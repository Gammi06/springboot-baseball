package site.metacoding.bb.web.dto;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.service.StadiumsService;
import site.metacoding.bb.web.dto.request.stadiums.SaveDto;
import site.metacoding.bb.web.dto.response.stadiums.ListDto;

@RequiredArgsConstructor
@RestController
public class StadiumsApiControllers {
	private final StadiumsService stadiumsService;

	@PostMapping("/api/stadiums/save")
	public String insert(SaveDto saveDto) {
		stadiumsService.insert(saveDto);
		return "경기장 추가 완료";
	}

	@GetMapping("/api/stadiums")
	public List<ListDto> findAll() {
		List<ListDto> stadiums = stadiumsService.findAll();
		return stadiums;
	}

	@GetMapping("/api/stadiums/{id}")
	public ListDto findById(@PathVariable Integer id) {
		ListDto stardium = stadiumsService.findById(id);
		return stardium;
	}

	@DeleteMapping("/api/stadiums/{id}")
	public String delete(@PathVariable Integer id) {
		stadiumsService.delete(id);
		return "경기장 삭제 완료";
	}
}

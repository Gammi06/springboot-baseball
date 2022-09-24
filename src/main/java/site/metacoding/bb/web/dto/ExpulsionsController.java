package site.metacoding.bb.web.dto;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.domain.expulsions.Expulsions;
import site.metacoding.bb.service.ExpulsionsService;
import site.metacoding.bb.web.dto.request.expulsions.UpdateDto;
import site.metacoding.bb.web.dto.response.expulsions.ListDto;

@RequiredArgsConstructor
@RestController
public class ExpulsionsController {
	private final ExpulsionsService expulsionsService;
	
	@GetMapping("/api/expulsions/{id}")
	public Expulsions findById(@PathVariable Integer id) {
		Expulsions expulsionsPS = expulsionsService.findById(id);
		return expulsionsPS;
	}
	
	@GetMapping("/api/expulsions")
	public List<ListDto> findAll(){
		List<ListDto> expulsions = expulsionsService.findAll();
		return expulsions;
	}
	
	@PutMapping("/api/expulsions/reasons/{id}")
	public String update(@PathVariable Integer id, UpdateDto updateDto) {
		expulsionsService.update(id, updateDto);
		return "퇴출 이유 수정 완료";
	}
}

package site.metacoding.bb.web.dto;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.service.StadiumsService;
import site.metacoding.bb.web.dto.response.CMRespDto;
import site.metacoding.bb.web.dto.response.stadiums.ListStadiumsDto;

@RequiredArgsConstructor
@Controller
public class StadiumsController {
	private final StadiumsService stadiumsService;
	
	@GetMapping({"/", "/stadiums"})
	public String findAll(Model model){
		List<ListStadiumsDto> stadiums = stadiumsService.findAll();
		model.addAttribute("stadiums", stadiums);
		return "stadiums/listform";
	}
	
	@GetMapping("/stadiums/writeform")
	public String writeform() {
		return "stadiums/writeform";
	}
	
	@DeleteMapping("/stadiums/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id){
		stadiumsService.delete(id);
		return new CMRespDto<>(1, "경기장 삭제 성공", null);
	}
}

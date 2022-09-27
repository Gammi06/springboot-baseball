package site.metacoding.bb.web.dto;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.service.StadiumsService;
import site.metacoding.bb.service.TeamsService;
import site.metacoding.bb.web.dto.request.teams.SaveDto;
import site.metacoding.bb.web.dto.response.CMRespDto;
import site.metacoding.bb.web.dto.response.stadiums.ListStadiumsDto;
import site.metacoding.bb.web.dto.response.teams.ListTeamsDto;

@RequiredArgsConstructor
@Controller
public class TeamsController {
	private final TeamsService teamsService;
	private final StadiumsService stadiumsService;
	
	@PostMapping("/teams/save")
	public @ResponseBody CMRespDto<?> save(@RequestBody SaveDto saveDto){
		teamsService.insert(saveDto);
		return new CMRespDto<>(1, "팀 등록 완료", null);
	}
	
	@GetMapping("/teams")
	public String findAll(Model model) {
		List<ListTeamsDto> teams = teamsService.findAll();
		model.addAttribute("teams", teams);
		return "teams/listform";
	}
	
	@GetMapping("/teams/writeform")
	public String saveform(Model model) {
		List<ListStadiumsDto> stadiums = stadiumsService.findAll();
		model.addAttribute("stadiums", stadiums);
		return "teams/writeform";
	}
}

package site.metacoding.bb.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.service.TeamsService;
import site.metacoding.bb.web.dto.request.teams.SaveDto;
import site.metacoding.bb.web.dto.response.teams.listDto;

@RequiredArgsConstructor
@RestController
public class TeamsApiControllers {

	private final TeamsService teamsService;

	@PostMapping("api/teams/save")
	public String insert(SaveDto saveDto) {
		teamsService.insert(saveDto);
		return "팀 추가 완료";
	}
	
	@GetMapping("/api/teams")
	public List<listDto> findAll(){
		List<listDto> teams = teamsService.findAll();
		return teams;
	}
	
	@GetMapping("/api/teams/{id}")
	public listDto findById(@PathVariable Integer id) {
		listDto teams = teamsService.findById(id);
		return teams;
	}
	
	@DeleteMapping("api/teams/{id}")
	public String delete(@PathVariable Integer id) {
		teamsService.delete(id);
		return "팀 삭제 완료";
	}
}

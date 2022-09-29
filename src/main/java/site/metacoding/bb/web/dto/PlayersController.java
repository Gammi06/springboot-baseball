package site.metacoding.bb.web.dto;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.service.PlayersService;
import site.metacoding.bb.service.PositionsService;
import site.metacoding.bb.service.TeamsService;
import site.metacoding.bb.web.dto.response.CMRespDto;
import site.metacoding.bb.web.dto.response.players.ListPlayersDto;
import site.metacoding.bb.web.dto.response.positions.ListPositionsDto;
import site.metacoding.bb.web.dto.response.teams.ListTeamsDto;

@RequiredArgsConstructor
@Controller
public class PlayersController {
	private final PlayersService playersService;
	private final TeamsService teamsService;

	@GetMapping("/players")
	public String findAll(Model model) {
		List<ListPlayersDto> players = playersService.findAll();
		model.addAttribute("players", players);
		return "players/listform";
	}

	@GetMapping("/players/positions")
	public String findByPosition(Model model, @PathVariable Integer id) {
		//List<ListPositionsDto> positions = positionsService.findAll();
		List<ListPlayersDto> players = playersService.findByPosition();

		//System.out.println(positions.get(0).getPositions());
		//System.out.println(players.get(0).getPlayersName());

		//model.addAttribute("positions", positions);
		model.addAttribute("players", players);
		return "players/positionlistform";
	}

	@GetMapping("/players/writeform")
	public String insert(Model model) {
		List<ListTeamsDto> teams = teamsService.findAll();
		model.addAttribute("teams", teams);
		return "players/writeform";
	}
	
	@DeleteMapping("/players/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id){
		playersService.delete(id);
		return new CMRespDto<>(1, "플레이어 삭제 성공", null);
	}
}

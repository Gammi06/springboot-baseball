package site.metacoding.bb.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.service.PlayersService;
import site.metacoding.bb.web.dto.request.players.SaveDto;
import site.metacoding.bb.web.dto.response.players.ListDto;

@RequiredArgsConstructor
@RestController
public class PlayerApiController {

	private final PlayersService playersService;
	
	@PostMapping("/api/players/save")
	public String insert(SaveDto saveDto) {
		playersService.insert(saveDto);
		return "선수 추가 완료";
	}
	
	@GetMapping("/api/players")
	public List<ListDto> findAll(){
		List<ListDto> players = playersService.findAll();
		return players;
	}
	
	@GetMapping("/api/players/{id}")
	public ListDto findById(@PathVariable Integer id) {
		ListDto player = playersService.findById(id);
		return player;
	}
	
	@DeleteMapping("/api/players/{id}")
	public String delete(@PathVariable Integer id) {
		playersService.delete(id);
		return "선수 삭제 완료";
	}
}

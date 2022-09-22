package site.metacoding.bb.domain.players;

import java.util.List;

import site.metacoding.bb.web.dto.response.players.PositionlistDto;
import site.metacoding.bb.web.dto.response.players.TeamlistDto;
import site.metacoding.bb.web.dto.response.players.ListDto;

public interface PlayersDao {
	public void insert(Players players);
	public List<ListDto> findAll();
	public List<TeamlistDto> findByTeam();
	public List<PositionlistDto> findByPosition();
	public ListDto findById(Integer id);
	public void update(Players players);
	public void delete(Integer id);
}

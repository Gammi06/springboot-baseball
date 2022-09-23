package site.metacoding.bb.domain.players;

import java.util.List;

import site.metacoding.bb.web.dto.response.players.ListDto;

public interface PlayersDao {
	public void insert(Players players);
	public List<ListDto> findAll();
	public List<ListDto> findByTeam();
	public List<ListDto> findByPosition();
	public ListDto findById(Integer id);
	public void update(Players players);
	public void delete(Integer id);
}

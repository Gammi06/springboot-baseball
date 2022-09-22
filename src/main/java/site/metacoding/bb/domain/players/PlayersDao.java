package site.metacoding.bb.domain.players;

import java.util.List;

import site.metacoding.bb.web.dto.response.players.listDto;

public interface PlayersDao {
	public void insert(Players players);
	public List<listDto> findAll();
	public listDto findById(Integer id);
	public void update(Players players);
	public void delete(Integer id);
}

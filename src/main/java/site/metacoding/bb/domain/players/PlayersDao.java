package site.metacoding.bb.domain.players;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import site.metacoding.bb.web.dto.response.players.ListPlayersDto;

public interface PlayersDao {
	public void insert(Players players);
	public List<ListPlayersDto> findAll();
	public Players findById(Integer id);
	public void update(Players players);
	public void delete(Integer id);
	public List<ListPlayersDto> findByPosition();
	//public List<Map<String, Object>> findByPosition(@Param("teamNameList") List<String> teamNameList);
}

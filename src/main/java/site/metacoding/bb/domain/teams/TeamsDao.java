package site.metacoding.bb.domain.teams;

import java.util.List;

import site.metacoding.bb.web.dto.response.teams.listDto;

public interface TeamsDao {
	public void insert(Teams teams);
	public List<listDto> findAll();
	public listDto findById(Integer id);
	public void update(Teams teams);
	public void delete(Integer id);
}

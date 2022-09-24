package site.metacoding.bb.domain.teams;

import java.util.List;

import site.metacoding.bb.web.dto.response.teams.ListDto;

public interface TeamsDao {
	public void insert(Teams teams);
	public List<ListDto> findAll();
	public Teams findById(Integer id);
	public Teams update(Teams teams);
	public void delete(Integer id);
}

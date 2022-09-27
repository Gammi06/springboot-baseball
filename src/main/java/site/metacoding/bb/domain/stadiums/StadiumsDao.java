package site.metacoding.bb.domain.stadiums;

import java.util.List;

import site.metacoding.bb.web.dto.response.stadiums.ListStadiumsDto;

public interface StadiumsDao {
	public void insert(Stadiums stadiums);
	public List<ListStadiumsDto> findAll();
	public Stadiums findById(Integer id);
	//public void update(Integer id, Stadiums stadiums);
	public void delete(Integer id);
}

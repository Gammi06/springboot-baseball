package site.metacoding.bb.domain.stadiums;

import java.util.List;

import site.metacoding.bb.web.dto.response.stadiums.ListDto;

public interface StadiumsDao {
	public void insert(Stadiums stadiums);
	public List<ListDto> findAll();
	public Stadiums findById(Integer id);
	//public void update(Integer id, Stadiums stadiums);
	public void delete(Integer id);
}

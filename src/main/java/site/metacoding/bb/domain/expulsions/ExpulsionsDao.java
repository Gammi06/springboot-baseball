package site.metacoding.bb.domain.expulsions;

import java.util.List;

import site.metacoding.bb.web.dto.request.expulsions.UpdateDto;
import site.metacoding.bb.web.dto.response.expulsions.ListDto;

public interface ExpulsionsDao {
	public void insert(Expulsions expulsions);
	public List<ListDto> findAll();
	public Expulsions findById(Integer id);
	public void update(Expulsions expulsions);
	public void delete(Integer id);
}

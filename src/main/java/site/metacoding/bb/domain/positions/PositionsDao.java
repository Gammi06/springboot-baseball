package site.metacoding.bb.domain.positions;

import java.util.List;

import site.metacoding.bb.web.dto.response.positions.ListPositionsDto;

public interface PositionsDao {
	public List<ListPositionsDto> findAll();
}

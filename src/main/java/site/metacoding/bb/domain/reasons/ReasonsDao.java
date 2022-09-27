package site.metacoding.bb.domain.reasons;

import java.util.List;

import site.metacoding.bb.web.dto.response.reasons.ListReasonsDto;

public interface ReasonsDao {
	public List<ListReasonsDto> findAll();
}

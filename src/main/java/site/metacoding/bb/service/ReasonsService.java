package site.metacoding.bb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.domain.reasons.ReasonsDao;
import site.metacoding.bb.web.dto.response.reasons.ListReasonsDto;

@RequiredArgsConstructor
@Service
public class ReasonsService {
	private final ReasonsDao reasonsDao;
	
	public List<ListReasonsDto> findAll() {
		return reasonsDao.findAll();
	}
}

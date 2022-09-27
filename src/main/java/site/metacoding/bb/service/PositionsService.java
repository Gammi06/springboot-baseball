package site.metacoding.bb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.domain.positions.PositionsDao;
import site.metacoding.bb.web.dto.response.positions.ListPositionsDto;

@RequiredArgsConstructor
@Service
public class PositionsService {
	private final PositionsDao positionsDao;
	
	public List<ListPositionsDto> findAll(){
		return positionsDao.findAll();
	}
}

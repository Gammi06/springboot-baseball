package site.metacoding.bb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.domain.stadiums.Stadiums;
import site.metacoding.bb.domain.stadiums.StadiumsDao;
import site.metacoding.bb.web.dto.request.stadiums.SaveDto;
import site.metacoding.bb.web.dto.response.stadiums.ListStadiumsDto;

@RequiredArgsConstructor
@Service
public class StadiumsService {
	private final StadiumsDao stadiumsDao;

	public void insert(SaveDto saveDto) {
		Stadiums stadiums = saveDto.toEntity();
		stadiumsDao.insert(stadiums);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void delete(Integer id) {
		if (stadiumsDao.findById(id) == null)
			return;
		stadiumsDao.delete(id);
	}

	public List<ListStadiumsDto> findAll() {
		return stadiumsDao.findAll();
	}

	public Stadiums findById(Integer id) {
		Stadiums stadiumsPS = stadiumsDao.findById(id);
		if (stadiumsPS == null) {
			return null;
		}
		return stadiumsPS;
	}
}

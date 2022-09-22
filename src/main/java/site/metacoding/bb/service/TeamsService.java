package site.metacoding.bb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.domain.teams.Teams;
import site.metacoding.bb.domain.teams.TeamsDao;
import site.metacoding.bb.web.dto.request.teams.SaveDto;
import site.metacoding.bb.web.dto.response.teams.ListDto;

@RequiredArgsConstructor
@Service
public class TeamsService {

	private final TeamsDao teamsDao;

	public void insert(SaveDto saveDto) {
		Teams teams = saveDto.toEntity();
		teamsDao.insert(teams);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void delete(Integer id) {
		if (teamsDao.findById(id) == null)
			return;
		teamsDao.delete(id);
	}

	public ListDto findById(Integer id) {
		ListDto listDto = teamsDao.findById(id);
		if (listDto == null) {
			return null;
		}
		return listDto;
	}

	public List<ListDto> findAll() {
		return teamsDao.findAll();
	}
}

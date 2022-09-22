package site.metacoding.bb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.domain.players.Players;
import site.metacoding.bb.domain.players.PlayersDao;
import site.metacoding.bb.web.dto.request.players.SaveDto;
import site.metacoding.bb.web.dto.response.players.listDto;

@RequiredArgsConstructor
@Service
public class PlayersService {
	private final PlayersDao playersDao;

	public void insert(SaveDto saveDto) {
		Players players = saveDto.toEntity();
		playersDao.insert(players);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void delete(Integer id) {
		if (playersDao.findById(id) == null)
			return;
		playersDao.delete(id);
	}

	public List<listDto> findAll() {
		return playersDao.findAll();
	}

	public listDto findById(Integer id) {
		listDto listDto = playersDao.findById(id);
		if (listDto == null)
			return null;

		return listDto;
	}

}

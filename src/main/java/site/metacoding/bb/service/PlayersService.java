package site.metacoding.bb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.domain.expulsions.Expulsions;
import site.metacoding.bb.domain.expulsions.ExpulsionsDao;
import site.metacoding.bb.domain.players.Players;
import site.metacoding.bb.domain.players.PlayersDao;
import site.metacoding.bb.domain.positions.Positions;
import site.metacoding.bb.domain.positions.PositionsDao;
import site.metacoding.bb.domain.teams.Teams;
import site.metacoding.bb.domain.teams.TeamsDao;
import site.metacoding.bb.web.dto.request.players.SaveDto;
import site.metacoding.bb.web.dto.response.players.ListPlayersDto;
import site.metacoding.bb.web.dto.response.positions.ListPositionsDto;
import site.metacoding.bb.web.dto.response.teams.ListTeamsDto;

@RequiredArgsConstructor
@Service
public class PlayersService {
	private final PlayersDao playersDao;
	private final ExpulsionsDao expulsionsDao;
	private final TeamsDao teamsDao;
	private final PositionsDao positionsDao;

	public void insert(SaveDto saveDto) {
		Players players = saveDto.toEntity();
		playersDao.insert(players);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void delete(Integer id) {
		Players playersPS = playersDao.findById(id);
		if (playersPS == null)
			return;

		// 2. 퇴출선수 추가하기
		Expulsions expulsionsPS = new Expulsions(playersPS);
		expulsionsDao.insert(expulsionsPS);

		// 3. 선수 삭제하기
		playersDao.delete(id);
	}

	public List<ListPlayersDto> findAll() {
		return playersDao.findAll();
	}

	public List<ListPlayersDto> findByPosition(){
		return playersDao.findByPosition();
	}

	public Players findById(Integer id) {
		Players playersPS = playersDao.findById(id);
		return playersPS;
	}
}

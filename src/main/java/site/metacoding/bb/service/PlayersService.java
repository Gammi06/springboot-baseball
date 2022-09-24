package site.metacoding.bb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.domain.expulsions.Expulsions;
import site.metacoding.bb.domain.expulsions.ExpulsionsDao;
import site.metacoding.bb.domain.players.Players;
import site.metacoding.bb.domain.players.PlayersDao;
import site.metacoding.bb.web.dto.request.players.SaveDto;
import site.metacoding.bb.web.dto.response.players.ListDto;

@RequiredArgsConstructor
@Service
public class PlayersService {
	private final PlayersDao playersDao;
	private final ExpulsionsDao expulsionsDao;
	
	public void insert(SaveDto saveDto) {
		Players players = saveDto.toEntity();
		playersDao.insert(players);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public void delete(Integer id) {
		Players playersPS = playersDao.findById(id);
		if (playersPS == null)
			return;
		
		//2. 퇴출선수 추가하기
		Expulsions expulsionsPS = new Expulsions(playersPS);		
		expulsionsDao.insert(expulsionsPS);
		
		//3. 선수 삭제하기
		playersDao.delete(id);
	}

	public List<ListDto> findAll() {
		return playersDao.findAll();
	}

	public List<ListDto> findByTeam(){
		return playersDao.findByTeam();
	}

	public List<ListDto> findByPosition(){
		return playersDao.findByPosition();
	}

	public Players findById(Integer id) {
		Players playersPS = playersDao.findById(id);
		return playersPS;
	}
}

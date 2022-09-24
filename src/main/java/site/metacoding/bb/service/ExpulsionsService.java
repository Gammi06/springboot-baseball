package site.metacoding.bb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.bb.domain.expulsions.Expulsions;
import site.metacoding.bb.domain.expulsions.ExpulsionsDao;
import site.metacoding.bb.web.dto.request.expulsions.SaveDto;
import site.metacoding.bb.web.dto.request.expulsions.UpdateDto;
import site.metacoding.bb.web.dto.response.expulsions.ListDto;

@RequiredArgsConstructor
@Service
public class ExpulsionsService {
	private final ExpulsionsDao expulsionsDao;
	
	public void insert(SaveDto saveDto) {
		Expulsions expulsions = saveDto.toEntity();
		expulsionsDao.insert(expulsions);
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void delete(Integer id) {
		if(expulsionsDao.findById(id) == null) {
			return;
		}
		expulsionsDao.delete(id);
	}
	
	public void update(Integer id, UpdateDto updateDto) {
		Expulsions expulsionsPS = expulsionsDao.findById(id);
		if(expulsionsPS == null) {
			return;
		}
		
		expulsionsPS.update(updateDto);
		
		expulsionsDao.update(expulsionsPS);
	}
	
	public List<ListDto> findAll(){
		return expulsionsDao.findAll();
	}
	
	public Expulsions findById(Integer id) {
		Expulsions expulsionsPS = expulsionsDao.findById(id);
		if(expulsionsPS == null)
			return null;
		
		return expulsionsPS;
	}
}

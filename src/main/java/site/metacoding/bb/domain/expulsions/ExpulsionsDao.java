package site.metacoding.bb.domain.expulsions;

import java.util.List;

public interface ExpulsionsDao {
	public void insert(Expulsions outers);
	public List<Expulsions> findAll();
	public void findById(Integer id);
	public void update(Expulsions outers);
	public void delete(Integer id);
}

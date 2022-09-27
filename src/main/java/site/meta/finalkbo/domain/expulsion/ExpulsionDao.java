package site.meta.finalkbo.domain.expulsion;

import java.util.List;

public interface ExpulsionDao {
    public void insert(Expulsion expulsion);
    public List<Expulsion> findAll();
    public Expulsion findByPlayerId(Integer playerId);
    public void deleteById(Integer id);
    public void update();
}

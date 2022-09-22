package site.meta.finalkbo.domain.player;

public interface PlayerDao {
    public void insert();
    public void findAll();
    public void findById(Integer id);
    public void deleteById(Integer id);
    public void update();
}

package site.meta.finalkbo.domain.team;


import java.util.List;

public interface TeamDao {
    public void insert(Team team);
    public List<Team> findAllView();
    public Team findById(Integer id);
    public void deleteById(Integer id);
    public void update(Integer id, Team team);
}

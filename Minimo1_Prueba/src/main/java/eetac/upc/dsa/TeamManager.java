package eetac.upc.dsa;

import eetac.upc.dsa.models.Team;

import java.util.List;
public interface TeamManager {
    public Team addTeam(String members, int team_life, int num_members);
    public Team addTeam(Team team);
    public Team getTeam(int id);
    public List<Team> findAll();
    public void DeleteTeam(int id);
    public Team UpdateTeam(Team team);

    public int size();
}

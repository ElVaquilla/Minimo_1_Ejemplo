package eetac.upc.dsa;

import eetac.upc.dsa.models.Game;
import eetac.upc.dsa.models.Team;
import eetac.upc.dsa.models.User;

import java.util.List;

public interface GameManager {

    // User manager
    public User addUser(String nombre, String apellido);
    public User addUser(User user);
    public User getUser(int id);
    public void deleteUser(int id);
    public User updateUser(User user);

    // Team manager
    public Team addTeam(String members, int team_life, int num_members);
    public Team addTeam(Team team);
    public Team getTeam(int id);
    public void DeleteTeam(int id);
    public Team UpdateTeam(Team team);

    // Game manager
    public Game addGame(int state_of_game);
    public Game addGame(Game game);
    public Game getGame(int id);
    public List<Game> findAll();
    public void deleteGame(int id);
    public Game updateGame(Game game);

    public int size();
}

package eetac.upc.dsa;

import eetac.upc.dsa.models.Game;
import eetac.upc.dsa.models.Team;
import eetac.upc.dsa.models.User;
import eetac.upc.dsa.models.Product;

import java.util.List;

public interface GameManager {

    // User manager
    public User addUser(String nombre, String apellido, String s);
    public User addUser(User user);
    public User getUser(int id);
    public List <User> findAllUsers();
    public void deleteUser(int id);
    public User updateUser(User user);

    // Team manager
    public Team addTeam(String members, int team_life, int num_members);
    public Team addTeam(Team team);
    public Team getTeam(int id);
    public List<Team> findAllTeams();
    public void deleteTeam(int id);
    public Team updateTeam(Team team);

    // Game manager
    public Game addGame(int state_of_game);
    public Game addGame(Game game);
    public Game getGame(int id);
    public List<Game> findAllGames();
    public void deleteGame(int id);
    public Game updateGame(Game game);

    // Product manager
    public Product addProduct(String name, int price, String description, int effect_life, boolean type);
    public Product addProduct(Product product);
    public Product getProduct(int id);
    public List<Product> findAllProducts();
    public void deleteProduct(int id);
    public Product updateProduct(Product product);

    public int GameSize();
    public int TeamSize();
    public int UserSize();
    public int ProductSize();

}
package eetac.upc.dsa;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

import eetac.upc.dsa.models.User;
import eetac.upc.dsa.models.Team;
import eetac.upc.dsa.models.Product;
import eetac.upc.dsa.models.Game;

public class GameManagerImpl implements GameManager {
    private static GameManager instance;
    protected List<Game> Games;
    protected List<User> Users;
    protected List<Team> Teams;
    protected List<Product> Products;
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);
    private GameManagerImpl() {
        this.Games = new LinkedList<>();
        this.Users = new LinkedList<>();
        this.Teams = new LinkedList<>();
        this.Products = new LinkedList<>();
    }

    public static GameManager getInstance() {
        if (instance==null)
            instance = new GameManagerImpl();
        return instance;
    }

    public int GameSize() {
        int ret = this.Games.size();
        logger.info("Game size " + ret);

        return ret;
    }

    public int TeamSize() {
        int ret = this.Teams.size();
        logger.info("Team size " + ret);

        return ret;
    }
    public int UserSize() {
        int ret = this.Users.size();
        logger.info("User size " + ret);

        return ret;
    }
    public int ProductSize() {
        int ret = this.Products.size();
        logger.info("Product size " + ret);

        return ret;
    }
    public Game addGame(Game g) {
        logger.info("new Game " + g);

        this.Games.add (g);
        logger.info("new Game added");
        return g;
    }
    public Game addGame(int state_of_game) { return this.addGame(new Game(state_of_game)); }
    public User addUser(User u) {
        logger.info("new User " + u);

        this.Users.add (u);
        logger.info("new User added");
        return u;
    }
    public User addUser(String name, String last_name, String user_name) { return this.addUser(new User(name, last_name, user_name)); }
    public Team addTeam(Team t) {
        logger.info("new Team " + t);

        this.Teams.add (t);
        logger.info("new Team added");
        return t;
    }
    public Team addTeam(String members, int team_life, int num_members) { return this.addTeam(new Team(members, team_life, num_members)); }
    public Product addProduct(Product p) {
        logger.info("new Product " + p);

        this.Products.add (p);
        logger.info("new Products added");
        return p;
    }
    public Product addProduct(String name, int price, String description, int effect_life, boolean type) { return this.addProduct(new Product(name, price, description, effect_life, type)); }

    public Game getGame(int id) {
        logger.info("getGame("+id+")");

        for (Game g: this.Games) {
            if (g.GetGameId() == id) {
                logger.info("getGame("+id+"): "+g);

                return g;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public Team getTeam(int id) {
        logger.info("getTeam("+id+")");

        for (Team t: this.Teams) {
            if (t.GetTeamId() == id) {
                logger.info("getTeam("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }
    public User getUser(int id) {
        logger.info("getUser("+id+")");

        for (User u: this.Users) {
            if (u.GetUserId() == id) {
                logger.info("getUser("+id+"): "+u);

                return u;
            }
        }

        logger.warn("not found " + id);
        return null;
    }
    public Product getProduct(int id) {
        logger.info("getProduct("+id+")");

        for (Product p: this.Products) {
            if (p.GetProductId() == id) {
                logger.info("getProduct("+id+"): "+p);

                return p;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Game> findAllGames() {
        return this.Games;
    }
    public List<Team> findAllTeams() {
        return this.Teams;
    }
    public List<User> findAllUsers() {
        return this.Users;
    }
    public List<Product> findAllProducts() {
        return this.Products;
    }

    @Override
    public void deleteGame(int id) {
        Game g = this.getGame(id);
        if (g==null) {
            logger.warn("not found " + g);
        }
        else logger.info(g+" deleted ");

        this.Games.remove(g);
    }

    @Override
    public Game updateGame(Game game) {
        Game g = this.getGame(game.GetGameId());

        if (g!=null) {
            logger.info(game+" rebut!!!! ");

            g.SetState(game.GetState());

            logger.info(g+" updated ");
        }
        else {
            logger.warn("not found "+game);
        }
        return g;
    }



    @Override
    public void deleteTeam(int id) {
        Team t = this.getTeam(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.Teams.remove(t);
    }

    @Override
    public Team updateTeam(Team team) {
        Team t = this.getTeam(team.GetTeamId());

        if (t!=null) {
            logger.info(team+" rebut!!!! ");

            t.SetMembers(team.GetMembers());
            t.SetNum(team.GetNum());
            t.SetTeamLife(team.GetTeamLife());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+team);
        }
        return t;
    }



    @Override
    public void deleteUser(int id) {
        User u = this.getUser(id);
        if (u==null) {
            logger.warn("not found " + u);
        }
        else logger.info(u+" deleted ");

        this.Users.remove(u);
    }

    @Override
    public User updateUser(User usr) {
        User u = this.getUser(usr.GetUserId());

        if (u!=null) {
            logger.info(usr+" rebut!!!! ");

            u.SetName(usr.GetName());
            u.SetLastName(usr.GetLastName());
            u.SetUserName(usr.GetUserName());
            u.SetDSACoins(usr.GetDSACoins());
            u.SetLife(usr.GetLife());
            u.SetArmor(usr.GetArmor());

            logger.info(u+" updated ");
        }
        else {
            logger.warn("not found "+usr);
        }
        return u;
    }



    @Override
    public void deleteProduct(int id) {
        Product p = this.getProduct(id);
        if (p==null) {
            logger.warn("not found " + p);
        }
        else logger.info(p+" deleted ");

        this.Products.remove(p);
    }

    @Override
    public Product updateProduct(Product product) {
        Product p = this.getProduct(product.GetProductId());

        if (p!=null) {
            logger.info(product+" rebut!!!! ");

            p.SetName(product.GetName());
            p.SetDescription(product.GetDescription());
            p.SetPrice(product.GetPrice());
            p.SetType(product.GetType());
            p.SetEffect(product.GetEffect());

            logger.info(p+" updated ");
        }
        else {
            logger.warn("not found "+product);
        }
        return p;
    }
}

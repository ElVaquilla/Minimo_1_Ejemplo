package eetac.upc.dsa.models;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    int id;
    static AtomicInteger nextId = new AtomicInteger();
    String username;
    int points;   // Puntos en partida
    int level;  // Nivel del jugador
    boolean partida;    // Indica si el usuario está en una partida, SOLO UNA PARTIDA A LA VEZ
    String date;        // Fecha de la ultima subida de nivel
    int gameId;

    // Constructores
    public User(String username){
        this();
        this.username = username;
        this.points = 0;
        this.level = 0;
        this.partida = false;
        this.date = date;
        this.id = nextId.incrementAndGet();
    }

    public User(){this.id = nextId.incrementAndGet();}

    // Setters y Getters
    public int  GetUserId(){return this.id;}
    public String GetUserName(){return this.username;}
    public void SetUserName(String username){this.username = username;}
    public int GetLevel(){return this.level;}
    public void SetLevel(int level){this.level = level;}
    public int GetPoints(){return this.points;}
    public void SetPoints(int points){this.points = this.points + points;}
    public boolean GetPartida(){return this.partida;}
    public void SetPartida(boolean partida){this.partida = partida;}
    public void SetDate(String date){this.date = date;}
    public String GetDate(){return this.date;}
    public int GetGameId(){return this.gameId;}
    public void SetGameId(int id){this.gameId = id;}
}
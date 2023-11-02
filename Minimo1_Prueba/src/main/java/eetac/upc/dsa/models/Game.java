package eetac.upc.dsa.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    int id;
    AtomicInteger nextID = new AtomicInteger();
    int state_of_game;  // 0 No iniciado
                        // 1 Iniciado en preparación
                        // 2 Iniciado en funcionamiento
                        // 3 Finalizado

    // Constructores
    public Game(){this.id = nextID.incrementAndGet();}
    public Game(int state_of_game){
        this();
        this.id = nextID.incrementAndGet();
        this.state_of_game = state_of_game;
    }

    // Setters y Getters

    public int GetGameId(){return this.id;}
    public int GetState(){return this.state_of_game;}
    public void SetState(int state_of_game){this.state_of_game = state_of_game;}
}

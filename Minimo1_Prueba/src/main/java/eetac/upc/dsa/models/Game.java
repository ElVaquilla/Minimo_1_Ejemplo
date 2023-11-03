package eetac.upc.dsa.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    int id;
    AtomicInteger nextID = new AtomicInteger();
    String description;
    int levels;

    // Constructores
    public Game(){this.id = nextID.incrementAndGet();}
    public Game(String description, int levels){
        this();
        this.id = nextID.incrementAndGet();
        this.description = description;
        this.levels = levels;
    }

    // Setters y Getters

    public int GetGameId(){return this.id;}
    public String GetDescription(){return this.description;}
    public void SetDescription(String description){this.description = description;}
    public int GetLevels(){return this.levels;}
    public void SetLevels(int levels){this.levels = levels;}
}
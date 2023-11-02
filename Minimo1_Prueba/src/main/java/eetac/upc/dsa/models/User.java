package eetac.upc.dsa.models;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    int id;
    static AtomicInteger nextId = new AtomicInteger();
    String name;
    String last_name;
    int dsa_coins;
    int life;   // 1000 es el máximo de vida
    int armor;  // 1000 valor máximo
                // Al inicio siempre es 0

    // Constructores
    public User(String name, String last_name){
        this();
        this.name = name;
        this.last_name = last_name;
        this.dsa_coins = 25;
        this.life = 1000;
        this.armor = 0;
        this.id = nextId.incrementAndGet();
    }

    public User(){this.id = nextId.incrementAndGet();}

    // Setters y Getters
    public int  GetId(){return this.id;}
    public String GetName(){return this.name;}
    public void SetName(String name){this.name = name;}
    public String GetLastName(){return this.last_name;}
    public void SetLastName(String last_name){this.last_name = last_name;}
    public int GetDSACoins(){return this.dsa_coins;}
    public void SetDSACoins(int dsa_coins){this.dsa_coins = dsa_coins;}
    public int GetLife(){return this.life;}
    public void SetLife(int life){this.life = life;}
    public int GetArmor(){return this.armor;}
    public void SetArmor(int armor){this.armor = armor;}


}

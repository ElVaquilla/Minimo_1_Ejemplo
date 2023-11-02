package eetac.upc.dsa.models;

import java.util.concurrent.atomic.AtomicInteger;
public class Product {
    int id;
    AtomicInteger nextId = new AtomicInteger();

    String name;
    int price;
    String description;
    int effect_life;
    boolean type;   // Loa objetos puden ser de dos tipos, ajenos e internos
                    // Si son ajenos (False) el efecto de vida se aplicará al otro jugador Ej.: Armas, conjuros, etc
                    // Si son internos (True) al jugador que posea el objeto Ej.: Pociones, armaduras, cosméticos, etc

    // Constructores
    public Product(){this.id = nextId.incrementAndGet();}
    public Product(String name, int price, String despiption, int effect_life, boolean type){
        this();
        this.id = nextId.incrementAndGet();
        this.price = price;
        this.name = name;
        this.description = description;
        this.effect_life = effect_life;
        this.type = type;
    }

    // Setters y Getters

    public int GetProductId(){return this.id;}
    public String GetName(){return this.name;}
    public void SetName(String name){this.name = name;}
    public String GetDescription(){return this.description;}
    public void SetDescription(String description){this.description = description;}
    public int GetPrice(){return this.price;}
    public void SetPrice(int price){this.price = price;}
    public int GetEffect(){return this.effect_life;}
    public void SetEffect(int effect_life){this.effect_life = effect_life;}
    public boolean GetType(){return this.type;}
    public void SetType(boolean type){this.type = type;}
}
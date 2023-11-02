package eetac.upc.dsa.models;

import java.util.concurrent.atomic.AtomicInteger;
public class Team {
    int id;
    AtomicInteger nextId = new AtomicInteger();
    String members;
    int num_members;
    int team_life;  //Life of all users

    // Constructores
    public Team(){this.id = nextId.incrementAndGet();}
    public Team(String members, int team_life, int num_members){
        this();
        this.members = members;
        this.team_life = team_life;
        this.num_members = num_members;
    }

    // Setters y Getters
    public int GetTeamId(){return this.id;}
    public String GetMembers(){return this.members;}
    public void SetMembers(String members){this.members = members;}
    public int GetNum(){return this.num_members;}
    public void SetNum(int num_members){this.num_members = num_members;}
    public int GetTeamLife(){return this.team_life;}
    public void SetTeamLife(int team_life){this.team_life = team_life;}
}
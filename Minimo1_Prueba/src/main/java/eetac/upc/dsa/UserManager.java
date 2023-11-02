package eetac.upc.dsa;

import eetac.upc.dsa.models.User;

import java.util.List;

public interface UserManager {
    public User addUser(String nombre, String apellido);
    public User addUser(User user);
    public User getUser(int id);
    public List<User> findAll();
    public void deleteUser(int id);
    public User updateUser(User user);

    public int size();
}

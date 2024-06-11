package services;

import model.User;
import repositories.UsersRepo;

import java.util.List;

public class UserService{
    private static UserService userService;

    private UserService() {
    }

    public static synchronized UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public boolean checkUsername(String username) {
        List<User> users = usersRepo.getAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private final UsersRepo usersRepo = UsersRepo.getUsersRepo();


    public boolean add(User user) {
       return usersRepo.add(user);
    }


    public List<User> getAll() {
        return usersRepo.getAll();
    }

    public boolean remove(String username) {
        return usersRepo.remove(username);
    }
}

package services.impl;

import model.User;
import repositories.impl.UsersRepo;
import services.IUserService;

import java.util.List;

public class UserService implements IUserService {
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

    UsersRepo usersRepo = UsersRepo.getUsersRepo();

    @Override
    public boolean add(User user) {
       return usersRepo.add(user);
    }

    @Override
    public List<User> getAll() {
        return usersRepo.getAll();
    }

    public boolean remove(String username) {
        return usersRepo.remove(username);
    }
}

package repositories;

import model.User;
import views.LibraryView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {

    private static UserRepo userRepo;

    private UserRepo() {
    }

    public static synchronized UserRepo getLibraryView() {
        if (userRepo == null) {
            userRepo = new UserRepo();
        }
        return userRepo;
    }


    LibraryView view = LibraryView.getLibraryView();

    public void addUser(User user) {
        List<User> users = getUser();
        users.add(user);
        try (
                FileOutputStream fos = new FileOutputStream("src/data/user.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(users);
            view.viewRegisterMessage(true);
        } catch (IOException e) {
            view.viewRegisterMessage(false);
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("src/data/user.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            users = (List<User>) ois.readObject();
        } catch (EOFException ignored) {
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Error reading user data!!!");
        }
        return users;
    }
}


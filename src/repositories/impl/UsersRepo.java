package repositories.impl;

import model.User;
import views.LibraryView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepo {

    private static UsersRepo usersRepo;

    private UsersRepo() {
    }

    public static synchronized UsersRepo getUsersRepo() {
        if (usersRepo == null) {
            usersRepo = new UsersRepo();
        }
        return usersRepo;
    }


    LibraryView view = LibraryView.getLibraryView();

    public boolean add(User user) {
        if (!usersRepo.checkUsername(user.getUsername())) {
            List<User> users = getAll();
            users.add(user);
            writeFile(users);
            return true;
        }
        System.out.println("\nTên đăng nhập đã tồn tại!");
        return false;
    }

    private void writeFile(List<User> users) {
        try (
                FileOutputStream fos = new FileOutputStream("src/data/users.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.err.println("Lỗi ghi file!!!");
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("src/data/users.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            users = (List<User>) ois.readObject();
        } catch (EOFException ignored) {
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Lỗi đọc file!!!");
        }
        return users;
    }

    public boolean remove(String username) {
        List<User> users = getAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                writeFile(users);
                return true;
            }
        }
        return false;
    }

    public boolean checkUsername(String username) {
        List<User> users = getAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}


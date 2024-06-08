package controller;

import model.User;
import repositories.UserRepo;
import services.Service;
import views.LibraryView;

import java.util.List;

public class LibraryController {
    UserRepo userRepo = UserRepo.getLibraryView();
    LibraryView view = LibraryView.getLibraryView();
    Service service = Service.getService();
    User user;

    private static LibraryController libraryController;

    private LibraryController() {
    }

    public static synchronized LibraryController getLibraryController() {
        if (libraryController == null) {
            libraryController = new LibraryController();
        }
        return libraryController;
    }

    List<User> users;
    String[] data;
    boolean result;

    public void start() {
        while (true) {
            int choice = view.mainStatusView();
            switch (choice) {
                case 1:
                    data = view.loginView();
                    result = service.checkLoginAdmin(data);
                    if (result) {
                        view.viewLoginMessage(true);
                        handleAdmin();
                    } else {
                        view.viewLoginMessage(false);
                    }
                    break;
                case 2:
                    handleUserLogin();

                    break;
                case 0:
                    return;
            }
        }
    }

    private void handleUserLogin() {
        int choice = view.userLoginView();
        switch (choice) {
            case 1:
                data = view.loginView();
                users = userRepo.getUser();
                result = service.checkLoginUser(users, data);
                if (result) {
                    view.viewLoginMessage(true);
                    handleUser();
                } else {
                    view.viewLoginMessage(false);
                }
                break;
            case 2:
                user = view.registerView();
                userRepo.addUser(user);
                break;
            case 0:
                return;
        }
    }

    private void handleAdmin() {
        while (true) {
            int choice = view.adminStatusView();
            switch (choice) {
                case 1:
                    // Logic thêm sách
                    break;
                case 2:
                    // Logic xem sách hiện tại
                    break;
                case 3:
                    break;
                case 4:
                    // Logic chỉnh sửa sách
                    break;
                case 5:
                    // Logic xóa sách
                    break;
                case 6:
                    List<User> users = userRepo.getUser();
                    for (User user : users) {
                        System.out.println(user);
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    private void handleUser() {
        while (true) {
            int choice = view.userStatusView();
            switch (choice) {
                case 1:
                    // Logic xem sách hiện tại
                    break;
                case 2:
                    // Logic thuê sách
                    break;
                case 3:
                    // Logic trả sách
                    break;
                case 0:
                    return;
            }
        }
    }
}

package services;

import model.User;

import java.util.List;

public class Service {
    private static Service service;

    private Service() {
    }

    public static synchronized Service getService() {
        if (service == null) {
            service = new Service();
        }
        return service;
    }

    public boolean checkLoginAdmin(String[] admin) {
        return admin[0].equals("ADMIN") && admin[1].equals("666666");
    }

    public boolean checkLoginUser(List<User> users, String[] accountLogin) {
        for (User user : users) {
            if (user.getUsername().equals(accountLogin[0]) && user.getPassword().equals(accountLogin[1])) {
                return true;
            }
        }
        return false;
    }
}

package controller;

public class MainController {
    public static void main(String[] args) {
        LibraryController controller = LibraryController.getLibraryController();
        controller.start();
    }
}

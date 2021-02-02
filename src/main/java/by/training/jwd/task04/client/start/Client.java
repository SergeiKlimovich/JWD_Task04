package by.training.jwd.task04.client.start;

import by.training.jwd.task04.client.controller.ClientController;

public class Client {

    private final static String HOST = "localhost";
    private final static int PORT = 3575;

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        clientController.start(HOST, PORT);
    }
}
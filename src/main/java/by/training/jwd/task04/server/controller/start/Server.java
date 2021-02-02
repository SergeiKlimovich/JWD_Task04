package by.training.jwd.task04.server.controller.start;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.Logger;

import by.training.jwd.task04.server.controller.ServerController;
import by.training.jwd.task04.server.service.exception.ServiceException;

public class Server {

	private static final int PORT = 3575;
	 private final static Logger logger = Logger.getLogger(Server.class);
	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(PORT);
			logger.info("Server started");
			while (true) {
				Socket clientSocket = serverSocket.accept();
				 logger.info("Connection established");
				ServerController serverController = new ServerController();
				serverController.start(clientSocket);
				clientSocket.close();
				 logger.info("ClientSocket is closed");
			}
		} catch (ServiceException | IOException e) {
			 logger.error(e);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				 logger.error(e);
			}
		}
		logger.info("Server is closed");
	}
}

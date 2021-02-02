package by.training.jwd.task04.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import by.training.jwd.task04.client.model.ReaderFromFile;
import by.training.jwd.task04.client.model.exception.DAOException;
import by.training.jwd.task04.client.view.ClientViewer;
import by.training.jwd.task04.entity.impl.Text;

public class ClientController {
	private final static Logger logger = Logger.getLogger(ClientController.class);
	private static final int WAITING_TIME = 500;
	private static final String TYPE_ENDING = "\n--end--\n";

	private final BufferedReader consoleReader;
	private final ClientViewer clientViewer;
	private final ReaderFromFile readerFromFile;

	private Text desiredText;

	private Socket clientSocket;
	private ObjectInputStream objectIn;
	private OutputStream out;

	public ClientController() {
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		clientViewer = new ClientViewer();
		readerFromFile = new ReaderFromFile();
	}

	public void start(final String HOST, final int PORT) {
		try {
			try {
				clientSocket = new Socket(HOST, PORT);
				logger.info("Client started");
				objectIn = new ObjectInputStream(clientSocket.getInputStream());
				out = clientSocket.getOutputStream();

				clientViewer.printWelcomeMessage(objectIn);
				logger.info("Welcome message is printed");
				sendRequest();
				logger.info("Request is sent");
				deserializeText();
				logger.info("Modified text is deserialized");
				clientViewer.printFormattedText(desiredText);
				logger.info("Modified text is printed");
			} finally {
				clientSocket.close();
				logger.info("Client is closed");
			}
		} catch (IOException | DAOException | ClassNotFoundException e) {
			logger.error(e);
		}
	}

	private void sendRequest() throws IOException, DAOException {
		String typeOfEdit = consoleReader.readLine() + "\n";
		String allText = readerFromFile.readAllText();

		String request = typeOfEdit + allText + TYPE_ENDING;

		out.write(request.getBytes());
		out.flush();
	}

	private void deserializeText() throws IOException, ClassNotFoundException {

		try {
			Thread.sleep(WAITING_TIME);
		} catch (InterruptedException e) {
			logger.error(e);
		}
		logger.info("Deserialize started");
		desiredText = (Text) objectIn.readObject();
		logger.info("Deserialize completed");
	}
}

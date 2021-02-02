package by.training.jwd.task04.server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import by.training.jwd.task04.entity.impl.Text;
import by.training.jwd.task04.server.service.TextService;
import by.training.jwd.task04.server.service.exception.ServiceException;
import by.training.jwd.task04.server.service.impl.TextServiceImpl;

public class ServerController {
	private final static Logger logger = Logger.getLogger(ServerController.class);
	private static final String TYPE_ENDING = "--end--";

	private TextService textService;

	private BufferedReader requestReader;
	private ObjectOutputStream objectOut;

	public ServerController() throws ServiceException {
		textService = new TextServiceImpl();
	}

	public void start(final Socket clientSocket) {
		try {
			requestReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			objectOut = new ObjectOutputStream(clientSocket.getOutputStream());

			sendWelcomeMessage(objectOut);

			String editNumber = readEditNumber();

			String textData = readTextData();

			Text text = textService.createText(textData);

			Text modifiedText = modifyText(text, editNumber);

			if (modifiedText != null) {

				objectOut.writeObject(modifiedText);

			} else {

				sendErrorMessage();
			}
		} catch (IOException e) {
			 logger.error(e);
		}
	}

	private void sendWelcomeMessage(ObjectOutputStream objectOut) throws IOException {
		StringBuilder welcomeMessage = new StringBuilder().append("You can do one of this edit\n")
				.append("Enter 1, if you want to form sentences in ascending order\n")
				.append("Enter 2, if you want to form sentences with the replacement\n")
				.append("of the first and last words in places\n").append("Enter your choice:\n").append("--end--\n");

		objectOut.write(welcomeMessage.toString().getBytes());
		objectOut.flush();
	}

	private void sendErrorMessage() throws IOException {
		objectOut.write("You entered invalid edit code".getBytes());
	}

	private String readEditNumber() throws IOException {
		return requestReader.readLine();
	}

	private String readTextData() throws IOException {

		StringBuilder buff = new StringBuilder();
		String line;
		while (true) {
			line = requestReader.readLine();
			if (line.contains(TYPE_ENDING)) {
				break;
			}
			buff.append(line).append("\n");
		}
		return buff.toString();
	}

	private Text modifyText(Text text, String editNumber) {
		if (editNumber.equals("1")) {
			return textService.formSentencesAscending(text);
		} else if (editNumber.equals("2")) {
			return textService.formSentenceOppositeReplacementFirstLastWords(text);
		} else {
			return null;
		}
	}
}
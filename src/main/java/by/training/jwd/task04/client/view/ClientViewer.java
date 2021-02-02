package by.training.jwd.task04.client.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

import by.training.jwd.task04.entity.Component;
import by.training.jwd.task04.entity.impl.Text;

public class ClientViewer {

    private static final String TYPE_ENDING = "--end--";

    public void printWelcomeMessage(ObjectInputStream objectIn) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(objectIn), 1);
        String line;
        while (true) {
            line = reader.readLine();
            if (line.contains(TYPE_ENDING)) {
                break;
            }
            printMessage(line);
        }
    }

    public void printFormattedText(Text text) {
        List<Component> components = text.getText();
        StringBuilder buff = new StringBuilder();

        buff.append("_____________________________________________________________\n");
        for (Component c : components) {
            buff.append(c.getContent()).append("\n");
        }
        buff.append("_____________________________________________________________\n");

        System.out.println(buff.toString());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}

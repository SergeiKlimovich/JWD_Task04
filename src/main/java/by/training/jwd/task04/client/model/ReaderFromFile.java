package by.training.jwd.task04.client.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import by.training.jwd.task04.client.model.exception.DAOException;

public class ReaderFromFile {

    private final Path filePath = Paths.get("resources/file.txt");

    public String readAllText() throws DAOException {
        StringBuilder textBuffer = new StringBuilder();

        try (BufferedReader fileReader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                textBuffer.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }

        return textBuffer.toString();
    }
}

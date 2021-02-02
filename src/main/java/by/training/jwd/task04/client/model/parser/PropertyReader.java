package by.training.jwd.task04.client.model.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import by.training.jwd.task04.client.model.exception.DAOException;

public class PropertyReader {

    private static PropertyReader instance = new PropertyReader();
    private Properties properties = new Properties();

    private PropertyReader() {}

    public static PropertyReader getInstance() {
        return instance;
    }

    public String getProperty(String propertyName) throws DAOException {
        String property;
        try {
            FileInputStream inputStream = new FileInputStream("resources/regexp.properties");
            properties.load(inputStream);
            property = properties.getProperty(propertyName);
        } catch (IOException e) {
            throw new DAOException("Ошибка regexp.properties", e);
        }

        return property;
    }
}

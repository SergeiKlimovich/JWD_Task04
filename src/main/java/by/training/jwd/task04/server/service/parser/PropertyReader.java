package by.training.jwd.task04.server.service.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import by.training.jwd.task04.server.service.exception.ServiceException;

public class PropertyReader {

    private static PropertyReader instance = new PropertyReader();
    private Properties properties = new Properties();

    private PropertyReader() {}

    public static PropertyReader getInstance() {
        return instance;
    }

    public String getProperty(String propertyName) throws ServiceException {
        String property;
        try {
            FileInputStream inputStream = new FileInputStream("resources/regexp.properties");
            properties.load(inputStream);
            property = properties.getProperty(propertyName);
        } catch (IOException e) {
            throw new ServiceException("Ошибка regexp.properties");
        }

        return property;
    }
}

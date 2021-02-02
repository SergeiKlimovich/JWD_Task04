package by.training.jwd.task04.client.model.impl;

import by.training.jwd.task04.client.model.ReaderFromFile;
import by.training.jwd.task04.client.model.TextDAO;
import by.training.jwd.task04.client.model.exception.DAOException;
import by.training.jwd.task04.client.model.parser.ComponentParser;
import by.training.jwd.task04.client.model.parser.ParserFactory;
import by.training.jwd.task04.entity.impl.Text;

public class TextDAOImpl implements TextDAO {

    private final ComponentParser componentParser;
    private final ReaderFromFile reader;

    public TextDAOImpl() throws DAOException {
        componentParser = ParserFactory.getComponentParser();
        reader = new ReaderFromFile();
    }

    @Override
    public Text getText() throws DAOException {
        return componentParser.createText(reader.readAllText());
    }
}

package by.training.jwd.task04.client.model;

import by.training.jwd.task04.client.model.exception.DAOException;
import by.training.jwd.task04.entity.impl.Text;

public interface TextDAO {

    Text getText() throws DAOException;
}

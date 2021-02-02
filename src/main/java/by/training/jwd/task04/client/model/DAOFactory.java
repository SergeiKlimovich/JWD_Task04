package by.training.jwd.task04.client.model;

import by.training.jwd.task04.client.model.exception.DAOException;
import by.training.jwd.task04.client.model.impl.TextDAOImpl;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private static TextDAO textDAO;

	private DAOFactory() {

	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public TextDAO getTextDAO() throws DAOException {
		if (textDAO == null) {
			textDAO = new TextDAOImpl();
		}
		return textDAO;
	}
}

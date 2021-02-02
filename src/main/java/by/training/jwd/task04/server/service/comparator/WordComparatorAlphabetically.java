package by.training.jwd.task04.server.service.comparator;

import java.util.Comparator;

import by.training.jwd.task04.entity.Component;
import by.training.jwd.task04.entity.impl.Word;

public class WordComparatorAlphabetically implements Comparator<Component> {

    @Override
    public int compare(Component o1, Component o2) {
        return ((Word) o1).getWord().compareTo(((Word) o2).getWord());
    }
}
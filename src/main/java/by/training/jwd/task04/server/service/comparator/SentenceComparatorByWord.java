package by.training.jwd.task04.server.service.comparator;

import java.util.Comparator;

import by.training.jwd.task04.entity.Component;
import by.training.jwd.task04.entity.impl.Sentence;
import by.training.jwd.task04.entity.impl.Word;

public class SentenceComparatorByWord implements Comparator<Component> {

    @Override
    public int compare(Component o1, Component o2) {
        int countWordInFirstSentence = 0;
        int countWordInSecondSentence = 0;

        for (Component c : ((Sentence) o1).getPartsOfSentence()) {
            if (c.getClass().equals(Word.class)) {
                countWordInFirstSentence++;
            }
        }

        for (Component c : ((Sentence) o2).getPartsOfSentence()) {
            if (c.getClass().equals(Word.class)) {
                countWordInSecondSentence++;
            }
        }

        return countWordInFirstSentence - countWordInSecondSentence;
    }
}

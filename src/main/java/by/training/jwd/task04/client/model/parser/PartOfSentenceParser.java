package by.training.jwd.task04.client.model.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.jwd.task04.client.model.exception.DAOException;
import by.training.jwd.task04.entity.Component;
import by.training.jwd.task04.entity.impl.Digit;
import by.training.jwd.task04.entity.impl.PunctuationMark;
import by.training.jwd.task04.entity.impl.Word;

public class PartOfSentenceParser {

    private final String partOfSentenceRegEx;
    private final String wordRegEx;
    private final String digitRegEx;
    private final Pattern pattern;

    public PartOfSentenceParser() throws DAOException {
        partOfSentenceRegEx = PropertyReader.getInstance().getProperty("partOfSentenceRegEx");
        wordRegEx = PropertyReader.getInstance().getProperty("wordRegEx");
        digitRegEx = PropertyReader.getInstance().getProperty("digitRegEx");
        pattern = Pattern.compile(partOfSentenceRegEx);
    }

    public List<Component> parsePartOfSentence(String sentence) {
        List<Component> partsOfSentence = new ArrayList<>();

        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            String part = matcher.group().intern();
            if (part.matches(wordRegEx)) {
                partsOfSentence.add(new Word(part));
            } else if (part.matches(digitRegEx)){
                partsOfSentence.add(new Digit(part));
            } else {
                partsOfSentence.add(new PunctuationMark(part));
            }
        }

        return partsOfSentence;
    }
}

package by.training.jwd.task04.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.training.jwd.task04.entity.Component;
import by.training.jwd.task04.entity.impl.Sentence;
import by.training.jwd.task04.entity.impl.Text;
import by.training.jwd.task04.entity.impl.Word;
import by.training.jwd.task04.server.service.TextService;
import by.training.jwd.task04.server.service.comparator.SentenceComparatorByWord;
import by.training.jwd.task04.server.service.comparator.WordComparatorAlphabetically;
import by.training.jwd.task04.server.service.exception.ServiceException;
import by.training.jwd.task04.server.service.parser.ComponentParser;
import by.training.jwd.task04.server.service.parser.ParserFactory;

public class TextServiceImpl implements TextService {

    private final ComponentParser componentParser;

    private SentenceComparatorByWord sentenceComparatorByWord = new SentenceComparatorByWord();
    private WordComparatorAlphabetically wordComparatorAlphabetically = new WordComparatorAlphabetically();

    public TextServiceImpl() throws ServiceException {
        componentParser = ParserFactory.getComponentParser();
    }

    @Override
    public Text createText(String allText) {
        return componentParser.createText(allText);
    }

    @Override
    public Text formSentencesAscending(Text text) {
        List<Component> sentences = getListSentences(text);
        sentences.sort(sentenceComparatorByWord);
        return new Text(sentences);
    }

    @Override
    public Text formSentenceOppositeReplacementFirstLastWords(Text text) {
        List<Component> sentences = getListSentences(text);
        List<Component> formedSentences = new ArrayList<>();

        for (Component s : sentences) {
            Sentence editedSentence = new Sentence();

            Word firstWord = null;
            Word lastWord = null;
            for (Component c : ((Sentence) s).getPartsOfSentence()) {
                if (c.getClass().equals(Word.class)) {
                    Word word = (Word) c;
                    if (firstWord == null) {
                        firstWord = word;
                    } else {
                        lastWord = word;
                    }
                }
                editedSentence.addPart(c);
            }

            if (firstWord != null && lastWord != null) {
                editedSentence.removePart(firstWord);
                editedSentence.removePart(lastWord);
                editedSentence.addPart(((Sentence) s).getPartsOfSentence().indexOf(firstWord), lastWord);
                editedSentence.addPart(((Sentence) s).getPartsOfSentence().indexOf(lastWord), firstWord);

                formedSentences.add(editedSentence);
            } else {
                formedSentences.add(s);
            }
        }

        return new Text(formedSentences);
    }

    private List<Component> getListSentences(Text text) {
        List<Component> sentences = new ArrayList<>();

        for (Component component : text.getText()) {
            if (component.getClass().equals(Sentence.class)) {
                Sentence sentence = (Sentence) component;
                sentences.add(sentence);
            }
        }

        return sentences;
    }

}

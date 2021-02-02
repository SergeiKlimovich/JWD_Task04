package by.training.jwd.task04.server.service.parser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.training.jwd.task04.entity.Component;
import by.training.jwd.task04.entity.impl.CodeBlock;
import by.training.jwd.task04.entity.impl.Text;
import by.training.jwd.task04.server.service.exception.ServiceException;

public class ComponentParser {

    private final SentenceParser sentenceParser;
    private final String componentsRegExp;
    private final Pattern pattern;

    public ComponentParser() throws ServiceException {
        sentenceParser = ParserFactory.getSentenceParser();
        componentsRegExp = PropertyReader.getInstance().getProperty("componentsRegExp");
        pattern = Pattern.compile(componentsRegExp);
    }

    public Text createText(String allText) {
        Text text = new Text();

        Matcher matcher = pattern.matcher(allText);

        while (matcher.find()) {
            String textBlock = matcher.group("TextBlock");
            String codeBLock = matcher.group("CodeBlock");

            if (textBlock != null) {
                List<Component> sentences = sentenceParser.parseSentences(textBlock);
                for (Component c : sentences) {
                    text.addTextComponent(c);
                }
            }

            if (codeBLock != null) {
                text.addTextComponent(new CodeBlock(codeBLock));
            }
        }

        return text;
    }
}
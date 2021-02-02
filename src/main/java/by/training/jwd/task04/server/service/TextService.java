package by.training.jwd.task04.server.service;

import by.training.jwd.task04.entity.impl.Text;

public interface TextService {

    Text createText(String allText);

    
    Text formSentencesAscending(Text text);

    
    Text formSentenceOppositeReplacementFirstLastWords(Text text);
}

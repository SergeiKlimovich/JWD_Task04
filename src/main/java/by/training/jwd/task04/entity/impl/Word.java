package by.training.jwd.task04.entity.impl;

import java.util.Objects;

import by.training.jwd.task04.entity.Component;

public class Word implements Component {

	private static final long serialVersionUID = 1L;
	private String word;

    public Word() {
		
	}

	public Word(String word) {
        this.word = word;
    }

    @Override
    public String getContent() {
        return word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
		this.word = word;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

	@Override
	public String toString() {
		return "Word [word=" + word + "]";
	}

}

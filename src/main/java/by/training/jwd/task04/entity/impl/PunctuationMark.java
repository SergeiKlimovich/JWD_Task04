package by.training.jwd.task04.entity.impl;

import java.util.Objects;

import by.training.jwd.task04.entity.Component;

public class PunctuationMark implements Component {
   
	private static final long serialVersionUID = 1L;
	private String punctuationMark;

    public PunctuationMark() {
		
	}

	public PunctuationMark(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    @Override
    public String getContent() {
        return punctuationMark;
    }

    public String getPunctuationMark() {
        return punctuationMark;
    }

    public void setPunctuationMark(String punctuationMark) {
		this.punctuationMark = punctuationMark;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunctuationMark that = (PunctuationMark) o;
        return punctuationMark.equals(that.punctuationMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(punctuationMark);
    }

	@Override
	public String toString() {
		return "PunctuationMark [punctuationMark=" + punctuationMark + "]";
	}



}
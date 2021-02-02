package by.training.jwd.task04.entity.impl;

import java.util.Objects;

import by.training.jwd.task04.entity.Component;

public class Digit implements Component {
    
	private static final long serialVersionUID = 1L;
	private String digit;

    public Digit() {
		
	}

	public Digit(String digit) {
        this.digit = digit;
    }

    @Override
    public String getContent() {
        return digit;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
		this.digit = digit;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit1 = (Digit) o;
        return digit.equals(digit1.digit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }

	@Override
	public String toString() {
		return "Digit [digit=" + digit + "]";
	}



}

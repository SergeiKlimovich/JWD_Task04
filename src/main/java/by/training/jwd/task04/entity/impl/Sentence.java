package by.training.jwd.task04.entity.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import by.training.jwd.task04.entity.Component;

public class Sentence implements Component {

	private static final long serialVersionUID = 1L;
	private List<Component> partsOfSentence;

    public Sentence() {
        partsOfSentence = new ArrayList<>();
    }

    @Override
    public String getContent() {
        StringBuilder buff = new StringBuilder();

        for (Component c : partsOfSentence) {
            buff.append(c.getContent());
        }

        return buff.toString();
    }

    public List<Component> getPartsOfSentence() {
        return partsOfSentence;
    }

    public void setPartsOfSentence(List<Component> partsOfSentence) {
		this.partsOfSentence = partsOfSentence;
	}

	public void addPart(Component component) {
        partsOfSentence.add(component);
    }

    public void addPart(int index, Component component) {
        partsOfSentence.add(index, component);
    }

    public void removePart(Component component) {
        partsOfSentence.remove(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return this.partsOfSentence.equals(sentence.partsOfSentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partsOfSentence);
    }

	@Override
	public String toString() {
		return "Sentence [partsOfSentence=" + partsOfSentence + "]";
	}


}

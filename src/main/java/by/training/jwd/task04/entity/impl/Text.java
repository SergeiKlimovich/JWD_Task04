package by.training.jwd.task04.entity.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import by.training.jwd.task04.entity.Component;

public class Text implements Component {

	private static final long serialVersionUID = 1L;
	private List<Component> text;

	public Text() {
		this.text = new ArrayList<>();
	}

	public Text(List<Component> components) {
		text = components;
	}

	public List<Component> getText() {
		return text;
	}

	public void setText(List<Component> text) {
		this.text = text;
	}

	public void addTextComponent(Component component) {
		text.add(component);
	}

	@Override
	public String getContent() {
		StringBuilder buff = new StringBuilder();

		for (Component c : text) {
			buff.append(c.getContent());
		}

		return buff.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Text text1 = (Text) o;
		return text.equals(text1.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}

	@Override
	public String toString() {
		return "Text [text=" + text + "]";
	}

}

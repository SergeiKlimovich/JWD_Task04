package by.training.jwd.task04.entity.impl;

import java.util.Objects;

import by.training.jwd.task04.entity.Component;

public class CodeBlock implements Component {

	private static final long serialVersionUID = 1684L;

	private String codeBlock;

	public CodeBlock() {

	}

	public CodeBlock(String codeBlock) {
		this.codeBlock = codeBlock;
	}

	@Override
	public String getContent() {
		return codeBlock;
	}

	public String getCodeBlock() {
		return codeBlock;
	}

	public void setCodeBlock(String codeBlock) {
		this.codeBlock = codeBlock;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CodeBlock codeBlock1 = (CodeBlock) o;
		return codeBlock.equals(codeBlock1.codeBlock);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeBlock);
	}

	@Override
	public String toString() {
		return "CodeBlock [codeBlock=" + codeBlock + "]";
	}


}

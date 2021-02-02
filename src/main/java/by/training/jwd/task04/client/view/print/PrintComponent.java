package by.training.jwd.task04.client.view.print;

import java.util.List;

import by.training.jwd.task04.entity.Component;

public class PrintComponent {

    public void print(List<? extends Component> components) {
        StringBuilder buff = new StringBuilder();

        for (Component c : components) {
            buff.append(c.getContent()).append("\n");
        }

        System.out.println(buff.toString());
    }
}
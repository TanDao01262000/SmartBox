package smartbox;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class ContainerPanel extends AppPanel {
    java.awt.List components;
    public ContainerPanel(AppFactory factory) {
        super(factory);
        controlPanel.setLayout(new GridLayout(3, 1));


        JPanel p = new JPanel();
        JButton button = new JButton("Add");
        button.addActionListener(this);
        p.add(button);
        controlPanel.add(p);

        p = new JPanel();
        button = new JButton("Rem");
        button.addActionListener(this);
        p.add(button);
        controlPanel.add(p);

        p = new JPanel();
        button = new JButton("Run");
        button.addActionListener(this);
        p.add(button);
        controlPanel.add(p);

    }

    public static void main(String[] args) {
        AppPanel panel = new ContainerPanel(new ContainerFactory());
        panel.display();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Elementos {
    public Container tela;

    public Elementos(Container t){
        this.tela = t;
    }

    public JLabel Label(String txt, int[] x){
        JLabel label = new JLabel(txt);
        label.setBounds(x[0], x[1], x[2], x[3]);

        this.tela.add(label);
        return label;

    }

    public JTextField TextField(String txt, int[] x){
        JTextField campo = new JTextField(txt);
        campo.setBounds(x[0], x[1], x[2], x[3]);
        this.tela.add(campo);

        return campo;
    }
    public JTextField TextField(int[] x){
        JTextField campo = new JTextField();
        campo.setBounds(x[0], x[1], x[2], x[3]);
        this.tela.add(campo);

        return campo;
    }

    public JButton btn(String txt, int[] x){
        JButton button = new JButton(txt);
        button.setBounds(x[0], x[1], x[2], x[3]);

        tela.add(button);

        return button;

    }

}

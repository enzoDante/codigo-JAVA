import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Atividade11_ex4 extends JFrame{
    private String texto = "";
    JButton btn;
    JTextField txt;
    JLabel rotulo;
    List lista;

    public Atividade11_ex4(){
        Container tela = getContentPane();
        tela.setLayout(null);
        rotulo = new JLabel("Digite um numero entre 1 a 10:");
        tela.add(rotulo);
        rotulo.setBounds(10,5,200,20);

        txt = new JTextField();
        tela.add(txt);
        txt.setBounds(10, 30, 100, 20);

        lista = new List();
        tela.add(lista);
        lista.setBounds(20, 60, 150, 50);

        btn = new JButton("Ok");
        tela.add(btn);
        btn.setBounds(50, 150, 50, 30);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                //JOptionPane.showMessageDialog(null, txt.getText());
                //"IIIIVIIIIX"
                int num = Integer.parseInt(txt.getText());
                lista.addItem(NumerRomano(num));
            }
        });

        setSize(400,300);
        setVisible(true);

    }
    public String NumerRomano(int num){
        int ind = num < 4 ? 0 : (num==4? 3 : (num >= 5 && num < 9? 4:(num==9? 8: 9)));
        setTexto("IIIIVIIIIX".substring(ind, (num == 4 || num == 9? 1 : 0)+ Integer.parseInt(txt.getText())));
        //System.out.println(a);
        return getTexto();        

    }
    public void setTexto(String value){
        this.texto = value;
    }
    public String getTexto(){
        return this.texto;
    }
    public static void main(String args[]){
        Atividade11_ex4 app = new Atividade11_ex4();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
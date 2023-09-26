/* *******************************************************************
 * Colegio Técnico Antônio Teixeira Fernandes (Univap)
 * Curso Técnico em Informática - Data de Entrega: 28/09/2023
 * Autores do Projeto: Enzo Dante Mícoli
 *                     
 * Turma: 3H  Disciplina: Programação - II
 * Avaliação parcial referente ao 4 - Bimestre
 * Observação: <colocar se houver>
 * 
 * nome_arquivo.java
 * ******************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Atividade11_ex1 extends JFrame{
    private String texto = "";
    JButton btn;
    JTextField txt;
    JLabel rotulo;
    List lista;

    public Atividade11_ex1(){
        Container tela = getContentPane();
        tela.setLayout(null);
        rotulo = new JLabel("Digite uma frase:");
        tela.add(rotulo);
        rotulo.setBounds(10,5,200,20);

        txt = new JTextField();
        tela.add(txt);
        txt.setBounds(10, 30, 200, 20);

        lista = new List(4, false);
        tela.add(lista);
        lista.setBounds(20, 60, 150, 50);

        btn = new JButton("Ok");
        tela.add(btn);
        btn.setBounds(50, 150, 50, 30);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                //JOptionPane.showMessageDialog(null, txt.getText());
                setTexto(txt.getText());
                lista.addItem(getTexto());
            }
        });

        setSize(400,300);
        setVisible(true);

    }
    public void setTexto(String value){
        this.texto = value;
    }
    public String getTexto(){
        return this.texto;
    }
    public static void main(String args[]){
        Atividade11_ex1 app = new Atividade11_ex1();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
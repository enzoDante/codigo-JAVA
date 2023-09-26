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

public class Atividade11_ex5 extends JFrame{
    private String texto = "";
    JButton btn;
    JTextField txt;
    JLabel rotulo;
    List lista;

    public Atividade11_ex5(){
        Container tela = getContentPane();
        tela.setLayout(null);
        rotulo = new JLabel("Digite uma frase:");
        tela.add(rotulo);
        rotulo.setBounds(10,5,200,20);

        txt = new JTextField();
        tela.add(txt);
        txt.setBounds(10, 30, 250, 20);

        lista = new List();
        tela.add(lista);
        lista.setBounds(20, 60, 250, 50);

        btn = new JButton("Ok");
        tela.add(btn);
        btn.setBounds(50, 150, 50, 30);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                String texto = txt.getText();
                Vogais vogais = new Vogais();
                vogais.VerificarV(texto);
                lista.addItem("total de Vogais: "+vogais.getTotalVogs() + " | Total de Consoantes: "+vogais.getTotalCons());
            }
        });

        setSize(400,300);
        setVisible(true);

    }
    public static void main(String args[]){
        Atividade11_ex5 app = new Atividade11_ex5();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
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
import java.util.Random;

public class Atividade11_ex2 extends JFrame{
    private String texto = "";
    JButton btn;
    List lista;

    public Atividade11_ex2(){
        Container tela = getContentPane();
        tela.setLayout(null);

        lista = new List();
        tela.add(lista);
        lista.setBounds(20, 20, 150, 150);

        btn = new JButton("Ok");
        tela.add(btn);
        btn.setBounds(50, 200, 50, 30);

        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                //JOptionPane.showMessageDialog(null, txt.getText());
                gerarNumeros(10, lista);
            }
        });

        setSize(400,300);
        setVisible(true);

    }
    public void gerarNumeros(int quant, List lis){
        Random gerador = new Random();
        for(int i = 0; i < quant; i++){
            lis.addItem((gerador.nextInt(61)+30)+"");
        }
    }
    public static void main(String args[]){
        Atividade11_ex2 app = new Atividade11_ex2();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
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

public class Atividade11_ex3 extends JFrame{
    private String texto = "";
    JButton btnNomes;
    JButton btn;
    JTextField txt;
    JLabel rotulo;
    List lista;
    List lista2;

    public Atividade11_ex3(){
        Container tela = getContentPane();
        tela.setLayout(null);
        rotulo = new JLabel("Digite nome e sobrenome:");
        tela.add(rotulo);
        rotulo.setBounds(10,5,200,20);

        txt = new JTextField();
        tela.add(txt);
        txt.setBounds(10, 30, 200, 20);

        lista = new List();
        tela.add(lista);
        lista.setBounds(20, 60, 150, 80);
        lista.addItem("Julio Silva");
        lista.addItem("Enzo Dante");
        lista.addItem("Vitor Ferreira");
        lista.addItem("Mateus Cabral");

        lista2 = new List();
        tela.add(lista2);
        lista2.setBounds(200, 60, 150, 80);

        btnNomes = new JButton("Adicionar nome");
        tela.add(btnNomes);
        btnNomes.setBounds(20, 150, 150, 30);

        btn = new JButton("Ok");
        tela.add(btn);
        btn.setBounds(200, 150, 50, 30);

        btnNomes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                lista.addItem(txt.getText());
            }
        });

        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                //JOptionPane.showMessageDialog(null, txt.getText());
                gerarLista(lista, lista2);
            }
        });

        setSize(400,300);
        setVisible(true);

    }
    public void gerarLista(List l1, List l2){
        for(int i = 0; i < l1.getItemCount(); i++){
            String[] teste = (l1.getItem(i)).split(" ");
            l2.addItem(teste[1] + ", "+teste[0]);
        }
    }
    public static void main(String args[]){
        Atividade11_ex3 app = new Atividade11_ex3();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
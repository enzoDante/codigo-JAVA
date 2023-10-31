import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Projeto4B extends JFrame{
    JButton btnLogin;
    JButton btnCadastro;
    JTextField NomeLogCad;
    JTextField emailLogCad;
    JTextField telefone;
    JTextField senhaLogCad;
    JTextField confirSenhaCad;
    JLabel rotNomeLC;
    JLabel rotEmail;
    JLabel rotTelefone;
    JLabel rotSenha;
    JLabel rotCSenha;
    Conect banco;

    public Projeto4B(){
        //banco = new Conect();
        Container tela = getContentPane();
        tela.setLayout(null);

        rotNomeLC = new JLabel("Digite seu nome *(somente para cadastro):");
        rotNomeLC.setBounds(200, 10, 280, 20);
        rotEmail = new JLabel("Digite seu email:");
        rotEmail.setBounds(200, 70, 250, 20);
        rotTelefone = new JLabel("Digite seu telefone *(somente para cadastro):");
        rotTelefone.setBounds(200, 125, 280, 20);
        rotSenha = new JLabel("Digite sua senha:");
        rotSenha.setBounds(200, 170, 200, 20);
        rotCSenha = new JLabel("Confirmar senha *(somente para cadastro):");
        rotCSenha.setBounds(200, 215, 250, 20);

        NomeLogCad = new JTextField();
        NomeLogCad.setBounds(200, 35, 200, 20);
        emailLogCad = new JTextField();
        emailLogCad.setBounds(200, 95, 200, 20);
        telefone = new JTextField();
        telefone.setBounds(200, 145, 200, 20);
        senhaLogCad = new JTextField();
        senhaLogCad.setBounds(200, 190, 200, 20);
        confirSenhaCad = new JTextField();
        confirSenhaCad.setBounds(200, 235, 200, 20);

        btnLogin = new JButton("Logar");
        btnLogin.setBounds(320, 300, 100, 30);
        btnCadastro = new JButton("Cadastrar");
        btnCadastro.setBounds(200, 300, 100, 30);

        tela.add(rotNomeLC);
        tela.add(NomeLogCad);
        tela.add(rotEmail);
        tela.add(emailLogCad);
        tela.add(rotTelefone);
        tela.add(telefone);
        tela.add(rotSenha);
        tela.add(senhaLogCad);
        tela.add(rotCSenha);
        tela.add(confirSenhaCad);
        tela.add(btnCadastro);
        tela.add(btnLogin);

        btnCadastro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                //JOptionPane.showMessageDialog(null, txt.getText());
                //"IIIIVIIIIX"
                //Ex4_metodo metod = new Ex4_metodo();
                //int num = Integer.parseInt(txt.getText());
                //lista.addItem(metod.NumerRomano(num));
                Cadastro cad = new Cadastro();
                String[] response = cad.setValores(NomeLogCad.getText(), emailLogCad.getText(), telefone.getText(), senhaLogCad.getText(), confirSenhaCad.getText());
                JOptionPane.showMessageDialog(null, response[1]);
            }
        });

        setSize(600,600);
        setVisible(true);

    }
    public static void main(String args[]){
        Projeto4B app = new Projeto4B();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
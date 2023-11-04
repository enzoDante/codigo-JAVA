import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Projeto4B extends JFrame{
    JTextField Nome;
    JTextField email;
    JTextField altura;
    JTextField massa;
    JLabel rotNomeLC;
    JLabel rotEmail;
    JLabel rotAltura;
    JLabel rotMassa;
    JLabel rotIMC_Desc;
    JLabel rotBuscaPaciente;
    JTextField emailPaciente;
    JButton btnCadastro;
    JButton btnConsultar;
    JButton btnAlterar;
    JButton btnExcluir;
    JButton btnRelatorio;
    int idPaciente = 0;

    public Projeto4B(){
        Container tela = getContentPane();
        tela.setLayout(null);
        CampoDadoPaciente(tela);
        Opcoes(tela);

        setSize(800,400);
        setVisible(true);

    }
    public void CampoDadoPaciente(Container tela){
        rotNomeLC = new JLabel("Dados do paciente Digite nome:");
        rotNomeLC.setBounds(10, 10, 280, 20);
        rotEmail = new JLabel("Digite email:");
        rotEmail.setBounds(10, 65, 250, 20);
        rotAltura = new JLabel("Digite sua altura:");
        rotAltura.setBounds(10, 120, 280, 20);
        rotMassa = new JLabel("Digite sua massa corporal:");
        rotMassa.setBounds(10, 165, 200, 20);

        Nome = new JTextField();
        Nome.setBounds(10, 35, 200, 20);
        email = new JTextField();
        email.setBounds(10, 90, 200, 20);
        altura = new JTextField();
        altura.setBounds(10, 140, 200, 20);
        massa = new JTextField();
        massa.setBounds(10, 185, 200, 20);

        tela.add(rotNomeLC);
        tela.add(Nome);
        tela.add(rotEmail);
        tela.add(email);
        tela.add(rotAltura);
        tela.add(altura);
        tela.add(rotMassa);
        tela.add(massa);
    }

    public void Opcoes(Container tela){
        btnCadastro = new JButton("Cadastrar");
        btnCadastro.setBounds(10, 240, 100, 30);
        tela.add(btnCadastro);
        btnCadastro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(CamposVazios()){
                    Cadastro cad = new Cadastro();
                    String[] response = cad.setValores(Nome.getText(), email.getText(), Double.parseDouble(altura.getText()), Double.parseDouble(massa.getText()));
    
                    RotuloIMC(tela);
                    JOptionPane.showMessageDialog(null, response[1]);
                    if(response[1].equals("Cadastrado com sucesso!"))
                        LogOperacao("Cadastrar");
                }else
                    JOptionPane.showMessageDialog(null, "Campos vazios!");
            }
        });
        //================================================================
        btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(120, 240, 100, 30);
        tela.add(btnAlterar);
        btnAlterar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(CamposVazios()){
                    Alterar alter = new Alterar();
                    String[] response = alter.setDadosBanco(idPaciente, Nome.getText(), email.getText(), Double.parseDouble(altura.getText()), Double.parseDouble(massa.getText()));
                    if(response.length > 1){
                        RotuloIMC(tela, response[1], response[2]);
                        LogOperacao("Alterar");
                    }
                    else
                        RotuloIMC(tela);
    
                    JOptionPane.showMessageDialog(null, response[0]);
                }else
                    JOptionPane.showMessageDialog(null, "Campos vazios!");

            }
        });
        //================================================================

        rotBuscaPaciente = new JLabel("Digite o nome ou email do paciente:");
        rotBuscaPaciente.setBounds(300, 10, 250, 30);
        tela.add(rotBuscaPaciente);

        emailPaciente = new JTextField();
        emailPaciente.setBounds(300, 40, 210, 20);
        tela.add(emailPaciente);

        //================================================================
        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(300, 80, 100, 30);
        tela.add(btnConsultar);
        btnConsultar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                
                Consultar consulta = new Consultar();
                String[] dados = consulta.getPaciente(emailPaciente.getText());
                if(dados.length > 1){
                    idPaciente = Integer.parseInt(dados[0]);
                    Nome.setText(dados[1]);
                    email.setText(dados[2]);
                    altura.setText(dados[3]);
                    massa.setText(dados[4]);

                    RotuloIMC(tela, dados[5], dados[6]);
                    LogOperacao("Consultar");
                }else
                    JOptionPane.showMessageDialog(null, dados[0]);
            }
        });
        //================================================================
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(410, 80, 100, 30);
        tela.add(btnExcluir);
        btnExcluir.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                Excluir excl = new Excluir();
                String response = excl.ExcluirPaciente(emailPaciente.getText());
                idPaciente = 0;
                RotuloIMC(tela);
                JOptionPane.showMessageDialog(null, response);
                if(response.equals("Paciente excluido!"))
                    LogOperacao("Excluir");

            }
        });
        //=================================================================
        btnRelatorio = new JButton("Gerar Relatório");
        btnRelatorio.setBounds(300, 130, 150, 30);
        tela.add(btnRelatorio);
        btnRelatorio.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                Relatorio relat = new Relatorio();
                relat.gerarRelatorio();
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
            }
        });
    }
    public void RotuloIMC(Container tela, String imc, String imcD){
        if(rotIMC_Desc != null)
            tela.remove(rotIMC_Desc);
            
        rotIMC_Desc = new JLabel("IMC: ["+imc+"] -> "+ imcD);
        rotIMC_Desc.setBounds(10, 200, 200, 30);
        tela.add(rotIMC_Desc);
        
        tela.revalidate();
        tela.repaint();
    }
    public void RotuloIMC(Container tela){
        Nome.setText("");
        email.setText("");
        altura.setText("");
        massa.setText("");
        if(rotIMC_Desc != null)
            tela.remove(rotIMC_Desc);
        tela.revalidate();
        tela.repaint();
    }
    public Boolean CamposVazios(){
        if(Nome.getText().equals(""))
            return false;
        if(email.getText().equals(""))
            return false;
        if(altura.getText().equals(""))
            return false;
        if(massa.getText().equals(""))
            return false;
        return true;
    }
    public void LogOperacao(String Operacao){
        Conect banco = new Conect();
        Date dataHoraAtual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataHora = sdf.format(dataHoraAtual);
        String query = "INSERT INTO Log (data_hora, operacao) VALUES (\""+dataHora+"\", \""+Operacao+"\")";
        banco.ExecutarQuery(query);
    }

    public static void main(String args[]){
        Projeto4B app = new Projeto4B();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Relatorio relat = new Relatorio();
        // relat.gerarRelatorio();
    }
}
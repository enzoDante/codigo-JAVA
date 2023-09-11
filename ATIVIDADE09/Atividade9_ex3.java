/* *******************************************************************
 * Colegio Técnico Antônio Teixeira Fernandes (Univap)
 * Curso Técnico em Informática - Data de Entrega: 12/09/2023
 * Autores do Projeto: Enzo Dante Mícoli
 * Turma: 3H  Disciplina: Programação - II
 * Avaliação parcial referente ao 1 - Bimestre
 * Observação: <colocar se houver>
 * 
 * nome_arquivo.java
 * ******************************************************************/
import java.awt.*;

public class Atividade9_ex3 extends Frame{
    private String textoDigitado = "";
	Panel p1;
	Panel p2;
	Label labe1;
	Label labe2;
	TextField text1;
	Button btn1;
	public Atividade9_ex3(){
		setLayout(new BorderLayout());
		p1 = new Panel();
		p2 = new Panel();
		labe1 = new Label("Digite um texto:");
		labe2 = new Label("=======================================");
		text1 = new TextField(30);
		btn1 = new Button("Verificar");


		add("North", p1);
		p1.add(labe1);
		p1.add(text1);
		p1.add(labe3);

		add("South", p2);
		p2.add(btn1);

		reshape(100, 100, 700, 300);
		show();
	}
	public boolean action(Event evt, Object ob){
		if("Verificar".equals(ob)){
            StringConfig();
            String resultado = getString();
            
			text1.setText(resultado);
			labe2.setText(resultado);
		}
		return true;

	}
    public void StringConfig(){
        this.setString(text1.getText());
        char Caractere1 = this.getString().charAt(0);
        Caractere1 = Character.toUpperCase(Caractere1);
        this.setString(Caractere1 + this.getString().substring(1, this.getString().length()));

    }
    public void setString(String value){
        this.textoDigitado = value;
    }
    public String getString(){
        return this.textoDigitado;
    }
    

	public static void main(String args[]){
		new Atividade9_ex3();
	}
}
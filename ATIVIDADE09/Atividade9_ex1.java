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

public class Atividade9_ex1 extends Frame{
	Panel p1;
	Panel p2;
	Panel p3;
	Label labe1;
	Label labe2;
	Label labe3;
	TextField text1;
	TextField text2;
	Button btn1;
	public Atividade9_ex1(){
		setLayout(new BorderLayout());
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		labe1 = new Label("Digite um texto:");
		labe2 = new Label("Digite um caractere:");
		labe3 = new Label("=======================================");
		text1 = new TextField(30);
		text2 = new TextField(10);
		btn1 = new Button("Verificar");


		add("North", p1);
		p1.add(labe1);
		p1.add(text1);
		p1.add(labe2);
		p1.add(text2);

		add("Center", p2);
		p2.add(labe3);

		add("South", p3);
		p3.add(btn1);

		reshape(100, 100, 700, 300);
		show();
	}
	public boolean action(Event evt, Object arg){
		if("Verificar".equals(arg)){
			String txt = text1.getText();
			char c = text2.getText().charAt(0);
			String resultado = removerCarac(txt, c);
			text1.setText(resultado);
			labe3.setText(resultado);
		}
		return true;

	}
	public String removerCarac(String texto, char c){
		return texto.replace(""+c, "");
	}
	public static void main(String args[]){
		new Atividade9_ex1();
	}
}
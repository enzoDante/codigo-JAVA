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

public class Atividade9_ex5 extends Frame{
	Panel p1;
	Panel p2;
	Panel p3;
	Label labe1;
	Label labe2;
	TextField text1;
	Button btn1;
	public Atividade9_ex5(){
		setLayout(new BorderLayout());
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		labe1 = new Label("Digite um texto:");
		labe2 = new Label("=======================================");
		text1 = new TextField(30);
		btn1 = new Button("Verificar");


		add("North", p1);
		p1.add(labe1);
		p1.add(text1);

		add("Center", p2);
		p2.add(labe2);

		add("South", p3);
		p3.add(btn1);

		reshape(100, 100, 700, 300);
		show();
	}
	public boolean action(Event evt, Object arg){
		if("Verificar".equals(arg)){
			String txt = text1.getText();
            getTotais(txt);
			//labe2.setText(resultado);
		}
		return true;

	}

    public void getTotais(String str){
        QVogais qv = new QVogais();
        qv.VerificarV(str);
        labe2.setText("Vogais: "+qv.getTotalVogs() +"  Consoantes: "+qv.getTotalCons());
    }
	public static void main(String args[]){
		new Atividade9_ex5();
	}
}
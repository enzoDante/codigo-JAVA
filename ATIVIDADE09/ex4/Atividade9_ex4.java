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


public class Atividade9_ex4 extends Frame{
    private boolean centavos = false;
    private String valorExtenso = "";
	Panel p1;
	Panel p2;
	Panel p3;
	Label labe1;
	Label labe2;
	TextField text1;
	Button btn1;
	public Atividade9_ex4(){
		setLayout(new BorderLayout());
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		labe1 = new Label("Informe um valor em R$:");
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
			
			Float num = Float.parseFloat(text1.getText());
            labe2.setText(num+" a ");
            String resultado = getValorExtenso(num);

			labe2.setText(resultado);
		}
		return true;

	}
    public String getValorExtenso(Float num){
		String valores = "";
		
        int[] numers = getInteiro(num);
		
		Dezena dez = new Dezena();
		if(numers[0] != 0){
			dez.setDezenaExtenso(numers[0]);
			valores = dez.getDezena() + " Reais" + (numers[1] != 0 ? " e " :"");
		}
		if(numers[1] != 0){
			dez.setDezenaExtenso(numers[1]);
			valores += dez.getDezena() + " Centavos";
		}
		//dez.setDezenaExtenso(getInteiro(num)[0] != 0 ? getInteiro(num)[0] : getInteiro(num)[1]);

		return valores;
    }
	public int[] getInteiro(Float num){
		String n = num+"";
		int index = n.indexOf(".");
		String inteiro = n.substring(0, index);
		String decimal = n.substring(index+1);

		decimal = decimal.length() <= 1? decimal + "0" : decimal;
		int[] numeros = {Integer.parseInt(inteiro), Integer.parseInt(decimal)};

		return numeros;

	}
	public static void main(String args[]){
		new Atividade9_ex4();
	}
}
import java.awt.*;
import javax.swing.*;

public class ComponenteSWING {
    private Container tela;
    private int dimensao;
    public Jogo campoMinado;
    public JButton[][] btns;

    public ComponenteSWING(Container tela, int dim){
        this.tela = tela;
        this.dimensao = dim;
        this.campoMinado = new Jogo(dim);
        this.campoMinado.gerarCampo();
        btns = new JButton[dim][dim];
    }

    public void cabeca(){
        JPanel cab = new JPanel();
        
    }

    public void iniciarCampo(){
        JPanel panel = new JPanel(new GridLayout(this.dimensao, this.dimensao));
        //panel.setPreferredSize(new Dimension(200, 200));

        for(int i = 0; i < this.dimensao; i++){
            for(int j = 0; j < this.dimensao; j++){

                Celula atual = campoMinado.gerar[i][j];
                
                btns[i][j] = new JButton(atual.icone);
                btns[i][j].setPreferredSize(new Dimension(40, 40));
                btns[i][j].setMargin(new Insets(0, 0, 0, 0));
                
                int aaa = i;
                int bbb = j;

                 btns[i][j].addActionListener(e -> {
                    System.out.println("Clique em: (" + aaa + ", " + bbb + ")");
                    if(!campoMinado.verificarInicio()){
                        campoMinado.setInicio();

                        campoMinado.gerarBombas();
                    }

                    Celula clicada = campoMinado.gerar[aaa][bbb];
                    if(clicada.revelado || clicada.bomba) return;
                    //clicada.revelado = true;



                    // if(clicada.bomba){
                    //     System.out.println("bomba\n");
                    //     btn.setText("B");
                    // }else if(clicada.bombasVizinho > 0){
                    //     btn.setText(String.valueOf(clicada.bombasVizinho));
                    //     // aqui chama limparvizinhasvazias


                    // }else{
                    //     btn.setText("");
                    //     //aqui chama limparvizinhasvazias
                    // }
                    campoMinado.limparCelula(atual);
                    
                    atualizarCampoVisual();
                    // Aqui você pode ligar com sua estrutura de dados Cell
                    // btn.setText("X"); // Apenas exemplo
                    btns[aaa][bbb].setEnabled(false);
                });


                panel.add(btns[i][j]);


            }
        }

        tela.add(panel);
    }

    public void atualizarCampoVisual() {
        Component[] components = tela.getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel panel) {
                Component[] botoes = panel.getComponents();
                for (int i = 0; i < dimensao; i++) {
                    for (int j = 0; j < dimensao; j++) {
                        Celula cel = campoMinado.gerar[i][j];
                        JButton btn = (JButton) botoes[i * dimensao + j];

                        if (cel.revelado) {
                            if (cel.bomba) {
                                btn.setText("💣");
                            } else if (cel.bombasVizinho > 0) {
                                btn.setText(String.valueOf(cel.bombasVizinho));
                            } else {
                                btn.setText("");
                            }
                            btn.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
}

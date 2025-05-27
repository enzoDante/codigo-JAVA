import java.awt.*;
import javax.swing.*;

public class ComponenteSWING {
    private Container tela;
    private JLabel contadorBandeiras;
    private int bandeirasRestantes;
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
        cab.setLayout(new FlowLayout(FlowLayout.LEFT));
        bandeirasRestantes = campoMinado.totalBomba;

        contadorBandeiras = new JLabel("F " + bandeirasRestantes);
        cab.add(contadorBandeiras);
        
        tela.add(cab, BorderLayout.NORTH);
        
    }

    public void iniciarCampo(){
        // JPanel gridWrapper = new JPanel();
        // gridWrapper.setLayout(new GridBagLayout());
        JPanel panel = new JPanel(new GridLayout(this.dimensao, this.dimensao));
        int btnSize = 35; // 35
        panel.setPreferredSize(new Dimension(btnSize * this.dimensao, btnSize * this.dimensao));
        

        for(int i = 0; i < this.dimensao; i++){
            for(int j = 0; j < this.dimensao; j++){

                Celula atual = campoMinado.gerar[i][j];
                
                btns[i][j] = new JButton(atual.icone);
                btns[i][j].setPreferredSize(new Dimension(btnSize, btnSize));
                btns[i][j].setMargin(new Insets(0, 0, 0, 0));
                
                int aaa = i;
                int bbb = j;

                btns[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e){
                        if(SwingUtilities.isRightMouseButton(e)){
                            
                            
                            toggleBandeira(aaa, bbb);
                        }
                        else if(SwingUtilities.isLeftMouseButton(e)){
                            if(campoMinado.gerar[aaa][bbb].bandeira) return; // não permite clique esquerdo caso tenha bandeira

                            if(!campoMinado.verificarInicio()){
                                campoMinado.setInicio();
                                campoMinado.gerarBombas(aaa, bbb);
                            }

                            Celula clicada = campoMinado.gerar[aaa][bbb];
                            if(clicada.revelado) return;
                            if(clicada.bomba){
                                clicada.revelado = true;
                                btns[aaa][bbb].setText("B");
                                JOptionPane.showMessageDialog(null, "Você perdeu");
                                voltarMenu();
                                return;
                            }else
                                campoMinado.limparCelula(clicada);
                            
                            atualizarCampoVisual();
                            if(campoMinado.verificarVitoria()){
                                JOptionPane.showMessageDialog(null, "Você venceu!");
                                voltarMenu();
                            }
                        }
                    }
                });


                panel.add(btns[i][j]);


            }
        }
        // gridWrapper.add(panel);
        // tela.add(gridWrapper, BorderLayout.CENTER);
        tela.add(panel);
    }

    private void voltarMenu() {
        tela.removeAll();
        tela.revalidate();
        tela.repaint();

        Menu menu = new Menu(tela); // você precisa ter essa classe criada
    }

    public void toggleBandeira(int a, int b){
        Celula cel = campoMinado.gerar[a][b];
        JButton btn = btns[a][b];

        if(cel.revelado) return;
        if(!cel.bandeira){ // && bandeirasRestantes > 0
            cel.bandeira = true;
            // btn.setText("F");
            ImageIcon icone = new ImageIcon("./imagens/flag2.png");
            icone = new ImageIcon(icone.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
            btn.setIcon(icone);
            btn.setDisabledIcon(icone);
            btn.setEnabled(false);
            bandeirasRestantes--;

        }else if(cel.bandeira){
            cel.bandeira = false;
            // btn.setText("");
            btn.setIcon(null);
            btn.setEnabled(true);
            bandeirasRestantes++;
        }

        contadorBandeiras.setText("F "+bandeirasRestantes);
    }

    public void atualizarCampoVisual() {
        for(int i = 0; i < this.dimensao; i++){
            for(int j = 0; j < this.dimensao; j++){
                Celula cel = campoMinado.gerar[i][j];
                JButton btn = btns[i][j];

                if(cel.revelado){
                    if(cel.bomba){
                        btn.setText("B");
                    }else if(cel.bombasVizinho > 0)
                        btn.setText(String.valueOf(cel.bombasVizinho));
                    else
                        btn.setText("");
                    btn.setEnabled(false);
                }else if(cel.bandeira){
                    // btn.setText("F");
                    ImageIcon icone = new ImageIcon("./imagens/flag2.png");
                    icone = new ImageIcon(icone.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
                    btn.setIcon(icone);
                    btn.setDisabledIcon(icone);
                    btn.setEnabled(false);
                }else{
                    btn.setText("");
                    btn.setIcon(null);
                    btn.setEnabled(true);
                }
            }
        }
    }
}

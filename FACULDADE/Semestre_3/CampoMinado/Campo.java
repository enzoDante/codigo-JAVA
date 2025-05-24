import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Campo {
    public int totalBomba;
    public Celula[][] gerar;

    public Campo(int value){
        this.totalBomba = value;
        this.gerar = new Celula[this.totalBomba][this.totalBomba];
    }

    public void gerarCampo(){
        for(int i = 0; i < this.totalBomba; i++){
            for(int j = 0; j < this.totalBomba; j++){
                this.gerar[i][j] = new Celula();
            }
        }
        conectarIrmoesLimoes(this.gerar);
    }

    public void conectarIrmoesLimoes(Celula gerada[][]){
        for(int i = 0; i < this.totalBomba; i++){
            for(int j = 0; j < this.totalBomba; j++){

                if(i > 0){ // pode ter celula acima da atual
                    gerada[i][j].cima = gerada[i-1][j];

                    if(j > 0){ // pode celula no topo esquerdo da atual
                        gerada[i][j].CE = gerada[i-1][j-1];
                    }
                    if(j < this.totalBomba -1){ // pode celula no topo direito da atual
                        gerada[i][j].CD = gerada[i-1][j+1];
                    }
                }
                if(i < this.totalBomba-1){ // pode ter celula abaixo da atual
                    gerada[i][j].baixo = gerada[i+1][j];

                    if(j > 0){ // pode celula abaixo esquerda da atual
                        gerada[i][j].BE = gerada[i+1][j-1];
                    }
                    if(j < this.totalBomba -1){ // pode celula abaixo direita da atual
                        gerada[i][j].BD = gerada[i+1][j+1];
                    }
                }
                if(j > 0){ // pode ter celula a esquerda da atual
                    gerada[i][j].esquerda = gerada[i][j-1];
                }
                if(j < this.totalBomba-1){ // pode ter celula a direita da atual
                    gerada[i][j].direita = gerada[i][j+1];
                }

            }
        }
    }

    public void gerarBombas(int a, int b){
        int bombasCriadas = 0;
        Random rand = new Random();
        while (bombasCriadas < totalBomba) {
            int i = rand.nextInt(totalBomba);
            int j = rand.nextInt(totalBomba);
            if(i != a || j != b){
                Celula cel = gerar[i][j];
                if (!cel.bomba) {
                    cel.bomba = true;
                    atualizarVizinhos(cel);
                    bombasCriadas++;
                }
            }
        }
    }
    private void atualizarVizinhos(Celula cel){
        for (Celula vizinho : new Celula[]{cel.cima, cel.baixo, cel.esquerda, cel.direita,
                                       cel.CE, cel.CD, cel.BE, cel.BD}) {
            if (vizinho != null) {
                vizinho.bombasVizinho++;
            }
        }
    }




    public void limparCelula(Celula cel) {
        if (cel == null || cel.revelado) return;  // || cel.bomba

        cel.revelado = true;

        int revelarCampos = SortearNumero.sortearComPeso(0, 10, 1.5);
        //limparVizinhasVazias(cel);
        if (cel.bombasVizinho == 0) {
            limparVizinhasVazias(cel);
        } else {
            // limparAoRedor(cel);
        }
    }

    public void limparVizinhasVazias(Celula cel) {
        for (Celula viz : getVizinhos(cel)) {
            if (viz != null && !viz.revelado && !viz.bomba) {
                viz.revelado = true;

                // Se também for vazia, continue a limpeza recursivamente
                if (viz.bombasVizinho == 0) {
                    limparVizinhasVazias(viz);
                }
            }
        }
    }

    public void limparAoRedor(Celula cel) {
        for (Celula viz : getVizinhos(cel)) {
            if (viz != null && !viz.revelado && !viz.bomba) {
                viz.revelado = true;
            }
        }
    }

    public List<Celula> getVizinhos(Celula cel) {
        // return List.of(
        //     cel.cima, cel.baixo, cel.direita, cel.esquerda,
        //     cel.CE, cel.CD, cel.BE, cel.BD
        // );
        List<Celula> vizinhos = new ArrayList<>();
        if (cel.cima != null)     vizinhos.add(cel.cima);
        if (cel.baixo != null)    vizinhos.add(cel.baixo);
        if (cel.esquerda != null) vizinhos.add(cel.esquerda);
        if (cel.direita != null)  vizinhos.add(cel.direita);
        if (cel.CE != null)       vizinhos.add(cel.CE);
        if (cel.CD != null)       vizinhos.add(cel.CD);
        if (cel.BE != null)       vizinhos.add(cel.BE);
        if (cel.BD != null)       vizinhos.add(cel.BD);
        return vizinhos;
    }

    public boolean verificarVitoria() {
        for (int i = 0; i < totalBomba; i++) {
            for (int j = 0; j < totalBomba; j++) {
                Celula c = gerar[i][j];
                if (!c.bomba && !c.revelado) {
                    return false;
                }
            }
        }
        return true;
    }

}

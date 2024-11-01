public class Resultado {
    private long tempo;
    private int iteracoes;
    private int trocas;

    public Resultado(long tempo, int iteracoes, int trocas) {
        this.tempo = tempo;
        this.iteracoes = iteracoes;
        this.trocas = trocas;
    }

    public long getTempo() {
        return tempo;
    }

    public int getIteracoes() {
        return iteracoes;
    }

    public int getTrocas() {
        return trocas;
    }
}

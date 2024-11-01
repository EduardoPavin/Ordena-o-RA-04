import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;




public class CriadorDeGraficos {
    private DefaultCategoryDataset datasetTempo;
    private DefaultCategoryDataset datasetTrocas;
    private DefaultCategoryDataset datasetIteracoes;

    public CriadorDeGraficos() {
        datasetTempo = new DefaultCategoryDataset();
        datasetTrocas = new DefaultCategoryDataset();
        datasetIteracoes = new DefaultCategoryDataset();
    }






    public void adicionarDados(String tamanho, long tempoQuick, int trocasQuick, int iteracoesQuick,
                               long tempoRadix, int trocasRadix, int iteracoesRadix) {
        datasetTempo.addValue(tempoQuick, "QuickSort", tamanho);
        datasetTempo.addValue(tempoRadix, "RadixSort", tamanho);

        datasetTrocas.addValue(trocasQuick, "QuickSort", tamanho);
        datasetTrocas.addValue(trocasRadix, "RadixSort", tamanho);

        datasetIteracoes.addValue(iteracoesQuick, "QuickSort", tamanho);
        datasetIteracoes.addValue(iteracoesRadix, "RadixSort", tamanho);
    }




    public ChartPanel criarGraficoTempo() {
        JFreeChart graficoTempo = ChartFactory.createLineChart(
                "Tempo de Execução",
                "Tamanho do Vetor",
                "Tempo (ns)",
                datasetTempo,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);




        salvarGraficoComoImagem(graficoTempo, "grafico_tempo.png");

        return new ChartPanel(graficoTempo);
    }

    public ChartPanel criarGraficoTrocas() {
        JFreeChart graficoTrocas = ChartFactory.createLineChart(
                "Número de Trocas",
                "Tamanho do Vetor",
                "Trocas",
                datasetTrocas,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);




        salvarGraficoComoImagem(graficoTrocas, "grafico_trocas.png");

        return new ChartPanel(graficoTrocas);
    }

    public ChartPanel criarGraficoIteracoes() {
        JFreeChart graficoIteracoes = ChartFactory.createLineChart(
                "Número de Iterações",
                "Tamanho do Vetor",
                "Iterações",
                datasetIteracoes,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);




        salvarGraficoComoImagem(graficoIteracoes, "grafico_iteracoes.png");

        return new ChartPanel(graficoIteracoes);
    }

    private void salvarGraficoComoImagem(JFreeChart grafico, String nomeArquivo) {
        try {
            File arquivoImagem = new File(nomeArquivo);
            ChartUtils.saveChartAsPNG(arquivoImagem, grafico, 1000, 800);
            System.out.println("Gráfico salvo como: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o gráfico " + nomeArquivo + ": " + e.getMessage());
        }
    }
}

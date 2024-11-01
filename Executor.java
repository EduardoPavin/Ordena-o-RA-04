import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;

public class Executor {
    public void executarTestes(JTextArea areaDeResultados, JPanel painelGraficos) {
        int[] tamanhos = {1000, 10000, 100000, 500000, 1000000};
        long seed = 12345L;
        StringBuilder textoResultados = new StringBuilder();

        CriadorDeGraficos criadorDeGraficos = new CriadorDeGraficos();

        for (int tamanho : tamanhos) {
            GeradorDeDados gerador = new GeradorDeDados(5, tamanho, seed);
            int[][] conjuntosDeDados = gerador.getConjuntosDeDados();

            long tempoTotalQuick = 0;
            int trocasTotaisQuick = 0;
            int iteracoesTotaisQuick = 0;

            long tempoTotalRadix = 0;
            int trocasTotaisRadix = 0;
            int iteracoesTotaisRadix = 0;

            MedidorDeDesempenho medidor = new MedidorDeDesempenho();

            for (int[] dados : conjuntosDeDados) {
                Resultado resultadoQuick = medidor.medirQuickSort(dados);
                tempoTotalQuick += resultadoQuick.getTempo();
                trocasTotaisQuick += resultadoQuick.getTrocas();
                iteracoesTotaisQuick += resultadoQuick.getIteracoes();

                Resultado resultadoRadix = medidor.medirRadixSort(dados);
                tempoTotalRadix += resultadoRadix.getTempo();
                trocasTotaisRadix += resultadoRadix.getTrocas();
                iteracoesTotaisRadix += resultadoRadix.getIteracoes();
            }



            long mediaTempoQuick = tempoTotalQuick / 5;
            int mediaTrocasQuick = trocasTotaisQuick / 5;
            int mediaIteracoesQuick = iteracoesTotaisQuick / 5;



            long mediaTempoRadix = tempoTotalRadix / 5;
            int mediaTrocasRadix = trocasTotaisRadix / 5;
            int mediaIteracoesRadix = iteracoesTotaisRadix / 5;



            textoResultados.append("Tamanho: ").append(tamanho).append("\n");
            textoResultados.append("QuickSort - Tempo: ").append(mediaTempoQuick).append(" ns, Trocas: ")
                    .append(mediaTrocasQuick).append(", Iterações: ").append(mediaIteracoesQuick).append("\n");
            textoResultados.append("RadixSort - Tempo: ").append(mediaTempoRadix).append(" ns, Trocas: ")
                    .append(mediaTrocasRadix).append(", Iterações: ").append(mediaIteracoesRadix).append("\n\n");

            criadorDeGraficos.adicionarDados(String.valueOf(tamanho), mediaTempoQuick, mediaTrocasQuick, mediaIteracoesQuick,
                    mediaTempoRadix, mediaTrocasRadix, mediaIteracoesRadix);
        }




        areaDeResultados.setText(textoResultados.toString());

        painelGraficos.removeAll();
        painelGraficos.setLayout(new GridLayout(1, 3));

        ChartPanel painelGraficoTempo = criadorDeGraficos.criarGraficoTempo();
        ChartPanel painelGraficoTrocas = criadorDeGraficos.criarGraficoTrocas();
        ChartPanel painelGraficoIteracoes = criadorDeGraficos.criarGraficoIteracoes();

        painelGraficos.add(painelGraficoTempo);
        painelGraficos.add(painelGraficoTrocas);
        painelGraficos.add(painelGraficoIteracoes);




        painelGraficos.validate();
        painelGraficos.repaint();
    }
}

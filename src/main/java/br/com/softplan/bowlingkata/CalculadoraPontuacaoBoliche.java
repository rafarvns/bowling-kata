package br.com.softplan.bowlingkata;

public class CalculadoraPontuacaoBoliche {

    private int[] jogadas;
    private int index;
    private int maxRounds;

    //Adicionei o parâmetro maxRounds pois pelo que pesquisei sobre as regras do boliche,
    //a quantidade de rodadas muitas vezes é uma modalidade, portanto achei que ficaria mais completo.
    public int pontuacaoDoJogo(int[] jogadas, int maxRounds) {
        int resultado = 0;
        this.jogadas = jogadas;
        this.maxRounds = maxRounds * 2;

        for (index = 0; index < this.maxRounds && index < jogadas.length; index += 2) {
            resultado += pontuacaoDaRodada();
        }
        return resultado;
    }

    private int pontuacaoDaRodada() {
        if (isStrike()) {
            int pontuacaoComStrike = pontuacaoComRodadaStrike();
            index--;
            maxRounds--;
            return pontuacaoComStrike;
        } else if (isSpare()) {
            return pontuacaoComRodadaSpare();
        } else {
            return pontuacaoComRodadaSemBonificacao();
        }
    }

    private boolean isStrike() {
        return jogadas[index] == 10;
    }

    private boolean isSpare() {
        return jogadas[index] + jogadas[index + 1] == 10;
    }

    private boolean isSpareParcialSemBonificacao() {
        return index == jogadas.length - 2;
    }

    private boolean isStrikeParcialSemBonificacao() {
        return index == jogadas.length - 1;
    }
    
    private boolean isSpareOuStrikeNaUltimaRodada() {
        return index == (maxRounds - 1);
    }

    private int pontuacaoComRodadaStrike() {
        if(isSpareOuStrikeNaUltimaRodada()) {
            return jogadas[index] + jogadas[index + 1] + jogadas[index + 2] + jogadas[index + 3] + jogadas[index + 4] + jogadas[index + 5];
        }
        if(isStrikeParcialSemBonificacao()) {
            return jogadas[index];
        }
        return jogadas[index] + jogadas[index + 1] + jogadas[index + 2];
    }

    private int pontuacaoComRodadaSpare() {
        if(isSpareOuStrikeNaUltimaRodada()) {
            return jogadas[index] + jogadas[index + 1] + jogadas[index + 2] + jogadas[index + 3] + jogadas[index + 4] + jogadas[index + 5];
        }
        if(isSpareParcialSemBonificacao()) {
            return jogadas[index] + jogadas[index + 1];
        }
        return jogadas[index] + jogadas[index + 1] + jogadas[index + 2];
    }

    private int pontuacaoComRodadaSemBonificacao() {
        return jogadas[index] + jogadas[index + 1];
    }

}

package br.com.softplan.bowlingkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraPontuacaoBolicheTest {

    private CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche;
    private int maxRounds;

    @BeforeEach
    void setUp() {
        calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();
        maxRounds = 10;
    }

    @Test
    void deve_retornar_pontuacao_quando_todas_as_jogadas_forem_zeradas() {
        int[] jogadas = {
                0,0,
                0,0,
                0,0,
                0,0,
                0,0,
                0,0,
                0,0,
                0,0,
                0,0,
                0,0,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(0, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_quando_nao_houver_bonificacoes() {
        int[] jogadas = {
                1,0,
                5,0,
                0,5,
                2,2,
                0,0,
                4,1,
                0,1,
                0,0,
                0,5,
                2,3,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(31, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_quando_houver_spare_em_jogada_do_meio() {
        int[] jogadas = {
                1,0,
                5,0,
                0,5,
                2,2,
                5,5,
                4,1,
                0,1,
                5,4,
                0,5,
                2,3,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(54, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_quando_houver_dois_spares_seguidos() {
        int[] jogadas = {
                1,0,
                5,0,
                0,5,
                2,2,
                5,5,
                5,5,
                0,1,
                5,4,
                0,5,
                2,3,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(60, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_quando_houver_dois_spares_e_spare_na_ultima_rodada() {
        int[] jogadas = {
            1,0,
            0,1,
            1,0,
            0,1,
            1,5,
            1,0,
            1,9,
            5,5,
            0,0,
            2,8,1,1,2
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(47, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_quando_houver_um_strike_no_meio_do_jogo() {
        int[] jogadas = {
                0,0,
                1,0,
                0,0,
                2,0,
                10,
                3,0,
                0,0,
                0,0,
                0,0,
                1,0,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(20, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_quando_houver_um_jogo_perfeito() {
        int[] jogadas = {
                10,
                10,
                10,
                10,
                10,
                10,
                10,
                10,
                10,
                10, 10, 10, 10
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(300, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_quando_houver_um_jogo_perfeito_com_bonificacoes_imperfeitas_na_ultima_rodada() {
        int[] jogadas = {
                10,
                10,
                10,
                10,
                10,
                10,
                10,
                10,
                10,
                10, 5, 5, 5
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(285, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_ate_o_maximo_de_rodadas_definidas() {
        int[] jogadas = {
                1,0,
                5,0,
                0,5,
                2,2,
                0,0,
                4,1,
                0,1,
                0,0,
                0,5,
                2,3,
                0,0,
                3,2,
                1,0,
                2,6,
                2,7,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(31, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_parcial_quando_todas_as_jogadas_ainda_forem_zeradas() {
        int[] jogadas = {
                0,0,
                0,0,
                0,0,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(0, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_parcial() {
        int[] jogadas = {
                1,0,
                5,0,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(6, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_parcial_com_spare_no_final_ainda_sem_bonus() {
        int[] jogadas = {
                1,9,
                5,0,
                5,5,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(30, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_parcial_com_spare() {
        int[] jogadas = {
                1,9,
                5,0,
                5,5,
                2,0
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(34, pontuacao);
    }

    @Test
    void deve_retornar_pontuacao_parcial_com_strike_no_final_ainda_sem_bonus() {
        int[] jogadas = {
                1,0,
                1,0,
                10,
        };
        var pontuacao = calculadoraPontuacaoBoliche.pontuacaoDoJogo(jogadas, maxRounds);

        assertEquals(12, pontuacao);
    }

}
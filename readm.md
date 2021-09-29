# Bowling Kata

O objetivo é criar uma classe que possa calcular a pontuação total de um jogo de boliche somando os pinos e bônus. O
design da classe e as regras do cálculo devem seguir o detalhado abaixo. Ao final desse documento estão exemplo de
auxílio no entendimento, os exemplos são reais e seu uso é opcional.

`````java
class CalculadoraPontuacaoBoliche {
   int pontuacaoDoJogo(int[] jogadas) {
	return 0;
   }
}
`````

## Regras da pontuação:

Um jogo de boliche possui 10 rodadas. Em cada rodada, o jogador tem 2 chances (jogadas) para derrubar os 10 pinos. Se
todos os 10 pinos forem derrubados na primeira jogada essa rodada é encerrada, caso contrário o jogador tem a direto a
uma segunda jogada.

A pontuação do jogo é a soma total de todos pinos derrubados, a esse total ainda são somadas as bonificações. Essas
bonificações (Strike ou Spare) são dadas a um jogador que derrube todos os 10 pinos:

### Bônus de spare

um Spare é quando um jogador derruba todos os 10 pinos em duas jogadas. O bônus por isso é o número de pinos derrubados
na próxima jogada.

### Bônus de strike

um Strike é quando um jogador derruba todos os 10 pinos em uma única primeira jogada. O bônus por isso é o número de
pinos derrubados nas duas próximas jogadas.

### Spare ou strike no final

O valor do bônus sempre depende das próximas jogadas, exceto na última rodada que é diferente de todas as outras. Ao
fazer um Strike ou Spare na 10ª rodada, o jogador tem direto a 3 jogadas nessa rodada como forma de bônus (conforme pode
ser visto nos exemplos abaixo). Design da classe:

## Exemplos jogos:

## Jogo completo com spare e strike.

int[] jogadas = { 1,4, 4,5, **6,4,** **<u>5</u>**,5, **10**, <u>0,1</u>, **7,3**, **<u>6</u>,4**, **<u>10</u>**, **<u>
2,8</u>**, <u>6</u> };
<br>
retorno esperado = 133

## Jogo com um strike.

int[] jogadas = { 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, **10**, <u>2,3</u>, 0,0 };
<br>
Retorno esperado = 20

## Jogo com um Spare.

int[] jogadas = { 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, **2,8**, <u>2</u>,3, 0,0 };
<br>
retorno esperado = 17

## Jogo perfeito.

int jogadas = { <u>**10, 10, 10, 10, 10, 10, 10, 10, 10, 10,** 10, 10</u> };
<br>
retorno esperado = 300

## OBS:

* Os espaços entre os números representam a separação entre as rodadas (sempre são 10 rodadas);
* Os números em negrito são Strike ou Spare;
* Os números sublinhados são os bônus de um Strike ou Spare de uma jogada anterior. Ou seja, esses números são somados
  novamente ao resultado total na forma de bônus.

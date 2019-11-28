package batalhanaval;

import java.io.*;

public class BatalhaNavalOriginal {

    public static String tabuleiro[][] = new String[10][10]; //cria um tabuleiro  10x10
    public static int posicao[][] = new int[10][10]; //posicoes dos barcos no tabuleiro

    public static void zeraPosicao() {
        for (int l = 0; l < 10; l++) { //preenche as linhas com 0
            for (int c = 0; c < 10; c++) { //preenche as colunas com 0
                posicao[l][c] = 0;
            }
        }
    }

    //funcao que determina a Posicao dos submarinos no tabuleiro
    public static void posicaoDosSubmarinos() {

        //SUBMARINO 1
        posicao[6][0] = 1;

        //SUBMARINO 2
        posicao[6][4] = 1;

        //SUBMARINO 3
        posicao[7][2] = 1;

        //SUBMARINO 4
        posicao[8][0] = 1;

        //SUBMARINO 5
        posicao[9][3] = 1;
    }

    //funcao que define a Posicao dos destroyers no tabuleiro
    public static void posicaoDosDestroyers() {

        //DESTROYER 1
        posicao[2][5] = 3;
        posicao[2][6] = 3;

        //DESTROYER 2
        posicao[3][8] = 3;
        posicao[3][9] = 3;

        //DESTROYER 3
        posicao[4][5] = 3;
        posicao[4][6] = 3;

    }

    //funcao que define a Posicao dos cruzadores no tabuleiro
    public static void posicaoDosCruzadores() {

        //CRUZADOR 1//
        posicao[2][0] = 5;
        posicao[2][1] = 5;
        posicao[2][2] = 5;
        posicao[2][3] = 5;

        //CRUZADOR 2//
        posicao[4][0] = 5;
        posicao[4][1] = 5;
        posicao[4][2] = 5;
        posicao[4][3] = 5;

    }

    //funcao que define a Posicao do Porta Aviao no tabuleiro
    public static void posicaoDoPortaAviao() {

        //PORTA AVIAO//
        posicao[0][2] = 7;
        posicao[0][3] = 7;
        posicao[0][4] = 7;
        
    }

    public static int lerLinha() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int Linha = 0;
        try {
            System.out.println("Informe a linha: ");
            Linha = Integer.parseInt(entrada.readLine());
            if (Linha >= 0 && Linha <= 9) {
                return (Linha);
            } else {
                System.out.println("Linha inexistente!!!");
                return (lerLinha());
            }
        } catch (Exception e) {
            System.out.println("Linha inexistente!!!");
            return (lerLinha());
        }
    }

    public static int lerColuna() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int Coluna = 0;
        //int acert=14;
        try {
            System.out.println("Informe a coluna: ");
            Coluna = Integer.parseInt(entrada.readLine());
            if (Coluna >= 0 && Coluna <= 9) {
                return (Coluna);
            } else {
                System.out.println("Coluna inexistente!!!");
                return (lerColuna());
            }
        } catch (Exception e) {
            System.out.println("Coluna inexistente!!!");
            return (lerColuna());
        }

    }

    public static void inicilizaMatriz() {
        for (int l = 0; l < 10; l++) {//preenche as linhas com elementos de 0 a 7//
            for (int c = 0; c < 10; c++) {//preenche as colunas com elementos de 0 a 7//
                tabuleiro[l][c] = " ";
            }
        }
    }

    public static void imprimeTabuleiro() {
        System.out.println("    0   1   2   3   4   5   6   7   8   9"); //numero da coluna
        System.out.println("-------------------------------------------");
        for(int l=0;l<10;l++){//preenche as linhas com elementos de 0 a 7//
            System.out.print(l + " ");   //numero da linhas do lado do tabuleiro
            for(int c=0;c<10;c++){//preenche as colunas com elementos de 0 a 7//
                System.out.print("| "+tabuleiro[l][c]+" ");
            }
            System.out.println("|");
            System.out.println("--------------------------------------------");
        }
    }

    public static void verificaPosicao() {

        int submarino = 5;
        int destroyer = 6;
        int cruzador = 12;
        int portaAvioes = 3;

        boolean controladora = false;//usamos essa variável para controlar o loop.

        while (controladora == false) {
            int lin = lerLinha();//aqui lê a linha
            int col = lerColuna();//aqui lê a coluna

            int escolha = posicao[lin][col];
            System.out.println(escolha);

            if (tabuleiro[lin][col] == " ") {//se vc ainda n escolheu essa posicao
                switch (escolha) {
                    case 0:
                        System.out.println("voce atirou na agua, tente novamente");
                        tabuleiro[lin][col] = "X";
                        imprimeTabuleiro();
                        break;
                    case 1:
                        System.out.println("voce acertou um submarino");
                        tabuleiro[lin][col] = "S";
                        submarino--; //diminui uma unidade de submarino
                        imprimeTabuleiro();
                        break;
                    case 3:
                        System.out.println("voce acertou um distroyer");
                        tabuleiro[lin][col] = "D";
                        destroyer--; //diminui uma unidade de distroyer
                        imprimeTabuleiro();
                        break;
                    case 5:
                        System.out.println("voce acertou um cruzador");
                        tabuleiro[lin][col] = "C";
                        cruzador--; //diminui uma unidade de cruzador
                        imprimeTabuleiro();
                        break;
                    
                    case 7:
                        System.out.println("voce acertou um porta-avioes");
                        tabuleiro[lin][col] = "P";
                        portaAvioes--; //diminui uma unidade de portaAvioes
                        imprimeTabuleiro();
                        break;
                }//fim do switch
            }//fim do primeiro if

            //Aqui verifica se o jogador já eliminou todos os itens
            if (submarino == 0 && destroyer == 0 && cruzador == 0 && portaAvioes == 0) {
                controladora = true;
            }

        }//fim do while
    }

    public static void main(String[] args) {
        int linha, coluna;

        zeraPosicao();
        posicaoDosSubmarinos();
        posicaoDosDestroyers();
        posicaoDosCruzadores();
        posicaoDoPortaAviao();


        inicilizaMatriz();
        imprimeTabuleiro();


     linha = lerLinha();
     coluna = lerColuna();

        verificaPosicao();

        
        String arq = "log.txt";
        

        String log ="Linha: "+linha+"| Coluna: "+coluna;
        
        if(Arquivo.Write(arq, log))
            System.out.println("Arquivo salvo com sucesso!");
        else
            System.out.println("Erro ao salvar o arquivo!");
        
        
        System.out.println("Parabéns você ganhou");

    }

}

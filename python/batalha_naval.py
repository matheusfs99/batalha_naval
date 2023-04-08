import numpy as np # necessário instalar o numpy
import random


class BatalhaNaval:
    itens = {"agua": 0, "navio": 1, "bomba": 2, "atacado": 3}
    def __init__(self):
        self.tabuleiro = np.zeros((5, 5))
        self.preenche_tabuleiro(10, 5)
        self.game_over = False
        self.win = True

    def preenche_tabuleiro(self, qtd_navios, qtd_bombas):
        def marca_posicao(total, qtd, item):
            while total < qtd:
                line = random.randint(0, 4)
                column = random.randint(0, 4)

                if self.tabuleiro[line][column] == 0:
                    self.tabuleiro[line][column] = self.itens[item]
                    total += 1
            return total

        total_navios = 0
        total_bombas = 0

        marca_posicao(total_navios, qtd_navios, "navio")
        marca_posicao(total_bombas, qtd_bombas, "bomba")

    def ataque(self, linha, coluna):
        try:
            posicao = self.tabuleiro[linha][coluna]
            if posicao == self.itens["agua"]:
                self.tabuleiro[linha][coluna] = self.itens["atacado"]
                print("Você atingiu a água. Tente novamente")
            elif posicao == self.itens["navio"]:
                self.tabuleiro[linha][coluna] = self.itens["atacado"]
                if not self.itens["navio"] in self.tabuleiro:
                    self.win = True
                    print("Parabéns! Você ganhou o jogo!")
                print("Você atingiu um navio")
            elif posicao == self.itens["bomba"]:
                self.game_over = True
                print("Você atingiu uma bomba.\nGame Over")
        except:
            print("Posição inexistente no tabuleiro.")

if __name__ == "__main__":
    batalha_naval = BatalhaNaval()
    while not batalha_naval.game_over or batalha_naval.win:
        linha = int(input("Informe a linha q deseja atacar no tabuleiro: "))
        coluna = int(input("Informe a coluna q deseja atacar no tabuleiro: "))
        batalha_naval.ataque(linha, coluna)

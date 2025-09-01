import csv
import os
import sys

class DbObitosCasos:
    def __init__(self):
        self.dadosSemanas = {}
        self.casosAcc = 0
        self.obitosAcc = 0

        absCaminho = os.path.dirname(os.path.abspath(__file__))
        ds = os.path.join(absCaminho, "DB-Obitos-Casos.csv")

        try:
            with open(ds, mode="r") as dados:
                leitor = csv.reader(dados)
                for linha in leitor:
                    semanaAno = linha[0].split("/")
                    self.casosAcc += int(linha[1])
                    self.obitosAcc += int(linha[2])
                    celula = {
                        "ano": int(semanaAno[1]), "semana": int(semanaAno[0]),
                        "casos": int(linha[1]), "obitos":int(linha[2]),
                        "casosAcc": self.casosAcc, "obitosAcc": self.obitosAcc
                        }
                    self.dadosSemanas[str(celula["ano"]*100 + celula["semana"])] = celula
        except FileNotFoundError:
            print("Erro: Arquivo não encontrado!")
        except IOError:
            print("Erro inesperado ao ler o arquivo!")

    def retornarInformacoes(self, semanaID):
        return self.dadosSemanas[str(semanaID)]
    
    def retornarListaInteira(self):
        return self.dadosSemanas

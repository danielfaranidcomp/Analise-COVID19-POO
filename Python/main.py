from Janela import Ui_MainWindow
import sys
import os
from PyQt5 import QtWidgets
from DbObitosCasos import DbObitosCasos

class janelaInicial(QtWidgets.QMainWindow, Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)
        for i in range(1, 54):
            self.escolhaSemana.addItem(str(i))
        for j in range(2020, 2025):
            self.escolhaAno.addItem(str(j))
        
        self.titulo.setText("Análise COVID Sergipe 2020-2024")
        self.casosAcc.setText("368.215")
        self.casosPeriodo.setText("368.215")
        self.obitosAcc.setText("6.577")
        self.obitosPeriodo.setText("6.577")
        self.botaoConfirmar.clicked.connect(self.pegarDados)

    def pegarDados(self):
        try:
            id = int(self.escolhaAno.currentText()) * 100 + int(self.escolhaSemana.currentText())
            db = DbObitosCasos()
            informacoes = db.retornarInformacoes(id)
            self.casosAcc.setText(str(informacoes["casosAcc"]))
            self.casosPeriodo.setText(str(informacoes["casos"]))
            self.obitosAcc.setText(str(informacoes["obitosAcc"]))
            self.obitosPeriodo.setText(str(informacoes["obitos"]))
            self.titulo.setText(f"Análise COVID Sergipe {informacoes["semana"]}ª semana de {informacoes["ano"]}")
            
        except Exception as e:
            msg = QtWidgets.QMessageBox()
            msg.setIcon(QtWidgets.QMessageBox.Critical)
            msg.setText("Dados não encontrados")
            msg.setInformativeText("Os dados escolhidos não constam na base de dados. Tente outra opção.")
            msg.setWindowTitle("Erro Inesperado.")
            msg.exec_()


if __name__ == '__main__':
    app = QtWidgets.QApplication(sys.argv)
    window = janelaInicial()
    window.show()
    app.exec()
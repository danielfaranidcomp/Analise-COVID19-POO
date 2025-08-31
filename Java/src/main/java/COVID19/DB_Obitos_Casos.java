package COVID19;

import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

// @author daniel
public class DB_Obitos_Casos {
    TreeMap<Integer, CelulaDbObitos> dadosSemanas = new TreeMap<>();
    int casosAcc, obitosAcc = 0; // criando variável que armazena óbitos e casos acumulados até o momento
    
    public DB_Obitos_Casos() {
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\danie\\Downloads\\Projeto POO - Análise Explanatória do COVID em Sergipe\\COVID19\\src\\main\\java\\COVID19\\DB-Obitos-Casos.csv"))){
            String linha = br.readLine();
            while(linha != null) {
                String[] itensDivididos = linha.split(",");
                casosAcc += Integer.parseInt(itensDivididos[1]);
                obitosAcc += Integer.parseInt(itensDivididos[2]);
                String[] semanaAno = itensDivididos[0].split("/");
                CelulaDbObitos novaCelula = new CelulaDbObitos(Integer.parseInt(itensDivididos[1]),
                Integer.parseInt(itensDivididos[2]), Integer.parseInt(semanaAno[0]), Integer.parseInt(semanaAno[1]),
                casosAcc, obitosAcc);
                int semanaID = (Integer.parseInt(semanaAno[1]) * 100) + Integer.parseInt(semanaAno[0]); // identificador de ano e semana
                dadosSemanas.put(semanaID, novaCelula);
                linha = br.readLine();
            }
        }
        catch(FileNotFoundException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Exception Dialog");
            alert.setHeaderText("File not found exception");
            alert.setContentText("Arquivo nao encontrado");
            alert.showAndWait();
        }
        catch(IOException e) {
            System.out.println("Erro Inesperado!");
        }
    }
    
    public CelulaDbObitos retornarInformacoes(int semanaID) {
        return dadosSemanas.get(semanaID);
    } 
    
    public TreeMap<Integer, CelulaDbObitos> retornarListaCompleta() {
        return dadosSemanas;
    }
}

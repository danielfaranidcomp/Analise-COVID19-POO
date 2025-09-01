
package COVID19;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import java.lang.NullPointerException;
import java.util.Map;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;

import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author daniel
 */
public class PrimaryController implements Initializable {


    @FXML
    private ChoiceBox<Integer> choiceSemana;
    
    @FXML
    private ChoiceBox<Integer> choiceAno;

    @FXML
    private Button confirmarBtn;
    
    @FXML
    private BarChart<String, Integer> barChart1;
    
    @FXML
    private BarChart<String, Integer> barChart2;
    
    @FXML
    private Text periodoId;
    
    @FXML
    private Text obitosId;
    
    @FXML
    private Text casosId;
    
    @FXML
    private PieChart pieChartId;
    
    @FXML
    private PieChart pieChartId2;
        
    @FXML
    private Text casosAccId;
            
    @FXML
    private Text obitosAccId;
    
    @FXML
    private AreaChart<Number, Number> areaChart1;
    
    @FXML
    private AreaChart<Number, Number> areaChart2;

    @FXML
    void procurarDados(ActionEvent event) {
        DB_Obitos_Casos DbObitos = new DB_Obitos_Casos();
        int celulaID = choiceAno.getSelectionModel().getSelectedItem() * 100 + 
                choiceSemana.getSelectionModel().getSelectedItem();
        try {       
        CelulaDbObitos informacoes = DbObitos.retornarInformacoes(celulaID);
        
        periodoId.setText("Análise COVID Sergipe: " + 
                Integer.toString(informacoes.retornarSemana()) + 
                "ª semana de " +
                Integer.toString(informacoes.retornarAno()));
        
        XYChart.Series serie1 = new XYChart.Series();
        serie1.setName("Casos em Sergipe (" + informacoes.retornarCasos() + ")");
        serie1.getData().add(new XYChart.Data("Casos", informacoes.retornarCasos()));
        serie1.getData().add(new XYChart.Data("Casos Acumulados", informacoes.retornarCasosAcc()));
        
        XYChart.Series serie2 = new XYChart.Series();       
        serie2.setName("Óbitos em Sergipe" + informacoes.retornarObitos() + ")");
        serie2.getData().add(new XYChart.Data("Óbitos", informacoes.retornarObitos()));
        serie2.getData().add(new XYChart.Data("Óbitos Acumulados", informacoes.retornarObitosAcc()));
        
        barChart1.getData().clear();
        barChart2.getData().clear();
        
        barChart1.getData().add(serie1);
        barChart2.getData().add(serie2);
        
        casosId.setText(Integer.toString(informacoes.retornarCasos()));
        obitosId.setText(Integer.toString(informacoes.retornarObitos()));
        casosAccId.setText(Integer.toString(informacoes.retornarCasosAcc()));
        obitosAccId.setText(Integer.toString(informacoes.retornarObitosAcc()));
        
        float porcentagemCasosAnteriores = (100*(informacoes.retornarCasosAcc() - informacoes.retornarCasos()))/
                informacoes.retornarCasosAcc();
        float porcentagemCasosAtuais = 100 - porcentagemCasosAnteriores;
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Casos anteriores (" + porcentagemCasosAnteriores + ")" , porcentagemCasosAnteriores),
        new PieChart.Data("Casos atuais (" + porcentagemCasosAtuais + ")", porcentagemCasosAtuais));
        pieChartId.setData(pieChartData);
        pieChartId.setLabelsVisible(true);
        float porcentagemObitosAnteriores = (100*(informacoes.retornarObitosAcc() - informacoes.retornarObitos()))/
                informacoes.retornarObitosAcc();
        float porcentagemObitosAtuais = 100 - porcentagemObitosAnteriores;
        ObservableList<PieChart.Data> pieChartData2 = FXCollections.observableArrayList(
        new PieChart.Data("Óbitos anteriores (" + porcentagemObitosAnteriores + ")" , porcentagemObitosAnteriores),
        new PieChart.Data("Óbitos atuais (" + porcentagemObitosAtuais + ")", porcentagemObitosAtuais));
        pieChartId2.setData(pieChartData2);
        pieChartId2.setLabelsVisible(true);
        
        areaChart1.getData().clear();
        areaChart2.getData().clear();
        TreeMap<Integer, CelulaDbObitos> db2 = DbObitos.retornarListaCompleta();
        XYChart.Series obitos = new XYChart.Series();
        XYChart.Series casos = new XYChart.Series();
        obitos.setName("Óbitos");
        casos.setName("Casos");
        int i = 0;
        for(Map.Entry<Integer,CelulaDbObitos> entry : db2.entrySet()) {
               obitos.getData().add(new XYChart.Data(Integer.toString(i), entry.getValue().retornarObitos()));
               casos.getData().add(new XYChart.Data(Integer.toString(i), entry.getValue().retornarCasos()));
               if(entry.getKey() == celulaID)
                   break;
               i++;
        }
        areaChart2.getData().add(obitos);
        areaChart1.getData().add(casos);
        }
        catch(NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText("Sem informações para a opção selecionada.");
            alert.setContentText("Tente novamente com outra data");
            alert.showAndWait();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        periodoId.setText("Análise COVID Sergipe: 2020-2024");
        casosId.setText("368.215");
        obitosId.setText("6.577");
        casosAccId.setText("368.215");
        obitosAccId.setText("6.577");
        
        choiceAno.getItems().addAll(2020, 2021, 2022, 2023, 2024);
        List semanas = new ArrayList();
        for (int i=1; i<54; i++)
            semanas.add(i);
        choiceSemana.getItems().addAll(semanas);

        XYChart.Series serie1 = new XYChart.Series();
        serie1.setName("Casos em Sergipe");
        serie1.getData().add(new XYChart.Data("Casos", 368215));
        serie1.getData().add(new XYChart.Data("Casos Acumulados", 368215));
        XYChart.Series serie2 = new XYChart.Series();
        serie2.setName("Óbitos em Sergipe");
        serie2.getData().add(new XYChart.Data("Óbitos", 6577));
        serie2.getData().add(new XYChart.Data("Óbitos Acumulados", 6577));
        barChart1.getData().add(serie1);
        barChart2.getData().add(serie2);
        
        pieChartId.getData().add(new PieChart.Data("Casos Anteriores (100)", 100));
        pieChartId2.getData().add(new PieChart.Data("Mortes Anteriores(100)", 100));
        
        DB_Obitos_Casos informacoes = new DB_Obitos_Casos();
        TreeMap<Integer, CelulaDbObitos> Db = informacoes.retornarListaCompleta();
        XYChart.Series obitos = new XYChart.Series();
        XYChart.Series casos = new XYChart.Series();
        obitos.setName("Óbitos");
        casos.setName("Casos");
        int i = 0;
        for(Map.Entry<Integer,CelulaDbObitos> entry : Db.entrySet()) {
               obitos.getData().add(new XYChart.Data(Integer.toString(i), entry.getValue().retornarObitos()));
               casos.getData().add(new XYChart.Data(Integer.toString(i), entry.getValue().retornarCasos()));
               i++;
        }
        areaChart2.getData().add(obitos);
        areaChart1.getData().add(casos);
        
    }    
    
}

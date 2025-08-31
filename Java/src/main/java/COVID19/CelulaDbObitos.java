
package COVID19;

//@author daniel
 
public class CelulaDbObitos {
    private int casos, obitos, semana, ano, casosAcc, obitosAcc;
    
    public CelulaDbObitos(int casos, int obitos, int semana, int ano, int casosAcc, int obitosAcc) {
        this.casos = casos;
        this.obitos = obitos;
        this.semana = semana;
        this.ano = ano;
        this.casosAcc = casosAcc;
        this.obitosAcc = obitosAcc;
    }
    
    public int retornarAno() {
        return ano;
    }
    
    public int retornarObitos() {
        return obitos;
    }
    
    public int retornarSemana() {
        return semana;
    }
  
    public int retornarCasos() {
        return casos;
    }
    
    public int retornarCasosAcc() {
        return casosAcc;
    }
    
    public int retornarObitosAcc() {
        return obitosAcc;
    }
}

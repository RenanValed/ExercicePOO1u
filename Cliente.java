
import java.util.ArrayList;

public class Cliente
{   String cpf;
    String genero;
    ArrayList<Metrica> metricas = new ArrayList<>();
    
    public Metrica metricaAtual(){
        return metricas.get((metricas.size()) -1);
    }
    public Double imaAtual(){
        return this.metricaAtual().imc();
    }
}

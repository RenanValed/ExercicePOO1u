import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.io.BufferedReader;
import java.awt.Toolkit;


public class List_exercices3
{
    //3.1 Obter a data atual do sistema e retorná-la na forma de String.
    public String exercice3_1()
    { Date dataAtual = new Date();
        return ""+dataAtual;

    }
    //3.2 Receber uma data (como String) no formato dd/mm/aaaa e retornar a mesma data (como String) no formato "<dia da semana>, 
    //<dia> de <nome do mês> de <ano>"
    public String exercice3_2(String args) throws java.text.ParseException {
    SimpleDateFormat formatoinicial = new SimpleDateFormat("dd/MM/yyyy");
    Date dia = formatoinicial.parse(args);
        SimpleDateFormat formatacao = new SimpleDateFormat("EEEE, dd 'de'  MMMM 'de'  yyyy");
    String data = formatacao.format(dia);
    return data;

    }
    //3.3 Receber um caminho de diretório como parâmetro e retornar um vetor com todos os itens do diretório. Dica: 
    //objetos da classe File podem ser usados para realizar operações sobre diretórios, entre várias outras coisas. 
    //Analise a documentação da classe File para saber além do que já foi descrito no conteúdo deste texto.
    public String[] exercice3_3(String caminho){
        File diretorioTemp = new File(caminho);
        String[] conteudo = diretorioTemp.list();
        return conteudo;
    }
    //3.4 Receber um caminho de diretório como parâmetro e retornar um vetor com todos os itens do diretório.
    //Cada item do vetor retornado deve estar precedido por "[A]", caso seja arquivo, e "D", caso seja diretório. 
    //Retorne um valor nulo caso o String recebido como parâmetro não corresponda a um diretório existente no disco. 
    //Mais uma vez, você precisará de um objeto da classe File para fazer o trabalho sujo para você.
    public String[] exercice3_4(String caminho){
        File diretorioTemp = new File(caminho);
        String[] conteudo= diretorioTemp.list();
        for (int i=0;i < conteudo.length; i++){
            if(new File(diretorioTemp.getPath(),conteudo[i]).isDirectory()){  
                conteudo[i] ="[D]" + i;
            }else{
                conteudo[i] = "[A]" + conteudo[i];
            }
        }
        return conteudo;
    }
    //3.5 Receber um caminho para um arquivo como parâmetro e deletar o arquivo. 
    public void exercice3_5(String caminho,String nomeFile){
        new File(caminho,nomeFile).delete();
    }
    //3.6 (Desafio) Escreva um programa que mostre uma janela com dois menus - Arquivo e Editar. 
    //Dica: você deverá utilizar objetos das classes JFrame, JMenuBar e JMenu). 
    public void exercice3_6(){
        JFrame canva = new JFrame();
        canva.setTitle("Canva");
        canva.setSize(400,400);
        
        JMenuBar menu = new JMenuBar();
        canva.setJMenuBar(menu);
        menu.add(new JMenu("Arquivo"));
        menu.add(new JMenu("Editar"));
        canva.setVisible(true);
    }
    //3.7 (Desafio) Escreva um método que receba como parâmetro um String representando um caminho para um arquivo executável e 
    //execute tal arquivo. Dica: pesquise no google "java como executar programas externos" (SEM as aspas) e seja feliz 
    //(você pode ter que escrever código que não vai entender bem - a ideia aqui é que você desenrole a solução independentemente
    //de entender o que está acontecendo. Acredite, isso lhe será muito útil em sua vida de programador) 
    public void exercice3_7(String caminho) throws java.io.IOException{
        Runtime.getRuntime().exec(caminho);
    }
    //3.8 (Desafio) Escreva um método que receba o caminho de um arquivo de texto (txt) e abra o arquivo no bloco de notas 
    //(notepad no windows ou qualquer gedit no Ubuntu). Dica: você vai precisar apenas da solução da questão anterior e 
    //de um real a mais de esperteza.
    public  void exercice3_8(String caminho) throws java.io.IOException {
        Runtime.getRuntime().exec("notepad "+caminho);
        }
    //3.9 (Desafio) Faça um método que mostre uma Janela (vazia) do tamanho da tela. 
    //O programa deve funcionar em monitores com diferentes resoluções. Dica de professor: 
    //a classe ToolKit pode prover o tamanho da tela. Dica de MÃE: pesquise "como criar uma janela tela cheia em java" 
    //(sem aspas, pelo amor de Deus) e seja feliz.
    public void exercice3_9(){
        JFrame canva = new JFrame();
        canva.setTitle("Canva");
        canva.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        JMenuBar menu = new JMenuBar();
        canva.setJMenuBar(menu);
        canva.setVisible(true);
    }
    //3.10 Receber duas datas como parâmetro e retornar a mais recente
    public String exercice3_10(String data1,String data2) throws java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dia1 = formato.parse(data1);
        Date dia2 = formato.parse(data2);
        String str;
        if(dia1.before(dia2) && dia1.before(new Date())){
            str = formato.format(dia2);
            return str;
        }
        str = formato.format(dia1);
        return str;
    }
    //3.11 (Desafio) Receber um array de Dates e modificar o array de forma que fique em ordem cronológica. 
    //Dica: use o método compareTo da classe Date
    public String[] exercice3_11(String[] datas) throws java.text.ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String temp;
        Date dia1,dia2;
        
        for(int i = 1; i < datas.length;i++){
            dia1 = formato.parse(datas[i]);
            for(int j = 0; j < i;j++){
                dia2 = formato.parse(datas[j]);
                if(dia2.compareTo(dia1)>0){
                    temp = datas[i];
                    datas[i] = datas[j];
                    datas[j] = temp;
                }        
            }
        }
        return datas;
    }
    //3.12 Receber uma data, na forma de String, no formato dd/mm/aaaa, e retornar o dia da semana referente à data.
    public String exercicio3_12(String data) throws java.text.ParseException {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date dataForm = formatador.parse(data);
        SimpleDateFormat formatador2 = new SimpleDateFormat("EEEE");
        String dataFormatada = formatador2.format(dataForm);
        return dataFormatada;
    }
}

public class List_exercices2
{

    public String[] exercice2_9(String[] array)
    {   for(int i=0;i < array.length; i++){
            array[i] = array[i].toUpperCase();
    }
    //2.9 Receber um array de Strings e modificá-lo de forma que todos os seus itens fiquem com todas as letras maiúsculas (use o método toUpperCase)
    return array;
}
    public String[] exercice2_10(String[] array1)
    { //2.10 Receber um array de Strings e retornar um array com os mesmos Strings mas com todas as letras maiúsculas (use o método toUpperCase)
       String[] maiusculas = new String[array1.length];
       for(int i=0;i < array1.length; i++){
                maiusculas[i] = array1[i].toUpperCase();
            }
        return maiusculas;
}
    public int[] exercice2_11(int[] array){
        //2.11 Receber um vetor de inteiros. Percorrer o vetor com um comando for. A cada repetição, troque o elemento corrente com o que 
        //estiver uma posição à frente sempre que o elemento da frente for menor que o elemento corrente. 
        int x;
        for (int i = 0; i < array.length-1; i++){
            
            if (array[i] >  array[i+1]){
                x = array[i+1];
                array[i+1] = array[i];
                array[i] = x;
            }
        }
        return array;
}
    public int exercice2_12(int[] array){
    //2.12 Adapte o exercício anterior de forma que as trocas sejam efetuadas e, além disso, o método retorne a quantidade de trocas realizadas. 
    int x,cont = 0 ;
        for (int i = 0; i < array.length-1; i++){
            
            if (array[i] >  array[i+1]){
                x = array[i+1];
                array[i+1] = array[i];
                array[i] = x;
                cont += 1;
            }
        }
        return cont;
}

    public int exercice2_13(String[] array){
        //2.13. Adapte o exercício anterior para que funcione com um vetor de Strings e faça as trocas sempre que um String for 
        //lexicograficamente maior que o String que está à sua frente no vetor. Lembre de retornar o número de trocas.
        int count = 0;
        String x;
        for(int i =0;i< array.length - 1;i++){
            if(array[i].compareTo(array[i+1])>0){
                x = array[i+1];
                array[i+1] = array[i];
                array[i] = x;
                count +=1;
        }
    }
        return count;
}
    public int[] exercice2_14(int[] array){
    //2.14 (Desafio) Receber um vetor de inteiros e modificá-lo para que fique em ordem decrescente. 
    //Dica de amigo: se você usar o método do exercício 2.12 e a quantidade de trocas retornada for 0 (zero), o vetor estará ordenado. 
    //É possível chamar um método de dentro de outro, assim como em qualquer linguagem de programação que você já estudou.

    for (int i = 1; i < array.length; i++) {
        for (int j = 0; j < i; j++) {
            if (array[i] > array[j]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    return array;
}
    public String[] exercice2_15(String[] array){
    //2.15 (Desafio) Receber um vetor de Strings e modificá-lo para que fique ordem alfabética. Dica de amigo: 
    //veja a dica de amigo da questão anterior.
    for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i].compareTo(array[j]) < 0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    
    return array;
}
    public String[] exercice2_16(String[] array){
        //2.16 (Desafio) Receber um vetor de Strings na forma "nome sobrenome" e modificá-lo para que fique ordenado alfabeticamente 
        //por sobrenome. Por exemplo: se o vetor {"robert plant", "ian gillan", "neil young"} for passado como parâmetro, após a 
        //execução do método, o conteúdo do vetor deve ser {"ian gillan", "robert plant",  "neil young"}. Sem dicas, se vire sozinho.
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if((array[i].substring(array[i].indexOf(" ")+1,array[i].indexOf(" ")+2)).compareTo(array[j].substring(array[j].indexOf(" ")+1,array[j].indexOf(" ")+2)) < 0){
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
}
    public String[] exercice2_17(String[] array){
    //2.17 (Desafio) Receber um vetor de Strings na forma "nome sobrenome" e modificá-lo para que fique ordenado alfabeticamente 
    //por sobrenome e com a forma dos strings alterada para "sobrenome, nome".  Por exemplo: se o vetor 
    //{"robert plant", "ian gillan", "neil young"} for passado como parâmetro, após a execução do método, o conteúdo do vetor deve ser 
    //{"gillan, ian", "plant, robert",  "young, neil"}
    array = exercice2_16(array);
    for (int i = 0; i < array.length; i++) {
            int aux = array[i].indexOf(" ");
            array[i] = array[i].substring(aux+1, array[i].length()) + ", " + (array[i].substring(0,aux));
            }
    return array;
}

}

public class Metrica
{
    Double altura;
    Double peso;
    Double biceps;
    Double cintura;
    Double perna;
    
     public Double imc(){
        return peso/(altura * altura);
        }
}

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

import java.util.ArrayList;
public class Academia
{   String Nome;
    ArrayList<Cliente> clientes = new ArrayList<>();
    //HashMap <String,ArrayList<Cliente>> res
    
}
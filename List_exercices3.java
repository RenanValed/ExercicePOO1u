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

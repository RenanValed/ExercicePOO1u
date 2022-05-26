
/**
 * Escreva uma descrição da classe List_exercices aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
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
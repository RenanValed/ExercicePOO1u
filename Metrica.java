
/**
 * Escreva uma descrição da classe Metrica aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
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

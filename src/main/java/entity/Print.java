package entity;

import java.util.List;
import java.util.Scanner;

public class Print {

    private Scanner leia;

    {
        leia = new Scanner(System.in);
    }

    public void pergunta(int cont, int qtdIndividuosChegou){

        System.out.println("A geracao ["+ cont + "] teve [" + qtdIndividuosChegou + "] que chegaram");
        System.out.println("Deseja parar o esperimento? (Y or N)");
        String resposta = leia.next();

        if(resposta.equalsIgnoreCase("S")){
            System.exit(1);
        }

        System.out.println("continuando");
    }


    public void mostreIndividuos(int count, List<Individuo> individuoList){

        System.out.println("---- individuos da populacao [" + count +"] ----");

        for (Individuo i: individuoList){
            System.out.println(i);
        }
        System.out.println("---- -------------------------------------- ----");

    }


    public void vencedoresIncriveis(int count, List<Individuo> individuoList){

        System.out.println("---- vencedores incriveis dapopulacao [" + count +"] ----");

        for (Individuo i: individuoList){
            System.out.println(i);
        }
        System.out.println("---- ---------------------------------------------- ----");

    }

    public void filhosDaGeracao(int count, List<Individuo> individuoList){

        System.out.println("---- filhos da geracao populacao [" + count +"] ----");

        for (Individuo i: individuoList){
            System.out.println(i);
        }
        System.out.println("---- ------------------------------------------------ ----");

    }

}

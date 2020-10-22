package control;

import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

//    public void methodA_teste(){
//        Torneio torneio = new Torneio();
//        Acasalamento acasalamento = new Acasalamento();
//
//        Geracao geracaoZero = new Geracao();
//
//        List<Individuo> individuoList = new ArrayList<Individuo>();
//
//        geracaoZero.setId(0);
//        geracaoZero.criaIndividuos(individuoList);
//
//        System.out.println("==== individuos ===");
//        for (Individuo i: geracaoZero.getIndividuos()){
//            System.out.println(i);
//        }
//        System.out.println("==== ========== ===");
//
//        System.out.println("==== torneio normal ===");
//        for (Individuo a : torneio.vencedores(geracaoZero.getIndividuos())){
//            System.out.println(a);
//        }
//        System.out.println("==== ========== ===");
//
//        //TODO | AS VEZES OS VENCEDORES INCRIVEIS SE REPETEM
//        //TODO | TEMOS Q TER UMA LOGICA DE ACASALAR SERES DIFERENTES
//        //TODO | NAO PASSAR ENGEÇADO O PAI E A MAE
//        System.out.println("==== vencedores incriveis ===");
//        List<Individuo> vencedoresIncriveis = torneio.startToneio(geracaoZero.getIndividuos());
//
//        for (Individuo v: vencedoresIncriveis){
//            System.out.println(v);
//        }
//        System.out.println("==== ========== ===");
//
//        List<Individuo> testeDosPais = new ArrayList<Individuo>();
//        testeDosPais.add(vencedoresIncriveis.get(0));
//        testeDosPais.add(vencedoresIncriveis.get(1));
//
//        System.out.println("==== mae ===");
//        System.out.println(vencedoresIncriveis.get(0));
//        System.out.println("============");
//        System.out.println("==== pai ===");
//        System.out.println(vencedoresIncriveis.get(1));
//        System.out.println("============");
//
//        List<Individuo> filhos = acasalamento.cruza(testeDosPais);
//
//        System.out.println("==== filhos ===");
//        for (Individuo f: filhos){
//            System.out.println(f);
//        }
//        System.out.println("============");
//
//    }
//

        public static void main(String[] args) {

        Print print = new Print();

        Torneio torneio = new Torneio();

        List<Individuo> individuoProxGeracao = new ArrayList<Individuo>();

        int cont = 0;

        while (true){

            try {

                TimeUnit.SECONDS.sleep(1);

                System.out.println("============= GERACAO [" + cont +"] =============");

                Geracao g = new Geracao();
                g.setId(cont);
                g.criaIndividuos(individuoProxGeracao);

                //print.mostreIndividuos(cont, g.getIndividuos());

                List<Individuo> individuosChagaram = g.individuosSucesso();

                int qtdIndividuosChegou = individuosChagaram.size();

                if(qtdIndividuosChegou > 0){
                    print.pergunta(cont, qtdIndividuosChegou);
                }else{
                    System.out.println("==== geracao [" + cont +"] - nao teve sucesso ====");
                }

                List<Individuo> vecedoresIncriveis = torneio.startToneio(g.getIndividuos());

                print.vencedoresIncriveis(cont, vecedoresIncriveis);

                Acasalamento acasalamento = new Acasalamento(vecedoresIncriveis);
                individuoProxGeracao = acasalamento.meDeTodosOsFilhos();

                print.filhosDaGeracao(cont, individuoProxGeracao);

                System.out.println("==================================================");

                cont++;

            }catch (Exception e){
                System.out.println(e);
                e.printStackTrace();
            }

        }
    }

}

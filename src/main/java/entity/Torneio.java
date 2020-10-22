package entity;

import java.util.*;

public class Torneio {


    public static final Integer qtdVencedores = 12;
    public static final Integer qtdBatalhas = qtdVencedores;
    private Bloco blocoObjetivo;

    public Torneio() {
        blocoObjetivo = new Bloco();
        blocoObjetivo.setX(1000);
        blocoObjetivo.setY(1000);
    }

    public Integer calculePonto(Individuo individuo){

        Integer x = (blocoObjetivo.getX() - individuo.getBlocoAtual().getX());
        Integer y = (blocoObjetivo.getY() - individuo.getBlocoAtual().getY());

        return (x + y);
    }

    public List<Individuo> startToneio(List<Individuo> individuos){

        // vencedor dos vencedores sorteia os vencedores
        return vencedorDosVencedores(vencedores(individuos));
    }


    public List<Individuo> vencedores(List<Individuo> individuos){

        System.out.println("=== iniciando o torneio ===");
        System.out.println("=== calculando pontos ===");

        for (Individuo individuo: individuos){

            Integer ponto = calculePonto(individuo);
            individuo.setPonto(ponto);
        }

        Collections.sort(individuos);

        System.out.println("=== retornando vencedores ===");
        //retorna
        return new ArrayList<Individuo>(individuos.subList(0, qtdVencedores));

    }


    //nao pode ser mais dois individuos distintos (problema lock)
    public List<Individuo> meDeDoisIndividuos(List<Individuo> individuos){

        List<Individuo> individuoList = new ArrayList<Individuo>();

        //fica preso aqui - quando converge
        while(individuoList.size() < 2){

            Random randomize = new Random();
            int index = randomize.nextInt(individuos.size());

            //if(!individuoList.contains(individuos.get(index))){

                individuoList.add(individuos.get(index));
            //}
        }

        return individuoList;
    }


    public Individuo batalha(List<Individuo> individuoList){

        if(individuoList.get(0).getPonto() < individuoList.get(1).getPonto()){
            return individuoList.get(0);
        }else{
            return individuoList.get(1);
        }
    }


    public List<Individuo> vencedorDosVencedores(List<Individuo> individuos){

        List<Individuo> vencedoresIncriveis = new ArrayList<Individuo>();

        for (int i = 0; i < qtdBatalhas; i++) {

            List<Individuo> doisIndividuos = meDeDoisIndividuos(individuos);

            vencedoresIncriveis.add(batalha(doisIndividuos));
        }

        System.out.println("=== retornando vencedores incriveis ===");
        return vencedoresIncriveis;
    }



}

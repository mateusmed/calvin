package entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Acasalamento {

    public static final Integer corte = 2;

    private List<Individuo> filhos;
    private List<Individuo> individuosPaternosClone;

    public Acasalamento(List<Individuo> individuosPaternosClone) {
        filhos = new ArrayList<Individuo>();
        this.individuosPaternosClone = individuosPaternosClone;
    }
    public List<Individuo> getIndividuosPaternosClone() {
        return individuosPaternosClone;
    }

    public void setIndividuosPaternosClone(List<Individuo> individuosPaternosClone) {
        this.individuosPaternosClone = individuosPaternosClone;
    }

    public Integer sorteiaCorte(){

        Random randomize = new Random();

        while (true){
            int value = randomize.nextInt(corte);

            if(value != 0) {
                return value;
            }
        }
    }


    public List<Individuo> meDeTodosOsFilhos(){

        while (!individuosPaternosClone.isEmpty()){
            filhos.addAll(cruza(meDeOsPais()));
        }

        return filhos;
    }


    public List<Individuo> meDeOsPais(){

        List<Individuo> pais = new ArrayList<Individuo>();

        pais.add(getIndividuosPaternosClone().get(0));
        pais.add(getIndividuosPaternosClone().get(1));

        if(!getIndividuosPaternosClone().isEmpty()){

            for (int i = 1; i <= 2 ; i++) {
                getIndividuosPaternosClone().remove(getIndividuosPaternosClone().get(0));
            }

        }

        return pais;
    }

    public List<Individuo> cruza(List<Individuo> individuosPaternos){

        List<Individuo> filhos = new ArrayList<Individuo>();

        Individuo mae = individuosPaternos.get(0);
        Individuo pai = individuosPaternos.get(1);


            List<Integer> maeGenes = new ArrayList<Integer>();
            List<Integer> paiGenes = new ArrayList<Integer>();

            List<Integer> maeParte1 = new ArrayList<Integer>();
            List<Integer> paiParte1 = new ArrayList<Integer>();

            maeGenes.addAll(mae.getGenes());
            paiGenes.addAll(pai.getGenes());

            Integer corte = sorteiaCorte();

            maeParte1.addAll(maeGenes.subList(0, corte));
            maeGenes.removeAll(maeParte1);
            List<Integer> maeParte2 = maeGenes;

            paiParte1.addAll(paiGenes.subList(0, corte));
            paiGenes.removeAll(paiParte1);
            List<Integer> paiParte2 = paiGenes;

            maeParte1.addAll(paiParte2);
            paiParte1.addAll(maeParte2);

            List<Integer> genesFilho1 = new ArrayList<Integer>();
            genesFilho1 = maeParte1;

            List<Integer> genesFilho2 = new ArrayList<Integer>();
            genesFilho2= paiParte1;

            filhos.add(new Individuo(genesFilho1));
            filhos.add(new Individuo(genesFilho2));

        return filhos;
    }

}

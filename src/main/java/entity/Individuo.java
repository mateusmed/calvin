package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individuo implements Comparable{

    public static final Integer numGenes = 4;

    private Integer ponto;
    private List<Integer> genes;
    private Boolean valido;
    private Bloco blocoAtual;
    private List<Bloco>  historicoTotal;

    {
        valido = true;
        historicoTotal = new ArrayList<Bloco>();

    }

    public int compareTo(Object object) {

        int ponto = ((Individuo)object).getPonto();

        if(this.ponto == ponto){
            return 0;

        }else if(this.ponto > ponto){
            return 1;

        }else{
            return -1;
        }
    }


    public Individuo(List<Integer> genes) {

        blocoAtual = new Bloco();
        blocoAtual.setX(1);
        blocoAtual.setY(1);

        historicoTotal.add(blocoAtual);

        this.genes = genes;
        ande();
    }

    public Individuo() {

        blocoAtual = new Bloco();
        blocoAtual.setX(1);
        blocoAtual.setY(1);

        historicoTotal.add(blocoAtual);

        Random randomize = new Random();
        genes = new ArrayList<Integer>();

        for (int i = 1; i <= numGenes ; i++) {
            genes.add(randomize.nextInt(500));
        }

        ande();
    }

    public void ande(){

        Bloco novoBloco = null;

        for (int i = 1; i <= genes.get(0) ; i++) {

            novoBloco = direita();

            if(!novoBloco.getDisponivel()){
                valido = false;
                return;
            }

            blocoAtual = novoBloco;
            historicoTotal.add(blocoAtual);
        }

        for (int j = 1; j <= genes.get(1) ; j++) {

            novoBloco = baixo();

            if(!novoBloco.getDisponivel()){
                valido = false;
                return;
            }

            blocoAtual = novoBloco;
            historicoTotal.add(blocoAtual);
        }

        for (int k = 1; k <= genes.get(2) ; k++) {

            novoBloco = direita();

            if(!novoBloco.getDisponivel()){
                valido = false;
                return;
            }

            blocoAtual = novoBloco;
            historicoTotal.add(blocoAtual);
        }

        for (int l = 1; l <= genes.get(3) ; l++) {

            novoBloco = baixo();

            if(!novoBloco.getDisponivel()){
                valido = false;
                return;
            }

            blocoAtual = novoBloco;
            historicoTotal.add(blocoAtual);
        }

    }

    private Bloco direita(){

        return new Bloco(blocoAtual.getX() , (blocoAtual.getY() + 1));

    }

    private Bloco baixo(){

        return new Bloco((blocoAtual.getX() + 1) , blocoAtual.getY());

    }

    @Override
    public boolean equals(Object obj) {

        Individuo objIndividuo = (Individuo)obj;

        if(this.blocoAtual.getX() == objIndividuo.getBlocoAtual().getX()
                && this.blocoAtual.getY() == objIndividuo.blocoAtual.getY()
                    && this.genes.equals(objIndividuo.genes)){
            return true;
        }
        return false;
    }

    public List<Integer> getGenes() {
        return genes;
    }

    public void setGenes(List<Integer> genes) {
        this.genes = genes;
    }

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    public Bloco getBlocoAtual() {
        return blocoAtual;
    }

    public void setBlocoAtual(Bloco blocoAtual) {
        this.blocoAtual = blocoAtual;
    }

    public List<Bloco> getHistoricoTotal() {
        return historicoTotal;
    }

    public void setHistoricoTotal(List<Bloco> historicoTotal) {
        this.historicoTotal = historicoTotal;
    }

    public Integer getPonto() {
        return ponto;
    }

    public void setPonto(Integer ponto) {
        this.ponto = ponto;
    }


    @Override
    public String toString() {
        return "[x:" + blocoAtual.getX() + " y:" + blocoAtual.getY() + "]" + "-- [ponto:" + ponto + "] -- " +"[g1:" + genes + "]";
    }
}

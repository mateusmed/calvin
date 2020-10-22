package entity;

import java.util.ArrayList;
import java.util.List;

public class Geracao {

    public static final Bloco blocoObjetivo = new Bloco(1000, 1000);

    public static final Integer numIndividuosPorGeracao = 1000;
    private Integer id;
    private List<Individuo> individuos;

    public Geracao() {
        individuos = new ArrayList<Individuo>();
    }

    public void criaIndividuos(List<Individuo> individuosVecedores){

        System.out.println("=== gerando individuos ===");

        individuos.addAll(individuosVecedores);

        Integer nIndividuos = (numIndividuosPorGeracao - individuosVecedores.size());

        while (getIndividuos().size() < nIndividuos){

            Individuo individuo = new Individuo();

            if(individuo.getValido()){
                individuos.add(individuo);
            }
        }

    }

    public List<Individuo> individuosSucesso(){

        System.out.println("=== verificando se alguem teve sucesso ===");

        List<Individuo> atingiramObjetivo = new ArrayList<Individuo>();

        for (Individuo i : individuos){

            if(blocoObjetivo.equals(i.getBlocoAtual())){
                atingiramObjetivo.add(i);
            }
        }

     return atingiramObjetivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(List<Individuo> individuos) {
        this.individuos = individuos;
    }

    @Override
    public String toString() {
        return "Geracao{" + id +
                "\n Individuos=" + individuos;
    }
}

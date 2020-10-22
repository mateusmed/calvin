package entity;

import java.util.List;

public class Bloco {

    private int x;
    private int y;
    private Boolean disponivel;
    private Integer distanciaDestino;

    public Bloco() {
    }

    public Bloco(int x, int y) {
        this.x = x;
        this.y = y;

        this.disponivel = false;

        if(!Constants.blocosBloqueados.contains(this)) {
            this.disponivel = true;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Integer getDistanciaDestino() {
        return distanciaDestino;
    }

    public void setDistanciaDestino(Integer distanciaDestino) {
        this.distanciaDestino = distanciaDestino;
    }

    @Override
    public String toString() {
        return "[" +  x + "-" + y + "]" + "  -  [" + disponivel + ']' + '\n';
    }

    @Override
    public boolean equals(Object obj) {

        if(this.x == ((Bloco)obj).getX() && this.y == ((Bloco)obj).getY()){
            return true;
        }
        return false;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

}

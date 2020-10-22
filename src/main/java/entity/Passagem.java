package entity;

public class Passagem {

    private Integer x;
    private Integer y;

    public Passagem() {
    }

    public Passagem(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Passagem{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

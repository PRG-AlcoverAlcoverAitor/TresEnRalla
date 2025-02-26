package tictactoe;
public class TresEnRatlla {
    private int dimension;
    public TresEnRatlla(){
        this.dimension = 0;
    }
    
    public void setDimension(int dimension){
        this.dimension = dimension;
    }
    
    public static void main(String[] args) {
        Tauler tauler = new Tauler();
        tauler.mostrar();
    }
    
}

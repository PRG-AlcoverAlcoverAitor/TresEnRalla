package tictactoe;

public class Tauler {

    private int dimension;

    public Tauler() {
        this.dimension = pedirDimension();
    }
    
    
    public void buidar(){
        
    }
    
    public boolean isCoordenadaValida(Coordenada coordenada){
        return false;
    }
    
    public void mostrar(){
        
    }
    
    public void posarFitxa(){
        
    }
    
    public boolean isOcupada(){
        return false;
    }
    
    public boolean estaPle(){
        return false;
    }
    
    public boolean hiHaTresEnRatlla(){
        return false;
    }
    
    private boolean hiHaTresEnRatlla(EstatCasella tipusFitxa){
        return false;
    }
    
    private int pedirDimension() {
        while (true) {
            System.out.print("Vols donar una nova dimensió al tauler? (Per defecte: 3) [S/N]:  ");
            String decision = GestorIO.llegirCadena();
            if (decision.equals("S")) {
                int entero = GestorIO.leerEntero("Introdueix la dimensió del tauler [3-8]: ");
                GestorIO.llegirCadena();
                if (entero >= 3 && entero <= 8) {
                    return entero;
                }else{
                    System.out.println("¡Error! Tens que posar un numero entre 3 i 8");
                }
            } else if (decision.equals("N")) {
                return 3;
            } else {
                System.out.println("¡Error! Ha d'introduïr S o N");
            }
        }
    }
}

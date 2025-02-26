package tictactoe;

public class Tauler {
    private int dimensio;
    private EstatCasella[][] caselles;
    private final EstatCasella ESTATCASELLAX = EstatCasella.FITXA_X;
    private final EstatCasella ESTATCASELLAO = EstatCasella.FITXA_O;
    private final EstatCasella ESTATCASELLABUIT = EstatCasella.BUIT;

    // Constructor
    public Tauler() {
        this.dimensio = pedirDimension();
        caselles = new EstatCasella[dimensio][dimensio];
        buidar();
    }

    // Mètode per buidar el tauler (posar totes les caselles a l'estat "BUIT")
    public void buidar() {
        for (int i = 0; i < dimensio; i++) {
            for (int j = 0; j < dimensio; j++) {
                caselles[i][j] = ESTATCASELLABUIT;
            }
        }
    }


    public boolean isCoordenadaValida(Coordenada coordenada) {
        return coordenada.isValida(dimensio);
    }
    
    public void posarFitxa(Coordenada coordenada, EstatCasella tipusFitxa){
        
    }

    // Mostra el tauler a la pantalla
    public void mostrar() {
        // Imprimir capçalera de columnes
        System.out.print("| |");
        for (int i = 1; i <= dimensio; i++) {
            System.out.print(i + "|");
        }
        System.out.println();

        // Imprimir files i contingut del tauler
        for (int i = 0; i < dimensio; i++) {
            char filaChar = (char) ('A' + i);
            System.out.print("|" + filaChar + "|");
            for (int j = 0; j < dimensio; j++) {
                System.out.print(caselles[i][j].getSimbol() + "|");
            }
            System.out.println();
        }
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

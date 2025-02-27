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

    public boolean isOcupada(Coordenada coordenada) {
        int filaIndex = coordenada.getFila() - 'A';
        int columnaIndex = coordenada.getColumna() - 1;
        if (caselles[filaIndex][columnaIndex] == ESTATCASELLABUIT) {
            return false;
        } else {
            return true;
        }
    }

    public void posarFitxa(Coordenada coordenada, EstatCasella tipusFitxa) {
        int filaIndex = coordenada.getFila() - 'A';
        int columnaIndex = coordenada.getColumna() - 1;
        if (!isOcupada(coordenada) && !isCoordenadaValida(coordenada)) {
            caselles[filaIndex][columnaIndex] = tipusFitxa;
        } else {
            System.out.println("¡Error! Aquesta casella ja està ocupada o no existeix.");
        }
    }

    public void mostrar() {
        System.out.print("| |");
        for (int i = 1; i <= dimensio; i++) {
            System.out.print(i + "|");
        }
        System.out.println();

        for (int i = 0; i < dimensio; i++) {
            char filaChar = (char) ('A' + i);
            System.out.print("|" + filaChar + "|");
            for (int j = 0; j < dimensio; j++) {
                System.out.print(caselles[i][j].getSimbol() + "|");
            }
            System.out.println();
        }
    }

    public boolean estaPle() {
        for (int i = 0; i < dimensio; i++) {
            for (int j = 0; j < dimensio; j++) {
                if (caselles[i][j] == ESTATCASELLABUIT) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hiHaTresEnRatlla() {
        return hiHaTresEnRatlla(ESTATCASELLAX) || hiHaTresEnRatlla(ESTATCASELLAO);
    }

    private boolean hiHaTresEnRatlla(EstatCasella tipusFitxa) {
        // Comprovar files
        for (int i = 0; i < dimensio; i++) {
            boolean filaCompleta = true;
            for (int j = 0; j < dimensio; j++) {
                if (caselles[i][j] != tipusFitxa) {
                    filaCompleta = false;
                    break;
                }
            }
            if (filaCompleta) {
                return true;
            }
        }

        // Comprovar columnes
        for (int j = 0; j < dimensio; j++) {
            boolean columnaCompleta = true;
            for (int i = 0; i < dimensio; i++) {
                if (caselles[i][j] != tipusFitxa) {
                    columnaCompleta = false;
                    break;
                }
            }
            if (columnaCompleta) {
                return true;
            }
        }

        // Comprovar diagonal principal (\)
        boolean diagonalPrincipalCompleta = true;
        for (int i = 0; i < dimensio; i++) {
            if (caselles[i][i] != tipusFitxa) {
                diagonalPrincipalCompleta = false;
                break;
            }
        }
        if (diagonalPrincipalCompleta) {
            return true;
        }

        // Comprovar diagonal secundària (/)
        boolean diagonalSecundariaCompleta = true;
        for (int i = 0; i < dimensio; i++) {
            if (caselles[i][dimensio - 1 - i] != tipusFitxa) {
                diagonalSecundariaCompleta = false;
                break;
            }
        }
        if (diagonalSecundariaCompleta) {
            return true;
        }

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
                } else {
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

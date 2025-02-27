package tictactoe;

public class Jugador {

    private EstatCasella casilla;

    public Jugador(EstatCasella estatcasella) {
        this.casilla = estatcasella;
    }

    public void posarFitxa(Tauler tauler) {
        System.out.println("Jugador amb " + this.casilla.getSimbol());
        Coordenada coordenada = obtenirCoordenada(tauler);
        tauler.posarFitxa(coordenada, casilla);
    }

    private Coordenada obtenirCoordenada(Tauler tauler) {
        Coordenada coordenada;

        while (true) {
            System.out.print("Introdueix casella [Lletra-Número]: ");
            String entrada = GestorIO.llegirCadena().toUpperCase().trim();

            if (entrada.matches("^[A-Z]-\\d+$")) {
                String[] parts = entrada.split("-");
                char fila = parts[0].charAt(0);
                int columna = Integer.parseInt(parts[1]);

                coordenada = new Coordenada(fila, columna);

                if (tauler.isCoordenadaValida(coordenada)) {
                    return coordenada;
                } else {
                    System.out.println("¡Error! Coordenada fora de rang. Introdueix una vàlida.");
                }
            } else {
                System.out.println("¡Error! Format incorrecte. Usa el format [Lletra-Número] (ex: A-1).");
            }
        }
    }
}

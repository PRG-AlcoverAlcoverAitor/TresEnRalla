package tictactoe;

public class TresEnRatlla {
    
    public static void main(String[] args) {
        // Creem el tauler del joc
        Tauler tauler = new Tauler();
        
        // Creem els 2 jugadors
        Jugador jugador1 = new Jugador(EstatCasella.FITXA_X);
        Jugador jugador2 = new Jugador(EstatCasella.FITXA_O);
        
        // Mostrem el tauler inicial
        tauler.mostrar();
        
        boolean tornJugador1 = true; // Alternar torns
        while (!tauler.estaPle() && !tauler.hiHaTresEnRatlla()) {
            if (tornJugador1) {
                jugador1.posarFitxa(tauler);
            } else {
                jugador2.posarFitxa(tauler);
            }
            tauler.mostrar();
            tornJugador1 = !tornJugador1; // Canviar de jugador
        }

        // Verificar resultat final
        if (tauler.hiHaTresEnRatlla()) {
            System.out.println("Ha guanyat la partida el jugador " + (tornJugador1 ? "O" : "X"));
        } else if (tauler.estaPle()) {
            System.out.println("La partida ha finalitzat en empat.");
        }
    }
}

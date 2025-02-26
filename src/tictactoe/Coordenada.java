package tictactoe;

public class Coordenada {
    private char fila;
    private int columna;

    // Constructor
    public Coordenada(char fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    // Getters
    public char getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isValida(int dimensio) {
        // Comprovar si la fila està dins de l'alfabet (de la A a la Z)
        int filaIndex = fila - 'A' + 1; // Converteix la lletra a un número (A=1, B=2, C=3, ...)
        
        // Comprovar que la fila i la columna estiguin dins del rang de la dimensió
        return filaIndex >= 1 && filaIndex <= dimensio && columna >= 1 && columna <= dimensio;
    }
}

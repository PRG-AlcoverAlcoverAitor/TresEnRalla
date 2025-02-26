package tictactoe;

public enum EstatCasella {
    FITXA_O("O"),
    FITXA_X("X"),
    BUIT(" ");

    private final String simbol;

    EstatCasella(String simbol) {
        this.simbol = simbol;
    }

    public String getSimbol() {
        return simbol;
    }
    
    
    
}

package tictactoe;
import java.util.Scanner;

public class GestorIO {
    private static final Scanner scanner = new Scanner(System.in);

    public static String llegirCadena() {
        return scanner.nextLine();
    }
    
    public static int leerEntero(String mensaje) {
        int entero = 0;
        boolean datoValido = false;

        while (!datoValido) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                entero = scanner.nextInt();
                datoValido = true;
            } else {
                System.out.println("Error: Debes introducir un número entero.");
                scanner.next();
            }
        }
        return entero;
    }

    public static String llegirLletraGuioNumero() {
        String entrada;
        String regex = "[A-Za-z]-\\d+";
        
        do {
            System.out.print("Introdueix una cadena en format Lletra-Número (ex: A-1): ");
            entrada = scanner.nextLine();
            if (!entrada.matches(regex)) {
                System.out.println("Format incorrecte. Torna-ho a intentar.");
            }
        } while (!entrada.matches(regex));
        
        return entrada;
    }
}
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Elige dificultad del juego\n1.Facil\n2.Medio\n3.Dificil\n4.Personalizado\n5.Salir\n");
        int opcion= teclado.nextInt();
    menu(opcion);
    }

//Funcion menu dificultad
    public static void menu(int opcion){
        int tamaño_tblr = 10;
        char tablBarcos[][] = new char[tamaño_tblr][tamaño_tblr];
        char tablDisparos[][] = new char[tamaño_tblr][tamaño_tblr];
        switch (opcion){
            case 1:
                titulosB();
                crear_tablero(tablBarcos);
                titulosD();
                crear_tablero(tablDisparos);
                for (int i = 0; i < 5; i++) {
                    colocarLancha(tablBarcos, 'L', 1);
                }
                for (int i = 0; i < 3; i++) {
                    colocarBarco(tablBarcos, 'B', 3);
                }

                colocarCrucero(tablBarcos, 'Z', 4);
                colocarPortaviones(tablBarcos, 'P', 5);

                titulosD();
                mostrar_tablero(tablDisparos);
                for (int i = 0; i < 50; i++) {
                    System.out.println(i+"/50");
                    disparo(tablDisparos, tablBarcos);
                    titulosD();

                    if (!quedanBarcos(tablDisparos, tablBarcos)) {
                        System.out.println("¡Has hundido todos los barcos! ¡Has ganado el juego!");
                        return; // Salir del programa
                    }

                    if (i + 1 == 50) {
                        System.out.println("¡Has superado los 50 intentos! Has perdido el juego.");
                        return; // Salir del programa
                    }

                }
                break;
            case 2:
                titulosB();
                crear_tablero(tablBarcos);
                titulosD();
                crear_tablero(tablDisparos);
                for (int i = 0; i < 2; i++) {
                    colocarLancha(tablBarcos, 'L', 1);
                }

                colocarBarco(tablBarcos, 'B', 3);
                colocarCrucero(tablBarcos, 'Z', 4);
                colocarPortaviones(tablBarcos, 'P', 5);

                titulosD();
                mostrar_tablero(tablDisparos);
                for (int i = 0; i < 30; i++) {
                    System.out.println(i+"/30");
                    disparo(tablDisparos, tablBarcos);
                    titulosD();
                    mostrar_tablero(tablDisparos);

                    if (!quedanBarcos(tablDisparos, tablBarcos)) {
                        System.out.println("¡Has hundido todos los barcos! ¡Has ganado el juego!");
                        return; // Salir del programa
                    }

                    if (i + 1 == 30) {
                        System.out.println("¡Has superado los 50 intentos! Has perdido el juego.");
                        return; // Salir del programa
                    }
                }

                break;
            case 3:
                titulosB();
                crear_tablero(tablBarcos);
                titulosD();
                crear_tablero(tablDisparos);

                colocarLancha(tablBarcos, 'L', 1);
                colocarBarco(tablBarcos, 'B', 3);

                titulosD();
                mostrar_tablero(tablDisparos);
                for (int i = 0; i < 10; i++) {
                    System.out.println(i+"/10");
                    disparo(tablDisparos, tablBarcos);
                    titulosD();
                    mostrar_tablero(tablDisparos);

                    if (!quedanBarcos(tablDisparos, tablBarcos)) {
                        System.out.println("¡Has hundido todos los barcos! ¡Has ganado el juego!");
                        return; // Salir del programa
                    }

                    if (i + 1 == 10) {
                        System.out.println("¡Has superado los 50 intentos! Has perdido el juego.");
                        return; // Salir del programa

                    }
                }

                break;
            case 4:
                Scanner perso = new Scanner(System.in);
                int tamaño_pers;
                do {
                    System.out.println("Elige el tamaño del tablero (entre 5 y 27): ");
                    tamaño_pers = perso.nextInt();
                    if (tamaño_pers > 27 || tamaño_pers < 5) {
                        System.out.println("Debe ser mayor que 5 y menor que 27. Intenta de nuevo.");
                    }
                } while (tamaño_pers > 27 || tamaño_pers < 5);

                char tablBarcosPerso[][] = new char[tamaño_pers][tamaño_pers];
                char tablDisparosPerso[][] = new char[tamaño_pers][tamaño_pers];
                titulosB();
                crear_tablero(tablBarcosPerso);
                titulosD();
                crear_tablero(tablDisparosPerso);

                System.out.println("Elige el numero de Lanchas: ");
                int Lanchas = perso.nextInt();
                for (int i = 0; i < Lanchas; i++) {
                    colocarLancha(tablBarcosPerso, 'L', 1);
                }

                System.out.println("Elige el numero de Barcos: ");
                int Barcos = perso.nextInt();
                for (int i = 0; i < Barcos; i++) {
                    colocarBarco(tablBarcosPerso, 'B', 3);
                }

                System.out.println("Elige el numero de Cruceros: ");
                int Crucero = perso.nextInt();
                for (int i = 0; i < Crucero; i++) {
                    colocarCrucero(tablBarcosPerso, 'Z', 4);
                }

                System.out.println("Elige el numero de Portaaviones: ");
                int Portaviones = perso.nextInt();
                for (int i = 0; i < Portaviones; i++) {
                    colocarPortaviones(tablBarcosPerso, 'P', 5);
                }
                titulosD();
                mostrar_tablero(tablDisparosPerso);
                System.out.println("Número de intentos: ");
                int intentos = perso.nextInt();
                for (int i = 0; i < intentos; i++) {
                    System.out.println(i + "/" + intentos);
                    disparo(tablDisparosPerso, tablBarcosPerso);
                    titulosD();
                    mostrar_tablero(tablDisparosPerso);

                    if (!quedanBarcos(tablDisparosPerso, tablBarcosPerso)) {
                        System.out.println("¡Has hundido todos los barcos! ¡Has ganado el juego!");
                        return; // Salir del programa

                    }

                    if (i + 1 == intentos) {
                        System.out.println("¡Has superado los" +intentos +" intentos! Has perdido el juego.");
                        return; // Salir del programa
                    }
                }
                break;
            case 5:
                System.out.println("Salir del Juego");
                System.exit(0);
        }

    }
    public static void  titulosD(){
        System.out.println( "*******************\n" +
                "Tablero de Disparos\n" +
                "*******************\n");
    }
    public static void titulosB(){
        System.out.println( "*******************\n" +
                "Tablero de Barcos\n" +
                "*******************\n");
    }

    // Función para disparar
    public static void disparo(char[][] tablDisparos, char[][]tablBarcos) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dime la letra del tablero: ");
        char letra = teclado.next().charAt(0);
        System.out.println("Dime un numero del tablero: ");
        int numero = teclado.nextInt();

        int indiceLetra = letra - 'A';

        if (indiceLetra >= 0 && indiceLetra < tablBarcos.length && numero >= 0 && numero < tablBarcos[0].length) {
            if (tablBarcos[indiceLetra][numero] == '-') {
                tablDisparos[indiceLetra][numero] = 'A'; // Agua
            } else {
                tablDisparos[indiceLetra][numero] = 'X'; // Barco golpeado
            }
        } else {
            System.out.println("Posición no válida en el tablero.");
        }
    }

    //Comprobar que quedan barcos
    public static boolean quedanBarcos(char[][] tablDisparos, char[][] tablBarcos) {
        for (int i = 0; i < tablBarcos.length; i++) {
            for (int j = 0; j < tablBarcos[i].length; j++) {
                if (tablBarcos[i][j] != '-' && tablDisparos[i][j] != 'X') {
                    return true;
                }
            }
        }
        return false;
    }

    // Función para colocar una lancha en el tablero de forma aleatoria
    public static void colocarLancha(char[][] tablero, char tipoBarco, int longitud) {
        int tamaño_tblr = tablero.length;
        int letra, numero;

        do {
            letra = (int) (Math.random() * tamaño_tblr);
            numero = (int) (Math.random() * tamaño_tblr);
        } while (!esEspacioDisponible(tablero, letra, numero, longitud));

        tablero[letra][numero] = tipoBarco;
    }

    // Función para colocar un barco en el tablero de forma aleatoria
    public static void colocarBarco(char[][] tablero, char tipoBarco, int longitud) {
        int tamaño_tblr = tablero.length;
        int letra, numero;

        do {
            letra = (int) (Math.random() * tamaño_tblr);
            numero = (int) (Math.random() * (tamaño_tblr - longitud + 1));
        } while (!esEspacioDisponible(tablero, letra, numero, longitud));

        for (int k = 0; k < longitud; k++) {
            tablero[letra][numero + k] = tipoBarco;
        }
    }

    // Función para colocar un Crucero en el tablero de forma aleatoria
    public static void colocarCrucero(char[][] tablero, char tipoBarco, int longitud) {
        int tamaño_tblr = tablero.length;
        int letra, numero;

        do {
            letra = (int) (Math.random() * tamaño_tblr);
            numero = (int) (Math.random() * (tamaño_tblr - longitud + 1));
        } while (!esEspacioDisponible(tablero, letra, numero, longitud));

        for (int k = 0; k < longitud; k++) {
            tablero[letra][numero + k] = tipoBarco;
        }

    }

    // Función para colocar un Portaviones verticalmente en el tablero de forma aleatoria
    public static void colocarPortaviones(char[][] tablero, char tipoBarco, int longitud) {
        int tamaño_tblr = tablero.length;
        int letra, numero;

        do {
            letra = (int) (Math.random() * (tamaño_tblr - longitud + 1));
            numero = (int) (Math.random() * tamaño_tblr);
        } while (!esEspacioDisponible(tablero, letra, numero, longitud));

        for (int k = 0; k < longitud; k++) {
            tablero[letra + k][numero] = tipoBarco;
        }

    }

    //Funcion para comprobar si se puede colocar algun barco en la casilla
    public static boolean esEspacioDisponible(char[][] tablero, int letra, int numero, int longitud) {
        for (int k = 0; k < longitud; k++) {
            if (letra + k >= tablero.length || numero >= tablero[0].length || tablero[letra + k][numero] != '-') {
                return false;
            }
        }
        return true;
    }

    // Función para mostrar el tablero
    public static void mostrar_tablero(char[][] tablero) {

        for (int k = 0; k <= tablero.length-1; k++) {
            System.out.print("\t" + k + "  ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {
            char letra = (char) ('A' + i);
            System.out.print(letra + "\t");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Función para crear el tablero
    public static void crear_tablero(char[][] tablero) {
        int tamaño_tblr= tablero.length;
        char vacio = '-';
        for (int k = 0; k <= tablero.length-1; k++) {
            System.out.print("\t" + k + "");
        }
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            char letra = (char) ('A' + i);
            System.out.print(letra + "\t");
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = vacio;
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

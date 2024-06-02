package com.mycompany.practica1_ipc1_2024;


import java.util.Scanner;
import java.util.Random;

public class Practica1_IPC1_2024 {

    public static int opcionJuego = 0;
    public static int inicioWordle = 0;
    public static int adivinarWordle = 0;
    public static int vecesPerdidasWordle = 0;
    public static int inicioBasket = 0;
    public static int inicio2048 = 0;
    public static int ganar2048 = 0;
    public static int terminar2048 = 0;
    public static boolean salir = false;
    public static boolean jugarNuevamente = true;
    public static int fila = 4;
    public static int columna = 4;
    public static int [][] tablero = new int[fila][columna];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (args.length > 0) { 
            int parametro = Integer.parseInt(args[0]);
            if (parametro >= 1 && parametro <= 3){
                switch (parametro){
                    case 1:
                        do {
                            Wordle();
                            inicioWordle++;
                            System.out.println("¿Desea seguir jugando o quiere regresar al menu principal? s/n");
                            char respuesta = scanner.next().charAt(0);
                            if (respuesta != 's') {
                                jugarNuevamente = false;
                            }
                        }while (jugarNuevamente);
                        break;
                    case 2:
                        do {
                            juegoBasketball();
                            inicioBasket++;
                            System.out.println("¿Desea seguir jugando o quiere regresar al menu principal? s/n");
                            char respuesta = scanner.next().charAt(0);
                            if (respuesta != 's') {
                                jugarNuevamente = false;
                            }
                        }while (jugarNuevamente);
                        break;

                    case 3:
                        juego2048();
                        inicio2048++;
                        break;
                }
            }else {
                System.out.println("El parametro no es valido, intente de nuevo ");
            }

        }else {
            do {
                System.out.println("Bienvenidos desarroladores de  Code’n Bugs");
                System.out.println("Lista de juegos: ");
                System.out.println("1. Wordle ");
                System.out.println("2. Basketball ");
                System.out.println("3. Juego 2048 ");
                System.out.println("4. Reportes ");
                System.out.println("5. Salir ");
                System.out.println("Elija un juego: ");
                opcionJuego = scanner.nextInt();

                switch (opcionJuego){
                    case 1:
                        do {
                            Wordle();
                            System.out.println("¿Desea seguir jugando o quiere regresar al menu principal? s/n");
                            char respuesta = scanner.next().charAt(0);
                            if (respuesta != 's') {
                                jugarNuevamente = false;
                            }
                        }while (jugarNuevamente);
                        break;

                    case 2:
                        do {
                            juegoBasketball();
                            System.out.println("¿Desea seguir jugando o quiere regresar al menu principal? s/n");
                            char respuesta = scanner.next().charAt(0);
                            if (respuesta != 's') {
                                jugarNuevamente = false;
                            }
                        }while (jugarNuevamente);
                        break;

                    case 3:
                        juego2048();
                        break;

                    case 4:
                        Scanner scanner3 = new Scanner(System.in);
                        int reportes = 0;
                        do {
                            System.out.println("Reporte de juegos ");
                            System.out.println("1. Cantidad de veces que los juegos se han iniciado ");
                            System.out.println("2. Cantidad de veces que ha perdido en Wordle ");
                            System.out.println("3. Cantidad de veces que ha intendo adivinar una palabra en Wordle ");
                            System.out.println("4. Cantidad de veces que ha ganado en 2048 ");
                            System.out.println("5. Cantidad de veces que ha salido del juego 2048 sin finalizar ");
                            System.out.println("6. Menu principal ");
                            System.out.println("Elija una opción: ");
                            reportes = scanner3.nextInt();
                            switch (reportes){
                                case 1:
                                    System.out.println("-----------------------------------------------------------------");
                                    System.out.println("Cantidad de veces que se han inicidado el juego Wordle es: "+inicioWordle);
                                    System.out.println("Cantidad de veces que se han inicidado el juego Basketball es: "+inicioBasket);
                                    System.out.println("Cantidad de veces que se han inicidado el juego 2048 es: "+inicio2048);
                                    System.out.println("-----------------------------------------------------------------");
                                    break;

                                case 2:
                                    System.out.println("-----------------------------------------------------------------");
                                    System.out.println("Cantidad de veces perdidas en Wordle es: "+vecesPerdidasWordle);
                                    System.out.println("-----------------------------------------------------------------");
                                    break;

                                case 3:
                                    System.out.println("-----------------------------------------------------------------");
                                    System.out.println("Cantidad de veces que el jugador a intentado adivinar una palabra en Wordle: "+adivinarWordle);
                                    System.out.println("-----------------------------------------------------------------");
                                    break;

                                case 4:
                                    System.out.println("-----------------------------------------------------------------");
                                    System.out.println("Cantidad de veces ganadas en 2048: "+ganar2048);
                                    System.out.println("-----------------------------------------------------------------");
                                    break;

                                case 5:
                                    System.out.println("-----------------------------------------------------------------");
                                    System.out.println("Cantidad de veces que se han salido de 2048 sin terminar el juego: "+terminar2048);
                                    System.out.println("-----------------------------------------------------------------");
                                    break;

                                case 6:
                                    break;

                                default:
                                    System.out.println("Opción no valida ");
                                    break;
                            }
                        }while (reportes != 6);
                        break;

                    case 5:
                        System.out.println("Nos vemos Desarrolllador ");
                        salir = true;
                        break;
                }
            } while (!salir);
        }
    }

    static void Wordle (){
        inicioWordle++;
        Scanner scanner1 = new Scanner(System.in);
        int intentos = 6;
        String palabraOculta;
        String palabraMostrar;
        boolean ganar = false;

        System.out.println("Tiene que ingresar una palabra de 5 letras para poder adivinarla en 6 intentos o menos ");
        System.out.println("Cada letra despues de escribirla aparecera con un color verde si esta en su posisión, color amarillo si pertenece a la palabra pero no esta en la posición ");
        System.out.println("y color rojo si no pertenece a la palabra");
        System.out.println("Ingrese una palabra de 5 letras:");
        palabraOculta = scanner1.nextLine().toLowerCase();
        for (int i = 0; i < 10; i++) {
            System.out.println(" ");
        }
       
        /*Con este ciclo se verifica que la palabra que se tiene que adivinar sea de 5 letras no más y no menos */
        while (palabraOculta.length() != 5) {
            System.out.println("La palabra debe tener 5 letras. Ingrese nuevamente:");
            palabraOculta = scanner1.nextLine().toLowerCase();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

        }

        for (int i = 0; i < intentos; i++) {
            adivinarWordle++;
            System.out.println("Intento " + (i + 1) + ": Ingrese la palabra:");
            palabraMostrar = scanner1.nextLine().toLowerCase();

            /*Con este ciclo se verifica que la palabra escrita sea de 5 letras no más y no menos */
            while (palabraMostrar.length() != 5) {
                System.out.println("La palabra debe tener 5 letras. Ingrese nuevamente:");
                palabraMostrar = scanner1.nextLine().toLowerCase();
            }

            String resultado = "";
            for (int j = 0; j < 5; j++) {
                char letraMostrar = palabraMostrar.charAt(j);
                char letraOculta = palabraOculta.charAt(j);

                if (letraMostrar == letraOculta) {
                    resultado += "\u001B[32m" + letraMostrar + "\u001B[0m";
                } else if (palabraOculta.indexOf(letraMostrar) != -1) {
                    resultado += "\u001B[33m" + letraMostrar + "\u001B[0m";
                } else {
                    resultado += "\u001B[31m" + letraMostrar + "\u001B[0m";
                }
            }
            System.out.println(resultado);
            System.out.println();

            /* En esta parte se verifica si adivino la palabra */
            if (palabraMostrar.equals(palabraOculta)) {
                System.out.println("Ganaste, felicidades!!!");
                ganar = true;
                break;
            }
        }

        if (!ganar) {
            vecesPerdidasWordle++;
            System.out.println("Has perdido. La palabra oculta era: " + palabraOculta);
        }
    }

    static void juegoBasketball(){
        inicioBasket++;
        Scanner scanner = new Scanner(System.in);
        int turnos;
        int pJugador1 = 0;
        int pJugador2 = 0;
        int jugada1;
        int jugada2;
        Random random = new Random();
        String jugador1;
        String jugador2;
        System.out.println("Instrucciones: Este juego consiste en la simulación de un juego de Basketball de dos personas, ");
        System.out.println("los jugadores ingresan el nombre de cada uno y tambien colocan cuantos turnos desean jugar. ");
        System.out.println("En cada turno, cada jugador puede escoger entre 2 tipos de lanzamientos:\n" +
                "● Salto largo desde 5 metros, vale 3 puntos y la probabilidad de anotar es de 65%\n" +
                "● Salto corto desde 3 metros, vale 2 puntos y la probabilidad de anotar es de 80%");
        System.out.println("Existe un lanzamiento espcial 'Tiro libre' que se da a un jugador cuando le cometen falta y tiene \n"+
                "el valor de 2 puntos con una probabilidad de anotar del 90%");
        System.out.println("También puede escoger entre 2 movimientos de defensa que ayudan a reducir la probabilidad del\n" +
                "oponente de anotar en el turno. Los movimientos son:\n" +
                "● Defensa cuerpo a cuerpo, reduce la probabilidad de anotar en un 15% y probabilidad de hacer\n" +
                "falta del 35%\n" +
                "● Defensa fuerte, reduce la probabilidad de anotar en un 30% y probabilidad de hacer falta del\n" +
                "65%\n");
        System.out.println("Ingrese el nombre del jugador 1: ");
        jugador1 = scanner.nextLine();
        System.out.println("Ingrese el nombre del jugador 2: ");
        jugador2 = scanner.nextLine();

        System.out.println("Ingrese el número de turnos por jugar: ");
        turnos = scanner.nextInt();

        if (turnos >= 1){
            for (int i = 1; i <= turnos; i++){
                System.out.println("Turno "+i+":");
                System.out.println(" ");

                System.out.println(jugador1+"  empieza tu turno ");
                System.out.println("Ingrese la acción que quiere realizar en su turno: "+i);
                System.out.println("1. Salto largo, valor 3 puntos ");
                System.out.println("2. Salto corto, valor 2 puntos ");
                System.out.println("3. Defensa cuerpo a cuerpo ");
                System.out.println("4. Defensa fuerte ");
                jugada1 = scanner.nextInt();

                System.out.println(jugador2+"  empieza tu turno ");
                System.out.println("Ingrese la acción que quiere realizar en su turno: "+i);
                System.out.println("1. Salto largo, valor 3 puntos ");
                System.out.println("2. Salto corto, valor 2 puntos ");
                System.out.println("3. Defensa cuerpo a cuerpo ");
                System.out.println("4. Defensa fuerte ");
                jugada2 = scanner.nextInt();

                pJugador1 = hacerJugada(jugada1, jugador1, pJugador1, random, pJugador2, pJugador1);
                pJugador2 = hacerJugada(jugada2, jugador2, pJugador2, random, pJugador1, pJugador2);
            }
            System.out.println("Puntaje final:");
            System.out.println(jugador1 + ": " + pJugador1 + " puntos");
            System.out.println(jugador2 + ": " + pJugador2 + " puntos");

            if (pJugador1 > pJugador2) {
                System.out.println(jugador1 + " es el ganador");
            } else if (pJugador1 < pJugador2) {
                System.out.println(jugador2 + " es el ganador");
            } else {
                System.out.println("¡Es un empate!");
            }
        }else{
            System.out.println("El número de turnos tiene que ser mayor o igual a 1");
        }
    }

    /* Metodo donde se evalua qué jugada haran los jugadores en el juego de basketball */
    static int hacerJugada(int accion1, String jugador, int puntajeJugador, Random random, int puntajeOponente, int pJugador1){
        int puntajeJugadorNuevo = puntajeJugador;
        int probaLargo = random.nextInt(100);
        int probaCorto = random.nextInt(100);
        int probaFuerte = random.nextInt(100);
        int probaCuerpo = random.nextInt(100);
        switch (accion1) {
            case 1:
                if (probaLargo <= 65) {
                    puntajeJugadorNuevo = puntajeJugador +3;
                    System.out.println(jugador + " anota 3 puntos");
                } else {
                    System.out.println(jugador + " fallo el salto largo");
                }
                break;

            case 2:
                if (probaCorto <= 80) {
                    puntajeJugadorNuevo = puntajeJugador + 2;
                    System.out.println(jugador + " anota 2 puntos");
                } else {
                    System.out.println(jugador + " fallo el salto corto");
                }
                break;

            case 3:
                if (probaCuerpo <= 35) {
                    System.out.println(jugador + " hace una falta");
                    if (random.nextInt(100) < 90) { /*Aca se simula el tiro libre*/
                        puntajeOponente += 2;
                        System.out.println(jugador + " anota 2 puntos desde el tiro libre");
                    } else {
                        System.out.println(jugador + " falla el tiro libre");
                    }
                } else {
                    System.out.println(jugador + " defensa efectiva");
                }
                break;
            case 4:
                if (probaFuerte <= 65) {
                    System.out.println(jugador + " hace una falta");
                    if (random.nextInt(100) < 90) { 
                        puntajeOponente += 2;
                        System.out.println(jugador + " anota 2 puntos desde el tiro libre");
                    } else {
                        System.out.println(jugador + " falla el tiro libre");
                    }
                } else {
                    System.out.println(jugador + " defensa fuerte efectiva");
                }
                break;



            default:
                System.out.println("Opción incorrecta");
        }
        return puntajeJugadorNuevo;
    }

    static void juego2048(){
        inicio2048++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Instrucciones: El juego consiste en un tablero de 4x4 que ira generando numeros aleatorios entre 2 y 4 \n" +
                "el objetivo es que alguna casilla logre tener el valor de 2048 y esto se logra colisionando dos casillas con el mismo numero \n" +
                "esto durante el mismo movimiento, cuya suma sera el equivalente a la suma de los numeros de las casillas con los numeros originales, \n" +
                "no obstante la casilla resultante no se podra combinar con otra casilla en el mismo turno");
        System.out.println();
        System.out.println("El jugador puede mover la totalidad de las casillas del tablero hacia arriba(w), abajo (s), derecha (d) o\n" +
                "izquierda (a).\n" +
                "Se pierde cuando ya no existan movimientos posibles");
        System.out.println("Bienvenido al juego 2048 ");
        inicializarTablero();
        dibujarTablero(tablero);
        boolean seguirJugando = true;

        while (seguirJugando){
            System.out.println("Que movimiento desea realizar: ");
            System.out.println("Presione 'a' para mover hacia la izquierda: ");
            System.out.println("Presione 'd' para mover hacia la derecha: ");
            System.out.println("Presione 'w' para mover hacia la arriba: ");
            System.out.println("Presione 's' para mover hacia la abajo: ");
            char movimiento = scanner.next().charAt(0);
            if (movimiento == 'a') {
                moverIzquierda();
                dibujarTablero(tablero);
            } else if (movimiento == 'd'){
                moverDerecha();
                dibujarTablero(tablero);
            }else if (movimiento == 'w'){
                moverArriba();
                dibujarTablero(tablero);
            } else if (movimiento == 's') {
                moverAbajo();
                dibujarTablero(tablero);
            }else {
                System.out.println("Movimiento no válido.");
            }

            if (tablerotiene2048()) {
                ganar2048++;
                System.out.println("Felicidades has llegado a 2048");

            } else if (!hayMovimientosDisponibles()) {
                System.out.println("No hay más movimientos disponibles. Fin del juego.");
            }else {
                numeroAleatorio();
            }
            System.out.println("¿Desea seguir jugando? (s/n)");
            char continuar = scanner.next().charAt(0);
            if (continuar == 'n') {
                terminar2048++;
                seguirJugando = false;
            }
        }
    }

    /* Metodo que sirve para iniciar el tablero de 2048 con los números aleatorios,
    este metodo contiene los metodos de numeroAleatorio que se ha realizado por aparte
    */
    static void inicializarTablero() {
        numeroAleatorio();
        numeroAleatorio();
    }

    static void dibujarTablero(int [][] tablero) {
        Random random = new Random();
        int filaAleatoria;
        filaAleatoria = random.nextInt(tablero.length); 
        int columnaAleatoria;
        columnaAleatoria = random.nextInt(tablero[0].length);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != 0) {
                    System.out.print("| " + tablero[i][j] + " ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
            while (tablero[filaAleatoria][columnaAleatoria] != 0) {
                filaAleatoria = random.nextInt(tablero.length);
                columnaAleatoria = random.nextInt(tablero[0].length);
            }
        }
    }

    static void numeroAleatorio(){
        Random random = new Random();
        int filaAleatoria;
        int columnaAleatoria;

        do {
            filaAleatoria = random.nextInt(tablero.length); 
            columnaAleatoria = random.nextInt(tablero[0].length); 
        } while (tablero[filaAleatoria][columnaAleatoria] != 0); /*En esta parte se generan posiciones aleatorias hasta encontrar una vacía*/
        /*En esta parte se hace la probablidad de que aparezca un numero entre 2 y 4*/
        tablero[filaAleatoria][columnaAleatoria] = (random.nextDouble() < 0.9) ? 2 : 4;
    }

    static void moverIzquierda() {
        for (int i = 0; i < tablero.length; i++) {
            int posicionVacia = 0; 

            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != 0) {
                    tablero[i][posicionVacia] = tablero[i][j];
                    if (j != posicionVacia) {
                        tablero[i][j] = 0; 
                    }
                    posicionVacia++;
                }
            }

            
            for (int j = 0; j < tablero[i].length - 1; j++) {
                if (tablero[i][j] == tablero[i][j + 1]) {
                    tablero[i][j] *= 2; 
                    tablero[i][j + 1] = 0; 
                }
            }

           
            posicionVacia = 0;
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != 0) {
                    tablero[i][posicionVacia] = tablero[i][j];
                    if (j != posicionVacia) {
                        tablero[i][j] = 0; 
                    }
                    posicionVacia++;
                }
            }
        }
    }

    static void moverDerecha() {
        for (int i = 0; i < tablero.length; i++) {
            int posicionVacia = tablero[i].length - 1; 


            for (int j = tablero[i].length - 1; j >= 0; j--) {
                if (tablero[i][j] != 0) {
                   
                    tablero[i][posicionVacia] = tablero[i][j];
                    if (j != posicionVacia) {
                        tablero[i][j] = 0; 
                    }
                    posicionVacia--;
                }
            }

           
            for (int j = tablero[i].length - 1; j > 0; j--) {
                if (tablero[i][j] == tablero[i][j - 1]) {
                    tablero[i][j] *= 2; 
                    tablero[i][j - 1] = 0; 
                }
            }

            
            posicionVacia = tablero[i].length - 1;
            for (int j = tablero[i].length - 1; j >= 0; j--) {
                if (tablero[i][j] != 0) {
                    tablero[i][posicionVacia] = tablero[i][j];
                    if (j != posicionVacia) {
                        tablero[i][j] = 0; 
                    }
                    posicionVacia--;
                }
            }
        }
    }

    static void moverArriba() {
        for (int j = 0; j < tablero[0].length; j++) {
            int posicionVacia = 0; 

            
            for (int i = 0; i < tablero.length; i++) {
                if (tablero[i][j] != 0) {
                   
                    tablero[posicionVacia][j] = tablero[i][j];
                    if (i != posicionVacia) {
                        tablero[i][j] = 0; 
                    }
                    posicionVacia++;
                }
            }

            /* En esta parte se hace la suma de los números que son iguales en las casillas */
            for (int i = 0; i < tablero.length - 1; i++) {
                if (tablero[i][j] == tablero[i + 1][j]) {
                    tablero[i][j] *= 2; /* En esta parte se depublica el número que se ha unido */
                    tablero[i + 1][j] = 0; /*En esta parte se limpia la casilla */
                }
            }

            /*En esta parte manda los números hacia arriba para llenar alguna casilla vacia */
            posicionVacia = 0;
            for (int i = 0; i < tablero.length; i++) {
                if (tablero[i][j] != 0) {
                    tablero[posicionVacia][j] = tablero[i][j];
                    if (i != posicionVacia) {
                        tablero[i][j] = 0; 
                    }
                    posicionVacia++;
                }
            }
        }
    }

    static void moverAbajo() {
        for (int j = 0; j < tablero[0].length; j++) {
            int posicionVacia = tablero.length - 1; /*Aca se busca una casilla vacia*/

           
            for (int i = tablero.length - 1; i >= 0; i--) {
                if (tablero[i][j] != 0) {
                    /* Si el número no es cero lo desplazamos a la posición vacía*/
                    tablero[posicionVacia][j] = tablero[i][j];
                    if (i != posicionVacia) {
                        tablero[i][j] = 0; 
                    }
                    posicionVacia--;
                }
            }

            // Combinar números adyacentes que tengan el mismo valor
            for (int i = tablero.length - 1; i > 0; i--) {
                if (tablero[i][j] == tablero[i - 1][j]) {
                    tablero[i][j] *= 2; // Duplicar el número
                    tablero[i - 1][j] = 0; // Limpiar la posición anterior
                }
            }

        
            posicionVacia = tablero.length - 1;
            for (int i = tablero.length - 1; i >= 0; i--) {
                if (tablero[i][j] != 0) {
                    tablero[posicionVacia][j] = tablero[i][j];
                    if (i != posicionVacia) {
                        tablero[i][j] = 0; 
                    }
                    posicionVacia--;
                }
            }
        }
    }

    static boolean tablerotiene2048() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean hayMovimientosDisponibles() {
        /* En esta parte se busca algun espacio vacio del tablero*/
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == 0) {
                    return true;
                }
            }
        }

        /*En esta parte busca dos números iguales en una fila o columna */
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length - 1; j++) {
                if (tablero[i][j] == tablero[i][j + 1] || tablero[j][i] == tablero[j + 1][i]) {
                    return true;
                }
            }
        }

        return false;
    }
}
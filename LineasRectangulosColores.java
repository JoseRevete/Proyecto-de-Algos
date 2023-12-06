import java.util.Scanner;
import java.awt.Font;

public class LineasRectangulosColores {

    // ejecucion del juego
    //@ requires true;
    //@ ensures true;
    public static void main(String[] args) {
        inicializarJuego();

        // Dibujo de tablero
        MaquinaDeTrazados mt = new MaquinaDeTrazados(700,700, "Juego Tablero", Colores.DARK_GRAY);
        mt.dibujarOvaloLleno(mt.XMAX/2 - 150, mt.YMAX/2 -150, mt.XMAX, mt.YMAX, Colores.GRAY);
        mt.dibujarOvaloLleno(mt.XMAX/2 - 110, mt.YMAX/2 -110, mt.XMAX, mt.YMAX, Colores.BLACK);
        mt.dibujarOvaloLleno(mt.XMAX/2 - 80, mt.YMAX/2 - 80, mt.XMAX, mt.YMAX, Colores.DARK_GRAY);
        mt.dibujarOvaloLleno(mt.XMAX/2 - 40, mt.YMAX/2 - 40, mt.XMAX, mt.YMAX, Colores.GRAY);
        mt.configurarFuente("Monospaced", Font.PLAIN, 24);

        mt.dibujarRectanguloLleno(40,20, 20, 180, Colores.BLACK);
        mt.dibujarRectanguloLleno(40, 180, 100, 20, Colores.BLACK);
        mt.dibujarRectanguloLleno(30,30, 20, 180, Colores.RED);
        mt.dibujarRectanguloLleno(30, 190, 100, 20, Colores.RED);

        mt.dibujarRectanguloLleno(40,240, 20, 180, Colores.BLACK);
        mt.dibujarRectanguloLleno(40, 240, 100, 20, Colores.BLACK);
        mt.dibujarRectanguloLleno(40, 400, 100, 20, Colores.BLACK);
        mt.dibujarRectanguloLleno(30,250, 20, 180, Colores.RED);
        mt.dibujarRectanguloLleno(30, 250, 100, 20, Colores.RED);
        mt.dibujarRectanguloLleno(30, 410, 100, 20, Colores.RED);

        mt.dibujarRectanguloLleno(40, 460, 20, 180, Colores.BLACK);
        mt.dibujarRectanguloLleno(40, 460, 100, 20, Colores.BLACK);
        mt.dibujarRectanguloLleno(40, 530, 100, 20, Colores.BLACK);
        mt.dibujarRectanguloLleno(120, 460, 20, 70, Colores.BLACK);
        int[] xx = {80, 120, 140, 100};
        int[] yy = {550, 640, 640, 550};
        mt.dibujarPoligonoLleno(xx, yy, 4, Colores.BLACK);
        mt.dibujarRectanguloLleno(30, 470, 20, 180, Colores.RED);
        mt.dibujarRectanguloLleno(30, 470, 100, 20, Colores.RED);
        mt.dibujarRectanguloLleno(30, 540, 100, 20, Colores.RED);
        mt.dibujarRectanguloLleno(110, 470, 20, 70, Colores.RED);
        int[] x = {70, 110, 130, 90};
        int[] y = {560, 650, 650, 560};
        mt.dibujarPoligonoLleno(x, y, 4, Colores.RED);

        int valor = 0;
        if (mt.XMAX >= mt.YMAX) {valor = mt.YMAX*70/100;}
        else {valor = mt.XMAX*70/100;}
        mt.dibujarRectanguloLleno(mt.XMAX/2 - valor/2 + valor/6 - valor/60, mt.YMAX/2 - valor/2 + valor/6 - valor/60, valor + valor/30, valor + valor/30, Colores.BLACK);
        mt.dibujarRectanguloLleno(mt.XMAX/2 - valor/2 + valor/6, mt.YMAX/2 - valor/2 + valor/6, valor, valor, Colores.WHITE);
        int valorx = mt.XMAX/2 - valor/2 + valor/6;
        int valory = mt.YMAX/2 - valor/2 + valor/6;
        casillasTableroHorizontal(mt, valorx, valory, valor);
        casillasTableroVertical(mt, valorx, valory, valor);
        int puntaje = 0 ;
        int[] tableroPosicionesX = new int[9];
        int i = 0;
        int j;

        // Posicion de cada casilla del tablero en x y y
        while (tableroPosicionesX.length > i) {
            tableroPosicionesX[i] = valorx;
            valorx += valor/9;
            i++;}
        
        int[] tableroPosicionesY = new int[9];
        i = 0;
        while (tableroPosicionesY.length > i) {
            tableroPosicionesY[i] = valory;
            valory += valor/9;
            i++;}
        

        // tablero principal
        int[][] tablero = new int[9][9];
        i = 0;
        while (tablero.length > i) {
            j = 0;
            while (tablero[i].length > j) {
                tablero[i][j] = 0;
                j++;}
            i++;}

        // del 1 al 6 son los circulos, el 7 es el cuadrado
        // 1 es azul, 2 rojo, 3, amarillo, 4 verde, 5 rosado, 6 naranja
        // 7 es el cuadrado magenta
        int[] piezas = {1,2,3,4,5,6,7};
        int[][] primeras3Piezas = inicializarTablero(piezas, tablero);
        boolean repetir = true;
        // comprobacion de que las 3 primera piezas son distintas, de ser iguales, se repite
        while ( repetir == true) {
            if (primeras3Piezas[0][1] == primeras3Piezas[1][1] && primeras3Piezas[0][2] == primeras3Piezas[1][2]) {primeras3Piezas = inicializarTablero(piezas, tablero);}
            else if (primeras3Piezas[0][1] == primeras3Piezas[2][1] && primeras3Piezas[0][2] == primeras3Piezas[2][2]) {primeras3Piezas = inicializarTablero(piezas, tablero);}
            else if (primeras3Piezas[1][1] == primeras3Piezas[2][1] && primeras3Piezas[1][2] == primeras3Piezas[2][2]) {primeras3Piezas = inicializarTablero(piezas, tablero);}
            else {repetir = false;}
        }

        i = 0;
        // dibujando primeras piezas
        while (primeras3Piezas.length > i) {
            Colores color;
            if (primeras3Piezas[i][0] == 1) {color = Colores.BLUE;}
            else if (primeras3Piezas[i][0] == 2) {color = Colores.RED;}
            else if (primeras3Piezas[i][0] == 3) {color = Colores.YELLOW;}
            else if (primeras3Piezas[i][0] == 4) {color = Colores.GREEN;}
            else if (primeras3Piezas[i][0] == 5) {color = Colores.PINK;}
            else if (primeras3Piezas[i][0] == 6) {color = Colores.ORANGE;}
            else {color = Colores.MAGENTA;}

            if (primeras3Piezas[i][0] == 7) { mt.dibujarRectanguloLleno(tableroPosicionesX[primeras3Piezas[i][1]], tableroPosicionesY[primeras3Piezas[i][2]], valor/9, valor/9, color);}
            else {mt.dibujarOvaloLleno(tableroPosicionesX[primeras3Piezas[i][1]], tableroPosicionesY[primeras3Piezas[i][2]], valor/9, valor/9, color);}
            mt.mostrar();
            tablero[primeras3Piezas[i][1]][primeras3Piezas[i][2]]=primeras3Piezas[i][0];
            i++;}

        // dibujar puntaje
        valorx = mt.XMAX/2 - valor/2 + valor/6;
        valory = mt.YMAX/2 - valor/2 + valor/6;
        mt.dibujarString("Puntaje:", valorx + valor/2 + valor/6, valory - valor/3 + 15);
        mt.dibujarString(""+puntaje, valorx + valor/2 + valor/6 + valor/9, valory - valor/7- valor/25);
        int[] proximosObjetos = obtenerProximosObjetos(mt, piezas, valor);
        mt.mostrar();
        
        // movimientos en el juego y acciones
        int[][] nuevoTablero = tablero;
        boolean finalizarJuego = true;
        while (finalizarJuego == true) {
            nuevoTablero = obtenerJugadaValida(mt, nuevoTablero, tableroPosicionesX, tableroPosicionesY, valor, valorx, valory);
            if (nuevoTablero[0][0] == -1) {System.out.println("Numero de intentos excedidos. Gracias por jugar."); finalizarJuego = false;}
            else {
                if (tableroLleno(nuevoTablero) == true) {System.out.println("El juego ha acabado, el tablero esta lleno. Gracias por jugar"); break;}
                else {
                    nuevoTablero = agregarProximosObjetos(mt, nuevoTablero, proximosObjetos, valor, tableroPosicionesX, tableroPosicionesY, valorx, valory);
                    proximosObjetos = obtenerProximosObjetos(mt, piezas, valor);
                    if (tableroLleno(nuevoTablero) == true) {System.out.println("El juego ha acabado, el tablero esta lleno. Gracias por jugar"); break;}
                }
            }
            mt.repintar();
        }
        mt.terminar();
    }

    // Metodo para saludar y dar la bienvenida al usuario
    //@ requires true;
    //@ ensures \result != null;
    public static /*@ pure*/ String inicializarJuego() {
        System.out.println("¡Bienvenido a Lineas de colores y rectangulos!");
        System.out.println("Por favor ingrese su nombre: ");
        Scanner leer = new Scanner (System.in);
        String jugador = leer.nextLine();
        System.out.println("Hola " + jugador + ".");
        System.out.println("El juego consiste en ir moviendo los circulos y cuadrados para formar lineas de 5 circulos (o mayor) o cuadrados de tamaño 2x2 (o mayor), respectivamente.");
        System.out.println("Solo lo debe mover a una casilla en donde no hayan circulos ni cuadrados. Para poder moverlos, este debe tener a su alrededor al menos un espacio libre de circulos y cuadrados");
        System.out.println("Solo puede seleccionar casillas (para mover un objeto desde dicha casilla a otra) si tiene un objeto en ella");
        System.out.println("Se suman puntos cuando alinie de forma horizontal, vertical o diagonal 5 circulos (o mas), o cuando se formen cuadrados de 2x2 (o mayores)");
        System.out.println("La tabla de puntaje es:");
        System.out.println("    ");
        System.out.println(" Número de objetos alineados | Puntos que se obtienen ");
        System.out.println("------------------------------------------------------");
        System.out.println("              4              |             5          ");
        System.out.println("              5              |             10         ");
        System.out.println("              6              |             12         ");
        System.out.println("              7              |             18         ");
        System.out.println("           8 o mas           |             40         ");
        System.out.println("   ");
        System.out.println("Las coordenadas de las casillas se deben dar de la forma numero de columna ---> ejecutar ---> numero de fila. De forma contraria, dara error");
        System.out.println("Disfrute el juego :)");
        return jugador;
    }

    // Metodo para mostrar tablero y piezas
    //@ requires (\forall int i ; 0 <= i && i < piezas.length ; piezas[i] >= 1 && piezas[i] <= 7);
    //@ requires (\forall int i ; 0 <= i && i < tablero.length ; (\forall int j ; 0 <= j && j < tablero[i].length ; tablero[i][j] == 0));
    //@ ensures (\exists int i ; 0 <= i && i < tablero.length ; (\exists int j ; 0 <= j && j < tablero[i].length ; tablero[i][j] == 0));
    public static /*@ pure */ int[][] inicializarTablero(int[] piezas, int[][] tablero) {
        int[][] tableroModificado = new int[3][3];
        int i = 0;
        //@ maintaining tableroModificado.length >= i;
        //@ decreases tableroModificado.length - i;
        while (tableroModificado.length > i) {
            int j = 0;
            //@ maintaining tableroModificado[i].length >= j;
            //@ decreases tableroModificado[i].length - j;
            while (tableroModificado[i].length > j) {
                int piezacoordenada = 0;
                if (j == 0) {piezacoordenada = (int) (Math.random()*piezas.length+1);}
                else if (j == 1) {piezacoordenada = (int) (Math.random()*tablero.length);}
                else {piezacoordenada = (int) (Math.random()*tablero.length);}
                tableroModificado[i][j] = piezacoordenada;
                j++;}
            i++;}
        return tableroModificado;
    }

    // Metodo para dibujar las lineas horizontales del tablero
    //@ requires valorx >= 0;
    //@ requires valory >= 0;
    //@ requires valor >= 0;
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ ensures true;
    public static /*@ pure */ void casillasTableroHorizontal(MaquinaDeTrazados mt, int valorx, int valory, int valor) {
        //@ assume valory + valor/15 < Integer.MAX_VALUE;
        mt.dibujarString("0", valorx - valor/15, valory + valor/15);
        int desplazamientoy = valor/9;
        //@ assume valory + desplazamientoy  < Integer.MAX_VALUE;
        //@ assume valory + valor/15 + desplazamientoy < Integer.MAX_VALUE;
        //@ assume valorx + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("1", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        //@ assume valory + desplazamientoy  < Integer.MAX_VALUE;
        //@ assume valory + valor/15 + desplazamientoy < Integer.MAX_VALUE;
        //@ assume valorx + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("2", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        //@ assume valory + desplazamientoy  < Integer.MAX_VALUE;
        //@ assume valory + valor/15 + desplazamientoy < Integer.MAX_VALUE;
        //@ assume valorx + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("3", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        //@ assume valory + desplazamientoy  < Integer.MAX_VALUE;
        //@ assume valory + valor/15 + desplazamientoy < Integer.MAX_VALUE;
        //@ assume valorx + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("4", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        //@ assume valory + desplazamientoy  < Integer.MAX_VALUE;
        //@ assume valory + valor/15 + desplazamientoy < Integer.MAX_VALUE;
        //@ assume valorx + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("5", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        //@ assume valory + desplazamientoy  < Integer.MAX_VALUE;
        //@ assume valory + valor/15 + desplazamientoy < Integer.MAX_VALUE;
        //@ assume valorx + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("6", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        //@ assume valory + desplazamientoy  < Integer.MAX_VALUE;
        //@ assume valory + valor/15 + desplazamientoy < Integer.MAX_VALUE;
        //@ assume valorx + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("7", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        //@ assume valory + desplazamientoy  < Integer.MAX_VALUE;
        //@ assume valory + valor/15 + desplazamientoy < Integer.MAX_VALUE;
        //@ assume valorx + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("8", valorx - valor/15, valory + valor/15 + desplazamientoy);
    }

    // Metodo para dibujar las lineas verticales del tablero
    //@ requires valorx >= 0;
    //@ requires valory >= 0;
    //@ requires valor >= 0;
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ ensures true;
    public static /*@ pure */ void casillasTableroVertical(MaquinaDeTrazados mt, int valorx, int valory, int valor) {
        //@ assume  valorx + valor/24 < Integer.MAX_VALUE;
        mt.dibujarString("0", valorx + valor/24, valory - valor/24);
        int desplazamientox = valor/9;
        //@ assume  valorx + valor/24 + desplazamientox < Integer.MAX_VALUE;
        //@ assume  valorx + desplazamientox < Integer.MAX_VALUE;
        //@ assume valory + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("1", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        //@ assume  valorx + valor/24 + desplazamientox < Integer.MAX_VALUE;
        //@ assume  valorx + desplazamientox < Integer.MAX_VALUE;
        //@ assume valory + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("2", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        //@ assume  valorx + valor/24 + desplazamientox < Integer.MAX_VALUE;
        //@ assume  valorx + desplazamientox < Integer.MAX_VALUE;
        //@ assume valory + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("3", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        //@ assume  valorx + valor/24 + desplazamientox < Integer.MAX_VALUE;
        //@ assume  valorx + desplazamientox < Integer.MAX_VALUE;
        //@ assume valory + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("4", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        //@ assume  valorx + valor/24 + desplazamientox < Integer.MAX_VALUE;
        //@ assume  valorx + desplazamientox < Integer.MAX_VALUE;
        //@ assume valory + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("5", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        //@ assume  valorx + valor/24 + desplazamientox < Integer.MAX_VALUE;
        //@ assume  valorx + desplazamientox < Integer.MAX_VALUE;
        //@ assume valory + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("6", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        //@ assume  valorx + valor/24 + desplazamientox < Integer.MAX_VALUE;
        //@ assume  valorx + desplazamientox < Integer.MAX_VALUE;
        //@ assume valory + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("7", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        //@ assume  valorx + valor/24 + desplazamientox < Integer.MAX_VALUE;
        //@ assume  valorx + desplazamientox < Integer.MAX_VALUE;
        //@ assume valory + valor < Integer.MAX_VALUE;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("8", valorx + valor/24 + desplazamientox, valory - valor/24);
    }

    // Metodo para elegir y dibujar proximos objetos del tablero
    //@ requires valor >= 0;
    //@ requires (\forall int i ; 0 <= i && i < piezas.length ; piezas[i]==i+1);
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ ensures (\forall int i ; 0 <= i && i < \result.length ; \result[i] > 0 && \result[i] < 9);
    public static /*@ pure */ int[]  obtenerProximosObjetos(MaquinaDeTrazados mt, int[] piezas, int valor) {
        int[] piezasProximas = new int[3];
        piezasProximas[0] = (int) (Math.random()*piezas.length+1);
        piezasProximas[1] = (int) (Math.random()*piezas.length+1);
        piezasProximas[2] = (int) (Math.random()*piezas.length+1);
        int desplazamiento = valor/18;
        mt.dibujarString("PROXIMOS:", mt.XMAX/20 + valor/4 + desplazamiento, mt.YMAX/10 - mt.YMAX/20);
        int i = 0;
        //@ maintaining piezasProximas.length >= i;
        //@ decreases piezasProximas.length - i;
        while (piezasProximas.length > i) {
            Colores color;
            if (piezasProximas[i] == 1) {color = Colores.BLUE;}
            else if (piezasProximas[i] == 2) {color = Colores.RED;}
            else if (piezasProximas[i] == 3) {color = Colores.YELLOW;}
            else if (piezasProximas[i] == 4) {color = Colores.GREEN;}
            else if (piezasProximas[i] == 5) {color = Colores.PINK;}
            else if (piezasProximas[i] == 6) {color = Colores.ORANGE;}
            else {color = Colores.MAGENTA;}
            if (piezasProximas[i] == 7) { mt.dibujarRectanguloLleno(mt.XMAX/20 + valor/4 + desplazamiento, mt.YMAX/10, valor/9, valor/9, color);}
            else {mt.dibujarOvaloLleno(mt.XMAX/20 + valor/4 + desplazamiento, mt.YMAX/10, valor/9, valor/9, color);}
            desplazamiento = desplazamiento + valor/18 + valor/9;
            i++;}
        return piezasProximas;
    }

    // Metodo para agregar los objetos que estaban proximos a agregar en el tablero
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ requires valorx >= 0;
    //@ requires valory >= 0;
    //@ requires valor >= 0;
    //@ requires (\forall int i ; 0 <= i && i < proximosObjetos.length ; proximosObjetos[i] > 0 && proximosObjetos[i] < 9);
    //@ requires tableroPosicionesX.length == 9;
    //@ requires tableroPosicionesY.length == 9;
    //@ requires nuevoTablero.length == 9 && (\forall int i ; 0 <= i && i < nuevoTablero.length ; nuevoTablero[i].length == 9);
    //@ ensures (\forall int k ; 0 <= k && k < proximosObjetos.length ; (\forall int i ; 0 <= i && i < \result.length ; (\exists int j ; 0 <= i && i < \result[i].length ; \result[i][j] == proximosObjetos[k]))) || !(\forall int k ; 0 <= k && k < proximosObjetos.length ; (\forall int i ; 0 <= i && i < \result.length ; (\exists int j ; 0 <= i && i < \result[i].length ; \result[i][j] == proximosObjetos[k])));
    public static /*@ pure */ int[][] agregarProximosObjetos(MaquinaDeTrazados mt, int[][] nuevoTablero, int[] proximosObjetos, int valor, int[] tableroPosicionesX, int[] tableroPosicionesY, int valorx, int valory) {
        int i = 0;
        int h = 0;
        int[][] tablero = nuevoTablero;
        mt.dibujarRectanguloLleno(mt.XMAX/20 + valor/4 + valor/18, mt.YMAX/10 - mt.YMAX/15, valor/2 , valor/4, Colores.DARK_GRAY);
        //@ maintaining i <= proximosObjetos.length;
        //@ decreases 1000 - h;
        while (i < proximosObjetos.length) {
            int x = (int) (Math.random()*nuevoTablero.length);
            int y = (int) (Math.random()*nuevoTablero.length);
            if (tablero[x][y] == 0) {
                tablero[x][y] = proximosObjetos[i];
                dibujarLosProximosObjetos(mt, proximosObjetos[i], x, y, valor, tableroPosicionesX, tableroPosicionesY, nuevoTablero);
                i++;}
            else {}
            h++;
        }
        casillasTableroHorizontal(mt, valorx, valory, valor);
        casillasTableroVertical(mt, valorx, valory, valor);
        return tablero;
    }

    // Metodo para pedir al usuario coordenadas de la casilla del objeto
    //@ requires true;
    //@ ensures (\result >= 0 && \result <= 8) || (\result == -1);
    public static /*@ pure */ int pedirCoordenada(){
        Scanner leer = new Scanner (System.in);
        int coordenada = leer.nextInt();
        int a = 0;
        //@ maintaining 4 >= a;
        //@ decreases 4 - a;
        while (4 > a) {
            if (0 <= coordenada && coordenada <= 8) {break;}
            else {
                System.out.println("Coordenada invalida, intente de nuevo");
                leer = new Scanner (System.in);
                coordenada = leer.nextInt(); 
                a++;
            }
        }
        // si a >= 4, significa que el usuario excedio el limite de intentos. -1 es solo para identificar esto
        if (a >= 4) {coordenada = -1;}
        else {}
        return coordenada;
    }

	// Metodo para verificar si la jugada es valida
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ requires valorx >= 0;
    //@ requires valory >= 0;
    //@ requires valor >= 0;
    //@ requires tableroPosicionesX.length == 9;
    //@ requires tableroPosicionesY.length == 9;
    //@ requires tablero.length == 9 && (\forall int i ; 0 <= i && i < tablero.length ; tablero[i].length == 9);
    //@ ensures (\result[0][0] == -1) || (\result[0][0] != -1);
    public static /*@ pure */ int[][] obtenerJugadaValida(MaquinaDeTrazados mt, int[][] tablero, int[] tableroPosicionesX, int[] tableroPosicionesY, int valor, int valorx, int valory){
        int[][] nuevoTablero = tablero;
        int q = 0;
        boolean comprobarJugadaValida = false;
        int u = 0;
        int coordenada1 = 0;
        int coordenada2 = 0;
        //@ maintaining 9 >= u;
        //@ decreases 9 - u;
        while ( u < 6) {
            q = 0;
            //@ maintaining 5 >= q;
            //@ decreases 5 - q;
            while (4 > q) {
            System.out.println("Debe ingresar la coordenada origen de su figura a mover");
            System.out.println("Por favor ingrese el numero de columna de la figura a mover: ");
            coordenada1 = pedirCoordenada();
            // si devuelve -1, se rompe el while
            if (coordenada1 == -1) {u = 6; break;}
            else {}
            System.out.println("Por favor ingrese el numero de fila de la figura a mover: ");
            coordenada2 = pedirCoordenada();
            // si devuelve -1, se rompe el while
            if (coordenada2 == -1) {u = 6; break;}
            else {}
            // si la coordenada dada contiene un objeto, se pocede
            if (tablero[coordenada1][coordenada2] != 0) {
                int h = 0;
                comprobarJugadaValida =true;
                //@ maintaining 7 >= h;
                //@ decreases 7 - h;
                while (6 > h) {
                    // se evaluan los casos de dificultad para ver si el objeto se puede mover
                    if (coordenada1 == 8 && coordenada2 == 8) {
                        if (tablero[7][7] == 0 || tablero[7][8] == 0 || tablero[8][7] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 0 && coordenada2 == 0) {
                        if (tablero[0][1] == 0 || tablero[1][1] == 0 || tablero[1][0] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 0 && coordenada2 == 8) {
                        if (tablero[0][7] == 0 || tablero[1][7] == 0 || tablero[1][8] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 8 && coordenada2 == 0) {
                        if (tablero[7][1] == 0 || tablero[8][1] == 0 || tablero[7][0] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 8 && coordenada2 != 0) {
                        if (tablero[8][coordenada2 -1] == 0 || tablero[8][coordenada2 +1] == 0 || tablero[7][coordenada2 -1] == 0 || tablero[7][coordenada2] == 0 || tablero[7][coordenada2 +1] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 != 0 && coordenada2 == 8) {
                        if (tablero[coordenada1-1][7] == 0 || tablero[coordenada1-1][8] == 0 || tablero[coordenada1][7] == 0 || tablero[coordenada1+1][7] == 0 || tablero[coordenada1+1][8] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 0 && coordenada2 != 0) {
                        if (tablero[0][coordenada2 -1] == 0 || tablero[0][coordenada2 +1] == 0 || tablero[1][coordenada2 -1] == 0 || tablero[1][coordenada2] == 0 || tablero[1][coordenada2 +1] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 != 0 && coordenada2 == 0) {
                        if (tablero[coordenada1-1][0] == 0 || tablero[coordenada1-1][1] == 0 || tablero[coordenada1][1] == 0 || tablero[coordenada1+1][0] == 0 || tablero[coordenada1+1][1] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else {
                        int coord1 = coordenada1 - 1;
                        comprobarJugadaValida = false;
                        int i = 0;
                        //@ maintaining 3 >= i;
                        //@ decreases 3 - i;
                        while (3 > i) {
                            int j = 0;
                            int coord2 = coordenada2 - 1;
                            if (comprobarJugadaValida == true) {h=7;break;}
                            //@ maintaining 3 >= j;
                            //@ decreases 3 - j;
                            while ( 3 > j ){
                                if (tablero[coord1][coord2] == 0) {comprobarJugadaValida = true;h=7;break;}
                                else
                                coord2++;
                                j++;}
                            coord1++;
                            i++;}
                        break;}
                        h++;
                }
                if (comprobarJugadaValida == true) {q=5;}
                else {q++;System.out.println("La jugada que intenta realizar no es valida, el objeto se encuentra rodeado de otros obejtos. Intente de nuevo");}
            }
            else {System.out.println("La posicion que indicas en que cual esta el objeto que intentas mover esta vacia. Intenta de nuevo");q++;}
            }
            if(q < 5) {u=6; break;}
            else {}

            q = 0;
            //@ maintaining 5 >= q;
            //@ decreases 5 - q;
            while (4 > q) {
            if (comprobarJugadaValida == true) {
                System.out.println("Ahora debe ingresar la coordenada destino de su figura a mover");
                System.out.println("Por favor ingrese el numero destino de columna de la figura a mover: ");
		    	int coordenada3 = pedirCoordenada();
                // si devuelve -1, se rompe el while
                if (coordenada3 == -1) {u = 6; break;}
                else {}
                System.out.println("Por favor ingrese el numero destino de fila de la figura a mover: ");
                int coordenada4 = pedirCoordenada();
                // si devuelve -1, se rompe el while
                if (coordenada4 == -1) {u = 6; break;}
                else {}
                // si la coordenada dada en el tablero es 0, significa que no hay objetos
                if (tablero[coordenada3][coordenada4] == 0) {
                    nuevoTablero[coordenada3][coordenada4] = tablero[coordenada1][coordenada2];
                    nuevoTablero[coordenada1][coordenada2] = 0;
                    mt.dibujarRectanguloLleno(tableroPosicionesX[coordenada1], tableroPosicionesY[coordenada2], valor/9, valor/9, Colores.WHITE);
                    dibujarAlMover(mt,coordenada3,coordenada4,valor,tableroPosicionesX,tableroPosicionesY,nuevoTablero);
                    casillasTableroHorizontal(mt, valorx, valory, valor);
                    casillasTableroVertical(mt, valorx, valory, valor);
                    q=5;
                    u=8;
                    break;
                }
                else {System.out.println("La coordenada destino que esta planteando ya se encuentra ocupada por un objeto. Intente de nuevo");q++;}
            }
            else {System.out.println("La jugada que intenta realizar no es valida, el objeto se encuentra rodeado de otros objetos. Intente de nuevo");q++;}
            }
            if(q < 5) {u=6; break;}
            else {break;}
        }
        // si u < 8 significa que se excedio el numero de intentos para registrar una coordenada correcta. -1 es para identificar que esto sucedio
        if (u < 8) {System.out.println("Excedio el numero maximo de intentos"); nuevoTablero[0][0] = -1;}
        else {System.out.println("El cambio ha sido realizado con exito");}
        return nuevoTablero;
    }

    // Metodo para dibujar el movimiento de objeto en el tablero
    //@ requires coordenada3 >= 0 && coordenada3 <= 8;
    //@ requires coordenada4 >= 0 && coordenada4 <= 8;
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ requires valor >= 0;
    //@ requires tableroPosicionesX.length == 9;
    //@ requires tableroPosicionesY.length == 9;
    //@ requires nuevoTablero.length == 9 && (\forall int i ; 0 <= i && i < nuevoTablero.length ; nuevoTablero[i].length == 9);
    //@ ensures true;
    public static /*@ pure */ void dibujarAlMover(MaquinaDeTrazados mt, int coordenada3, int coordenada4, int valor, int[] tableroPosicionesX, int[] tableroPosicionesY, int[][] nuevoTablero) {
            Colores color;
            if (nuevoTablero[coordenada3][coordenada4] == 1) {color = Colores.BLUE;}
            else if (nuevoTablero[coordenada3][coordenada4] == 2) {color = Colores.RED;}
            else if (nuevoTablero[coordenada3][coordenada4] == 3) {color = Colores.YELLOW;}
            else if (nuevoTablero[coordenada3][coordenada4] == 4) {color = Colores.GREEN;}
            else if (nuevoTablero[coordenada3][coordenada4] == 5) {color = Colores.PINK;}
            else if (nuevoTablero[coordenada3][coordenada4] == 6) {color = Colores.ORANGE;}
            else {color = Colores.MAGENTA;}

            if (nuevoTablero[coordenada3][coordenada4] == 7) { mt.dibujarRectanguloLleno(tableroPosicionesX[coordenada3], tableroPosicionesY[coordenada4], valor/9, valor/9, color);}
            else {mt.dibujarOvaloLleno(tableroPosicionesX[coordenada3], tableroPosicionesY[coordenada4], valor/9, valor/9, color);}
    }

    // Metodo para dibujar los objetos que era proximos en el tablero
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ requires valor >= 0;
    //@ requires tableroPosicionesX.length == 9;
    //@ requires tableroPosicionesY.length == 9;
    //@ requires nuevoTablero.length == 9 && (\forall int i ; 0 <= i && i < nuevoTablero.length ; nuevoTablero[i].length == 9);
    //@ requires objeto >= 1 && objeto <= 7;
    //@ requires x >= 0 && x <= 8;
    //@ requires y >= 0 && y <= 8;
    //@ ensures true;
    public static /*@ pure */ void dibujarLosProximosObjetos(MaquinaDeTrazados mt, int objeto, int x, int y, int valor, int[] tableroPosicionesX, int[] tableroPosicionesY, int[][] nuevoTablero) {
            Colores color;
            if (objeto == 1) {color = Colores.BLUE;}
            else if (objeto == 2) {color = Colores.RED;}
            else if (objeto == 3) {color = Colores.YELLOW;}
            else if (objeto == 4) {color = Colores.GREEN;}
            else if (objeto == 5) {color = Colores.PINK;}
            else if (objeto == 6) {color = Colores.ORANGE;}
            else {color = Colores.MAGENTA;}

            if (objeto == 7) { mt.dibujarRectanguloLleno(tableroPosicionesX[x], tableroPosicionesY[y], valor/9, valor/9, color);}
            else {mt.dibujarOvaloLleno(tableroPosicionesX[x], tableroPosicionesY[y], valor/9, valor/9, color);}
    }

    // Metodo que verifica si el tablero esta lleno
    //@ requires nuevoTablero.length == 9 && (\forall int i ; 0 <= i && i < nuevoTablero.length ; nuevoTablero[i].length == 9);
    //@ ensures \result == (\forall int i ; 0 <= i && i < nuevoTablero.length ; (\forall int j ; 0 <= j && j < nuevoTablero[i].length ; nuevoTablero[i][j] != 0));
    public static /* pure */ boolean tableroLleno(int[][] nuevoTablero) {
        int i = 0;
        boolean comprobarTablero = true;
        //@ maintaining nuevoTablero.length >= i;
        //@ decreases nuevoTablero.length - i;
        while (nuevoTablero.length > i) {
            int j = 0;
            if (comprobarTablero == false) {break;}
            else {}
            //@ maintaining nuevoTablero[i].length >= j && comprobarTablero == true;
            //@ decreases nuevoTablero[i].length - j;
            while (nuevoTablero[i].length > j && comprobarTablero == true) {
                if (nuevoTablero[i][j] == 0) {comprobarTablero = false; break;}
                else {comprobarTablero = true;}
            j++;}
        i++;}
        return comprobarTablero;
    }
}

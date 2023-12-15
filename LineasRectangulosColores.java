import java.util.Scanner;
import java.awt.Font;

public class LineasRectangulosColores {

    // ejecucion del juego
    //@ requires true;
    //@ ensures true;
    public static void main(String[] args) {
        inicializarJuego();

        // Dibujo de tablero
        MaquinaDeTrazados mt = new MaquinaDeTrazados(700,700, "Juego Tablero", Colores.GRAY);
        mt.dibujarOvaloLleno(mt.XMAX/2 - 150, mt.YMAX/2 -150, mt.XMAX, mt.YMAX, Colores.DARK_GRAY);
        mt.dibujarOvaloLleno(mt.XMAX/2 - 110, mt.YMAX/2 -110, mt.XMAX, mt.YMAX, Colores.BLACK);
        mt.dibujarOvaloLleno(mt.XMAX/2 - 80, mt.YMAX/2 - 80, mt.XMAX, mt.YMAX, Colores.GRAY);
        mt.dibujarOvaloLleno(mt.XMAX/2 - 40, mt.YMAX/2 - 40, mt.XMAX, mt.YMAX, Colores.DARK_GRAY);
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
        mt.dibujarRectanguloLleno(mt.XMAX/2 - valor/2 + valor/6 - valor/60, mt.YMAX/2 - valor/2 + valor/6 - valor/60, valor + valor/35, valor + valor/40, Colores.BLACK);
        mt.dibujarRectanguloLleno(mt.XMAX/2 - valor/2 + valor/6, mt.YMAX/2 - valor/2 + valor/6, valor - valor/100, valor - valor/100, Colores.WHITE);
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

            if (primeras3Piezas[i][0] == 7) { mt.dibujarRectanguloLleno(tableroPosicionesX[primeras3Piezas[i][2]], tableroPosicionesY[primeras3Piezas[i][1]], valor/9, valor/9, color);}
            else {mt.dibujarOvaloLleno(tableroPosicionesX[primeras3Piezas[i][2]], tableroPosicionesY[primeras3Piezas[i][1]], valor/9, valor/9, color);}
            mt.mostrar();
            tablero[primeras3Piezas[i][2]][primeras3Piezas[i][1]]=primeras3Piezas[i][0];
            i++;}

        // dibujar puntaje
        valorx = mt.XMAX/2 - valor/2 + valor/6;
        valory = mt.YMAX/2 - valor/2 + valor/6;
        mt.dibujarString("Puntaje:", valorx + valor/2 + valor/6, valory - valor/3 + 15);
        mt.dibujarString(""+puntaje, valorx + valor/2 + valor/6 + valor/9, valory - valor/7- valor/25);
        int[] proximosObjetos = obtenerProximosObjetos(mt, piezas, valor, tablero);
        mt.mostrar();
        
        // movimientos en el juego y acciones
        int[][] nuevoTablero = tablero;
        boolean finalizarJuego = true;
        
        puntaje = 0;
        while (finalizarJuego == true) {
            boolean verificar = true;
            nuevoTablero = obtenerJugadaValida(mt, nuevoTablero, tableroPosicionesX, tableroPosicionesY, valor, valorx, valory);
            if (nuevoTablero[0][0] == -1) {System.out.println("Numero de intentos excedidos. Gracias por jugar."); finalizarJuego = false;}
            else {
                if (tableroLleno(nuevoTablero) == true) {System.out.println("El juego ha acabado, el tablero esta lleno. Gracias por jugar"); break;}
                else {
                    nuevoTablero = procesarObjetosDelTablero(mt, nuevoTablero, valor, tableroPosicionesX, tableroPosicionesY, valorx, valory);

                    i = 0;
                    while (nuevoTablero.length > i) {
                        j = 0;
                        while (nuevoTablero[i].length > j) {
                            //System.out.println(nuevoTablero[i][j]);
                            if (nuevoTablero[i][j] <= -5) {puntaje += (-1)*(nuevoTablero[i][j]);
                                nuevoTablero[i][j] = 0; verificar = false;}
                            else {}
                            j++;}
                        i++;}

                    mt.dibujarRectanguloLleno( valorx + valor/2 + valor/6 + valor/18, valory - valor/7- valor/10, valor/7, valor/10, Colores.GRAY);
                    mt.dibujarString(""+puntaje+"", valorx + valor/2 + valor/6 + valor/9, valory - valor/7- valor/25);
                    if (verificar == true) {
                        nuevoTablero = agregarProximosObjetos(mt, nuevoTablero, proximosObjetos, valor, tableroPosicionesX, tableroPosicionesY, valorx, valory);
                        proximosObjetos = obtenerProximosObjetos(mt, piezas, valor, nuevoTablero);
                        if (tableroLleno(nuevoTablero) == true) {System.out.println("El juego ha acabado, el tablero esta lleno. Gracias por jugar"); break;}
                    }
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
        System.out.println("Se suman puntos cuando alinee de forma horizontal, vertical o diagonal 5 circulos (o mas), o cuando se formen cuadrados de 2x2 (o mayores)");
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
        System.out.println("Las coordenadas de las casillas se deben dar de la forma: numero de fila ---> ejecutar ---> numero de columna. De forma contraria, dara error");
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
    public static /*@ pure */ int[]  obtenerProximosObjetos(MaquinaDeTrazados mt, int[] piezas, int valor, int[][] tablero) {
        int[] piezasProximas = new int[3];
        piezasProximas[0] = (int) (Math.random()*piezas.length+1);
        piezasProximas[1] = (int) (Math.random()*piezas.length+1);

        int i = 0;
        int j = 0;
        int[] arregloParaEscogerElMenor = {0,0,0,0,0,0,0};
        //@ maintaining tablero.length >= i;
        //@ decreases tablero.length - i;
        while (tablero.length > i) {
            j = 0;
            //@ maintaining tablero[i].length >= j;
            //@ decreases tablero[i].length - j;
            while (tablero[i].length > j) {
                if (tablero[i][j] == 1) {arregloParaEscogerElMenor[0]++;}
                else if (tablero[i][j] == 2) {arregloParaEscogerElMenor[1]++;}
                else if (tablero[i][j] == 3) {arregloParaEscogerElMenor[2]++;}
                else if (tablero[i][j] == 4) {arregloParaEscogerElMenor[3]++;}
                else if (tablero[i][j] == 5) {arregloParaEscogerElMenor[4]++;}
                else if (tablero[i][j] == 6) {arregloParaEscogerElMenor[5]++;}
                else if (tablero[i][j] == 7) {arregloParaEscogerElMenor[6]++;}
                else {}
                j++;
            }
            i++;
        }
        i = 1;
        int menor = arregloParaEscogerElMenor[0];
        j = 1;
        //@ maintaining arregloParaEscogerElMenor.length >= i;
        //@ decreases arregloParaEscogerElMenor.length - i;
        while (arregloParaEscogerElMenor.length > i) {
            if (menor <=  arregloParaEscogerElMenor[i]) {}
            else { menor = arregloParaEscogerElMenor[i]; j = i+1;}
            i++;
        }
        piezasProximas[2] = j;

        int desplazamiento = valor/18;
        mt.dibujarString("PROXIMOS:", mt.XMAX/20 + valor/4 + desplazamiento, mt.YMAX/10 - mt.YMAX/20);
        i = 0;
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
        mt.dibujarRectanguloLleno(mt.XMAX/20 + valor/4 + valor/18, mt.YMAX/10 - mt.YMAX/15, valor/2 , valor/4, Colores.GRAY);
        //@ maintaining i <= proximosObjetos.length;
        //@ decreases 1000 - h;
        while (i < proximosObjetos.length) {
            if(tableroLleno(nuevoTablero) == true) {break;}
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
            System.out.println("Por favor ingrese el numero de fila de la figura a mover: ");
            coordenada1 = pedirCoordenada();
            // si devuelve -1, se rompe el while
            if (coordenada1 == -1) {u = 6; break;}
            else {}
            System.out.println("Por favor ingrese el numero de columna de la figura a mover: ");
            coordenada2 = pedirCoordenada();
            // si devuelve -1, se rompe el while
            if (coordenada2 == -1) {u = 6; break;}
            else {}
            // si la coordenada dada contiene un objeto, se pocede
            if (tablero[coordenada2][coordenada1] != 0) {
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
                    else if (coordenada2 == 8 && coordenada1 != 0) {
                        if (tablero[8][coordenada1 -1] == 0 || tablero[8][coordenada1 +1] == 0 || tablero[7][coordenada1 -1] == 0 || tablero[7][coordenada1] == 0 || tablero[7][coordenada1 +1] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada2 != 0 && coordenada1 == 8) {
                        if (tablero[coordenada2-1][7] == 0 || tablero[coordenada2-1][8] == 0 || tablero[coordenada2][7] == 0 || tablero[coordenada2+1][7] == 0 || tablero[coordenada2+1][8] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada2 == 0 && coordenada1 != 0) {
                        if (tablero[0][coordenada1 -1] == 0 || tablero[0][coordenada1 +1] == 0 || tablero[1][coordenada1 -1] == 0 || tablero[1][coordenada1] == 0 || tablero[1][coordenada1 +1] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada2 != 0 && coordenada1 == 0) {
                        if (tablero[coordenada2-1][0] == 0 || tablero[coordenada2-1][1] == 0 || tablero[coordenada2][1] == 0 || tablero[coordenada2+1][0] == 0 || tablero[coordenada2+1][1] == 0){h=7;break;}
                        else {comprobarJugadaValida= false;}}
                    else {
                        int coord2 = coordenada2 - 1;
                        comprobarJugadaValida = false;
                        int i = 0;
                        //@ maintaining 3 >= i;
                        //@ decreases 3 - i;
                        while (3 > i) {
                            int j = 0;
                            int coord1 = coordenada1 - 1;
                            if (comprobarJugadaValida == true) {h=7;break;}
                            //@ maintaining 3 >= j;
                            //@ decreases 3 - j;
                            while ( 3 > j ){
                                if (tablero[coord2][coord1] == 0) {comprobarJugadaValida = true;h=7;break;}
                                else
                                coord1++;
                                j++;}
                            coord2++;
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
                System.out.println("Por favor ingrese el numero destino de fila de la figura a mover: ");
		    	int coordenada3 = pedirCoordenada();
                // si devuelve -1, se rompe el while
                if (coordenada3 == -1) {u = 6; break;}
                else {}
                System.out.println("Por favor ingrese el numero destino de columna de la figura a mover: ");
                int coordenada4 = pedirCoordenada();
                // si devuelve -1, se rompe el while
                if (coordenada4 == -1) {u = 6; break;}
                else {}
                // si la coordenada dada en el tablero es 0, significa que no hay objetos
                if (tablero[coordenada4][coordenada3] == 0) {
                    nuevoTablero[coordenada4][coordenada3] = tablero[coordenada2][coordenada1];
                    nuevoTablero[coordenada2][coordenada1] = 0;
                    mt.dibujarRectanguloLleno(tableroPosicionesX[coordenada2], tableroPosicionesY[coordenada1], valor/9, valor/9, Colores.WHITE);
                    dibujarAlMover(mt,coordenada4,coordenada3,valor,tableroPosicionesX,tableroPosicionesY,nuevoTablero);
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

    // Metodo para chequear cada elemento del tablero y asi saber si se tiene que eliminar alguna combinacion
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ requires valor >= 0;
    //@ requires tableroPosicionesX.length == 9;
    //@ requires tableroPosicionesY.length == 9;
    //@ requires nuevoTablero.length == 9 && (\forall int i ; 0 <= i && i < nuevoTablero.length ; nuevoTablero[i].length == 9);
    //@ requires valorx >= 0;
    //@ requires valory >= 0;
    //@ ensures (\result == nuevoTablero) || (\result != nuevoTablero);
    public static /*@ pure */ int[][] procesarObjetosDelTablero(MaquinaDeTrazados mt, int[][] nuevoTablero, int valor, int[] tableroPosicionesX, int[] tableroPosicionesY, int valorx, int valory) {
        int[][] nuevoTablero1 = nuevoTablero;
        int[][] verificarEliminacion = new int[9][9];
        int i = 0 ;
        int j = 0;
        int conteo = 0;
        //@ maintaining verificarEliminacion.length >= i;
        //@ decreases verificarEliminacion.length - i;
        while (verificarEliminacion.length > i){
            j = 0;
            //@ maintaining verificarEliminacion[i].length >= j;
            //@ decreases verificarEliminacion[i].length - j;
            while (verificarEliminacion[i].length > j) { verificarEliminacion[i][j] = 0;j++;}
            i++;}

        i = 0;
        //@ maintaining nuevoTablero1.length >= i;
        //@ decreases nuevoTablero1.length - i;
        while (nuevoTablero1.length > i) {
            j = 0 ;
            //@ maintaining nuevoTablero1[i].length >= j;
            //@ decreases nuevoTablero1[i].length - j;
            while (nuevoTablero1[i].length > j) {
                if (1 <= nuevoTablero1[i][j] && nuevoTablero1[i][j] <= 6) {verificarEliminacion = contarCirculos(mt, nuevoTablero1, valor, tableroPosicionesX, tableroPosicionesY, i, j, verificarEliminacion);}
                else if (nuevoTablero1[i][j] == 7) {verificarEliminacion = contarCuadrados(mt, nuevoTablero, valor, tableroPosicionesX, tableroPosicionesY, i, j, verificarEliminacion);}
                else {}
            j++;}
        i++;}

        nuevoTablero1 = eliminarObjetos(mt, nuevoTablero, valor, tableroPosicionesX, tableroPosicionesY, verificarEliminacion, valorx, valory);
        i = 0;
        int c1 = 0;
        int c2 = 0;
        //@ maintaining verificarEliminacion.length >= i;
        //@ decreases verificarEliminacion.length - i;
        while (verificarEliminacion.length > i) {
            j = 0;
            //@ maintaining verificarEliminacion[i].length >= j;
            //@ decreases verificarEliminacion[i].length - j;
            while (verificarEliminacion[i].length > j) {
                if (verificarEliminacion[i][j] == 1) {verificarEliminacion[i][j] = 0;conteo++;c1=i;c2=j;}
                else{}
                j++;}
            i++;}
        
        if (conteo == 4) {nuevoTablero1[c1][c2] -= 5;}
        else if (conteo == 5){nuevoTablero1[c1][c2] -= 10;}
        else if (conteo == 6){nuevoTablero1[c1][c2] -= 12;}
        else if (conteo == 7){nuevoTablero1[c1][c2] -= 18;}
        else if (conteo >= 8){nuevoTablero1[c1][c2] -= 40;}
        else {}

        return nuevoTablero1;
    }

    // Metodo para contar la cantidad de cuadrados que forman matrices nxn
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ requires valor >= 0;
    //@ requires tableroPosicionesX.length == 9;
    //@ requires tableroPosicionesY.length == 9;
    //@ requires nuevoTablero.length == 9 && (\forall int i ; 0 <= i && i < nuevoTablero.length ; nuevoTablero[i].length == 9);
    //@ requires 0 <= coordenada4 && coordenada4 <= 8;
    //@ requires verificarEliminacion.length == 9 && (\forall int j ; 0 <= j && j < verificarEliminacion.length ; verificarEliminacion[j].length == 9);
    //@ requires 0 <= coordenada3 && coordenada3 <= 8;
    //@ ensures (verificarEliminacion == \result) || (verificarEliminacion != \result);
    public static /*@ pure */ int[][] contarCuadrados(MaquinaDeTrazados mt, int[][] nuevoTablero, int valor, int[] tableroPosicionesX, int[] tableroPosicionesY, int coordenada4, int coordenada3, int[][] verificarEliminacion) {
        int[][] nuevoTablero1 = nuevoTablero;
        int objeto = nuevoTablero[coordenada4][coordenada3];
        int i = 0;
        int j = 0;
        int c3 = coordenada3;
        int c4 = coordenada4;
        int[][] verificarEliminacion1 = verificarEliminacion;

        int conteo = 0;
        if (coordenada4 < 7 && coordenada3 < 7) {
            if (objeto == nuevoTablero[coordenada4][coordenada3] && objeto == nuevoTablero[coordenada4][coordenada3+1] && objeto == nuevoTablero[coordenada4][coordenada3+2] && objeto == nuevoTablero[coordenada4+1][coordenada3] && objeto == nuevoTablero[coordenada4+1][coordenada3+1] && objeto == nuevoTablero[coordenada4+1][coordenada3+2] && objeto == nuevoTablero[coordenada4+2][coordenada3] && objeto == nuevoTablero[coordenada4+2][coordenada3+1] && objeto == nuevoTablero[coordenada4+2][coordenada3+2]) {
                i = 0;
                c3 = coordenada3;
                //@ maintaining 3 >= i;
                //@ decreases 3- i;
                while (3 > i) {
                    j = 0;
                    c4 = coordenada4;
                    //@ maintaining 3 >= j;
                    //@ decreases 3- j;
                    while (3 > j) {
                        verificarEliminacion1[c4][c3] = 1;
                    j++; c4++;}
                i++; c3++;}}

            else if (objeto == nuevoTablero[coordenada4][coordenada3] && objeto == nuevoTablero[coordenada4][coordenada3+1] && objeto == nuevoTablero[coordenada4+1][coordenada3] && objeto == nuevoTablero[coordenada4+1][coordenada3+1]) {
                i = 0;
                c3 = coordenada3;
                //@ maintaining 2 >= i;
                //@ decreases 2- i;
                while (2 > i) {
                    j = 0;
                    c4 = coordenada4;
                    //@ maintaining 2 >= j;
                    //@ decreases 2- j;
                    while (2 > j) {
                        verificarEliminacion1[c4][c3] = 1;
                    j++; c4++;}
                i++; c3++;}}

            else {}}

        else if (coordenada4 < 8 && coordenada3 < 8) {
            if (objeto == nuevoTablero[coordenada4][coordenada3] && objeto == nuevoTablero[coordenada4][coordenada3+1] && objeto == nuevoTablero[coordenada4+1][coordenada3] && objeto == nuevoTablero[coordenada4+1][coordenada3+1]) {
                i = 0;
                c3 = coordenada3;
                //@ maintaining 2 >= i;
                //@ decreases 2 - i;
                while (2 > i) {
                    j = 0;
                    c4 = coordenada4;
                    //@ maintaining 2 >= j;
                    //@ decreases 2- j;
                    while (2 > j) {
                        verificarEliminacion1[c4][c3] = 1;
                    j++; c4++;}
                i++; c3++;}}

            else {}}

        else {}
        return verificarEliminacion1;
    }

    // Metodo para contar la cantidad de circulos que su combinacion formas lineas de 5 o mas objetos
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ requires valor >= 0;
    //@ requires tableroPosicionesX.length == 9;
    //@ requires tableroPosicionesY.length == 9;
    //@ requires nuevoTablero.length == 9 && (\forall int i ; 0 <= i && i < nuevoTablero.length ; nuevoTablero[i].length == 9);
    //@ requires 0 <= coordenada4 && coordenada4 <= 8;
    //@ requires verificarEliminacion.length == 9 && (\forall int j ; 0 <= j && j < verificarEliminacion.length ; verificarEliminacion[j].length == 9);
    //@ requires 0 <= coordenada3 && coordenada3 <= 8;
    //@ ensures (verificarEliminacion == \result) || (verificarEliminacion != \result);
    public static /*@ pure */ int[][] contarCirculos(MaquinaDeTrazados mt, int[][] nuevoTablero, int valor, int[] tableroPosicionesX, int[] tableroPosicionesY, int coordenada4, int coordenada3, int[][] verificarEliminacion) {
        int i;
        int j;
        int vertical = 0;
        int horizontal = 0;
        int diagonal = 0;
        int diagonalinversa = 0;
        int[][] nuevoTablero1 = nuevoTablero;
        int objeto = nuevoTablero1[coordenada4][coordenada3];


        if (coordenada3 <= 4 && coordenada4 <= 4) {
            // contar en columna
            i = coordenada3;
            //@ maintaining nuevoTablero.length >= i ;
            //@ decreases nuevoTablero.length - i ;
            while (nuevoTablero.length > i) {
                if (objeto == nuevoTablero1[coordenada4][i]) {vertical +=1;}
                else {break;}
                i++;}
            if (vertical >= 5) {
                i = coordenada3;
                //@ maintaining nuevoTablero.length >= i ;
                //@ decreases nuevoTablero.length - i ;
                while (nuevoTablero.length > i) {
                    if (objeto == nuevoTablero1[coordenada4][i]) {verificarEliminacion[coordenada4][i]= 1;}
                    else {}
                    i++;}}
            else {}

            // contar en fila
            i = coordenada4;
            //@ maintaining nuevoTablero.length >= i ;
            //@ decreases nuevoTablero.length - i ;
            while (nuevoTablero.length > i) {
                if (objeto == nuevoTablero1[i][coordenada3]) {horizontal +=1;}
                else {break;}
                i++;}
            if (horizontal >= 5) {
                i = coordenada4;
                //@ maintaining nuevoTablero.length >= i ;
                //@ decreases nuevoTablero.length - i ;
                while (nuevoTablero.length > i) {
                    if (objeto == nuevoTablero1[i][coordenada3]) {verificarEliminacion[i][coordenada3]= 1;}
                    else {}
                    i++;}}
            else {}

            // contar en diagonal
            i = coordenada4;
            j = coordenada3;
            //@ maintaining nuevoTablero.length >= i ;
            //@ decreases nuevoTablero.length - i ;
            while (nuevoTablero.length > i) {
                if (objeto == nuevoTablero1[i][j]) {
                    diagonal +=1;}
                else {break;}
                i++;j++;}
            if (diagonal >= 5) {
                i = coordenada4;
                j = coordenada3;
                //@ maintaining nuevoTablero.length >= i ;
                //@ decreases nuevoTablero.length - i ;
                while (nuevoTablero.length > i) {
                    if (objeto == nuevoTablero1[i][j]){verificarEliminacion[i][j]= 1;}
                    else {}
                    i++;j++;}}
            else {}

            if (coordenada3 == 4 && coordenada4 == 4) {

                // contar en diagonal inversa
                i = coordenada4;
                j = coordenada3;
                //@ maintaining 0 <= i && j <= 8;
                //@ decreases 9 - j;
                while (0 <= i && j <= 8) {
                    if (objeto == nuevoTablero1[i][j]) {
                        diagonalinversa +=1;}
                    else {break;}
                    i--;j++;}
                if (diagonalinversa >= 5) {
                    i = coordenada4;
                    j = coordenada3;
                    //@ maintaining 0 <= i && j <= 8;
                    //@ decreases 9 - j;
                    while (0 <= i && j <= 8) {
                        if (objeto == nuevoTablero1[i][j]){verificarEliminacion[i][j]= 1;}
                        else {}
                        i--;j++;}}
                else{}
            }
        }

        else if (coordenada4 <= 4 && coordenada3 > 4) {
            // contar en fila
            i = coordenada4;
            //@ maintaining nuevoTablero.length >= i ;
            //@ decreases nuevoTablero.length - i ;
            while (nuevoTablero.length > i) {
                if (objeto == nuevoTablero1[i][coordenada3]) {horizontal +=1;}
                else {break;}
                i++;}
            if (horizontal == 5) {
                i = coordenada4;
                //@ maintaining nuevoTablero.length >= i ;
                //@ decreases nuevoTablero.length - i ;
                while (nuevoTablero.length > i) {
                    if (objeto == nuevoTablero1[i][coordenada3]) {verificarEliminacion[i][coordenada3]= 1;}
                    else {}
                    i++;}}
            else {}

        }

        else if (coordenada4 > 4 && coordenada3 <= 4) {
            // contar en columna
            i = coordenada3;
            //@ maintaining nuevoTablero.length >= i ;
            //@ decreases nuevoTablero.length - i ;
            while (nuevoTablero.length > i) {
                if (objeto == nuevoTablero1[coordenada4][i]) {vertical +=1;}
                else {break;}
                i++;}
            if (vertical >= 5) {
                i = coordenada3;
                //@ maintaining nuevoTablero.length >= i ;
                //@ decreases nuevoTablero.length - i ;
                while (nuevoTablero.length > i) {
                    if (objeto == nuevoTablero1[coordenada4][i]) {verificarEliminacion[coordenada4][i]= 1;}
                    else {}
                    i++;}}
            else {}
            

            // contar en diagonal inversa
            i = coordenada4;
            j = coordenada3;
            //@ maintaining 0 <= i && j <= 8;
            //@ decreases 9 - j;
            while (0 <= i && j <= 8) {
                if (objeto == nuevoTablero1[i][j]) {
                    diagonalinversa +=1;}
                else {break;}
                i--;j++;}
                System.out.println(diagonalinversa);
            if (diagonalinversa >= 5) {
                i = coordenada4;
                j = coordenada3;
                //@ maintaining 0 <= i && j <= 8;
                //@ decreases 9 - j;
                while (0 <= i && j <= 8) {
                    if (objeto == nuevoTablero1[i][j]){verificarEliminacion[i][j]= 1;}
                    else {}
                    i--;j++;}}
            else{}
        }
        else {}
        return verificarEliminacion;
    }

    // Metodo para eliminar los objetos en las posiciones dada por la matriz verificarEliminacion
    //@ requires mt.XMAX > 0 && mt.YMAX > 0;
    //@ requires valor >= 0;
    //@ requires tableroPosicionesX.length == 9;
    //@ requires tableroPosicionesY.length == 9;
    //@ requires nuevoTablero.length == 9 && (\forall int i ; 0 <= i && i < nuevoTablero.length ; nuevoTablero[i].length == 9);
    //@ requires verificarEliminacion.length == 9 && (\forall int j ; 0 <= j && j < verificarEliminacion.length ; verificarEliminacion[j].length == 9);
    //@ ensures (verificarEliminacion == \result) || (verificarEliminacion != \result);
    public static /*@ pure */ int[][] eliminarObjetos(MaquinaDeTrazados mt, int[][] nuevoTablero, int valor, int[] tableroPosicionesX, int[] tableroPosicionesY, int[][] verificarEliminacion, int valorx, int valory) {
        int i = 0;
        int j = 0;
        int[][] nuevoTablero1 = nuevoTablero;

        //@ maintaining verificarEliminacion.length >= i;
        //@ decreases verificarEliminacion.length - i;
        while (verificarEliminacion.length > i) {
            j = 0;
            //@ maintaining verificarEliminacion[i].length >= j;
            //@ decreases verificarEliminacion[i].length - j;
            while (verificarEliminacion[i].length > j) {
                if (verificarEliminacion[i][j] == 1) {mt.dibujarRectanguloLleno(tableroPosicionesX[i], tableroPosicionesY[j], valor/9, valor/9, Colores.WHITE); nuevoTablero1[i][j] = 0;}
                else{}
                j++;}
            i++;}
        casillasTableroHorizontal(mt, valorx, valory, valor);
        casillasTableroVertical(mt, valorx, valory, valor);
        return nuevoTablero1;
    }
}
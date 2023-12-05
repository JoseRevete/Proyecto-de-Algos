import java.util.Scanner;
import java.awt.Font;

public class LineasRectangulosColores {

    public static void main(String[] args) {
        inicializarJuego();
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
        while ( repetir == true) {
            if (primeras3Piezas[0][1] == primeras3Piezas[1][1] && primeras3Piezas[0][2] == primeras3Piezas[1][2]) {primeras3Piezas = inicializarTablero(piezas, tablero);}
            else if (primeras3Piezas[0][1] == primeras3Piezas[2][1] && primeras3Piezas[0][2] == primeras3Piezas[2][2]) {primeras3Piezas = inicializarTablero(piezas, tablero);}
            else if (primeras3Piezas[1][1] == primeras3Piezas[2][1] && primeras3Piezas[1][2] == primeras3Piezas[2][2]) {primeras3Piezas = inicializarTablero(piezas, tablero);}
            else {repetir = false;}
        }

        i = 0;
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

        valorx = mt.XMAX/2 - valor/2 + valor/6;
        valory = mt.YMAX/2 - valor/2 + valor/6;
        mt.dibujarString("Puntaje:", valorx + valor/2 + valor/6, valory - valor/3 + 15);
        mt.dibujarString(""+puntaje, valorx + valor/2 + valor/6 + valor/9, valory - valor/7- valor/25);
        int[] proximosObjetos = obtenerProximosObjetos(mt, piezas, valor);
        mt.mostrar();
        
        int[][] nuevoTablero = tablero;
        boolean finalizarJuego = true;
        while (finalizarJuego == true) {
		// AQUI ESTA
            int[][] tableroParaComparar = devolverTablero(nuevoTablero);
            nuevoTablero = obtenerJugadaValida(mt, nuevoTablero, tableroPosicionesX, tableroPosicionesY, valor, valorx, valory);
            //if (tableroParaComparar == nuevoTablero) {System.out.println("No realizo ningun cambio"); finalizarJuego = false;}
            //else {
                if (tableroLleno(nuevoTablero) == true) {System.out.println("El juego ha acabado, el tablero esta lleno. Gracias por jugar"); break;}
                else {
                    nuevoTablero = agregarProximosObjetos(mt, nuevoTablero, proximosObjetos, valor, tableroPosicionesX, tableroPosicionesY);
                    proximosObjetos = obtenerProximosObjetos(mt, piezas, valor);
                }//}
            mt.repintar();
        }
        mt.terminar();
    }

    // Metodo para saludar y dar la bienvenida al usuario
    public static /*@ pure*/ String inicializarJuego() {
        System.out.println("¡Bienvenido a Lineas de colores y rectangulos!");
        System.out.println("Por favor ingrese su nombre: ");
        Scanner leer = new Scanner (System.in);
        String jugador = leer.nextLine();
        System.out.println("Hola " + jugador + ".");
        System.out.println("El juego consiste en ir moviendo los circulos y cuadrados para formar lineas de 5 circulos o cuadrados de tamaño 2x2 o mayor, respectivamente.");
        System.out.println("Solo lo debe mover a una posicion en donde no hayan circulos ni cuadrados, para poder moverlos, este debe ser al menos un espacio a su alrededor libre de circulos y cuadrados");
        System.out.println("Se suman puntos cuando alinie de forma horizontal, vertical o diagonal 5 circulos, o cuando se formen cuadrados de 2x2 o mayores");
        System.out.println("La tabla de puntaje es:");
        System.out.println("Número de objetos alineados  |  Puntos que se obtienen");
        System.out.println("------------------------------------------------------");
        System.out.println("              4              |             5          ");
        System.out.println("              5              |             10         ");
        System.out.println("              6              |             12         ");
        System.out.println("              7              |             18         ");
        System.out.println("           8 o mas           |             40         ");
        return jugador;
    }

    // Metodo para mostrar tablero y piezas
    public static /*@ pure */ int[][] inicializarTablero(int[] piezas, int[][] tablero) {
        int[][] tableroModificado = new int[3][3];
        int i = 0;
        boolean result = true;
        while (tableroModificado.length > i) {
            int j = 0;
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

    public static /*@ pure */ void casillasTableroHorizontal(MaquinaDeTrazados mt, int valorx, int valory, int valor) {
        mt.dibujarString("0", valorx - valor/15, valory + valor/15);
        int desplazamientoy = valor/9;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("1", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("2", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("3", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("4", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("5", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("6", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("7", valorx - valor/15, valory + valor/15 + desplazamientoy);
        desplazamientoy += valor/9;
        mt.dibujarLinea(valorx, valory + desplazamientoy, valorx + valor, valory + desplazamientoy);
        mt.dibujarString("8", valorx - valor/15, valory + valor/15 + desplazamientoy);
    }

    public static /*@ pure */ void casillasTableroVertical(MaquinaDeTrazados mt, int valorx, int valory, int valor) {
        mt.dibujarString("0", valorx + valor/24, valory - valor/24);
        int desplazamientox = valor/9;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("1", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("2", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("3", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("4", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("5", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("6", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("7", valorx + valor/24 + desplazamientox, valory - valor/24);
        desplazamientox += valor/9;
        mt.dibujarLinea(valorx + desplazamientox, valory, valorx + desplazamientox, valory + valor);
        mt.dibujarString("8", valorx + valor/24 + desplazamientox, valory - valor/24);
    }

    public static /*@ pure */ int[]  obtenerProximosObjetos(MaquinaDeTrazados mt, int[] piezas, int valor) {
        int[] piezasProximas = new int[3];
        piezasProximas[0] = (int) (Math.random()*piezas.length+1);
        piezasProximas[1] = (int) (Math.random()*piezas.length+1);
        piezasProximas[2] = (int) (Math.random()*piezas.length+1);
        int desplazamiento = valor/18;
        mt.dibujarString("PROXIMOS:", mt.XMAX/20 + valor/4 + desplazamiento, mt.YMAX/10 - mt.YMAX/20);
        int i = 0;
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
            mt.mostrar();
            i++;}
        return piezasProximas;
    }

    public static /*@ pure */ int[][] agregarProximosObjetos(MaquinaDeTrazados mt, int[][] nuevoTablero, int[] proximosObjetos, int valor, int[] tableroPosicionesX, int[] tableroPosicionesY) {
        int i = 0;
        int[][] tablero = nuevoTablero;
        mt.dibujarRectanguloLleno(mt.XMAX/20 + valor/4 + valor/18, mt.YMAX/10 - mt.YMAX/15, valor/2 , valor/4, Colores.DARK_GRAY);
        while (i < proximosObjetos.length) {
            int x = (int) (Math.random()*nuevoTablero.length);
            int y = (int) (Math.random()*nuevoTablero.length);
            if (tablero[x][y] == 0) {
                tablero[x][y] = proximosObjetos[i];
                dibujarLosProximosObjetos(mt, proximosObjetos[i], x, y, valor, tableroPosicionesX, tableroPosicionesY, nuevoTablero);
                i++;}
            else {}
        }
        return tablero;
    }

    public static /*@ pure */ int pedirCoordenada(){
        Scanner leer = new Scanner (System.in);
        int coordenada = leer.nextInt();
        int a = 0;
        while (4 > a) {
            if (0 <= coordenada && coordenada <= 8) {break;}
            else {
                System.out.println("Coordenada invalida, intente de nuevo");
                leer = new Scanner (System.in);
                coordenada = leer.nextInt(); 
                a++;
            }
        }
        if (a >= 4) {coordenada = -1;}
        else {}
        return coordenada;
    }

	// Metodo para verificar si la jugada es valida
    public static /*@ pure */ int[][] obtenerJugadaValida(MaquinaDeTrazados mt, int[][] tablero, int[] tableroPosicionesX, int[] tableroPosicionesY, int valor, int valorx, int valory){
        int[][] nuevoTablero = tablero;
        boolean comprobarJugadaValida = false;
        int u = 0;
        while ( u < 6) {
            System.out.println("Debe ingresar la coordenada origen de su figura a mover");
            System.out.println("Por favor ingrese el numero de columna de la figura a mover: ");
            int coordenada1 = pedirCoordenada();
            if (coordenada1 == -1) {u = 6; break;}
            else {}
            System.out.println("Por favor ingrese el numero de fila de la figura a mover: ");
            int coordenada2 = pedirCoordenada();
            if (coordenada2 == -1) {u = 6; break;}
            else {}
            if (tablero[coordenada1][coordenada2] != 0) {
                comprobarJugadaValida = true;
                while (comprobarJugadaValida == true) {
                    if (coordenada1 == 8 && coordenada2 == 8) {
                        if (tablero[7][7] == 0 || tablero[7][8] == 0 || tablero[8][7] == 0){break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 0 && coordenada2 == 0) {
                        if (tablero[0][1] == 0 || tablero[1][1] == 0 || tablero[1][0] == 0){break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 0 && coordenada2 == 8) {
                        if (tablero[0][7] == 0 || tablero[1][7] == 0 || tablero[1][8] == 0){break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 8 && coordenada2 == 0) {
                        if (tablero[7][1] == 0 || tablero[8][1] == 0 || tablero[7][0] == 0){break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 8 && coordenada2 != 0) {
                        if (tablero[8][coordenada2 -1] == 0 || tablero[8][coordenada2 +1] == 0 || tablero[7][coordenada2 -1] == 0 || tablero[7][coordenada2] == 0 || tablero[7][coordenada2 +1] == 0){break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 != 0 && coordenada2 == 8) {
                        if (tablero[coordenada1-1][7] == 0 || tablero[coordenada1-1][8] == 0 || tablero[coordenada1][7] == 0 || tablero[coordenada1+1][7] == 0 || tablero[coordenada1+1][8] == 0){break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 == 0 && coordenada2 != 0) {
                        if (tablero[0][coordenada2 -1] == 0 || tablero[0][coordenada2 +1] == 0 || tablero[1][coordenada2 -1] == 0 || tablero[1][coordenada2] == 0 || tablero[1][coordenada2 +1] == 0){break;}
                        else {comprobarJugadaValida= false;}}
                    else if (coordenada1 != 0 && coordenada2 == 0) {
                        if (tablero[coordenada1-1][0] == 0 || tablero[coordenada1-1][1] == 0 || tablero[coordenada1][1] == 0 || tablero[coordenada1+1][0] == 0 || tablero[coordenada1+1][1] == 0){break;}
                        else {comprobarJugadaValida= false;}}
                    else {
                        int coord1 = coordenada1 - 1;
                        comprobarJugadaValida = false;
                        int i = 0;
                        while (3 > i) {
                            int j = 0;
                            int coord2 = coordenada2 - 1;
                            if (comprobarJugadaValida == true) {break;}
                            while ( 3 > j ){
                                if (tablero[coord1][coord2] == 0) {comprobarJugadaValida = true;break;}
                                else
                                coord2++;
                                j++;}
                            coord1++;
                            i++;}
                        break;}
                }
            }
            else {System.out.println("La posicion que indicas en que cual esta el objeto que intentas mover esta vacia. Intenta de nuevo");}
            if (comprobarJugadaValida == true) {
                System.out.println("Ahora debe ingresar la coordenada destino de su figura a mover");
                System.out.println("Por favor ingrese el numero destino de columna de la figura a mover: ");
		    	int coordenada3 = pedirCoordenada();
                if (coordenada3 == -1) {u = 6; break;}
                else {}
                System.out.println("Por favor ingrese el numero destino de fila de la figura a mover: ");
                int coordenada4 = pedirCoordenada();
                if (coordenada4 == -1) {u = 6; break;}
                else {}
                if (tablero[coordenada3][coordenada4] == 0) {
                    nuevoTablero[coordenada3][coordenada4] = tablero[coordenada1][coordenada2];
                    nuevoTablero[coordenada1][coordenada2] = 0;
                    mt.dibujarRectanguloLleno(tableroPosicionesX[coordenada1], tableroPosicionesY[coordenada2], valor/9, valor/9, Colores.WHITE);
                    dibujarAlMover(mt,coordenada3,coordenada4,valor,tableroPosicionesX,tableroPosicionesY,nuevoTablero);
                    casillasTableroHorizontal(mt, valorx, valory, valor);
                    casillasTableroVertical(mt, valorx, valory, valor);
                    mt.repintar();
                    u=8;
                    break;
                }
                else {System.out.println("La coordenada destino que esta planteando ya se encuentra ocupada por un objeto. Intente de nuevo");}
            }
            else {System.out.println("La jugada que intenta realizar no es valida, el objeto se encuentra rodeado de otros obejtos. Intente de nuevo");}
            u++;
        }
        if (u < 8) {System.out.println("Excedio el numero maximo de intentos");}
        else {System.out.println("El cambio ha sido realizado con exito");}
        return nuevoTablero;
    }

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
            mt.mostrar();
    }

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
            mt.mostrar();
    }

    public static /* pure */ boolean tableroLleno(int[][] nuevoTablero) {
        int i = 0;
        boolean comprobarTablero = true;
        while (nuevoTablero.length > i) {
            int j = 0;
            while (nuevoTablero[i].length > j) {
                if (nuevoTablero[i][j] == 0) {comprobarTablero = false; break;}
                else {comprobarTablero = true;}
            j++;}
        i++;}
        return comprobarTablero;
    }

    public static /*@ pure */ int[][] devolverTablero(int[][] nuevoTablero) {return nuevoTablero;}
}

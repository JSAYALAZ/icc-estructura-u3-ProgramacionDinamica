package Ejercicios.contorllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicios.models.Celda;

/*
 * Un jugador está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior izquierda con el jugador, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 *
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */
public class Laberinto {

    private static Map<Celda, Boolean> cacheMap = new HashMap<>();

    public List<Celda> getPath(boolean[][] grid) {
        List<Celda> resp = new ArrayList<>();
        Celda celda = new Celda(0, 0);
        return move(grid, celda, resp);
    }

    public static List<Celda> move(boolean[][] celdas, Celda celda, List<Celda> resultado) {
        System.out.println("\n\n\n");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.err.println("El hilo fue interrumpido");
        }
        int elementosAbajo = celdas.length;
        int elementosAlado = celdas[celda.getCol()].length;


        System.out.println("elementosAbajo: " + elementosAbajo);
        System.out.println("elementosAlado: " + elementosAlado);
        if (elementosAbajo == 1 && elementosAlado == 1) {
            return resultado;
        }

        if (cacheMap.containsKey(celda)) {
            if (elementosAbajo - celda.getRow() >= 1) {
                System.out.println("Moviento a abajo");
                resultado.add(celda);
                move(celdas, new Celda(celda.getRow() + 1, 0), resultado);
            }
        } else {
            if (elementosAlado - celda.getCol() >= 1) {
                System.out.println("Elemetno no encontrado");
                System.out.println("Posicion en la columna: " + celda.getCol());
                System.out.println("Posicion en la fila: " + celda.getRow());
                System.out.println("Moviendo a lado derecho");
                move(celdas, new Celda(celda.getRow(), celda.getCol() + 1), resultado);
            }

            cacheMap.put(celda, false);

        }
        return resultado;

    }
}
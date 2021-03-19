/**
 * Ejercicio 1 - Programa que muestra los primeros n números pares, siendo n un valor que el
 * usuario ingresará por consola.
 * Ejercicio 2 - Programa que muestra los primeros n múltiplos m, siendo n y m valores que el
 * usuario ingresará por consola.
 *
 * @author  Sofia Pigino (Grupo 2)
 * @version 1.0
 */

import java.util.Scanner;

public class Ejercicio1y2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("- Ejercicio 1 -");
        System.out.print("Ingrese la cantidad de numeros pares que desea mostrar: ");
        int n1 = sc.nextInt();
        isNumber(n1, 2);

        System.out.println("- Ejercicio 2 -");
        System.out.print("Ingrese la cantidad de numeros multiplos de m que desea mostrar: ");
        int n2 = sc.nextInt();
        System.out.print("Ingrese el multiplo (m): ");
        int m = sc.nextInt();
        isNumber(n2, m);
    }

    public static void isNumber(int n, int m) {
        for(int i = 0; i < n * m; i += m) {
            System.out.println(i);
        }

    }
}


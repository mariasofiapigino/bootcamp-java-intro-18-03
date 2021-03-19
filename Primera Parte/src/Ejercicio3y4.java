/**
 * Ejercicio 3 - Programa para informar si un número n es primo o no, siendo n un valor que el
 * usuario ingresará por consola.
 * Ejercicio 4 - Programa para mostrar por consola los primeros n números primos, siendo n
 * un valor que el usuario ingresará por consola.
 *
 * @author  Sofia Pigino (Grupo 2)
 * @version 1.0
 */

import java.util.Scanner;

public class Ejercicio3y4 {
    public static void main(String[] args) {
        System.out.println("- Ejercicio 3 -");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese numero a controlar si es primo: ");
        int n = sc.nextInt();

        if (isPrime(n)) System.out.println(n + " si es un numero primo");
        else System.out.println(n + " no es un numero primo");

        System.out.println("- Ejercicio 4 -");
        System.out.print("Ingrese cantidad de numeros primos a mostrar: ");
        int n1 = sc.nextInt();

        int count = 0;

        for (int i = 0; count < n1; i++) {
            if (isPrime(i)){
                System.out.println(i);
                count++;
            }
        }
    }

    public static Boolean isPrime(int number)
    {
        if(number < 2)
        {
            return false;
        }
        else
        {
            for(int x=2; x*x<=number; x++)
            {
                if( number % x == 0 ) {
                    return false;
                }
            }
        }
        return true;
    }
}

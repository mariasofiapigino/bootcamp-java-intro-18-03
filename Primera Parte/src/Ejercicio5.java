/**
 * Programa que muestra por consola los primeros n numeros naturales
 * que tienen al menos m digitos d, siendo n, m y d valores que el
 * usuario ingresa por consola.
 *
 * @author  Sofia Pigino (Grupo 2)
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros naturales que desea mostrar: ");
        int n = sc.nextInt();
        System.out.print("Ingrese la cantidad de digitos: ");
        int m = sc.nextInt();
        System.out.print("Ingrese el digito a buscar: ");
        String d = sc.next();

        int count = 0;
        int countD = 0;

        ArrayList number = new ArrayList();

        for (int i = 0; count < n; i++) {
            String x = Integer.toString(i);
            char[] digits = x.toCharArray();
            for (int j = 0; j < digits.length; j++) {
                if (Character.toString(digits[j]).equals(d)) {
                    countD++;
                }
            }
            if (countD == m) {
                count++;
                number.add(x);
            }
            countD = 0;
        }
        System.out.println(number.toString());
    }
}

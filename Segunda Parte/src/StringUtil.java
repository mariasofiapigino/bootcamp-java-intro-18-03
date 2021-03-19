import java.util.Arrays;
import java.util.stream.Stream;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        String strChar = String.valueOf(c);
        return strChar.repeat(n);
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String s, int n, char c)
    {
        String strArray = "";
        int start = s.length();
        int finish = n - 1;
        if (start != 0) finish = n;
        for (int i = start; i < finish; i++) {
            strArray += String.valueOf(c);
        }

        strArray += s;

        return strArray;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int intArray[])
    {
        String[] strArray = new String[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            strArray[i] = String.valueOf(intArray[i]);
        }
        return strArray;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        return Stream.of(arr)
                .mapToInt(Integer::parseInt).toArray();
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        return Arrays.asList(arr)
                .stream().map(String::length).max(Integer::compareTo).get();
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c)
    {
        int max = maxLength(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], max, c);
        }
    }
}

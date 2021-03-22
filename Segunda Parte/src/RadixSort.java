/**
 * Desarrollar el método radixSort, que ordena un array de enteros mediante dicho algoritmo de
 * ordenamiento: “ordenamiento de raíz”.
 *
 * @author  Sofia Pigino (Grupo 2)
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSort {
    public static void radixSort(int []arr)
    {
        StringUtil stringUtil = new StringUtil();
        String[] strArray = stringUtil.toStringArray(arr);
        stringUtil.lNormalize(strArray, '0');

        Map<Character, ArrayList> map = new HashMap();

        initMap(strArray, map);

        Map<Character,ArrayList> newMap = recursive(map, 0, stringUtil.maxLength(strArray) - 2);

        ArrayList finalArray = new ArrayList();

        for(Map.Entry<Character,ArrayList> entry:newMap.entrySet())
        {
            ArrayList value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                finalArray.add(value.get(i));
            }
        }

        String[] finalString = new String[strArray.length];

        for (int i = 0; i < finalArray.size(); i++) {
            finalString[i] = (String) finalArray.get(i);
        }

        for (int i = 0; i < finalString.length; i++) {
            arr[i] = Integer.valueOf(finalString[i]);
        }
    }

    public static void initMap(String[] strArray, Map<Character, ArrayList> map) {
        // Se inicializa el map
        // Recorre cada palabra del strArray original
        for (int i = 0; i < strArray.length; i++) {

            // Una palabra, array de caracteres
            char[] charArray = strArray[i].toCharArray();

            // Ultimo caracter del array
            char lastChar = charArray[strArray[i].length() - 1];

            if (!map.containsKey(lastChar)) {
                ArrayList content = new ArrayList();
                content.add(strArray[i]);
                map.put(lastChar, content);
            } else {
                ArrayList oldContent = map.get(lastChar);
                oldContent.add(strArray[i]);
                map.put(lastChar, oldContent);
            }
        }
    }

    public static Map recursive(Map<Character,ArrayList> map, int count, int max){
        Map<Character, ArrayList> newMap = new HashMap();

        for(Map.Entry<Character,ArrayList> entry:map.entrySet()) {
            ArrayList<String> value = entry.getValue();

            for (int i = 0; i < value.size(); i++) {
                char[] charArray = value.get(i).toCharArray();

                char lastChar = charArray[value.get(i).length() - 2 - count];

                if (!newMap.containsKey(lastChar)) {
                    String actual = value.get(i);
                    ArrayList actualArray = new ArrayList();
                    actualArray.add(actual);
                    newMap.put(lastChar, actualArray);
                } else {
                    String actual = value.get(i);
                    ArrayList anteriorArray = newMap.get(lastChar);
                    anteriorArray.add(actual);
                    newMap.put(lastChar, anteriorArray);
                }
            }
        }

        Map returnMap;

        if (count == max) {
            returnMap = new HashMap(newMap);
            return returnMap;
        } else {
            count++;
            returnMap = recursive(newMap, count, max);
        }

        return returnMap;

    }

    public static void main(String[] args)
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}

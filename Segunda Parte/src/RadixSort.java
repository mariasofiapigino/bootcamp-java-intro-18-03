import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RadixSort {
    public static void radixSort(int []arr)
    {
        StringUtil stringUtil = new StringUtil();
        String[] strArray = stringUtil.toStringArray(arr);
        stringUtil.lNormalize(strArray, '0');

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }

        Map<Character, ArrayList> map = new HashMap();
        Map<Character, ArrayList> newMap = new HashMap<>();

        // newMap = recursive(map, strArray, 1);

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

        System.out.println(map.toString());

        for(Map.Entry<Character,ArrayList> entry:map.entrySet()) {
            Character key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                char[] charArray = value.get(i).toCharArray();

                char lastChar = charArray[value.get(i).length() - 1];
                System.out.println("Ultimo char: " + lastChar);


            }
        }

    }

    public static Map recursive(Map<Character, ArrayList> map, String[] strArray, int index){
        Map<Character, ArrayList> newMap = new HashMap<>();
        if (index > strArray[1].length()){
            return map;
        }

        for (int i = 0; i < strArray.length; i++) {

            // Una palabra, array de caracteres
            char[] charArray = strArray[i].toCharArray();

            // Ultimo caracter del array
            char lastChar = charArray[strArray[i].length() - index];
            // char lastLastChar = charArray[strArray[i].length() - index - 1];
            // System.out.print("Ultimo caracter: " + lastChar + "\n");

            if (!map.containsKey(lastChar)) {
                ArrayList content = new ArrayList();
                content.add(strArray[i]);
                map.put(lastChar, content);
            } else {
                ArrayList oldContent = map.get(lastChar);
                oldContent.add(strArray[i]);
                map.put(lastChar, oldContent);

                // ArrayList removeContent = map.get(lastLastChar);
                // System.out.println(removeContent.toString());
                // removeContent.remove(strArray[i]);
                // map.put(lastLastChar, removeContent);
            }
        }

        newMap = recursive(map, strArray, index + 1);

        return newMap;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[10];
//        int[] arr = {2, 3, 4, 5, 8, 12, 10, 7, 11};

        // M1 - ARR[0]
        // M2 - ARR[1]
//
//        // 9 + 25 + 49 + 121
//
//        // sum of squares of all the odd numbers in this array
//
//        int result = 0;
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] % 2 == 1){
//                result += Math.pow(arr[i], 2);
//            }
//        }
//
//        System.out.println(result);

        // ArrayList --> List

//        ArrayList<String> cities = new ArrayList<>(); // n ~ 10^5
//
//        cities.add("Mumbai"); // 3
//        cities.add("Delhi"); // 2
//        cities.add("Chennai"); // 3
//        cities.add("Kolkata"); // 3
//        cities.add("Bangalore"); // 4
//        cities.add("Bhopal"); // 2
//        cities.add("Hyderabad"); // 3
//
//        int maxVowels = 0;
//        String maxVowelCity = "";
//
//        for(int i = 0; i < cities.size(); i++){
//            String city = cities.get(i);
//
//            int count = countVowels(city);
//
//            if(count > maxVowels){
//                maxVowels = count;
//                maxVowelCity = city;
//            }
//        }
//
//        System.out.println("City - " + maxVowelCity + " has maximum number of vowels which are - " + maxVowels);


         int[] arr = {2, 3, 4, 5, 6, 7, 8}; // consist of unique elements
         int target = 8;
        // count of all possible pairs which result to target
        // [ (2, 6), (3, 5)] => 2

        int count = 0;
        List<List<Integer>> pairs = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], true);
        }

        for(int i = 0; i < arr.length; i++){
            int otherElement = target - arr[i];
            if(map.containsKey(otherElement) && arr[i] != otherElement){
                List<Integer> al = new ArrayList<>();
                al.add(arr[i]);
                al.add(otherElement);
                pairs.add(al);
                count++;
                map.remove(arr[i]);
            }
        }

        System.out.println(count);
        System.out.println(pairs);
    }

    public static int countVowels(String str){

        HashSet<Character> set = new HashSet(); // 16
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        System.out.println(set);

        int count = 0;
        for(int j = 0; j < str.length(); j++){
            if(set.contains(str.charAt(j))){
                count++;
            }
        }

        return count;
    }
}
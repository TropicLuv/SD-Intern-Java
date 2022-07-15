import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Exercises_Sweeft {
    public Boolean isPalindrome(String text){
        if(text.length() < 2)
            return Boolean.TRUE;
        if(text.charAt(0) == text.charAt(text.length() - 1))
            return isPalindrome(text.substring(1, text.length() - 1));
        return Boolean.FALSE;
    }

    public int minSplit(int amount){
        int coins = 0;
        if (amount <= 0)
            return coins;
        while(amount > 0){
            coins ++;
            if(amount >= 50)
                amount -= 50;
            else if (amount >= 20)
                amount -= 20;
            else if (amount >= 10)
                amount -= 10;
            else if (amount >= 5)
                amount -= 5;
            else amount -= 1;
        }
        return coins;
    }

    public int notContains(int[] array){
        AtomicInteger i = new AtomicInteger(0);
        List<Integer> listOfIntegers = new ArrayList<>();

        for(Integer num : array) listOfIntegers.add(num);

        Integer [] a = listOfIntegers.stream().filter(x -> x > 0 ).map(Integer.class::cast).collect(Collectors.toSet()).
                stream().filter(x-> x == (i.incrementAndGet())).toArray(Integer[]::new);

        if(a.length == 0) return 1;
        return a[a.length - 1] + 1;
    }

    
    public Boolean isProperly(String sequence){
        if(sequence.length() %2 != 0) return Boolean.FALSE;
        int k = 0;
        for (int i = 0; i<= sequence.length() - 1; i++){
            if (k<0) return Boolean.FALSE;
            if (sequence.charAt(i) == '(')
                k++;
            else
                k--;
        }
        if(k == 0) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public static long fact(int n){
        if(n == 0) return 1;
        return n * fact(n-1);
    }

    public int countVariants(int stairsCount){
        if(stairsCount < 0) return -1;
        int returnValue = 0, twoStairs = 0;
        while (twoStairs <= stairsCount){
            returnValue += (fact(stairsCount)/((fact(twoStairs))*(fact(stairsCount-- - twoStairs++))));
        }
        return returnValue;
    }



public static void main(String[] args) {
        var a = new Exercises_Sweeft();
    System.out.println("__________isPalindrome_____________");
    System.out.println("isPalindrome Test 1 -> (\"hello_SWEEFT!\") : " + a.isPalindrome("hello_SWEEFT!"));
    System.out.println("isPalindrome Test 2 -> (\"olo1olo\") : " + a.isPalindrome("olo1olo"));
    System.out.println("isPalindrome Test 3 -> (\"a\") : " + a.isPalindrome("a"));
    System.out.println("isPalindrome Test 4 -> (\"\") : " + a.isPalindrome(""));

    System.out.println("__________minSplit_____________");
    System.out.println("minSplit Test 1 -> (99) : " + a.minSplit(99));
    System.out.println("minSplit Test 2 -> (100) : " + a.minSplit(100));

    System.out.println("__________notContains_____________");
    System.out.println("notContains Test 1 -> ({1,2,3}) : " + a.notContains(new int [] {1,2,3}));
    System.out.println("notContains Test 2 -> ({-1,2,3}) : " + a.notContains(new int [] {-1,2,3}));
    System.out.println("notContains Test 3 -> ({1,2,3,4,5,6,8}) : " + a.notContains(new int [] {1,2,3,4,5,6,8}));

    System.out.println("__________isProperly_____________");
    System.out.println("isProperly Test 1 -> \"()(())\" : " + a.isProperly("()(())"));
    System.out.println("isProperly Test 2 -> \")()(\" : " + a.isProperly(")()("));

    System.out.println("__________countVariants_____________");
    System.out.println("countVariants Test 1 -> \"(5)\" : " + a.countVariants(5));
    System.out.println("countVariants Test 2 -> \"(20)\" : " + a.countVariants(20));
    System.out.println("____________________________________");
}

}

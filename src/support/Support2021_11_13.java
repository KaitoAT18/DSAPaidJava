package support;

import java.util.ArrayList;
import java.util.List;

public class Support2021_11_13 {
    public static void main(String[] args) {
        System.out.println(findPrimeNumber(10));
        System.out.println(findPrimeNumber(20));
        System.out.println(findPrimeNumber(5));
    }

    private static List<Integer> findPrimeNumber(int n) {
        List<Integer> result = new ArrayList<>();
        if(n < 2) {
            return result;
        }
        result.add(2);
        //                      b8
        for (int i = 3; i < n; i+= 2) {
            boolean flag = true; // b3
            //      b4                          b6
            for (int j = 0; j < result.size(); j++) {
                if(i % result.get(j) == 0) { // b5
                    flag = false;
                }
            }
            if(flag == true) {
                result.add(i);
            }
        }
        return result;
    }
}

package prgmrs;

import java.util.*;

public class 최소공배수 {
    public static void main(String[] args) {
        int[] array ={100,100,100};
        System.out.println(lcm(array));
    }

    private static int gcd(int a,int b){
        while(b!=0){
            int r = a%b;
            a= b;
            b= r;
        }
        return a;
    }

    private static int lcm(int a,int b){
        return a * (b / gcd(a,b));
    }

    private static int lcm(int[] array){
        int result = array[0];

        for(int i=1; i<array.length; i++){
            result = lcm(result,array[i]);
        }

        return result;
    }

}

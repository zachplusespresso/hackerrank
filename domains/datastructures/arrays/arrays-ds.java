import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        int[] array = new int[num];

        for(int i = 0; i < num; i++){
            array[i] = in.nextInt();
        }

        for(int i = num - 1; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
    }
}

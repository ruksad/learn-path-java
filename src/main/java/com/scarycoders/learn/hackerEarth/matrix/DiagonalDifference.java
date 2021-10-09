package com.scarycoders.learn.hackerEarth.matrix;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DiagonalDifference {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
        int leftDiag=0;
        int rigthDiag=0;
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i==j){
                    leftDiag+=arr[i][j];
                }
                if(i+j==arr.length-1){
                    rigthDiag+=arr[i][j];
                }
            }
        }
        return Math.abs(leftDiag-rigthDiag);
    }

    static void plusMinus(int[] arr) {
        int arrsize=arr.length;
        //double positiveFraction,negativeFraction,zeroFraction=0.0;
        double positiveCount=0,negativeCount = 0,zeroCount=0;
        for(int i=0;i<arrsize;i++){
            if(arr[i]>0){
                positiveCount+=1;
            }else if(arr[i]<0){
                negativeCount+=1;
            }else{
                zeroCount+=1;
            }
        }
        BigDecimal positiveFraction = BigDecimal.valueOf(positiveCount / arrsize).setScale(6,BigDecimal.ROUND_HALF_UP);
        BigDecimal negativeFraction = BigDecimal.valueOf(negativeCount / arrsize).setScale(6,BigDecimal.ROUND_HALF_UP);
        BigDecimal zeroFraction = BigDecimal.valueOf(zeroCount / arrsize).setScale(6,BigDecimal.ROUND_HALF_UP);
        System.out.println(""+positiveFraction);
        System.out.println(""+negativeFraction);
        System.out.println(""+zeroFraction);


    }

    static void staircase(int n) {

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+j>=n-1){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }
                if(j==n-1){
                    System.out.println();
                }
            }
        }

    }
    /*
        convert time 07:05:45PM to 19:05:45
     */
    static String timeConversion(String s) throws ParseException {
        SimpleDateFormat to = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat from = new SimpleDateFormat("hh:mm:ssa");
        Date parse = from.parse(s);
        return to.format(parse);

    }

    static int[] gradingStudents(int[] grades) {
        int[] result=new int[grades.length];

        for(int i=0;i<grades.length;i++){
            if(grades[i]<38){
                result[i]=grades[i];
            }else{
                int multiple=grades[i]/5;
                if((grades[i]-((multiple+1)*5))<3){
                    result[i]=(multiple+1)*5;
                }else{
                    result[i]=grades[i];
                }
            }
        }
        return result;

    }
    static void miniMaxSum(int[] arr) {
        long minSum=0,maxSum=0;
      Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1)
                minSum+=arr[i];
            if(i>0)
                maxSum+=arr[i];
        }
        System.out.println(minSum+" "+maxSum);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");



        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }*/

//        int[][] arr = {{11,2,4},{4,5,6},{10,8,-12}};
//        int result = diagonalDifference(arr);
//        System.out.println(result);
       int [] arr={73,67, 38,33};
//        plusMinus(arr);
      //  staircase(6);
//        try {
//            System.out.println(timeConversion("07:05:45PM"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        final int[] ints = gradingStudents(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}

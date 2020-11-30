package main.java.com.bsu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Scanner;

class Sort implements Runnable {
    Integer[] arr;
    int typeOfTask;

    public Sort(Integer[] arr, int typeOfTask) {
        this.arr = arr;
        this.typeOfTask = typeOfTask;
    }

    @Override
    public void run() {
        switch (typeOfTask) {
            case 1:
                Arrays.sort(arr, Comparator.naturalOrder());
                break;
            case 2:
                Arrays.sort(arr, Comparator.reverseOrder());
                break;
            case 3:
                Arrays.sort(arr, (o1, o2) -> {
                    int l1 = o1.toString().length();
                    int l2 = o2.toString().length();
                    return l1 - l2;
                });
                break;
            case 4:
                Arrays.sort(arr, (o1, o2) -> {
                    int l1 = o1.toString().length();
                    int l2 = o2.toString().length();
                    return l2 - l1;
                });
                break;
        }
    }
}

public class Main {
    static public void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter number of elements");
            int n = scan.nextInt();
            Integer[] arr = new Integer[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 300);
            }

            System.out.println("n = " + n);
            for (int e : arr) {
                System.out.println(e);
            }

            System.out.println("1. Для сортировки по возрастанию значения чисел");
            System.out.println("2. Для сортировки по убыванию значения чисел");
            System.out.println();
            System.out.println("3. Для сортировки по возрастанию длины чисел");
            System.out.println("4. Для сортировки по убыванию длины чисел");

            int typeOfTask = scan.nextInt();

            Thread sort = new Thread(new Sort(arr, typeOfTask));
            sort.start();
            sort.join();

            for (int e : arr) {
                System.out.println(e);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}

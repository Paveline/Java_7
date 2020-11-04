package main.java.com.bsu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class Sort implements Runnable {
    Integer[] arr;
    String direction;
    String type = "";

    public Sort(Integer[] arr, String direction, String type) {
        this.arr = arr;
        this.direction = direction;
        this.type = type;
    }

    @Override
    public void run() {
        if (type.equals("numb")) {
            if (direction.equals("up")) {
                Arrays.sort(arr, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                });
            } else {
                Arrays.sort(arr, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                });
            }
        } else {
            if (direction.equals("up")) {
                Arrays.sort(arr, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        int l1 = o1.toString().length();
                        int l2 = o2.toString().length();
                        return l1 - l2;
                    }
                });
            } else {
                Arrays.sort(arr, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        int l1 = o1.toString().length();
                        int l2 = o2.toString().length();
                        return l2 - l1;
                    }
                });
            }
        }

        for (int e : arr) {
            System.out.println(e);
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
                arr[i] = (int) (Math.random() * 30);
            }

            System.out.println("n = " + n);
            for (int e : arr) {
                System.out.println(e);
            }

            String direction;
            String type;

            System.out.println("Для сортировки по возрастанию/убыванию напишите up/down");
            String str = scan.next();

            if (str.equals("up") || str.equals("down")) {
                direction = str;
            } else throw new IllegalArgumentException("Данной функции нет");

            System.out.println("Для сортировки по значению чисел/количеству цифр напишите numb/length");
            str = scan.next();
            if (str.equals("numb") || str.equals("length")) {
                type = str;
            } else throw new IllegalArgumentException("Данной функции нет");

            Thread sort = new Thread(new Sort(arr, direction, type));
            sort.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}

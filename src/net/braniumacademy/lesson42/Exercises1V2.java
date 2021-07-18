package net.braniumacademy.lesson42;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exercises1V2 {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int max = n;
        if (n == 1) {
            System.out.println(1);
        } else {
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i = 0; i < n; i++) {
                int x = input.nextInt();
                queue.add(x);
                while (!queue.isEmpty() && queue.peek() == max) {
                    System.out.print(queue.poll() + " ");
                    max--;
                }
                System.out.println();
            }
        }
    }
}

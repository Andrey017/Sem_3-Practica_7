package ru.mirea;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        int[] a_1 = {1, 3, 5, 7, 9};
        int[] a_2 = {2, 4, 6, 8, 0};

        ArrayDeque<Integer> stack_1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack_2 = new ArrayDeque<>();

        for (int i = 0; i < 5; i++) {
            stack_1.add(a_1[i]);
            stack_2.add(a_2[i]);
        }

        int n = 0;
        boolean result = false;
        System.out.println(stack_1);
        System.out.println(stack_2);
        System.out.println(" ");

        for (int i = 0; i < 106; i++) {
            n++;
            if (stack_1.getFirst() < stack_2.getFirst() || ((stack_1.getFirst() == 9) && (stack_2.getFirst() == 0))) {
                stack_1.add(stack_2.pop());
                stack_1.add(stack_1.pop());
            } else if (stack_1.getFirst() > stack_2.getFirst() || ((stack_1.getFirst() == 0) && (stack_2.getFirst() == 9))) {
                stack_2.add(stack_1.pop());
                stack_2.add(stack_2.pop());
            }

            if (stack_1.size() == 0) {
                System.out.println("First " + n);
                result = true;
                break;
            } else if (stack_2.size() == 0) {
                System.out.println("Second " + n);
                result = true;
                break;
            }
            System.out.println(stack_1);
            System.out.println(stack_2);
            System.out.println(" ");
        }
        if (!result){
            System.out.println("botva " + n);
        }
    }
}

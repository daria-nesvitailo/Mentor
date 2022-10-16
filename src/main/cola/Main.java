package main.cola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> cola = new ArrayList<>();
        List<String> theory = Arrays.asList("Sheldon", "Leonard", "Volovitc", "Kutrapalli", "Penny");
        Scanner sc = new Scanner(System.in);
        System.out.println("How many cup cola do you want?");
        String line = sc.nextLine();
        int parseInt = Integer.parseInt(line);
        if (parseInt <= 5) {
            for (int i = 0; i < theory.size(); i++) {
                if (parseInt <= i) {
                    cola.add(theory.get(i));
                }
            }
            for (int i = 0; i < theory.size(); i++) {
                if (parseInt > i) {
                    cola.add(theory.get(i));
                    cola.add(theory.get(i));
                }
            }
        }

        for (String friend : cola) {
            System.out.println(friend);
        }
    }

}

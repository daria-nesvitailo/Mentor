package main.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
            String s = new String(Files.readAllBytes(Paths.get("/Users/daria/Workspace/Mentor/src/main/reader/article")));

            Map<String, Integer> result = new HashMap<>();
            for (String letter : alphabet) {
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (letter.equalsIgnoreCase(String.valueOf(s.charAt(i)))) {
                        count++;
                    }
                }

                result.put(letter, count);
            }

            List<Map.Entry<String, Integer>> sorted = new ArrayList<>(result.entrySet());
            sorted.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

            for (Map.Entry<String, Integer> entry : sorted) {
                System.out.println(entry.getKey() + " repeats " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package com.kstyer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceService {
    public static void userInput() {
        Scanner sc = new Scanner(System.in);
        boolean shouldContinue;
        List<String> allLines = new ArrayList<>();
        do {
            System.out.println("Enter exit to quit");
            String currentLine = sc.nextLine();
            allLines.add(currentLine);
            shouldContinue = !"exit".equals(currentLine);

        }
        while (shouldContinue);
        System.out.println("your second entry was" + allLines.get(1));
    }
}

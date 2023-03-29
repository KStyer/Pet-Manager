package com.kstyer;

import com.kstyer.models.Cat;
import com.kstyer.models.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceService {
    public static void userInput() {
        Scanner sc = new Scanner(System.in);
        boolean shouldContinue;

        List<Pet> allPets = new ArrayList<>();
        Pet tempi = new Cat("Tempi");
        Pet pasha = new Cat("Pasha");
        allPets.add(tempi);
        allPets.add(pasha);

        do {
            System.out.println("Type 1 to view all pets, or enter exit to quit");
            String currentLine = sc.nextLine();
           // allLines.add(currentLine);
            boolean isOne = "1".equals(currentLine);
            if (isOne){
                for(int i = 0; i < allPets.size(); i++){
                    System.out.println(allPets.get(i).getName());
                }

            }
            shouldContinue = !"exit".equals(currentLine);

        }
        while (shouldContinue);
        System.out.println("You have exited Pet Manager");
    }
}

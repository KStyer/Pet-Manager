package com.kstyer;

import com.kstyer.models.Cat;
import com.kstyer.models.Pet;
import com.kstyer.models.Rat;

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
                System.out.println("****************************************");
                System.out.println("* NUMBER * PET                         *");
                System.out.println("****************************************");

                for(int i = 0; i < allPets.size(); i++){
                    System.out.printf("* %-6d * Name: %-18s %2s *%n", (i + 1), allPets.get(i).getName(), allPets.get(i).getType());
                    System.out.println("****************************************");
                   // System.out.println((i + 1) + ": " + allPets.get(i).getName());
                }
               // for(Pet currentPet : allPets){
               //     System.out.println(currentPet.getName());
               // }
            }
            shouldContinue = !"exit".equals(currentLine);

        }
        while (shouldContinue);
        System.out.println("You have exited Pet Manager");
    }
}

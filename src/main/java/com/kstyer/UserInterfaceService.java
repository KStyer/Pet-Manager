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
            System.out.println("Type 1 to view all pets, type 2 to create a new pet, or enter exit to quit");
            String currentLine = sc.nextLine();
           // allLines.add(currentLine);
            boolean isOne = "1".equals(currentLine);
            boolean isTwo = "2".equals(currentLine);
            if (isOne){
                displayAllPets(allPets, sc);
            }

            if (isTwo){
                System.out.println("Enter the name of the new pet");
                String newPetName = sc.nextLine();
                System.out.println("Enter the type of pet (Cat/Rat)");
                String newPetType = sc.nextLine();

                switch (newPetType.toLowerCase()) {

                    case "cat":
                        System.out.println("you added a Cat");
                        Pet newlyAddedCat = new Cat(newPetName);
                        allPets.add(newlyAddedCat);
                        break;

                    case "rat":
                        System.out.println("you added a Rat");
                        Pet newlyAddedRat = new Rat(newPetName);
                        allPets.add(newlyAddedRat);

                        break;

                    default:
                        System.out.println("I didn't understand that.");

                }

            }

            shouldContinue = !"exit".equals(currentLine);

        }
        while (shouldContinue);
        System.out.println("You have exited Pet Manager");
    }

    private static void displayAllPets(List<Pet> allPets, Scanner sc) {
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
}

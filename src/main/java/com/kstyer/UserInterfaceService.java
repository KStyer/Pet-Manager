package com.kstyer;

import com.kstyer.models.Cat;
import com.kstyer.models.Pet;
import com.kstyer.models.PetTypes;
import com.kstyer.models.Rat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceService {
    public static void userInput() {
        Scanner sc = new Scanner(System.in);
        boolean shouldContinue = true;

        List<Pet> allPets = new ArrayList<>();


        do {
            System.out.println("Type 1 to view all pets, type 2 to create a new pet, type 3 to sort all pets, or enter exit to quit");
            String currentLine = sc.nextLine();
           // allLines.add(currentLine);

            switch (currentLine.toLowerCase()) {

                case "1":
                    displayAllPets(allPets);
                    break;

                case "2":
                    addNewPet(allPets, sc);
                    break;

                case "3":
                    allPets = sortAllPets(allPets);
                    break;

                case "exit":
                    shouldContinue = false;
                    break;

                default:
                    System.out.println("I didn't understand that.");

            }

//            if ("1".equals(currentLine)){
//                displayAllPets(allPets);
//            }
//
//            if ("2".equals(currentLine)){
//                addNewPet(allPets, sc);
//            }
//
//            if ("exit".equals(currentLine)){
//                shouldContinue = false;
//            }

        }
        while (shouldContinue);
        System.out.println("You have exited Pet Manager");
    }

    private static List<Pet> sortAllPets(List<Pet> unsortedPets) {
        List<Pet> sortedPets = new ArrayList<>();
        if (!unsortedPets.isEmpty()){
            sortedPets.add(unsortedPets.get(0));

            for(int i = 1; i < unsortedPets.size(); i++) {
                for(int j = 0; j < sortedPets.size(); j++){
                    if(unsortedPets.get(i).getName().compareToIgnoreCase(sortedPets.get(j).getName()) < 0) {
                        sortedPets.add(j, unsortedPets.get(i));
                        break;
                    }
                    if(j == sortedPets.size() -1) {
                        sortedPets.add(unsortedPets.get(i));
                        break;
                    }
                }
            }
        }

        displayAllPets(sortedPets);
        return sortedPets;
    }

    private static void addNewPet(List<Pet> allPets, Scanner sc) {
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

//        switch (PetTypes.valueOf(newPetType.toUpperCase())) {
//            case CAT -> {
//                System.out.println("you added a Cat");
//                Pet newlyAddedCat = new Cat(newPetName);
//                allPets.add(newlyAddedCat);
//            }
//            case RAT -> {
//                System.out.println("you added a Rat");
//                Pet newlyAddedRat = new Rat(newPetName);
//                allPets.add(newlyAddedRat);
//            }
//            default -> System.out.println("I didn't understand that.");
//        }
    }



    private static void displayAllPets(List<Pet> allPets) {
        System.out.println("****************************************");
        System.out.println("* NUMBER * PET                         *");
        System.out.println("****************************************");

//        if (allPets.size() == 0){
//            System.out.println("* NO PETS HAVE BEEN ENTERED YET        *");
//            System.out.println("****************************************");
//        }

        if (allPets.isEmpty()){
            System.out.println("* NO PETS HAVE BEEN ENTERED YET        *");
            System.out.println("****************************************");
        }

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

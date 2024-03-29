package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Optional;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Optional<Pet> registerNewPet() {
        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        if (DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            return Optional.of(buildPet(type));
        } else {
            System.out.println("Unknown pet type: " + type + ". Please enter a valid type (dog / cat).");
            return Optional.empty();
        }

    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);

        System.out.print("Age: ");
        String age;
        do {
            age = Main.SCANNER.nextLine();

            // Перевірка, чи введене значення для віку є числом
            if (!age.matches("\\d+")) {
                System.out.println("Invalid age. Please enter a numeric value for age.");
            } else {
                int ageValue = Integer.parseInt(age);
                if (ageValue < 1 || ageValue > 20) {
                    System.out.println("Invalid age. Please enter a value between 1 and 20.");
                    age = ""; // Скидаємо значення age, щоб повторно запросити введення
                }
            }
        } while (age.isEmpty() || !age.matches("\\d+") || Integer.parseInt(age) < 1 || Integer.parseInt(age) > 20);

        pet.setAge(age);

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());

        System.out.print("Sex (male / female): ");
        String sex;
        do {
            sex = Main.SCANNER.nextLine();
            if (!sex.equalsIgnoreCase("male") && !sex.equalsIgnoreCase("female")) {
                System.out.println("Invalid input. Please enter 'male' or 'female'.");
            }
        } while (!sex.equalsIgnoreCase("male") && !sex.equalsIgnoreCase("female"));
        pet.setSex(sex);

        if (type.equals(DOG_TYPE)) {
            System.out.println("Size (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog) pet).setSize(Dog.Size.fromString(size));
        }   else if (type.equals(CAT_TYPE)) {
            System.out.println("Size (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            // Задайте розмір кота
            ((Cat) pet).setSize(Cat.Size.fromString(size));
        }

        return pet;
    }
}
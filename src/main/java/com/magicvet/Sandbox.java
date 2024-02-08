package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {

    public static void main(String[] args) {
        Dog dog1 = createDog(Dog.Size.M, "5", "Dog1", "Owner1", Pet.HealthState.GOOD);
        Dog dog2 = createDog(Dog.Size.S, "3", "Dog2", "Owner2", Pet.HealthState.EXCELLENT);
        Dog dog3 = createDog(Dog.Size.XS, "1", "Dog3", "Owner3", Pet.HealthState.FAIR);
        Dog dog4 = createDog(Dog.Size.XL, "7", "Dog4", "Owner4", Pet.HealthState.POOR);
        Dog dog5 = createDog(Dog.Size.L, "6", "Dog5", "Owner5", Pet.HealthState.UNKNOWN);

        Cat cat1 = createCat(Cat.Size.M, "2", "Cat1", "Owner1", Pet.HealthState.GOOD);
        Cat cat2 = createCat(Cat.Size.L, "4", "Cat2", "Owner2", Pet.HealthState.EXCELLENT);
        Cat cat3 = createCat(Cat.Size.S, "3", "Cat3", "Owner3", Pet.HealthState.FAIR);
        Cat cat4 = createCat(Cat.Size.XS, "1", "Cat4", "Owner4", Pet.HealthState.POOR);
        Cat cat5 = createCat(Cat.Size.XL, "5", "Cat5", "Owner5", Pet.HealthState.UNKNOWN);

        Dog[] dogs = {dog1, dog2, dog3, dog4, dog5};
        Arrays.sort(dogs, Comparator.comparingInt(dog -> dog.getSize().getValue()));

        for (Dog dog : dogs) {
            System.out.println(dog);
        }

        Pet[] pets = {dog1, dog2, dog3, dog4, dog5, cat1, cat2, cat3, cat4, cat5};

        // Сортуємо тварин за віком
        Arrays.sort(pets, Comparator.comparingInt(Pet::getAgeAsInt));

        // Виводимо відсортований список
        for (Pet pet : pets) {
            System.out.println(pet + ", Registration Date: " + pet.registrationDate.format(Pet.FORMATTER));
        }

        // Сортуємо тварин за станом здоров'я
        Arrays.sort(pets, Comparator.comparingInt(pet -> pet.getHealthState().ordinal()));

        // Виводимо відсортований список за станом здоров'я
        for (Pet pet : pets) {
            System.out.println(pet + ", Registration Date: " + pet.registrationDate.format(Pet.FORMATTER));
        }
    }

    private static Dog createDog(Dog.Size size, String age, String name, String owner, Pet.HealthState healthState) {
        Dog dog = new Dog(size, "someType", "male", age, name, owner, healthState);
        dog.setAge(age);
        return dog;
    }

    private static Cat createCat(Cat.Size size, String age, String name, String owner, Pet.HealthState healthState) {
        Cat cat = new Cat("someType", "female", age, name, owner, size, healthState);
        cat.setAge(age);
        return cat;
    }
}

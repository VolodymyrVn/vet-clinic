package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {

    public static void main(String[] args) {
        Dog[] dogs = {
                createDog(Dog.Size.M, "5", "Dog1", "Owner1", Pet.HealthState.GOOD),
                createDog(Dog.Size.S, "3", "Dog2", "Owner2", Pet.HealthState.EXCELLENT),
                createDog(Dog.Size.XS, "1", "Dog3", "Owner3", Pet.HealthState.FAIR),
                createDog(Dog.Size.XL, "7", "Dog4", "Owner4", Pet.HealthState.POOR),
                createDog(Dog.Size.L, "6", "Dog5", "Owner5", Pet.HealthState.UNKNOWN)
        };

        // Сортуємо тварин за розміром
        Arrays.sort(dogs, Comparator.comparingInt(dog -> dog.getSize().ordinal()));

        // Використовуємо Stream API для виведення
        Arrays.stream(dogs).forEach(System.out::println);

        // Те ж саме для котів
        Cat[] cats = {
                createCat(Cat.Size.M, "2", "Cat1", "Owner1", Pet.HealthState.GOOD),
                createCat(Cat.Size.L, "4", "Cat2", "Owner2", Pet.HealthState.EXCELLENT),
                createCat(Cat.Size.S, "3", "Cat3", "Owner3", Pet.HealthState.FAIR),
                createCat(Cat.Size.XS, "1", "Cat4", "Owner4", Pet.HealthState.POOR),
                createCat(Cat.Size.XL, "5", "Cat5", "Owner5", Pet.HealthState.UNKNOWN)
        };

        // Сортуємо тварин за розміром
        Arrays.sort(cats, Comparator.comparingInt(cat -> cat.getSize().ordinal()));

        // Використовуємо Stream API для виведення
        Arrays.stream(cats).forEach(System.out::println);

        Pet[] pets = Arrays.copyOf(dogs, dogs.length + cats.length);
        System.arraycopy(cats, 0, pets, dogs.length, cats.length);

        // Сортуємо тварин за станом здоров'я
        Arrays.sort(pets, Comparator.comparingInt(pet -> pet.getHealthState().ordinal()));

        // Виводимо відсортований список за станом здоров'я
        for (Pet pet : pets) {
            System.out.println(pet + ", Registration Date: "
                    + pet.registrationDate.format(Pet.FORMATTER)
                    + ", Health State: " + pet.getHealthState());
        }
    }

    private static Dog createDog(Dog.Size size, String age, String name, String owner, Pet.HealthState healthState) {
        Dog dog = new Dog(size, "someType", "male", age, name, owner, healthState);
        dog.setAge(age);
        dog.setHealthState(healthState); // Встановлення healthState
        return dog;
    }

    private static Cat createCat(Cat.Size size, String age, String name, String owner, Pet.HealthState healthState) {
        Cat cat = new Cat("someType", "female", age, name, owner, size, healthState);
        cat.setAge(age);
        cat.setHealthState(healthState); // Встановлення healthState
        return cat;
    }
}

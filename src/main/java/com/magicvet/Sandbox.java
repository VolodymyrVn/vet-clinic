package main.java.com.magicvet;

import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {

    public static void main(String[] args) {
        Dog dog1 = new Dog(Dog.Size.M);
        dog1.setAge("5");

        Dog dog2 = new Dog(Dog.Size.S);
        dog2.setAge("3");

        Dog dog3 = new Dog(Dog.Size.XS);
        dog3.setAge("1");

        Dog dog4 = new Dog(Dog.Size.XL);
        dog4.setAge("7");

        Dog dog5 = new Dog(Dog.Size.L);
        dog5.setAge("6");

        Cat cat1 = new Cat();
        cat1.setAge("2");
        cat1.setSize(Cat.M);

        Cat cat2 = new Cat();
        cat2.setAge("4");
        cat2.setSize(Cat.L);

        Cat cat3 = new Cat();
        cat3.setAge("3");
        cat3.setSize(Cat.S);

        Cat cat4 = new Cat();
        cat4.setAge("1");
        cat4.setSize(Cat.XS);

        Cat cat5 = new Cat();
        cat5.setAge("5");
        cat5.setSize(Cat.XL);

        dog1 = new Dog(Dog.Size.M,
                "someType",
                "male",
                "5",
                "Dog1",
                "Owner1",
                Pet.HealthState.GOOD);
        dog1.setAge("5");

        dog2 = new Dog(Dog.Size.S,
                "someType",
                "female",
                "3",
                "Dog2",
                "Owner2",
                Pet.HealthState.EXCELLENT);
        dog2.setAge("3");

        dog3 = new Dog(Dog.Size.XS,
                "someType",
                "male",
                "1",
                "Dog3",
                "Owner3",
                Pet.HealthState.FAIR);
        dog3.setAge("1");

        dog4 = new Dog(Dog.Size.XL,
                "someType",
                "female",
                "7",
                "Dog4",
                "Owner4",
                Pet.HealthState.POOR);
        dog4.setAge("7");

        dog5 = new Dog(Dog.Size.L,
                "someType",
                "male",
                "6",
                "Dog5",
                "Owner5",
                Pet.HealthState.UNKNOWN);
        dog5.setAge("6");

        cat1 = new Cat(
                "someType",
                "female",
                "2",
                "Cat1",
                "Owner1",
                Cat.M, Pet.HealthState.GOOD);
        cat1.setAge("2");

        cat2 = new Cat(
                "someType",
                "female",
                "4",
                "Cat2",
                "Owner2",
                Cat.L, Pet.HealthState.EXCELLENT);
        cat2.setAge("4");

        cat3 = new Cat(
                "someType",
                "female",
                "3",
                "Cat3",
                "Owner3",
                Cat.S, Pet.HealthState.FAIR);
        cat3.setAge("3");

        cat4 = new Cat(
                "someType",
                "female",
                "1",
                "Cat4",
                "Owner4",
                Cat.XS, Pet.HealthState.POOR);
        cat4.setAge("1");

        cat5 = new Cat(
                "someType",
                "female",
                "5",
                "Cat5",
                "Owner5",
                Cat.XL, Pet.HealthState.UNKNOWN);
        cat5.setAge("5");




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
            System.out.println(pet);
        }

        // Сортуємо тварин за станом здоров'я
        Arrays.sort(pets, Comparator.comparingInt(pet -> pet.getHealthState().ordinal()));

        // Виводимо відсортований список за станом здоров'я
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}

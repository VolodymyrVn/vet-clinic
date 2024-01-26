package main.java.com.magicvet;

import main.java.com.magicvet.comparator.PetAgeComparator;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Arrays;

public class Sandbox {

    public static void main(String[] args) {
        Dog dog1 = new Dog(Dog.M);
        dog1.setAge("5");

        Dog dog2 = new Dog(Dog.S);
        dog2.setAge("3");

        Dog dog3 = new Dog(Dog.XS);
        dog3.setAge("1");

        Dog dog4 = new Dog(Dog.XL);
        dog4.setAge("7");

        Dog dog5 = new Dog(Dog.L);
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

        Pet[] pets = {dog1, dog2, dog3, dog4, dog5, cat1, cat2, cat3, cat4, cat5};

        // Сортуємо тварин за віком
        Arrays.sort(pets, new PetAgeComparator());

        // Виводимо відсортований список
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}

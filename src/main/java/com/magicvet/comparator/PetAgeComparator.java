package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Pet;

import java.util.Comparator;

public class PetAgeComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet pet1, Pet pet2) {
        return pet1.getAgeAsInt() - pet2.getAgeAsInt();
    }
}

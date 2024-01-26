package main.java.com.magicvet.model;

import java.util.Objects;

public class Cat extends Pet {

    public static final String XS = "XS";
    public static final String S = "S";
    public static final String M = "M";
    public static final String L = "L";
    public static final String XL = "XL";

    private String size;

    public Cat() {
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public int getAgeAsInt() {
        // Реалізація отримання числового віку для котів.
        try {
            return Integer.parseInt(getAge());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public int compareTo(Pet otherPet) {
        return Integer.compare(this.getAgeAsInt(), otherPet.getAgeAsInt());
    }

    @Override
    public String toString() {
        return String.format("Cat{type='%s', sex='%s', age='%s', name='%s', ownerName='%s', size='%s'}",
                getType(), getSex(), getAge(), getName(), getOwnerName(), size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

}

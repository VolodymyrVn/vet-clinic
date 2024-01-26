package main.java.com.magicvet.model;
import java.util.Objects;
public class Dog extends Pet {

    public static final String XS = "XS";
    public static final String S = "S";
    public static final String M = "M";
    public static final String L = "L";
    public static final String XL = "XL";

    private String size;

    public Dog() { }

    public Dog(String size) {
        this.size = size;
    }


    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public int getAgeAsInt() {
        // Реалізація отримання числового віку для собаки.
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
        return String.format("Dog{type='%s', sex='%s', age='%s', name='%s', ownerName='%s', size='%s'}",
                getType(), getSex(), getAge(), getName(), getOwnerName(), size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
}

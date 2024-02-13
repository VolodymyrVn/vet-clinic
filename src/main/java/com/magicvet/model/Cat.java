package main.java.com.magicvet.model;

import java.util.Objects;

public class Cat extends Pet {

    public enum Size {
        XS, S, M, L, XL, UNKNOWN;

        public static Size fromString(String value) {
            for (Size size : Size.values()) {
                if (size.toString().equalsIgnoreCase(value)) {
                    return size;
                }
            }

            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }
    }

    private Size size;

    public Cat() {
        super("", "", "", "", "");
    }

    public Cat(Size size) {
        super("", "", "", "", "");
        this.size = size;
    }

    public Cat(String type, String sex, String age, String name, String ownerName, Size size, HealthState healthState) {
        super(type, sex, age, name, ownerName);
        this.size = size;
        setHealthState(healthState);
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public int getAgeAsInt() {
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
        return String.format("Pet{type=%s, sex=%s, age=%s, name=%s, ownerName=%s, size=%s}",
                getType(), getSex(), getAge(), getName(), getOwnerName(), size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return size == cat.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
}

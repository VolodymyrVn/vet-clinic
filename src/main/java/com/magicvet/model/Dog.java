package main.java.com.magicvet.model;
import java.util.Objects;
public class Dog extends Pet {

    private Size size;

    public Dog() {
        super("", "", "", "", "");
    }

    public Dog(Size size) {
        super("", "", "", "", "");
        this.size = size;
    }
    public Dog(Size size, String type, String sex, String age, String name, String ownerName, HealthState healthState) {
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

    public enum Size {
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);

        private final int value;

        Size(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
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
        return String.format("Pet{type=%s, sex=%s, age=%s, name=%s, ownerName=%s, size=%s}",
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

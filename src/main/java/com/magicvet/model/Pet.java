package main.java.com.magicvet.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public abstract class Pet implements Comparable<Pet> {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String type;
    private String sex;
    private String age;
    private String name;
    private String ownerName;
    private HealthState healthState;
    public final LocalDateTime registrationDate = LocalDateTime.now();

    public Pet(String type, String sex, String age, String name, String ownerName) {
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.ownerName = ownerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public HealthState getHealthState() { // ДОДАНО
        return healthState;
    }

    public void setHealthState(HealthState healthState) { // ДОДАНО
        this.healthState = healthState;
    }

    public void setHealthStateFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter health state (EXCELLENT, GOOD, FAIR, POOR, UNKNOWN):");
        String input = scanner.nextLine().toUpperCase();

        try {
            HealthState state = HealthState.valueOf(input);
            setHealthState(state);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Defaulting to CONSULTATION.");
            setHealthState(HealthState.CONSULTATION);
        }
    }

    public abstract int getAgeAsInt(); // Новий абстрактний метод для отримання числового віку.

    @Override
    public int compareTo(Pet otherPet) {
        return Integer.compare(this.getAgeAsInt(), otherPet.getAgeAsInt());
    }

    @Override
    public String toString() {
        return String.format("Pet{type=%s, sex=%s, age=%s, name=%s," +
                             " ownerName=%s, healthState=%s," +
                             " registrationDate=%s}",
                type, sex, age, name, ownerName, healthState, registrationDate.format(FORMATTER));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type) &&
                Objects.equals(sex, pet.sex) &&
                Objects.equals(age, pet.age) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName);
    }


    public enum HealthState {
        EXCELLENT,
        GOOD,
        FAIR,
        POOR,
        CONSULTATION, UNKNOWN
    }

}

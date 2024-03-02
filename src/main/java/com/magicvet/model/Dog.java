package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet {

    private Size size; // Розмір собаки

    public Dog() {
        // Виклик конструктора батьківського класу з порожніми рядками
        super("", "", "", "", "");
    }

    public Dog(Size size) {
        // Виклик конструктора батьківського класу з порожніми рядками
        super("", "", "", "", "");
        this.size = size; // Ініціалізація розміру собаки
    }

    public Dog(Size size, String type, String sex, String age, String name, String ownerName, HealthState healthState) {
        super(type, sex, age, name, ownerName); // Виклик конструктора батьківського класу з параметрами
        this.size = size; // Ініціалізація розміру собаки
        setHealthState(healthState); // Встановлення стану здоров'я
    }

    public void setSize(Size size) {
        this.size = size; // Встановлення розміру собаки
    }

    public Size getSize() {
        return size; // Отримання розміру собаки
    }

    @Override
    public int getAgeAsInt() {
        try {
            return Integer.parseInt(getAge()); // Перетворення рядкового віку на ціле число
        } catch (NumberFormatException e) {
            return 0; // Повернення 0 у разі невдалого перетворення
        }
    }

    @Override
    public String toString() {
        return String.format("Pet{type=%s, sex=%s, age=%s, name=%s," +
                        " ownerName=%s, size=%s, healthState=%s}",
                // Повернення рядка із даними про собаку
                getType(), getSex(), getAge(), getName(), getOwnerName(), size, getHealthState());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Перевірка на посилання на той самий об'єкт
        if (o == null || getClass() != o.getClass()) return false; // Перевірка на класи
        if (!super.equals(o)) return false; // Перевірка на спадковість
        Dog dog = (Dog) o; // Приведення до класу собаки
        return size == dog.size; // Порівняння розмірів собак
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size); // Обчислення хеш-коду
    }

    public enum Size {
        XS, S, M, L, XL, UNKNOWN; // Розміри собак та невідомий розмір

        // Метод для перетворення рядкового значення на об'єкт перерахування
        public static Size fromString(String value) {
            for (Size size : Size.values()) {
                if (size.toString().equals(value)) {
                    return size;
                }
            }     // Повідомлення у разі невдалого парсингу
            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);
            return UNKNOWN; // Повернення значення за замовчуванням
        }
    }
}

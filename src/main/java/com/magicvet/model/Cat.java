package main.java.com.magicvet.model;

import java.util.Objects;

public class Cat extends Pet {

    private Size size; // Розмір кота

    public Cat() {
        // Виклик конструктора батьківського класу з порожніми рядками
        super("", "", "", "", "");
    }

    public Cat(Size size) {
        // Виклик конструктора батьківського класу з порожніми рядками
        super("", "", "", "", "");
        this.size = size; // Ініціалізація розміру кота
    }

    public Cat(String type, String sex, String age, String name, String ownerName, Size size, HealthState healthState) {
        super(type, sex, age, name, ownerName); // Виклик конструктора батьківського класу з параметрами
        this.size = size; // Ініціалізація розміру кота
        setHealthState(healthState); // Встановлення стану здоров'я
    }

    public void setSize(Size size) {
        this.size = size; // Встановлення розміру кота
    }

    public Size getSize() {
        return size; // Отримання розміру кота
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
                // Повернення рядка із даними про кота
                getType(), getSex(), getAge(), getName(), getOwnerName(), size, getHealthState());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Перевірка на посилання на той самий об'єкт
        if (o == null || getClass() != o.getClass()) return false; // Перевірка на класи
        if (!super.equals(o)) return false; // Перевірка на спадковість
        Cat cat = (Cat) o; // Приведення до класу кота
        return size == cat.size; // Порівняння розмірів котів
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size); // Обчислення хеш-коду
    }

    public enum Size {
        XS, S, M, L, XL, UNKNOWN; // Розміри котів та невідомий розмір

        // Метод для перетворення рядкового значення на об'єкт перерахування
        public static Size fromString(String value) {
            for (Size size : Size.values()) {
                if (size.toString().equalsIgnoreCase(value)) {
                    return size;
                }
            } // Повідомлення у разі невдалого парсингу
            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);
            return UNKNOWN; // Повернення значення за замовчуванням
        }
    }
}

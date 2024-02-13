package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final Scanner SCANNER = new Scanner(System.in);

    public Client registerNewClient() {
        System.out.println("Please provide client details.");

        String email = getEmailFromUser();
        String firstName = getValidatedName("First name");
        String lastName = getValidatedName("Last name");
        String location = getLocationFromUser();

        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        // Використання методу fromString для обробки рядка location
        client.setLocation(fromString(location));

        System.out.println("New client: " + client.getFirstName() + " "
                + client.getLastName() + " ("
                + client.getEmail() + ")");

        return client;
    }

    // Доданий метод fromString для обробки рядка
    private static Client.Location fromString(String value) {
        for (Client.Location location : Client.Location.values()) {
            if (location.toString().equalsIgnoreCase(value)) {
                return location;
            }
        }

        System.out.println("Unable to parse value '" + value + "'. Using default value: " + Client.Location.UNKNOWN);
        return Client.Location.UNKNOWN;
    }

    private String getEmailFromUser() {
        String email;
        do {
            System.out.println("Email: ");
            email = SCANNER.nextLine();
            if (!isEmailValid(email)) {
                System.out.println("Provided email is invalid. Please enter a valid email.");
            }
        } while (!isEmailValid(email));
        return email;
    }

    private String getValidatedName(String fieldName) {
        String name;
        do {
            System.out.println(fieldName + ": ");
            name = SCANNER.nextLine();
            if (!isNameValid(name)) {
                System.out.println("Invalid " + fieldName + ". Please enter a valid " + fieldName + ".");
            }
        } while (!isNameValid(name));
        return name;
    }

    private String getLocationFromUser() {
        System.out.println("Location: ");
        return Main.SCANNER.nextLine();
    }

    private static boolean isEmailValid(String email) {
        String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isNameValid(String name) {
        String NAME_PATTERN = "^[a-zA-Z]{3,}$";
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}

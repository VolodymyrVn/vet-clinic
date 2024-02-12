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
        client.setLocation(Client.Location.valueOf(location));

        System.out.println("New client: " + client.getFirstName() + " "
                + client.getLastName() + " ("
                + client.getEmail() + ")");
        return client;
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

package main.java.com.magicvet.component;
import main.java.com.magicvet.Main;
import java.util.stream.IntStream;

public class Authenticator {
    private static final String PASSWORD = "d";

    public static boolean auth() {
        boolean accepted = IntStream.range(0, 3)
                .mapToObj(i -> {
                    System.out.print("Password: ");
                    String input = Main.SCANNER.nextLine();
                    if (!input.equals(PASSWORD)) {
                        System.out.println("Access denied. Please check your password.");
                    }
                    return input.equals(PASSWORD);
                })
                .filter(Boolean::booleanValue)
                .findFirst()
                .orElse(false);

        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");

        return accepted;
    }
}

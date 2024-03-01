package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void registerClients() {
        List<Client> clients = new ArrayList<>();
        String message = "Do you want to add register more clients? (y/n): ";
        do {
            Optional<Client> client = addClient();
            client.ifPresent(clients::add);
        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = clients.stream()
                .collect(Collectors.groupingBy(Client::getLocation));
        printClients(clientsByLocation);

    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content = "\nLocation: " + clients.getKey()
                    + "\nClients (" + clients.getValue().size() + "):"
                    + "\n\t" + clients.getValue();

            System.out.println(content);

        }
    }
    private Optional<Client> addClient() {
        Optional<Client> client = clientService.registerNewClient();
        client.ifPresent(this::registerPets);
        return client;
    }

    private void registerPets(Client client) {
        String message = "Do you want to add more pets to the current client? (y/n): ";
        boolean addedPet;
        do {
            addPet(client);
            addedPet = !client.getPets().isEmpty();
        } while (!addedPet || verifyRepeating(message));
    }

    private boolean petAdded = false; // Флаг, щоб визначити, чи був вже доданий питомець для нового клієнта

    private void addPet(Client client) {
        if (!petAdded) {
            System.out.println("Adding a new pet."); // Виводимо повідомлення лише якщо питомець ще не був доданий
            petAdded = true; // Встановлюємо флаг, що питомець був доданий
        }
        Optional<Pet> petOptional = petService.registerNewPet();
        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            pet.setHealthStateFromUserInput();
            System.out.println("Pet has been added.");
        }
    }

    private boolean verifyRepeating(String message) {
        System.out.println(message);

        String answer = Main.SCANNER.nextLine();
        if ("y".equals(answer)) {
            return true;
        } else if ("n".equals(answer)) {
            return false;
        } else {
            System.out.println("Incorrect answer. Pleas try again.");
            return verifyRepeating(message);
        }
    }

}
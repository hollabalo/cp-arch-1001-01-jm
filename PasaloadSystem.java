/**
 * @author johnmichael.gerona
 * @created 11/21/23
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasaloadSystem {
    public static void main(String[] args) {
        // initialize data
        User userJm = new User("JM", "09178482035", 1000.0);
        User userShrek = new User("Shrek", "09999999999", 20.0);
        List<User> users = new ArrayList<>();
        users.add(userJm);
        users.add(userShrek);
        PasaloadSystem p = new PasaloadSystem(users);

        // render texts

        boolean run = true;
        Scanner scan = null;
        while(run) {
            renderHomeScreen();
            scan = new Scanner(System.in);
            switch(scan.nextInt()) {
                case 1: displayUsers(p); break;
                case 2: transferLoad(p); break;
                case 3: run = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
        scan.close();
        System.out.println("Exiting the Pasaload System. Goodbye!");
    }

    private static void renderHomeScreen() {
        String[] homeScreenText = {
                "\n",
                "Welcome to Pasaload System",
                "\n",
                "Menu:",
                "1. View User Details",
                "2. Transfer Load",
                "3. Exit"
        };
        for (String text : homeScreenText) {
            System.out.println(text);
        }
    }

    private static void displayUsers(PasaloadSystem p) {
        List<User> users = p.getUsers();
        for(User u : users) {
            System.out.println("==============");
            System.out.println("Name: " + u.getName());
            System.out.println("Mobile Number: " + u.getMobileNumber());
            System.out.println("Load Balance: " + u.getLoadBalance());
        }
    }

    private static void transferLoad(PasaloadSystem p) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your mobile number:");
        String inputOwnNumber = scan.nextLine();

        System.out.println("Enter recipient's mobile number:");
        String inputRecipientNumber = scan.nextLine();

        System.out.println("Enter load amount to transfer:");
        String inputAmount = scan.nextLine();

        User ownUser = p.getUsers().stream().filter(u -> u.getMobileNumber().equals(inputOwnNumber))
                .findAny().orElse(null);

        if(ownUser == null) {
            System.out.println("Can't find your record!");
            return;
        }

        User recipient = p.getUsers().stream().filter(u -> u.getMobileNumber().equals(inputRecipientNumber))
                .findAny().orElse(null);

        if(recipient == null) {
            System.out.println("Can't find recipient!");
            return;
        }

        if(ownUser.getLoadBalance() < Double.parseDouble(inputAmount)) {
            System.out.println("Not enough balance on your account!");
            return;
        }

        ownUser.setLoadBalance(ownUser.getLoadBalance() - Double.parseDouble(inputAmount));
        recipient.setLoadBalance(recipient.getLoadBalance() + Double.parseDouble(inputAmount));
        p.users.set(p.users.indexOf(ownUser), ownUser);
        p.users.set(p.users.indexOf(recipient), recipient);

        System.out.println("Load transferred successfully!");
    }

    private List<User> users;

    public PasaloadSystem(List<User> users) {
        this.users = users;
    }

    private List<User> getUsers() {
        return users;
    }

    private void setUsers(List<User> users) {
        this.users = users;
    }
}


package enterprise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Phonebook phoneBook = new Phonebook();
        Scanner input = new Scanner(System.in);

        String phone;
        String name;

        System.out.println("\n--INSTRUCTIONS FOR USING THE PHONEBOOK--\n" +
                "Enter the contact's name or phone number\n" +
                "to add it to the phonebook, or use the commands below:\n" +
                "Command - \"ADD\" add contact\n" +
                "Command - \"EDIT\" edit contact\n" +
                "Command - \"DELETE\" delete contact\n" +
                "Command - \"LIST\" shows all contacts\n" +
                "Command - \"EXIT\" exit from the program\n");

        // start program execution
        while (true) {

            System.out.println("Enter PHONE, NAME or COMMAND:");

            String line = input.nextLine();

            // don't accept empty input
            if (line.isBlank()) {
                continue;
            }

            // add contact by command "add"
            if (line.equalsIgnoreCase("Add")) {

                System.out.println("Enter contact name:");

                name = input.nextLine();

                if (name.equalsIgnoreCase(phoneBook.nameValidator(name))) {

                    if (phoneBook.nameExists(name)) {
                        System.out.println("Such contact already exists...\n");
                        continue;
                    }

                    System.out.println("Enter phone number for the contact: " + name);

                    phone = input.nextLine();

                    if (phone.equalsIgnoreCase(phoneBook.phoneValidator(phone))) {

                        phoneBook.addContact(phone, name);

                        System.out.println("Contact saved!\n");

                    } else {
                        System.out.println("You entered an invalid number...\n");
                    }

                } else {
                    System.out.println("You entered an invalid name...\n");
                }
            }

            // edit contact by command "edit"
            if (line.equalsIgnoreCase("Edit")) {

                String newPhone;
                String newName;

                System.out.println("Enter contact name to edit:");

                name = input.nextLine();

                if (name.equalsIgnoreCase(phoneBook.nameValidator(name))) {

                    if (phoneBook.nameExists(name)) {

                        System.out.println("Enter a new contact name:");

                        newName = input.nextLine();

                        if (newName.equalsIgnoreCase(phoneBook.nameValidator(newName))) {

                            System.out.println("Enter a new contact phone number:");

                            newPhone = input.nextLine();

                            if (newPhone.equalsIgnoreCase(phoneBook.phoneValidator(newPhone))) {

                                phoneBook.deleteContact(name);
                                phoneBook.addContact(newPhone, newName);
                                System.out.println("The contact has been successfully edited!\n");

                            } else {
                                System.out.println("You entered an invalid number...\n");
                            }

                        } else {
                            System.out.println("You entered an invalid name...\n");
                        }

                    } else {
                        System.out.println("This contact doesn't exists...\n");
                    }
                }
            }

            // delete contact by command "delete"
            if (line.equalsIgnoreCase("Delete")) {

                System.out.println("Enter contact name to delete:");

                name = input.nextLine();

                if (name.equalsIgnoreCase(phoneBook.nameValidator(name))) {

                    if (phoneBook.nameExists(name)) {

                        phoneBook.deleteContact(name);

                        System.out.println("The contact has been successfully deleted!\n");

                    } else {
                        System.out.println("This contact doesn't exists...\n");
                    }
                }
            }

            // show all contacts by command "list"
            if (line.equalsIgnoreCase("List")) {

                if (phoneBook.isEmpty()) {
                    System.out.println("Phonebook is empty...\n");
                    continue;
                } else {
                    phoneBook.showContacts();
                }
            }

            // stop the program by command "exit"
            if (line.equalsIgnoreCase("Exit")) {
                break;
            }

            // add contact to the phonebook if the name is entered
            if (line.equalsIgnoreCase(phoneBook.nameValidator(line))) {

                name = line;

                if (phoneBook.nameExists(name)) {
                    System.out.println("Such contact already exists...\n");
                    continue;
                }

                System.out.println("Enter phone number for the contact: " + name);

                phone = input.nextLine();

                if (phone.equalsIgnoreCase(phoneBook.phoneValidator(phone))) {

                    phoneBook.addContact(phone, name);

                    System.out.println("Contact saved!\n");

                } else {
                    System.out.println("You entered an invalid number...\n");
                }
            }

            // add contact to phonebook if the phone number is entered
            if (line.equalsIgnoreCase(phoneBook.phoneValidator(line))) {

                phone = line;

                if (phoneBook.phoneExists(phone)) {
                    System.out.println("Such contact already exists...\n");
                    continue;
                }

                System.out.println("Enter name for the contact: " + phone);

                name = input.nextLine();

                if(name.equalsIgnoreCase(phoneBook.nameValidator(name))) {

                    phoneBook.addContact(phone, name);

                    System.out.println("Contact saved!\n");

                } else {
                    System.out.println("You entered an invalid name...\n");
                }
            }
        }
    }
}

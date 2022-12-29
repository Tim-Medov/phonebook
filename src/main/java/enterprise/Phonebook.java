
package enterprise;

import java.util.Map;
import java.util.TreeMap;

public class Phonebook {

    private Map<String, String> phonebookMap;

    public Phonebook() {
        this.phonebookMap = new TreeMap<>();
    }

    public boolean isEmpty() {
        return phonebookMap.isEmpty();
    }

    public boolean phoneExists(String phone) {
        return phonebookMap.containsKey(phone);
    }

    public boolean nameExists(String name) {
        return phonebookMap.containsValue(name);
    }

    public void showContacts() {

        for (Map.Entry<String, String> entry : phonebookMap.entrySet()) {

            String phone = entry.getKey();
            String name = entry.getValue();

            System.out.println(name + " - " + phone);
        }

        System.out.println();
    }

    public String phoneValidator(String phone) {

        String validPhone = "";

        String phoneRegexFull = "[+][0-9]{1,3}[0-9]{10}";
        String phoneRegexNormal = "[0-9]{1,3}[0-9]{10}";
        String phoneRegexSmall = "[0-9]{10}";

        if (phone.matches(phoneRegexFull) || phone.matches(phoneRegexNormal) ||
                phone.matches(phoneRegexSmall)) {
            validPhone = phone;
        }

        return validPhone;
    }

    public String nameValidator(String name) {

        String validName = "";
        String nameRegex = "[A-Za-z\\s]+";

        if (name.matches(nameRegex) &&
                !name.equalsIgnoreCase("Add") &&
                !name.equalsIgnoreCase("Edit") &&
                !name.equalsIgnoreCase("Delete") &&
                !name.equalsIgnoreCase("List") &&
                !name.equalsIgnoreCase("Exit")) {

            validName = name;
        }

        return validName;
    }

    public void addContact(String phone, String name) {
        phonebookMap.put(phone, name);
    }

    public void deleteContact(String name) {

        String existingPhone = "";

        for (Map.Entry<String, String> entry : phonebookMap.entrySet()) {

            String phoneKey = entry.getKey();
            String nameValue = entry.getValue();

            if (nameValue.equals(name)) {
                existingPhone = phoneKey;
            }
        }

        phonebookMap.remove(existingPhone);
    }
}

package hu.nive.ujratervezes.io.phonebook;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {

        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        }

        List<String> names = new ArrayList<>(contacts.keySet());
        List<String> formattedContacts = new ArrayList<>();

        if (names.size() != 0) {

            for (String name : names) {
                formattedContacts.add(formatData(name, contacts.get(name)));
            }

        }

        exportFormattedData(output, formattedContacts);

    }

    public String formatData(String name, String phoneNumber) {

        return name + ": " + phoneNumber;

    }

    public void exportFormattedData(String filename, List<String> contacts) {
        File csvOutputFile = new File(filename);
        try (FileWriter fw = new FileWriter(csvOutputFile)) {

            for (String st : contacts) {
                fw.write(st);
                fw.flush();
                fw.close();
            }

        } catch (Exception e) {
            System.out.println("An error occurred while exporting");
        }
    }
}
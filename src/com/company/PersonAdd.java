package com.company;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonAdd {

    public void addPerson() {
        String line = "";
        System.out.println("Please type new person");

        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Type first name: ");
            String FirstName = input.next();
            System.out.println("Type last name: ");
            String LastName = input.next();
            System.out.println("Input birth year: ");
            int BirthY = input.nextInt();
            System.out.println("Input PESEL: ");
            long Pesel= input.nextLong();

            String newPerson = FirstName +","+ LastName +","+ BirthY +","+ Pesel;

            BufferedReader reader = new BufferedReader(new FileReader("Exel.csv"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Exel.csv"), true));
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.write(newPerson);
            writer.newLine();
            writer.close();
            reader.close();
        } catch (InputMismatchException ime) {
            System.err.println("Invalid input");
        } catch (FileNotFoundException fnfe) {
            System.err.println("Error : File not found ");
        } catch (IOException ioe) {
            System.err.println("I/O error");
        } finally {
            System.out.println("nExel created");
        }
    }

}

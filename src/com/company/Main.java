package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


/* Damian Ostapczuk
    nr indeksu 11759
    */

public class Main {

    public static void main(String[] args) throws IOException {

        String FileName = "Exel.csv";
        String Textread = readFile(FileName);
        System.out.println("Text in file " + "\n" + Textread);

        PersonAdd add = new PersonAdd();
        add.addPerson();
        
        System.out.println("Tabela zostala posortowana po imieniu");
        new Main().sort(FileName, "csv1.txt");



    }


    void sort(String FileName, String checkFile) throws IOException{

        Path path = Paths.get(FileName);
        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);
        Path toPath = Paths.get(checkFile);
        Files.write(toPath, lines);



    }

    public static String readFile(String FileName) {
        File FileData = new File(FileName);
        String read = "";
        try {
            Scanner skaner = new Scanner(FileData);

            while (skaner.hasNextLine()) {

                read = read + skaner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return read;

    }


}

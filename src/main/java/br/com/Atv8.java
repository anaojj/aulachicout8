package br.com;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Atv8{
    public static void main( String[] args )
    {
        List<String> lines = null;
        Path inputPath = Paths.get("meuarquivo.txt");
        Path outputPath = Paths.get("meuarquivo_sem_excluir.txt");
        
        try {
            lines = Files.readAllLines(inputPath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the input file.");
            e.printStackTrace();
            return;
        }
        
        List<String> filteredLines = new ArrayList<>();
        for (String line : lines) {
            if (!line.contains("excluir")) {
                filteredLines.add(line);
            }
        }
        
        try {
            Files.write(outputPath, filteredLines);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the output file.");
            e.printStackTrace();
        }
    }
}

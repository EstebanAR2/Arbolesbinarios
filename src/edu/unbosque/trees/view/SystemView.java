package edu.unbosque.trees.view;

import edu.unbosque.trees.model.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class SystemView {

    private final PrintWriter writer;
    private final BufferedReader reader;

    public SystemView() {
        writer = new PrintWriter(System.out, true, StandardCharsets.UTF_8);
        reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    }

    public void print(String message) {
        writer.print(message);
        writer.flush();
    }

    public void println(String message) {
        writer.println(message);
        writer.flush();
    }

    public String readString() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            writer.println("Error al leer la entrada de texto: " + ex.getMessage());
            return null;
        }
    }

    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readString());
            } catch (NumberFormatException ex) {
                writer.println("Entrada no válida. Por favor, ingrese un número entero.");
            }
        }
    }

}

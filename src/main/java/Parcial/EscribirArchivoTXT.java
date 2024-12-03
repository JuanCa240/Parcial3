package Parcial;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscribirArchivoTXT {

    public static void main(String[] args) {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
       

        BufferedWriter writer = null;
        try {
            File archivo = new File("personas.txt");

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

        
            writer = new BufferedWriter(new FileWriter(archivo));

          
            for (int i = 0; i < listaPersonas.size(); i++) {
                Persona persona = listaPersonas.get(i); // Obtener cada persona por índice
                writer.write("Identificación: " + persona.getIdentificacion() + "\n");
                writer.write("Nombre: " + persona.getNombre() + "\n");
                writer.write("Correo: " + persona.getCorreo() + "\n");
                writer.write("-----------------------------\n");
            }

            System.out.println("Datos guardados en personas.txt");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}

package Parcial;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivoXML {
    public List<Persona> leerPersonasXML(String rutaArchivo) {
        List<Persona> listaPersonas = new ArrayList<>();

        try {
            File archivo = new File(rutaArchivo);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(archivo);

            documento.getDocumentElement().normalize();
            NodeList nodeList = documento.getElementsByTagName("Persona");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nodo = nodeList.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    String identificacion = elemento.getElementsByTagName("Identificacion").item(0).getTextContent();
                    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent();
                    String correo = elemento.getElementsByTagName("Correo").item(0).getTextContent();

                    listaPersonas.add(new Persona(identificacion, nombre, correo));
                }
            }

            System.out.println("Archivo XML leído correctamente.");
        } catch (Exception e) {
            e.getMessage();
        }

        return listaPersonas;
    }
}

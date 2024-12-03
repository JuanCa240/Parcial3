package Parcial;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class EscribirArchivoXML {
    public void guardarPersonasXML(ArrayList<Persona> listaPersonas, String rutaArchivo) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            Element root = documento.createElement("Personas");
            documento.appendChild(root);

            for (int i = 0; i < listaPersonas.size(); i++) {
                Persona persona = listaPersonas.get(i);

                Element elementoPersona = documento.createElement("Persona");

                Element identificacion = documento.createElement("Identificacion");
                identificacion.appendChild(documento.createTextNode(persona.getIdentificacion()));
                elementoPersona.appendChild(identificacion);

                Element nombre = documento.createElement("Nombre");
                nombre.appendChild(documento.createTextNode(persona.getNombre()));
                elementoPersona.appendChild(nombre);

                Element correo = documento.createElement("Correo");
                correo.appendChild(documento.createTextNode(persona.getCorreo()));
                elementoPersona.appendChild(correo);

                root.appendChild(elementoPersona);
            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource domSource = new DOMSource(documento);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(domSource, result);

            System.out.println("Archivo XML guardado correctamente.");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

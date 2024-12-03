package Parcial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlEventos {
    private VentanaPrincipal vp;
    private ArrayList<Persona> listaPersonas;
    private String rutaArchivo = "C:\\Users\\Juan Camilo\\OneDrive\\Documentos\\NetBeansProjects\\ParcialTresPOO\\personas.xml";

    public ControlEventos(VentanaPrincipal vp) {
        this.vp = vp;
        this.listaPersonas = new ArrayList<>();
        gestionarEventos();
    }

    public void gestionarEventos() {
        vp.getBotonAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    agregarPersona();
                } catch (CorreoMalEscritoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
              }            
        });
        
        vp.getBotonGuardarXML().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarXML();
            }
        });

        vp.getBotonLeerXML().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerXML();
            }
            });
        }
        
    public void agregarPersona() throws CorreoMalEscritoException{
            String identificacion = vp.getCampoIdentificacion().getText();
                String nombre = vp.getCampoNombre().getText();
                String correo = vp.getCampoCorreo().getText();

                if (identificacion.isEmpty() || nombre.isEmpty() || correo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                    return;
                }
                
                ingresarCorreo(correo);

                Persona nuevaPersona = new Persona(identificacion, nombre, correo);
                listaPersonas.add(nuevaPersona);

                vp.getModelo().addRow(new Object[]{identificacion, nombre, correo});
                vp.getCampoIdentificacion().setText("");
                vp.getCampoNombre().setText("");
                vp.getCampoCorreo().setText("");
    }
    
     public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }
     
      public void ingresarCorreo(String correo) throws CorreoMalEscritoException {
        if (!correo.contains("@")) {
            throw new CorreoMalEscritoException("El correo debe ser válido '@' ");
        }
    }
      
     public void guardarXML() {
        EscribirArchivoXML escritor = new EscribirArchivoXML();
        escritor.guardarPersonasXML(listaPersonas, rutaArchivo);
         System.out.println("Datos guardados en el archivo XML.");
    }

    public void leerXML() {
        LeerArchivoXML lector = new LeerArchivoXML();
        ArrayList<Persona> personas = (ArrayList<Persona>) lector.leerPersonasXML(rutaArchivo);

        listaPersonas.clear();
        vp.getModelo().setRowCount(0);

        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            listaPersonas.add(persona);
            vp.getModelo().addRow(new Object[]{persona.getIdentificacion(), persona.getNombre(), persona.getCorreo()});
        }

        System.out.println("Datos cargados desde el archivo XML.");
    }
}


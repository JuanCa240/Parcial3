package Parcial;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal {
    private JButton botonGuardarXML, botonLeerXML, botonGuardarTXT, botonLeerTXT, botonGuardarJSON, botonLeerJSON, botonAgregar;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JPanel panel;
    private JTextField campoIdentificacion, campoNombre, campoCorreo;

    public JFrame configurarVentana() {
        JFrame ventana = new JFrame("PARCIAL");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 600);

        panel = new JPanel();
        panel.setLayout(null);
        ventana.add(panel);

        // Tabla
        String[] encabezado = {"Identificación", "Nombre", "Correo"};
        modelo = new DefaultTableModel(null, encabezado);
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(10, 280, 370, 200);
        panel.add(scrollPane);

        // Botones
        botonGuardarXML = new JButton("Guardar XML");
        botonGuardarXML.setBounds(10, 10, 120, 30);
        panel.add(botonGuardarXML);

        botonLeerXML = new JButton("Leer XML");
        botonLeerXML.setBounds(140, 10, 120, 30);
        panel.add(botonLeerXML);

        botonGuardarTXT = new JButton("Guardar TXT");
        botonGuardarTXT.setBounds(10, 50, 120, 30);
        panel.add(botonGuardarTXT);

        botonLeerTXT = new JButton("Leer TXT");
        botonLeerTXT.setBounds(140, 50, 120, 30);
        panel.add(botonLeerTXT);

        botonGuardarJSON = new JButton("Guardar JSON");
        botonGuardarJSON.setBounds(10, 90, 120, 30);
        panel.add(botonGuardarJSON);

        botonLeerJSON = new JButton("Leer JSON");
        botonLeerJSON.setBounds(140, 90, 120, 30);
        panel.add(botonLeerJSON);

        JLabel labelIdentificacion = new JLabel("Identificación:");
        labelIdentificacion.setBounds(10, 150, 120, 30);
        panel.add(labelIdentificacion);

        campoIdentificacion = new JTextField();
        campoIdentificacion.setBounds(140, 150, 200, 30);
        panel.add(campoIdentificacion);

        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(10, 190, 120, 30);
        panel.add(labelNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(140, 190, 200, 30);
        panel.add(campoNombre);

        JLabel labelCorreo = new JLabel("Correo:");
        labelCorreo.setBounds(10, 230, 120, 30);
        panel.add(labelCorreo);

        campoCorreo = new JTextField();
        campoCorreo.setBounds(140, 230, 200, 30);
        panel.add(campoCorreo);

     
        botonAgregar = new JButton("Agregar Persona");
        botonAgregar.setBounds(140, 500, 200, 30);
        panel.add(botonAgregar);

        ventana.setVisible(true);
        return ventana;
    }

    public JButton getBotonGuardarXML() {
        return botonGuardarXML;
    }

    public JButton getBotonLeerXML() {
        return botonLeerXML;
    }

    public JButton getBotonGuardarTXT() {
        return botonGuardarTXT;
    }

    public JButton getBotonLeerTXT() {
        return botonLeerTXT;
    }

    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public JTextField getCampoIdentificacion() {
        return campoIdentificacion;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JTextField getCampoCorreo() {
        return campoCorreo;
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }
}

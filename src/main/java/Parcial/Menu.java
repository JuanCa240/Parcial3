package Parcial;

import javax.swing.JFrame;

public class Menu {
    public static void main(String[] args) {
        VentanaPrincipal vp = new VentanaPrincipal();
        JFrame ventana = vp.configurarVentana();
        
        ControlEventos e = new ControlEventos(vp);
        
        
    }
            
}

package tap_proyecto1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaInformacion extends JFrame{
    public TablaInformacion(){
        setTitle("Listado de Pacientes");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DefaultTableModel Listado = new DefaultTableModel();
        
        Listado.addColumn("IdPacientes");
        Listado.addColumn("Nombre");
        Listado.addColumn("Apellidos");
        Listado.addColumn("Telefono");
        Listado.addColumn("Correo");
        Listado.addColumn("Fecha de Alta");
        JTable tabla = new JTable(Listado);
        JScrollPane Scroll = new JScrollPane(tabla);

        JPanel PanelBoton = new JPanel();

        setLayout(new BorderLayout());
        
        add(Scroll, BorderLayout.CENTER);
        add(PanelBoton, BorderLayout.NORTH);
        setVisible(true);
    }
}
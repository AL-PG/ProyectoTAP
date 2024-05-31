package tap_proyecto1;
import java.sql.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaInformacion extends JFrame{
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/consultorio";
    private static final String USER = "postgres";
    private static final String PASS = "D277353527316d";
    private DefaultTableModel table;

    public TablaInformacion() throws SQLException{
        setTitle("Listado de Pacientes");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DefaultTableModel Listado = new DefaultTableModel();
        
        Listado.addColumn("IdPacientes");
        Listado.addColumn("Nombre");
        Listado.addColumn("Apellidos");
        Listado.addColumn("Telefono");
        Listado.addColumn("Correo");
        Listado.addColumn("Fecha de nacimiento");
        JTable tabla = new JTable(Listado);
        JScrollPane Scroll = new JScrollPane(tabla);

        JPanel PanelBoton = new JPanel();

        setLayout(new BorderLayout());
        
        add(Scroll, BorderLayout.CENTER);
        add(PanelBoton, BorderLayout.NORTH);
        setVisible(true);
        table = Listado;
        consultarPacientes();


    }
    public void consultarPacientes() throws SQLException {
        String sql = "SELECT * FROM public.paciente";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                this.table.addRow(new Object[]{rs.getInt("idPaciente"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("teléfono"), 
                rs.getString("correo"), rs.getDate("fechaNac")} );

            }
        }
    }
    

}

package tap_proyecto1;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.WindowAdapter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class verCitasAdmin extends JFrame implements ActionListener {
    private JCalendar calendario;
    private JScrollPane citasScroll;
    private JPanel panelCalendario;
    private JPanel panelBotones;
    private JPanel panelCitas;
    private JButton nuevaCita;
    private JButton agregarPaciente;
    private JButton listarPaciente;
    private JLabel seleccionMedico;
    private JTable tablaCitas;
    private final JComboBox<Integer> medicosIds;
    private static final Integer idsMedicos[] = {
        1,
        2,
        3,
    };
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/consultorio";
    private static final String USER = "postgres";
    private static final String PASS = "D277353527316d*";
    private DefaultTableModel model;

    public verCitasAdmin() {
        super("Agenda de Citas");
        setSize(800, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        LineBorder border = new LineBorder(new Color(12, 111, 253), 2);

        calendario = new JCalendar();
        panelCalendario = new JPanel();
        calendario.setBackground(Color.WHITE);
        panelCalendario.add(calendario, BorderLayout.CENTER);
        calendario.getYearChooser().setBorder(border);
        calendario.getMonthChooser().setBorder(border);
        calendario.setDecorationBackgroundColor(new Color(12, 111, 253));
        calendario.setWeekdayForeground(Color.WHITE);
        calendario.setFont(new Font("Arial", Font.PLAIN, 15));;
        calendario.setBorder(border);

        JDayChooser dayChooser = calendario.getDayChooser();
        dayChooser.addPropertyChangeListener("day", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                cargarCitasPorFecha(calendario.getDate());
            }
        });

        dayChooser.setBackground(Color.BLUE);

        add(panelCalendario, BorderLayout.CENTER);

        String[] columnasNombre = {"Hora", "Paciente", "Descripción", "Médico"};
        model = new DefaultTableModel(null, columnasNombre);
        tablaCitas = new JTable();
        this.tablaCitas.setModel(model);

        tablaCitas.setEnabled(false);
        tablaCitas.setFont(new Font("Arial", Font.PLAIN, 15));
        try {
            consultarCitas();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }

        tablaCitas.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(new Color(12, 111, 253)); 
                c.setForeground(Color.WHITE); 
                if (c instanceof JLabel) {
                    JLabel label = (JLabel) c;
                    label.setHorizontalAlignment(SwingConstants.CENTER); 
                }
                return c;
            }
        });

        citasScroll = new JScrollPane(tablaCitas);
        Dimension preferredSize = new Dimension(750, 200);
        citasScroll.setPreferredSize(preferredSize);;
        panelCitas = new JPanel();
        panelCitas.add(citasScroll, BorderLayout.CENTER);

        JPanel panelMedico = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        panelBotones = new JPanel(new BorderLayout());
        
        nuevaCita = new JButton("Nueva cita");
        nuevaCita.setForeground(new Color(255, 255, 255));
        nuevaCita.setBackground(new Color(12, 111, 253));

        agregarPaciente = new JButton("Agregar Paciente");
        agregarPaciente.setForeground(new Color(255, 255, 255));
        agregarPaciente.setBackground(new Color(12, 111, 253));

        listarPaciente = new JButton("Listar Pacientes");
        listarPaciente.setForeground(new Color(255, 255, 255));
        listarPaciente.setBackground(new Color(12, 111, 253));
        
        panelBotones.add(nuevaCita, BorderLayout.WEST);
        panelBotones.add(agregarPaciente, BorderLayout.CENTER);
        panelBotones.add(listarPaciente, BorderLayout.SOUTH);

        seleccionMedico = new JLabel("Seleccion de médico: ");
        panelMedico.add(seleccionMedico, BorderLayout.EAST);
        listarPaciente.addActionListener(this);
        nuevaCita.addActionListener(this);
        agregarPaciente.addActionListener(this);

        medicosIds = new JComboBox<Integer>(idsMedicos);
        medicosIds.setMaximumRowCount(3);
        medicosIds.setBorder(border);
        panelMedico.add(medicosIds, BorderLayout.CENTER);

        panelMedico.setBackground(Color.WHITE);

        panelBotones.add(panelMedico, BorderLayout.EAST);
        panelBotones.setBackground(Color.WHITE);
        panelCalendario.setBackground(Color.WHITE);

        
        add(calendario, BorderLayout.CENTER);
        add(panelCitas, BorderLayout.SOUTH);
        add(panelBotones, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == nuevaCita) {
            nuevaCita.setEnabled(false);
    
            AgregarCitas agregaCitas = new AgregarCitas(this,true);
            agregaCitas.setVisible(true);
            agregaCitas.setSize(600, 650);
    
            agregaCitas.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    nuevaCita.setEnabled(true);
                }
            });
        }

        if (e.getSource() == agregarPaciente){
            agregarPaciente.setEnabled(false);
    
            pacienteFormulario1 agregaPaciente = new pacienteFormulario1(this,true);
            agregaPaciente.setVisible(true);
            agregaPaciente.setSize(800, 800);
    
            agregaPaciente.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    agregarPaciente.setEnabled(true);
                }
            });

        }

        if (e.getSource() == listarPaciente){
            listarPaciente.setEnabled(false);
            TablaInformacion listaP;
            try {
                listaP = new TablaInformacion();
                listaP.setVisible(true);
                listaP.setSize(800, 800);
        
                listaP.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        agregarPaciente.setEnabled(true);
                    }
                });
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            verCitasAdmin frame = new verCitasAdmin();
            frame.setSize(800, 850);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public void consultarCitas() throws SQLException {
        String sql = "SELECT hora, \"idPaciente\", descripción, \"idUsuario\" FROM citas";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("hora"), rs.getInt("idPaciente"), rs.getString("descripción"), rs.getInt("idUsuario")});
            }
        }
    }

    private void cargarCitasPorFecha(Date fecha) {
        model.setRowCount(0); // Limpiar la tabla antes de cargar nuevas citas
    
        // Consultar las citas para la fecha seleccionada
        String sql = "SELECT hora, \"idPaciente\", descripción, \"idUsuario\" FROM citas WHERE fecha = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(fecha.getTime())); // Convertir la fecha a java.sql.Date
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{rs.getString("hora"), rs.getInt("idPaciente"), rs.getString("descripción"), rs.getInt("idUsuario")});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
    }
    
    
}
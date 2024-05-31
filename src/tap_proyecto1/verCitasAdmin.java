
package tap_proyecto1;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
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
    private final JComboBox<String> medicosNombre;
    private static final String nombres[] = {
        "Médico 1",
        "Médico 2",
        "Médico 3",
        "Médico 4"
    };

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

        dayChooser.setBackground(Color.BLUE);

        add(panelCalendario, BorderLayout.CENTER);

        String[] columnasNombre = {"Hora", "Paciente", "Descripción", "Médico"};
        DefaultTableModel model = new DefaultTableModel(null, columnasNombre);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        while (calendar.get(Calendar.HOUR_OF_DAY) < 22) {
            String hora = dateFormat.format(calendar.getTime());
            model.addRow(new Object[]{hora, "", "", ""}); 
            calendar.add(Calendar.MINUTE, 20);
        }

        tablaCitas = new JTable(model);
        tablaCitas.setEnabled(false);
        tablaCitas.setFont(new Font("Arial", Font.PLAIN, 15));

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

        medicosNombre = new JComboBox<String>(nombres);
        medicosNombre.setMaximumRowCount(4);
        medicosNombre.setBorder(border);
        panelMedico.add(medicosNombre, BorderLayout.CENTER);

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
    
}

package tap_proyecto1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AgregarCitas extends JFrame implements ActionListener {
    private final JLabel MedicoLabel;
    private final JLabel DescripcionLabel;
    private final JLabel PacienteLabel;
    private final JLabel ApellidosPLabel;
    private final JLabel FechaLabel;
    private final JLabel HoraLabel;
    private final JLabel NotasLabel;
    private final JLabel MinutosLabel;
    private final JButton GuardarButton;
    private final JButton CancelarButton;
    private final JPanel panelPrincipal;
    private final JPanel panel1;
    private final JPanel panel2;
    private final JPanel panel3;
    private final JTextField DescripcionText;
    private final JTextArea NotasText;
    private final JTextField PacienteText;
    private final JTextField ApellidosPText;
    private final JComboBox<String> MedicosNombre;
    private final JDateChooser Fecha;
    private final JSpinner hourSpinner;
    private final JSpinner minuteSpinner;
    private final JComboBox<String> diasCombo;
    private static final String dias[] = {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
    };
    private final JComboBox<String> mesCombo;
    private static final String mes[] = {
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" 
    };
    private final JTextField anio;
    private static final String URL = "jdbc:postgresql://localhost:5432/consultorio";
    private static final String USUARIO = "postgres";
    private static final String CONTRASEÑA = "D277353527316d*";

    private static final String nombres[] = {
        "Fernando Alarcón Rojas",
        "Gloria Arias Nieto",
        "Rafael Alberto Ariza Vesga"
    };
    
    public AgregarCitas(verCitasAdmin parent, boolean modal) {
        super("Crear cita");
        setSize(550, 650);

        LineBorder border = new LineBorder(new Color(108, 120, 189), 2);
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));

        panel1 = new JPanel();
        panel1.setLayout(null);


        DescripcionLabel = new JLabel("Descripción");
        DescripcionLabel.setBounds(20, 130, 100, 20);
        DescripcionLabel.setForeground(new Color(97, 113, 195));
        DescripcionText = new JTextField();
        DescripcionText.setBounds(20, 150, 350, 50);
        DescripcionText.setBorder(border);

        panel1.add(DescripcionLabel);
        panel1.add(DescripcionText);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(370, 219));

        MedicoLabel = new JLabel("Médico");
        MedicoLabel.setBounds(20, 44, 50, 20);
        MedicoLabel.setForeground(new Color(97, 113, 195));
        MedicosNombre = new JComboBox<>(nombres);
        MedicosNombre.setMaximumRowCount(3);
        MedicosNombre.setBounds(20, 79, 150, 20);
        MedicosNombre.setBorder(border);

        PacienteLabel = new JLabel("Nombre ");
        PacienteLabel.setBounds(220, 44, 200, 20);
        PacienteLabel.setForeground(new Color(97, 113, 195));
        ApellidosPLabel = new JLabel("Apellidos paciente");
        ApellidosPLabel.setBounds(320, 44, 120, 20);
        ApellidosPLabel.setForeground(new Color(97, 113, 195));

        PacienteText = new JTextField();
        PacienteText.setBounds(220, 70, 75, 30);
        PacienteText.setBorder(border);
        ApellidosPText = new JTextField();
        ApellidosPText.setBounds(320, 70, 150, 30);
        ApellidosPText.setBorder(border);

        FechaLabel = new JLabel("Fecha");
        FechaLabel.setBounds(20, 110, 50, 20);
        FechaLabel.setForeground(new Color(97, 113, 195));
        Fecha = new JDateChooser();
        Fecha.setBounds(20, 140, 100, 20);
        Fecha.setBorder(border);

        diasCombo = new JComboBox<>(dias);
        diasCombo.setBounds(20, 140, 50, 20);
        diasCombo.setBorder(border);
        mesCombo = new JComboBox<>(mes);
        mesCombo.setBounds(80, 140, 50, 20);
        mesCombo.setBorder(border);
        anio = new JTextField();
        anio.setBounds(150, 140, 40, 20);
        anio.setBorder(border);

        HoraLabel = new JLabel("Hora");
        HoraLabel.setBounds(220, 110, 50, 20);
        HoraLabel.setForeground(new Color(97, 113, 195));

        MinutosLabel = new JLabel("Minutos");
        MinutosLabel.setBounds(280, 110, 50, 20);
        MinutosLabel.setForeground(new Color(97, 113, 195));


        SpinnerNumberModel hourModel = new SpinnerNumberModel(7, 7, 22, 1);
        hourSpinner = new JSpinner(hourModel);
        hourSpinner.setBounds(220, 140, 50, 20);
        hourSpinner.setBorder(border);

        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 40, 20);
        minuteSpinner = new JSpinner(minuteModel);
        minuteSpinner.setBounds(280, 140, 50, 20);
        minuteSpinner.setBorder(border);

        panel2.add(MedicoLabel);
        panel2.add(MedicosNombre);
        panel2.add(PacienteLabel);
        panel2.add(PacienteText);
        panel2.add(ApellidosPLabel);
        panel2.add(ApellidosPText);
        panel2.add(FechaLabel);
        panel2.add(diasCombo);
        panel2.add(mesCombo);
        panel2.add(anio);
        panel2.add(HoraLabel);
        panel2.add(MinutosLabel);
        panel2.add(hourSpinner);
        panel2.add(minuteSpinner);

        panel3 = new JPanel();
        panel3.setLayout(null);

        NotasLabel = new JLabel("Notas extra");
        NotasLabel.setBounds(20, 5, 80, 20);
        NotasLabel.setForeground(new Color(97, 113, 195));
        NotasText = new JTextArea();
        NotasText.setBounds(20, 30, 300, 100);
        NotasText.setBorder(border);
        GuardarButton = new JButton("Guardar");
        GuardarButton.setBounds(370, 20, 100, 40);
        GuardarButton.setForeground(new Color(255, 255, 255));
        GuardarButton.setBackground(new Color(62, 81, 180));
        CancelarButton = new JButton("Cancelar");
        CancelarButton.setBounds(370, 70, 100, 40);
        CancelarButton.setForeground(new Color(255, 255, 255));
        CancelarButton.setBackground(new Color(233, 30, 99));

        panel3.add(NotasLabel);
        panel3.add(NotasText);
        panel3.add(GuardarButton);
        panel3.add(CancelarButton);

        CancelarButton.addActionListener(this);
        GuardarButton.addActionListener(this);

        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        panel3.setBackground(Color.WHITE);

        panelPrincipal.add(panel1, BorderLayout.NORTH);
        panelPrincipal.add(panel2, BorderLayout.CENTER);
        panelPrincipal.add(panel3, BorderLayout.SOUTH);
        panelPrincipal.setBackground(Color.WHITE);
        add(panelPrincipal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CancelarButton) {
            dispose();
        }

        if (e.getSource() == GuardarButton) {
            String descripcion = DescripcionText.getText();
            String nombrePaciente = PacienteText.getText();
            String apellidosPaciente = ApellidosPText.getText();
            String nombreMedico = (String) MedicosNombre.getSelectedItem();
            Date fecha = (Date) Fecha.getDate();

            String diaStr = (String) diasCombo.getSelectedItem();
                int diaInt = Integer.parseInt(diaStr);
                String mesStr = (String) mesCombo.getSelectedItem();
                int mesInt = Integer.parseInt(mesStr);
                int anioInt = Integer.parseInt(anio.getText());

                LocalDate date = LocalDate.of(anioInt, mesInt, diaInt);
                Date fechaNacB = Date.valueOf(date);

            int hora = (Integer) hourSpinner.getValue();
            int minutos = (Integer) minuteSpinner.getValue();
            String notas = NotasText.getText();

            String horaFormateada = String.format("%02d:%02d", hora, minutos);

            Time horaSQL = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                java.util.Date utilDate = sdf.parse(horaFormateada);
                horaSQL = new Time(utilDate.getTime());
            } catch (ParseException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error en el formato de la hora.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int medicoId = getMedicoIdByName(nombreMedico);
            System.out.println("soy medico " + medicoId);
            int pacienteId = getPacienteIdByName(nombrePaciente, apellidosPaciente);
            System.out.println("Soy paciente " +pacienteId);

            if (medicoId != -1 && pacienteId != -1) {
                guardarCita(medicoId, pacienteId, descripcion, fechaNacB, horaSQL, notas);
                JOptionPane.showMessageDialog(this, "Cita guardada con éxito!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error: No se encontró el médico o paciente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == CancelarButton) {
            dispose();
        }
    }

    public int getMedicoIdByName(String nombreMedico) {
        String query = "SELECT \"idUsuario\" FROM usuario WHERE nombre = ? AND tipo = 'Medico'";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombreMedico);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idUsuario");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; 
    }
    
private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }


    public int getPacienteIdByName(String nombre, String apellidos) {
        String query = "SELECT \"idPaciente\" FROM paciente WHERE nombre = ? AND apellidos = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("idPaciente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;}
    
    public void guardarCita(int medicoId, int pacienteId, String descripcion, Date fechaNacB, Time hora, String notas) {
        String query = "INSERT INTO citas (fecha, hora, descripción, extra, \"idPaciente\", \"idUsuario\") VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, fechaNacB);
            statement.setTime(2, hora);
            statement.setString(3, descripcion);
            statement.setString(4, notas);
            statement.setInt(5, pacienteId);
            statement.setInt(6, medicoId);
            int row = statement.executeUpdate();

            if (row > 0) {
                JOptionPane.showMessageDialog(null, "La cita ha sido registrado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


    

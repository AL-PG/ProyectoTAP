package tap_proyecto1;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")

public class ExpedienteMed extends JFrame{
    private JTextField nombreCompletoField, fechaNacimientoField, ocupacionField;
    private JComboBox<String> generoComboBox;
    private JTextArea alergiasTextArea, operacionesTextArea, otrosPadecimientosTextArea;
    private JCheckBox ningunaAlergiaCheckBox, ningunaOperacionCheckBox,ningunaMedicamentpCheckBox;
    private JCheckBox altaPresionCheckBox, diabetesCheckBox, cancerCheckBox, anemiaCheckBox, fCardiacaCheckBox, neumoniaCheckBox, indigestionCheckBox, diarreaCheckBox, bronquitisCheckBox, ulceraCheckBox, hepatitisCheckBox, artritisCheckBox, depresionCheckBox, alcoholismoCheckBox, drogadiccionCheckBox, hemorroidesCheckBox, otroPadecimientoCheckBox;
    private JTextField sustanciasField, dosisField;
    private JTextField madreField, padreField, hermanosField, abuelaField, abueloField;

    private static final String URL = "jdbc:postgresql://localhost:5432/consultorio";
    private static final String USUARIO = "postgres";
    private static final String CONTRASEÑA = "D277353527316d*";

    public ExpedienteMed() {
        setTitle("Expediente Médico");
        setSize(850, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal y establecer un layout nulo
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(800, 1600)); // Ajustar según el contenido

        ningunaAlergiaCheckBox = new JCheckBox("Ninguno");
        ningunaOperacionCheckBox = new JCheckBox("Ninguno");
        ningunaMedicamentpCheckBox = new JCheckBox("Ninguno");
        altaPresionCheckBox = new JCheckBox("Alta Presión");
        diabetesCheckBox = new JCheckBox("Diabetes");
        cancerCheckBox = new JCheckBox("Cáncer");
        anemiaCheckBox = new JCheckBox("Anemia");
        fCardiacaCheckBox = new JCheckBox("Fallo Cardíaco");
        neumoniaCheckBox = new JCheckBox("Neumonía");
        indigestionCheckBox = new JCheckBox("Indigestión");
        diarreaCheckBox = new JCheckBox("Diarrea");
        bronquitisCheckBox = new JCheckBox("Bronquitis");
        ulceraCheckBox = new JCheckBox("Úlcera");
        hepatitisCheckBox = new JCheckBox("Hepatitis");
        artritisCheckBox = new JCheckBox("Artritis");
        depresionCheckBox = new JCheckBox("Depresión");
        alcoholismoCheckBox = new JCheckBox("Alcoholismo");
        drogadiccionCheckBox = new JCheckBox("Drogadicción");
        hemorroidesCheckBox = new JCheckBox("Hemorroides");
        otroPadecimientoCheckBox = new JCheckBox("Otro Padecimiento");

        JCheckBox[] checkBoxArray = new JCheckBox[]{
            altaPresionCheckBox, diabetesCheckBox, cancerCheckBox, anemiaCheckBox, fCardiacaCheckBox,
            neumoniaCheckBox, indigestionCheckBox, diarreaCheckBox, bronquitisCheckBox, ulceraCheckBox,
            hepatitisCheckBox, artritisCheckBox, depresionCheckBox, alcoholismoCheckBox,
            drogadiccionCheckBox, hemorroidesCheckBox, otroPadecimientoCheckBox
        };


        int y = 10;  // Coordenada y inicial
        // Sección de Información Personal
        addLabel(mainPanel, "INFORMACIÓN PERSONAL", 10, y, 780, 30, true);
        y += 40;
        addLabel(mainPanel, "Nombre Completo:", 10, y, 200, 30);
        nombreCompletoField = addTextField(mainPanel, 220, y, 560, 30);
        y += 40;
        addLabel(mainPanel, "Fecha de Nacimiento:", 10, y, 200, 30);
        fechaNacimientoField = addTextField(mainPanel, 220, y, 560, 30);
        y += 40;
        addLabel(mainPanel, "Género:", 10, y, 200, 30);
        generoComboBox = addComboBox(mainPanel, new String[]{"Hombre", "Mujer"}, 220, y, 560, 30);
        y += 40;
        addLabel(mainPanel, "Ocupación:", 10, y, 200, 30);
        ocupacionField = addTextField(mainPanel, 220, y, 560, 30);
        y += 50;

        // Sección de Alergias a Medicamentos u Otras Sustancias
        addLabel(mainPanel, "ALERGIAS A MEDICAMENTOS U OTRAS SUSTANCIAS", 10, y, 780, 30, true);
        y += 40;
        ningunaAlergiaCheckBox = addCheckBox(mainPanel, ningunaAlergiaCheckBox, 10, y, 780, 30);
        y += 40;
        alergiasTextArea = addTextArea(mainPanel, 10, y, 770, 60);
        y += 70;

        // Sección de Medicamentos, Vitaminas, Suplementos
        addLabel(mainPanel, "ACTUALES MEDICAMENTOS, VITAMINAS, SUPLEMENTOS", 10, y, 780, 30, true);
        y += 40;
        ningunaMedicamentpCheckBox = addCheckBox(mainPanel, ningunaMedicamentpCheckBox, 10, y, 780, 30);
        y += 40;
        addLabel(mainPanel, "Sustancias:", 10, y, 200, 30);
        sustanciasField = addTextField(mainPanel, 220, y, 560, 30);
        y += 40;
        addLabel(mainPanel, "Dosis:", 10, y, 200, 30);
        dosisField = addTextField(mainPanel, 220, y, 560, 30);
        y += 50;

        // Sección de Operaciones y Hospitalizaciones
        addLabel(mainPanel, "OPERACIONES Y HOSPITALIZACIONES", 10, y, 780, 30, true);
        y += 40;
        ningunaOperacionCheckBox = addCheckBox(mainPanel, ningunaOperacionCheckBox, 10, y, 780, 30);
        y += 40;
        operacionesTextArea = addTextArea(mainPanel, 10, y, 770, 60);
        y += 70;

        // Sección de Historia Médica de Padecimientos
        addLabel(mainPanel, "HISTORIA MÉDICA DE PADECIMIENTOS", 10, y, 780, 30, true);
        y += 40;
        altaPresionCheckBox = addCheckBox(mainPanel, altaPresionCheckBox, 10, y, 190, 30);
        diabetesCheckBox = addCheckBox(mainPanel, diabetesCheckBox, 200, y, 190, 30);
        cancerCheckBox = addCheckBox(mainPanel, cancerCheckBox, 390, y, 190, 30);
        anemiaCheckBox = addCheckBox(mainPanel, anemiaCheckBox, 580, y, 190, 30);
        y += 40;
        fCardiacaCheckBox = addCheckBox(mainPanel, fCardiacaCheckBox, 10, y, 190, 30);
        neumoniaCheckBox = addCheckBox(mainPanel, neumoniaCheckBox, 200, y, 190, 30);
        indigestionCheckBox = addCheckBox(mainPanel, indigestionCheckBox, 390, y, 190, 30);
        diarreaCheckBox = addCheckBox(mainPanel, diarreaCheckBox, 580, y, 190, 30);
        y += 40;
        bronquitisCheckBox = addCheckBox(mainPanel, bronquitisCheckBox, 10, y, 190, 30);
        ulceraCheckBox = addCheckBox(mainPanel, ulceraCheckBox, 200, y, 190, 30);
        hepatitisCheckBox = addCheckBox(mainPanel, hepatitisCheckBox, 390, y, 190, 30);
        artritisCheckBox = addCheckBox(mainPanel, artritisCheckBox, 580, y, 190, 30);
        y += 40;
        depresionCheckBox = addCheckBox(mainPanel, depresionCheckBox, 10, y, 190, 30);
        alcoholismoCheckBox = addCheckBox(mainPanel, alcoholismoCheckBox, 200, y, 190, 30);
        drogadiccionCheckBox = addCheckBox(mainPanel, drogadiccionCheckBox, 390, y, 190, 30);
        hemorroidesCheckBox = addCheckBox(mainPanel, hemorroidesCheckBox, 580, y, 190, 30);
        y += 40;
        otroPadecimientoCheckBox = addCheckBox(mainPanel, otroPadecimientoCheckBox, 10, y, 780, 30);
        y += 40;
        otrosPadecimientosTextArea = addTextArea(mainPanel, 10, y, 770, 60);
        y += 70;

        // Sección de Historial Familiar
        addLabel(mainPanel, "HISTORIAL FAMILIAR", 10, y, 780, 30, true);
        y += 40;
        addLabel(mainPanel, "Madre:", 10, y, 200, 30);
        madreField = addTextField(mainPanel, 220, y, 560, 30);
        y += 40;
        addLabel(mainPanel, "Padre:", 10, y, 200, 30);
        padreField = addTextField(mainPanel, 220, y, 560, 30);
        y += 40;
        addLabel(mainPanel, "Hermanos:", 10, y, 200, 30);
        hermanosField = addTextField(mainPanel, 220, y, 560, 30);
        y += 40;
        addLabel(mainPanel, "Abuela:", 10, y, 200, 30);
        abuelaField = addTextField(mainPanel, 220, y, 560, 30);
        y += 40;
        addLabel(mainPanel, "Abuelo:", 10, y, 200, 30);
        abueloField = addTextField(mainPanel, 220, y, 560, 30);
        y += 50;

        // Botón de Guardar y Salir
        JButton guardarSalirButton = new JButton("Guardar y Salir");
        guardarSalirButton.setBackground(Color.BLUE);
        guardarSalirButton.setForeground(Color.WHITE);
        guardarSalirButton.setBounds(300, y, 200, 40);
        guardarSalirButton.addActionListener(e -> {
            try {
                guardarExpediente(checkBoxArray);
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        mainPanel.add(guardarSalirButton);

        // Añadir el panel principal a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        setContentPane(scrollPane);

        setVisible(true);
    }

    private void addLabel(JPanel panel, String text, int x, int y, int width, int height) {
        addLabel(panel, text, x, y, width, height, false);
    }

    private void addLabel(JPanel panel, String text, int x, int y, int width, int height, boolean isTitle) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        if (isTitle) {
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setForeground(Color.BLUE);
            label.setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            label.setFont(new Font("Arial", Font.PLAIN, 14));
        }
        panel.add(label);
    }

    private JTextField addTextField(JPanel panel, int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        panel.add(textField);
        return textField;
    }

    private JComboBox<String> addComboBox(JPanel panel, String[] items, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(x, y, width, height);
        panel.add(comboBox);
        return comboBox;
    }

    private JCheckBox addCheckBox(JPanel panel, JCheckBox text, int x, int y, int width, int height) {
        text.setBounds(x, y, width, height);
        panel.add(text);
        return text;
    }

    private JTextArea addTextArea(JPanel panel, int x, int y, int width, int height) {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(x, y, width, height);
        panel.add(scrollPane);
        return textArea;
    }

    // Método para guardar el expediente
    private void guardarExpediente(JCheckBox[] checkBoxArray) throws ParseException {
        String Alergias = "";
        String Medicamentos = "";
        String Operacion = "";
        String Enfermedades = "";
        String Dosis = "";
        
        String NombreCompleto = nombreCompletoField.getText();

        String FechaNacimiento = fechaNacimientoField.getText(); 
        LocalDate dateFormat = LocalDate.parse(FechaNacimiento);
        Date date = Date.valueOf(FechaNacimiento);

        String Genero = (String) generoComboBox.getSelectedItem();
        String Ocupación = ocupacionField.getText();
        
        if (ningunaAlergiaCheckBox.isSelected()) {
            Alergias = ningunaAlergiaCheckBox.getText();
        } else {
            Alergias = alergiasTextArea.getText();
        }

        if (ningunaMedicamentpCheckBox.isSelected()) {
             Medicamentos = ningunaAlergiaCheckBox.getText();
             Dosis = ningunaAlergiaCheckBox.getText();
            
        } else {
             Medicamentos = sustanciasField.getText();
             Dosis = dosisField.getText();
        }

        if (ningunaOperacionCheckBox.isSelected()) {
             Operacion = ningunaOperacionCheckBox.getText();
        } else {
             Operacion = operacionesTextArea.getText();
        }
        
        for (JCheckBox jCheckBox : checkBoxArray) {
            if (jCheckBox.isSelected()) {
                 Enfermedades += jCheckBox.getText() + ", ";
            }
             Enfermedades += otrosPadecimientosTextArea.getText();
        }

        String HMadre = madreField.getText();
        String HPadre = padreField.getText();
        String HHermanos = hermanosField.getText();
        String HAbuela = abuelaField.getText();
        String HAbuelo = abueloField.getText();

        guardarCita(NombreCompleto, date, Genero, Ocupación, Alergias, Medicamentos, Dosis, Operacion, Enfermedades, HMadre, HPadre, HHermanos, HAbuela, HAbuelo);

        JOptionPane.showMessageDialog(this, "Expediente guardado correctamente.");
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }


    public void guardarCita(String NombreCompleto, Date FechaNacimiento, String Genero, String Ocupacion, String Alergias, String Sustancias, String Dosis, String Operacion, String Padecimientos, String HMadre, String HPadre, String HHermanos, String HAbuela, String HAbuelo) {
        String query = "INSERT INTO expedientemedico (nombrecompleto, fechanacimiento, genero, ocupacion, alergias, sustancias, dosis, operaciones, padecimientos, hmadre, hpadre, hhermanos, habuela, habuelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, NombreCompleto);
            statement.setDate(2, FechaNacimiento);
            statement.setString(3, Genero);
            statement.setString(4, Ocupacion);
            statement.setString(5, Alergias);
            statement.setString(6, Sustancias);
            statement.setString(7, Dosis);
            statement.setString(8, Operacion);
            statement.setString(9, Padecimientos);
            statement.setString(10, HMadre);
            statement.setString(11, HPadre);
            statement.setString(12, HHermanos);
            statement.setString(13, HAbuela);
            statement.setString(14, HAbuelo);
            int row = statement.executeUpdate();

            if (row > 0) {
                JOptionPane.showMessageDialog(null, "Ha sido registrado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ExpedienteMed();
    }
}

package tap_proyecto1;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")

public class ExpedienteMed extends JFrame{
    private JTextField nombreCompletoField, fechaField, fechaNacimientoField, ocupacionField;
    private JComboBox<String> generoComboBox;
    private JTextArea alergiasTextArea, operacionesTextArea, otrosPadecimientosTextArea;
    private JCheckBox ningunaAlergiaCheckBox, ningunaOperacionCheckBox;
    private JCheckBox altaPresionCheckBox, diabetesCheckBox, cancerCheckBox, anemiaCheckBox, fCardiacaCheckBox, neumoniaCheckBox, indigestionCheckBox, diarreaCheckBox, bronquitisCheckBox, ulceraCheckBox, hepatitisCheckBox, artritisCheckBox, depresionCheckBox, alcoholismoCheckBox, drogadiccionCheckBox, hemorroidesCheckBox, otroPadecimientoCheckBox;
    private JTextField sustanciasField, dosisField;
    private JTextField madreField, padreField, hermanosField, abuelaField, abueloField;

    public ExpedienteMed() {
        setTitle("Expediente Médico");
        setSize(850, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal y establecer un layout nulo
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(800, 1600)); // Ajustar según el contenido

        int y = 10;  // Coordenada y inicial

        // Sección de Información Personal
        addLabel(mainPanel, "INFORMACIÓN PERSONAL", 10, y, 780, 30, true);
        y += 40;
        addLabel(mainPanel, "Nombre Completo:", 10, y, 200, 30);
        nombreCompletoField = addTextField(mainPanel, 220, y, 560, 30);
        y += 40;
        addLabel(mainPanel, "Fecha:", 10, y, 200, 30);
        fechaField = addTextField(mainPanel, 220, y, 560, 30);
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
        ningunaAlergiaCheckBox = addCheckBox(mainPanel, "Ninguna", 10, y, 780, 30);
        y += 40;
        alergiasTextArea = addTextArea(mainPanel, 10, y, 770, 60);
        y += 70;

        // Sección de Medicamentos, Vitaminas, Suplementos
        addLabel(mainPanel, "ACTUALES MEDICAMENTOS, VITAMINAS, SUPLEMENTOS", 10, y, 780, 30, true);
        y += 40;
        ningunaAlergiaCheckBox = addCheckBox(mainPanel, "Ninguna", 10, y, 780, 30);
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
        ningunaOperacionCheckBox = addCheckBox(mainPanel, "Ninguna", 10, y, 780, 30);
        y += 40;
        operacionesTextArea = addTextArea(mainPanel, 10, y, 770, 60);
        y += 70;

        // Sección de Historia Médica de Padecimientos
        addLabel(mainPanel, "HISTORIA MÉDICA DE PADECIMIENTOS", 10, y, 780, 30, true);
        y += 40;
        altaPresionCheckBox = addCheckBox(mainPanel, "Alta Presión", 10, y, 190, 30);
        diabetesCheckBox = addCheckBox(mainPanel, "Diabetes", 200, y, 190, 30);
        cancerCheckBox = addCheckBox(mainPanel, "Cancer", 390, y, 190, 30);
        anemiaCheckBox = addCheckBox(mainPanel, "Anemia", 580, y, 190, 30);
        y += 40;
        fCardiacaCheckBox = addCheckBox(mainPanel, "F. Cardiaca", 10, y, 190, 30);
        neumoniaCheckBox = addCheckBox(mainPanel, "Neumonía", 200, y, 190, 30);
        indigestionCheckBox = addCheckBox(mainPanel, "Indigestión", 390, y, 190, 30);
        diarreaCheckBox = addCheckBox(mainPanel, "Diarrea", 580, y, 190, 30);
        y += 40;
        bronquitisCheckBox = addCheckBox(mainPanel, "Bronquitis", 10, y, 190, 30);
        ulceraCheckBox = addCheckBox(mainPanel, "Úlcera", 200, y, 190, 30);
        hepatitisCheckBox = addCheckBox(mainPanel, "Hepatitis", 390, y, 190, 30);
        artritisCheckBox = addCheckBox(mainPanel, "Artritis", 580, y, 190, 30);
        y += 40;
        depresionCheckBox = addCheckBox(mainPanel, "Depresión", 10, y, 190, 30);
        alcoholismoCheckBox = addCheckBox(mainPanel, "Alcoholismo", 200, y, 190, 30);
        drogadiccionCheckBox = addCheckBox(mainPanel, "Drogadicción", 390, y, 190, 30);
        hemorroidesCheckBox = addCheckBox(mainPanel, "Hemorroides", 580, y, 190, 30);
        y += 40;
        otroPadecimientoCheckBox = addCheckBox(mainPanel, "Otro", 10, y, 780, 30);
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
        guardarSalirButton.addActionListener(e -> guardarExpediente());
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

    private JCheckBox addCheckBox(JPanel panel, String text, int x, int y, int width, int height) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setBounds(x, y, width, height);
        panel.add(checkBox);
        return checkBox;
    }

    private JTextArea addTextArea(JPanel panel, int x, int y, int width, int height) {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(x, y, width, height);
        panel.add(scrollPane);
        return textArea;
    }

    // Método para guardar el expediente
    private void guardarExpediente() {
        // Implementación para guardar el expediente
        JOptionPane.showMessageDialog(this, "Expediente guardado correctamente.");
    }

    public static void main(String[] args) {
        new ExpedienteMed();
    }
}

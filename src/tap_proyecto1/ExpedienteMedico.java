package tap_proyecto1;

import javax.swing.*;
import java.awt.*;

public class ExpedienteMedico extends JFrame {
    private JTextField nombreCompletoField, fechaField, fechaNacimientoField, ocupacionField;
    private JComboBox<String> generoComboBox;
    private JTextArea alergiasTextArea, operacionesTextArea, otrosPadecimientosTextArea;
    private JCheckBox ningunaAlergiaCheckBox, ningunaOperacionCheckBox;
    private JCheckBox altaPresionCheckBox, diabetesCheckBox, cancerCheckBox, anemiaCheckBox, fCardiacaCheckBox, neumoniaCheckBox, indigestionCheckBox, diarreaCheckBox, bronquitisCheckBox, ulceraCheckBox, hepatitisCheckBox, artritisCheckBox, depresionCheckBox, alcoholismoCheckBox, drogadiccionCheckBox, hemorroidesCheckBox, otroPadecimientoCheckBox;
    private JTextField sustanciasField, dosisField;
    private JTextField madreField, padreField, hermanosField, abuelaField, abueloField;

    public ExpedienteMedico() {
        setTitle("Expediente Médico");
        setSize(800, 920);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));
        setLocationRelativeTo(null);

        // Sección de Información Personal
        addPanel("INFORMACION PERSONAL");
        add(Box.createRigidArea(new Dimension(0, 20))); // Salto de línea después del título
        addCampo("Nombre Completo:");
        nombreCompletoField = new JTextField();
        add(nombreCompletoField);

        addCampo("Fecha:");
        fechaField = new JTextField();
        add(fechaField);

        addCampo("Fecha de Nacimiento:");
        fechaNacimientoField = new JTextField();
        add(fechaNacimientoField);

        addCampo("Género:");
        generoComboBox = new JComboBox<>(new String[]{"Hombre", "Mujer"});
        add(generoComboBox);

        addCampo("Ocupación:");
        ocupacionField = new JTextField();
        add(ocupacionField);

        add(Box.createRigidArea(new Dimension(0, 10))); // Salto de línea

        // Sección de Alergias a Medicamentos u Otras Sustancias
        addPanel("ALERGIAS A MEDICAMENTOS U OTRAS SUSTANCIAS");
        ningunaAlergiaCheckBox = new JCheckBox("Ninguna");
        add(ningunaAlergiaCheckBox);

        alergiasTextArea = new JTextArea(3, 20);
        add(new JScrollPane(alergiasTextArea));

        add(Box.createRigidArea(new Dimension(0, 20))); // Salto de línea

        // Salto de línea antes de la sección de Medicamentos, Vitaminas, Suplementos
        add(Box.createRigidArea(new Dimension(0, 20))); 

        // Sección de Medicamentos, Vitaminas, Suplementos
        addPanel("ACTUALES MEDICAMENTOS, VITAMINAS, SUPLEMENTOS");
        ningunaAlergiaCheckBox = new JCheckBox("Ninguna");
        add(ningunaAlergiaCheckBox);

        addCampo("Sustancias:");
        sustanciasField = new JTextField();
        add(sustanciasField);

        addCampo("Dosis:");
        dosisField = new JTextField();
        add(dosisField);

        add(Box.createRigidArea(new Dimension(0, 20))); // Salto de línea

        // Sección de Operaciones y Hospitalizaciones
        addCampo("OPERACIONES Y HOSPITALIZACIONES");
        ningunaOperacionCheckBox = new JCheckBox("Ninguna");
        add(ningunaOperacionCheckBox);

        operacionesTextArea = new JTextArea(2, 20);
        add(new JScrollPane(operacionesTextArea));

        add(Box.createRigidArea(new Dimension(0, 20))); // Salto de línea

        // Sección de Historia Médica de Padecimientos
        addPanel("HISTORIA MÉDICA DE PADECIMIENTOS");
        altaPresionCheckBox = new JCheckBox("Alta Presión");
        diabetesCheckBox = new JCheckBox("Diabetes");
        cancerCheckBox = new JCheckBox("Cancer");
        anemiaCheckBox = new JCheckBox("Anemia");
        fCardiacaCheckBox = new JCheckBox("F. Cardiaca");
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
        otroPadecimientoCheckBox = new JCheckBox("Otro");
        otrosPadecimientosTextArea = new JTextArea(2, 20);
        add(altaPresionCheckBox);
        add(diabetesCheckBox);
        add(cancerCheckBox);
        add(anemiaCheckBox);
        add(fCardiacaCheckBox);
        add(neumoniaCheckBox);
        add(indigestionCheckBox);
        add(diarreaCheckBox);
        add(bronquitisCheckBox);
        add(ulceraCheckBox);
        add(hepatitisCheckBox);
        add(artritisCheckBox);
        add(depresionCheckBox);
        add(alcoholismoCheckBox);
        add(drogadiccionCheckBox);
        add(hemorroidesCheckBox);
        add(otroPadecimientoCheckBox);
        add(new JScrollPane(otrosPadecimientosTextArea));

        add(Box.createRigidArea(new Dimension(0, 20))); // Salto de línea

        // Sección de Historial Familiar
        addPanel("HISTORIAL FAMILIAR");
        addCampo("Madre:");
        madreField = new JTextField();
        add(madreField);

        addCampo("Padre:");
        padreField = new JTextField();
        add(padreField);

        addCampo("Hermanos:");
        hermanosField = new JTextField();
        add(hermanosField);

        addCampo("Abuela:");
        abuelaField = new JTextField();
        add(abuelaField);

        addCampo("Abuelo:");
        abueloField = new JTextField();
        add(abueloField);

        add(Box.createRigidArea(new Dimension(0, 20))); // Salto de línea

        // Botón de Guardar y Salir
        JButton guardarSalirButton = new JButton("Guardar y Salir");
        guardarSalirButton.addActionListener(e -> guardarExpediente());
        add(guardarSalirButton);

        setVisible(true);
    }

    private void addPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), title));
        add(panel);
    }

    private void addCampo(String label) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel etiqueta = new JLabel(label);
        panel.add(etiqueta);
        add(panel);
    }

    // Método para guardar el expediente
    private void guardarExpediente() {
    }
}

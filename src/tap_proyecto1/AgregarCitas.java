
package tap_proyecto1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;

public class AgregarCitas extends JFrame implements ActionListener {
    private final JLabel CitasIdLabel;
    private final JLabel MedicoLabel;
    private final JLabel DescripcionLabel;
    private final JLabel PacienteLabel;
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
    private final JTextField CitasIdText;
    private final JTextField DescripcionText;
    private final JTextArea NotasText;
    private final JTextField PacienteText;
    private final JComboBox<String> MedicosNombre;
    private final JDateChooser Fecha;
    private final JSpinner hourSpinner;
    private final JSpinner minuteSpinner;

    private static final String nombres[] = {"Médico 1", "Médico 2", "Médico 3", "Médico 4"};

    public AgregarCitas(verCitasAdmin parent, boolean modal) {
        super("Editar cita");
        setSize(600, 650);

        LineBorder border = new LineBorder(new Color(108, 120, 189), 2);
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));

        panel1 = new JPanel();
        panel1.setLayout(null);

        CitasIdLabel = new JLabel("Cita id");
        CitasIdLabel.setBounds(100, 44, 40, 20);
        CitasIdLabel.setForeground(new Color(97, 113, 195));
        CitasIdText = new JTextField();
        CitasIdText.setBounds(100, 70, 75, 30);
        CitasIdText.setBorder(border);

        DescripcionLabel = new JLabel("Descripción");
        DescripcionLabel.setBounds(100, 130, 100, 20);
        DescripcionLabel.setForeground(new Color(97, 113, 195));
        DescripcionText = new JTextField();
        DescripcionText.setBounds(100, 150, 300, 50);
        DescripcionText.setBorder(border);

        panel1.add(CitasIdLabel);
        panel1.add(CitasIdText);
        panel1.add(DescripcionLabel);
        panel1.add(DescripcionText);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(370, 219));

        MedicoLabel = new JLabel("Médico");
        MedicoLabel.setBounds(100, 44, 50, 20);
        MedicoLabel.setForeground(new Color(97, 113, 195));
        MedicosNombre = new JComboBox<>(nombres);
        MedicosNombre.setMaximumRowCount(4);
        MedicosNombre.setBounds(100, 79, 120, 20);
        MedicosNombre.setBorder(border);

        PacienteLabel = new JLabel("Nombre del paciente");
        PacienteLabel.setBounds(300, 44, 140, 20);
        PacienteLabel.setForeground(new Color(97, 113, 195));
        PacienteText = new JTextField();
        PacienteText.setBounds(300, 70, 200, 30);
        PacienteText.setBorder(border);

        FechaLabel = new JLabel("Fecha");
        FechaLabel.setBounds(100, 110, 50, 20);
        FechaLabel.setForeground(new Color(97, 113, 195));
        Fecha = new JDateChooser();
        Fecha.setBounds(100, 140, 100, 20);
        Fecha.setBorder(border);

        HoraLabel = new JLabel("Hora");
        HoraLabel.setBounds(300, 110, 50, 20);
        HoraLabel.setForeground(new Color(97, 113, 195));

        MinutosLabel = new JLabel("Minutos");
        MinutosLabel.setBounds(360, 110, 50, 20);
        MinutosLabel.setForeground(new Color(97, 113, 195));


        SpinnerNumberModel hourModel = new SpinnerNumberModel(7, 7, 22, 1);
        hourSpinner = new JSpinner(hourModel);
        hourSpinner.setBounds(300, 140, 50, 20);
        hourSpinner.setBorder(border);

        SpinnerNumberModel minuteModel = new SpinnerNumberModel(0, 0, 40, 20);
        minuteSpinner = new JSpinner(minuteModel);
        minuteSpinner.setBounds(360, 140, 50, 20);
        minuteSpinner.setBorder(border);

        panel2.add(MedicoLabel);
        panel2.add(MedicosNombre);
        panel2.add(PacienteLabel);
        panel2.add(PacienteText);
        panel2.add(FechaLabel);
        panel2.add(Fecha);
        panel2.add(HoraLabel);
        panel2.add(MinutosLabel);
        panel2.add(hourSpinner);
        panel2.add(minuteSpinner);

        panel3 = new JPanel();
        panel3.setLayout(null);

        NotasLabel = new JLabel("Notas extra");
        NotasLabel.setBounds(100, 5, 80, 20);
        NotasLabel.setForeground(new Color(97, 113, 195));
        NotasText = new JTextArea();
        NotasText.setBounds(100, 30, 300, 100);
        NotasText.setBorder(border);
        GuardarButton = new JButton("Guardar");
        GuardarButton.setBounds(450, 20, 100, 40);
        GuardarButton.setForeground(new Color(255, 255, 255));
        GuardarButton.setBackground(new Color(62, 81, 180));
        CancelarButton = new JButton("Cancelar");
        CancelarButton.setBounds(450, 70, 100, 40);
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
        if (e.getSource() == CancelarButton || e.getSource() == GuardarButton) {
            dispose();
        }
    }
}

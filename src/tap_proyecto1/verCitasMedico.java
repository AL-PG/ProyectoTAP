
package tap_proyecto1;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class verCitasMedico extends JFrame {

    private JPanel panelCitas;
    private JPanel panelLabel;
    private JTable tablaCitas;
    private JScrollPane citasScroll;
    private JLabel fechaLabel;
    private JLabel citasLabel;

    public verCitasMedico() {
        super("Agenda de citas");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelLabel = new JPanel();
        fechaLabel = new JLabel(getFechaActual());
        fechaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fechaLabel.setForeground(Color.WHITE);
        fechaLabel.setBackground(new Color(12, 111, 253)); 
        fechaLabel.setOpaque(true); 
        fechaLabel.setFont(new Font("Arial", Font.BOLD, 15));

        citasLabel = new JLabel("Agenda de citas");
        citasLabel.setFont(new Font("Arial", Font.BOLD, 20));
        citasLabel.setForeground(Color.WHITE);
        citasLabel.setBackground(new Color(12, 111, 253)); 
        citasLabel.setOpaque(true); 
        citasLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panelLabel.setLayout(new BorderLayout());
        panelLabel.add(citasLabel, BorderLayout.CENTER);
        panelLabel.add(fechaLabel, BorderLayout.SOUTH);
    

        String[] columnasNombre = {"Hora", "Paciente", "Descripción", "Notas"};
        DefaultTableModel model = new DefaultTableModel(null, columnasNombre);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        while (calendar.get(Calendar.HOUR_OF_DAY) < 22) {
            String hora = dateFormat.format(calendar.getTime());
            model.addRow(new Object[]{hora, "", ""}); 
            calendar.add(Calendar.MINUTE, 20); 
        }

        tablaCitas = new JTable(model);
        tablaCitas.setEnabled(false);
        tablaCitas.setFont(new Font("Arial", Font.PLAIN, 16));
        tablaCitas.setBorder(new LineBorder(Color.BLUE));

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
        citasScroll.setPreferredSize(preferredSize);
        citasScroll.setBorder(new LineBorder(Color.BLUE));
        panelCitas = new JPanel();
        panelCitas.add(citasScroll, BorderLayout.CENTER);

        panelCitas.setBackground(Color.WHITE);
        panelLabel.setBackground(Color.WHITE);

        add(panelCitas, BorderLayout.CENTER);
        add(panelLabel, BorderLayout.NORTH);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            SwingUtilities.invokeLater(() -> {
                ajustarAnchoColumna();
            });
        }
    }

    private void ajustarAnchoColumna() {
        TableColumnModel columnModel = tablaCitas.getColumnModel();
        TableColumn horaColumn = columnModel.getColumn(0);
        horaColumn.setPreferredWidth(5);
    }

    private String getFechaActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        return "Fecha actual: " + dateFormat.format(cal.getTime());
    }
}


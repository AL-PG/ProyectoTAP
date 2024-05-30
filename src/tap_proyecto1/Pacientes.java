package tap_proyecto1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;

public class Pacientes extends JFrame {

    public Pacientes() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        fieldFoto = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fieldFoto.setIcon(new ImageIcon(getClass().getResource("/tap_proyecto1/R.png"))); // NOI18N

        jButton1.setText("Informacion Personal");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Expediente Medico");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(fieldFoto)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(fieldFoto, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
      new VerPacientes().setVisible(true);
    }
    private void jButton2ActionPerformed(ActionEvent evt) {
       new ExpedienteMed().setVisible(true);
    }

    private JLabel fieldFoto;
    private JButton jButton1;
    private JButton jButton2;
}

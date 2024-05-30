package tap_proyecto1;

import javax.swing.*;
import org.edisoncor.gui.button.ButtonColoredAction;
import org.edisoncor.gui.button.ButtonRound;
import org.edisoncor.gui.passwordField.PasswordFieldRound;
import org.edisoncor.gui.textField.TextFieldRound;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.swing.LayoutStyle.ComponentPlacement;

public class Login extends javax.swing.JFrame {
    
    private ButtonColoredAction buttonColoredAction1;
    private TextFieldRound fieldCorreo;
    private PasswordFieldRound fieldPassword;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        fieldCorreo = new TextFieldRound();
        fieldPassword = new PasswordFieldRound();
        buttonColoredAction1 = new ButtonColoredAction();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel1.setText("Correo:");

        jLabel2.setText("Contraseña:");

        buttonColoredAction1.setBackground(new java.awt.Color(153, 204, 255));
        buttonColoredAction1.setText("Entrar");
        buttonColoredAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonColoredAction1ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldCorreo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(buttonColoredAction1, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                .addContainerGap(9, Short.MAX_VALUE))

        )));
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCorreo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(fieldPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(buttonColoredAction1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }

    private void buttonRound1ActionPerformed(ActionEvent evt) {
        
    }

    private void buttonColoredAction1ActionPerformed(ActionEvent evt) {
       String correo = fieldCorreo.getText();
        String contrasena = new String(fieldPassword.getPassword());

        String url = "jdbc:postgresql://localhost:5432/consultorio";
        String usuario = "postgres";
        String contraseña = "D277353527316d*";

        String sql = "SELECT contrasena FROM public.usuario WHERE correo = ? AND contrasena = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            pstmt.setString(2, contrasena);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}


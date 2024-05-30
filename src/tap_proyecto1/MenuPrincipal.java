
package tap_proyecto1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MenuPrincipal extends JFrame{
    
    private final JPanel panel; 
    private final JPanel panel2; 
    private final JPanel panelBotones; 
    
    private final JButton botonP;
    private final JButton botonC;
    private final JButton botonAdmin;
    private final JButton boton1;
   
    private final JMenuBar botonM;
    private final JLabel fondo;
    
    
         public MenuPrincipal(){
        
         setTitle("Menu Principal");
         setSize(550,350);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         
         ImageIcon iconoAdmin = new ImageIcon("imagenes/candado.jpg");
         ImageIcon imagenFondo = new ImageIcon("imagenes/cons.png");
         ImageIcon iconoPaciente = new ImageIcon("imagenes/paciente.png");
         ImageIcon iconoCitas = new ImageIcon("imagenes/age.png");
        
        //creacion de paneles y botones
        //instanciar a los objetos 
        panel = new JPanel();
        panel2 = new JPanel();
        panelBotones = new JPanel();
        botonM = new JMenuBar();
          
        setJMenuBar(botonM); // Aquí está el cambio
        
        panel.setLayout(new BorderLayout());
        
        panelBotones.setLayout(new GridLayout(4,1));
        
        add(panel);
        panel.add(panelBotones,BorderLayout.WEST);
        panel.add(panel2,BorderLayout.EAST);
       
        fondo = new JLabel(imagenFondo);
        boton1 = new JButton("");
        
        botonP = new JButton(null,iconoPaciente);
        botonC = new JButton(null, iconoCitas);
        botonAdmin = new JButton(null,iconoAdmin);
        
        panelBotones.add(boton1);
        panelBotones.add(botonP);
        panelBotones.add(botonC);
        panelBotones.add(botonAdmin);
        panel2.add(fondo);
        
        
        
        botonP.addActionListener( new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           Pacientes perfil = new Pacientes();
                perfil.setVisible(true);
        }
    });
        
        botonC.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        verCitasMedico citas = new verCitasMedico();
                        citas.setVisible(true);
                    }
                });    
            }
        });
        
        botonAdmin.addActionListener( new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           verCitasAdmin admin = new verCitasAdmin ();
 
                admin.setVisible(true);
        }
        });
           
    }
         
}


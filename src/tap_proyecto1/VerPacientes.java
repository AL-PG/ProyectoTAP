package tap_proyecto1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class VerPacientes extends JFrame{
    private JButton BEditar;
    private JButton BVerExpediente;
    private JButton BCrearExpediente;
    private JButton BSalir;
    private JLabel LImagen;
    private JLabel LNombre;
    private JLabel ContNombre;
    private JLabel LIdPaciente;
    private JLabel ContIdPaciente;
    private JLabel LEdad;
    private JLabel ContEdad;
    private JLabel LSexo;
    private JLabel ContSexo;
    private JLabel LFechaIng;
    private JLabel ContFechaIng;
    private JLabel LHoraIng;
    private JLabel ContHoraIng;
    private JLabel LCurp;
    private JLabel ContCurp;
    private JLabel LFechaNac;
    private JLabel ContFechaNac;
    private JLabel LTelefono;
    private JLabel ContTelefono;
    private JLabel LCorreo;
    private JLabel ContCorreo;
    private JLabel LDireccion;
    private JLabel ContDireccion;
    private JLabel LCodigoPost;
    private JLabel ContCodigoPost;
    private JLabel LCiudad;
    private JLabel ContCiudad;
    private JLabel LEstado;
    private JLabel ContEstado;
    private JLabel LPais;
    private JLabel ContPais;
    private JLabel LNombreSeguro;
    private JLabel ContNombreSeguro;
    private JLabel LNumPoliza;
    private JLabel ContNumPoliza;
    private JLabel LTitularPoliza;
    private JLabel ContTitularPoliza;
    private JLabel LNombreEmergencia;
    private JLabel ContNombreEmergencia;
    private JLabel LTelefonoEmergencia;
    private JLabel ContiTelefonoEmergencia;
    private JLabel LRelacionPaciente;
    private JLabel ContRelacionPaciente;
    private JLabel LTitulo1;
    private JLabel LTitulo2;
    private JLabel LTitulo3;
    
    public VerPacientes(){
    
        setSize(605,880);
        setBackground(Color.WHITE);

        Font fontTitulos = new Font("Arial", Font.BOLD, 20);
        Font font = new Font("Arial", Font.BOLD, 14); 
        Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE);

        BEditar = new JButton("Editar");
        BEditar.setBounds(10, 10, 160, 40);
        BEditar.setBackground(Color.BLUE);
        BEditar.setForeground(Color.WHITE);
        add(BEditar);

        BCrearExpediente = new JButton("Crear Expediente");
        BCrearExpediente.setBounds(220, 10, 160, 40);
        BCrearExpediente.setBackground(Color.BLUE);
        BCrearExpediente.setForeground(Color.WHITE);
        add(BCrearExpediente);

        BVerExpediente= new JButton("Ver Expediente");
        BVerExpediente.setBounds(420, 10, 160, 40);
        BVerExpediente.setBackground(Color.BLUE);
        BVerExpediente.setForeground(Color.WHITE);
        add(BVerExpediente);
        
        BSalir = new JButton("Salir");
        BSalir.setBounds(500, 810, 80, 30);
        BSalir.setBackground(Color.RED);
        BSalir.setForeground(Color.WHITE);
        add(BSalir);

        Border borde = BorderFactory.createLineBorder(Color.BLACK, 1);

        JPanel panel1 = new JPanel();
        panel1.setBounds(10, 55, 570, 480);
        panel1.setBorder(borde);
        panel1.setLayout(null);
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBounds(10, 545, 280, 260);
        panel2.setBorder(borde);
        panel2.setLayout(null);
        add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBounds(280, 480, 265, 260);
        panel3.setBorder(borde);
        add(panel3);

        JPanel panel4 = new JPanel();
        panel3.setBounds(300, 545, 280, 260);
        panel3.setBorder(borde);
        panel3.setLayout(null);
        add(panel4);

        LImagen = new JLabel("Aqui va una foto del Paciente");
        LImagen.setBounds(10, 10, 160, 140);
        LImagen.setBorder(borde);
        panel1.add(LImagen);

        LNombre = new JLabel("Nombre");
        LNombre.setBounds(185, 70, 150, 20);
        LNombre.setFont(font);
        LNombre.setForeground(Color.BLUE);
        panel1.add(LNombre);

        ContNombre = new JLabel("JUAN PEREZ RODRIGUEZ");
        ContNombre.setBounds(185, 45, 280, 20);
        ContNombre.setFont(font);
        ContNombre.setBorder(bordeInferior);
        panel1.add(ContNombre);

        LIdPaciente = new JLabel("ID Paciente");
        LIdPaciente.setBounds(185, 120, 150, 20);
        LIdPaciente.setFont(font);
        LIdPaciente.setForeground(Color.BLUE);
        panel1.add(LIdPaciente);
        
        ContIdPaciente = new JLabel("PA-002");
        ContIdPaciente.setBounds(185, 95, 280, 20);
        ContIdPaciente.setFont(font);
        ContIdPaciente.setBorder(bordeInferior);
        panel1.add(ContIdPaciente);

        LEdad = new JLabel("Edad");
        LEdad.setBounds(10, 195, 120, 20);
        LEdad.setFont(font);
        LEdad.setForeground(Color.BLUE);
        panel1.add(LEdad);

        ContEdad = new JLabel("20");
        ContEdad.setBounds(10, 170, 125, 20);
        ContEdad.setFont(font);
        ContEdad.setBorder(bordeInferior);
        panel1.add(ContEdad);

        LSexo = new JLabel("Sexo");
        LSexo.setBounds(150, 195, 120, 20);
        LSexo.setFont(font);
        LSexo.setForeground(Color.BLUE);
        panel1.add(LSexo);

        ContSexo = new JLabel("HOMBRE");
        ContSexo.setBounds(150, 170, 125, 20);
        ContSexo.setFont(font);
        ContSexo.setBorder(bordeInferior);
        panel1.add(ContSexo);

        LFechaIng = new JLabel("Fecha Ingreso");
        LFechaIng.setBounds(300, 195, 120, 20);
        LFechaIng.setFont(font);
        LFechaIng.setForeground(Color.BLUE);
        panel1.add(LFechaIng);

        ContFechaIng = new JLabel("20 - Marzo - 2023");
        ContFechaIng.setBounds(300, 170, 125, 20);
        ContFechaIng.setFont(font);
        ContFechaIng.setBorder(bordeInferior);
        panel1.add(ContFechaIng);

        LHoraIng = new JLabel("Hora Ingreso");
        LHoraIng.setBounds(450, 195, 115, 20);
        LHoraIng.setFont(font);
        LHoraIng.setForeground(Color.BLUE);
        panel1.add(LHoraIng);

        ContHoraIng = new JLabel("20:40 pm");
        ContHoraIng.setBounds(450, 170, 110, 20);
        ContHoraIng.setFont(font);
        ContHoraIng.setBorder(bordeInferior);
        panel1.add(ContHoraIng);

        LCurp = new JLabel("CURP");
        LCurp.setBounds(10, 265, 170, 20);
        LCurp.setFont(font);
        LCurp.setForeground(Color.BLUE);
        panel1.add(LCurp);

        ContCurp = new JLabel();
        ContCurp.setBounds(10, 240, 260, 20);
        ContCurp.setFont(font);
        ContCurp.setBorder(bordeInferior);
        panel1.add(ContCurp);

        LFechaNac = new JLabel("Fecha de nacimiento");
        LFechaNac.setBounds(300, 265, 170, 20);
        LFechaNac.setFont(font);
        LFechaNac.setForeground(Color.BLUE);
        panel1.add(LFechaNac);

        ContFechaNac = new JLabel("30 - Enero - 2004");
        ContFechaNac.setBounds(300, 240, 260, 20);
        ContFechaNac.setFont(font);
        ContFechaNac.setBorder(bordeInferior);
        panel1.add(ContFechaNac);

        LTelefono = new JLabel("Teléfono");
        LTelefono.setBounds(10, 335, 170, 20);
        LTelefono.setFont(font);
        LTelefono.setForeground(Color.BLUE);
        panel1.add(LTelefono);

        ContTelefono = new JLabel("4434188890");
        ContTelefono.setBounds(10, 310, 260, 20);
        ContTelefono.setFont(font);
        ContTelefono.setBorder(bordeInferior);
        panel1.add(ContTelefono);

        LCorreo = new JLabel("Correo electrónico");
        LCorreo.setBounds(300, 335, 170, 20);
        LCorreo.setFont(font);
        LCorreo.setForeground(Color.BLUE);
        panel1.add(LCorreo);

        ContCorreo = new JLabel("juanperez@gmail.com");
        ContCorreo.setBounds(300, 310, 260, 20);
        ContCorreo.setFont(font);
        ContCorreo.setBorder(bordeInferior);
        panel1.add(ContCorreo);

        LDireccion = new JLabel("Dirección");
        LDireccion.setBounds(10, 395, 170, 20);
        LDireccion.setFont(font);
        LDireccion.setForeground(Color.BLUE);
        panel1.add(LDireccion);

        ContDireccion = new JLabel("Prados Verdes-Paseo del Fresno 627");
        ContDireccion.setBounds(10, 370, 260, 20);
        ContDireccion.setFont(font);
        ContDireccion.setBorder(bordeInferior);
        panel1.add(ContDireccion);

        LCodigoPost = new JLabel("Código postal");
        LCodigoPost.setBounds(300, 395, 120, 20);
        LCodigoPost.setFont(font);
        LCodigoPost.setForeground(Color.BLUE);
        panel1.add(LCodigoPost);

        ContCodigoPost = new JLabel("58110");
        ContCodigoPost.setBounds(300, 370, 125, 20);
        ContCodigoPost.setFont(font);
        ContCodigoPost.setBorder(bordeInferior);
        panel1.add(ContCodigoPost);

        LCiudad = new JLabel("Ciudad");
        LCiudad.setBounds(10, 455, 120, 20);
        LCiudad.setFont(font);
        LCiudad.setForeground(Color.BLUE);
        panel1.add(LCiudad);

        ContCiudad = new JLabel("Morelia");
        ContCiudad.setBounds(10, 430, 125, 20);
        ContCiudad.setFont(font);
        ContCiudad.setBorder(bordeInferior);
        panel1.add(ContCiudad);

        LEstado = new JLabel("Estado");
        LEstado.setBounds(150, 455, 120, 20);
        LEstado.setFont(font);
        LEstado.setForeground(Color.BLUE);
        panel1.add(LEstado);

        ContEstado = new JLabel("Michoacan");
        ContEstado.setBounds(150, 430, 125, 20);
        ContEstado.setFont(font);
        ContEstado.setBorder(bordeInferior);
        panel1.add(ContEstado);

        LPais = new JLabel("País");
        LPais.setBounds(300, 455, 120, 20);
        LPais.setFont(font);
        LPais.setForeground(Color.BLUE);
        panel1.add(LPais);

        ContPais = new JLabel("Mexico");
        ContPais.setBounds(300, 430, 125, 20);
        ContPais.setFont(font);
        ContPais.setBorder(bordeInferior);
        panel1.add(ContPais);

        
        LNombreSeguro = new JLabel("Nombre del seguro");
        LNombreSeguro.setBounds(10, 75, 220, 20);
        LNombreSeguro.setFont(font);
        LNombreSeguro.setForeground(Color.BLUE);
        panel2.add(LNombreSeguro);

        ContNombreSeguro = new JLabel();
        ContNombreSeguro.setBounds(10, 50, 250, 20);
        ContNombreSeguro.setFont(font);
        ContNombreSeguro.setBorder(bordeInferior);
        panel2.add(ContNombreSeguro);

        LNumPoliza = new JLabel("Número de póliza");
        LNumPoliza.setBounds(10, 140, 220, 20);
        LNumPoliza.setFont(font);
        LNumPoliza.setForeground(Color.BLUE);
        panel2.add(LNumPoliza);

        ContNumPoliza = new JLabel();
        ContNumPoliza.setBounds(10,115, 250, 20);
        ContNumPoliza.setFont(font);
        ContNumPoliza.setBorder(bordeInferior);
        panel2.add(ContNumPoliza);

        LTitularPoliza = new JLabel("Titular de la póliza");
        LTitularPoliza.setBounds(10, 205, 220, 20);
        LTitularPoliza.setFont(font);
        LTitularPoliza.setForeground(Color.BLUE);
        panel2.add(LTitularPoliza);

        ContTitularPoliza = new JLabel();
        ContTitularPoliza.setBounds(10,180, 250, 20);
        ContTitularPoliza.setFont(font);
        ContTitularPoliza.setBorder(bordeInferior);
        panel2.add(ContTitularPoliza);

        LNombreEmergencia = new JLabel("Nombre de emergencia");
        LNombreEmergencia.setBounds(10, 75, 220, 20);
        LNombreEmergencia.setFont(font);
        LNombreEmergencia.setForeground(Color.BLUE);
        panel3.add(LNombreEmergencia);

        ContNombreEmergencia = new JLabel();
        ContNombreEmergencia.setBounds(10, 50, 250, 20);
        ContNombreEmergencia.setFont(font);
        ContNombreEmergencia.setBorder(bordeInferior);
        panel3.add(ContNombreEmergencia);
        
        LTelefonoEmergencia = new JLabel("Teléfono de emergencia");
        LTelefonoEmergencia.setBounds(10, 140, 220, 20);
        LTelefonoEmergencia.setFont(font);
        LTelefonoEmergencia.setForeground(Color.BLUE);
        panel3.add(LTelefonoEmergencia);
        
        ContiTelefonoEmergencia = new JLabel();
        ContiTelefonoEmergencia.setBounds(10,115, 250, 20);
        ContiTelefonoEmergencia.setFont(font);
        ContiTelefonoEmergencia.setBorder(bordeInferior);
        panel3.add(ContiTelefonoEmergencia);
        
        LRelacionPaciente = new JLabel("Relación con el paciente");
        LRelacionPaciente.setBounds(10, 205, 220, 20);
        LRelacionPaciente.setFont(font);
        LRelacionPaciente.setForeground(Color.BLUE);
        panel3.add(LRelacionPaciente);
        
        ContRelacionPaciente = new JLabel();
        ContRelacionPaciente.setBounds(10,180, 250, 20);
        ContRelacionPaciente.setFont(font);
        ContRelacionPaciente.setBorder(bordeInferior);
        panel3.add(ContRelacionPaciente);
        
        LTitulo1 = new JLabel("DATOS PERSONALES");
        LTitulo1.setForeground(Color.BLUE);
        LTitulo1.setBounds(185, 10, 220, 20);
        LTitulo1.setFont(fontTitulos);
        panel1.add(LTitulo1);
        
        LTitulo2 = new JLabel("SEGURO MEDICO");
        LTitulo2.setForeground(Color.BLUE);
        LTitulo2.setBounds(55, 10, 220, 20);
        LTitulo2.setFont(fontTitulos);
        panel2.add(LTitulo2);

        LTitulo3 = new JLabel("EMERGENCIA");
        LTitulo3.setForeground(Color.BLUE);
        LTitulo3.setBounds(80, 10, 220, 20);
        LTitulo3.setFont(fontTitulos);
        panel3.add(LTitulo3);
        
    }
}


package tap_proyecto1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.*;

public class pacienteFormulario1 extends JFrame {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/consultorio";
    private static final String USER = "postgres";
    private static final String PASS = "D277353527316d";

    public pacienteFormulario1(verCitasAdmin parent, boolean modal) {
        initComponents();

        setLocationRelativeTo(null);

         guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreB = nombre.getText();
                String apellidosB = apellido.getText();
                String telefonoB = telefonoPaciente.getText();
                String estadoCivilB = null;
                if(soltero.isSelected()){
                    estadoCivilB = soltero.getText();
                } else if(casado.isSelected()){
                    estadoCivilB = casado.getText();
                } else if(viudo.isSelected()){
                    estadoCivilB = viudo.getText();
                }
                String correoB = correo.getText();
                String diaStr = (String) diaNacimiento.getSelectedItem();
                int diaInt = Integer.parseInt(diaStr);
                String mesStr = (String) mesNacimiento.getSelectedItem();
                int mesInt = Integer.parseInt(mesStr);
                int anioInt = Integer.parseInt(anioNacimiento.getText());

                LocalDate date = LocalDate.of(anioInt, mesInt, diaInt);
                Date fechaNacB = Date.valueOf(date);
                String motivoConsultaB = motivoVisita.getText();
                String antecedentesMedicB = antecentesMedicos.getText();
                String medicamentosActualesB = medicamentosMedicos.getText();
                String alergiasB = alergias.getText();
                String nombreSeguroB = nombreSeguro.getText();
                String numeroPolizaB = numeroPoliza.getText();
                String nombreTitularPoliaB = titularPoliza.getText();
                String contactoEmerNombreB = contactoEmergia.getText();
                String telefonoEmerB = telefonoEmergencia.getText();
                String relacionPacienteB = relacionPaciente.getText();
                String generoB = (String) sexx.getSelectedItem();


                insertPaciente(nombreB, apellidosB, telefonoB, estadoCivilB, correoB, fechaNacB, motivoConsultaB, antecedentesMedicB, medicamentosActualesB,
                alergiasB, nombreSeguroB, numeroPolizaB, nombreTitularPoliaB, contactoEmerNombreB, telefonoEmerB, relacionPacienteB, generoB);
            }

        });
       
    }
    public static void insertPaciente(String nombre, String apellidos, String telefono, String estadoCivil, 
                                     String correo, Date fechaNac, String motivoConsulta, String antecedentesMedic, 
                                     String medicamentosActuales, String alergias, String nombreSeguro, 
                                     String numeroPoliza, String nombreTitularPoliza, String contactoEmerNombre, 
                                     String telefonoEmer, String relacionPaciente, String genero) {
        String sql = "INSERT INTO public.paciente (nombre, apellidos, \"teléfono\", \"estadoCivil\", correo, " +
                     "\"fechaNac\", \"motivoConsulta\", \"antecedentesMedic\", \"medicamentosActuales\", alergias, " +
                     "\"nombreSeguro\", \"numeroPoliza\", \"nombreTitularPolia\", \"contactoEmerNombre\", " +
                     "\"telefonoEmer\", \"relacionPaciente\", genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, telefono);
            pstmt.setString(4, estadoCivil);
            pstmt.setString(5, correo);
            pstmt.setDate(6, fechaNac);
            pstmt.setString(7, motivoConsulta);
            pstmt.setString(8, antecedentesMedic);
            pstmt.setString(9, medicamentosActuales);
            pstmt.setString(10, alergias);
            pstmt.setString(11, nombreSeguro);
            pstmt.setString(12, numeroPoliza);
            pstmt.setString(13, nombreTitularPoliza);
            pstmt.setString(14, contactoEmerNombre);
            pstmt.setString(15, telefonoEmer);
            pstmt.setString(16, relacionPaciente);
            pstmt.setString(17, genero);
    
            int row =  pstmt.executeUpdate();
    
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "El paciente ha sido registrado exitosamente.");
            }
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el paciente: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTextPane1 = new JTextPane();
        buttonGroup1 = new ButtonGroup();
        Titulo = new JLabel();
        nombre = new JTextField();
        apellido = new JTextField();
        direccion = new JTextField();
        sexx = new JComboBox<>();
        ocupacion = new JTextField();
        diaNacimiento = new JComboBox<>();
        mesNacimiento = new JComboBox<>();
        anioNacimiento = new JTextField();
        jLabel3 = new JLabel();
        telefonoPaciente = new JTextField();
        correo = new JTextField();
        informacionmedica = new JLabel();
        informacionSobreSeguro = new JLabel();
        antecentesMedicos = new JTextField();
        medicamentosMedicos = new JTextField();
        alergias = new JTextField();
        motivoVisita = new JTextField();
        nombreSeguro = new JTextField();
        numeroPoliza = new JTextField();
        titularPoliza = new JTextField();
        contactoEmergia = new JLabel();
        nombreCompleto = new JTextField();
        telefonoEmergencia = new JTextField();
        relacionPaciente = new JTextField();
        jLabel6 = new JLabel();
        consentimientoPaciente = new JLabel();
        nombreYFirma = new JLabel();
        fecha = new JLabel();
        acepto = new Checkbox();
        guardar = new JButton();
        soltero = new JRadioButton();
        casado = new JRadioButton();
        viudo = new JRadioButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(92, 121, 144));

        Titulo.setBackground(new Color(153, 153, 255));
        Titulo.setFont(new Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Titulo.setForeground(new Color(51, 51, 255));
        Titulo.setText("DATOS PERSONALES");

        nombre.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                nombreFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                nombreFocusLost(evt);
            }
        });
       apellido.setText("Apellido(s)");
        apellido.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                apellidoFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                apellidoFocusLost(evt);
            }
        });
        direccion.setText("Dirección");
        direccion.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                direccionFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                direccionFocusLost(evt);
            }
        });
        sexx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mujer", "Hombre" }));
        sexx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexxActionPerformed(evt);
            }
        });


        ocupacion.setText("Ocupación");
        ocupacion.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                ocupacionFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                ocupacionFocusLost(evt);
            }
        });

        diaNacimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        diaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaNacimientoActionPerformed(evt);
            }
        });

        mesNacimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        mesNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesNacimientoActionPerformed(evt);
            }
        });

        anioNacimiento.setText("Año");
        anioNacimiento.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                anioNacimientoFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                anioNacimientoFocusLost(evt);
            }
        });

        jLabel3.setText("Fecha de Nacimiento");

        telefonoPaciente.setText("Télefono");
        telefonoPaciente.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                telefonoPacienteFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                telefonoPacienteFocusLost(evt);
            }
        });

        correo.setText("Correro Electronico");
        correo.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                correoFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                correoFocusLost(evt);
            }
        });

        informacionmedica.setFont(new Font("Yu Gothic UI Semibold", 1, 18)); 
        informacionmedica.setForeground(new Color(51, 51, 255));
        informacionmedica.setText("INFORMACIÓN MEDICA");

        informacionSobreSeguro.setFont(new Font("Yu Gothic UI Semibold", 1, 18)); 
        informacionSobreSeguro.setForeground(new Color(51, 51, 255));
        informacionSobreSeguro.setText("INFORMACIÓN SOBRE SEGURO MÉDICO");

        antecentesMedicos.setText("Antecedentes Medicos");
        antecentesMedicos.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                antecentesMedicosFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                antecentesMedicosFocusLost(evt);
            }
        });

        medicamentosMedicos.setText("Medicamentos Actuales");
        medicamentosMedicos.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                medicamentosMedicosFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                medicamentosMedicosFocusLost(evt);
            }
        });

        alergias.setText("Alergias");
        alergias.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                alergiasFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                alergiasFocusLost(evt);
            }
        });

        motivoVisita.setText("Motivo de Consulta");
        motivoVisita.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                motivoVisitaFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                motivoVisitaFocusLost(evt);
            }
        });

        nombreSeguro.setText("Nombre de Seguro");
        nombreSeguro.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                nombreSeguroFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                nombreSeguroFocusLost(evt);
            }
        });
        numeroPoliza.setText("Numero de Poliza");
        numeroPoliza.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                numeroPolizaFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                numeroPolizaFocusLost(evt);
            }
        });

        titularPoliza.setText("Nombre de Titular de la Poliza");
        titularPoliza.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                titularPolizaFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                titularPolizaFocusLost(evt);
            }
        });

        contactoEmergia.setFont(new Font("Yu Gothic UI Semibold", 1, 18));
        contactoEmergia.setForeground(new Color(51, 51, 255));
        contactoEmergia.setText("CONTACTO DE EMERGENCIA");

        nombreCompleto.setText("Nombre Completo");
        nombreCompleto.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                nombreCompletoFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                nombreCompletoFocusLost(evt);
            }
        });

        telefonoEmergencia.setText("Teléfono");
        telefonoEmergencia.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                telefonoEmergenciaFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                telefonoEmergenciaFocusLost(evt);
            }
        });

        relacionPaciente.setText("Relación con el Paciente");
        relacionPaciente.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                relacionPacienteFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                relacionPacienteFocusLost(evt);
            }
        });

        consentimientoPaciente.setFont(new Font("Yu Gothic UI Semibold", 1, 18)); 
        consentimientoPaciente.setForeground(new Color(51, 51, 255));
        consentimientoPaciente.setText("CONSENTIMIENTO DEL PACIENTE");

        nombreYFirma.setText("Nombre y firma paciente");
        fecha.setText("Fecha");
        acepto.setLabel("Acepto");
        guardar.setText("GUARDAR");

        buttonGroup1.add(soltero);
        soltero.setText("Soltero");

        buttonGroup1.add(casado);
        casado.setText("Casado");

        buttonGroup1.add(viudo);
        viudo.setText("Viudo");

       GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(motivoVisita)
                            .addComponent(alergias)
                            .addComponent(medicamentosMedicos)
                            .addComponent(antecentesMedicos)
                            .addComponent(telefonoPaciente)
                            .addComponent(nombre)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sexx, 0, 82, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ocupacion, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
                            .addComponent(direccion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(informacionmedica)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(diaNacimiento, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(casado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mesNacimiento, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(anioNacimiento, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(viudo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(soltero, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellido, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(titularPoliza, GroupLayout.Alignment.LEADING)
                                .addComponent(numeroPoliza, GroupLayout.Alignment.LEADING)
                                .addComponent(nombreSeguro, GroupLayout.Alignment.LEADING)
                                .addComponent(correo, GroupLayout.Alignment.LEADING)
                                .addComponent(informacionSobreSeguro, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(consentimientoPaciente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(contactoEmergia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(acepto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nombreYFirma, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fecha, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(guardar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37))))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombreCompleto, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(telefonoEmergencia, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(relacionPaciente)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(Titulo)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(Titulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(direccion)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(diaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(anioNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(ocupacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(soltero)
                            .addComponent(casado)
                            .addComponent(viudo))))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(informacionSobreSeguro)
                    .addComponent(informacionmedica, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(motivoVisita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreSeguro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(antecentesMedicos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroPoliza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(medicamentosMedicos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(titularPoliza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(alergias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(contactoEmergia)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(nombreCompleto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoEmergencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(relacionPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(consentimientoPaciente)
                .addGap(21, 21, 21)
                .addComponent(acepto, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreYFirma)
                    .addComponent(fecha)
                    .addComponent(guardar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }

    private void nombreFocusGained(FocusEvent evt) {
           nombre.setText("");   
    }

    private void nombreFocusLost(FocusEvent evt) {
        if (nombre.getText().isEmpty()){
            nombre.setText("Nombre(s)");
        }
    }
    private void apellidoFocusGained(FocusEvent evt) {
           apellido.setText("");
    }

    private void apellidoFocusLost(FocusEvent evt) {
        if (apellido.getText().isEmpty()){
        apellido.setText("Apellido(s)");
        }
    }
    private void direccionFocusGained(FocusEvent evt) {
        direccion.setText("");
    }

    private void direccionFocusLost(FocusEvent evt) {
        if (direccion.getText().isEmpty()){
        direccion.setText("Direccion");
        }
    }
    private void sexxActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void ocupacionFocusGained(FocusEvent evt) {
        ocupacion.setText("");
    }

    private void ocupacionFocusLost(FocusEvent evt) {
        if (ocupacion.getText().isEmpty()){
        ocupacion.setText("Ocupacion");
        }        
    }

    private void diaNacimientoActionPerformed(ActionEvent evt) {
        anioNacimiento.setText("");
    }

    private void mesNacimientoActionPerformed(ActionEvent evt) {
        anioNacimiento.setText("");
    }

    private void anioNacimientoFocusGained(FocusEvent evt) {
        anioNacimiento.setText("");
    }

    private void anioNacimientoFocusLost(FocusEvent evt) {
        if (anioNacimiento.getText().isEmpty()){
        anioNacimiento.setText("año");
        }
    }

    private void telefonoPacienteFocusGained(FocusEvent evt) {
        telefonoPaciente.setText("");
    }

    private void telefonoPacienteFocusLost(FocusEvent evt) {
        if (telefonoPaciente.getText().isEmpty()){
        telefonoPaciente.setText("Telefono");
        }
    }

    private void correoFocusGained(FocusEvent evt) {
        correo.setText("");
    }

    private void correoFocusLost(FocusEvent evt) {
        if (correo.getText().isEmpty()){
            correo.setText("Correo Electronico");
        }
    }

    private void motivoVisitaFocusGained(FocusEvent evt) {
        motivoVisita.setText("");
    }

    private void motivoVisitaFocusLost(FocusEvent evt) {
        if (motivoVisita.getText().isEmpty()){
        motivoVisita.setText("Motivo de Consulta");
        }
    }

    private void nombreSeguroFocusGained(FocusEvent evt) {
        nombreSeguro.setText("");
    }

    private void nombreSeguroFocusLost(FocusEvent evt) {
        if (nombreSeguro.getText().isEmpty()){
        nombreSeguro.setText("Nombre de seguro");
        }
    }

    private void antecentesMedicosFocusGained(FocusEvent evt) {
        antecentesMedicos.setText("");
    }

    private void antecentesMedicosFocusLost(FocusEvent evt) {
         if (antecentesMedicos.getText().isEmpty()){
        antecentesMedicos.setText("Antecedentes Medicos");
        }
    }

    private void numeroPolizaFocusGained(FocusEvent evt) {
        numeroPoliza.setText("");
    }

    private void numeroPolizaFocusLost(FocusEvent evt) {
         if (numeroPoliza.getText().isEmpty()){
        numeroPoliza.setText("Numero de Poliza");
        }
    }

    private void medicamentosMedicosFocusGained(FocusEvent evt) {
        medicamentosMedicos.setText("");
    }

    private void medicamentosMedicosFocusLost(FocusEvent evt) {
        medicamentosMedicos.setText("Medicamentos Actuales");
    }

    private void titularPolizaFocusGained(FocusEvent evt) {
        titularPoliza.setText("");
    }

    private void titularPolizaFocusLost(FocusEvent evt) {
         if (titularPoliza.getText().isEmpty()){
        titularPoliza.setText("Nombre Titular de la Poliza");
        }
    }

    private void alergiasFocusGained(FocusEvent evt) {
        alergias.setText("");
    }

    private void alergiasFocusLost(FocusEvent evt) {
         if (alergias.getText().isEmpty()){
        alergias.setText("Alergias");
        }
    }

    private void nombreCompletoFocusGained(FocusEvent evt) {
        nombreCompleto.setText("");
        
    }

    private void nombreCompletoFocusLost(FocusEvent evt) {
         if (nombreCompleto.getText().isEmpty()){
        nombreCompleto.setText("Nombre Completo");
        }
    }

    private void telefonoEmergenciaFocusGained(FocusEvent evt) {
        telefonoEmergencia.setText("");
    }

    private void telefonoEmergenciaFocusLost(FocusEvent evt) {
         if (telefonoEmergencia.getText().isEmpty()){
        telefonoEmergencia.setText("Telefono");
        }
    }

    private void relacionPacienteFocusGained(FocusEvent evt) {
        relacionPaciente.setText("");
    }

    private void relacionPacienteFocusLost(FocusEvent evt) {
         if (relacionPaciente.getText().isEmpty()){
        relacionPaciente.setText("Relacion con el Paciente");
        }
    }

    private JLabel Titulo;
    private Checkbox acepto;
    private JTextField alergias;
    private JTextField anioNacimiento;
    private JTextField antecentesMedicos;
    private JTextField apellido;
    private ButtonGroup buttonGroup1;
    private JRadioButton casado;
    private JLabel consentimientoPaciente;
    private JLabel contactoEmergia;
    private JTextField correo;
    private JComboBox<String> diaNacimiento;
    private JTextField direccion;
    private JLabel fecha;
    private JButton guardar;
    private JLabel informacionSobreSeguro;
    private JLabel informacionmedica;
    private JLabel jLabel3;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JTextPane jTextPane1;
    private JTextField medicamentosMedicos;
    private JComboBox<String> mesNacimiento;
    private JTextField motivoVisita;
    private JTextField nombre;
    private JTextField nombreCompleto;
    private JTextField nombreSeguro;
    private JLabel nombreYFirma;
    private JTextField numeroPoliza;
    private JTextField ocupacion;
    private JTextField relacionPaciente;
    private JComboBox<String> sexx;
    private JRadioButton soltero;
    private JTextField telefonoEmergencia;
    private JTextField telefonoPaciente;
    private JTextField titularPoliza;
    private JRadioButton viudo;
}

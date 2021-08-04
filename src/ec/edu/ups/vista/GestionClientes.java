/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.bo.PersonaBO;
import ec.edu.ups.entidad.Personas;
import ec.edu.ups.entidad.Usuarios;
import javax.swing.JOptionPane;

public final class GestionClientes extends javax.swing.JInternalFrame {
    private int id=0;
    private final PersonaBO  pClienteBO;
    private Usuarios user;

    public GestionClientes(PersonaBO  pClienteBO){
        initComponents();
        this.pClienteBO=pClienteBO;
        cargarPersonasTbl();
        user=null;
        permisos ();
    }
    
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rbID = new javax.swing.JRadioButton();
        rbCedula = new javax.swing.JRadioButton();
        rbDesac = new javax.swing.JRadioButton();
        btnDesactivarCliente = new javax.swing.JToggleButton();

        setClosable(true);
        setTitle("Administrar Clientes");
        setAlignmentX(500.0F);
        setAlignmentY(500.0F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 628));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel5.setToolTipText("");
        jPanel5.setName(""); // NOI18N

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        txtNombre.setMinimumSize(new java.awt.Dimension(7, 26));

        txtApellido.setMinimumSize(new java.awt.Dimension(7, 25));
        txtApellido.setPreferredSize(new java.awt.Dimension(7, 25));

        lblCedula.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCedula.setText("Cedula:");

        lblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        lblApellido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblApellido.setText("Apellido:");

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDireccion.setText("Direccion:");

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefono.setText("Telefono:");

        lblTelefono1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefono1.setText("Correo:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula)
                            .addComponent(lblNombre))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(lblApellido)
                            .addComponent(lblTelefono)
                            .addComponent(lblTelefono1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblNombre))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono1)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(0, 51, 255));
        btnGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("AGREGAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(0, 51, 255));
        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(0, 51, 255));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("MODIFICAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnListar.setBackground(new java.awt.Color(0, 51, 255));
        btnListar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 51, 255));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblClientes.setEditingColumn(8);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        buttonGroup1.add(rbID);
        rbID.setSelected(true);
        rbID.setBorder(new javax.swing.border.MatteBorder(null));
        rbID.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        rbID.setLabel("ID");
        rbID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIDActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCedula);
        rbCedula.setText("CEDULA");
        rbCedula.setBorder(new javax.swing.border.MatteBorder(null));
        rbCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        rbCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCedulaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbDesac);
        rbDesac.setText("DESACTIVOS");
        rbDesac.setBorder(new javax.swing.border.MatteBorder(null));
        rbDesac.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        rbDesac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDesacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbID)
                    .addComponent(rbCedula)
                    .addComponent(rbDesac))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbCedula)
                .addGap(18, 18, 18)
                .addComponent(rbDesac)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDesactivarCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDesactivarCliente.setText("ACTIVAR/DESACTIVAR CLIENTE");
        btnDesactivarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDesactivarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDesactivarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  public void permisos (){
      if(user!=null){
      if(user.getUsu_rol()=='G'){
    btnEliminar.setEnabled(false);
    
    }else{
    
    btnEliminar.setVisible(true);
    }
      }

  
  }
    public void limpiar() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        buttonGroup1.clearSelection();
        txtCedula.setEnabled(true);
    }

    public boolean validarCampos() {
        if (txtDireccion.getText().isEmpty()
                || txtTelefono.getText().isEmpty()
                || txtCedula.getText().isEmpty()
                || txtNombre.getText().isEmpty()
                || txtApellido.getText().isEmpty()||txtCorreo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CAMPOS VACIOS");
            return false;

        } else {
            return true;
        }

    }

    public void cargarPersonasTbl() {
        if(user!=null){
         pClienteBO.listarPersona(tblClientes);
        }else{
            System.out.println("TABLA VACIA:CLIENTES");
        }
       
        System.out.println(user);
        
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String mensaje="";
        Personas p = new Personas();        
        if(validarCampos()){
        //No se agrega el id por que se esta utilizando secuencias
        p.setPer_nombre(txtNombre.getText().trim());
        p.setPer_apellidos(txtApellido.getText().trim());
        p.setPer_cedula(txtCedula.getText().trim());
        p.setPer_correo(txtCorreo.getText().trim());
        p.setPer_direccion(txtDireccion.getText().trim());
        p.setPer_telefono(txtTelefono.getText().trim());
        p.setPer_rol('C');//seteamos el rol de la persona ya que es cliente
        p.setPer_estado(' ');//El estado por defecto es N de nuevo
        // mensaje = pBO.agregarPersona(p,u);
       mensaje= pClienteBO.agregarPersona(p, user);
       JOptionPane.showMessageDialog(this, mensaje);
       cargarPersonasTbl();
       }
        System.out.println(p+" "+user);
        System.out.println(mensaje);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

     String mensaje="";
     Personas p = new Personas(); 
    if(validarCampos()&& id!=0){
        p.setPer_codigo(id);
        p.setPer_nombre(txtNombre.getText().trim());
        p.setPer_apellidos(txtApellido.getText().trim());
        p.setPer_cedula(txtCedula.getText().trim());
        p.setPer_correo(txtCorreo.getText().trim());
        p.setPer_direccion(txtDireccion.getText().trim());
        p.setPer_telefono(txtTelefono.getText().trim());
        p.setPer_rol('C');//seteamos el rol de la persona ya que es cliente
        p.setPer_estado(' ');//El estado por defecto es nulo
        mensaje = pClienteBO.actualizarPersona(p, user);
        JOptionPane.showMessageDialog(this, mensaje);
        cargarPersonasTbl();
        System.out.println(p+" "+user);
        System.out.println(mensaje);
    }
    
      
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

      String mensaje="";
//        a=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar al cliente?","Confirmar eliminacion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
      if(validarCampos()||id!=0){
       int d = JOptionPane.showConfirmDialog(this, "ESTA SEGURO DE ELIMINAR AL CLIENTE CON CEDULA " + txtCedula.getText().trim());
        if (d == JOptionPane.YES_OPTION) {
            
            Personas pers= new Personas();
            pers=pClienteBO.buscarPersonaO(txtCedula.getText().trim());
        if(pers!=null){
          if (pers.getPer_rol()=='C' && pers.getPer_estado()==' '){
              mensaje = pClienteBO.eliminarPersona(id,user);
              JOptionPane.showMessageDialog(null, mensaje);
          }else{
              switch (pers.getPer_estado()) {
                  case 'A':
                      d = JOptionPane.showConfirmDialog(this, "EL CLIENTE TIENE UNA FACTURA ACTIVA:\n Desea desactivar al cliente?");
                      if (d == JOptionPane.YES_OPTION) {
                          pers.setPer_estado('D');
                          mensaje = pClienteBO.actualizarPersona(pers, user);
                          JOptionPane.showMessageDialog(this, mensaje);
                      }           break;
                  case 'D':
                      JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR A UN CLIENTE YA DESACTIVADO");
                      break;
                  case ' ':
                      JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR AL CLIENTE: \n El cliente no esta asociado a una factura");
                      break;
                  default:
                       JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR AL CLIENTE: \n No se pudo encontrar al cliente");
                      break;
              }
          }
        }
        
          
          cargarPersonasTbl();
        }  
      
      }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
    cargarPersonasTbl();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked

        int index = tblClientes.getSelectedRow();
        this.id = Integer.parseInt(""+ tblClientes.getValueAt(index, 0));
        String cedula = "" + tblClientes.getValueAt(index, 1);
        String nombre = "" + tblClientes.getValueAt(index, 2);
        String apellido = "" + tblClientes.getValueAt(index, 3);
        String direccion = "" + tblClientes.getValueAt(index, 4);
        String telefono = "" + tblClientes.getValueAt(index, 5);
        String correo = "" + tblClientes.getValueAt(index, 6);

        //double abono = Double.parseDouble("" + tblClientes.getValueAt(index, 8));
        txtCedula.setText(cedula);
        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtDireccion.setText(direccion);
        txtTelefono.setText(telefono);
        txtCorreo.setText(correo);
        
        txtCedula.setEnabled(false);
        
    }//GEN-LAST:event_tblClientesMouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
      
        cargarPersonasTbl();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         String p="";
            if(rbID.isSelected()){
            p="ID";
                System.out.println(p);
            }
            if (rbCedula.isSelected()){
            p="CEDULA";
             System.out.println(p);
            }
            
            if(rbDesac.isSelected()){
            p="DESACTIVOS";
             System.out.println(p);
            }
          Personas per= new Personas();
           String opcion = "";
           
            if(p.equals("ID")){
           opcion= JOptionPane.showInputDialog(null,"Ingrese ID");
           per.setPer_codigo(Integer.parseInt(opcion));
            }
            if(p.equals("CEDULA")){
            opcion= JOptionPane.showInputDialog(null,"Ingrese Cedula");
           per.setPer_cedula(opcion);
            }
            
            if(!"".equals(opcion)|| user!=null||!"".equals(p)){
            System.out.println(opcion+" "+p+" "+user);
            pClienteBO.buscarPersona(per, user, tblClientes, p);
            }else if (p.equals("DESACTIVOS")){
                pClienteBO.buscarPersona(per, user, tblClientes, p);
            }else{
             JOptionPane.showMessageDialog(this,"SELECCIONE TIPO DE BUSQUEDA");
            }
           
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void rbCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCedulaActionPerformed

    private void rbIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbIDActionPerformed

    private void rbDesacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDesacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbDesacActionPerformed

    private void btnDesactivarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarClienteActionPerformed
      String mensaje="";
        if(validarCampos()){
            Personas pers = new Personas();
            pers=pClienteBO.buscarPersonaO(txtCedula.getText().trim());
            if(pers!=null){
               switch (pers.getPer_estado()) {
              case 'A':
                  int d = JOptionPane.showConfirmDialog(this, "EL CLIENTE TIENE UNA FACTURA ACTIVA:\n Desea desactivar al cliente?");
                  if (d == JOptionPane.YES_OPTION) {
                      pers.setPer_estado('D');
                      mensaje = pClienteBO.actualizarPersona(pers, user);
                      JOptionPane.showMessageDialog(this, mensaje);
                  }      
                  break;
              case ' ':
                  JOptionPane.showMessageDialog(null, "NO SE PUEDE DESACTIVAR AL CLIENTE: \n El cliente no esta asociado a una factura");
                  break;
                  
              case 'D':
                d = JOptionPane.showConfirmDialog(this, "EL CLIENTE TIENE UNA FACTURA DESACTIVA:\n Desea activar al cliente?");
                  if (d == JOptionPane.YES_OPTION) {
                      pers.setPer_estado('A');
                      mensaje = pClienteBO.actualizarPersona(pers, user);
                      JOptionPane.showMessageDialog(this, mensaje);
                  }      
                  break;
              default:
                   JOptionPane.showMessageDialog(null, "NO SE PUEDE DESACTIVAR AL CLIENTE: \n No se pudo encontrar al cliente");
                  break;
          }
            
            }else{
            
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DESACTIVAR AL CLIENTE: \n No se pudo encontrar al cliente");
            }
       
       }
        
    }//GEN-LAST:event_btnDesactivarClienteActionPerformed

    public int getId() {
        return id;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JToggleButton btnDesactivarCliente;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JRadioButton rbCedula;
    private javax.swing.JRadioButton rbDesac;
    private javax.swing.JRadioButton rbID;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

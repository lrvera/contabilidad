package contabilidad.vista;

import contabilidad.vista.modelo.ModeloTablaLibroDiario;
import contabilidad.vista.modelo.ModeloTablaTransacciones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.com.dao.Conexion;
import org.com.dao.UtilidadDAO;
import org.com.modelo.conta.AsientoContable;
import org.com.modelo.conta.LibroDiario;
import org.com.modelo.conta.PlanDeCuentas;
import org.com.modelo.conta.TipoDocumento;
import org.com.modelo.conta.Transaccion;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author lrvera
 */
public class AgregarEditarAsiento extends javax.swing.JInternalFrame {

    EntityManager em;
    AsientoContable asiento;
    ModeloTablaTransacciones modeloTablaTransacciones = new ModeloTablaTransacciones();
    private final ModeloTablaLibroDiario modeloTablaLibroDiario;
//    Long idPlan = null;
    Date fecha;
    String secuencia;
    PlanDeCuentas cuenta = null;
    String cuentaS;
    LibroDiario libroDiario = LibroDiarioVista.diario;
    Transaccion transaccion;
    private List<Transaccion> transaccions = new ArrayList<>();

//    DateFormat dateFormat = DateFormat.getInstance();
    public AgregarEditarAsiento(String titulo, AsientoContable asientoContable, ModeloTablaLibroDiario mtld) {
        super(titulo);
        this.setAsiento(asientoContable);
        this.modeloTablaLibroDiario = mtld;
        initComponents();
        buscarPlanCuenta();
//        fijarDelModelo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDebe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHaber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblSecuencia = new javax.swing.JLabel();
        lblMensajes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTransacciones = new javax.swing.JTable();
        btnInsertar = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        btnQuitar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcbTipoDocumento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jLabel1.setText("Cuenta:");

        jLabel2.setText("Fecha:");

        jLabel3.setText("Identificador:");

        jLabel4.setText("Debe:");

        txtDebe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDebeKeyTyped(evt);
            }
        });

        jLabel5.setText("Haber:");

        txtHaber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHaberKeyTyped(evt);
            }
        });

        jLabel6.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblSecuencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSecuencia.setForeground(java.awt.Color.red);
        generarSecuencia();
        lblSecuencia.setText(secuencia);
        //lblSecuencia.setText(String.valueOf(asiento.getId()));

        lblMensajes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMensajes.setForeground(java.awt.Color.red);

        tablaTransacciones.setModel(modeloTablaTransacciones);
        tablaTransacciones.setAutoCreateRowSorter(true);
        tablaTransacciones.getColumn("CODIGO").setPreferredWidth(80);
        tablaTransacciones.getColumn("DESCRIPCION").setPreferredWidth(308);
        tablaTransacciones.getColumn("DEBE").setPreferredWidth(50);
        tablaTransacciones.getColumn("HABER").setPreferredWidth(50);
        tablaTransacciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTransaccionesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaTransaccionesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaTransacciones);

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contabilidad/vista/imagenes/addTable.png"))); // NOI18N
        btnInsertar.setToolTipText("AGREGAR A LA TABLA");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        jDateChooser2.setToolTipText("Seleccione la fecha");

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contabilidad/vista/imagenes/deleteTable.png"))); // NOI18N
        btnQuitar.setToolTipText("ELIMINAR DE LA TABLA");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo de Documento:");

        jcbTipoDocumento.removeAllItems();
        jcbTipoDocumento.addItem("-- SELECCIONE --");
        TipoDocumento [] tipoDoc = TipoDocumento.values();
        /*for(TipoDocumento tipo : tipoDoc){
            jcbTipoDocumento.addItem(tipo.toString());
        }*/
        jcbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(tipoDoc));

        jLabel8.setText("# documento:");

        jComboBox2.setEditable(true);
        jComboBox2.setToolTipText("SELECCIONE UNO");
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSecuencia)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(199, 199, 199)
                                        .addComponent(txtHaber, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnInsertar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumDoc)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblSecuencia)
                        .addComponent(jLabel2))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtHaber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnInsertar)
                    .addComponent(btnQuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnGuardar))
                    .addComponent(lblMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDebeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDebeKeyTyped
        char c = evt.getKeyChar();
        this.lblMensajes.setText(null);
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            this.lblMensajes.setText("El campo no debe contener texto");
        }
    }//GEN-LAST:event_txtDebeKeyTyped

    private void txtHaberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHaberKeyTyped
        char c = evt.getKeyChar();
        this.lblMensajes.setText(null);
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            this.lblMensajes.setText("El campo no debe contener texto");
        }
    }//GEN-LAST:event_txtHaberKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (jDateChooser2.getDate() != null) {
            if (!txtDescripcion.getText().isEmpty()) {
                fecha = jDateChooser2.getDate();
//                SimpleDateFormat formato = new SimpleDateFormat("dd/MMM/yyyy");
                fijarAlModelo();
                System.out.println("ceunta " + cuenta);
                guardar();
            } else {
                JOptionPane.showMessageDialog(this, "POR FAVOR, INGRESE UNA DESCRIPCION PARA EL ASIENTO");
            }
        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE UNA FECHA PRIMERO");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        lblMensajes.setText(null);
        if (cuenta != null) {
            transaccion = new Transaccion();
            fijarMemoriaTabla();
            modeloTablaTransacciones.addTransaccion(transaccion);
        } else {
            lblMensajes.setText("Seleccione una cuenta primero");
        }
        limpiar();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void tablaTransaccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTransaccionesMouseClicked

    }//GEN-LAST:event_tablaTransaccionesMouseClicked

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int fila = tablaTransacciones.getSelectedRow();
        modeloTablaTransacciones.deleteRow(fila);
        transaccions.remove(modeloTablaTransacciones.getTransaccionSeleccionada());
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void tablaTransaccionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTransaccionesMouseReleased
        Transaccion tr = modeloTablaTransacciones.getTransaccionSeleccionada();
        txtDebe.setText(String.valueOf(tr.getDebe()));
        txtHaber.setText(String.valueOf(tr.getHaber()));
//        lblDescripcionCuenta.setText(tr.getCuenta().getDescripcionCuenta());
    }//GEN-LAST:event_tablaTransaccionesMouseReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        cuentaS = jComboBox2.getSelectedItem().toString();
        buscarCuenta(cuentaS);
    }//GEN-LAST:event_jComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbTipoDocumento;
    private javax.swing.JLabel lblMensajes;
    private javax.swing.JLabel lblSecuencia;
    private javax.swing.JTable tablaTransacciones;
    private javax.swing.JTextField txtDebe;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtHaber;
    private javax.swing.JTextField txtNumDoc;
    // End of variables declaration//GEN-END:variables

    public void generarSecuencia() {
        int sec = 0;
        Calendar anio = Calendar.getInstance();
        Connection cn = Conexion.getConexion();
        String sql = "SELECT id FROM AsientoContable";
        try {
            Statement ps = cn.prepareStatement(sql);
            ps = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery(sql);
            if (rs != null && rs.last()) {
                sec = Integer.parseInt((String) rs.getString(1));
                sec += 1;
            } else {
                sec += 1;
            }
            secuencia = String.valueOf(anio.get(Calendar.YEAR) + "-" + sec);
            System.out.println("secuencia " + secuencia);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return sec;
    }

    public void guardar() {
        try {
            em = UtilidadDAO.getEntityManager();
            em.getTransaction().begin();
            if (asiento.getId() == null || asiento.getId() == 0) {
//                this.fijarMemoriaTabla();
                System.out.println(asiento.getId());
                for (int i = 0; i < transaccions.size(); i++) {
                    em.persist(transaccions.get(i));
                }
                em.persist(asiento);
                this.modeloTablaLibroDiario.addAsientoContable(asiento);

            } else {
                System.out.println("tans en bd " + asiento.getTransacciones().size());
                System.out.println("tans en mem " + transaccions.size());
                for (int i = 0; i < transaccions.size(); i++) {
                    if (asiento.getTransacciones().contains(transaccions.get(i))) {
                        em.merge(transaccions.get(i));
                    } else {
                        System.out.println("else eliminar");
                        em.remove(transaccions.get(i));
                    }
                }
                em.merge(asiento);
                this.modeloTablaLibroDiario.fireTableDataChanged();
            }
            em.getTransaction().commit();
            this.dispose();
        } catch (Exception e) {
            if (em == null) {
                JOptionPane.showMessageDialog(this, "Error al guardar, imposible crear Unidad de persistencia");
            } else {
                JOptionPane.showMessageDialog(this, "Error en la transaccion guardar");
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void fijarMemoriaTabla() {
        transaccion.setDebe(!txtDebe.getText().isEmpty() ? Double.valueOf(txtDebe.getText()) : 0.0);
        transaccion.setHaber(!txtHaber.getText().isEmpty() ? Double.valueOf(txtHaber.getText()) : 0.0);
        transaccion.setAsientoContable(asiento);
        transaccion.setCuenta(cuenta);
        transaccions.add(transaccion);
    }

    public void fijarAlModelo() {
        asiento.setTransacciones(transaccions);
        asiento.setDescripcion(txtDescripcion.getText());
        asiento.setDiario(libroDiario);
        asiento.setFecha(fecha);
        asiento.setSecuencia(secuencia);
        asiento.setTipoDocumento((TipoDocumento) jcbTipoDocumento.getSelectedItem());
        asiento.setNumeroDoc(txtNumDoc.getText());
    }

    public void fijarDelModelo() {
        if (asiento != null) {
            this.jDateChooser2.setDate(asiento.getFecha());
            this.lblSecuencia.setText(asiento.getSecuencia());
            this.txtDescripcion.setText(asiento.getDescripcion());
//        this.txtCodigo.setEnabled((asiento.getId()==null));
            this.modeloTablaTransacciones.setTransacciones(asiento.getTransacciones());
        }
    }

    public void buscarPlanCuenta() {
        try {
            em = UtilidadDAO.getEntityManager();
            String querys = "SELECT p FROM PlanDeCuentas p WHERE p.nivel = 5";
            Query q = em.createQuery(querys);
            List<PlanDeCuentas> planes = q.getResultList();
            AutoCompleteDecorator.decorate(jComboBox2);
            if (!planes.isEmpty()) {
                jComboBox2.removeAllItems();
                for (int i = 0; i < planes.size(); i++) {
                    if (planes.get(i) != null) {
                        cuenta = planes.get(i);
                        jComboBox2.addItem(planes.get(i).getDescripcionCuenta());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PlanDeCuentas buscarCuenta(String cuentaS) {
        try {
            em = UtilidadDAO.getEntityManager();
            String querys = "SELECT p FROM PlanDeCuentas p WHERE p.descripcionCuenta = :cuenta";
            Query q = em.createQuery(querys);
            q.setParameter("cuenta", cuentaS);
            List<PlanDeCuentas> planCuentas = q.getResultList();
            if (!planCuentas.isEmpty()) {
                cuenta = planCuentas.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuenta;
    }

    public void limpiar() {
//        txtCodigo.setText(null);
        txtDebe.setText(null);
        txtHaber.setText(null);
//        lblDescripcionCuenta.setText(null);
    }

    public AsientoContable getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoContable asiento) {
        this.asiento = asiento;
    }
}

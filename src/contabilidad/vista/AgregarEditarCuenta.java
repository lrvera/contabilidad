package contabilidad.vista;

import contabilidad.vista.modelo.ModeloTablaPlanCuentas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.com.dao.UtilidadDAO;
import org.com.modelo.conta.PlanDeCuentas;

/**
 *
 * @author lrvera
 */
public class AgregarEditarCuenta extends javax.swing.JInternalFrame {

    private PlanDeCuentas cuenta, cuentaPadre;
    private final ModeloTablaPlanCuentas tablaPlanCuentas;
    EntityManager em = null;

    /**
     * Creates new form AgregarEditarCuenta
     */
    public AgregarEditarCuenta(String titulo, boolean modal, ModeloTablaPlanCuentas tablaPlanCuentas, PlanDeCuentas cuenta) {
        super(titulo, modal);
        this.setCuenta(cuenta);
        this.tablaPlanCuentas = tablaPlanCuentas;
        initComponents();
        this.fijarDelModelo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtNivel = new javax.swing.JTextField();
        txtPadre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblMensajes = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Codigo de la cuenta:");

        jLabel2.setText("Descripcion de la cuenta:");

        jLabel3.setText("Nivel:");

        jLabel4.setText("Padre:");

        txtNivel.setEditable(false);

        txtPadre.setEditable(false);

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

        lblMensajes.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblMensajes.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo)
                            .addComponent(txtNivel)
                            .addComponent(txtDescripcion)
                            .addComponent(txtPadre)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblMensajes, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.lblMensajes.setText(""); // se pone en blanco el label de mensajes
        String codig = txtCodigo.getText(); //obtengo el texto del campo codifo
        int tamanio = codig.length(); // lçsaco la longitud de la cadana del campo codigo
        int nivel = 1; // variable que sirve para incrementar el nivel de la cuenta
        char car; // se utiliza para verificar que la ultima poscicion no sea .
        if (!codig.isEmpty()) { // verifica que exista texto en el campo codigo
            if (!txtDescripcion.getText().isEmpty()) { // verifica que exista texto en el campo descripcion
                car = codig.charAt(tamanio - 1); // saca el ultimo caracter ingresado en el campo texto
                if (car != '.') { // verifica que el ultimo caracter no sea .
                    String idPadre = identificarPadre(codig);
                    buscarPadre(idPadre);
                    for (int i = 0; i < codig.length(); i++) { // recorre la cadena y saca las posiciones
                        txtNivel.setText(String.valueOf(nivel));// se coloca el nivel de la cuenta
                        if (codig.charAt(i) == '.') { // verifica que la poscion sea . 
                            nivel += 1; // si es . se incrementa el nivel en 1
                        }
                    }
                    System.out.println("padre... " + cuentaPadre);
                    if (cuentaPadre != null) {
                        cuenta.setPadre(cuentaPadre);
                        txtPadre.setText(cuentaPadre.getDescripcionCuenta());
                        guardar();
                    } else if (cuentaPadre == null && !existePunto(codig)) {
                        cuenta.setPadre(null);
                        guardar();
                    } else {
                        lblMensajes.setText("No se puede asociar a una cuenta Padre");
                    }
                } else {
                    this.lblMensajes.setText("Por favor verifique el código ingresado");
                }
            } else {
                this.lblMensajes.setText("Ingrese la descripción de la cuenta.");
            }
        } else {
            lblMensajes.setText("Ingrese el código de la cuenta.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblMensajes;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtPadre;
    // End of variables declaration//GEN-END:variables

    public void guardar() {
        try {
            em = UtilidadDAO.getEntityManager();
            em.getTransaction().begin();
            if (cuenta.getId() == null || cuenta.getId() == 0) {
                this.fijarAlModelo();
                System.out.println(cuenta.getId());
                if (!verificarDuplicados()) {
                    em.persist(cuenta);
                    this.tablaPlanCuentas.addPlanCuenta(cuenta);
//                    JOptionPane.showMessageDialog(this, "Cuenta creada correctamente.");
                }
//            } if (!verificarDuplicados()) {
//                System.out.println("verifica duplicados");
//                this.fijarAlModelo();
////                    em.merge(cuenta);
//                this.tablaPlanCuentas.fireTableDataChanged();
            } else if (!txtDescripcion.getText().equals(cuenta.getDescripcionCuenta())) {
                System.out.println("cuenta "+cuenta);
                System.out.println("txt "+txtCodigo.getText());
                System.out.println("cta "+cuenta.getCodigoCuenta());
                if (txtCodigo.getText().equals(cuenta.getCodigoCuenta())) {
                    System.out.println("verifica duplicados y descripcion");
                    System.out.println(txtDescripcion.getText());
                    System.out.println(cuenta.getDescripcionCuenta());
                    this.fijarAlModelo();
                    em.merge(cuenta);
                    this.tablaPlanCuentas.fireTableDataChanged();
                }
            }
            em.getTransaction().commit();
            this.dispose();
//limpiar();
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

    public boolean verificarDuplicados() {
        boolean existe = false;
        for (int i = 0; i < tablaPlanCuentas.getRowCount(); i++) {
            if (tablaPlanCuentas.getValueAt(i, 0).equals(this.txtCodigo.getText())) {
                JOptionPane.showMessageDialog(this, "YA EXISTE LA CUENTA");
                existe = true;
            }
        }
        return existe;
    }

    public boolean verificaDatos() {
        boolean exist = false;
        PlanDeCuentas ct = tablaPlanCuentas.getRow();
        System.out.println("en bd-- " + ct.getCodigoCuenta());
        System.out.println("en mem-- " + txtCodigo.getText());
        if (txtCodigo.getText().equals(ct.getCodigoCuenta())) {
//            JOptionPane.showMessageDialog(this, "YA EXISTE LA CUENTA");
            exist = true;
        }
        return exist;
    }

    public void buscarPadre(String IdPadre) {
        try {
            em = UtilidadDAO.getEntityManager();
            Query q = em.createNamedQuery("PlanDeCuentas.findParent");
            q.setParameter("codPadre", IdPadre);
            List<PlanDeCuentas> cts = q.getResultList();
            cuentaPadre = ((cts != null && !cts.isEmpty()) ? cts.get(0) : null);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("mensaje:  " + e.getMessage());
            System.out.println("causa:  " + e.getCause());
            System.out.println("trace:  " + e.getStackTrace());
        }
    }

    public void fijarAlModelo() {
        cuenta.setCodigoCuenta(this.txtCodigo.getText());
        cuenta.setDescripcionCuenta(this.txtDescripcion.getText());
        cuenta.setNivel(Integer.parseInt(this.txtNivel.getText()));

    }

    public void fijarDelModelo() {
        this.txtCodigo.setText(cuenta.getCodigoCuenta());
        this.txtDescripcion.setText(cuenta.getDescripcionCuenta());
        this.txtNivel.setText(String.valueOf(cuenta.getNivel()));
        if (cuenta.getPadre() != null) {
            this.txtPadre.setText(cuenta.getPadre().getDescripcionCuenta());
        }
    }
    
    /**
     * Metodo que realiza un recorido al dato ingresado en el campo Codigo, con
     * lo cual se va a determinar el padre de la cuenta agregada
     *
     * @param cadena la cadena a recorrer
     * @return el id del padre de la cuenta
     */
    public String identificarPadre(String cadena) {
        String idValor = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != '.') {
                idValor += cadena.charAt(i);
            } else {
                break;
            }
        }
        return idValor;
    }

    public boolean existePunto(String cadena) {
        boolean valor = false;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '.') {
                valor = true;
                System.out.println("existe punto");
                break;
            } else {
                valor = false;
                System.out.println("no existe punto");
            }
        }
        System.out.println(valor);
        return valor;
    }

    public PlanDeCuentas getCuenta() {
        return cuenta;
    }

    public void setCuenta(PlanDeCuentas cuenta) {
        this.cuenta = cuenta;
    }

    public PlanDeCuentas getCuentaPadre() {
        return cuentaPadre;
    }

    public void setCuentaPadre(PlanDeCuentas cuentaPadre) {
        this.cuentaPadre = cuentaPadre;
    }

}

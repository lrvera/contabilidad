/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad.vista;

import static contabilidad.vista.ContaPrincipal.jDesktopPane1;
import contabilidad.vista.modelo.ModeloTablaPlanCuentas;
import java.awt.Dimension;
import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.com.dao.UtilidadDAO;
import org.com.modelo.conta.PlanDeCuentas;

/**
 *
 * @author lrvera
 */
public class PlanCuentas extends javax.swing.JInternalFrame {

    private PlanDeCuentas cuenta;
    ModeloTablaPlanCuentas modeloTablaPlanCuentas = new ModeloTablaPlanCuentas();
    EntityManager em = null;
    Connection cn;

    /**
     * Creates new form AgregarUsuario
     */
    public PlanCuentas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnEditarCuenta = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Plan de cuentas");
        setToolTipText("Plan de cuentas");
        setAutoscrolls(true);

        btnAgregarC.setText("Agregar Cuenta");
        btnAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCActionPerformed(evt);
            }
        });

        jTable1.setModel(modeloTablaPlanCuentas);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        //modeloTablaPlanCuentas.addPlanCuenta(cuenta);
        cargarTabla();
        jScrollPane1.setViewportView(jTable1);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditarCuenta.setText("Editar Cuenta");
        btnEditarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCuentaActionPerformed(evt);
            }
        });

        btnEliminarCuenta.setText("Eliminar Cuenta");
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarC)
                    .addComponent(btnCancelar)
                    .addComponent(btnEditarCuenta)
                    .addComponent(btnEliminarCuenta)))
        );

        setBounds(0, 0, 740, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCActionPerformed
        PlanDeCuentas cuenta1 = new PlanDeCuentas();
        ModeloTablaPlanCuentas modelo = (ModeloTablaPlanCuentas) this.jTable1.getModel();
        AgregarEditarCuenta addCuenta = new AgregarEditarCuenta("Agregar nuevo Plan de Cuentas", true, modelo, cuenta1);
        ContaPrincipal.jDesktopPane1.add(addCuenta);
        addCuenta.toFront();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = addCuenta.getSize();
        addCuenta.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        addCuenta.show();
    }//GEN-LAST:event_btnAgregarCActionPerformed

    private void btnEditarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCuentaActionPerformed
        ModeloTablaPlanCuentas modelo = (ModeloTablaPlanCuentas) this.jTable1.getModel();
        PlanDeCuentas cuentaSeleccionada = modelo.getCuentaSeleccionada();
        AgregarEditarCuenta editarCuenta = new AgregarEditarCuenta("Editar Cuenta", true, modelo, cuentaSeleccionada);
        ContaPrincipal.jDesktopPane1.add(editarCuenta);
        editarCuenta.toFront();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = editarCuenta.getSize();
        editarCuenta.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        editarCuenta.setVisible(true);
    }//GEN-LAST:event_btnEditarCuentaActionPerformed

    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed
        ModeloTablaPlanCuentas modelo = (ModeloTablaPlanCuentas) this.jTable1.getModel();
        PlanDeCuentas cuentaSeleccionada = modelo.getCuentaSeleccionada();
        if (cuentaSeleccionada.getPadre() == null) {
            int op = JOptionPane.showConfirmDialog(this, "Va a eliminar una cuenta asociada, esta seguro de seguir?", "MENSAJE DE CONFIRMACION", WIDTH);
            if (op == 0) {
                Eliminar(cuentaSeleccionada);
                modelo.fireTableDataChanged();
            }
        } else {
            Eliminar(cuentaSeleccionada);
        }
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarC;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarCuenta;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void cargarTabla() {
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getColumn("CODIGO").setPreferredWidth(100);
        jTable1.getColumn("DESCRIPCION").setPreferredWidth(480);
        jTable1.getColumn("NIVEL").setPreferredWidth(60);
        jTable1.getColumn("PADRE").setPreferredWidth(70);
        ModeloTablaPlanCuentas model = (ModeloTablaPlanCuentas) this.jTable1.getModel();
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        jTable1.setRowSorter(sorter);
        try {
            em = UtilidadDAO.getEntityManager();
            Query q = em.createNamedQuery("PlanCuentas.findAll");
            List<PlanDeCuentas> cuentas = q.getResultList();
            for (int i = 0; i < cuentas.size(); i++) {
                cuenta = cuentas.get(i);
                modeloTablaPlanCuentas.addPlanCuenta(cuenta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jTable1.getRowSorter().toggleSortOrder(0);
    }

    public void Eliminar(PlanDeCuentas cuenta) {
        int op = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la cuenta?", "MENSAJE DE CONFIRMACION", WIDTH);
        if (op == 0) {
            try {
                em = UtilidadDAO.getEntityManager();
                em.getTransaction().begin();
                int x = jTable1.getSelectedRow();
                ModeloTablaPlanCuentas modelo = (ModeloTablaPlanCuentas) this.jTable1.getModel();
                modelo.deleteRow(x);
                PlanDeCuentas cta = em.getReference(PlanDeCuentas.class, cuenta.getId());
                em.remove(cta);
//                JOptionPane.showMessageDialog(this, "CUENTA ELIMINADA");
                em.getTransaction().commit();
                modelo.fireTableDataChanged();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("mensaje--- " + e.getMessage());
                System.out.println("causa--- " + e.getCause());
                System.out.println("localizado--- " + e.getLocalizedMessage());
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
    }
}

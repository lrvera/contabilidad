package contabilidad.vista.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.modelo.conta.PlanDeCuentas;

/**
 *
 * @author lrvera
 */
public class ModeloTablaPlanCuentas extends AbstractTableModel{

//    ATRIBUTOS
    private static final String DESCRIPCION = "DESCRIPCION";
    private static final String CODIGO = "CODIGO";
    private static final String NIVEL = "NIVEL";
    private static final String PADRE = "PADRE";
    private String titulos[] = {CODIGO, DESCRIPCION, NIVEL, PADRE};
    private List<PlanDeCuentas> cuentas;
    private PlanDeCuentas cuentaSeleccionada;

//    CONSTRUCTORES
    public ModeloTablaPlanCuentas() {
        this.cuentas = new ArrayList<>();
        this.cuentaSeleccionada = new PlanDeCuentas();
    }

    public ModeloTablaPlanCuentas(List<PlanDeCuentas> cuentas) {
        this.cuentas = cuentas;
        if (this.cuentas != null && !this.cuentas.isEmpty()) {
            cuentaSeleccionada = cuentas.get(0);
        } else {
            cuentaSeleccionada = new PlanDeCuentas();
        }
    }

    public ModeloTablaPlanCuentas(int numFilas) {
        this.cuentas = new ArrayList<>(numFilas);
        cuentaSeleccionada = new PlanDeCuentas();
    }

//    GETTERS Y SETTERS
    public PlanDeCuentas getCuentaSeleccionada() {
        return cuentaSeleccionada;
    }

    public void setCuentaSeleccionada(PlanDeCuentas cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
    }

    public String[] getTitulos() {
        return titulos;
    }

    public void setTitulos(String[] titulos) {
        this.titulos = titulos;
    }

    public List<PlanDeCuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<PlanDeCuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public PlanDeCuentas getRow() {
        PlanDeCuentas cta=null;
        for (int i = 0; i < cuentas.size(); i++) {
            cta = this.cuentas.get(i);
        }
        return cta;
    }

    public void deleteRow(int row) {
        this.cuentas.remove(row);
        this.fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        if (this.cuentas != null) {
            return this.cuentas.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        if (this.titulos != null) {
            return this.titulos.length;
        } else {
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PlanDeCuentas cuenta1 = this.cuentas.get(rowIndex);
        this.cuentaSeleccionada = cuenta1;
        String nombreColumna = this.titulos[columnIndex];
        if (nombreColumna.equals(CODIGO)) {
            return cuenta1.getCodigoCuenta();
        } else if (nombreColumna.equals(DESCRIPCION)) {
            return cuenta1.getDescripcionCuenta();
        } else if (nombreColumna.equals(PADRE)) {
            return (cuenta1.getPadre()!=null ? cuenta1.getPadre().getDescripcionCuenta(): null);
        } else if (nombreColumna.equals(NIVEL)) {
            return cuenta1.getNivel();
        } else {
            return null;
        }
    }

    @Override
    public String getColumnName(int index) {
        return titulos[index];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        PlanDeCuentas cuenta1 = this.cuentas.get(rowIndex);
        String nombreColumna = this.titulos[columnIndex];
        if (nombreColumna.equals(CODIGO)) {
            cuenta1.setCodigoCuenta((String) aValue);
        } else if (nombreColumna.equals(DESCRIPCION)) {
            cuenta1.setDescripcionCuenta((String) aValue);
        } else if (nombreColumna.equals(PADRE)) {
            cuenta1.setPadre((PlanDeCuentas) aValue);
        } else if (nombreColumna.equals(NIVEL)) {
            cuenta1.setNivel((int) aValue);
        }
        
        //PARA INDICAR QUE LA TABLA A CAMBIADO
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void addPlanCuenta(PlanDeCuentas cuenta) {
        if (cuenta != null && !cuentas.contains(cuenta)) {
            cuentas.add(cuenta);
            fireTableDataChanged();
        }
    }
    
}

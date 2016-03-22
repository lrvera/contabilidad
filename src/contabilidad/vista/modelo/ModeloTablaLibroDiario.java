package contabilidad.vista.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.modelo.conta.AsientoContable;
import org.com.modelo.conta.TipoDocumento;

/**
 *
 * @author lrvera
 */
public class ModeloTablaLibroDiario extends AbstractTableModel {

    private static final String FECHA = "FECHA";
    private static final String DESCRIPCION = "DESCRIPCION";
    private static final String SECUENCIA = "SECUENCIA";
    private static final String TIPO_DOCUMENTO = "TIPO";
    private String titulos[] = {FECHA, SECUENCIA, DESCRIPCION, TIPO_DOCUMENTO};
    private List<AsientoContable> asientos;
    private AsientoContable asientoSeleccionado;
    

    public ModeloTablaLibroDiario() {
        this.asientos = new ArrayList<>();
        this.asientoSeleccionado = new AsientoContable();
    }

    public ModeloTablaLibroDiario(List<AsientoContable> asientos) {
        this.asientos = asientos;
        if (this.asientos != null && !this.asientos.isEmpty()) {
            asientoSeleccionado = this.asientos.get(0);
        } else {
            asientoSeleccionado = new AsientoContable();
        }
    }

    public ModeloTablaLibroDiario(int numFilas) {
        this.asientos = new ArrayList<>(numFilas);
        this.asientoSeleccionado = new AsientoContable();
    }

    public String[] getTitulos() {
        return titulos;
    }

    public void setTitulos(String[] titulos) {
        this.titulos = titulos;
    }

    public AsientoContable getRow() {
        AsientoContable asiento = null;
        for (int i = 0; i < asientos.size(); i++) {
            asiento = asientos.get(i);
        }
        return asiento;
    }

    public List<AsientoContable> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<AsientoContable> asientos) {
        this.asientos = asientos;
    }

    public AsientoContable getAsientoSeleccionado() {
        return asientoSeleccionado;
    }

    public void setAsientoSeleccionado(AsientoContable asientoSeleccionado) {
        this.asientoSeleccionado = asientoSeleccionado;
    }
    
    public void deleteRow(int row) {
        this.asientos.remove(row);
        this.fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        if (this.asientos != null) {
            return this.asientos.size();
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
        AsientoContable asiento = this.asientos.get(rowIndex);
        this.asientoSeleccionado = asiento;
        String nombreColumna = this.titulos[columnIndex];
        if (nombreColumna.equals(FECHA)) {
            return asiento.getFecha();
        } else if (nombreColumna.equals(SECUENCIA)) {
            return asiento.getSecuencia();
        } else if (nombreColumna.equals(DESCRIPCION)) {
            return asiento.getDescripcion();
        } else if (nombreColumna.equals(TIPO_DOCUMENTO)) {
            return asiento.getTipoDocumento();
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
        AsientoContable asiento = this.asientos.get(rowIndex);
        String nombreColumna = this.titulos[columnIndex];
        if (nombreColumna.equals(FECHA)) {
            asiento.setFecha((Date) aValue);
        } else if (nombreColumna.equals(SECUENCIA)) {
            asiento.setSecuencia((String)aValue);
        } else if (nombreColumna.equals(DESCRIPCION)) {
            asiento.setDescripcion((String) aValue);
        } else if (nombreColumna.equals(TIPO_DOCUMENTO)) {
            asiento.setTipoDocumento((TipoDocumento)aValue);
        }
        //PARA INDICAR QUE LA TABLA A CAMBIADO
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void addAsientoContable(AsientoContable asientoContable) {
        if (asientoContable != null && !asientos.contains(asientoContable)) {
            asientos.add(asientoContable);
            fireTableDataChanged();
        }
    }

}

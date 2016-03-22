package contabilidad.vista.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.com.modelo.conta.Transaccion;

/**
 *
 * @author lrvera
 */
public class ModeloTablaTransacciones extends AbstractTableModel {

//    ATRIBUTOS
    private static final String CODIGO = "CODIGO";
    private static final String DESCRIPCION = "DESCRIPCION";
    private static final String DEBE = "DEBE";
    private static final String HABER = "HABER";
    private String titulos[] = {CODIGO, DESCRIPCION, DEBE, HABER};
    private List<Transaccion> transacciones;
    private Transaccion transaccionSeleccionada;

//    CONSTRUCTORES
    public ModeloTablaTransacciones() {
        this.transacciones = new ArrayList<>();
        this.transaccionSeleccionada = new Transaccion();
    }

    public ModeloTablaTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
        if (this.transacciones != null && !this.transacciones.isEmpty()) {
            transaccionSeleccionada = transacciones.get(0);
        } else {
            transaccionSeleccionada = new Transaccion();
        }
    }

    public ModeloTablaTransacciones(int numFilas) {
        this.transacciones = new ArrayList<>(numFilas);
        transaccionSeleccionada = new Transaccion();
    }

//    GETTERS Y SETTERS

    public String[] getTitulos() {
        return titulos;
    }

    public void setTitulos(String[] titulos) {
        this.titulos = titulos;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public Transaccion getTransaccionSeleccionada() {
        return transaccionSeleccionada;
    }

    public void setTransaccionSeleccionada(Transaccion transaccionSeleccionada) {
        this.transaccionSeleccionada = transaccionSeleccionada;
    }

    public Transaccion getRow() {
        Transaccion trans=null;
        for (int i = 0; i < transacciones.size(); i++) {
            trans = this.transacciones.get(i);
        }
        return trans;
    }

    public void deleteRow(int row) {
        this.transacciones.remove(row);
        this.fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        if (this.transacciones != null) {
            return this.transacciones.size();
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
        Transaccion transaccion = this.transacciones.get(rowIndex);
        this.transaccionSeleccionada = transaccion;
        String nombreColumna = this.titulos[columnIndex];
        if (nombreColumna.equals(CODIGO)) {
            return transaccion.getCuenta().getCodigoCuenta();
        } else if (nombreColumna.equals(DESCRIPCION)) {
            return transaccion.getCuenta().getDescripcionCuenta();
        } else if (nombreColumna.equals(HABER)) {
            return transaccion.getHaber();
        } else if (nombreColumna.equals(DEBE)) {
            return transaccion.getDebe();
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
        Transaccion transaccion = this.transacciones.get(rowIndex);
        String nombreColumna = this.titulos[columnIndex];
        if (nombreColumna.equals(CODIGO)) {
            transaccion.getCuenta().setCodigoCuenta((String)aValue);
        } else if (nombreColumna.equals(DESCRIPCION)) {
            transaccion.getCuenta().setDescripcionCuenta((String) aValue);
        } else if (nombreColumna.equals(HABER)) {
            transaccion.setHaber((double) aValue);
        } else if (nombreColumna.equals(DEBE)) {
            transaccion.setDebe((double) aValue);
        }
        //PARA INDICAR QUE LA TABLA A CAMBIADO
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void addTransaccion(Transaccion transaccion) {
        if (transaccion != null) {
            transacciones.add(transaccion);
            fireTableDataChanged();
        }
    }

}

package contabilidad.vista.modelo;

/**
 *
 * @author lrvera
 */
public class ModeloTablaAsientoContable /*extends AbstractTableModel */{

    /*private static final String CODIGO = "CODIGO";
    private static final String DESCRIPCION = "DESCRIPCION";
    private static final String DEBE = "DEBE";
    private static final String HABER = "HABER";
    private String titulos[] = {CODIGO, DESCRIPCION, DEBE, HABER};
    private List<AsientoContable> asientos;
    private AsientoContable asientoSeleccionado;

    public ModeloTablaAsientoContable() {
        this.asientos = new ArrayList<>();
        this.asientoSeleccionado = new AsientoContable();
    }

    public ModeloTablaAsientoContable(List<AsientoContable> asientos) {
        this.asientos = asientos;
        if (this.asientos != null && !this.asientos.isEmpty()) {
            asientoSeleccionado = asientos.get(0);
        } else {
            asientoSeleccionado = new AsientoContable();
        }
    }

    public ModeloTablaAsientoContable(int numFilas) {
        this.asientos = new ArrayList<>(numFilas);
        this.asientoSeleccionado = new AsientoContable();
    }

    public String[] getTitulos() {
        return titulos;
    }

    public void setTitulos(String[] titulos) {
        this.titulos = titulos;
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

    public AsientoContable getRow() {
        AsientoContable as = null;
        for (int i = 0; i < asientos.size(); i++) {
            as = asientos.get(i);
        }
        return as;
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
        if (nombreColumna.equals(CODIGO)) {
            return asiento.getCuenta().getCodigoCuenta();
        } else if (nombreColumna.equals(DESCRIPCION)) {
            return asiento.getCuenta().getDescripcionCuenta();
        } else if (nombreColumna.equals(DEBE)) {
            return asiento.getDebe();
        } else if (nombreColumna.equals(HABER)) {
            return asiento.getHaber();
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
        if (nombreColumna.equals(CODIGO)) {
            asiento.getCuenta().setCodigoCuenta((String) aValue);
        } else if (nombreColumna.equals(DESCRIPCION)) {
            asiento.getCuenta().setDescripcionCuenta((String) aValue);
        } else if (nombreColumna.equals(DEBE)) {
            asiento.setDebe((Long) aValue);
        } else if (nombreColumna.equals(HABER)) {
            asiento.setHaber((Long) aValue);
        }
        //PARA INDICAR QUE LA TABLA A CAMBIADO
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void addAsiento(AsientoContable ac) {
        if (ac != null && !asientos.contains(ac)) {
            asientos.add(ac);
            fireTableDataChanged();
        }
    }*/

}

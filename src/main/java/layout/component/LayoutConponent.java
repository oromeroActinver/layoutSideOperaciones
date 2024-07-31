package layout.component;

import java.util.Date;

public class LayoutConponent {
	
	private String idOperacion;
	private Date periodo;
    private Date fecha;
    private String producto;
    private String divisaMoneda;
    private Double monto;
    private String institucion;
    
	public String getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}
	public Date getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDivisaMoneda() {
		return divisaMoneda;
	}
	public void setDivisaMoneda(String divisaMoneda) {
		this.divisaMoneda = divisaMoneda;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
    
	public LayoutConponent(String idOperacion, Date periodo, Date fecha, String producto, String divisaMoneda, Double monto, String institucion) {
        this.idOperacion = idOperacion;
        this.periodo = periodo;
        this.fecha = fecha;
        this.producto = producto;
        this.divisaMoneda = divisaMoneda;
        this.monto = monto;
        this.institucion = institucion;
    }

}

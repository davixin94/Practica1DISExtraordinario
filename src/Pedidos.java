import java.util.ArrayList;

public class Pedidos {
	
	private ArrayList<Producto> productos;
	private int cantidad;
	private String calle;
	private int numero;
	private int cp;
	private String poblacion;
	private String pais;
	private String destinatario;
	private String fechaEntrega;
	
	
	public Pedidos(ArrayList<Producto> productos, int cantidad, String calle, int numero, int cp, String poblacion,
			String pais, String destinatario, String fechaEntrega) {
		super();
		this.productos = productos;
		this.cantidad = cantidad;
		this.calle = calle;
		this.numero = numero;
		this.cp = cp;
		this.poblacion = poblacion;
		this.pais = pais;
		this.destinatario = destinatario;
		this.fechaEntrega = fechaEntrega;
	}

	public Pedidos() {
		
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}



	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public int getCp() {
		return cp;
	}



	public void setCp(int cp) {
		this.cp = cp;
	}



	public String getPoblacion() {
		return poblacion;
	}



	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getDestinatario() {
		return destinatario;
	}



	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}



	public String getFechaEntrega() {
		return fechaEntrega;
	}



	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	


	@Override
	public String toString() {
	
	return "\t\t<pedido>\n\t\t\t<productos>\n\t\t"+productos +"\t\t\t</productos>\n\t\t\t<cantidad>"+cantidad+"</cantidad>\n\t\t\t<calle>"+calle +"</calle>\n\t\t\t<numero>"+numero +
			"</numero>\n\t\t\t<cp>"+cp +"</cp>\n\t\t\t<poblacion>"+poblacion +"</poblacion>\n\t\t\t<pais>"+pais +"</pais>\n\t\t\t<destinatario>"+destinatario +
			"</destinatario>\n\t\t\t<fechaEntrega>"+fechaEntrega +"</fechaEntrega>\n\t\t</pedido>\n";
	}

}


public class Producto {

	private int codigo;
	private String nombre;
	private String descripcion;
	private int stock;
	private char pasillo;
	private int estanteria;
	private	int estante;
	private boolean estado; //Pendientes
	
	
	public Producto(int codigo, String nombre, String descripcion, int stock, char pasillo, int estanteria, int estante,
			boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.pasillo = pasillo;
		this.estanteria = estanteria;
		this.estante = estante;
		this.estado = estado;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public char getPasillo() {
		return pasillo;
	}


	public void setPasillo(char pasillo) {
		this.pasillo = pasillo;
	}


	public int getEstanteria() {
		return estanteria;
	}


	public void setEstanteria(int estanteria) {
		this.estanteria = estanteria;
	}


	public int getEstante() {
		return estante;
	}


	public void setEstante(int estante) {
		this.estante = estante;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
			
	return "\t\t<producto>\n\t\t\t<codigo>"+codigo +"</codigo>\n\t\t\t<nombre>"+nombre+"</nombre>\n\t\t\t<descripcion>"+descripcion +"</descripcion>\n\t\t\t<stock>"+stock +
			"</stock>\n\t\t\t<pasillo>"+pasillo +"</pasillo>\n\t\t\t<estanteria>"+estanteria +"</estanteria>\n\t\t\t<estante>"+estante +"</estante>\n" +
			"\t\t\t<estado>"+estado +"</estado>\n\t\t</producto>\n";
	}
	
}

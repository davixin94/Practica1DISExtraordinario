import java.util.ArrayList;


public class Almacen {
	
	private ArrayList<Clientes> clientes = new ArrayList<>();
	private ArrayList<Pedidos> pedidos = new ArrayList<>();
	private ArrayList<Producto> productos = new ArrayList<>();
	
	public Almacen() {
		
	}
	
	public Almacen(ArrayList<Clientes> clientes, ArrayList<Pedidos> pedidos, ArrayList<Producto> productos) {
		super();
		this.clientes = clientes;
		this.pedidos = pedidos;
		this.productos = productos;
	}
	public void setClientes(ArrayList<Clientes> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Clientes> getClientes() {
		return clientes;
	}
	public ArrayList<Pedidos> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
	

}

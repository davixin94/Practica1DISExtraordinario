import java.util.ArrayList;

public class Models extends ArrayList<Models.Container>{
	
	public class Container{
		public int type;
		public Object object;
	}
	
	public class Clientes{
		public String nombre;
		public String apellidos;
		public String email;
		public int telefono;
		public String calle;
		public int numero;
		public int cp;
		public String poblacion;
		public String pais;
	}
	
	public class Pedidos{
		public ArrayList<Producto> productos;
		public int cantidad;
		public String calle;
		public int numero;
		public int cp;
		public String poblacion;
		public String pais;
		public String destinatario;
		public String fechaEntrega;
	}
	
	public class Producto{
		public int codigo;
		public String nombre;
		public String descripcion;
		public int stock;
		public char pasillo;
		public int estanteria;
		public	int estante;
		public boolean estado;
	}

}

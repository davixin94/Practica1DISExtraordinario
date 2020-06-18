import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int menu = -1;
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
		
		while(menu != 4) {
			generarMenu();
			menu = Integer.parseInt(in.readLine());
			switch (menu) {
			case 1:
				Producto p = subMenuProducto();
				productos.add(p);
				break;
			case 2:
				Clientes c = subMenuCliente();
				clientes.add(c);
				break;
			case 3:
				Pedidos ped = subMenuPedidos();
				pedidos.add(ped);
				break;
			case 4:
				break;
			default:
				System.out.println("Por favor, elija una opcion valida.");
			}
		}
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\">\n";
		String root = "<almacen>\n";
		String xml = "";
		xml += header + root;
		for(Producto p: productos) {
			xml += "\t<productos>\n";
			xml += p;
			xml += "\t</productos>\n";
		}
		for(Clientes c: clientes) {
			xml += "\t<clientes>\n";
			xml += c;
			xml += "\t</clientes>\n";
		}
		for(Pedidos ped: pedidos) {
			xml += "\t<pedidos>\n";
			xml += ped;
			xml += "\t</pedidos>\n"
					+ "";
		}
		String close_root = "\n</almacen>";
			
		xml += close_root;
		
		writeToFile(xml, "../xmlAlmacen.xml");
		
	}
	
	public static void generarMenu() {
		System.out.println("---------------");
		System.out.println("Elija una opcion:");
		System.out.println("1.- Introducir producto");
		System.out.println("2.- Introducir datos de cliente.");
		System.out.println("3.- Introducir datos de pedido");
		System.out.println("4.- Salir");
	}
	
	public static Clientes subMenuCliente() throws IOException {
        java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //Inicializacion datos cliente
        String nombre = null;
        String apellido = null;
        String email = null;
        int telefono = 0;
        String calle = null;
        int numero = 0;
        int cp = 0;
        String poblacion = null;
        String pais = null;

        System.out.println("Introduce datos del cliente:");
        //Introduccion de datos cliente por el usuario
        System.out.println("Introduce nombre:");
        nombre = in.readLine();
        System.out.println("Introduce apellidos:");
        apellido = in.readLine();
        System.out.println("Introduce email:");
        email = in.readLine();
        while(!email.contains("@")) {
            System.out.println("Email no valido");
            System.out.println("Introduce email:");
            email = in.readLine();
        }
        System.out.println("Introduce telefono:");
        telefono = Integer.parseInt(in.readLine());;
        System.out.println("Introduce direccion");
        System.out.println("Calle:");
        calle = in.readLine();
        System.out.println("Numero:");
        numero = Integer.parseInt(in.readLine());;
        System.out.println("Codigo Postal:");
        cp = Integer.parseInt(in.readLine());;
        System.out.println("Poblacion:");
        poblacion = in.readLine();
        System.out.println("Pais:");
        pais = in.readLine();
        System.out.println("---FIN DE CLIENTE---");

        Clientes c = new Clientes(nombre, apellido, email, telefono, calle, numero, cp, poblacion, pais);
        return c;

    }
	public static Producto subMenuProducto() throws NumberFormatException, IOException {
        java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //Inicializacion de datos de producto
        int codigo = 0;
        String nombre = null;
        String descripcion = null;
        int stock = 0;
        char pasillo = ' ';
        int estanteria = 0;
        int estante = 0;
        boolean estado = false;
        String estado_aux = null;
        System.out.println("Introduce datos del producto:");
        //Introducción de datos por el usuario
        System.out.println("Introduce codigo de 10 numeros:");
        codigo = Integer.parseInt(in.readLine());;
        System.out.println("Introduce nombre:");
        nombre = in.readLine();
        System.out.println("Introduce descripcion:");
        descripcion = in.readLine();
        System.out.println("Introduce stock:");
        stock = Integer.parseInt(in.readLine());;
        System.out.println("Introduce la localizacion del producto en el almacen:");
        System.out.println("Pasillo (A-Z):");
        pasillo = (in.readLine()).charAt(0);
        System.out.println("Estanteria (0-10):");
        estanteria = Integer.parseInt(in.readLine());;
        System.out.println("Introduce estante (0-5):");
        estante = Integer.parseInt(in.readLine());;
        System.out.println("---Fin de localizacion---");
        System.out.println("Introduce si el producto esta en almacen (y/n):");
        estado_aux = in.readLine();
        if (estado_aux == "y" || estado_aux == "yes" || estado_aux == "si") {
            estado = true;
        }else if(estado_aux == "n" || estado_aux== "no"){
            estado = false;
        }
        System.out.println("---FIN DE PRODUCTO---");

        Producto p = new Producto(codigo, nombre, descripcion, stock, pasillo,
                estanteria, estante, estado);
        return p;
    }
	
	public static Pedidos subMenuPedidos() throws IOException {
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Inicializacion datos pedido
		String producto = null;
		ArrayList<String> productos = new ArrayList<String>();
		String calle = null;
		int numero = 0;
		int cp = 0;
		String poblacion = null;
		String pais = null;
		String destinatario = null;
		String fecha = null;
		
		
		System.out.println("Introduce datos del pedido:");
		//Introducción de datos del pedido por el usuario
		System.out.println("Introduce productos (presionar 0 para finalizar introduccion de productos):");
		producto = in.readLine();
		do{
			if(!producto.contentEquals("0")) {
				productos.add(producto);
				producto = in.readLine();
			}
		}while(!producto.contentEquals("0"));
		System.out.println("Productos introducidos.");
		System.out.println("Hay un total de " + (productos.size()) + " productos.");
		System.out.println("Introduce direccion de entrega:");
		System.out.println("Calle:");
		calle = in.readLine();
		System.out.println("Número:");
		numero = Integer.parseInt(in.readLine());;
		System.out.println("Código Postal:");
		cp = Integer.parseInt(in.readLine());;
		System.out.println("Poblacion:");
		poblacion = in.readLine();
		System.out.println("Pais:");
		pais = in.readLine();
		System.out.println("---FIN de direccion de entrega---");
		System.out.println("Introduce nombre del destinatario:");
		destinatario = in.readLine();
		System.out.println("Introduce de fecha estimada de entrega:");
		System.out.println("Introduce día previsto (dd):");
		fecha += in.readLine();
		System.out.println("Introduce mes previsto (MM):");
		fecha += in.readLine();
		System.out.println("Introduce a�o previsto (yyyy):");
		fecha += in.readLine();
		System.out.println("---FIN DE PEDIDO---");
		
		Pedidos p = new Pedidos(productos, productos.size(), calle, numero, cp,
				poblacion, pais, destinatario,fecha);
		
		return p;
	}
	
	public static void writeToFile(String xml, String fileName) throws IOException {
	    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
	    try {
			writer.write(xml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

}

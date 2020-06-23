import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;

import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.reflect.*;

public class Main {

	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	private static ArrayList<Pedidos> pedidosTotal = new ArrayList<>();
	private static ArrayList<Clientes> clientes = new ArrayList<Clientes>();
	private static Almacen almacen = new Almacen();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int menu = -1;
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
		
		
		String datosJsonString = "";
		
		while(menu != 5) {
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
				Pedidos ped = subMenuPedidos(productos);
				pedidosTotal.add(ped);
				break;
			case 4:
				JsonReader reader = new JsonReader(new FileReader("jsonAlmacen.json"));
				Gson g = new Gson();
				reader.setLenient(true);
				
				Almacen json = g.fromJson(reader, new TypeToken<Almacen>(){}.getType());
				importarDatos(json);
				System.out.println("Datos importados:\n"+ json.toString());
				datosJsonString = json.toString();
				break;
			case 5:
				break;
			default:
				System.out.println("Por favor, elija una opcion valida.");
			}
		}
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
		String root = "<almacen>\n";
		String xml = "";
		String aux="";
		
		xml += header + root;
		xml += "\t<productos>\n";
		for(Producto p: productos) {
			xml += p;	
		}
		xml += "\t</productos>\n";
		xml += "\t<clientes>\n";
		for(Clientes c: clientes) {
			xml += c;	
		}
		xml += "\t</clientes>\n";
		xml += "\t<pedidos>\n";
		for(Pedidos ped: pedidosTotal) {
			aux += ped;
			aux=aux.replace("</producto>", "\t\t</producto>");
		}
		aux=aux.replace("<codigo>", "\t\t<codigo>");
		aux=aux.replace("<nombre>", "\t\t<nombre>");
		aux=aux.replace("<descripcion>", "\t\t<descripcion>");
		aux=aux.replace("<stock>", "\t\t<stock>");
		aux=aux.replace("<pasillo>", "\t\t<pasillo>");
		aux=aux.replace("<estanteria>", "\t\t<estanteria>");
		aux=aux.replace("<estante>", "\t\t<estante>");
		aux=aux.replace("<estado>", "\t\t<estado>");
		xml += aux;
		xml += "\t</pedidos>\n";
		String close_root = "</almacen>";
			
		xml += close_root;
		
		xml=xml.replace("[", "");
		xml=xml.replace(",", "\t\t");
		xml=xml.replace("]", "");
		
		writeToFile(xml, "xmlAlmacen.xml");
		writeToJson(xml, "jsonAlmacen.json");
		
	}
	
	private static void importarDatos(Object o){
		// TODO Auto-generated method stub

		pedidosTotal = almacen.getPedidos();
		productos = almacen.getProductos();	
		clientes = almacen.getClientes();
	}

	public static void generarMenu() {
		System.out.println("---------------");
		System.out.println("Elija una opcion:");
		System.out.println("1.- Introducir producto");
		System.out.println("2.- Introducir datos de cliente.");
		System.out.println("3.- Introducir datos de pedido");
		System.out.println("4.- Importar Datos");
		System.out.println("5.- Guardar y Salir");
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
        //IntroducciÃ³n de datos por el usuario
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
        System.out.println("Pendiente de entrada en almacén (y/n):");
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
	
	public static Pedidos subMenuPedidos(ArrayList<Producto> productos) throws IOException {
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Inicializacion datos pedido
		String producto = null;
		ArrayList<Producto> productosPedidos = new ArrayList<>();
		String calle = null;
		int numero = 0;
		int cp = 0;
		String poblacion = null;
		String pais = null;
		String destinatario = null;
		String fecha = null;
		int cantidad = 0;
		
		
		System.out.println("Introduce datos del pedido:");
		//IntroducciÃ³n de datos del pedido por el usuario
		System.out.println("Introduce productos (presionar 0 para finalizar introduccion de productos):\n");
		producto = in.readLine();
		do{
			if(!producto.contentEquals("0")) {
				for(Producto prod: productos) {
					if(prod.getNombre().equals(producto)) {
						System.out.println("Introduce cantidad: \n");
						cantidad = Integer.parseInt(in.readLine());
						if((prod.getStock() - cantidad)>0) {
							prod.setStock(prod.getStock() - cantidad);
							productosPedidos.add(prod);
							System.out.println(producto + " añadido con éxito.\n");
						}else {
							System.out.println("No hay suficiente stock!\n");
						}
					}
				}
				producto = in.readLine();
			}
		}while(!producto.contentEquals("0"));
		System.out.println("Productos introducidos.");
		System.out.println("Hay un total de " + (productosPedidos.size()) + " productos.");
		System.out.println("Introduce direccion de entrega:");
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
		System.out.println("---FIN de direccion de entrega---");
		System.out.println("Introduce nombre del destinatario:");
		destinatario = in.readLine();
		System.out.println("Introduce de fecha estimada de entrega:");
		System.out.println("Introduce dia previsto (dd):");
		fecha = in.readLine()+"/";
		System.out.println("Introduce mes previsto (MM):");
		fecha += in.readLine()+"/";
		System.out.println("Introduce año previsto (yyyy):");
		fecha += in.readLine();
		System.out.println("---FIN DE PEDIDO---");
		
		Pedidos p = new Pedidos(productosPedidos, productosPedidos.size(), calle, numero, cp,
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
	
	public static void writeToJson(String xml, String fileName) throws IOException {
		Gson gson = new Gson();
		JSONObject json = XML.toJSONObject(xml);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(json.toString());
		writer.close();
	}

}

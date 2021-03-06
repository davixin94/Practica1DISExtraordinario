
public class Clientes {
	
	private String nombre;
	private String apellidos;
	private String email;
	private int telefono;
	private String calle;
	private int numero;
	private int cp;
	private String poblacion;
	private String pais;
	
	public Clientes() {
		
	}
	
	public Clientes(String nombre, String apellidos, String email, int telefono, String calle, int numero, int cp,
			String poblacion, String pais) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.calle = calle;
		this.numero = numero;
		this.cp = cp;
		this.poblacion = poblacion;
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
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
	@Override
	public String toString() {
		
	return "\t\t<cliente>\n\t\t\t<nombre>"+nombre +"</nombre>\n\t\t\t<apellidos>"+apellidos+"</apellidos>\n\t\t\t<email>"+email +"</email>\n\t\t\t<telefono>"+telefono +
			"</telefono>\n\t\t\t<calle>"+calle +"</calle>\n\t\t\t<numero>"+numero +"</numero>\n\t\t\t<cp>"+cp +"</cp>\n\t\t\t<poblacion>"+poblacion +
			"</poblacion>\n\t\t\t<pais>"+pais +"</pais>\n\t\t</cliente>\n";
	}
}

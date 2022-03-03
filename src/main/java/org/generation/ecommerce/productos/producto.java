package org.generation.ecommerce.productos;

public class producto {
	private String nombre;
	private String descripcion;
	private String URL_Imagen;
	private double price;
	private int id;
	private static int total=0;

	public producto(String nombre, String descripcion, String uRL_Imagen, double price) {
		super();
		total++;
		this.id = total;
		this.nombre = nombre;
		this.descripcion = descripcion;
		URL_Imagen = uRL_Imagen;
		this.price = price;
	}//constructor
	public producto() {
		super();
		total++;
		this.id = total;
	}//constructor default
	
	public int getId() {
		return id;
	}// getId

	public String getNombre() {
		return nombre;
	}//getNombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre
	public String getDescripcion() {
		return descripcion;
	}//getDescripcion
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion
	public String getURL_Imagen() {
		return URL_Imagen;
	}//getURL_Imagen
	public void setURL_Imagen(String uRL_Imagen) {
		URL_Imagen = uRL_Imagen;
	}//setURL_Imagen
	public double getPrice() {
		return price;
	}//getPrice
	public void setPrice(double price) {
		this.price = price;
	}//setPrice
	@Override
	public String toString() {
		return "producto [nombre=" + nombre + ", descripcion=" + descripcion + ", URL_Imagen=" + URL_Imagen + ", price="
				+ price + "]";
	}//toString		
}//class producto

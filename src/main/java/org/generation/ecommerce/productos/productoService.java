package org.generation.ecommerce.productos;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class productoService {
	public final ArrayList<producto> lista = new ArrayList<producto>();

	public productoService() {
		lista.add( new producto("Plumón tinta fugaz", 
				"Plumón tinta fugaz color verde para pintarrón", 
				"plumonVerde.jpg", 25.0)
				);
		lista.add( new producto("Borrador pintarrón", 
				"Borrador para pintarrón de tinta fugaz", 
				"borradorB.jpg", 45.0)
				);
		lista.add( new producto("Cuaderno profesional cuadro chico", 
				"Cuaderno profesional cuadro chico Norma", 
				"NormaCuadroChico.jpg", 78.0)
				);
	}//constructor

	public ArrayList<producto> getProductos(){
		return lista;
	}// getProductos

	public producto getProducto(Long prodId) {
		producto tmpProd = null;
		for (producto prod : lista) {
			if (prod.getId() == prodId) {
				tmpProd = prod;
			}//if 
		}//foreach
		return tmpProd;
	}// getProducto

	public void deleteProducto(Long prodId) {
		for (producto prod : lista) {
			if (prod.getId() == prodId) {
				lista.remove(prod);
				break;
			}//if 
		}//foreach
	}// deleteProducto

	public void addProducto(producto prod) {
		lista.add(prod);
	} // addProducto

	public void updateProducto(Long prodId, String nombre, 
			String descripcion, double price, String url_Imagen) {
		for (producto prod : lista) {
			if (prod.getId() == prodId) {
				if (nombre!=null) prod.setNombre(nombre);
				if (descripcion!=null) prod.setDescripcion(descripcion);
				if (price!=0)prod.setPrice(price);
				if (url_Imagen!=null) prod.setURL_Imagen(url_Imagen);
			}//if 
		}//foreach
	} // updateProducto
	

	
	
} //class productoService

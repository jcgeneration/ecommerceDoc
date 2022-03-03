package org.generation.ecommerce.productos;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/productos/")
@CrossOrigin(origins="http://localhost:5500")
@Api(value="Administrador de los productos del ecommerce", description="Operaciones CRUD con productos")
public class productoController {
	
	private final productoService prodService;
	@Autowired
	public productoController(productoService prodService) {
		this.prodService = prodService;
	} //constructor
	@ApiOperation(value="Ver las lista de todos los productos disponibles", response=List.class)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Ok"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=500, message="Server Error")
	})
	@GetMapping
	public List<producto> getProductos(){
		return prodService.getProductos();
	}// getProductos
	@ApiOperation(value="Ver un producto específico", response=producto.class)	
	@GetMapping(path="{prodId}")
	public producto getProducto(@PathVariable("prodId") Long prodId){
		return prodService.getProducto(prodId);
	}// getProducto
	@ApiOperation(value="Eliminar un producto específico")
	@DeleteMapping(path="{prodId}")
	public void deleteProducto(@PathVariable("prodId") Long prodId) {
		prodService.deleteProducto(prodId);
	}//deleteProducto
	@ApiOperation(value="Crear un nuevo producto")
	@PostMapping
	public void addProducto(@RequestBody producto prod) {
		prodService.addProducto(prod);
	}//addProducto
	@ApiOperation(value="Actualizar un producto específico")
	@PutMapping(path="{prodId}")
    public void updateProducto(@PathVariable("prodId") Long prodId,
    		@RequestParam(required=false) String nombre, 
    		@RequestParam(required=false) String descripcion,
    		@RequestParam(required=false) double price,
    		@RequestParam(required=false) String url_Imagen) {
		prodService.updateProducto (prodId, nombre, descripcion,
				price, url_Imagen);
	}// updateProducto
	
}//class productoController

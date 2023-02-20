package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Pedido {
	
	


	private int numeroPedido;
	private int idPedidio;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido;

	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public int getIdPedidio() {
		return idPedidio;
	}
	public void setIdPedidio(int idPedidio) {
		this.idPedidio = idPedidio;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	
	
	
	public ArrayList<Producto> getItemsPedido() {
		return itemsPedido;
	}
	public void setItemsPedido(ArrayList<Producto> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}
	public Pedido() {
		
	}
	
	
	
		
}
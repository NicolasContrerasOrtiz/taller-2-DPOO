package modelo;

import java.util.ArrayList;

public class Combo implements Producto {
	
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> ItemsCombo;
	
	
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public String getNombreCombo() {
		return nombreCombo;
	}
	public void setNombreCombo(String nombreCombo) {
		this.nombreCombo = nombreCombo;
	}
	public ArrayList<ProductoMenu> getItemsCombo() {
		return ItemsCombo;
	}
	public void setItemsCombo(ArrayList<ProductoMenu> itemsCombo) {
		ItemsCombo = itemsCombo;
	}
	
	public Combo() {
		// TODO Auto-generated constructor stub
		
		
	}
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

package modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Restaurante{
	
	private Pedido pedidoEnCurso;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Combo> combos;
	
	public Restaurante() {
	}
	
	public void Iniciar_pedido(String nombre_cliente, String direccion_cliente ) {
	
	
	}
	
	public void Cerrar_guardar_pedidio() {
		
	}
	
	public void Cargar_info_restaurante(File ArchivoIngredientes, File ArchivoMenu, File ArchivoCombos, Restaurante restaurante) throws IOException {
		
		HashMap <String, ProductoMenu> map =cargarMenu(restaurante, ArchivoMenu);
		cargarCombos(restaurante, map, ArchivoCombos);
		cargarIngredientes(restaurante, ArchivoIngredientes);
		
		
	}
	
	private HashMap <String, ProductoMenu> cargarMenu(Restaurante restaurante,File menu) throws IOException{ 
		ArrayList<ProductoMenu> menuBase= new ArrayList<ProductoMenu>();
		HashMap <String, ProductoMenu> map = new HashMap <String, ProductoMenu>();
		Reader reader= new FileReader(menu);
		BufferedReader Bfreader= new BufferedReader(reader);
		String linea = Bfreader.readLine();
		
		while(linea != null) {
			String[] elementos= linea.split(";");
			String nombrePlato = elementos[0];
			int precio= Integer.parseInt(elementos[1]);
			ProductoMenu plato= new ProductoMenu();
			plato.setNombre(nombrePlato);
			plato.setPrecioBase(precio);
			menuBase.add(plato);
			map.put(nombrePlato, plato);
			linea= Bfreader.readLine();
			}
		Bfreader.close();
		restaurante.setMenuBase(menuBase);
		return map;
		}
	
	private void cargarCombos(Restaurante restaurante,HashMap <String, ProductoMenu> map, File ArchivoCombos ) throws IOException{ 
		ArrayList<Combo> combos= new ArrayList<Combo>();
		Reader reader= new FileReader(ArchivoCombos);
		BufferedReader Bfreader= new BufferedReader(reader);
		String linea = Bfreader.readLine();
		
		
		while(linea != null) {
			String[] elementos= linea.split(";");
			String nombreCombo = elementos[0];
			String d = elementos[1];
			double dto= (Double.parseDouble(d.replace("%","0")))*0.1;
			
			ArrayList<ProductoMenu> ItemsCombo= new ArrayList<ProductoMenu>();
			ItemsCombo.add(map.get(elementos[3]));
			ItemsCombo.add(map.get(elementos[4]));
			
			Combo combo= new Combo();
			combo.setNombreCombo(nombreCombo);
			combo.setDescuento(dto);
			combo.setItemsCombo(ItemsCombo);
			linea=Bfreader.readLine();
			
		}
		restaurante.setCombos(combos);
		Bfreader.close();;
		}
	
	private void cargarIngredientes(Restaurante restaurante, File ArchivoIngredientes) throws IOException{ 
		ArrayList<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
		Reader reader= new FileReader(ArchivoIngredientes);
		BufferedReader Bfreader= new BufferedReader(reader);
		String linea = Bfreader.readLine();
		
		while(linea != null) {
			String[] elementos= linea.split(";");
			String ingredienete = elementos[0];
			int precio= Integer.parseInt(elementos[1]);
			Ingrediente ingrediente= new Ingrediente();
			ingrediente.setNombre(ingredienete);
			ingrediente.setCostoAdicional(precio);
			linea=Bfreader.readLine();
			}
		Bfreader.close();
		
		restaurante.setIngredientes(ingredientes);
		}
	
	
	
	
	
	public Pedido getPedidoEnCurso() {
		return pedidoEnCurso;
	}

	public void setPedidoEnCurso(Pedido pedidoEnCurso) {
		this.pedidoEnCurso = pedidoEnCurso;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public ArrayList<ProductoMenu> getMenuBase() {
		return menuBase;
	}

	public void setMenuBase(ArrayList<ProductoMenu> menuBase) {
		this.menuBase = menuBase;
	}

	public ArrayList<Combo> getCombos() {
		return combos;
	}

	public void setCombos(ArrayList<Combo> combos) {
		this.combos = combos;
	}
	
	
	
	
	
	

}

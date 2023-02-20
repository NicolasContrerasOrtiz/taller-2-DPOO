package Consola;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modelo.*;


public class Aplicacion {
	
	public void Inciarapp() throws IOException {
		String nombreCliente= input("ingrese su nombre");
		String direccion = input("ingrese su direccion");
		
		File ArchivoIngredientes= new File("ingredientes.txt");
		File ArchivoCombos= new File("combos.txt");
		File ArchivoMenu= new File("menu.txt");
		Restaurante restaurante= new Restaurante();
		
		System.out.println("Bienvienido " + nombreCliente);
		
		restaurante.Cargar_info_restaurante(ArchivoIngredientes,ArchivoMenu,ArchivoCombos,restaurante);
		

		boolean cond=true;
		while(cond) { 
			mostrar_menu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor digite el numero de opcion deseada"));
			if (opcion_seleccionada == 4) {
				
				cond=false;
				}
			ejecutar_opcion(opcion_seleccionada,restaurante,nombreCliente, direccion);
			
			
			
		
			}
			
		
		
		
		
			
	}


	public static void main(String[] args) throws IOException {
		Aplicacion app = new Aplicacion();
		app.Inciarapp();
		
	
		
	}
	
	public void mostrar_menu() {	
		
		System.out.println("Usted Puede elegir entre las siguientes opciones");
		System.out.println("1. Mostrar el Menu");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Consultar un pedido");
		System.out.println("4. Salir");
		
		 
	}
	
	public void ejecutar_opcion(int opcion,Restaurante restaurante,String nombreCliente, String Direccion) {
		if (opcion==1) {
			
			ArrayList<ProductoMenu> menuBase= restaurante.getMenuBase();
			
			for (int i= 0; i < menuBase.size(); i++) {
				ProductoMenu producto= menuBase.get(i);
				
				System.out.println (producto.getNombre() + " : " + String.valueOf(producto.getPrecio()));
			}
			
			
			
		}	
		if (opcion==2) {
			int Id_nuevo= 1; 
			ArrayList<Producto> itemsPedido = new ArrayList<Producto>(); 
			Pedido pedido_nuevo= new Pedido();
			pedido_nuevo.setNombreCliente(nombreCliente);
			pedido_nuevo.setDireccionCliente(Direccion);
			pedido_nuevo.setIdPedidio(Id_nuevo);
			System.out.println("el id de su pedido es: " + String.valueOf(Id_nuevo));		
			restaurante.setPedidoEnCurso(pedido_nuevo);
			boolean cond2= true;
			
			while(cond2) {
				
				System.out.println("Usted Puede elegir entre las siguientes opciones");
				System.out.println("1. Agregar un elemento del menu");
				System.out.println("2. Agregar un Ingrediente");
				System.out.println("3. Agregar un Combo");
				System.out.println("4. terminar su pedido");
			int op = Integer.parseInt(input("Por favor digite el numero de opcion deseada"));
			
			if (op==1) {
				
				ArrayList<ProductoMenu> menuBase= restaurante.getMenuBase();
				
				for (int i= 0; i < menuBase.size(); i++) {
					ProductoMenu producto= menuBase.get(i);
					
					System.out.println (String.valueOf(i) + producto.getNombre() + " : " + String.valueOf(producto.getPrecio()));
					
				}
				int producto_a_añadir = Integer.parseInt("Por favor escriba el numero del producto que desea añadir a su pedido: ");
				System.out.println("se ha agredado un " + (menuBase.get(producto_a_añadir)).getNombre() + " a su pedido");
				
				itemsPedido.add(menuBase.get(producto_a_añadir));
				
				
			}
			
			if (op==2) {
				ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
				
				
			}
			
			if (op==3) {
				
				cond2 =false;
				
			}
				
				
				
			
			
				
			
			}
			
			
		}
		if (opcion==3) {
			
		}
		
		
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	 


}

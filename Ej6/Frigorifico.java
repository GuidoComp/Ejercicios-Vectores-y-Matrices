package Ej6;

import java.util.ArrayList;
import java.util.Arrays;

public class Frigorifico {

	private ArrayList<Pedido> pedidos;
	private ArrayList<Producto> productos;
	private ArrayList<Cliente> clientes;
	private Vendedor[] vendedores;
	
	public Frigorifico() {
		this.pedidos = new ArrayList<>();
		this.productos = new ArrayList<>();;
		this.clientes = new ArrayList<>();;
		this.vendedores = new Vendedor[3];
	}
	
	public String paisMasRentable() {
		double[] recaudacionPorPais = null;
		double recaudacionPais = 0;
		double mayorRecaudacion = Double.MIN_VALUE;
		String paisMayorRecaudacion = null;
		
		recaudacionPorPais = recaudacionPorPais();
		
		for(int i = 0; i < recaudacionPorPais.length; i++) {
			recaudacionPais = recaudacionPorPais[i];
			if (recaudacionPais > mayorRecaudacion) {
				mayorRecaudacion = recaudacionPorPais[i];
				paisMayorRecaudacion = Pais.values()[i].name();
			}
		}
		return paisMayorRecaudacion;
	}
	
	private double[] recaudacionPorPais() {
		double[] recaudacionPorPais = null;
		Cliente cliente = null;
		Pais paisCliente = null;
		
		recaudacionPorPais = new double[Pais.values().length];
		
		for (Pedido p: this.pedidos) {
			cliente = buscarCliente(p.getCuitCliente());
			paisCliente = cliente.getPais();
			recaudacionPorPais[paisCliente.ordinal()] += p.calcularMonto();
		}
		return recaudacionPorPais;
	}

	public int[] clientesPorPais() {
		int[] clientesPorPais = null;
		Pais paisCliente = null;
		
		clientesPorPais = new int[Pais.values().length];
		
		for(Cliente c: this.clientes) {
			paisCliente = c.getPais();
			clientesPorPais[paisCliente.ordinal()]++;
		}
		
		return clientesPorPais;
	}
	
	public void informarCantPedidos() {
		int[][] cantPedidosPorPais = null;
		Cliente cliente = null;
		Pais paisCliente = null;
		Vendedor vendedor = null;
		
		cantPedidosPorPais = new int[this.vendedores.length][Pais.values().length];
		
		for (Pedido p: this.pedidos) {
			cliente = this.buscarCliente(p.getCuitCliente());
			paisCliente = cliente.getPais();
			vendedor = this.buscarVendedor(p.getIdVendedor());
			cantPedidosPorPais[posicionVendedor(vendedor)][paisCliente.ordinal()]++;
		}
		
		for (int i = 0; i < cantPedidosPorPais.length; i++) {
			System.out.println("Vendedor: " + vendedores[i].getNombre());
			for (int j = 0; j < cantPedidosPorPais[i].length; j++) {
				System.out.print(Pais.values()[j].name() + ": " + cantPedidosPorPais[i][j] + " - ");
			}
			System.out.println();
		}
	}
	
	private int posicionVendedor(Vendedor v) {
		int pos = 0;
		int index = 0;
		boolean posEncontrada = false;
		
		while (index < vendedores.length && !posEncontrada) {
			if (vendedores[index] == v) {
				posEncontrada = true;
				pos = index;
			} else {
				index++;
			}
		}
		return pos;
	}
	
	private Cliente buscarCliente(String cuitCliente) {
		int index = 0;
		Cliente clienteEncontrado = null;
		Cliente clienteBuscado = null;
		
		while (index < clientes.size() && clienteBuscado == null) {
			clienteEncontrado = this.clientes.get(index);
			if (clienteEncontrado.getCuit().equals(cuitCliente)) {
				clienteBuscado = clienteEncontrado;
			} else {
				index++;
			}
		}
		return clienteEncontrado;
	}
	
	private Vendedor buscarVendedor(int idVendedor) {
		int index = 0;
		Vendedor vendedorEncontrado = null;
		Vendedor vendedorBuscado = null;
		
		while (index < vendedores.length && vendedorBuscado == null) {
			vendedorEncontrado = this.vendedores[index];
			if (vendedorEncontrado.getId() == idVendedor) {
				vendedorBuscado = vendedorEncontrado;
			} else {
				index++;
			}
		}
		return vendedorBuscado;
	}
	
	public void agregarProducto(Producto p) {
		this.productos.add(p);
	}
	
	public void agregarPedido(Pedido p) {
		this.pedidos.add(p);
	}
	
	public void agregarCliente(Cliente c) {
		this.clientes.add(c);
	}
	
	public void agregarVendedor(Vendedor v) {
		int index = 0;
		boolean vendedorAgregado = false;
		
		while (index < vendedores.length && !vendedorAgregado) {
			if (vendedores[index] == null) {
				vendedores[index] = v;
				vendedorAgregado = true;
			} else {
				index++;
			}
		}
	}

	@Override
	public String toString() {
		return "Frigorifico [pedidos=" + pedidos + ", productos=" + productos + ", clientes=" + clientes
				+ ", vendedores=" + Arrays.toString(vendedores) + "]";
	}
	
	
}

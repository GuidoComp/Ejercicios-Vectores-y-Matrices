package Ej6;

import java.util.ArrayList;

public class Pedido {

	private int idVendedor;
	private String cuitCliente;
	private ArrayList<Producto> productosPedidos;
	
	

	public Pedido(int idVendedor, String cuitCliente, ArrayList<Producto> productosPedidos) {
		this.idVendedor = idVendedor;
		this.cuitCliente = cuitCliente;
		this.productosPedidos = productosPedidos;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public String getCuitCliente() {
		return cuitCliente;
	}

	@Override
	public String toString() {
		return "Pedido [idVendedor=" + idVendedor + ", cuitCliente=" + cuitCliente + "]";
	}

	public double calcularMonto() {
		double monto = 0;
		
		for (Producto pr: this.productosPedidos) {
			monto += pr.getPrecio();
		}
		
		return monto;
	}
	
	
	
}

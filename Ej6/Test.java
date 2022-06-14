package Ej6;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		Frigorifico f = new Frigorifico();
		Producto pr1 = new Producto("450", "Queso", 1000);
		Producto pr2 = new Producto("455", "Jamon", 800);
		Producto pr3 = new Producto("460", "Mortadela", 750);
		Cliente cl1 = new Cliente("4354", "20-34234234-2", "1195849566", Pais.ARGENTINA);
		Cliente cl2 = new Cliente("3344", "20-23423777-2", "1166667583", Pais.CHILE);
		Cliente cl3 = new Cliente("1124", "20-33667778-3", "1154668970", Pais.ARGENTINA);
		Cliente cl4 = new Cliente("2246", "20-77788889-3", "1165788668", Pais.URUGUAY);
		Cliente cl5 = new Cliente("9988", "20-99997777-3", "33657889", Pais.BRASIL);
		Vendedor v1 = new Vendedor(0, "Agustin");
		Vendedor v2 = new Vendedor(1, "Augusto");
		Vendedor v3 = new Vendedor(2, "Lorena");
		
		ArrayList<Producto> productos1 = new ArrayList<>();
		productos1.add(pr1);
		productos1.add(pr2);
		
		ArrayList<Producto> productos2 = new ArrayList<>();
		productos2.add(pr1);
		productos2.add(pr3);
		
		ArrayList<Producto> productos3 = new ArrayList<>();
		productos3.add(pr1);
		productos3.add(pr2);
		productos3.add(pr3);
		productos3.add(pr1);
		productos3.add(pr2);
		productos3.add(pr3);
		productos3.add(pr3);
		
		Pedido pe1 = new Pedido(1, "20-34234234-2", productos1); //v2 vende a cl1, ARG
		Pedido pe2 = new Pedido(0, "20-33667778-3", productos2);//v1 vende a cl3, ARG
		Pedido pe3 = new Pedido(0, "20-34234234-2", productos2);//v1 vende a cl1, ARG
		Pedido pe4 = new Pedido(2, "20-99997777-3", productos1);//v3 vende a cl5, BR
		Pedido pe5 = new Pedido(1, "20-77788889-3", productos3);//v2 vende a cl4, URU
		
		f.agregarCliente(cl1);
		f.agregarCliente(cl2);
		f.agregarCliente(cl3);
		f.agregarCliente(cl4);
		f.agregarCliente(cl5);
		f.agregarProducto(pr1);
		f.agregarProducto(pr2);
		f.agregarProducto(pr3);
		f.agregarVendedor(v1);
		f.agregarVendedor(v2);
		f.agregarVendedor(v3);
		f.agregarPedido(pe1);
		f.agregarPedido(pe2);
		f.agregarPedido(pe3);
		f.agregarPedido(pe4);
		f.agregarPedido(pe5);
		
		System.out.println(f);
		
		f.informarCantPedidos();
		
		System.out.println("");
		int[] array = f.clientesPorPais();
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		
		System.out.println("");
		
		System.out.println(f.paisMasRentable());
	}

}

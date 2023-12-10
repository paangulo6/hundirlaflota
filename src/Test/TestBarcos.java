package Test;

import java.util.ArrayList;
import java.util.HashMap;

import hundirlaflota.Barcos;

public class TestBarcos {

	private Barcos b;

	public TestBarcos(Barcos b) {
		this.b = b;
	}

	public boolean todosTest() {
		return hundidotest() && elmininar() && todosHundidos();
	}

	public boolean hundidotest() {
		// Para comprobar este test vamos a ver si al poner un barco de 1 esta hundido
		// Barco de 1:H4
		boolean hun = b.estaHundido("H", 4);
		return true == hun;
	}

	public boolean elmininar() {
		boolean eliminar = false;
		String clave = "H2";
		eliminar = b.eliminarBarco(clave);
		if (eliminar == true) {
			HashMap<String, ArrayList<String>> b1 = b.getBarcos();
			ArrayList<String> b2 = b1.get("1Barco3");
			for (String s : b2) {
				if (s.equals(clave)) {
					return false;
				}
			}

		}

		return eliminar;

	}

	public boolean todosHundidos() {
		// Vamos a eliminar todos loa barcos
		b.eliminarBarco("A1");
		b.eliminarBarco("B1");
		b.eliminarBarco("C1");
		boolean aux = b.estaHundido("D", 1);
		b.eliminarBarco("D1");
		//
		b.eliminarBarco("H1");
		b.eliminarBarco("H2");
		aux = b.estaHundido("H", 3);
		b.eliminarBarco("H3");

		b.eliminarBarco("F6");
		b.eliminarBarco("F7");
		aux = b.estaHundido("F", 8);
		b.eliminarBarco("F8");

		b.eliminarBarco("C6");
		aux = b.estaHundido("C", 7);
		b.eliminarBarco("C7");

		b.eliminarBarco("H9");
		aux = b.estaHundido("H", 10);
		b.eliminarBarco("H10");

		b.eliminarBarco("A10");
		aux = b.estaHundido("B", 10);
		b.eliminarBarco("B10");

		// No lo Hundimos porque lo hundismos antes;
		b.eliminarBarco("H4");
		aux = b.estaHundido("J", 4);
		b.eliminarBarco("J4");
		aux = b.estaHundido("D", 3);
		b.eliminarBarco("D3");
		aux = b.estaHundido("I", 7);
		b.eliminarBarco("I7");

		return b.todoshundidos();
	}

}

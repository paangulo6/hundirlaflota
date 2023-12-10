package Test;

import java.util.ArrayList;

import hundirlaflota.Tablero;

public class TestTablero {

	
	
	public Tablero TableroVacio() {
		Tablero t= new Tablero();
		return t;
	}
	
	public Tablero agua(Tablero t) {
		t.agua("C", 7);
		t.agua("F", 3);
		t.agua("J", 5);
		t.agua("A", 9);
		return t;
	}
	
	public Tablero TableroTocado( Tablero t) {
		t.tocado("C", 1);
		t.tocado("A", 10);
		t.tocado("B", 3);
		t.tocado("B", 4);
		t.tocado("D", 2);
		return t;
	}
	
	public Tablero TableroTocado2(Tablero t) {
		t.tocado2("C", 1);
		t.tocado2("A", 9);
		return t;
	}
	
	
	
}

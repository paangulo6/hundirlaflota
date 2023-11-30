package Test;

import java.util.ArrayList;

import hundirlaflota.Comprobacion;
import hundirlaflota.Tablero;

public class TestComprobacion {

	private ArrayList<String> letras = new ArrayList();
	private ArrayList<Integer> numero = new ArrayList();
	private Tablero t;

	public TestComprobacion() {
		letras = new ArrayList();
		numero = new ArrayList();
		t = new Tablero();
		t.agua("C", 7);
		t.agua("F", 3);
		t.agua("J", 5);
		t.agua("A", 9);
		t.tocado("C", 1);
		t.tocado("A", 9);
		t.tocado("B", 3);
		t.tocado("B", 4);
		t.tocado("D", 2);
	}


	public boolean testOrdenacion() {
		// A7 B7 C7 E7: FALSA
		letras.add("A");
		letras.add("B");
		letras.add("C");
		letras.add("E");
		numero.add(7);
		numero.add(7);
		numero.add(7);
		numero.add(7);
		Comprobacion c = new Comprobacion(letras, numero, t);
		boolean falsa1 = c.ordenacion();

		// C4 D4 E4 F4 : VERDADERA
		letras = new ArrayList();
		letras.add("C");
		letras.add("D");
		letras.add("E");
		letras.add("F");
		numero = new ArrayList();
		numero.add(7);
		numero.add(7);
		numero.add(7);
		numero.add(7);
		Comprobacion c1 = new Comprobacion(letras, numero, t);
		boolean verdadera1 = c1.ordenacion();

		// I3 I4 I5 I6 : VERDADERA
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("I");
		letras.add("I");
		letras.add("I");
		letras.add("I");
		numero.add(3);
		numero.add(4);
		numero.add(5);
		numero.add(6);
		Comprobacion c2 = new Comprobacion(letras, numero, t);
		boolean verdadera2 = c2.ordenacion();

		// I3 I4 I5 I7: FALSA
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("I");
		letras.add("I");
		letras.add("I");
		letras.add("I");
		numero.add(3);
		numero.add(4);
		numero.add(5);
		numero.add(7);
		Comprobacion c3 = new Comprobacion(letras, numero, t);
		boolean falsa2 = c3.ordenacion();

		return verdadera1 && verdadera2 && !falsa1 && !falsa2;
	}

	public boolean testLetrascomp() {
		// C4 D4 E4 F4 : VERDADERA
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("C");
		letras.add("D");
		letras.add("E");
		letras.add("F");
		numero.add(7);
		numero.add(7);
		numero.add(7);
		numero.add(7);
		Comprobacion c4 = new Comprobacion(letras, numero, t);
		boolean verdadera1 = c4.letrascomp();
		// D4 E4 F4 K4: FALSA
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("D");
		letras.add("E");
		letras.add("F");
		letras.add("K");
		numero.add(7);
		numero.add(7);
		numero.add(7);
		numero.add(7);
		Comprobacion c5 = new Comprobacion(letras, numero, t);
		boolean falsa1 = c5.letrascomp();
		// I3 I4 I5 I6 : VERDADERA
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("I");
		letras.add("I");
		letras.add("I");
		letras.add("I");
		numero.add(3);
		numero.add(4);
		numero.add(5);
		numero.add(6);
		Comprobacion c6 = new Comprobacion(letras, numero, t);
		boolean verdadera2 = c6.letrascomp();
		// P3 P4 P5 P7: FALSA
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("P");
		letras.add("P");
		letras.add("P");
		letras.add("P");
		numero.add(3);
		numero.add(4);
		numero.add(5);
		numero.add(7);
		Comprobacion c7 = new Comprobacion(letras, numero, t);
		boolean falsa2 = c7.letrascomp();
		return verdadera1 && verdadera2 && !falsa1 && !falsa2;
	}

	public boolean testNumerocomp() {
		// C4 D11 E6 F7 : FALSA
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("C");
		letras.add("D");
		letras.add("E");
		letras.add("F");
		numero.add(4);
		numero.add(11);
		numero.add(6);
		numero.add(7);
		Comprobacion c8 = new Comprobacion(letras, numero, t);
		boolean falsa1 = c8.numerocomp();
		// C4 D5 E6 F7: VERDADERA
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("C");
		letras.add("D");
		letras.add("E");
		letras.add("F");
		numero.add(4);
		numero.add(5);
		numero.add(6);
		numero.add(7);
		Comprobacion c9 = new Comprobacion(letras, numero, t);
		boolean verdadera1 = c9.numerocomp();
		// A11 B11 C11 D11: FALSA
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("A");
		letras.add("B");
		letras.add("C");
		letras.add("D");
		numero.add(11);
		numero.add(11);
		numero.add(11);
		numero.add(11);
		Comprobacion c10 = new Comprobacion(letras, numero, t);
		boolean falsa2 = c10.numerocomp();
		return verdadera1 && !falsa1 && !falsa2;
	}

	public boolean testHaybarco() {
		// TRUE EN C1
		letras = new ArrayList();
		letras.add("C");
		letras.add("D");
		letras.add("E");
		letras.add("F");
		numero = new ArrayList();
		numero.add(1);
		numero.add(1);
		numero.add(1);
		numero.add(1);
		Comprobacion c11 = new Comprobacion(letras, numero, t);
		boolean verdadero = c11.haybarco();
		return verdadero;
	}

	public boolean testNorepetidos() {
		// Falso : si que hay repetidos
		letras = new ArrayList();
		letras.add("C");
		letras.add("D");
		letras.add("D");
		letras.add("F");
		numero = new ArrayList();
		numero.add(1);
		numero.add(1);
		numero.add(1);
		numero.add(1);
		Comprobacion c12 = new Comprobacion(letras, numero, t);
		boolean falso1 = c12.norepetidos();
		// Falso : si que hay repetidos
		letras = new ArrayList();
		letras.add("D");
		letras.add("D");
		letras.add("D");
		letras.add("D");
		numero = new ArrayList();
		numero.add(1);
		numero.add(2);
		numero.add(2);
		numero.add(3);
		Comprobacion c13 = new Comprobacion(letras, numero, t);
		boolean falso2 = c13.norepetidos();
		// Verdad :no hay repetidos
		letras = new ArrayList();
		letras.add("D");
		letras.add("D");
		letras.add("D");
		letras.add("D");
		numero = new ArrayList();
		numero.add(1);
		numero.add(2);
		numero.add(3);
		numero.add(4);
		Comprobacion c14 = new Comprobacion(letras, numero, t);
		boolean verdader1 = c14.norepetidos();
		// Verdad :no hay repetidos
		letras = new ArrayList();
		letras.add("D");
		letras.add("E");
		letras.add("F");
		letras.add("G");
		numero = new ArrayList();
		numero.add(3);
		numero.add(3);
		numero.add(3);
		numero.add(3);
		Comprobacion c15 = new Comprobacion(letras, numero, t);
		boolean verdader2 = c15.norepetidos();
		return verdader1 && verdader1 && !falso1 && !falso2;
	}

	public boolean comprobacion() {
		return true;
	}
}

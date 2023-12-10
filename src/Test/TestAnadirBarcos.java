package Test;

import java.util.ArrayList;

import hundirlaflota.AnadirBarcos;
import hundirlaflota.Barcos;
import hundirlaflota.Tablero;

public class TestAnadirBarcos {

	public AnadirBarcos Testaniadir() {
		ArrayList<String> letras = new ArrayList();
		ArrayList<Integer> numero = new ArrayList();
		Tablero t = new Tablero();
		Barcos b = new Barcos();
		AnadirBarcos ab = new AnadirBarcos(letras, numero, t, b);
		// 1BARCO4
		letras.add("A");
		letras.add("B");
		letras.add("C");
		letras.add("D");
		numero.add(1);
		numero.add(1);
		numero.add(1);
		numero.add(1);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(1);
		// 1BARCO3
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("H");
		letras.add("H");
		letras.add("H");
		numero.add(1);
		numero.add(2);
		numero.add(3);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(1);
		// 2BARCO3
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("F");
		letras.add("F");
		letras.add("F");
		numero.add(6);
		numero.add(7);
		numero.add(8);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(2);
		// 1BARCO2
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("C");
		letras.add("C");
		numero.add(6);
		numero.add(7);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(1);
		// 2BARCO2
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("H");
		letras.add("H");
		numero.add(9);
		numero.add(10);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(2);
		// 3BARCO2
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("A");
		letras.add("B");
		numero.add(10);
		numero.add(10);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(3);
		// 1BARCO1
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("H");
		numero.add(4);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(1);
		// 2BARCO1
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("J");
		numero.add(4);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(2);
		// 3BARCO1
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("D");
		numero.add(3);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(3);
		// 4BARCO1
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("I");
		numero.add(7);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(4);
		return ab;
	}

}

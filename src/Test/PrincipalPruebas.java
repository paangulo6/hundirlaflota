package Test;

import java.util.ArrayList;
import java.util.HashMap;

import hundirlaflota.AnadirBarcos;
import hundirlaflota.Barcos;
import hundirlaflota.Tablero;

public class PrincipalPruebas {

	public static void main(String[] args) {
		System.out.println("TEST COMPROBACION");
		boolean test=false;
		TestComprobacion tc= new TestComprobacion();
		test=tc.todos();
		System.out.println("Comprobacion:" + test);
		System.out.println("");
		
		System.out.println("TEST TABLERO");
		TestTablero tt= new TestTablero();
		Tablero t = new Tablero();
		System.out.println("Tablero Vacio");
		t=tt.TableroVacio();
		t.mostrarTablero();
		System.out.println("Tablero Con Barcos EN : C1, A9, B3, B4, D2 ");
		t=tt.TableroTocado(t);
		t.mostrarTablero();
		System.out.println("Tablero Con agua en : C7, F3 , J5 , A10");
		t=tt.agua(t);
		t.mostrarTablero();
		System.out.println("Tablero tocado por contricante en : C1 , y A9");
		t=tt.TableroTocado2(t);
		t.mostrarTablero();
		System.out.println("");
		
		System.out.println("TEST ANADIRBARCO");
		TestAnadirBarcos tab= new TestAnadirBarcos();
		AnadirBarcos ab=tab.Testaniadir();
		System.out.println("Barcos Añadidos: ");
		System.out.println("1Barco4: A1-B1-C1-D1");
		System.out.println("1Barco3: H1-H2-H3");
		System.out.println("2Barco3: F6-F7-F8");
		System.out.println("1Barco2: C6-C7");
		System.out.println("2Barco2: H9-H10");
		System.out.println("3Barco2: A10-B10");
		System.out.println("1Barco1: H4");
		System.out.println("2Barco1: J4");
		System.out.println("3Barco1: D3");
		System.out.println("4Barco1: I7");
		t=ab.getTablero();
		t.mostrarTablero();
		System.out.println("Comprobacion que se han añadido bien");
		Barcos b= ab.getBarcos();
		HashMap<String, ArrayList<String>> barcos=b.getBarcos();
		ArrayList<String> b1=barcos.get("1Barco4");
		String barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("1Barco4: "+ barco.equals("A1B1C1D1"));
		b1=barcos.get("1Barco3");
		barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("1Barco3: "+ barco.equals("H1H2H3"));
		b1=barcos.get("2Barco3");
		barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("2Barco3: "+ barco.equals("F6F7F8"));
		b1=barcos.get("1Barco2");
		barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("1Barco2: "+ barco.equals("C6C7"));
		b1=barcos.get("2Barco2");
		barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("2Barco2: "+ barco.equals("H9H10"));
		b1=barcos.get("3Barco2");
		barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("3Barco2: "+ barco.equals("A10B10"));
		b1=barcos.get("1Barco1");
		barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("1Barco1: "+ barco.equals("H4"));
		b1=barcos.get("2Barco1");
		barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("2Barco1: "+ barco.equals("J4"));
		b1=barcos.get("3Barco1");
		barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("3Barco1: "+ barco.equals("D3"));
		b1=barcos.get("4Barco1");
		barco="";
		for(String s: b1) {
			barco=barco+s;
		}
		System.out.println("1Barco1: "+ barco.equals("I7"));
		System.out.println("");
		
		System.out.println("TEST BARCOS");
		TestBarcos tb= new TestBarcos(b);
		boolean tbb=tb.todosTest();
		System.out.println("Barcos: "+ tbb);
		System.out.println("");
		
		System.out.println("TEST METODOS COMPROBAR RANGOS DE LETRAS Y NUMERO");
		TestMetodosComprobarRango mcr= new TestMetodosComprobarRango();
		System.out.println("Metodo de comprobar rango de letras y numero: " + mcr.comprobar());
		

	}

}

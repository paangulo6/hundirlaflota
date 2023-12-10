package hundirlaflota;

import java.util.ArrayList;

public class AnadirBarcos {

	// Arrays donde guardaremos las posicines de los barcos, en orden
	private ArrayList<String> letras;
	private ArrayList<Integer> numeros;
	// El tablero del jugador
	private Tablero tablero;
	// Los barcos que ya tiene el jugador asignados
	private Barcos barcos;

	// Constructor
	public AnadirBarcos(ArrayList<String> letras, ArrayList<Integer> numero, Tablero tablero, Barcos barcos) {
		this.letras = letras;
		this.numeros = numero;
		this.tablero = tablero;
		this.barcos = barcos;
	}

	// Pre: letras es un array inicializado no nulo
	// Post: asigna el valor de letras a la variable letras del this
	public void setLetras(ArrayList<String> letras) {
		this.letras = letras;
	}

	// Pre: numeros es un array de intgeger inicaialiado no nulo
	// Post: asigna el valor de numeros a la vriable numeros del this
	public void setNumeros(ArrayList<Integer> numeros) {
		this.numeros = numeros;
	}

	// Pre:
	// Post: devuelve el objeto tablero de tipo Tablero del this
	public Tablero getTablero() {
		return this.tablero;
	}

	// Pre:
	// Post: devuelve el objeto barcos de tipo Barcos del this
	public Barcos getBarcos() {
		return this.barcos;
	}

	// Pre: num es un integer que especifica el numero de barco que es
	// Post: devuelve verdad si se ha podido añadir el barco, es decir si el metodo
	// comprobar de la clase comprobacion devuelve verdad y añade a barcos el barco,
	// y falso en caso en caso contrario
	public boolean aniadir(int num) {
		boolean estabien = false;
		Comprobacion c;
		ArrayList<String> posicion = new ArrayList<String>();
		c = new Comprobacion(letras, numeros, tablero);
		estabien = c.comprobar();
		if (estabien) {
			for (int i = 0; i < letras.size(); i++) {
				String clave = letras.get(i) + numeros.get(i);
				posicion.add(clave);
				tablero.tocado(letras.get(i), numeros.get(i));

			}
		}
		this.barcos.addBarco(num + "Barco" + letras.size(), posicion);
		return estabien;
	}

}

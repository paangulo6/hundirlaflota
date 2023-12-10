package hundirlaflota;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Barcos implements Serializable {
	// En este HashMap guadaremos los barcos esto nos servira para saber si el barco
	// esta hundido o no. Si la lista es vacia esque esta hunidio.
	private HashMap<String, ArrayList<String>> barcos;
	int numbarcosHundidos;

	// Constructor
	public Barcos() {
		barcos = new HashMap<String, ArrayList<String>>();
		numbarcosHundidos = 0;

	}

	// Pre: barcos es un HashMap<String, ArrayList<String>> iniciado previamente y
	// no nulo´
	// Post: asigna el valor de barcos al objeto barcos del objeto this.
	public void setBarcos(HashMap<String, ArrayList<String>> barcos) {
		this.barcos = barcos;
	}

	// pre:
	// Post: devuelve el objeto barcos
	public HashMap<String, ArrayList<String>> getBarcos() {
		return this.barcos;
	}

	// Pre: El nombre es el nombre del barco y tiene una estructura que te indica el
	// numero del barco + barco + el numero de casillas Por ejemplo: 1barco4 ,
	// 3barco3
	// Post; devuelve verdad si el barco se ha añadido y falso en caso contrario
	public boolean addBarco(String nombre, ArrayList<String> posiciones) {
		if (!barcos.containsKey(nombre)) {
			barcos.put(nombre, posiciones);
			return true;
		} else {
			return false;
		}
	}

	// Pre;
	// Post: devuelve verdad si todos los barcos estan hundidos y falso en caso
	// contarrio
	public boolean todoshundidos() {
		return numbarcosHundidos == 10;

	}

	// Pre:letra es una letra comprendida entre A y J y num es un numero comprendido
	// entre 1 y 10
	// Post: devuelve verdad si el barco con clave letra-numero esta hundido y falso
	// en caso contario
	public boolean estaHundido(String letra, int num) {
		String clave = letra + num;
		String nombre = "1Barco4";
		ArrayList<String> l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}
		nombre = "1Barco3";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}

		nombre = "2Barco3";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}

		nombre = "1Barco2";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}

		nombre = "2Barco2";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}

		nombre = "3Barco2";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}

		nombre = "1Barco1";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}

		nombre = "2Barco1";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}

		nombre = "3Barco1";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}

		nombre = "4Barco1";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> hun = barcos.get(nombre);
				if (hun.size() == 1) {
					numbarcosHundidos++;
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	// Pre: clave es una clave de letra y numero que nos indica una poscion del
	// tablero
	// Post: devuelve verdad si ha eliminado el barco con clave clave y faslo en
	// caso contario
	public boolean eliminarBarco(String clave) {
		String nombre = "1Barco4";
		ArrayList<String> l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		nombre = "1Barco3";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		nombre = "2Barco3";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		nombre = "1Barco2";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		nombre = "2Barco2";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		nombre = "3Barco2";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		nombre = "1Barco1";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		nombre = "2Barco1";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		nombre = "3Barco1";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		nombre = "4Barco1";
		l = barcos.get(nombre);
		for (String s : l) {
			if (s.equals(clave)) {
				ArrayList<String> laux = elimbar(l, clave);
				barcos.replace(nombre, laux);
				return true;
			}
		}
		return false;
	}

	// metodo auxiliar para eliminar un barco
	public ArrayList<String> elimbar(ArrayList<String> l, String clave) {
		ArrayList<String> sol = new ArrayList<String>();
		for (int i = 0; i < l.size(); i++) {
			if (!l.get(i).equals(clave)) {
				sol.add(l.get(i));
			}
		}
		return sol;
	}

}

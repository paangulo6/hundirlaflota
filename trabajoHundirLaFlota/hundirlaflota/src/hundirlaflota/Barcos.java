package hundirlaflota;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Barcos implements Serializable{
	//En este  HashMap guadaremos los barcos esto nos servira para saber si el barco esta hundido o no. Si la lista es vacia esque esta hunidio.
		private HashMap<String, ArrayList<String>> barcos;
		private ArrayList<String> hundidos;
		
		public Barcos(){
			barcos= new HashMap<String, ArrayList<String>>();
			hundidos= new ArrayList<String>();
		}
		
		
		//Propiedades:
		public void setBarcos(HashMap<String, ArrayList<String>> barcos) {
			this.barcos=barcos;
		}
		
		public HashMap<String, ArrayList<String>> getBarcos(){
			return this.barcos;
		}
		
		public void setHundios(ArrayList<String> hundidos){
			this.hundidos=hundidos;
		}
		
		public  ArrayList<String> getHundidos(){
			return this.hundidos;
		}
		
		
		//Pre: El nombre es el nombre del barco y tiene una estructura que te indica el numero del barco + barco + el numero de casillas Por ejemplo: 1barco4 , 3barco3
		//Post; devuelve verdad si el barco se ha añadido y falso en caso contrario
		public boolean addBarco(String nombre, ArrayList<String> posicion) {
			if(! barcos.containsKey(nombre)) {
				barcos.put(nombre, posicion);
				return true;
			}else {
				return false;
			}
		}
		
		
		//Pre: El nombre es el nombre del barco y tiene una estructura que te indica el numero del barco + barco + el numero de casillas Por ejemplo: 1barco4 , 3barco3
		//Post: devuelve verdad si el barco esta hundido es decir el oponente ya ha adivinado todas las posiciones y faslo en caso contrario
		public boolean estaHundido(String nombre) {
			ArrayList<String> hun= barcos.get(nombre);
			if(hun.size()==0) {
				return true;
			}
			return false;
		}
		
		
	
}

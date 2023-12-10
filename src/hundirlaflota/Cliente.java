package hundirlaflota;

import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {

	private int numerobarcos;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//El tablero que sera el tablero del jugador
		Tablero tablero = new Tablero();
		Barcos barcos = new Barcos();
		boolean estabien = false;
		//Tablero del oponente 
		Tablero tableroOponente= new Tablero();
		//Boolean que nos dira si las letras y los numeros introducidos estan en el rango de valores que admite el juego.
		boolean letranumero=false;
		String letra="";
		String nums="";
		int num=0;

		//Nos mostrara el meu del juego
		menu();

		//Estas listas son dos listas auxiliares que guardaran en orden las letras y los numeros par que la clase añadir barco
		//Añada esas coordenas a la calse barcos
		ArrayList<String> letras = new ArrayList<String>();
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		AnadirBarcos abarcos = new AnadirBarcos(letras, numeros, tablero, barcos);

		//Empezamos con el barco de tamaño 4, como solo hay uno solo tenemos que hacerlo 1 vez
		while (estabien == false) {
			letras = new ArrayList();
			numeros = new ArrayList();
			System.out.println("1º barco de 4 casillas");
			
			for (int i = 0; i <= 3; i++) {
				
				while(!letranumero) {
					System.out.println("Introzuca la letra de fila en la que quiere colacar el barco");
					letra = s.next();
					letra=letra.toUpperCase();  //Ponemos lo que nos han pasado en mayusculas ya que nuestro programa trabaja en mayusuclas  
					System.out.println("Introzuca el numero de  columna en la que quiere colacar el barco");
					nums=s.next();
					//Comprobamos que letra esta entre A y J y es una letra 
					// y el numero introducido es un numero y esta entre 1-10
					if(esletra(letra) && esNumero(nums) && letraRango(letra)) {
						letranumero=true;
					}else {
						System.out.println("Coordenada mal introducida, fuara de rango");
					}
				}
				num=Integer.parseInt(nums);
				letras.add(letra);
				numeros.add(num);
				letranumero=false;


			}
			//Asignamos las letras y los numeros a añadir barco para que pueda comprobar
			abarcos.setLetras(letras);
			abarcos.setNumeros(numeros);
			//Si el metodo añadir de la clase añadir barco devuelve verdad  es que el barco esta bien introducio y se a añadido a los barcos del jugador
			//Le pasamos un 1 porque solo hay un barco de tamaño 4
			estabien = abarcos.aniadir(1);
			if (estabien == false) {
				System.out.println("Barco mal introducido");
			}
		}
		
		tablero = abarcos.getTablero();
		//Mostramos el tablero con los barcos colocados 
		tablero.mostrarTablero();
		System.out.println("1º barco de 4 casillas introducido correctamente");

		//Introduimos los barcos de tamaño 3
		//Nos llevara la cuenta de que barco es: 1º o el 2º para pasarselo a la clase añadir Barco para asignarle el nombre
		int numbarco = 1;
		while (numbarco <= 2) {
			estabien = false;
			while (estabien == false) {
				letras = new ArrayList();
				numeros = new ArrayList();
				System.out.println(numbarco + "º barco de 3 casillas");
				for (int i = 0; i <= 2; i++) {
					while(letranumero==false) {
						System.out.println("Introzuca la letra de fila en la que quiere colacar el barco");
						letra = s.next();
						letra=letra.toUpperCase();
						System.out.println("Introzuca el numero de  columna en la que quiere colacar el barco");
						nums=s.next();
						if(esletra(letra) && esNumero(nums) && letraRango(letra)) {
							letranumero=true;
						}else {
							System.out.println("Coordenada mal introducida, fuara de rango");
						}
					}
					num=Integer.parseInt(nums);
					letras.add(letra);
					numeros.add(num);
					letranumero=false;
				}
				abarcos.setLetras(letras);
				abarcos.setNumeros(numeros);
				estabien = abarcos.aniadir(numbarco);
				if (estabien == false) {
					System.out.println("Barco mal introducido");
				}
			}
			tablero = abarcos.getTablero();
			tablero.mostrarTablero();
			System.out.println(numbarco + "º barco de 3 casillas introducido correctamente");
			numbarco++;
		}

		//Introducimos los barcos de tamaño 2 
		numbarco = 1;
		while (numbarco <= 3) {
			estabien = false;
			while (estabien == false) {
				letras = new ArrayList();
				numeros = new ArrayList();
				System.out.println(numbarco + "º barco de 2 casillas");
				for (int i = 0; i <= 1; i++) {
					while(letranumero==false) {
						System.out.println("Introzuca la letra de fila en la que quiere colacar el barco");
						letra = s.next();
						letra=letra.toUpperCase();
						System.out.println("Introzuca el numero de  columna en la que quiere colacar el barco");
						nums=s.next();
						if(esletra(letra) && esNumero(nums) && letraRango(letra)) {
							letranumero=true;
						}else {
							System.out.println("Coordenada mal introducida, fuara de rango");
						}
					}
					num=Integer.parseInt(nums);
					letras.add(letra);
					numeros.add(num);
					letranumero=false;
				}
				abarcos.setLetras(letras);
				abarcos.setNumeros(numeros);
				estabien = abarcos.aniadir(numbarco);
				if (estabien == false) {
					System.out.println("Barco mal introducido");
				}
			}
			tablero = abarcos.getTablero();
			tablero.mostrarTablero();
			System.out.println(numbarco + "º barco de 2 casillas introducido correctamente");
			numbarco++;
		}
		
		//Introducios los barcos de tamaño 1
		numbarco = 1;
		while (numbarco <= 4) {
			estabien = false;
			while (estabien == false) {
				letras = new ArrayList();
				numeros = new ArrayList();
				System.out.println(numbarco + "º barco de 1 casillas");
				while(letranumero==false) {
					System.out.println("Introzuca la letra de fila en la que quiere colacar el barco");
					letra = s.next();
					letra=letra.toUpperCase();
					System.out.println("Introzuca el numero de  columna en la que quiere colacar el barco");
					nums=s.next();
					if(esletra(letra) && esNumero(nums) && letraRango(letra)) {
						letranumero=true;
					}else {
						System.out.println("Coordenada mal introducida, fuara de rango");
					}
				}
				num=Integer.parseInt(nums);
				letras.add(letra);
				numeros.add(num);
				letranumero=false;
				abarcos.setLetras(letras);
				abarcos.setNumeros(numeros);
				estabien = abarcos.aniadir(numbarco);
				if (estabien == false) {
					System.out.println("Barco mal introducido");
				}
			}
			tablero = abarcos.getTablero();
			tablero.mostrarTablero();
			System.out.println(numbarco + "º barco de 2 casillas introducido correctamente");
			numbarco++;
		}

		//Una vez introducidos los tablero de forma correcta empieza el juego
		System.out.println("Has introducido correctamnete tus barcos");
		System.out.println("Tu tablero queda:");
		tablero.mostrarTablero();
		barcos=abarcos.getBarcos();
		System.out.println("Empezamos a jugar.");
		System.out.println("Tu tablero saldra el primero y el de tu contricante el segundo");
		System.out.println("Cuando tu contrincante diga una posicion y no haya tocado agua en tu tablero aparecera O (agua)");
		System.out.println("Cuando tu contrincante diga una posicion  y toque uno de tus barcos aparecera una W");
		System.out.println("Cuando tu contricante te hunda un barco saldra que te ha hundidio el barco y el barco que te haya hundido");
		System.out.println("El jugador 1 empieza la partida.");
		
		
		letranumero=false;
		boolean acabado=false;
		Tablero tablerooponente= new Tablero();
		
		
		//Establecemos conexion con el servidor.
		try (Socket socket = new Socket("localhost", 5678);
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				
				
			) {
			//El objectOutputStream lo usaremos para mandarle el tablero de cada jugador.
			ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
			
			
			//Tablero
			oos.writeObject(tablero);
			
			//Barco 
			oos.writeObject(barcos);
			
			//Para saber el numero de ronda 
			int ronda=1;

			while(!acabado) {
				
				
				System.out.println("Ronda: " + ronda);
				
				
				//Recibimos turno
				int sn=dis.read();
				
				if(sn==1) {
					System.out.println("Es tu turno");
				}else{
					System.out.println("Es el turno del oponente");
				}
				
				if(sn==1) {
					
					//TURNO CUANDO LE TOCA
					
					//Le mandamos la letra y la fila
					while(letranumero==false) {
						s= new Scanner(System.in);
						System.out.println("Escribe la letra de la columna que quieres comprobar si hay barco");
						letra =s.nextLine();
						letra=letra.toUpperCase();
						System.out.println("Escribe el numero de la fila que quieres comprobar si hay barco");
						nums=s.next();
						if(esletra(letra) && esNumero(nums) && letraRango(letra)) {
							letranumero=true;
						}else {
							System.out.println("Coordenada mal introducida, fuara de rango");
						}
					}
					num=Integer.parseInt(nums);
					dos.writeBytes(letra+"\n");
					dos.write(num);
					letranumero=false;
				}
				
				String letraele=dis.readLine();
				int numele=dis.read();
				
				//Las lineas en blanco a lo largo del codigo es para que a la hora de mostrar quede mejor la visibilidad 
				// y no muestre todas las lineas seguidas que es dificil de leer
				System.out.println("");
				
				//Mostramos si nos ha dicho "AGUA" "TOCADO" o "HUNDIDO 
				String comtab=dis.readLine();
				System.out.println(comtab);
				System.out.println("");
				
				//Leemos el numero que manda el servidor para colocar el barco 
				int  comtab2=dis.read();
				
				if(sn==1) {
					//Si nos toca --> colocamos en el tablero que tenemos del opnente so ha sido agua o tocado
					if(comtab2==2 || comtab2==3) {
						//Hundido Y Tocado 
						tablerooponente.tocado(letraele, numele);	
					}else {
						//Agua
						tablerooponente.agua(letraele, numele);
					}

				}else {
					//si nos nos toca colocmos en nuestro tablero que nos ha mandado nuestro rival
					if(comtab2==2 || comtab2==3) {
						//Hundido
						tablero.tocado2(letraele, numele);	
					}else {
						//Agua
						tablero.agua(letraele, numele);
					}
				}
				
				//Mostramos la letra y el numero
				System.out.println("LETRA: " +letraele);
				System.out.println("NUMERO: "+ numele);
				System.out.println("");
				System.out.println("TU TABLERO ES:");
				System.out.println("");
				tablero.mostrarTablero();
				System.out.println("");
				System.out.println("");
				System.out.println("EL TABLERO DEL OPONENTE ES:");
				tablerooponente.mostrarTablero();
				System.out.println("");
				System.out.println("");
				
				//Comprobamos si alguno de los dos ha gandao para terminar la partida
				int seguirjugando=dis.read();
				if(seguirjugando==1) {
					acabado=true;
					if(sn==1) {
						System.out.println("Has ganado");
					}else {
						System.out.println("Has perdido");
					}
				}
			
				ronda++;
			}
				

		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	
	//Pre:
	//Post: muestra el menu por pantalla
	public static void menu() {
		System.out.println("   HUNDIR LA FLOTA ");
		System.out.println("El juego consiste en hundir los barcos de tus oponentes.");
		System.out.println("El primero que hunda los barcos del otro gana la partida");
		System.out.println("PREPARACION");
		System.out.println(
				"Cada jugador cuenta con dos cuadriculas 10x10, la primera es la tuya y la segunda la de tu oponente");
		System.out.println("Debes colocar 10 barcos de diferentes tamaños en posiciones horizontales y verticales");
		System.out.println("Los barcos a colocar son: ");
		System.out.println("            1 barco de 4 casillas");
		System.out.println("            2 barco de 3 casillas");
		System.out.println("            3 barco de 2 casillas");
		System.out.println("            4 barco de 1 casillas");
		System.out.println("En total 20 casillas, 10 barcos");
		System.out.println("Normas para colocar los barcos: ");
		System.out.println("            1. Los barcos pueden estar al borde de la cuadricula");
		System.out.println(
				"            2. Los barcos no pueden superponerse, es decir si uno de tus barcos esta en la 1 A otro de tus barcos no puede estar en la 1 A. ");
		System.out.println(
				"            3. Los barcos pueden estar al lado, no hace falta que haya ninguna separacion entre ellos. ");
		System.out.println(
				"            4. Los barcos pueden estar en posicion vertical o horizontal, nunca de forma diagonal ");
		System.out.println("            5. Una vez colocados tus barcos no puedes cambiarlos.");
		System.out.println("En la cuadricula de tu rival se pondra 0 si es agua y x si es barco ");
		System.out.println("Desarollo: ");
		System.out.println("El jugador 1 elige una coordenada y el juego automaticamente te dira:");
		System.out.println(			"- AGUA: si no hay barco");
		System.out.println(			"- TOCADO: si ha coincidico un barco");
		System.out.println(			"- HUNDIDO: si es un barco de un solo un cuadrado o el ultimo recuadro sin tocar de un barco tocado anteriorente");
		System.out.println(
				"Al jugador 2 se le mostrara la coordenada elegida por el jugador 1 y si ha tocado, hundidio barco o si ha tcoado agua ");
		System.out.println("Primero: Introducir coordenadas de los barcos");
		System.out.println(
				"Para introducir las coordenadas de los barcos tienes que introducir primero la letra y luego el número");
		System.out.println("Tienes que introducilos de menor a mayor.");
		System.out.println("Por ejemplo A1 va antes que B1 o que A7.");
		System.out.println("Y de forma ordenada.");
		System.out.println("Primero: Introducir coordenadas de los barcos");
	}

	

	// Pre: letra es una string
	// Post: devuelve verdad si la string pasada como paraemtro es una letra o no y
	// devuelve falso si es un numero
	public static boolean esletra(String letra) {
		try {
            int numero = Integer.parseInt(letra);
            return false;
            
        } catch (NumberFormatException e) {
        	return true;
        }
	}
	
	
	
	//pre: letra es una string 
	//post: devuelve verdad si la letra pasada como parametro es alguna de estas letras A,B,C,D,E,F,G,H,I,J y falso en caso contrario
	public static boolean letraRango(String letra) {
		
		if(letra.equals("A") || letra.equals("B") || letra.equals("C") || letra.equals("D") || letra.equals("E") || letra.equals("F") || letra.equals("G") || letra.equals("H") ||letra.equals("I") ||letra.equals("J")) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	//pre: 
	//post: devuelve verdad si la string pasada como parametro es un numero y esta en el rango de 0 a 10 (incluidos)
	//y falso en caso contrario
	public static boolean esNumero(String num) {
		 try {
	            int numero = Integer.parseInt(num);
	            if(numero>=1 && numero<=10) {
	            	return true;
	            }else {
	            	return false;
	            }
	        } catch (NumberFormatException e) {
	            return false;
	        }
	}
	
}

package hundirlaflota;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

//Clase similar a la clase Cliente pero en este cliente ya estan creados los tableros 
public class ClienteBarcosCreados {

	public static void main(String[] args) {

		// Arrays que nos ayudaran a crear el tbalero y los barcos, son variables
		// auxiliares pra la clase anadirBarco
		ArrayList<String> letras = new ArrayList();
		ArrayList<Integer> numero = new ArrayList();

		// Creamos nuestro tablero y nuetstri barco
		Tablero tablero = new Tablero();
		Barcos b = new Barcos();

		AnadirBarcos ab = new AnadirBarcos(letras, numero, tablero, b);
		// Metodo que nos añadira al tablero los barcos(implementado abajo)
		ab = aniadir(ab, letras, numero);
		tablero = ab.getTablero();
		b = ab.getBarcos();

		tablero.mostrarTablero();
		System.out.println("");

		// Nos ayudara a saber si ha terminado la partida
		boolean acabado = false;
		Tablero tablerooponente = new Tablero();
		Scanner s = new Scanner(System.in);

		// Establecemos conexion
		try (Socket socket = new Socket("localhost", 5678);
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());) {

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			// Tablero
			oos.writeObject(tablero);

			// Barco
			oos.writeObject(b);

			int ronda = 1;

			while (!acabado) {

				System.out.println("Ronda: " + ronda);

				// Recibimos turno
				int sn = dis.read();
				System.out.println(sn);

				if (sn == 1) {
					System.out.println("Es tu turno");
				} else {
					System.out.println("Es el turno del oponente");
				}

				if (sn == 1) {
					// TURNO CUANDO LE TOCA

					boolean letranumero = false;
					String letra = "";
					String nums = "";
					int num = 0;
					// Le mandamos la letra y la fila
					while (letranumero == false) {
						s = new Scanner(System.in);
						System.out.println("Escribe la letra de la columna que quieres comprobar si hay barco");
						letra = s.nextLine();
						letra=letra.toUpperCase();
						System.out.println("Escribe el numero de la fila que quieres comprobar si hay barco");
						nums = s.next();
						if (esletra(letra) && esNumero(nums) && letraRango(letra)) {
							letranumero = true;
						} else {
							System.out.println("Coordenada mal introducida, fuara de rango");
						}
					}
					num = Integer.parseInt(nums);
					dos.writeBytes(letra + "\n");
					dos.write(num);

				}

				String letraele = dis.readLine();
				int numele = dis.read();

				String comtab = dis.readLine();
				System.out.println(comtab);
				System.out.println("");

				int comtab2 = dis.read();

				if (sn == 1) {

					if (comtab2 == 2) {
						// Hundido
						tablerooponente.tocado(letraele, numele);
					} else if (comtab2 == 3) {
						// Tocado
						tablerooponente.tocado(letraele, numele);
					} else {
						// Agua
						tablerooponente.agua(letraele, numele);
					}

				} else {
					if (comtab2 == 2) {
						// Hundido
						tablero.tocado2(letraele, numele);
					} else if (comtab2 == 3) {
						// Tocado
						tablero.tocado2(letraele, numele);
					} else {
						// Agua
						tablero.agua(letraele, numele);
					}
				}

				System.out.println("LETRA: " + letraele);
				System.out.println("NUMERO: " + numele);
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

				int seguirjugando = dis.read();
				if (seguirjugando == 1) {
					acabado = true;
					if (sn == 1) {
						System.out.println("Has ganado");
					} else {
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

	// Pre: ab es objecto de la clase anadirBarco, ambas listas estan inicializadas
	// y no son nulas
	// Post: devuelve un objecto de tipo anadiraBarco con todos los barcos añadidos
	// al tablero y a los barcos
	public static AnadirBarcos aniadir(AnadirBarcos ab, ArrayList<String> letras, ArrayList<Integer> numero) {
		// 1BARCO4
		letras = new ArrayList();
		numero = new ArrayList();
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

	// pre: letra es una string
	// post: devuelve verdad si la letra pasada como parametro es alguna de estas
	// letras A,B,C,D,E,F,G,H,I,J y falso en caso contrario

	public static boolean letraRango(String letra) {

		if (letra.equals("A") || letra.equals("B") || letra.equals("C") || letra.equals("D") || letra.equals("E")
				|| letra.equals("F") || letra.equals("G") || letra.equals("H") || letra.equals("I")
				|| letra.equals("J")) {
			return true;
		} else {
			return false;
		}

	}

	// pre:
	// post: devuelve verdad si la string pasada como parametro es un numero y esta
	// en el rango de 0 a 10 (incluidos)
	// y falso en caso contrario

	public static boolean esNumero(String num) {
		try {
			int numero = Integer.parseInt(num);
			if (numero >= 1 && numero <= 10) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}

}

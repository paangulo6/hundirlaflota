package hundirlaflota;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AtenderPeticion extends Thread {

	// Guardaremos la entrada de los clientes
	private ArrayList<DataInputStream> dis = new ArrayList<DataInputStream>();
	// Guardaremos la salida de los clientes
	private ArrayList<DataOutputStream> dos = new ArrayList<DataOutputStream>();
	// Guardaremos el tablero de los jugadores
	private ArrayList<Tablero> tablerojugadores = new ArrayList<Tablero>();
	// Guardaremos los barcos de los jugadores.
	private ArrayList<Barcos> barcos = new ArrayList<Barcos>();

	// Construcor
	public AtenderPeticion(ArrayList<DataInputStream> dis, ArrayList<DataOutputStream> dos,
			ArrayList<Tablero> tablerojugadores, ArrayList<Barcos> barcos) {
		for (int n = 0; n < dis.size(); n++) {
			this.dis.add(dis.get(n));
		}
		for (int n = 0; n < dos.size(); n++) {
			this.dos.add(dos.get(n));
		}
		for (int n = 0; n < tablerojugadores.size(); n++) {
			this.tablerojugadores.add(tablerojugadores.get(n));
		}
		for (int n = 0; n < barcos.size(); n++) {
			this.barcos.add(barcos.get(n));
		}
	}

	public void run() {
		int n1 = 0; // Turno
		int n2 = 1; // Turno del oponente
		int aux = 1; // Nos ayudara para saber a quien le toca
		boolean acabar = false; // Para saber cunado termina el juego

		while (!acabar) {
			try {
				// Asignamos el turno a cada jugador
				if (aux == 1) {
					// Turno del jugador 1
					n1 = 0;
					n2 = 1;
					aux = 2;
				} else {
					// Turno del jugador 2
					n1 = 1;
					n2 = 0;
					aux = 1;
				}

				// Mandamos de quien es el turno
				dos.get(n1).write(1);
				dos.get(n1).flush();
				dos.get(n2).write(2);
				dos.get(n2).flush();

				// recibimos la letra y el numero
				String letra = dis.get(n1).readLine();
				int numero = dis.get(n1).read();
				String clave = letra + numero;

				// Le pasamos que letras ha elegido;
				dos.get(n1).writeBytes(letra + "\n");
				dos.get(n1).write(numero);
				dos.get(n2).writeBytes(letra + "\n");
				dos.get(n2).write(numero);

				// Comprobamos que hay en el tablero
				boolean tocado = tablerojugadores.get(n2).hayBraco(letra, numero);
				if (tocado == true) {
					boolean hundido = barcos.get(n2).estaHundido(letra, numero);
					if (hundido == true) {
						dos.get(n1).writeBytes("HUNDIDO \n");
						dos.get(n1).write(2);
						dos.get(n1).flush();
						dos.get(n2).writeBytes("HUNDIDO \n");
						dos.get(n2).write(2);
						dos.get(n2).flush();
					} else {
						dos.get(n1).writeBytes("TOCADO \n");
						dos.get(n1).write(3);
						dos.get(n1).flush();
						dos.get(n2).writeBytes("TOCADO \n");
						dos.get(n2).write(3);
						dos.get(n2).flush();

					}
					// Eliminamos el barco de la lista de barcos.
					barcos.get(n2).eliminarBarco(clave);
					// Comprobamos si ha acabado
					acabar = barcos.get(n2).todoshundidos();

				} else {
					dos.get(n1).writeBytes("AGUA \n");
					dos.get(n1).write(1);
					dos.get(n1).flush();
					dos.get(n2).writeBytes("AGUA \n");
					dos.get(n2).write(1);
					dos.get(n2).flush();
				}

				if (acabar == true) {
					dos.get(n1).write(1);
					dos.get(n1).flush();
					dos.get(n2).write(1);
					dos.get(n2).flush();
				} else {
					dos.get(n1).write(2);
					dos.get(n1).flush();
					dos.get(n2).write(2);
					dos.get(n2).flush();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

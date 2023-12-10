package hundirlaflota;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] args) {

		// Nos dira el numero de jugadores que quieran jugar
		int numjugadores = 0;
		// Guararemos el flujo de entrada de los clentes
		ArrayList<DataOutputStream> listdos = new ArrayList<DataOutputStream>();
		// Guardaremos el flujo de salida de los clientes
		ArrayList<DataInputStream> listdis = new ArrayList<DataInputStream>();
		// Guardaremos el tablero de ambos jugadores
		ArrayList<Tablero> tablerojugadores = new ArrayList<Tablero>();
		// Guardaremos el barco de ambos jugadores
		ArrayList<Barcos> barcos = new ArrayList<Barcos>();

		// Creamos e inicializamos el server socket
		try (ServerSocket server = new ServerSocket(5678)) {
			// para que nos deje conectar a varios clientes
			while (true) {
				try {

					// Acetamos la conexion del cliente
					Socket cliente = server.accept();
					DataInputStream dis = new DataInputStream(cliente.getInputStream());
					listdis.add(dis);
					DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
					listdos.add(dos);

					ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

					// Leemos y guaramos el tablero
					Tablero tablero = (Tablero) ois.readObject();
					tablerojugadores.add(tablero);

					Barcos barco = (Barcos) ois.readObject();
					barcos.add(barco);

					numjugadores++;

					// Si el numero de jugadores es igual a dos empezamos a jugar
					if (numjugadores == 2) {
						AtenderPeticion ap = new AtenderPeticion(listdis, listdos, tablerojugadores, barcos);
						ap.run();

						// Para que juegen mas personas de dos en dos
						/*
						 * listdos = new ArrayList<DataOutputStream>(); listdis = new
						 * ArrayList<DataInputStream>(); tablerojugadores = new ArrayList<Tablero>();
						 * barcos= new ArrayList<Barcos>(); numjugadores=0;
						 */
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

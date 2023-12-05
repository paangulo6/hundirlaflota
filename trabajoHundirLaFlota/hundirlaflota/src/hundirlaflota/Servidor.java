package hundirlaflota;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	
	public static void main(String[] args) {
		
		Barcos barcosjugador1;
		Barcos barcojugador2;
		boolean acabado= false;
		int numjugadores=1;
		
		try(ServerSocket server= new ServerSocket(5678)){
			while(true){
				ArrayList<Socket> clientes= new ArrayList<Socket>();
				Socket cliente= server.accept();
				DataInputStream dis= new DataInputStream(cliente.getInputStream());
				DataOutputStream dos= new DataOutputStream(cliente.getOutputStream());
				dos.write(numjugadores);
				numjugadores++;
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
}

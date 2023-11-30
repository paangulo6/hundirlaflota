package hundirlaflota;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {

	public static void main(String[] args) {
		ArrayList<String> letras= new ArrayList();
		ArrayList<Integer> numero= new ArrayList();
		
		try(ServerSocket socket= new ServerSocket(5678)){
			while(true) {
				try(
						Socket cliente= socket.accept();
						DataOutputStream dos=new DataOutputStream(cliente.getOutputStream());
						DataInputStream dis=new DataInputStream(cliente.getInputStream());
						){
					ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
					Tablero tablero = (Tablero) ois.readObject();
					Barcos barco = (Barcos) ois.readObject();
					boolean estabien=false;
					String linea;
					int num;
					Comprobacion c;
					ArrayList<String> posicion= new ArrayList<String>();
					while(!estabien) {
						letras= new ArrayList();
						numero= new ArrayList();
						for(int i=0; i<=3; i++) {
							linea=dis.readLine();
							num=dis.read();
							letras.add(linea);
							numero.add(num);
							
						}
						c= new Comprobacion(letras,numero, tablero);
						estabien=c.comprobar();
						if(estabien) {
							dos.writeBytes("OK" +"\n");
							dos.flush();
							for(int i=0; i<=3; i++) {
								String clave=letras.get(i) + numero.get(i);
								posicion.add(clave);
								tablero.tocado(letras.get(i), numero.get(i));
							
							}
						}else {
							dos.writeBytes("No" +"\n");
							dos.flush();
						}
					}
					barco.addBarco("1Barrco4", posicion);
					oos.writeObject(tablero);
					//oos.reset();
					
					estabien=false;
					while(!estabien) {
						letras= new ArrayList();
						numero= new ArrayList();
						for(int i=0; i<=2; i++) {
							linea=dis.readLine();
							num=dis.read();
							letras.add(linea);
							numero.add(num);
							
						}
						c= new Comprobacion(letras,numero, tablero);
						estabien=c.comprobar();
						if(estabien) {
							dos.writeBytes("OK" +"\n");
							dos.flush();
							posicion= new ArrayList<String>();
							for(int i=0; i<=2; i++) {
								String clave=letras.get(i) + numero.get(i);
								posicion.add(clave);
								tablero.tocado(letras.get(i), numero.get(i));
							
							}
						}else {
							dos.writeBytes("No" +"\n");
							dos.flush();
						}
					}
					barco.addBarco("1Barrco4", posicion);
					oos.writeObject(tablero);
					
				
					

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

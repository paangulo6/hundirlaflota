package hundirlaflota;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente2 {

	public static void main(String[] args) {
		try(Socket socket= new Socket("localhost", 5678);
				DataInputStream dis= new DataInputStream(socket.getInputStream());
				DataOutputStream dos= new DataOutputStream(socket.getOutputStream());
				){
			ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
			
			int numjug= dis.read();
			System.out.println(numjug);
			
			
			
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

import java.io.*;
import java.lang.Math;

public class seventeenDashOne {
	public static void main(String[] args) throws IOException {
		File temp = new File("Exercise17_01.txt");
		DataOutputStream output;
		
		if (temp.exists()) {
			output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Exercise17_01.txt", true)));
		}
		else {
			output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Exercise17_01.txt")));
		}
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("Exercise17_01.txt")));
		
		for (int i=0; i<=100; i++){
			output.writeInt((int)(Math.random()*10));
		}
		
		try {
			while (true) {
				System.out.print(input.readInt() + " ");
			}
		} catch (EOFException e) {
			System.out.println("finished");
			output.close();
		}
	}
}
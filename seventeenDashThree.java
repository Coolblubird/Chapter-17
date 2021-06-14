import java.io.*;
import java.lang.Math;

public class seventeenDashThree {
	public static void main(String[] args) throws IOException {
		File temp = new File("Exercise17_03.txt");
		DataOutputStream output;
		if (temp.exists()) {
			output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Exercise17_03.txt", true)));
		}
		else {
			output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Exercise17_03.txt")));
		}
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("Exercise17_03.txt")));
		
		for (int i=0; i<=100; i++){
			output.writeInt((int)(Math.random()*10));
		}
		
		reader(input);
		
		output.close();
		input.close();
	}
	
	public static void reader(DataInputStream i) throws IOException{
		int total = 0;
		int hold;
		
		try {
			while (true) {
				hold = i.readInt();
				total+=hold;
				System.out.print(hold + " ");
			}
		} catch (EOFException e) {
			System.out.println("total: " + total);
		}
	}
}
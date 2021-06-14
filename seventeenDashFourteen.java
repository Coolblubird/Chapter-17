//Jordan Ashe 6-14-21

import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class seventeenDashFourteen {
	public static void main(String[] args) throws IOException {
		DataOutputStream output;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input the name of the file you'd like to encode (note, include the file type): ");
		String inFile = scanner.nextLine();
		
		System.out.println("Please input the name of the file you'd like to place the code in (note, include the file type): ");
		String outFile = scanner.nextLine();
		File temp1 = new File(inFile);
		File temp2 = new File(outFile);
		
		output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(temp2)));
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(temp1)));
		
		try {
			while (input.available()>0) {
				int value = input.read();
				output.writeByte(value + 5);
			}
		} catch (EOFException e) {
			System.out.println("finished.");
		} catch (IOException e) {
			System.out.println("finished.");
		}
		
		output.close();
		input.close();
	}
}
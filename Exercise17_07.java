/**
 *
 * @author Jordan Ashe
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException,ClassNotFoundException{
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            outputData();
            
            output.close();
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
    }
    
    
    public static void outputData() throws IOException, EOFException, ClassNotFoundException{
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
        double total = 0;
        Loan temp;
        
        try {
            while (true) {
                temp = (Loan)input.readObject();
                total += temp.getLoanAmount();
            }
        } catch (EOFException e) {
            System.out.println("total: " + total);
            
        }
    }
}

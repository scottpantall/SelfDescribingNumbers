/**
 *
 * @author Scott Pantall
 */
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.*;

public class Main {
    public static void main (String[] args) throws IOException {
        Path file = Paths.get(args[0]);
        BufferedReader buffer = Files.newBufferedReader(file);
        String line;
        
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            //System.out.println(line);
            selfDescribe(line);
        }
    }
    
    public static void selfDescribe(String line) {
        char[] numbers = line.toCharArray();
        int[] digits = new int[numbers.length];
        
        for(int i = 0; i < digits.length; i++) {
            digits[i] = Character.getNumericValue(numbers[i]);
        }
        
        // Read the number in the position
        // Check the full array to see how many times the number for that position occurs
        // If the number in the position equals the number of times, then true and check next position
        // If not, then false and stop
        
        for(int i = 0; i < digits.length; i++) {
            int positionValue = digits[i];
            int count = 0;
            
            for(int j = 0; j < digits.length; j++) {
                if(digits[j] == i) {
                    count++;
                }
            }
            
            if(positionValue != count) {
                System.out.println("0");
                return;
            }
        }
        
        System.out.println("1");
        return;
    }
}

import java.io.FileWriter;
import java.io.IOException;

public class ZeroTo9999 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pass = "";
		
		for(int i = 0; i <= 9999; i++) {
			pass = pass + String.format("%04d", i) + "\n";
		}
		//System.out.println(pass);
		
		String filePath = "Pass.txt";
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			
			fileWriter.write(pass);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

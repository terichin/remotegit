import java.io.*;

public class FileReadSample {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true){
				String line = br.readLine();
				if(line == null){
					br.close();
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

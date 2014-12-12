import java.io.*;

public class FileWriteSample {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("test.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("ƒ†ƒjƒo‰ÔŽq");
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

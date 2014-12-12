import java.io.*;

public class FileIO {

	public void fileWrite(String str) {
		try {
			FileWriter fw = new FileWriter("FileTest.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(str);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileRead() {
		try {
			FileReader fr = new FileReader("FileTest.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while (true) {
				line = br.readLine();
				if (line == null) {
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
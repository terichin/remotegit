public class FileTest {
	public static void main(String[] args) {
		FileIO fio = new FileIO();
		fio.fileWrite("あいうえお");
		fio.fileWrite("かきくけこ");
		fio.fileRead();
	}

}

import org.apache.log4j.Logger;

public class Log4jTest {

	private static final Logger LOGGER =
					Logger.getLogger(Log4jTest.class);
	public static void main(String[] args) {
		LOGGER.info("main���\�b�h");
		try{
			System.out.println(args[0].length());
		}catch(Exception e){
			LOGGER.error("��O���������܂���"+e.toString());
		}
	}

}

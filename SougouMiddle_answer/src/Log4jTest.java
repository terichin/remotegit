import org.apache.log4j.Logger;

public class Log4jTest {

	private static final Logger LOGGER =
					Logger.getLogger(Log4jTest.class);
	public static void main(String[] args) {
		LOGGER.info("mainメソッド");
		try{
			System.out.println(args[0].length());
		}catch(Exception e){
			LOGGER.error("例外が発生しました"+e.toString());
		}
	}

}

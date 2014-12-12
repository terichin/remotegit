import org.apache.log4j.Logger;

public class Log4jSample {

	private static final Logger LOGGER =
					Logger.getLogger(Log4jSample.class);
	public static void main(String[] args) {
		LOGGER.fatal("test fatal");
		LOGGER.warn("test warn");
		LOGGER.info("test info");
		LOGGER.debug("test debug");
		LOGGER.trace("test trace");
		LOGGER.error("test error");
	}

}
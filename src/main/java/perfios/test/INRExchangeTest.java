package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import perfios.functionality.INRExchange;

class INRExchangeTest {

	@Test
	void testExchangetoinr() throws SQLException {
		var ob = new INRExchange();
		assertEquals(1097.74,ob.exchangetoinr("13084242506",97.74,1.2,"USD"));
	}

}

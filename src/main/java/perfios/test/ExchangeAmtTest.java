package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import perfios.functionality.ExchangeAmt;

class ExchangeAmtTest {

	@Test
	void testExchangeamt() throws RemoteException, SQLException {
		var ob = new ExchangeAmt();
		assertEquals(0.25,ob.exchangeamt("13084242506",1.2,100,"USD"));
	}

}

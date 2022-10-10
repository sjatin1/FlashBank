package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import perfios.functionality.DepositAmt;

class DepositAmtTest {

	@Test
	void testDeposit() throws RemoteException, SQLException {
		var ob = new DepositAmt();
		assertEquals(12100,ob.deposit("13088510579",100));
	}

}

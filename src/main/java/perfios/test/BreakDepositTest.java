package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import perfios.functionality.BreakDeposit;

class BreakDepositTest {

	@Test
	void testBreakDeposit() throws RemoteException, SQLException {
		var ob = new BreakDeposit();
		assertTrue(ob.breakDeposit("13088510579","shoes"));
	}

}

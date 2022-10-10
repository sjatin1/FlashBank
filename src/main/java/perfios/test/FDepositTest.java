package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.jupiter.api.Test;

import perfios.functionality.FDeposit;

class FDepositTest {

	@Test
	void testFDeposit1() throws SQLIntegrityConstraintViolationException, RemoteException, SQLException {
		var ob = new FDeposit();
		assertTrue(ob.fDeposit("13088510579",200,"shoes"));
	}

}

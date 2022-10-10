package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import perfios.functionality.WithdrawAmt;

class WithdrawTest {

	@Test
	void testWithdraw() throws RemoteException, SQLException {
		var ob = new WithdrawAmt();
		assertEquals(12000,ob.withdrawamt("13088510579",100));
	}

}

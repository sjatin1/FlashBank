package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import perfios.functionality.TransferAmt;

class TransferAmtTest {

	@Test
	void testTransfer() throws RemoteException, SQLException {
		var ob = new TransferAmt();
		assertEquals(800,ob.transfer("13084242506","13088510579",100));
	}

}

package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import perfios.functionality.UPITransfer;

class UPITransferTest {

	@Test
	void testUpi() throws RemoteException, SQLException {
		var ob = new UPITransfer();
		assertEquals(600,ob.upi("13084242506","sjatin1308@ybl","navya@ybl",100));
	}

}

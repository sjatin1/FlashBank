package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import perfios.functionality.UpdateAmt;

class UpdateTest {

	@Test
	void testUpdate() throws RemoteException {
		var ob = new UpdateAmt();
		assertTrue(ob.update("phno","13084242506","1234567892"));
	}

}

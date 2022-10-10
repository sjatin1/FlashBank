package perfios.test;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;

import perfios.functionality.Close;

class CloseTest {

	@Test
	void testClose() throws RemoteException {
		var ob = new Close();
		assertTrue(ob.close("13088510579"));
	}

}

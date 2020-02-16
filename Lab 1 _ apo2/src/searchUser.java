import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.*;
class searchUser {

	@Test
	void testExistentId() {
		
		Controling metodos = new Controling();
		int telephone = 9023943;
		metodos.createUser("DNI", "993jd930", "Juan", "Perez", telephone, "Calle 50 # 89-09");
		
		assertEquals("Nonexistent User", false, metodos.verificationId("993jd930"));
		metodos.getUsers().clear();
	}
	
	@Test
	void testNonexistent() {
		Controling metodos = new Controling();
		assertEquals("Existent User", true, metodos.verificationId("993jd930"));

		metodos.getUsers().clear();

	}
	
	

}

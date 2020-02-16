import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.*;


class TestUser {

	@Test
	void testUserNonexistent() {
		
		Controling metodos = new Controling();
		int telephone = 9023943;
		assertEquals("Existing User", "complete", metodos.createUser("DNI", "993jd930", "Juan", "Perez", telephone, "Calle 50 # 89-09"));
		metodos.getUsers().clear();

	}
	@Test 
	void testExistent() {
		
		Controling metodos = new Controling();
		int telephone = 9023943;
		assertEquals("Existent User", "insufficient information", metodos.createUser("DNI", "993jd930", "Juan", "Perez", telephone, "Calle 50 # 89-09"));
		metodos.getUsers().clear();

	}

}

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import model.*;

class TestTurn {

	@Test
	void testNonexistentTurn() {

		Controling metodos = new Controling();
		
		metodos.addTurn("993jd930");
		
		assertEquals("the User haven´t turn", "id existent on turn", metodos.addTurn("993jd930"));
		
		metodos.getTurns().clear();
	}

	@Test
	void testExistentTurn() {

		Controling metodos = new Controling();		
		assertEquals("the User have turn", "a new shift was added", metodos.addTurn("993jd930"));
		
		metodos.getTurns().clear();
	}
	
}

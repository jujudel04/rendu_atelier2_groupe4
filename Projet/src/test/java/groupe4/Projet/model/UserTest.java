package groupe4.Projet.model;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import groupe4.Projet.Model.User;

@RunWith(SpringRunner.class)
public class UserTest {
	private List<String> stringList;
	private List<Integer> intList;

	@Before
	public void setUp() {
		System.out.println("[BEFORE TEST] -- Add Hero to test");
		stringList = new ArrayList<String>();
		intList = new ArrayList<Integer>();
		stringList.add("normalString1");
		stringList.add("normalString2");
		stringList.add(";:!;!::!;;<>");
		intList.add(5);
		intList.add(500);
		intList.add(-1);
	}

	@After
	public void tearDown() {
		System.out.println("[AFTER TEST] -- CLEAN hero list");
		stringList = null;
		intList = null;
	}

	@Test
	public void createUser() {
		for(String msg:stringList) {
			for(String msg2:stringList) {
				for(String msg3:stringList) {
					for(Integer msg4:intList) {
						User h=new User(msg4, msg, msg2, msg3);
						System.out.println("msg:"+msg+", msg2:"+msg2+", msg3:"+msg3+", msg4:"+msg4);
						assertTrue(h.getId() == msg4);
						assertTrue(h.getName() == msg);
						assertTrue(h.getLogin() == msg2);
						assertTrue(h.getPasswd() == msg3);
						h.setId(msg4+1);
						assertTrue(h.getId() == (msg4+1));
						h.setName(msg2);
						assertTrue(h.getName() == msg2);
						h.setLogin(msg3);
						assertTrue(h.getLogin() == msg3);
						h.setPasswd(msg);
						assertTrue(h.getPasswd() == msg);
					}	
				}	
			}
		}
	}
	
}

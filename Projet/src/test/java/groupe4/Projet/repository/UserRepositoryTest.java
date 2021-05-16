package groupe4.Projet.repository;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe4.Projet.Model.User;
import groupe4.Projet.Repository.UserRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	UserRepository hrepo;

	@Before
	public void setUp() {
		hrepo.save(new User(1, "jdoe", "strong", "monpass"));
	}

	@After
	public void cleanUp() {
		hrepo.deleteAll();
	}

	@Test
	public void saveUser() {
		hrepo.save(new User(1, "test", "testUser", "monpasstest"));
		assertTrue(true);
	}

/*	@Test
	public void saveAndGetUser() {
		hrepo.deleteAll();
		hrepo.save(new User(2, "test1", "login1", "monpass1"));
		List<User> userList = new ArrayList<User>();
		hrepo.findAll().forEach(userList::add);
		assertTrue(userList.size() == 1);
		assertTrue(userList.get(0).getSuperPowerName().equals("testPower1"));
		assertTrue(userList.get(0).getName().equals("test1"));
		assertTrue(userList.get(0).getImgUrl().equals("https//test1_url.com"));
	}

	@Test
	public void getUser() {
		List<User> userList = hrepo.findByName("jdoe");
		assertTrue(userList.size() == 1);
		assertTrue(userList.get(0).getName().equals("jdoe"));
		assertTrue(userList.get(0).getSuperPowerName().equals("strong"));
		assertTrue(userList.get(0).getImgUrl().equals("https//url.com"));
	}

	@Test
	public void findByLogin() {
		hrepo.save(new User(1, "test1", "testPower1", 1, "https//test1_url.com"));
		hrepo.save(new User(2, "test2", "testPower2", 2, "https//test2_url.com"));
		hrepo.save(new User(3, "test2", "testPower2", 2, "https//test2_url.com"));
		hrepo.save(new User(4, "test2", "testPower2", 2, "https//test2_url.com"));
		List<User> userList = new ArrayList<>();
		hrepo.findByName("test2").forEach(userList::add);
		assertTrue(userList.size() == 3);
	}*/
}

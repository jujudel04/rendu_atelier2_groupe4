package groupe4.Projet.service;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import groupe4.Projet.Model.User;
import groupe4.Projet.Repository.UserRepository;
import groupe4.Projet.Service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserService.class)
public class UserServiceTest {

	@Autowired
	private UserService hService;

	@MockBean
	private UserRepository hRepo;
/*	
	User tmpUser=new User(1, "jdoe", "strong", 100, "https//url.com");
	
	@Test
	public void getUser() {
		Mockito.when(
				hRepo.findById(Mockito.any())
				).thenReturn(Optional.ofNullable(tmpUser));
		Hero heroInfo=hService.getUser(45);
		assertTrue(heroInfo.toString().equals(tmpUser.toString()));
	}
	
	@Test
	public void signup() {
		Mockito.when(
				hRepo.findById(Mockito.any())
				).thenReturn(Optional.ofNullable(tmpUser));
		Hero heroInfo=hService.signup("log", "pass");
		assertTrue(heroInfo.toString().equals(tmpUser.toString()));
	}
	*/
}


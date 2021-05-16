package groupe4.Projet.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe4.Projet.Model.Card;
import groupe4.Projet.Model.User;
import groupe4.Projet.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public static List<Integer> authenticateUser = new ArrayList<Integer>();

	public static void autorizeUser(Integer userid) {
		UserService.authenticateUser.add(userid);
	}

	public static boolean isAuthenticate(int id) {
		return UserService.authenticateUser.contains(id);
	}

	UserService() {
	}

	public void saveUser(User h) {
		userRepository.save(h);
	}

	public Integer signup(String login, String passwd) {
		List<User> users = userRepository.findByLogin(login);
		for (User user : users) {
			if (user.getPasswd().equals(passwd)) {
				UserService.autorizeUser(user.getId());
				return user.getId();
			}
		}
		return null;
	}

	public User getUser(int id) {
		Optional<User> hOpt = userRepository.findById(id);
		if (hOpt.isPresent()) {
			return hOpt.get();
		}
		return null;
	}

	public void addCard(Card card, Integer userId) {
		User user = this.getUser(userId);
		if (user != null) {
			user.addCard(card.getId());
			user.updateBalance(-card.getPrice());
			// for test
			List<Integer> cs = user.getUserCardList();
			this.saveUser(user);
		}
	}

	public void removeCard(Card card, Integer userId) {
		User user = this.getUser(userId);
		if (user != null) {
			user.removeCard(card.getId());
			user.updateBalance(+card.getPrice());
			this.saveUser(user);
		}
	}
}

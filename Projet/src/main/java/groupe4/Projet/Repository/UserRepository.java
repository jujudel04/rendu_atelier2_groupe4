package groupe4.Projet.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import groupe4.Projet.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByLogin(String login);

}

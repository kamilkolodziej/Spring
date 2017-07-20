package pl.kolodziej.kamil.usermanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.kolodziej.kamil.usermanager.domain.User;
import pl.kolodziej.kamil.usermanager.domain.UserGroup;
import pl.kolodziej.kamil.usermanager.repository.UserGroupRepository;
import pl.kolodziej.kamil.usermanager.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserGroupRepository userGroupRepository;
	
	@Test
	public void addUser() {
		
		User user = new User();
		user.setId(1L);
		user.setFisrtName("Artur");
		user.setSecondName("Kolodziej");
		
		userRepository.save(user);
	}
	
	@Test
	public void addUserGroup() {
		
		UserGroup group = new UserGroup();
		group.setId(1L);
		group.setName("Runners");
		userGroupRepository.save(group);
	}

}

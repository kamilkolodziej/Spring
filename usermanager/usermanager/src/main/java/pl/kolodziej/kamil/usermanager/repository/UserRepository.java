package pl.kolodziej.kamil.usermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import pl.kolodziej.kamil.usermanager.domain.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

}

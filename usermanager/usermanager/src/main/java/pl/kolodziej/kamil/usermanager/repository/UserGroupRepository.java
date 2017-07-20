package pl.kolodziej.kamil.usermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.kolodziej.kamil.usermanager.domain.UserGroup;

@RepositoryRestResource
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

}

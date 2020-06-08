package org.launchcode.tattoo_finder.models.data;

import org.launchcode.tattoo_finder.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}

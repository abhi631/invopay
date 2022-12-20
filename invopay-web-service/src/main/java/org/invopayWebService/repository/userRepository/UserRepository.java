package org.invopayWebService.repository.userRepository;

import org.invopayWebService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer > {
}

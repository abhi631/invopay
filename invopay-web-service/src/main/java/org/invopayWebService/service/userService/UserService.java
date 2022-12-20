package org.invopayWebService.service.userService;

import com.commons.ObjectMapperUtil;
import com.commons.webDTOS.user.UserDTO;
import org.invopayWebService.model.User;
import org.invopayWebService.repository.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registration(UserDTO userDTO){
        User user = ObjectMapperUtil.copyPropertiesByMapper(userDTO , User.class);
        userRepository.save(user);
        return user;
    }
}

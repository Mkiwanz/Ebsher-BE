package project.ebsher.Service;


import project.ebsher.Entity.User;
import project.ebsher.Entity.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    UserDto findById(long id);
    void update(UserDto users);
    void deleteUser(long id);
    User findAllByEmail(String email);

}

package project.ebsher.Service.Impl;


import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.ebsher.Entity.User;
import project.ebsher.Entity.dto.UserDto;
import project.ebsher.Repository.UserRepo;
import project.ebsher.Service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;
    private final ModelMapper mapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, ModelMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<UserDto> findAllUsers() {
        return userRepo.findAll().stream()
                .map(u -> mapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(long id) {
        return mapper.map(userRepo.findById(id).orElse(null), UserDto.class);
    }


    @Override
    public void update(UserDto user) {
        userRepo.save(mapper.map(user, User.class));
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User findAllByEmail(String email) {
        return userRepo.findAllByEmail(email);
    }


}

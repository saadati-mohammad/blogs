package blogs.modules.users.service;

import blogs.modules.users.model.Users;
import blogs.modules.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users registerUser(Users users) {
        return this.usersRepository.save(users);
    }

    public List<Users> findAllUsers() {
        return this.usersRepository.findAll();
    }

    public Optional<Users> findUserById(Long id){
        return usersRepository.findById(id);
    }
}

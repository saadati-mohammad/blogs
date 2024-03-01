package blogs.modules.users.controller;

import blogs.modules.users.model.Users;
import blogs.modules.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public List<Users> getUsers() {
        return this.usersService.findAllUsers();
    }

    @RequestMapping(value = {"/",""}, method = RequestMethod.POST)
    public Users registerUser(@RequestBody Users users){
        return this.usersService.registerUser(users);
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public Optional<Users> getUserById(@RequestParam Long id){
        return this.usersService.findUserById(id);
    }
}

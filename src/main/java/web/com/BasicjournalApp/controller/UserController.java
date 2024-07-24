package web.com.BasicjournalApp.controller;
import org.springframework.web.bind.annotation.RestController;
import web.com.BasicjournalApp.entity.User;
import web.com.BasicjournalApp.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/user")
// shyam id:-8c3db5c0-17b1-49e8-ae85-f8a5354b9a8f


public class UserController{
@Autowired
UserService userService;
@GetMapping("/GetUser")
public List<User> getALlUser() {
    return userService.getUsersList();
}

@PostMapping("/CreateUser")
public String postMethodName(@RequestBody User entity) {
    return userService.PostUserData(entity);
}

@PutMapping("/updateUser/{id}")
public String updateUser(@PathVariable String id, @RequestBody User entity) {
    return userService.updateUser(id, entity);
}

@GetMapping("/findParticularDataUser/{id}")
public User findParticularDataUser(@PathVariable String id) {
    return userService.getSingleUserData(id);
}

@DeleteMapping("/deletejournal/{id}")
public String  deleteJournal(@PathVariable String id){
    return userService.DeleteUser(id);
}


}
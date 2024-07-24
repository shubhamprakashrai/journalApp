package web.com.BasicjournalApp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web.com.BasicjournalApp.entity.User;
import web.com.BasicjournalApp.serviceimplementation.UserServiceImplemetation;

@Component
public class UserService {
    @Autowired
    UserServiceImplemetation userServiceImplemetation;
    public List<User> getUsersList(){
        return userServiceImplemetation.getAllUserData();
    }

    public String PostUserData(User user){
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }
        return userServiceImplemetation.saveUser(user);
    }

    public String DeleteUser(String id){
       return userServiceImplemetation.deleteSaveUser(id);
    }

    public String updateUser(String id, User entityUser){
        return userServiceImplemetation.updateUser(id, entityUser);
    }

    public User getSingleUserData(String id)
    {
        return userServiceImplemetation.findPartiCularDataUser(id);
    }

}

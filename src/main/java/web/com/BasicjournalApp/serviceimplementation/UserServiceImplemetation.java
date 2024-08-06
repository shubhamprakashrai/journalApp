package web.com.BasicjournalApp.serviceimplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web.com.BasicjournalApp.entity.User;
import web.com.BasicjournalApp.repository.UserRepository;

@Component
public class UserServiceImplemetation {
    @Autowired
    UserRepository useRepository;
    
     public List<User> getAllUserData(){
      return useRepository.findAll();
    }

    public String saveUser(User user){
        try {
        useRepository.save(user);
        return "User Save Successfully";
        } catch (Exception e) {
           return "User Save UnSuccessfully";
        }
    }

    public String deleteSaveUser(String id){
        try {
            useRepository.deleteById(id);
            return "Delete User Successfully";
        } catch (Exception e) {
           return "Delete User UnSuccessfully";
        }
    }

    public String updateUser(String id, User userDetails) {
        try {
            User exestingUser=useRepository.findById(id).get();
            exestingUser.setEmail(userDetails.getEmail());
            exestingUser.setUsername(userDetails.getUsername());
            useRepository.save(exestingUser);
            return "User updated successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating user: " + e.getMessage();
        }
    }
    public User findPartiCularDataUser(String id)
    {
        try {
            return useRepository.findById(id).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public User findByUsername(String username) {
        return useRepository.findByUsername(username);
    }
}

package web.com.BasicjournalApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.com.BasicjournalApp.entity.User;
@Repository
public interface UserRepository  extends JpaRepository<User,String>{
    User findByUsername(String UserName);
}

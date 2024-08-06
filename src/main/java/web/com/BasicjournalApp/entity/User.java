package web.com.BasicjournalApp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    private String id;
    @NonNull
    private String username;
    private String email;
    private String password;
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore 
    private List<journalEntity> journals;
    private List<String> roles;
}

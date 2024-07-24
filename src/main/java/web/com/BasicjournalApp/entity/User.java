package web.com.BasicjournalApp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String username;
    private String email;
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore 
    private List<journalEntity> journals;
}

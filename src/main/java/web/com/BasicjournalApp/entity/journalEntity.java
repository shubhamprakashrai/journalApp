package web.com.BasicjournalApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="journal_db")
public class journalEntity {
    @Id
    private String id;
    private String title;
    private String content;
    private String date;
    @ManyToOne
    private User user;
}

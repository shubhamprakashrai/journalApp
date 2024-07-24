package web.com.BasicjournalApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.com.BasicjournalApp.entity.journalEntity;

@Repository
public interface JournalEntryReposatory extends JpaRepository<journalEntity, String> {
    List<journalEntity> findByUserId(String userId);
    void deleteByUserIdAndId(String userId, String id);
}

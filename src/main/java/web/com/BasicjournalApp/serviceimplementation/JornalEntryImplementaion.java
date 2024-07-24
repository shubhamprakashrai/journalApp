package web.com.BasicjournalApp.serviceimplementation;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.com.BasicjournalApp.entity.journalEntity;
import web.com.BasicjournalApp.repository.JournalEntryReposatory;

@Component
public class JornalEntryImplementaion {
    @Autowired
    JournalEntryReposatory journalEntriesrepostitory;
    public void save(journalEntity journalEntity){
    journalEntity journalEntityObj=new journalEntity();
      BeanUtils.copyProperties(journalEntity, journalEntityObj);
      journalEntriesrepostitory.save(journalEntityObj);
    }

    public List<journalEntity> getAllJournal(){
        //  List<journalEntity> journalEntityList=new ArrayList<>();
       return journalEntriesrepostitory.findAll();
    }

    public String deleteItem(String id){
        try {
            journalEntriesrepostitory.deleteById(id);
            return "Delete successful";
        } catch (Exception e) {
            return "Error deleting journal entry: " + e.getMessage();
        }
    }

    public String updateItem(String id, journalEntity journalEntityDetailsObj){
        try {
            journalEntity exestingEmEntity=journalEntriesrepostitory.findById(id).get();
            exestingEmEntity.setContent(journalEntityDetailsObj.getContent());
            exestingEmEntity.setTitle(journalEntityDetailsObj.getTitle());
            journalEntriesrepostitory.save(exestingEmEntity);
          return "Update journal entry Successfully";
        } catch (Exception e) {
            return "Error Update journal entry: " + e.getMessage();
        }
    }
   
    public List<journalEntity> getJornalByUser(String userId) {
        return journalEntriesrepostitory.findByUserId(userId);
    }
}

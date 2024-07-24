package web.com.BasicjournalApp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.com.BasicjournalApp.entity.journalEntity;
import web.com.BasicjournalApp.serviceimplementation.JornalEntryImplementaion;

@Component
public class JornalEntryService {
    @Autowired
    JornalEntryImplementaion jornalEntryImplementaion;

    public void saveEntry(journalEntity journalEntity) {
        if (journalEntity.getId() == null || journalEntity.getId().isEmpty()) {
            journalEntity.setId(UUID.randomUUID().toString());
        }
        jornalEntryImplementaion.save(journalEntity);
    }

    public List<journalEntity> getJournal(){
        //  List<journalEntity> journalEntityList=new ArrayList<>();
       return jornalEntryImplementaion.getAllJournal();
    }

    public String deleteEntry(String id){
       return jornalEntryImplementaion.deleteItem(id);

    }

    public String updateEntry(String id, journalEntity journalEntityObj){
        
        return jornalEntryImplementaion.updateItem(id, journalEntityObj);
    }

    public List<journalEntity> getJournalsByUserId(String id){
        return jornalEntryImplementaion.getJornalByUser(id);
    }
}

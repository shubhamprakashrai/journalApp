package web.com.BasicjournalApp.controller;

// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.com.BasicjournalApp.entity.journalEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping({"/home"})

public class jornalcontroller {
    private Map<String,journalEntity> journalEntries=new HashMap<>();
    @GetMapping("/getjournal")
    public List<journalEntity> getAll(){
       return new ArrayList<>(journalEntries.values());
    }

    @PostMapping("/postjournal")
    public ResponseEntity<journalEntity> CreateJournal(@RequestBody journalEntity journalEntityObj){
        String id = UUID.randomUUID().toString();
        journalEntityObj.setId(id);
        journalEntries.put(id,journalEntityObj);
        return new ResponseEntity<>(journalEntityObj, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletejournal/{id}")
    public ResponseEntity<Void> deleteJournal(@PathVariable String id){
        journalEntity journalEntity = journalEntries.remove(id);
        if (journalEntity != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/Updatejournal/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody journalEntity journalEntityDetailsObj) {
        journalEntity journalEntity = journalEntries.get(id);
        if (journalEntity != null) {
            journalEntity.setTitle(journalEntityDetailsObj.getTitle());
            journalEntity.setContent(journalEntityDetailsObj.getContent());
            journalEntries.put(id, journalEntity);
            return "Update Successfully";
        } else {
            return "Item Not Found";
        }
        
    }
    

}


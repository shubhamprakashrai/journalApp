package web.com.BasicjournalApp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.com.BasicjournalApp.entity.journalEntity;
import web.com.BasicjournalApp.service.JornalEntryService;

@RestController
@RequestMapping({"/Jornal"})
public class jornaldatebasecontroller {
    @Autowired
    private JornalEntryService  jornalEntryService;
    @GetMapping("/getjournal")
    public List<journalEntity> getAll(){
       return jornalEntryService.getJournal();
    }

    @PostMapping("/postjournal")
    public boolean CreateJournal(@RequestBody journalEntity journalEntityObj){
        jornalEntryService.saveEntry(journalEntityObj);
        return true;
    }
    @GetMapping("/getUserJournals/{userId}")
    public List<journalEntity> getUserJournals(@PathVariable String userId) {
        return jornalEntryService.getJournalsByUserId(userId);
    }
    
    @DeleteMapping("/deletejournal/{id}")
    public String  deleteJournal(@PathVariable String id){
        System.out.println(id);
        return jornalEntryService.deleteEntry(id);
    }

    @PutMapping("/Updatejournal/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody journalEntity journalEntityDetailsObj) {
        return jornalEntryService.updateEntry(id,journalEntityDetailsObj);
    }
    
}

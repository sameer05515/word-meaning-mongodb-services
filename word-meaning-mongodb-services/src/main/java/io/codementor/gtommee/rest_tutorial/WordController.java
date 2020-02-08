package io.codementor.gtommee.rest_tutorial;


import io.codementor.gtommee.rest_tutorial.models.Word;
import io.codementor.gtommee.rest_tutorial.repositories.WordsRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {
  @Autowired
  private WordsRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Word> getAllWordi() {
    return repository.findAll();
  }
  
  @RequestMapping(value = "/count", method = RequestMethod.GET)
  public long getCount() {
    return repository.count();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Word getPetById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyPetById(@PathVariable("id") String id, @Valid @RequestBody Word Word) {
    Word.set_id(id);
    Word.setLastModified(new Date());
    repository.save(Word);
  }
  
  @RequestMapping(value = "/{id}/markRead", method = RequestMethod.PUT)
  public void markRead(@PathVariable("id") String id, @Valid @RequestBody Word Word) {
    Word.set_id(id);
    Word.setLastRead(new Date());
    Word.addReadHistory(new Date());
    repository.save(Word);
  }
  
  @RequestMapping(value = "/{id}/addTag", method = RequestMethod.PUT)
  public void addTag(@PathVariable("id") String id,@PathVariable("tag") String tag, @Valid @RequestBody Word Word) {
    Word.set_id(id);
    Word.setLastModified(new Date());
    Word.addTag(tag);
    repository.save(Word);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Word createPet(@Valid @RequestBody Word Word) {
    Word.set_id(ObjectId.get().toHexString());
    Word.setCreatedDate(new Date());
    repository.save(Word);
    return Word;
  }
  
  @RequestMapping(value = "/multi", method = RequestMethod.POST)
  public List<Word> createPet(@Valid @RequestBody List<Word> Wordilist) {
	  for(Word Word:Wordilist){
		  Word.set_id(ObjectId.get().toHexString());
		  Word.setCreatedDate(new Date());
		    repository.save(Word);
	  }
    
    return Wordilist;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}
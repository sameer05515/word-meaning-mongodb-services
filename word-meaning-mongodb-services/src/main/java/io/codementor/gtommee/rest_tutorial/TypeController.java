package io.codementor.gtommee.rest_tutorial;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.codementor.gtommee.rest_tutorial.models.Type;
import io.codementor.gtommee.rest_tutorial.repositories.TypeRepository;

@RestController
@RequestMapping("/types")
public class TypeController {
  @Autowired
  private TypeRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Type> getAllTypei() {
    return repository.findAll();
  }
  
  @RequestMapping(value = "/count", method = RequestMethod.GET)
  public long getCount() {
    return repository.count();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Type getPetById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
  }
  
//  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//  public void modifyPetById(@PathVariable("id") String id, @Valid @RequestBody Type Type) {
//    Type.set_id(id);
//    Type.setLastModified(new Date());
//    repository.save(Type);
//  }
//  
//  @RequestMapping(value = "/{id}/markRead", method = RequestMethod.PUT)
//  public void markRead(@PathVariable("id") String id, @Valid @RequestBody Type Type) {
//    Type.set_id(id);
//    Type.setLastRead(new Date());
//    Type.addReadHistory(new Date());
//    repository.save(Type);
//  }
//  
//  @RequestMapping(value = "/{id}/addTag", method = RequestMethod.PUT)
//  public void addTag(@PathVariable("id") String id,@PathVariable("tag") String tag, @Valid @RequestBody Type Type) {
//    Type.set_id(id);
//    Type.setLastModified(new Date());
//    Type.addTag(tag);
//    repository.save(Type);
//  }
//  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Type createPet(@Valid @RequestBody Type Type) {
    Type.set_id(ObjectId.get().toHexString());
    Type.setCreatedDate(new Date());
    repository.save(Type);
    return Type;
  }
  
  @RequestMapping(value = "/multi", method = RequestMethod.POST)
  public List<Type> createPet(@Valid @RequestBody List<Type> Typeilist) {
	  for(Type Type:Typeilist){
		  Type.set_id(ObjectId.get().toHexString());
		  Type.setCreatedDate(new Date());
		    repository.save(Type);
	  }
    
    return Typeilist;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}
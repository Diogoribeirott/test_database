package service;

import java.util.List;

import dominio.Produce;
import repository.ProducerRepository;

public class ProcudeService {
  public static void save(Produce Produce){
    ProducerRepository.save(Produce);
  }
  
  public static void delete(Integer id){
      RequireValidID(id);
      ProducerRepository.Delete(id);
    }


  public static void Update(Produce produce){
    RequireValidID(produce.getId());
    ProducerRepository.Update(produce);
  }
  
  public static List<Produce> findAll(){
    return ProducerRepository.findAll();
  }

   public static List<Produce> findByName(String name){
    return ProducerRepository.findByName(name);
  }

  public static void showProduceAll(){
    ProducerRepository.showProduceAll();
  }

  public static void RequireValidID(Integer id){
    if(id == null || id <= 0){
      throw new IllegalArgumentException("Error while to insert value id");
    }

  }
};
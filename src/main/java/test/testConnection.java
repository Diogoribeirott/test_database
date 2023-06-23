package test;


import java.util.List;
import dominio.Produce;
import service.ProcudeService;


public class testConnection {
  public static void main(String[] args) {
    
     Produce build = Produce.ProducerBuilder
        .Build()
        .idBuild(3)
        .nameBuilder("sbt")
        .build();
    
        List<Produce> producers = ProcudeService.findAll();

        for (Produce produce : producers) {
          System.out.println(produce);
          
        }

        System.out.println(producers);
        

        ProcudeService.showProduceAll();
      

  }
    
}
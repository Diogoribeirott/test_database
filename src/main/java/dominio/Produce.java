package dominio;


public class Produce {
    private Integer id;
    private String name;


   public static  class ProducerBuilder{
      private Integer id;
      private String name;

      public static ProducerBuilder Build(){
        return new ProducerBuilder();
      }

      public ProducerBuilder idBuild(Integer id){
        this.id = id;
        return this;
      }   

      public ProducerBuilder nameBuilder(String name){
        this.name =name;
        return this;
      }

      public Produce build(){
        Produce produce = new Produce();
        produce.id= this.id;
        produce.name= this.name;

        return produce;
      }
        
      

   }


  @Override
  public String toString() {
    return "Produce id=" + id + ", name=" + name + "";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Produce other = (Produce) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }


  public Integer getId() {
    return id;
  }


  public String getName() {
    return name;
  }
    
}
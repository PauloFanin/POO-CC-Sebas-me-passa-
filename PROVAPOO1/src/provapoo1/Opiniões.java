
package provapoo1;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Opiniões {
    private Avaliação[] avaliacao;

    public Opiniões(Avaliação[] avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    private List<Avaliação> procurarporID(int elementoporid){
        List<Avaliação> listavaliação = new ArrayList<>();
        int identID = elementoporid;
        for (Avaliação avaliação : avaliacao){
            if(avaliação.getSerial()== identID)
            {
                listavaliação.add(avaliação);
            }
        }
        return listavaliação;
    }
    
    public double mediafilme(int elementoporID){
        double media =0;
        int identID = elementoporID, total =0;
        for (Avaliação avaliação : avaliacao){
            if(avaliação.getSerial()== identID){
                media += avaliação.getNota();
                total++;
            }
        }
        return media / total;
           
    }
    public Avaliação maiornota(int elementoporID){
       List listavaliação = procurarporID(elementoporID);
        Collections.sort(listavaliação, (Avaliação a, Avaliação b) -> {
            if(a.getNota()  > b.getNota()) return 1;
            else if (a.getNota() < b.getNota()) return -1;
            return 0;
        });
                
           return ((Avaliação) listavaliação.get(listavaliação.size()-1));
        
    }
      public Avaliação piornota(int elementoporID){
          List listavaliação = procurarporID(elementoporID);
        
          Collections.sort(listavaliação,(Avaliação a, Avaliação b) -> {
              if(a.getNota()> b.getNota()) return -1;
              else if ( a.getNota()< b.getNota()) return 1;
              return 0;
          });
          return ((Avaliação) listavaliação.get( listavaliação.size()-1));
      }      
    

    public Avaliação[] getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliação[] avaliacao) {
        this.avaliacao = avaliacao;
    }
 
}      

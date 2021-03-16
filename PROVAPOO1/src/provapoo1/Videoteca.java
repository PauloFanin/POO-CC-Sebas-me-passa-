
package provapoo1;


public class Videoteca {
    private Filme [] filmes;
    
    public int procurafilme(String nomefilmes){
        int procfilme = 0 , procsinopse = 0, vetorposi = -1;
        
            for (int proc = 0; proc< filmes.length; proc ++)
            {
                procfilme=filmes[proc].getNome().indexOf(nomefilmes);
                
                procsinopse=filmes[proc].getSinopse().indexOf(nomefilmes);
                
                    if(procfilme>=0 || procsinopse >=0)
                    {
                        vetorposi = proc;
                        break;
                    }
                }   
                return vetorposi;
            }
            
             public String[]getAllTodosFilmes(){
                 int tamanhoFilme=filmes.length;
                 
                 String[] nomes = new String[tamanhoFilme];
                 
                 for(int proc=0; proc<tamanhoFilme;proc++){
                    nomes[proc]=filmes[proc].getNome();
                 }
                    return nomes;
                }

    public Videoteca(Filme[] filmes) {
        this.filmes = filmes;
    }

    public Filme[] getFilmes() {
        return filmes;
    }

    public void setFilmes(Filme[] filmes) {
        this.filmes = filmes;
    }
             
            
            }
                     
                  


    


package provapoo1;



public class PROVAPOO1 {
   
    

   
    public static void main(String[] args) {
        MenuPrincipal rapaduracast = new MenuPrincipal();
        rapaduracast.setResizable(false);
        rapaduracast.setVisible(true);
        
        
        
        
        
        Filme filme1 = new Filme(1001, "Cinderela Baiana", "comédia", "Numa"
                + " cidade da região metropolitana de Salvador, Bahia, vive uma"
                + " família humilde.");
        Filme filme2 = new Filme(1034, "Birdemic: Shock and Terror", "terror",""
                + "Rod (Alan Bagh ) é um vendedor de software novo que vive uma"
                + " vida de sucesso no Vale do Silício."); 
        Filme filme3 = new Filme (1342, "Um Dia de Fúria", "ação", "Martin "
                + "Prendergast (Robert Duvall) é um policial no seu último dia"
                + " de trabalho antes de se aposentar.");
               
        filme1.filmestatus();
        
        Avaliação ava1 = new Avaliação(12331, "Zédroguinha", 1, "excelente");
        ava1.critica();
        
        Avaliação ava2 = new Avaliação (12313, "zezimTransão", 7, "axé mamãe");
        ava2.critica();
        
        Avaliação ava3 = new Avaliação( 21332, "Ana", 9, "virei dançarina");
        ava3.critica();
        
        Avaliação ava4 = new Avaliação(12543,"juão", 10,"quero meu kamipássaro");
        ava4.critica();
        
        Avaliação ava5 = new Avaliação(12312, "pedrim", 3, "odeio pássaros");
        ava5.critica();
        
        Avaliação ava6 = new Avaliação (12321, "Antony", 9, "já quero uma continuação");
        ava6.critica();
        
        Avaliação ava7 = new Avaliação(31231, "Sonic", 9,"mais rápido que eu ");
        ava7.critica();
        
        Avaliação ava8 = new Avaliação(35431, "André", 10, "um dia irei fazer igual");
        ava8.critica();
        
        Avaliação ava9 = new Avaliação(38731, "José", 3, "sangue de jeus tem poder");        
        ava9.critica();        
    }
    
}

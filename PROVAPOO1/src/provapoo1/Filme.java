
package provapoo1;


public class Filme {
    private int codigo;
    private String nome;
    private String genero;
    private String sinopse;

    public Filme(int codigo, String nome, String genero, String sinopse) {
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    public void filmestatus(){
        System.out.println("código: " + this.getCodigo());
        System.out.println("título: " + this.getNome() );
        System.out.println("gênero: " + this.getGenero());
        System.out.println("sinopse: " + this.getSinopse());
    }
}

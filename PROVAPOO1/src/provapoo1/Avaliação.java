
package provapoo1;


public class Avaliação {
    private int serial; 
    private String usuario;
    private int nota;
    private String comentario;

    public Avaliação(int serial, String usuario, int nota, String comentario) {
        this.serial = serial;
        this.usuario = usuario;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public void critica (){
        System.out.println("serial: " + this.getSerial());
        System.out.println("usuário: " + this.getUsuario());
        System.out.println("nota: " + this.getNota());
        System.out.println("comentário: " + this.getComentario());
        
    }
}

package Clases.Modelos;
public class Usuario {
    private String Nombre;
    private String Email;
    private long Telefono;


    public Usuario(String Nombre, String Email, Long Telefono) {
        this.Nombre = Nombre;
        this.Email = Email;
        this.Telefono = Telefono;
    }
    public String getNombre(){
        return Nombre;
    }

    public String getEmail(){
        return Email;
    }

    public long getPhone(){
        return Telefono;
    }

    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public void setPhone(int Phone){
        this.Telefono = Phone;
    }
}

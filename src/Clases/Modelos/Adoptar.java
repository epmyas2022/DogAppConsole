package Clases.Modelos;

public class Adoptar {
    private String Name;
    private String Phone;
    private String Email;
    private String NameDog;
    private String Status = "Pendiente";
    
    
    public void setName(String name){
        this.Name = name;
    }
    
    public void setPhone(String phone){
        this.Phone = phone;
    }
    
    public void setEmail(String mail){
        this.Email = mail;
    }
    
    public void setNameDog(String value){
        this.NameDog = value;
    }
    public void setStatus(String status){
        this.Status = status;
    }
}

package Clases;


import Clases.Modelos.Perro;
import Clases.Modelos.Usuario;

public class Funciones extends Guardar {
    private static String ClaveApi = "XfxtgFocNC7nrPFEa4LEnQ==yIQHymIObl5hXq6E";
    private static String UrlApiPerros = "https://api.api-ninjas.com/v1/dogs?name=";

    private static String UrlAdopcion = "https://sheet.best/api/sheets/8b724225-5b64-4404-89e6-4aa6cc545444";

    public static void Adoptar(String name) {

        try {

            var data = new Clases.Modelos.Adoptar();

            var nombre = LeerPropiedad("Usuario", "Nombre");
            var email = LeerPropiedad("Usuario", "Email");
            var telefono = LeerPropiedad("Usuario", "Telefono");

            data.setName(nombre);
            data.setEmail(email);
            data.setPhone(telefono);
            data.setNameDog(name);
            Ajax.setDataPost(data);

            Ajax.Fetch(UrlAdopcion, "", Ajax.Method_POST);

            System.out.println(Color.COLOR_GREEN + "=========================================");
            System.out.println(Color.COLOR_GREEN + "| Su solicitud de adopcion fue enviada |");
            System.out.println(Color.COLOR_GREEN + "=========================================");
        } catch (Exception e) {
            System.out.println(e);
        }
    };

    public static void CargarInfoPerro(String name) {

        name = name.replace(" ", "&");
        try {
            var i = 0;

            Ajax.SetModel(Perro.class);

            Ajax.Fetch(UrlApiPerros + name, ClaveApi, Ajax.Method_GET);

            var perros = Ajax.getResponse();

            for (var perro : perros) {
                i += 1;
                System.out.println("");
                var ObjectoPerro = (Perro) perro;
              

                System.out.println(Color.COLOR_GREEN + "[" + i + "] " + ObjectoPerro.GetName());
                
                System.out.println(Color.COLOR_PURPLE);

                System.out.println("=========================================");
                System.out.println("Nombre perro : " + ObjectoPerro.GetName());
                System.out.println("Imagen perro : " + ObjectoPerro.GetImage());
                System.out.println("Vida maxima perro : " + ObjectoPerro.GetMaxLife());
                System.out.println("Vida minima perro : " + ObjectoPerro.GetMinLife());
                System.out.println("Energia perro : " + ObjectoPerro.GetEnergy());
                System.out.println("Entrenabilidad perro : " + ObjectoPerro.GetTrainability());
                System.out.println("Proteccion perro : " + ObjectoPerro.GetProtectiveness());
                System.out.println("");

            }

        } catch (Exception e) {
            System.out.println("Error al cargar la lista de perros");
        }

    }

    public static void RegistrarUsuario(String nombre, String correo, Long telefono) {
        try {
            CrearArchivo("Usuario", new Usuario(nombre, correo, telefono));
            System.out.println(Color.COLOR_GREEN + "====================================");
            System.out.println(Color.COLOR_GREEN + "| Usuario registrado correctamente |");
            System.out.println(Color.COLOR_GREEN + "====================================");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
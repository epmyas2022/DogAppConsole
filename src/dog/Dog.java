/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dog;

/**
 *
 * @author Isaac
 */
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import Clases.*;
public class Dog extends Funciones{

    public static void main(String[] args) {

        LimpiarPantalla();

        boolean menu = false;

        Scanner sc = new Scanner(System.in);

        while (!menu) {

            var opc = 1;
            CargarBanner("src/dog/banner.txt");

            System.out.println(Color.COLOR_PURPLE + "1. Adoptar perro");
            System.out.println("2. Registrame");
            System.out.println("3. Salir");

            System.out.print(Color.COLOR_RED + "Elige una opcion: ");

            opc = sc.nextInt();

            if (opc == 1) {
                AdoptarPerro();
            }
            if (opc == 2) {
                Registrame();
            }
            if (opc == 3) {
                Salir();
                menu = true;
                sc.close();
            }

        }

    }

    private static void AdoptarPerro() {
        LimpiarPantalla();

        System.out.println("Adoptar perro");

        String[] razas = {"Beagle", "Bulldog", "Chihuahua", "Golden Retriever", "Labrador", "Rottweiler",
            "Husky", "Schnauzer", "Bracco", "Chow"};

        for (int i = 0; i < razas.length; i++) {

            System.out.println(Color.COLOR_BLUE + (i + 1) + ". " + razas[i]);

        }

        System.out.println("11. Otro ");

        System.out.print(Color.COLOR_RED + "Elige una raza: ");

        Scanner sc = new Scanner(System.in);

        var raza = sc.nextInt();

        if (raza != 11) {
            CargarInfoPerro(razas[raza - 1]);

        } else {
            System.out.print(Color.COLOR_GREEN + "Escribe la raza: ");
            var razaOtro = sc.next();
            CargarInfoPerro(razaOtro);

        }

        sc = new Scanner(System.in);

        System.out.print(Color.COLOR_YELLOW + "Escribe el nombre del perro a adoptar: ");
        var perro = sc.nextLine();

        Adoptar(perro);

    }

    private static void Registrame() {

        LimpiarPantalla();

        var read = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");

        var nombre = read.nextLine();

        System.out.print("Ingrese su correo: ");
        var correo = read.nextLine();

        System.out.print("Ingrese su telefono: ");
        var telefono = read.nextLong();

        RegistrarUsuario(nombre, correo, telefono);

        System.out.println(" ");

    }

    private static void Salir() {
        System.out.println("Salir");

    }

    private static void CargarBanner(String Ruta) {
        System.out.println("" + Color.COLOR_WHITE);

        Path path = Paths.get(Ruta);

        try {

            var scan = new Scanner(path);

            while (scan.hasNextLine()) {
                var line = scan.nextLine();
                System.out.println(line);
            }

            scan.close();

        } catch (Exception e) {
            System.out.println("Error al cargar el banner");
        }

        System.out.println("");

    }

    private static void LimpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

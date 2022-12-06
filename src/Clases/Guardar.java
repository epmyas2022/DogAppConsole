package Clases;

import java.util.*;

import Clases.Modelos.Usuario;

import java.io.*;
public class Guardar {
    
  public static void CrearArchivo(String FileName,Usuario datos) throws Exception{
      Properties prop = new Properties();
      
        prop.setProperty("Nombre", datos.getNombre());
        prop.setProperty("Email", datos.getEmail());
        prop.setProperty("Telefono", String.valueOf(datos.getPhone()));

      
      prop.store(new FileWriter(FileName + ".properties"), "File Generate by Dog App");
  }
  
  public static String LeerPropiedad(String FileName,String atributo) throws FileNotFoundException, IOException{
      var reader = new FileReader(FileName + ".properties");
      
      var props = new Properties();
      
      props.load(reader);
      
      return props.getProperty(atributo);
        
  }
  
  public static boolean ExisteArchivo(String FileName){
      File file = new File(FileName + ".properties");
      
      return file.exists();
  }
    
    
    
}

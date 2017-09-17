//Programa que muestra por consola todo el contenido de un fichero
//Sergio Garcia Balsas
package ejerciciopropuesto.pkg122;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioPropuesto122 {

    public static void main(String[] args) 
    {
       try
       {
            BufferedReader ficheroEntrada = new BufferedReader(
            new FileReader(new File("anotaciones.txt")));
            
            String linea= "";
            
            do
            {
                linea = ficheroEntrada.readLine();
                if (linea != null)
                {
                    System.out.println(linea);
                }
            }
            while (linea != null);
            ficheroEntrada.close();
       } 
       catch (FileNotFoundException ex) 
       {
            ex.printStackTrace();
       } 
       catch (IOException ex) 
       {
            ex.printStackTrace();
       }
       
      
    }
    
}

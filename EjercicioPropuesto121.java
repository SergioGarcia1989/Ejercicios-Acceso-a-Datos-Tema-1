//Programa que muestra la primera linea del contenido de un fichero con dos lineas
//Sergio Garcia Balsas
package ejerciciopropuesto1.pkg2.pkg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioPropuesto121 {

    
    public static void main(String[] args) 
    {
        try
        {
            BufferedReader ficheroEntrada = new BufferedReader(
            new FileReader(new File("DosFrases.txt")));
            
            String linea = "";
            linea = ficheroEntrada.readLine();
            System.out.println(linea);
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

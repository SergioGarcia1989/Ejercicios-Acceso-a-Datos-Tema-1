/*Programa que lee un fichero de texto y lo vuelca a otro pasando cada linea
a mayúsculas */
//Sergio García Balsas
package ejerciciopropuesto125;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class EjercicioPropuesto125 
{

    public static void main(String[] args) throws IOException 
    {
        try
        {
            BufferedReader ficheroEntrada = new BufferedReader(
            new FileReader(new File("anotaciones.txt")));
            
            String linea = "";
            
            PrintWriter ficheroSalida = new PrintWriter("mayus.txt");
            
            do
            {
                linea = ficheroEntrada.readLine();
                if (linea != null)
                {
                    ficheroSalida.println(linea.toUpperCase());
                }
            }
            while (linea != null);
            
            ficheroEntrada.close();
            ficheroSalida.close();
        } 
        catch (FileNotFoundException ex) 
        {
            ex.printStackTrace();
        }
    }
    
}

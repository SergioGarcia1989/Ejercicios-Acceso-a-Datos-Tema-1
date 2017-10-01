/*
 *Leemos la cabecera de un fichero BMP (54 primeros bytes) y 
si la posición 30 es 0, no está comprimido.
Sergio Garcia Balsas
 */
package ejercicioproupuesto143;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class EjercicioProupuesto143
{
    public static void main(String[] args) 
    {
        String nombreFichero = "";
        Scanner s = new Scanner(System.in);
        if (args.length == 0)
        {
            System.out.println("Nombre del fichero ");
            nombreFichero = s.nextLine();
        }
        else
        {
            nombreFichero = args[0];
        }
        
      
        try
        {
            File fichero = new File (nombreFichero);
            InputStream dato = new FileInputStream(fichero);
            
            /*Para leer el fichero entero 
            int tamanio = (int) fichero.length(); */
            
            //Leemos la cabecera (54 primeros bytes)
            byte[] buffer = new byte [54];
            dato.read(buffer, 0, 54);
            
            System.out.println(buffer[30]);
            
            if (buffer[30] == 0)
            {
                System.out.println("No está Comprimido");
            }
            else
            {
                System.out.println(" comprimido");
            }
            
            dato.close();
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println("Fichero no encontrado");
        } 
        catch (IOException ex)
        {
             System.err.println("I/O Exception");
        }
    }
}

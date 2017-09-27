/*
 * Crea un programa que se capaz de saber si dos ficheros binarios
son diferentes o iguales.
Se leeran por parametros, y si no hay parametros se preguntará al usuario.

Sergio Garcia Balsas
 */
package ejerciciopropuesto3comparar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjercicioPropuesto3Comparar
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner (System.in);
        String nombre1;
        String nombre2;
        if (args.length == 0)
        {
            System.out.println("¿ Nombre del fichero ?");
            nombre1 = teclado.nextLine();
            
            System.out.println("¿ Nombre del fichero2 ?");
            nombre2 = teclado.nextLine();
        }
        else
        {
            nombre1 = args[0];
            nombre2 = args[1];
        }
        
         
        try
        {
            File fichero1 = new File(nombre1);
            InputStream ficheroEntradaBin1
                    = new FileInputStream(fichero1);
            
            int tamanioFichero1 = (int) fichero1.length();
            byte [] buffer1 = new byte [tamanioFichero1];
            int c;
            while ((c = ficheroEntradaBin1.read(buffer1, 0, tamanioFichero1))>0)
            {
                
            }
            
            File fichero2 = new File(nombre2);
            InputStream ficheroEntradaBin2
                    = new FileInputStream(fichero2);
            
            int tamanioFichero2 = (int) fichero2.length();
            byte [] buffer2 = new byte [tamanioFichero2];
            int d;
            while ((d = ficheroEntradaBin2.read(buffer2, 0, tamanioFichero2))>0)
            {
                
            }
            
            
            
            if ( tamanioFichero1 != tamanioFichero2)
            {
                System.out.println(" Son distintos ");
            }
    
            else
            {
             boolean sonIguales = false; 
                for (int i = 0 ;  i < tamanioFichero1 ; i++)
                {
                    for (int j = 0; j < tamanioFichero2; j++)
                    {
                        if (buffer1[i] == buffer2[j])
                        {
                            sonIguales = true;
                        }
                    }
                }
                
                if (sonIguales)
                {
                    System.out.println("Son iguales");
                }
                if (!sonIguales)
                {
                    System.out.println("No son iguales");
                }
            }
            
            
            ficheroEntradaBin1.close();
            ficheroEntradaBin2.close();
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println(" No se encuentra el fichero ");
        } 
        catch (IOException ex)
        {
           System.err.println(" Error entrada salida ");
        }
        
    }
}

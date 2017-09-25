/*
 * Leer los datos de un fichero binario usando un array y mostrando
por pantalla su contenido.
 */
package ejerciciopropuesto142;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioPropuesto142 
{

    public static void main(String[] args) throws IOException 
    {
        Scanner teclado = new Scanner (System.in);
        System.out.println("Nombre fichero");
        String nombreFichero = teclado.nextLine();
        
        try 
        {
            FileInputStream ficheroEntrada =
                    new FileInputStream(new File(nombreFichero));
           
           int tamanio = ficheroEntrada.available();
            System.out.println(tamanio);
            
           byte[] f = new byte [tamanio];
           ficheroEntrada.read(f,0,tamanio);
           
           for (int i = 0; i < f.length ; i++)
           {
               if ((f[i] >= 'a')&& (f[i] <= 'z') || (f[i] == ' ')
                       || (f[i] >= 'A') && (f[i] <= 'Z'))
               {
                   System.out.print((char)f[i]);
               }
           }
           
           ficheroEntrada.close();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("No se encuentra fichero");
        }
    }
    
}

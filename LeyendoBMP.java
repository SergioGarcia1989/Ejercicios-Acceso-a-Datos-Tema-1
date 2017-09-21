/*Programa que lee los dos primeros bytes de un fichero binario, y comprueba
que se trata de un fichero BMP */
// Sergio Garcia Balsas
package leyendobmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LeyendoBMP 
{
    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner (System.in);
        String nombredelfichero = "";
        if (args.length == 0)
        {
            System.out.println("Nombre del fichero");
            nombredelfichero = teclado.nextLine();
        }
        else
        {
            nombredelfichero = args[0];
        }
        
        try
        {
            FileInputStream ficheroEntrada2 =
                new FileInputStream(new File(nombredelfichero+".bmp"));
            
            int dato1 = ficheroEntrada2.read();
            int dato2 = ficheroEntrada2.read();
           
            if ((dato1 == 'B') && (dato2 == 'M'))
            {
                System.out.println("Es un BMP");
            }
            else
            {
                System.out.println("No es un BMP");
            }
            ficheroEntrada2.close();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("No se encuentra el fichero");
        } 
        catch (IOException ex) 
        {
            System.out.println("Error de entrada salida");
        }
    }
}

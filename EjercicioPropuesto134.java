/*
 * Programa que abre una imagen GIF y comprueba si sus tres primeros bytes son 
las letras G, I, F
Sergio Garcia Balsas
 */
package ejerciciopropuesto134;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class EjercicioPropuesto134 
{
    public static void main(String[] args) 
    {
        try 
        {
            FileInputStream ficheroEntrada =
                    new FileInputStream(new File("hola.gif"));
            int dato1 = ficheroEntrada.read();
            int dato2 = ficheroEntrada.read();
            int dato3 = ficheroEntrada.read();
            
            if ((dato1 == 'G') && (dato2 == 'I') && (dato3 == 'F'))
            {
                System.out.println("Es un GIF");
            }
            else
            {
                System.out.println("No es un GIF");
            }
            ficheroEntrada.close();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("No se encuentra el fichero");
        } 
        catch (IOException ex) 
        {
            System.out.println("Error de Entrada/Salida");
        }
    }
}

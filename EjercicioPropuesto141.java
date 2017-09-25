/*
 * Programa que lee la cabecera de un fichero BMP (54 bytes) y si los
dos primeros corresponden a las letras B y M será un BMP
 */
package ejerciciopropuesto141;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class EjercicioPropuesto141 
{
    public static void main(String[] args) 
    {
        try 
        {
            FileInputStream ficheroEntrada =
                    new FileInputStream(new File("welcome1.bmp"));
            
            byte[] fichero = new byte [54];
            int cantidadleida = ficheroEntrada.read(fichero, 0, 54);
            
            if ((fichero[0] == 'B')&&(fichero[1] == 'M'))
            {
                System.out.println("Es un BMP");
            }
            else
            {
                System.out.println("No es un BMP");
            }
            
            ficheroEntrada.close();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Error de entrada salida");
        } 
        catch (IOException ex) 
        {
            System.out.println("Error entrada salida");
        }
    }
}

/*
 *Programa que extraiga el contenido de un fichero binario, volcando a un fichero
de texto todo lo que sean caracteres imprimibles (basta con que sean desde la A hasta la Z,
junto con el espacio en blanco) e ignorando todos los demás caracteres. El nombre del fichero
de entrada lo elegirá el usuario y el fichero de salida tendrá ese mismo nombre, pero
terminado en “.txt” (por ejemplo, si el fichero original era “1.zip”, el de salida será “1.zip.txt”).
 
Sergio Garcia Balsas*/
package ejerciciopropuesto133;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class EjercicioPropuesto133 
{

    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println(" ¿ Nombre del fichero binario de entrada ?? ");
        String nombreFichero = teclado.nextLine();
        
        try 
        {
            FileInputStream ficheroEntrada =
                    new FileInputStream(new File(nombreFichero));
            
            PrintWriter ficheroSalida = new PrintWriter (nombreFichero + ".txt");
            
            int dato = 0;
            do
            {
                dato = ficheroEntrada.read();
                if (dato != -1 )
                {
                    if ((dato >= 'a')&&(dato <= 'z') || (dato == ' ')
                            || (dato >= 'A')&&(dato <= 'Z'))
                    {
                        ficheroSalida.print((char)dato);
                    }
                }
            }
            while (dato != -1);
            
            ficheroEntrada.close();
            ficheroSalida.close();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println(" File not Found ");
        } 
        catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }
    }
}

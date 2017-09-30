/*
 * Mostrar un bmp fichero Binario
    Sergio Garcia Balsas
    Fernando Carbonell Selva
    Abilio Reig Sancho
 */
package mostrarbinario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MostrarBinario
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
            File fichero = new File (nombredelfichero+ ".bmp");
            InputStream dato = new FileInputStream(fichero);
            
            int tamanio = (int) fichero.length();
            byte[] b = new byte[tamanio];
            dato.read(b,0,tamanio);
           
            if ((b[0] == 'B') && (b[1] == 'M'))
            {
                System.out.println("Es un BMP");
                int altura;
                int anchura;
                
                altura =  b[18];
                anchura = b[22];
                System.out.println("Altura: " + altura);
                System.out.println("Anchura: " + anchura);
                System.out.println(tamanio);
                int pos = 54 + 768;
                int contadorBytesLeidos = 0;
                
                for (int fila = 0 ; fila < altura ; fila++)
                {
                    for (int col = 0; col < anchura; col++)
                    {
                        if (b[pos] == 0)
                        {
                            System.out.print(".");
                        }
                        else
                        {
                            System.out.print("*");
                        }
                        pos++;
                    }
                    System.out.println();
                }
            }
            else
            {
                System.out.println("No es un BMP");
            }
            dato.close();
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
  
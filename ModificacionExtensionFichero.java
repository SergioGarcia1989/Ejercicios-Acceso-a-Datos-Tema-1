/*
 Cambiando la extensión de un fichero .txt En java
No existe el .Remove para Strings, con lo cuál necesitamos saber la posición
del punto, y usar un subString para quedarnos con la extensión.
 */
package modificacionextensionfichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ModificacionExtensionFichero 
{

    public static void main(String[] args) throws IOException
    {
        Scanner teclado = new Scanner(System.in);
        String fichero ="";
        
        if (args.length == 0)
        {
            System.out.println("Nombre del fichero? ");
            fichero = teclado.nextLine();
        }
        else
        {
            fichero = args[0];
        }
        
        try
        {
            BufferedReader ficheroEntrada = new BufferedReader(
            new FileReader( new File(fichero)));
            
            int n = fichero.lastIndexOf(".");
            //POsición del punto
            System.out.println(n); //Es la 4
            String nombreSINEXTENSION = fichero.substring(0,4); //Nos quedamos con el caracter 0,1,2,3 y 4
            //Comprobamos el nombre del fichero sin extensión:
            System.out.println(nombreSINEXTENSION);
            ficheroEntrada.close();
            
            PrintWriter p = new PrintWriter (nombreSINEXTENSION +".html");
            p.println("Hola");
            p.close();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File not found");
        }
      
    }
    
}

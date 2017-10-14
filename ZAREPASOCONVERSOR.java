/*
 *Crea un programa que haga una conversión básica de un programa en Java a su equivalente en C#.

La nota será como sigue:

Estructura básica (leer de un fichero, volcar a otro, analizar línea de comandos): 4 puntos.
Los "import" se convertirán (si procede) en "using": 1 punto.
"println" se convertirá (con matices) en "WriteLine": 1 punto.
Las cadenas no serán "String", sino "string": 1 punto
Los booleanos no serán "bool" sino "boolean": 1 punto
"main" debe estar en mayúsculas: 1 punto
Los métodos deben comenzar en mayúsculas. Por ejemplo, ".substring" se convertirá en ".Substring": 1 punto

Sergio Garcia Balsas
 */
package e9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Usuario
 */
public class E9
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       String nombreFichero = "";
       Scanner sc = new Scanner (System.in);
       
       if (args.length == 0)
       {
           System.out.println("Nombre del fichero?");
           nombreFichero = sc.nextLine();
       }
       else
       {
           nombreFichero = args[0];
       }
       
        try
        {
            BufferedReader ficheroEntrada = new BufferedReader(
                    new FileReader(new File(nombreFichero)));
            
            PrintWriter pw = new PrintWriter ("ejemplo.cs");
            pw.println("using System;");
            
            String linea = "";
            do
            {
                linea = ficheroEntrada.readLine();
                if (linea != null)
                {
                    if (linea.contains("import"))
                    {
                        linea = "";
                        pw.println(linea);
                    }
                    else if (linea.contains("package"))
                    {
                        linea = "";
                        pw.println(linea);
                    }
                    else if (linea.contains("Scanner"))
                    {
                        linea = "";
                        pw.println(linea);
                    }
                    else if (linea.contains("teclado"))
                    {
                        linea = linea.replace("teclado.nextLine()", "Console.ReadLine()");
                        pw.println(linea);
                    }
                    
                    else if (linea.contains("System.out.println"))
                    {
                       linea =  linea.replace("System.out.println", "Console.WriteLine");
                       pw.println(linea);
                    }
                    
                    else if (linea.contains("System.out.print"))
                    {
                       linea =  linea.replace("System.out.print", "Console.Write");
                       pw.println(linea);
                    }
                    
                    else if (linea.contains("main"))
                    {
                       linea =  linea.replace("main", "Main");
                       pw.println(linea);
                    }
                    
                    else if (linea.contains("boolean"))
                    {
                        linea =  linea.replace("boolean", "bool");
                        pw.println(linea);
                    }
                    
                    else if (linea.contains("String"))
                    {
                        linea =  linea.replace("String", "string");
                        pw.println(linea);
                    }
                    
                    else
                    {
                        pw.println(linea);
                    }
                    
                }
            }
            while (linea != null);
            
            pw.close();
            ficheroEntrada.close();
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println("Fichero no encontrado");
        } 
        catch (IOException ex)
        {
            System.out.println("Error Entrada Salida");
        }
    }
    
}

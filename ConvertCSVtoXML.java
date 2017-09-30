/*
 * Program that converts CSV to XML
Sergio Garcia Balsas
 */
package convertcsvtoxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ConvertCSVtoXML
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner (System.in);
        String nombreFichero="";
        if (args.length == 0)
        {
            System.out.println(" Nombre del fichero? ");
            nombreFichero = teclado.nextLine();
        }
        else
        {
            nombreFichero = args[0];
        }
        
        try
        {
            BufferedReader ficheroEntrada = new BufferedReader(
                    new FileReader(new File(nombreFichero)));
            String linea = "";
            
            int n = nombreFichero.lastIndexOf(".");
            String extension = nombreFichero.substring(n);
            String nombreNormal = nombreFichero.substring(0,n);
            
            //System.out.println("extension " + extension);
            
            PrintWriter ficheroSalida = new PrintWriter(nombreNormal + ".xml");
            
            ficheroSalida.println("<datos>");
            ficheroSalida.println("        <dato>");
            do
            {
                linea = ficheroEntrada.readLine();
                if (linea != null)
                {
                    String[] partes = linea.split(",");
                    ficheroSalida.println("<mes>" + partes[0] + "</mes>");
                    ficheroSalida.println("<ventas>" + partes[1] + "</ventas>");
                    ficheroSalida.println("<Acumulado>" + partes[2] + 
                            "</Acumulado>");
                }
            }
            while (linea != null);
            
            ficheroSalida.println("        </dato>");
            ficheroSalida.println("</datos>");
            
            ficheroSalida.close();
            ficheroEntrada.close();
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println("Fichero no encontrado");
        } 
        catch (IOException ex)
        {
            System.err.println("Error de entrada salida");
        } 
    }
}

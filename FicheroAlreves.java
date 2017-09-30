/*
 * Invertir fichero de texto
Sergio Garcia Balsas
 */
package ficheroalreves;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class FicheroAlreves
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader ficheroEntrada = new BufferedReader(
                    new FileReader(new File("hola.txt")));
            String linea = "";
            ArrayList lineas = new ArrayList ();
            
            PrintWriter ficheroSalida = new PrintWriter ("alreves.txt");
            do
            {
                linea = ficheroEntrada.readLine();
                if (linea != null)
                {
                    lineas.add(linea);
                }
            }
            while (linea != null);
            for (int i = lineas.size() -1 ; i >= 0 ; i--)
            {
                ficheroSalida.println(lineas.get(i));
            }
            //Debug System.out.println(lineas.get(0));
            
            ficheroEntrada.close();
            ficheroSalida.close();
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println("Fichero no encontrado");
        } 
        catch (IOException ex)
        {
            System.err.println("Problema en Entrada / Salida");
        }
    }
}

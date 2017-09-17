/* Programa que pide al usuario el nombre del fichero y se le pregunta
al usuario una palabra. El programa mostrará por pantalla todas las
lineas del fichero que contengan esa palabra*/
//Sergio García Balsas
package ejerciciopropuesto126;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class EjercicioPropuesto126 
{

    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        try
        {
            System.out.println( "Nombre del fichero? " );
            String nombredeFichero = teclado.nextLine();
            
            BufferedReader ficheroEntrada = new BufferedReader(
            new FileReader( new File(nombredeFichero+".txt" )));
            
            System.out.println(" Palabra a buscar? ");
            String palabra = teclado.nextLine();
            
            String linea = "";
            
            do
            {
                linea = ficheroEntrada.readLine();
                if (linea != null)
                {
                    if (linea.toLowerCase().contains(palabra.toLowerCase()))
                    {
                         System.out.println(linea);
                    }
                }
            }
            while (linea != null);
            ficheroEntrada.close();
        } 
        catch (FileNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
    
}

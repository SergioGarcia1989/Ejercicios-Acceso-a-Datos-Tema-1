/*
 * Crea un programa como el Hacha, que se capaz de partir un fichero
en varios, con el tamaño que asigne el usuario.
Se pedirán por parametros, nombre de fichero a cortar y tamaño, 
si no hay parametros se pregunta al usuario.
Sergio Garcia Balsas
 */
package hacha3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hacha3
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner (System.in);
        String nombre = "";
        int tamanioParticion = 0;
        if (args.length == 0)
        {
            System.out.println("¿ Nombre del fichero ?");
            nombre = teclado.nextLine();
            
            System.out.println("¿ Tamaño del fichero ?");
            tamanioParticion = teclado.nextInt();
        }
        else
        {
            nombre = args[0];
            tamanioParticion = Integer.parseInt(args[1]);
        }
        
        
        try
        {
            File fichero = new File(nombre);
            InputStream ficheroEntradaBin
                    = new FileInputStream(fichero);
            
            int tamanioTotal = (int) fichero.length();
            
            int cantidadDeFicheros;
            
            //1. Obtenemos la cantidad de ficheros
            if (tamanioTotal % tamanioParticion != 0)
            {
                cantidadDeFicheros = tamanioTotal / tamanioParticion + 1;
            }
            else
            {
                 cantidadDeFicheros = tamanioTotal / tamanioParticion;
            }
            //2. Leemos en bloque el contenido del fichero.
            byte [] b = new byte [tamanioTotal];
            int c;
            while ((c = ficheroEntradaBin.read(b, 0, tamanioTotal))>0)
            {
                
            }
            //3. Generamos los ficheros de salida resultantes
            OutputStream ficheroSalida = null;
            
            int n = nombre.lastIndexOf(".");
            String extension = nombre.substring(n);
            
            String nombreSin = nombre.substring(0,n);
            
            for (int i = 0; i < cantidadDeFicheros ; i++)
            {
                ficheroSalida = new FileOutputStream(
                            new File(nombreSin + i + extension));
                System.out.println("Generando parte " + (i+1) + "de" + 
                        cantidadDeFicheros);
                ficheroSalida.write(b[i]);
            }
            ficheroEntradaBin.close();
            ficheroSalida.close();
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println("No se encuentra el fichero");
        } 
        catch (IOException ex)
        {
            System.err.println("Error Entrada/Salida");
        }
        
    }
}

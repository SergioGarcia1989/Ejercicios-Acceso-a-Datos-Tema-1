/* Programa que lee de varios ficheros de texto y ordena su contenido
para volcarlo en otro fichero
 Sergio Garcia Balsas*/
package lervariosficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LerVariosFicheros 
{
    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner (System.in);
        String nombreFichero="";
        ArrayList lista = new ArrayList ();
        
        if (args.length == 0)
        {
            do
            {
                System.out.println("Nombre del fichero");
                nombreFichero = teclado.nextLine();
                if (!"".equals(nombreFichero))
                {
                    lista.add(nombreFichero);
                }
                
            }
            while ( ! "".equals(nombreFichero) ); 
        }
           
        //DEBUGEANDO: 
        //System.out.println(lista.get(0));
        
        ArrayList lineas = new ArrayList();
        try
        {
            BufferedReader ficheroEntrada= null;
            String linea="";
            
            for (int i = 0; i < lista.size() ; i++)
            {
                ficheroEntrada = new BufferedReader(
                new FileReader( new File( (String) lista.get(i))));
                System.out.println("-----------");
                System.out.println(lista.get(i).toString());
                
                do
                {
                    linea = ficheroEntrada.readLine();
                    if (linea != null)
                    lineas.add(linea);
                }
                while (linea != null);
            }
            
           
            /*Debugeando 
            System.out.println("Contenido linea 1 fichero 1"+lineas.get(0));
            System.out.println("Contenido linea 1 fichero 2" + lineas.get(1));
            */
            
            //El fichero de salida tomará el nombre del primer fichero + ordenado.txt
            PrintWriter ficheroSalida = new PrintWriter (lista.get(0) +"ordenado.txt");
            
            //Ordenamos alfabéticamente todas las lineas de los ficheros
            Collections.sort(lineas);
            
            //Recorremos con un for el total de lineas de nuestros ficheros
            for (int i = 0; i < lineas.size() ; i++)
            {
                ficheroSalida.println(lineas.get(i));
            }
            
            ficheroSalida.close();
            ficheroEntrada.close();
        } 
        
        catch (FileNotFoundException ex) 
        {
            System.out.println("No se encuentra fichero" 
                    + ex.getMessage().toString());
        } catch (IOException ex) 
        {
            System.out.println("Error de Entrada/Salida");
        }
    }
}

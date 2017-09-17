/*Programa que preguntara al usuario el nombre de un fichero de texto
que habrá que visualizar. Si el programa no existe el usuario deberá ser avisado */
//Sergio Garcia Balsas

package ejercicio.pkg124;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio124 {

    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner (System.in);
        System.out.println("Introduzca el nombre del fichero que desea ver: ");
        String nombreFichero = teclado.nextLine();
        
        File file = new File (nombreFichero+".txt");
        
        if ( ! file.exists() )
        {
            System.out.println("El fichero no existe");
        }
        else
        {
            try
            {
                 BufferedReader ficheroEntrada = new BufferedReader(
                 new FileReader(new File(nombreFichero+".txt")));

                 String linea= "";

                 do
                 {
                     linea = ficheroEntrada.readLine();
                     if (linea != null)
                     {
                         System.out.println(linea);
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
}

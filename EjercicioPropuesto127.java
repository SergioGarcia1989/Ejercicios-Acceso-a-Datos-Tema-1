/*Programa que lee un fichero de texto el cúal contiene un rectángulo de *
y nos muestra por pantalla su anchura y altura
*/
//Sergio García Balsas
package ejerciciopropuesto127;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class EjercicioPropuesto127 {

    public static void main(String[] args) {
        try
        {
            BufferedReader ficheroEntrada = new BufferedReader(
            new FileReader( new File("rectangle.txt" )));
            
            String linea = "";
            
            int ancho= 0;
            int alto = 0;
            do
            {
                linea = ficheroEntrada.readLine();
                
                if (linea != null)
                {
                    alto++;
                    ancho = linea.length();
                }
            }
            while (linea != null);
            ficheroEntrada.close();
            System.out.println("Alto: " + alto);
            System.out.println("Ancho: " + ancho);
        } 
        catch (FileNotFoundException ex) 
        {
           ex.printStackTrace();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

/*Programa que muestra el contenido de un fichero y cada 23 lineas el 
programa se pusará hasta que el usuario presione la tecla Intro */
//Sergio Garcia Balsas
package ejerciciopropuesto123;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioPropuesto123 
{
    public static void main(String[] args) 
    {
        try
       {
            BufferedReader ficheroEntrada = new BufferedReader(
            new FileReader(new File("anotaciones.txt")));
            
            Scanner teclado = new Scanner(System.in);
            
            String linea= "";
            int numerodelineas=0;
            do
            {
                linea = ficheroEntrada.readLine();
                if (linea != null)
                {
                    numerodelineas++;
                    if (numerodelineas % 23 == 22)
                    {
                        System.out.println("Intro para continuar");
                        teclado.nextLine();
                    }
                    else
                    {
                        System.out.println(linea);
                    }
                }
            }
            while (linea != null);
            System.out.println(numerodelineas);
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

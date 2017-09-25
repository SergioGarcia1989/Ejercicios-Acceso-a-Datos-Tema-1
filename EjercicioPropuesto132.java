/*
 * Programa que lee el contenido de un fichero binario, mostrando en pantalla todo
lo que sean caracteres imprimibles (basta con que sean desde la A hasta la Z, 
junto con el
espacio en blanco) e ignorando todos los demás caracteres. El nombre del fichero de entrada
lo elegirá el usuario.

Sergio García Balsas
 */
package ejerciciopropuesto132;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class EjercicioPropuesto132 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        System.out.println("Nombre del fichero");
        String nombre = teclado.nextLine();
        
        try 
        {
            FileInputStream ficheroEntrada2 =
                    new FileInputStream(new File(nombre));
            int dato;
            do
            {
                dato = ficheroEntrada2.read();
                if ((dato >= 'a') && (dato <= 'z') || (dato == (char)' ')
                        || (dato >= 'A') && (dato <= 'Z'))
                {
                    System.out.print((char)dato);
                }
            }
            while (dato != -1 );
            ficheroEntrada2.close();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Fichero no Encontrado" + ex.getMessage().toString());
        } 
        catch (IOException ex) 
        {
            System.out.println("Excepcion io");
        }
    }
}

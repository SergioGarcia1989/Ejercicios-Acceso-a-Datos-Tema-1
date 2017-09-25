/*
 * Programa que compruebe si un fichero EXE parece válido: deberá comprobar
    que su primer byte tenga el valor 0x4D y el segundo sea un 0x5A.
Sergio Garcia Balsas
 */
package ejerciciopropuesto131;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EjercicioPropuesto131 
{

   
    public static void main(String[] args) 
    {
        try {
            FileInputStream ficheroEntrada2 =
                    new FileInputStream(new File("Setup.exe"));
            int dato1 = ficheroEntrada2.read();
            int dato2 = ficheroEntrada2.read();
            
            if ((dato1 == 'M') && (dato2 == 'Z'))
            {
                System.out.println("Es un .exe");
            }
            else
            {
                System.out.println("No es un .exe");
            }
            
            ficheroEntrada2.close();
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("No se encuentra el fichero");
        } catch (IOException ex) {
            Logger.getLogger(EjercicioPropuesto131.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

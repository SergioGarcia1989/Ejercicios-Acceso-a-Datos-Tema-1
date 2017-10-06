/*
 *Darle la vuelta a un fichero
Sergio Garcia Balsas
 */
package darlelavuelta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Usuario
 */
public class DarleLavuelta
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        System.out.println("Copiando fichero binario...");

    try
    {
        
        File fichero = new File ("welcome1.bmp");
        InputStream ficheroEntrada3 = new FileInputStream(fichero);
       
        OutputStream ficheroSalida3 = new FileOutputStream(
        new File("welcome1OUT.bmp"));
        
        int BUFFER_SIZE = (int) fichero.length();
        byte[] buf = new byte[BUFFER_SIZE];
        ficheroEntrada3.read(buf, 0, BUFFER_SIZE);
        
        for (int i = buf.length -1 ; i >= 0; i --)
        {
            ficheroSalida3.write(buf[i]);
        }
        
        
       //TO DO HACERLO BIEN
        
        ficheroEntrada3.close();
        ficheroSalida3.close();
        
        }
        catch (Exception errorDeFichero)
        {
            System.out.println("Ha habido problemas: " +
            errorDeFichero.getMessage() );
        }
        System.out.println("Terminado!");
        }
    
}

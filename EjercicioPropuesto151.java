/*
 *1.5.1: Crea una clase Persona, con datos nombre, e-mail, año de nacimiento. 
Haz un programa
que cree tres objetos de tipo persona y los guarde en un fichero llamado “personas.dat”.

1.5.2 También muestra los datos de las tres personas que se habían guardado en
el fichero “personas.dat”.

Ambos ejemplos están hecho guardando el objeto directamente
y guardando y serializando en un arrayList

Sergio Garcia Balsas
 */
package ejerciciopropuesto151;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.Serializable;




public class Persona implements Serializable
{
    String nombre;
    String email;
    int anio;

    public Persona(String nombre, String email, int anio)
    {
        this.nombre = nombre;
        this.email = email;
        this.anio = anio;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getEmail()
    {
        return email;
    }

    public int getAnio()
    {
        return anio;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setAnio(int anio)
    {
        this.anio = anio;
    }

    @Override
    public String toString()
    {
        return "Persona{" + "nombre=" + nombre + ", email=" + email + ", anio=" + anio + '}';
    }
    
    
}





public class EjercicioPropuesto151
{
    public static void main(String[] args)
    {
       Persona p = new Persona("Paco", "paco@gmail.com",25);
       Persona p2 = new Persona("Oriol", "viscaERC@gmail.com",43);
       Persona p3 = new Persona("Sergi", "sergi@gmail.com",27);
       //Creamos un arrayList
       List<Persona> listaPersonas = new ArrayList<>();
       listaPersonas.add(p);
       listaPersonas.add(p2);
       listaPersonas.add(p3);
       
       try
       {
        //1. Serializar
        File fichero = new File("personas.dat");
        FileOutputStream ficheroSalida = new FileOutputStream(fichero);
        ObjectOutputStream ficheroObjetos = new ObjectOutputStream(ficheroSalida);
        //Serializamos peronas (Prescindible si serializamos el arraylist)
        ficheroObjetos.writeObject(p);
        ficheroObjetos.writeObject(p2);
        ficheroObjetos.writeObject(p3);
        //Serializamos el arrayList
        ficheroObjetos.writeObject(listaPersonas);
        
        FileInputStream ficheroentrada = new FileInputStream(fichero);
        ObjectInputStream leerFicheroObjetos = new ObjectInputStream(ficheroentrada);
        //Deserializamos Personas (Prescindible si deserializamos el arraylist)
        Persona ObjetoResultanteDeLaLecturaDelFichero = (Persona) leerFicheroObjetos.readObject();
        Persona ObjetoResultanteDeLaLecturaDelFichero1 = (Persona) leerFicheroObjetos.readObject();
        Persona ObjetoResultanteDeLaLecturaDelFichero2 = (Persona) leerFicheroObjetos.readObject();
        //Comprobación
        System.out.println(ObjetoResultanteDeLaLecturaDelFichero.toString());
        System.out.println(ObjetoResultanteDeLaLecturaDelFichero1.toString());
        System.out.println(ObjetoResultanteDeLaLecturaDelFichero2.toString());
        
           System.out.println("----------");
           
        //DeSerializamos el arrayList
        List arrayDePersonasDeserializado = (ArrayList) leerFicheroObjetos.readObject();
        for (int i = 0 ; i < arrayDePersonasDeserializado.size(); i++)
        {
            System.out.println(arrayDePersonasDeserializado.get(i).toString());
        }
        
        ficheroSalida.close();
        ficheroObjetos.close();
        ficheroentrada.close();
        leerFicheroObjetos.close();
        
       
        
       } 
       catch (FileNotFoundException ex)
        {
            System.err.println("Fichero no encontrado ");
        } 
       catch (IOException ex)
        {
            System.err.println("Error de entrada salida");
        }
       catch (ClassNotFoundException ex)
        {
            System.out.println("Clase no encontrada");
        }
       
    }
    
}

/*
 * Crea una Agenda de Personas Serializando y Deserializando, para poder
introducir personas nuevas, mostrarlas y buscarlas.
Sergio Garcia Balsas
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import java.io.Serializable;

public class Persona implements Serializable
{
    String nombre;
    String correoElectronico;
    int edad;

    public Persona(String nombre, String correoElectronico, int edad)
    {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.edad = edad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getCorreoElectronico()
    {
        return correoElectronico;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico)
    {
        this.correoElectronico = correoElectronico;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    @Override
    public String toString()
    {
        return "Persona{" + "nombre=" + nombre + ", correoElectronico=" 
                + correoElectronico + ", edad=" + edad + '}';
    }
    
    
}







public class EjercicioPropuesto153
{
    
    public static List <Persona> listaPersonas = new ArrayList<>();
    public static void menu()
    {
        System.out.println("1. Añadir persona");
        System.out.println("2. Buscar persona");
        System.out.println("3. Mostrar todas");
        System.out.println("4. Salir");
    }
    
    public static void anadirPersona() 
    {
        Scanner teclado = new Scanner(System.in);
      
        System.out.println("Nombre ?");
        String nombre = teclado.nextLine();
        System.out.println("Email ? ");
        String email = teclado.nextLine();
        System.out.println("Edad ?");
        int edad = teclado.nextInt();
        
        Persona p = new Persona (nombre, email, edad);
        listaPersonas.add(p);
        try
        {
            File fichero = new File("personas.dat");
            FileOutputStream ficheroSalida = new FileOutputStream(fichero);
            ObjectOutputStream ficheroObjetos = new ObjectOutputStream(ficheroSalida); 
            
            ficheroObjetos.writeObject(listaPersonas);
            
             ficheroObjetos.close();
             ficheroSalida.close();
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println("Fichero no encontrado ");
        } 
        catch (IOException ex)
        {
           System.err.println("Excepcion Entrada salida ");
        }
       
       
    }
    
    public static void mostrarDatosTemporalesMemoria()
    {
        for (int i = 0; i < listaPersonas.size(); i++)
        {
            System.out.println(listaPersonas.get(i).toString());
        }
    }
    
    public static void mostrarDatosSerializados()
    {
        try
        {
        File fichero = new File("personas.dat");
        FileInputStream ficheroSalida = new FileInputStream(fichero);
        ObjectInputStream ficheroObjetos = new ObjectInputStream(ficheroSalida);
        
        List arrays = (ArrayList) ficheroObjetos.readObject();
        
        for (int i = 0 ; i < arrays.size() ; i++)
        {
            System.out.println(arrays.get(i).toString());
        }
        
        ficheroSalida.close();
        ficheroObjetos.close();
        
        } 
        catch (FileNotFoundException ex)
        {
              System.err.println("Fichero no encontrado ");
        } 
        catch (IOException ex)
        {
            System.err.println("Error i/o ");
        } 
        catch (ClassNotFoundException ex)
        {
            System.err.println("Error de clase ");
        }
    }
    
    public static void buscarDatosSerializados()
    {
        Scanner teclado = new Scanner(System.in);
        try
        {
        File fichero = new File("personas.dat");
        FileInputStream ficheroSalida = new FileInputStream(fichero);
        ObjectInputStream ficheroObjetos = new ObjectInputStream(ficheroSalida);
        
        List arrays = (ArrayList) ficheroObjetos.readObject();
            System.out.println("Nombre de la persona que desea buscar: ");
            String persona = teclado.nextLine();
        
        for (int i = 0 ; i < arrays.size() ; i++)
        {
           if (arrays.get(i).toString().contains(persona))
           {
               System.out.println(" Datos de " + persona + "\n" +
                       arrays.get(i).toString());
           }
        }
        
        ficheroSalida.close();
        ficheroObjetos.close();
        
        } 
        catch (FileNotFoundException ex)
        {
           System.err.println("Fichero no encontrado ");
        } 
        catch (IOException ex)
        {
           System.err.println("error io ");
        } 
        catch (ClassNotFoundException ex)
        {
            System.err.println("clase no encontrada ");
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException
    {
      Scanner teclado = new Scanner(System.in);
       boolean salir = false;
       String opcion="";
       do
       {
           menu();
           opcion = teclado.nextLine();
           switch (opcion)
           {
                case "1": 
                   anadirPersona();
                   break;
                case "2": 
                    buscarDatosSerializados();
                    break;
                case "3": 
                    mostrarDatosSerializados();
                    break;
                case "4":
                    salir = true;
                    break;
                default: System.out.println("Número incorrecto");
                    break;
           }
           
       }
       while (!salir);
        System.out.println("Gracias por usar la Agenda de este Ejercicio");
    }
}

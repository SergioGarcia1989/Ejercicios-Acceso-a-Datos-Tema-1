// Base de datos de videojuegos en un fichero de texto
// Roberto Garcia Marcos, Sergio Garcia Balsas, Alexandra Sanchez Alonso

package videojuegos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Videojuegos {
 public static List<Videojuego> listaVideojuegos = new ArrayList<>();
 
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Videojuegos v = new Videojuegos();
       
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        String option = "" ;
        
        do{
            MuestraMenu();
            option = sc.next();
            
            switch (option){
                case "1": 
                    v.IntroducirJuegoSerializando();
                    break;
                case "2":
                    //probando
                    v.DeserializarMostrando();
                    //v.BuscarJuego(sc, listaVideojuegos);
                    break;
                case "3": //TO DO
                    System.out.println("Not work");
                    break;
                case "4": exit = true;
                    break;
                default: System.out.println("Opción no válida");
            }
        }
        while (!exit);
    }
    
    public static void MuestraMenu(){
        System.out.println("1. Añadir videojuego");
        System.out.println("2. Mostrar videojuego");
        System.out.println("3. Modificar videojuego");
        System.out.println("4. Salir");
    }
    
    public void ModificarVideojuego(ArrayList listaVideojuegos){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Titulo del videojuego que quiere modificar");
        String nuevonombre = "";
        /*
        for (int i = 0; i < listaVideojuegos.size() ; i++ )
        {
            if (!listaVideojuegos.get(i).)
            {
            } else {
                System.out.println ("Nombre antiguo "+
                    listaVideojuegos.get(i).getTitulo());
                System.out.println ("Introduzca nuevo nombre ");
                nuevonombre = teclado.next();

                listaVideojuegos.get(i).setTitulo(nuevonombre);
            }
        }
        */
    }
    
    public void IntroducirJuegoSerializando() 
    {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Genero: ");
        String genero = sc.nextLine();
        System.out.println("Plataforma: ");
        String plataforma = sc.nextLine();
        System.out.println("Descripcion: ");
        String descripcion = sc.nextLine();
        System.out.println("Año: ");
        String anyete = sc.nextLine();
        
        int anyo = Integer.parseInt(anyete);
        
        //Añade el videjuego
        Videojuego videojuego = new Videojuego(
                nombre, genero, anyo, plataforma, descripcion);
        listaVideojuegos.add(videojuego);
      
        
       //Serializando
        try
        {
             File fichero = new File("videojuegos.dat");
                FileOutputStream ficheroSalida;
            ficheroSalida = new FileOutputStream(fichero);
            ObjectOutputStream ficheroObjetos =
                new ObjectOutputStream(ficheroSalida);
            
            //ficheroObjetos.writeObject(videojuego);
            ficheroObjetos.writeObject(listaVideojuegos);
            ficheroObjetos.close();
            ficheroSalida.close();
            
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println("Error fichero no encontrado");
        } 
        catch (IOException ex)
        {
            System.out.println("Error fallo de entrada/salida");
        }
                
    }
    
    //Deserializando (sin usar try catch)
    public void DeserializarMostrando() throws FileNotFoundException, IOException, 
            ClassNotFoundException
    {
        File fichero = new File("videojuegos.dat");
        FileInputStream ficheroEntrada;
        ficheroEntrada = new FileInputStream(fichero);

        ObjectInputStream ficheroObjetos = new ObjectInputStream(ficheroEntrada);

       /* Videojuego videojuego = (Videojuego) ficheroObjetos.readObject();
          
        System.out.println(videojuego.getTitulo() + "\n" + videojuego.getGenero() 
                + "\n" + videojuego.getPlataforma() + "\n" + videojuego.getResumen() +
           videojuego.getAnyo());
        */
          
        List lista = (ArrayList) ficheroObjetos.readObject();
        listaVideojuegos = lista;
        
        for (int i = 0; i < lista.size() ; i++)
        {
            System.out.println(lista.get(i).toString());
        }
        
            
            ficheroObjetos.close();
            ficheroEntrada.close();
    }
    
   
    
    public void BuscarJuego(Scanner sc, ArrayList listaVideojuegos){
        // TO DO
        
        System.out.println("Introduce el titulo: ");
        String titulo = sc.nextLine();
        /*
        for(int i = 0; i < listaVideojuegos.size(); i++){
            if(titulo == listaVideojuegos.get(i).toString(){
                
            }
        }
        */
    }
}

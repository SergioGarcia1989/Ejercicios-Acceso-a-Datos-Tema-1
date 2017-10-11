/* Pregunta un pais y te da su capital a través de un archivo xml
 Sergio Garcia Balsas
 */
package dom1;

import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Dom1 {
    public static void main(String[] args){

        try {
            File inputFile = new File("countries.xml");
            DocumentBuilderFactory dbFactory 
                = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            System.out.println("Elemento base : " 
                + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("country");
            System.out.println();
            
           String pais="";
            Scanner teclado = new Scanner (System.in);
           
           
            do
            {
                
            //System.out.println("Recorriendo paises..."); 
            System.out.println("Nombre del pais?");
            pais = teclado.nextLine();
                for (int temp = 0; temp < nList.getLength(); temp++) 
                {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                    {
                        
                        Element eElement = (Element) nNode;
                        
                        if (!pais.equals(""))
                        {
                            //Mejora otro atributo seria que coincidiera con las "translations"
                            if (eElement.getAttribute("name").contains(pais))
                            { 
                                System.out.println("Capital: " 
                                + eElement.getAttribute("capital"));
                                System.out.println("  ");
                            }
                        }
                            
                       // System.out.println(); 
                    }
                }
              
            }
            while (!pais.equals(""));
             
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
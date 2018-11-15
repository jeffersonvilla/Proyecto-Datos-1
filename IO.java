package detector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author Grupo proyecto datos 1
 */
public class IO {
    
    /**
     * Abre archivo y por cada linea guarda datos en QuadTree
     * 
     * @autor desconocido
     * @url http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
     * @modificado por Grupo proyecto datos 1
     */
    public static void abriArchivo(QuadTree qt, String dir, String name){
        //Abro archivo 
        //Inserto elementos en Quad tree
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (dir+name);
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String linea;

           //Inicio del codigo modificado
           String[] n;
           while((linea=br.readLine())!=null){
              n = linea.split(",");        
              //System.out.println(linea);
              NodoT nodo = new NodoT(Double.parseDouble(n[0])
                      , Double.parseDouble(n[1]), Double.parseDouble(n[2]));
              qt.insertar(nodo);
           }
           //Fin de codigo modificado
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        
    }
    
    /**
     * Escribe elementos de la lista en un archivo
     * 
     * @autor desconocido
     * @url http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
     * @modificado por Grupo proyecto datos 1
     */
    public static void escribirArchivo(LinkedList<NodoT> list, String dir, String out){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(dir+out);
            pw = new PrintWriter(fichero);

        //Guarda cada elemento en la lista
        for(NodoT i :list){        
            pw.println(i.x()+","+i.y()+","+i.z());
        }
          

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    
}

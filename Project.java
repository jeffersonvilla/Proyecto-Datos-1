package project;

import java.lang.Math;
import java.io.*;

/**
 *
 * @author 
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //testQT();
        //testLL();
        
    }
    
    private static void testQT(){        
        QuadTree abejas = new QuadTree(); //Creo QuadTree
        insertarQuad(abejas); //Inserto elementos en QuadTree
        abejas.colisiones("colisionesq"); //Busco colisiones proximas
    }
    
    private static void testLL(){
        //Creo LinkedList
        LL abejas = new LL();              
        
        //Inserto elementos
        //archivoLista(abejas, "D:\\1000000abejas.txt");
        
        //System.out.println(abejas.size());
        
        //Ordeno respecto a x
        /*long startTime = System.nanoTime();   
        Ordenamiento.quickSort(abejas);
        long endTime = System.nanoTime();
        //abejas.showList(10000);
        System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");*/
        
        //Comparo en rango e imprimo
        //listaArchivo(abejas);
        
        archivoLista(abejas, "D:\\colisiones.txt");
        //abejas.showList();
        System.out.println(abejas.size());
    }
    
    private static void insertarQuad(QuadTree qt){
        //Abro archivo 
        //Inserto elementos en Quad tree
    }
    
    /**
     * Recorre lista comparando cada par de nodos consecutivos i, k
     * e imprimiendo en una archivo cuando d(i, k) < 100
     * 
     * @autor desconocido
     * @url http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
     */
    private static void listaArchivo(LL list){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("D:\\colisiones.txt");
            pw = new PrintWriter(fichero);

        /*
         * @autor Jefferson
         */
        //Incio de mi codigo
        long startTime = System.nanoTime();   
        for(NodoLL i = list.primero(); i!=list.fin();i = i.next()){
            NodoLL k = i.next(); 
            if(k == null) break; 
            if(distancia(i, k)<= 100){ 
                pw.println(i.x()+","+i.y()+","+i.z());
                i = i.next();
                pw.println(i.x()+","+i.y()+","+i.z());
             }
        }
        long endTime = System.nanoTime();
        System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
        //Fin de mi codigo    

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
    
    
    /**
     * LLena una lista con los elementos del archivo
     * 
     * @autor desconocido
     * @url http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
     */
    private static void archivoLista(LL list, String name){
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (name);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         /*
          * @autor Jefferson
          */
         //Inicio de mi codigo
         String[] n;
         while((linea=br.readLine())!=null){
            n = linea.split(",");        
            //System.out.println(linea);
            NodoLL nodo = new NodoLL(Double.parseDouble(n[0])
                    , Double.parseDouble(n[1]), Double.parseDouble(n[2]));
            list.insertar(nodo, list.size());
         }
         //Fin de mi codigo
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
    
    /*
    * Retorna la distancia(euclidiana) entre los nodos
    */
    private static double distancia(NodoLL i, NodoLL k){
        return Math.sqrt(Math.pow((i.x()-k.x()),2)+Math.pow((i.y()-k.y()),2)+
                Math.pow((i.z()-k.z()),2));
    }
    

}

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
        testQT();
        //testLL();
        
       /* QuadTree abejas = new QuadTree();
        abejas.insertar(0, 0, 0);
        abejas.insertar(1, 1, 0);
        abejas.insertar(1, -1, 0);
        abejas.insertar(-1, 1, 0);
        abejas.insertar(-1, -1, 0);
        abejas.insertar(-1, 2, 0);
        abejas.insertar(-1, 0.5, 0);
        abejas.preorden();*/
       /*NodoT a = new NodoT(-75.5796440222, 6.31091326448, 1687.9);
       NodoT c = new NodoT(-75.5443845591, 6.30633535292, 1415.34);
       NodoT b = new NodoT(-75.5439345586, 6.30588535247, 1395.34);
       System.out.println(distancia(a, b));*/
       
       
       
    }
    
    private static void testQT(){        
        QuadTree abejas = new QuadTree(); //Creo QuadTree
        //Inserto elementos en QuadTree
        insertarQuad(abejas, "D:\\10abejas.txt"); 
        System.out.println(abejas.posorden());
        //System.out.println("nivel "+abejas.nivel());
        /*System.out.println("NE"+abejas.NE().color());
        System.out.println("NW"+abejas.NW().color());
        System.out.println("SE"+abejas.SE().color());
        System.out.println("SW"+abejas.SW().color());*/
        //abejas.preorden();
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
    
    /**
     * Abre archivo y por cada linea guarda datos en QuadTree
     * 
     * @autor desconocido
     * @url http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
     */
    private static void insertarQuad(QuadTree qt,String name){
        //Abro archivo 
        //Inserto elementos en Quad tree
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
              NodoT nodo = new NodoT(Double.parseDouble(n[0])
                      , Double.parseDouble(n[1]), Double.parseDouble(n[2]));
              qt.insertar(nodo);
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
    * Retorna la distancia(en metros) entre los nodos
    */
    private static double distancia(NodoLL i, NodoLL k){
        double x1 = (i.x() * 10000)/90;
        double y1 = (i.y() * 40000)/360;
        double x2 = (k.x() * 10000)/90;
        double y2 = (k.y() * 40000)/360;
        return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2)+
                Math.pow((i.z()-k.z()),2));
    }
    
    /*
     * Retorna la distancia entre los nodos (haversine)
     *
     * @autor ananth
     * @url https://gist.github.com/vananth22/888ed9a22105670e7a4092bdcf0d72e4
     */
    private static double distancia(NodoT a, NodoT b){
        final int R = 6371; // Radious of the earth
        double latDistance = (a.x()-b.x());
        double lonDistance = (a.y()-b.y());
        double g = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
        Math.cos((b.x())) * Math.cos((a.x())) * 
        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(g), Math.sqrt(1-g));
        Double distance = R * c;
        return distance;
    }

}

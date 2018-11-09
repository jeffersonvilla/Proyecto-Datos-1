package project;

import java.lang.Math;
import java.io.*;
import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author 
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("En QuadTree");        
        testQT();
        System.out.println("\nEn LinkedList");        
        testLL();        
    }
    
    //Test algoritmo en QuadTree
    private static void testQT(){        
        QuadTree abejas = new QuadTree(); //Creo QuadTree
        //Inserto elementos en QuadTree
        insertarArchivoEnQuadTree(abejas, "C:\\temp\\Downloads\\10000abejas.txt"); 
        //Confirmamos cantidad de abejas en el quadtree
        System.out.println("Hay "+abejas.size()+" abejas en el quadtree");
        
        //Busco colisiones proximas
        long startTime1 = System.nanoTime();
        colisionesQuad(abejas,"C:\\temp\\Downloads\\colisionesq.txt"); 
        long endTime1 = System.nanoTime();
        System.out.println("Duración: " + (endTime1-startTime1)/1e6 + " ms");
        
        QuadTree colisiones = new QuadTree();
        //Comprobamos las colisiones
        insertarArchivoEnQuadTree(colisiones,"C:\\temp\\Downloads\\colisionesq.txt");
        //Imprimimos la cantidad de colisiones
        System.out.println("Hay "+colisiones.size()+" colisiones proximas");
    }
    
    //Test algoritmo en Colisiones
    private static void testLL(){        
        LL abejas = new LL();//Creo LinkedList        
        //Inserto elementos en LinkedList
        insertarArchivoEnLista(abejas, "C:\\temp\\Downloads\\10000abejas.txt");        
        //Comprobamos tamaño de la lista
        System.out.println("Hay "+abejas.size()+" abejas en la lista");
        //Ordeno respecto a x  
        Ordenamiento.quickSort(abejas);
        
        //Busco colisiones e imprimo
        long startTime2 = System.nanoTime();
        escribeListaEnArchivo(abejas,"C:\\temp\\Downloads\\" ,"c.txt");
        long endTime2 = System.nanoTime();
        System.out.println("Duración: " + (endTime2-startTime2)/1e6 + " ms");
        
        LL colisiones = new LL();
        //Comprobamos las colisiones
        insertarArchivoEnLista(colisiones, "C:\\temp\\Downloads\\c.txt");
        //Mostamos la cantidad
        System.out.println("Hay "+colisiones.size()+" colisiones proximas");
    }
    
    /**
     * Abre archivo y por cada linea guarda datos en QuadTree
     * 
     * @autor desconocido
     * @url http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
     */
    private static void insertarArchivoEnQuadTree(QuadTree qt,String name){
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
    
    private static void colisionesQuad(QuadTree q, String name){
        LinkedList<NodoT> n = new LinkedList<>();
        colisiones(q, n);
        //Escribo lista en archivo
        escribeListaEnArchivo(n, name);
        //System.out.println(n.size());
    }
    
    private static void colisiones(QuadTree q, LinkedList<NodoT> n){
        boolean added = false;
        if(q.color() != 0){//Si el tree no esta vacio
            if(q.color() != 2){ //Si el tree tiene hijos
                try{if(distancia(q.punto(),q.NE().punto())<= 100){
                   // n.addFirst(q.NE().punto());
                    if(!added){ n.addFirst(q.punto()); added = true;}
                }}catch(NullPointerException e){}
                try{if(distancia(q.punto(),q.NW().punto())<= 100){
                   // n.addFirst(q.NW().punto());
                    if(!added){ n.addFirst(q.punto()); added = true;}
                }}catch(NullPointerException e){}
                try{if(distancia(q.punto(),q.SE().punto())<= 100){
                   // n.addFirst(q.SE().punto());
                    if(!added){ n.addFirst(q.punto()); added = true;}
                }}catch(NullPointerException e){}
                try{if(distancia(q.punto(),q.SW().punto())<= 100){
                   // n.addFirst(q.SW().punto());
                    if(!added){ n.addFirst(q.punto()); added = true;}
                }}catch(NullPointerException e){}
                try{colisiones(q.NE(), n);}catch(NullPointerException e){}
                try{colisiones(q.NW(), n);}catch(NullPointerException e){}
                try{colisiones(q.SE(), n);}catch(NullPointerException e){}
                try{colisiones(q.SW(), n);}catch(NullPointerException e){}
            }else return;
        }else return;
    }
    
    /**
     * Recorre lista comparando cada par de nodos consecutivos i, k
     * e imprimiendo en una archivo cuando d(i, k) < 100
     * 
     * @autor desconocido
     * @url http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
     */
    //Implementacion para LL
    private static void escribeListaEnArchivo(LL list, String direccion, String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(direccion+nombre);
            pw = new PrintWriter(fichero);

        /*
         * @autor Jefferson
         */
        //Incio de mi codigo
        //long startTime = System.nanoTime();   
        for(NodoLL i = list.primero(); i!=list.fin().last();i = i.next()){
            NodoLL k = i.next(); 
            if(k == null) break; 
            if(distancia(i, k)<= 100){ 
                pw.println(i.x()+","+i.y()+","+i.z());
                i = i.next();
                pw.println(i.x()+","+i.y()+","+i.z());
             }
        }
        //long endTime = System.nanoTime();
        //System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
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
     * Recorre lista comparando cada par de nodos consecutivos i, k
     * e imprimiendo en una archivo cuando d(i, k) < 100
     * 
     * @autor desconocido
     * @url http://chuwiki.chuidiang.org/index.php?title=Lectura_y_Escritura_de_Ficheros_en_Java
     */
    //Implementacion para LinkedList
    private static void escribeListaEnArchivo(LinkedList<NodoT> list, String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombre);
            pw = new PrintWriter(fichero);

        /*
         * @autor Jefferson
         */
        //Incio de mi codigo
        //long startTime = System.nanoTime(); 
        NodoT k = list.getFirst();
        for(NodoT i :list){
            if(i == k)continue;
            if(distancia(i, k)<= 100)pw.println(i.x()+","+i.y()+","+i.z());
            k = i;
        }
        //long endTime = System.nanoTime();
        //System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
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
    private static void insertarArchivoEnLista(LL list, String name){
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

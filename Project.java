package project;

/**
 *
 * @author 
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //En quadtree
        //Inserto elementos en quadtree        
        //Busco prediccion de colisiones
        
        //En LinkedList
        /*LL abejas = new LL();
        NodoLL a1 = new NodoLL(-75.5618619706,6.31811259895,1375.92);
        NodoLL a2 = new NodoLL(-75.5699054633,6.35084148782,1375.89);
        NodoLL a3 = new NodoLL(-75.5636848415,6.31724585117,1368.81);
        NodoLL a4 = new NodoLL(-75.5836265641,6.31450564533,1351.39);
        NodoLL a5 = new NodoLL(-75.5318618084,6.33905462111,1318.96);
        NodoLL a6 = new NodoLL(-75.5298058637,6.34118508844,1327.07);
        NodoLL a7 = new NodoLL(-75.5492944209,6.34887049624,1327.65);
        NodoLL a8 = new NodoLL(-75.5410449586,6.32792514147,1375.53);
        NodoLL a9 = new NodoLL(-75.5488444205,6.34842049579,1307.65);
        NodoLL a10 = new NodoLL(-75.5293558632,6.34073508799,1307.07);
        */
        LL abejas = new LL();
        NodoLL a1 = new NodoLL(7,6.31811259895,1375.92);
        NodoLL a2 = new NodoLL(9,6.35084148782,1375.89);
        NodoLL a3 = new NodoLL(8,6.31724585117,1368.81);
        NodoLL a4 = new NodoLL(10,6.31450564533,1351.39);
        NodoLL a5 = new NodoLL(3,6.33905462111,1318.96);
        NodoLL a6 = new NodoLL(1,6.34118508844,1327.07);
        NodoLL a7 = new NodoLL(6,6.34887049624,1327.65);
        NodoLL a8 = new NodoLL(4,6.32792514147,1375.53);
        NodoLL a9 = new NodoLL(5,6.34842049579,1307.65);
        NodoLL a10 = new NodoLL(2,6.34073508799,1307.07);
        NodoLL a11 = new NodoLL(7,6.31811259895,1375.92);
        NodoLL a12 = new NodoLL(9,6.35084148782,1375.89);
        NodoLL a13 = new NodoLL(8,6.31724585117,1368.81);
        NodoLL a14 = new NodoLL(10,6.31450564533,1351.39);
        NodoLL a15 = new NodoLL(3,6.33905462111,1318.96);
        NodoLL a16 = new NodoLL(1,6.34118508844,1327.07);
        NodoLL a17 = new NodoLL(6,6.34887049624,1327.65);
        NodoLL a18 = new NodoLL(4,6.32792514147,1375.53);
        NodoLL a19 = new NodoLL(5,6.34842049579,1307.65);
        NodoLL a20 = new NodoLL(2,6.34073508799,1307.07);
        //Inserto elementos en LinkedList
        abejas.insertar(a1, 0);
        abejas.insertar(a2, 0);
        abejas.insertar(a3, 0);
        abejas.insertar(a4, 0);
        abejas.insertar(a5, 0);
        abejas.insertar(a6, 0);
        abejas.insertar(a7, 0);
        abejas.insertar(a8, 0);
        abejas.insertar(a9, 0);
        abejas.insertar(a10, 0);
       /* abejas.insertar(a11, 0);
        abejas.insertar(a12, 0);
        abejas.insertar(a13, 0);
        abejas.insertar(a14, 0);
        abejas.insertar(a15, 0);
        abejas.insertar(a16, 0);
        abejas.insertar(a17, 0);
        abejas.insertar(a18, 0);
        abejas.insertar(a19, 0);
        abejas.insertar(a20, 0);
        */
        //Ordeno respecto a x
        abejas.showList();
        Ordenamiento.quickSort(abejas);
        abejas.showList();
        //abejas.cambio(abejas.fin(), abejas.primero());
        //abejas.showList();
        //Ordenamiento.cambio(abejas.primero().next(), abejas.primero());
        //abejas.showList();
        
        //Comparo en rango 
        
    }
}

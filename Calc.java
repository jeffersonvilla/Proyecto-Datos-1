package detector;

/**
 *
 * @author Grupo proyecto datos 1
 */
public class Calc {
    
    /*
     * Retorna la distancia entre los nodos (haversine)
     *
     * @autor ananth
     * @url https://gist.github.com/vananth22/888ed9a22105670e7a4092bdcf0d72e4
     * @modificado por Grupo proyecto datos 1
     */
    public static double distancia(NodoT a, NodoT b){
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

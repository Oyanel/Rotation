package Graph;

import algo.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private List<Matrice> voisins;
    private Map<String, Matrice> idMatrice;
    private Map<Matrice,List<Matrice>> tableAjacence;

    private int nbSommets;
    private int nbAretes;

    public Graph() {
        init();
    }

    public List<Matrice> getVoisins() {
        return voisins;
    }

    public void setVoisins(List<Matrice> voisins) {
        this.voisins = voisins;
    }

    public Map<Matrice, List<Matrice>> getTableAjacence() {
        return tableAjacence;
    }

    public void setTableAjacence(Map<Matrice, List<Matrice>> tableAjacence) {
        this.tableAjacence = tableAjacence;
    }

    public int getNbSommets() {
        return nbSommets;
    }

    public void setNbSommets(int nbSommets) {
        this.nbSommets = nbSommets;
    }

    public int getNbAretes() {
        return nbAretes;
    }

    public void setNbAretes(int nbAretes) {
        this.nbAretes = nbAretes;
    }

    private void init() {
        Matrice m;
        tableAjacence = new HashMap<Matrice, List<Matrice>>();
        idMatrice = new HashMap<String, Matrice>();
        this.voisins = Utils.generateSommet(9);
        for (int i = 0; i < this.voisins.size(); i++) {
            idMatrice.put(Integer.toString(i), this.voisins.get(i));
            m = new Matrice(this.voisins.get(i).getValues());
            tableAjacence.put(this.voisins.get(i), m.getVoisins());
        }
        System.out.println();
    }
}

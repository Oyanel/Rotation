package Graph;

import java.util.ArrayList;

public class Matrice {
    private int values[] = new int[9];

    public Matrice(int[] values) {
        this.values = values;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public static void main(String[] args)  {
        /*int[] tab = {1,2,3,5,4,7,6,9,8};
        Matrice matrice = new Matrice(tab);
        System.out.println();
        System.out.println("voisins : ");
        ArrayList<int[]> list = matrice.getVoisins();
        for(int[] array : list) {
            for (int i = 0; i < 9; i++) {
                if((i%3) == 0){
                    System.out.println("");
                }
                System.out.print(array[i]);
            }
            System.out.println("");
        }*/
    }

    /**
     *
     * @param zone
     * 0-> haut gauche
     * 1-> haut droite
     * 2-> bas gauche
     * 3-> bas droite
     *
     * Très moche mais fonctionnel pour des matrices 2*2
     *
     * @param rot
     * 0->gauche
     * 1->droite
     *
     * @return
     */
    private int[] rotation(int zone,int rot){
        int[] sousMatrice = new int[4];
        int[] newMatrice = new int[9];
        int i =0;
        for(int value : values){
            newMatrice[i] = values[i];
            i++;
        }
        i = 0;
        switch (zone){
            case 0:
                sousMatrice[0] = this.values[0];
                sousMatrice[1] = this.values[1];
                sousMatrice[2] = this.values[3];
                sousMatrice[3] = this.values[4];
                sousMatrice = chooseRot(rot,sousMatrice);

                newMatrice[0] = sousMatrice[0];
                newMatrice[1] = sousMatrice[1];
                newMatrice[3] = sousMatrice[2];
                newMatrice[4] = sousMatrice[3];
                break;
            case 1:
                sousMatrice[0] = this.values[1];
                sousMatrice[1] = this.values[2];
                sousMatrice[2] = this.values[4];
                sousMatrice[3] = this.values[5];
                sousMatrice = chooseRot(rot,sousMatrice);

                newMatrice[1] = sousMatrice[0];
                newMatrice[2] = sousMatrice[1];
                newMatrice[4] = sousMatrice[2];
                newMatrice[5] = sousMatrice[3];
                break;
            case 2:
                sousMatrice[0] = this.values[3];
                sousMatrice[1] = this.values[4];
                sousMatrice[2] = this.values[6];
                sousMatrice[3] = this.values[7];
                sousMatrice = chooseRot(rot,sousMatrice);

                newMatrice[3] = sousMatrice[0];
                newMatrice[4] = sousMatrice[1];
                newMatrice[6] = sousMatrice[2];
                newMatrice[7] = sousMatrice[3];
                break;
            case 3:
                sousMatrice[0] = this.values[4];
                sousMatrice[1] = this.values[5];
                sousMatrice[2] = this.values[7];
                sousMatrice[3] = this.values[8];
                sousMatrice = chooseRot(rot,sousMatrice);

                newMatrice[4] = sousMatrice[0];
                newMatrice[5] = sousMatrice[1];
                newMatrice[7] = sousMatrice[2];
                newMatrice[8] = sousMatrice[3];
                break;
        }
        return newMatrice;
    }

    /**
     * Choisi en fonction de la rotation
     * @param rot
     * @param sousMatrice
     * @return
     */
    private int[] chooseRot(int rot, int[] sousMatrice){
        if(rot == 1){
            return rotationDroite(sousMatrice);
        }else{
            return rotationGauche(sousMatrice);
        }
    }

    /**
     * Rotation a droite
     * @param sousMatrice
     * @return
     */
    private int[] rotationDroite(int[] sousMatrice){
        int[] val = new int[4];
        val[0] = sousMatrice[1];
        val[1] = sousMatrice[3];
        val[2] = sousMatrice[0];
        val[3] = sousMatrice[2];
        return val;
    }


    /**
     * Rotation a gauche
     * @param sousMatrice
     * @return
     */
    private int[] rotationGauche(int[] sousMatrice){
        int[] val = new int[4];
        val[0] = sousMatrice[2];
        val[1] = sousMatrice[0];
        val[2] = sousMatrice[3];
        val[3] = sousMatrice[1];
        return val;
    }

    /**
     * renvoi les voisins du sommet
     * @return
     */
    public ArrayList<Matrice> getVoisins(){
        ArrayList<Matrice> list = new ArrayList<>();
        int[] newMatrice = new int[8];
        for(int i = 0 ; i < 4 ; i++){
            list.add(new Matrice(rotation(i,0)));
            list.add(new Matrice(rotation(i,1)));
        }
        return list;
    }
}

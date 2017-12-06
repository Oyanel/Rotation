package algo;

import Graph.Matrice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {



    public static List<Matrice> generateSommet(int n) {
        File file = new File("C:\\Users\\Epulapp\\Documents\\Cours\\Semestre 7\\Graphe\\Rotation\\sommets.txt");
        try {
            file.createNewFile();
            int base = 100000000;
            List<Matrice> listSommets = new ArrayList<>();
            FileWriter fileWriter = new FileWriter(file);
            for(int i = 0; i < fact(n); i++) {
                while(!isDoubleDigit(base)) {
                    base++;
                }

                fileWriter.write(Integer.toString(base));
                fileWriter.write("\n");

                String temp = Integer.toString(base);
                int[] newGuess = new int[temp.length()];
                for (int j = 0; j < temp.length(); j++)
                {
                    newGuess[j] = temp.charAt(j) - '0';
                }
                Matrice m = new Matrice(newGuess);
                listSommets.add(m);
                base++;
            }
            fileWriter.close();
            return listSommets;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static boolean isDoubleDigit(int num) {
        String temp = Integer.toString(num);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';
        }

        for (int i = 0; i < newGuess.length; i++)
        {
            for (int j = 0; j < newGuess.length; j++)
            {
                if(i != j) {
                    if (newGuess[i] == 0) {
                        return false;
                    }
                    if (newGuess[i] == newGuess[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int fact(int n)
    {
        int output;
        if(n==1){
            return 1;
        }
        //Recursion: Function calling itself!!
        output = fact(n-1)* n;
        return output;
    }


}

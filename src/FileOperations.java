import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class FileOperations {

    File file;
    Scanner scanner;
    Scanner fileScanner;
    int[] tab;

    public FileOperations() throws FileNotFoundException {
        this.file = new File("wyniki.txt");
        this.scanner = new Scanner(System.in);
        this.fileScanner = new Scanner(file);
    }

    public int[] getScores(){
        return tab;
    }

    public void LoadScoreFromFile(){

        tab = new int[10];
        for(int i=0; i<10; i++)
        {
            tab[i] = fileScanner.nextInt();
        }
    }

    public void ScoreUpdate(int newScore) throws FileNotFoundException {

        LoadScoreFromFile();



        boolean scoreCondidion=true;
        for(int i=0; i<10; i++){
            if(newScore==tab[i])scoreCondidion=false;
        }

        if(newScore>tab[9] && scoreCondidion==true){
            tab[9] = newScore;
        }

        Arrays.sort(tab);

        PrintWriter writer = new PrintWriter("wyniki.txt");
        for(int i=9; i>=0; i--)
        {
            writer.println(tab[i]);
        }
        writer.close();
    }


}


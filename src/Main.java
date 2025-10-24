import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<String>> xoarr = new ArrayList<>();
        xoarr.add(new ArrayList<String>());
        xoarr.add(new ArrayList<String>());
        xoarr.add(new ArrayList<String>());
        xoarr.get(0).add("1");
        xoarr.get(0).add("2");
        xoarr.get(0).add("3");
        xoarr.get(1).add("4");
        xoarr.get(1).add("5");
        xoarr.get(1).add("6");
        xoarr.get(2).add("7");
        xoarr.get(2).add("8");
        xoarr.get(2).add("9");
        boolean isdone = false;

        while (!isdone) {
            Random rand = new Random();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(" | " + xoarr.get(i).get(j) + " | ");
                }
                System.out.print("\n______________________\n");
            }
            System.out.println("where to play:");
            String player = sc.next();//taking the input from the player
            boolean islegal = isleagalPlayer(xoarr,player);
            if(isdone(xoarr)){
                break;
            }
            if(winner(xoarr)){
                break;
            }
            if(islegal){//we check here the random, is it leagal to be played or not
                boolean pclegal = false;
                while (!pclegal){
                    int pcRand = rand.nextInt(9)+1;
                    String pcRand_TOstring = String.valueOf(pcRand);
                    for(int i = 0;i<3;i++) {
                        for (int j = 0; j < 3; j++) {
                            if(xoarr.get(i).get(j).matches(pcRand_TOstring)){
                                System.out.println("pc generated :"+pcRand_TOstring);
                                xoarr.get(i).set(j, "o");
                                pclegal =true;
                                break;
                        }
                    }
                }

                }
                if (winner(xoarr)){
                    break;
                }

                System.out.println("legal");
            }

        }
    }
    static boolean winner(ArrayList<ArrayList<String>> xo){
            if((xo.get(0).get(0).matches("x") && xo.get(0).get(1).matches("x") && xo.get(0).get(2).matches("x"))||
               (xo.get(1).get(0).matches("x") && xo.get(1).get(1).matches("x") && xo.get(1).get(2).matches("x"))||
               (xo.get(2).get(0).matches("x") && xo.get(2).get(1).matches("x") && xo.get(2).get(2).matches("x")))
            {
                System.out.println("x wins");
                return true;
            }
       else if((xo.get(0).get(0).matches("x") && xo.get(1).get(0).matches("x") && xo.get(2).get(0).matches("x"))||
               (xo.get(0).get(1).matches("x") && xo.get(1).get(1).matches("x") && xo.get(2).get(1).matches("x"))||
               (xo.get(0).get(2).matches("x") && xo.get(1).get(2).matches("x") && xo.get(2).get(2).matches("x")))
            {
                System.out.println("x wins");
                return true ;
            }
        else if((xo.get(0).get(0).matches("x") && xo.get(1).get(1).matches("x") && xo.get(2).get(2).matches("x"))||
                (xo.get(2).get(0).matches("x") && xo.get(1).get(1).matches("x") && xo.get(0).get(2).matches("x")))
        {
            System.out.println("x wins");
            return true;
        }
       else if((xo.get(0).get(0).matches("o") && xo.get(0).get(1).matches("o") && xo.get(0).get(2).matches("o"))||
               (xo.get(1).get(0).matches("o") && xo.get(1).get(1).matches("o") && xo.get(1).get(2).matches("o"))||
               (xo.get(2).get(0).matches("o") && xo.get(2).get(1).matches("o") && xo.get(2).get(2).matches("o")))
        {
            System.out.println("o wins");
            return true;
        }
        else if((xo.get(0).get(0).matches("o") && xo.get(1).get(0).matches("o") && xo.get(2).get(0).matches("o"))||
                (xo.get(0).get(1).matches("o") && xo.get(1).get(1).matches("o") && xo.get(2).get(1).matches("o"))||
                (xo.get(0).get(2).matches("o") && xo.get(1).get(2).matches("o") && xo.get(2).get(2).matches("o")))
        {
            System.out.println("o wins");
            return true ;
        }
        else if((xo.get(0).get(0).matches("o") && xo.get(1).get(1).matches("o") && xo.get(2).get(2).matches("o"))||
                (xo.get(2).get(0).matches("o") && xo.get(1).get(1).matches("o") && xo.get(0).get(2).matches("o")))
        {
            System.out.println("o wins");
            return true;
        }
        return false;
    }



    static boolean isleagalPlayer(ArrayList<ArrayList<String>> xo,String playerChois){
        if (playerChois.matches("[1-9]")) {
            boolean played = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (playerChois.equalsIgnoreCase(xo.get(i).get(j))) {
                            xo.get(i).set(j, "x");
                            played = false;
                            return true;

                    }
                }
            }
            if(played){
                System.out.println("this place is played  ");
            }
        } else{
            System.out.println("please enter a number from 1-9");
            return false;
        }

        return false;
    }

    static boolean isdone(ArrayList<ArrayList<String>> xo){


        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                if( xo.get(i).get(j).matches("[1-9]")){
                    return false;
                }
            }
        }
        System.out.println("its a tie");
        return true;
    }
}
import java.util.ArrayList;
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

        while (!isdone){

            for(int i = 0;i<3;i++){
                for(int j = 0;j<3;j++){
                    System.out.print(" | "+xoarr.get(i).get(j)+" | ");
                }
                System.out.print("\n______________________\n");

            }
            System.out.println("where :");
            String player = sc.next();
            if(player.matches("[1-9]")){
                for(int i = 0;i<3;i++) {
                    for (int j = 0; j < 3; j++) {
                        if (player.equalsIgnoreCase(xoarr.get(i).get(j))){
                            xoarr.get(i).set(j,"x");
                        }
                    }
                }
            }else
                System.out.println("please enter a number from 1-9");

        isdone = isdone(xoarr);

        }


    }
    static boolean isdone(ArrayList<ArrayList<String>> xo){

        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                if( xo.get(i).get(j).matches("[1-9]")){
                    return false;
                }
            }
        }
        return true;
    }
}
package org.example.oop_project3;

import java.util.Random;

public class GameBoard {
    Random random = new Random();
    public static Card block = new Card("block",0,1,0,0,0,"");
    Card[][] board= new Card[2][21];

    public void randomnumber( ){
        int n = random.nextInt(21);
        int m = random.nextInt(21);
        this.board[0][n]=block;
        this.board[1][m]=block;
        System.out.println(n);
        System.out.println(m);
    }

}

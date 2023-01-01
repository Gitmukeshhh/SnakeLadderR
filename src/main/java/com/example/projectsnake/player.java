package com.example.projectsnake;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class player {
    private Circle gamePiece;
    int xPosition;
    int yPosition;
    int currrentPiecePosition;
    static  GameBoard gameBoard=new GameBoard();

    player(int tileSize, Color pieceColor){
        this.currrentPiecePosition=1;
        this.xPosition=gameBoard.getXValue(currrentPiecePosition);
        this.yPosition=gameBoard.getYValue(currrentPiecePosition);

        gamePiece=new Circle(tileSize/2);
        gamePiece.setFill(pieceColor);
        gamePiece.setTranslateX(this.xPosition);
        gamePiece.setTranslateY(this.yPosition);
    }

    public void  movePlayer(int diceValue){
        if(currrentPiecePosition+diceValue<=100){
            currrentPiecePosition +=diceValue;
            translatePlayer();
        }
    }

    private  void translatePlayer(){
        this.xPosition=gameBoard.getXValue(this.currrentPiecePosition);
        this.yPosition=gameBoard.getYValue(this.currrentPiecePosition);

        TranslateTransition animate=new TranslateTransition(Duration.millis(1000),this.gamePiece);
        animate.setToX(this.xPosition);
        animate.setToY(this.yPosition);
        animate.setAutoReverse(false);
        animate.play();

//        gamePiece.setTranslateX(this.xPosition);
//        gamePiece.setTranslateY(this.yPosition);
    }

     public void playerAtSnakeOrLadder(){
        int newPositon =gameBoard.playerPositionAtSnakeOrLadder(this.currrentPiecePosition);
        if(newPositon !=-1){
            this.currrentPiecePosition=newPositon;
            translatePlayer();
        }

     }




    public  Circle getGamePiece(){
        return this.gamePiece;
    }
}

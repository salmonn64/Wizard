package com.DavidDiaz.Wizard;
/**
 * Class to keep the data of a round
 */
class RoundData {
    private int numberOfRound;
    private SimpleLinkedList<TrickData> tricks;
    private SimpleLinkedList<MyPair<Player, Integer>> scoresAtTheEnd;
    private SimpleLinkedList<MyPair<Player, Integer>> predicciones;
    private int winnerFigure;
  

    public RoundData(int numberOfRound){
        this.numberOfRound = numberOfRound;
        tricks = new SimpleLinkedList<TrickData>();
        scoresAtTheEnd = new SimpleLinkedList<MyPair<Player,Integer>>();
        predicciones = new SimpleLinkedList<>();
    }

    public int getNumberOfRound(){
        return numberOfRound;
    }

    @Override
    public String toString(){
        String result = "Ronda: " + numberOfRound + "\n";
        result+= "Palo de triunfo: " + RegularCard.getFigureName(winnerFigure) + "\n";
        result+= "Predicciones: " + "\n";
        result+= predicciones.toString();
        result+= "Trucos: \n";
        result+= tricks.toString();
        result+= "Puntuaciones al final de la ronda\n";
        result+= scoresAtTheEnd.toString();
        return result;
    }

    public void addTrickData(TrickData t){
        tricks.add(t);
    }

    public void addScore(MyPair<Player, Integer> pair){
        scoresAtTheEnd.add(pair);
    }

    public void addPrediction(Player p, int number){
        MyPair<Player, Integer> pred = new MyPair<>(p, number);
        predicciones.add(pred);
    }

    public void setWinnerFigure(int figure){
        winnerFigure = figure;
    }

}

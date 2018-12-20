package epsevg.eu.Othello.Base;

public class Options {
    
    private final String p1;
    private final String p2;
    private final int prof1;
    private final int prof2;
    
    /**
     * Public constructor which stores players
     * attributes.
     * @param players Players
     * @param prof Deepness
     */
    public Options(String[] players,int[] prof)
    {
        p1 = players[0];
        p2 = players[1];
        prof1 = prof[0];
        prof2 = prof[1];
    }
        
    /* GETTERS */
    /**
     * Public method which goal is to get the first
     * players' name
     * @return First players' name
     */
    public String getFirstPlayer(){return p1;}
    
    /**
     * Public method which goal is to get the second
     * players' name
     * @return Second players' name
     */
    public String getSecondPlayer(){return p2;}
    
    /**
     * Public method which goal is to get the first
     * players' deepness.
     * @return First players' deepness.
     */
    public int getP1Prof(){return prof1;}
    
    /**
     * Public method which goal is to get the second
     * players' deepness
     * @return Second players' deepness
     */
    public int getP2Prof(){return prof2;}
}
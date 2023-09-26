package main;

import model.adapters.SquarePegAdapter;
import model.round.RoundHole;
import model.round.RoundPeg;
import model.square.SquarePeg;




public class Main {
    public static void main(String[] args) {
        // Round fits, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg rPeg = new RoundPeg(5);
        fits(rPeg,hole);

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        //fits(smallSqPeg,hole);  Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        fits(smallSqPegAdapter,hole);
        fits(largeSqPegAdapter,hole);

    }
    
    public static void fits(RoundPeg figure, RoundHole hole){
        String fit = (hole.fits(figure)) ? "fits" : "does not fit";
        System.out.println("Peg with length " + figure.getRadius() + " " + fit + " into hole with radius " + hole.getRadius() + ".");
    }
}
package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

/**
 *
 * @author Justin Jacobson
 */
public class Clorus extends Creature {

    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /** energy lost when moving */
    private double moveEnergyLoss = .03;

    /** energy gained when staying */
    private double stayEnergyLoss = .01;

    /** energy lost during replication */
    private double replicationLoss = .5;

    /**
     * creates clorus with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * creates a clorus with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    /**
     */
    public Color color() {
        g = 0;
        r = 34;
        b = 231;
        return color(r, g, b);
    }

    /**
     */
    public void attack(Creature c) {
        energy += c.energy();
    }

    /**
     */
    public void move() {
        energy -= moveEnergyLoss;
    }

    /**
     */
    public void stay() {
        energy -= stayEnergyLoss;
    }

    /**
     */
    public Clorus replicate() {
        energy = energy * replicationLoss;
        return new Clorus(energy);
    }

    /**
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipLocations = new ArrayDeque<>();
        boolean anyPlips = false;

        // (Google: Enhanced for-loop over keys of NEIGHBORS?)
        for (Direction key : neighbors.keySet()) {
            if (neighbors.get(key).name().equals("empty")) {
                emptyNeighbors.add(key);
            } else if (neighbors.get(key).name().equals("plip")) {
                anyPlips = true;
                plipLocations.add(key);
            }
        }
        // No empty squares, stay
        if (emptyNeighbors.size() == 0) {
            return new Action(Action.ActionType.STAY);
        // Rule 2, if plips, attack random
        } else if (anyPlips){
            return new Action(Action.ActionType.ATTACK, randomEntry(plipLocations));
        // Rule 3
        } else if (energy >= 1) {
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        // Rule 4
        } else {
            return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
        }
    }
}


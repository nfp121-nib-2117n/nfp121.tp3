package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.*;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.v.add(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.v.remove(this.v.size() - 1);
    }

    public Object sommet() throws PileVideException {
        if(estVide())
            throw new PileVideException();
        return this.v.lastElement();
    }

    public int taille() {
        return this.v.size();
    }

    public int capacite() {
        return this.v.capacity();
    }

    public boolean estVide() {
        return this.v.isEmpty();
    }

    public boolean estPleine() {
        return this.taille() == this.capacite();
    }

    public String toString() {
        Vector<Object> vecTemp = new Vector<Object>(taille());
        vecTemp.addAll(this.v);
        Collections.reverse(vecTemp);
        return vecTemp.toString();
    }

    public boolean equals(Object o) {
        if (o instanceof Pile3){
            Pile3 o_2 = (Pile3) o;
            return this.v.equals(o_2.v);
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}

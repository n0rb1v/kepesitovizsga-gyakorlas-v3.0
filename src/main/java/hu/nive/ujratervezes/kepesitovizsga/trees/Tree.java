package hu.nive.ujratervezes.kepesitovizsga.trees;

public abstract class Tree {
    protected int leaves;
    protected int weightOfFruit;

    public Tree(int leaves) {
        this.leaves = leaves;
    }

    public abstract int growLeaves(int i);

    public abstract void ripenFruit(int i);

    public abstract Fruit getFruit();

    public int getLeaves() {
        return leaves;
    }

    protected void incLeaves(int i) {
        leaves += i;
    }

    protected void incFruits(int i) {
        weightOfFruit += i;
    }
    public int getWeightOfFruit() {
        return weightOfFruit;
    }

    public int hostBirdNest() {
        return leaves / 200;
    }
}

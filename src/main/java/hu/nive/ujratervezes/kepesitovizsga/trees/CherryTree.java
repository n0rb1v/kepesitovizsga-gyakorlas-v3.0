package hu.nive.ujratervezes.kepesitovizsga.trees;

public class CherryTree extends Tree {
    public CherryTree(int i) {
        super(i);
    }

    @Override
    public int growLeaves(int i) {
        incLeaves(i * 20);
        return getLeaves();
    }

    @Override
    public void ripenFruit(int i) {
        incFruits(growLeaves(i) / 30);
    }

    @Override
    public Fruit getFruit() {
        return Fruit.CHERRY;
    }
}

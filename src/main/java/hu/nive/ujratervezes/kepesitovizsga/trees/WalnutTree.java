package hu.nive.ujratervezes.kepesitovizsga.trees;

public class WalnutTree extends Tree {
    public WalnutTree(int i) {
        super(i);
    }

    @Override
    public int growLeaves(int i) {
        incLeaves(i * 30);
        return getLeaves();
    }

    @Override
    public void ripenFruit(int i) {
        incFruits(growLeaves(i) / 10);
    }

    @Override
    public Fruit getFruit() {
        return Fruit.WALNUT;
    }
}

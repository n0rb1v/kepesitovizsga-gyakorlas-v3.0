package hu.nive.ujratervezes.kepesitovizsga.trees;

public class AppleTree extends Tree {
    public AppleTree(int i) {
        super(i);
    }

    @Override
    public int growLeaves(int i) {
        incLeaves(i * 10);
        return getLeaves();
    }

    @Override
    public void ripenFruit(int i) {
        incFruits(growLeaves(i) / 50);
    }

    @Override
    public Fruit getFruit() {
        return Fruit.APPLE;
    }
}

package hu.nive.ujratervezes.kepesitovizsga.ladybird;

import java.util.Objects;

public class Ladybug {
    private String hun_name;
    private String lat_name;
    private String family;
    private int points;

    public Ladybug(String hun_name, String lat_name, String family, int points) {
        this.hun_name = hun_name;
        this.lat_name = lat_name;
        this.family = family;
        this.points = points;
    }

    public String getHun_name() {
        return hun_name;
    }

    public String getLat_name() {
        return lat_name;
    }

    public String getFamily() {
        return family;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladybug)) return false;
        Ladybug ladybug = (Ladybug) o;
        return points == ladybug.points && Objects.equals(hun_name, ladybug.hun_name) && Objects.equals(lat_name, ladybug.lat_name) && Objects.equals(family, ladybug.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hun_name, lat_name, family, points);
    }
}

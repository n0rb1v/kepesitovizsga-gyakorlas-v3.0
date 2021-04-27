package hu.nive.ujratervezes.kepesitovizsga.ladybird;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Ladybird {
    private JdbcTemplate jdbc;

    public Ladybird(DataSource ds) {
        this.jdbc = new JdbcTemplate(ds);
    }

    public List<String> getLadybirdsWithExactNumberOfPoints(int i) {
        return jdbc.query("select * from ladybirds where number_of_points = ?", new Object[]{i},
                (rs, ix) -> rs.getString("hungarian_name"));
    }

    public Map<Integer, Integer> getLadybirdsByNumberOfPoints() {
        List<Integer> result = jdbc.query("select * from ladybirds",
                (rs, ix) -> rs.getInt("number_of_points"));
        return result.stream()
                .collect(Collectors.toMap(Integer::intValue, v -> 1, Integer::sum));
    }

    public Set<Ladybug> getLadybirdByPartOfLatinNameAndNumberOfPoints(String s, int i) {
        s = "(" + s + "%";
        List<Ladybug> result = jdbc.query("select * from ladybirds where number_of_points = ? and latin_name like ?"
                , new Object[]{i, s},
                (rs, ix) -> new Ladybug(
                        rs.getString("hungarian_name"),
                        rs.getString("latin_name"),
                        rs.getString("genus"),
                        rs.getInt("number_of_points")
                ));
        return Set.copyOf(result);
    }

    public Map<String, Integer> getLadybirdStatistics() {
        List<String> result = jdbc.query("select * from ladybirds",
                (rs, ix) -> rs.getString("genus"));
        return result.stream()
                .collect(Collectors.toMap(String::toString, v -> 1, Integer::sum));
    }
}

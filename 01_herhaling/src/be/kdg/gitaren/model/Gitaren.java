package be.kdg.gitaren.model;

import java.time.LocalDate;
import java.util.TreeSet;

/**
 * MULTIKLASSE
 * STUDENT: Jasper Lambrechts
 * klasgroep: TIB002
 * <p>
 * Gitaren {
 * <p>
 * brand = String
 * <p>
 * type = String
 * <p>
 * releaseDate = Date
 * <p>
 * numberOfFrets = Int
 * <p>
 * scaleLength = Double
 * <p>
 * woodUsed = Enum
 * <p>
 * Endorsed = Boolean
 * <p>
 * }
 */
public class Gitaren {

    TreeSet<Gitaar> gitaar = new TreeSet<>();

    public boolean voegToe(Gitaar gitaar) {
        return this.gitaar.add(gitaar);
    }

    public boolean verwijder(String brand, String type, LocalDate released) {
        gitaar.eq
    }
}

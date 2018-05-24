package be.kdg.gitaren.model;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import javafx.scene.transform.Scale;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

/**
 * BASISKLASSE
 * STUDENT: Jasper Lambrechts
 * klasgroep: TIB002
 * Gitaren {
 * <p>
 * brand = String
 * <p>
 * batch = string => serial number for uniqueness
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
public class Gitaar implements Comparable<Gitaar> {

    private String brand;
    private String type;
    private LocalDate releaseDate;
    private int numOfFrets;
    private double ScaleLength;
    private String wood; // = Wood.Mahogany.name();
    private boolean endorsed;

    public Gitaar() {
        setBrand("Unknown");
        setType("Unknown");
        setReleaseDate(LocalDate.of(1988, 05, 30));
        setNumOfFrets(54);
        setScaleLength(50);
        setWood(Wood.Mahogany.name());
        setEndorsed(true);
    }

    public Gitaar(String brand, String batch, LocalDate releaseDate, int numOfFrets, double scaleLength, String wood, boolean endorsed) {

        setBrand(brand);
        setType(batch);
        setReleaseDate(releaseDate);
        setNumOfFrets(numOfFrets);
        setScaleLength(scaleLength);
        setWood(wood);
        setEndorsed(endorsed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null)
            this.brand = brand;
        else {
            throw new IllegalArgumentException("Can't set brand. Value must be a string and cannot be empty!");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null)
            this.type = type;
        else {
            throw new IllegalArgumentException("Can't set batch. Value must be a string and cannot be empty!");
        }
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        LocalDate currentDate = LocalDate.now();
        if (releaseDate != null && releaseDate.isBefore(currentDate)) {
            this.releaseDate = releaseDate;
        } else {
            throw new IllegalArgumentException("Can't set release date.Value must be a LocalDateTime and cannot be empty!");
        }
    }

    public int getNumOfFrets() {
        return numOfFrets;
    }

    public void setNumOfFrets(int numOfFrets) {
        if (numOfFrets > 0) {
            this.numOfFrets = numOfFrets;
        } else {
            throw new IllegalArgumentException("Can't set number of frets.Value must be greater than zero");
        }

    }

    public double getScaleLength() {
        return ScaleLength;
    }

    public void setScaleLength(double scaleLength) {
        if (ScaleLength > 10 && scaleLength < 500) {
            ScaleLength = scaleLength;
        } else {
            throw new IllegalArgumentException("Can't set Scale Length.Value must be between 10 and 500");
        }

    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        if (wood != null) {
            this.wood = wood;
        } else {
            throw new IllegalArgumentException("Can't set Wood Type.Value must not be a String and not empty");
        }

    }

    public boolean isEndorsed() {
        return endorsed;
    }

    public void setEndorsed(boolean endorsed) {
        try {
            this.endorsed = endorsed;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Can't set endorsed boolean.Value must be a boolean");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gitaar gitaar = (Gitaar) o;
        return Objects.equals(getBrand(), gitaar.getBrand()) &&
                Objects.equals(getType(), gitaar.getType()) &&
                Objects.equals(getReleaseDate(), gitaar.getReleaseDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBrand(), getType(), getReleaseDate());
    }


    @Override
    public int compareTo(Gitaar o) {
        return Comparator.comparing(Gitaar::getBrand)
                .thenComparing(Gitaar::getType)
                .thenComparing(Gitaar::getReleaseDate)
                .compare(this, o);
    }

    @Override
    public String toString() {

        return String.format("%s \t\t %s \t\t %s \t\t  Frets: %d \t\t Scale Length: %5.2f \t\t\t Released: %tY"
                , brand
                , type
                , wood
                , numOfFrets
                , ScaleLength
                , releaseDate);
    }
}

package be.kdg.gitaren.model;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import javafx.scene.transform.Scale;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class Gitaar {

    private String brand;
    private String batch;
    private LocalDate releaseDate;
    private int numOfFrets;
    private double ScaleLength;
    private String wood; // = Wood.Mahogany.name();
    private boolean endorsed;

    public Gitaar() {
        setBrand("Unknown");
        setBatch("Unknown");
        setReleaseDate(LocalDate.of(1988,05,30));
        setNumOfFrets(54);
        setScaleLength(50);
        setWood(Wood.Mahogany.name());
        setEndorsed(true);
    }
    public Gitaar(String brand, String batch, LocalDate releaseDate, int numOfFrets, double scaleLength, String wood, boolean endorsed) {

        setBrand(brand);
        setBatch(batch);
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
        return batch;
    }

    public void setBatch(String type) {
        if (type != null)
            this.batch = type;
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
}

package Clases.Modelos;
public class Perro {

    private String image_link = "";
    private String name;
    private int max_life_expectancy;
    private int min_life_expectancy;
    private int energy;
    private int trainability;
    private int protectiveness;

    public String GetImage() {
        return image_link;
    }

    public String GetName() {
        return name;
    }

    public int GetMaxLife() {
        return this.max_life_expectancy;
    }

    public int GetMinLife() {
        return this.min_life_expectancy;
    }

    public String GetEnergy() {
        var result = "Normal";

        if (this.energy < 2) {
            result = "Baja";
        } else if (this.energy > 3) {
            result = "Alta";
        }
        return result;
    }

    public String GetTrainability() {
        var result = "Neutro";

        if (this.trainability < 2) {
            result = "Facil";
        } else if (this.trainability > 3) {
            result = "Dificil";
        }
        return result;
    }

    public String GetProtectiveness() {
        var result = "Media";

        if (this.protectiveness < 2) {
            result = "Minima";
        } else if (this.protectiveness > 3) {
            result = "Maxima";
        }
        return result;
    }
    
}

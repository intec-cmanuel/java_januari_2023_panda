package be.intecbrussel;

import java.util.Objects;

public class PostCard {
    private String country;
    private String continent;

    public PostCard(String country, String continent) {
        this.country = country;
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostCard)) return false;
        PostCard postCard = (PostCard) o;
        return Objects.equals(getCountry(), postCard.getCountry()) && Objects.equals(getContinent(), postCard.getContinent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getContinent());
    }

    @Override
    public String toString() {
        return "PostCard{" +
                "country='" + country + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}

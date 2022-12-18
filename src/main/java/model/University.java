package model;

import com.google.gson.annotations.SerializedName;

public class University {
    @SerializedName("universityId")
    private String id;
    @SerializedName("universityFullName")
    private String fullName;
    @SerializedName("universityShortName")
    private String shortName;
    @SerializedName("universityYearOfFoundation")
    private int yearOfFoundation;

    public University(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    @Override
    public String toString(){
        return "Университет<" +
                "   аббр:" + shortName +
                "   название:" + fullName +
                "   год образования:" + yearOfFoundation +
                "   id:" + id +
                ">";
    }
}

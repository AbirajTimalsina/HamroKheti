package model;

public class techinfo {

    String techinfo_title, techinfo_image;

    public techinfo(String techinfo_title, String techinfo_image) {
        this.techinfo_title = techinfo_title;
        this.techinfo_image = techinfo_image;
    }

    public String getTechinfo_title() {
        return techinfo_title;
    }

    public void setTechinfo_title(String techinfo_title) {
        this.techinfo_title = techinfo_title;
    }

    public String getTechinfo_image() {
        return techinfo_image;
    }

    public void setTechinfo_image(String techinfo_image) {
        this.techinfo_image = techinfo_image;
    }
}

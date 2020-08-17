package model;

public class techinfo {

    private String _id,techinfo_title, techinfo_image;

    public techinfo(String _id, String techinfo_title, String techinfo_image) {
        this._id = _id;
        this.techinfo_title = techinfo_title;
        this.techinfo_image = techinfo_image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

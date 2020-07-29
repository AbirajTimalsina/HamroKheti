package model;

public class bugsinfo {

    private String _id;
    private String title;
    private String bugsinfo_image;

    public bugsinfo(String _id, String title, String bugsinfo_image) {
        this._id = _id;
        this.title = title;
        this.bugsinfo_image = bugsinfo_image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBugsinfo_image() {
        return bugsinfo_image;
    }

    public void setBugsinfo_image(String bugsinfo_image) {
        this.bugsinfo_image = bugsinfo_image;
    }
}

package model;

public class bugsDetail {

    private String _id;
    private String bugsDetail_body, bugsDetail_image;

    public bugsDetail(String _id, String bugsDetail_body, String bugsDetail_image) {
        this._id = _id;
        this.bugsDetail_body = bugsDetail_body;
        this.bugsDetail_image = bugsDetail_image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBugsDetail_body() {
        return bugsDetail_body;
    }

    public void setBugsDetail_body(String bugsDetail_body) {
        this.bugsDetail_body = bugsDetail_body;
    }

    public String getBugsDetail_image() {
        return bugsDetail_image;
    }

    public void setBugsDetail_image(String bugsDetail_image) {
        this.bugsDetail_image = bugsDetail_image;
    }
}

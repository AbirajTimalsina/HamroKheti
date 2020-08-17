package model;

public class techDetail {

    private String _id;
    private String techDetail_body,techDetail_image;

    public techDetail(String _id, String techDetail_body, String techDetail_image) {
        this._id = _id;
        this.techDetail_body = techDetail_body;
        this.techDetail_image = techDetail_image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTechDetail_body() {
        return techDetail_body;
    }

    public void setTechDetail_body(String techDetail_body) {
        this.techDetail_body = techDetail_body;
    }

    public String getTechDetail_image() {
        return techDetail_image;
    }

    public void setTechDetail_image(String techDetail_image) {
        this.techDetail_image = techDetail_image;
    }
}

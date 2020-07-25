package model;

public class category {

    private String _id;
    private String category;
    private String category_image;

    public category(String _id, String category, String category_image) {
        this._id = _id;
        this.category = category;
        this.category_image = category_image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory_image() {
        return category_image;
    }

    public void setCategory_image(String category_image) {
        this.category_image = category_image;
    }
}

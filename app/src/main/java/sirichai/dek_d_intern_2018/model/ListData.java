package sirichai.dek_d_intern_2018.model;

/**
 * Created by atomiz on 22/2/2561.
 */

public class ListData {
    private String img;
    private String title;
    private String message;

    public ListData(String img, String title, String message) {
        this.img = img;
        this.title = title;
        this.message = message;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

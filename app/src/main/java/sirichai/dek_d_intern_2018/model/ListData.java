package sirichai.dek_d_intern_2018.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by atomiz on 22/2/2561.
 */

public class ListData implements Parcelable {

    public static final Creator<ListData> CREATOR = new Creator<ListData>() {
        @Override
        public ListData createFromParcel(Parcel in) {
            return new ListData(in);
        }

        @Override
        public ListData[] newArray(int size) {
            return new ListData[size];
        }
    };
    private String img;
    private String title;
    private String message;

    public ListData(String img, String title, String message) {
        this.img = img;
        this.title = title;
        this.message = message;
    }

    protected ListData(Parcel in) {
        img = in.readString();
        title = in.readString();
        message = in.readString();
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

    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("Img", img);
            obj.put("Title", title);
            obj.put("Message", message);
        } catch (JSONException e) {
            Log.e("convertJson", e.toString());
        }
        return obj;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(img);
        dest.writeString(title);
        dest.writeString(message);
    }
}

package models;

import java.io.Serializable;

public class ItemModel  implements Serializable {
    private String mImage;
    private String mDescription;
    private String mTitle;

    public ItemModel() {
    }

    public ItemModel(String mImage, String mDescription, String mTitle) {
        this.mImage = mImage;
        this.mDescription = mDescription;
        this.mTitle = mTitle;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

}

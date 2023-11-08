package my.snacksquad.app;

import android.os.Parcel;
import android.os.Parcelable;

public class dishh implements Parcelable {
    private String name;
    private String description;
    private String rating;
    private String price;
    private int id;
    private int quantity;
    protected dishh(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        rating = in.readString();
        price = in.readString();
        quantity = in.readInt();
    }
    public static final Creator<dishh> CREATOR = new Creator<dishh>() {
        @Override
        public dishh createFromParcel(Parcel in) {
            return new dishh(in);
        }

        @Override
        public dishh[] newArray(int size) {
            return new dishh[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(rating);
        dest.writeString(price);
        dest.writeInt(quantity);
    }


    public dishh(int id,String name, String description, String rating, String price) {
        this.id = id;

        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
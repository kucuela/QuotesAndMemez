package com.chikeandroid.tutsplus_glide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Chike on 2/11/2017.
 */

public class SpacePhoto implements Parcelable {

    private String mUrl;
    private String mTitle;

    public SpacePhoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected SpacePhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<SpacePhoto> CREATOR = new Creator<SpacePhoto>() {
        @Override
        public SpacePhoto createFromParcel(Parcel in) {
            return new SpacePhoto(in);
        }

        @Override
        public SpacePhoto[] newArray(int size) {
            return new SpacePhoto[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static  SpacePhoto[] getSpacePhotos() {

        return new SpacePhoto[]{


                new SpacePhoto("https://i.imgur.com/ghF0bfy.jpg","image"),

                new SpacePhoto("https://i.imgur.com/OizGPCW.jpg","image"),
                new SpacePhoto("https://i.imgur.com/Hjg73f2.jpg","image"),

                new SpacePhoto("https://i.imgur.com/r51zRbM.jpg","image"),
                new SpacePhoto("https://i.imgur.com/cMU99HW.jpg","image"),

                new SpacePhoto("https://i.imgur.com/CDeyiJ7.jpg","image"),
                new SpacePhoto("https://i.imgur.com/gtmK3Ha.jpg","image"),
                new SpacePhoto("https://i.imgur.com/5sQnyMW.jpg","image"),
                new SpacePhoto("https://i.imgur.com/BqzznpB.jpg","image"),
                new SpacePhoto("https://i.imgur.com/aVaLzhC.jpg","image"),
                new SpacePhoto("https://i.imgur.com/89RSQzL.jpg","image"),
                new SpacePhoto("https://i.imgur.com/g3ijvCy.jpg","image"),
                new SpacePhoto("https://i.imgur.com/tZt8QMb.jpg","image"),
                new SpacePhoto("https://i.imgur.com/lsty73w.jpg","image"),
                new SpacePhoto("https://i.imgur.com/5vs3HPA.jpg","image"),
                new SpacePhoto("https://i.imgur.com/LvyczPl.jpg","image"),
                new SpacePhoto("https://i.imgur.com/d49VNSA.jpg","image"),
                new SpacePhoto("https://i.imgur.com/QHJ1to2.jpg","image"),
                new SpacePhoto("https://i.imgur.com/SuB19j6.jpg","image"),
                new SpacePhoto("https://i.imgur.com/57WLVoE.jpg","image"),
                new SpacePhoto("https://i.imgur.com/5x4lBKq.jpg","image"),
                new SpacePhoto("https://i.imgur.com/FBxMvXL.jpg","image"),
                new SpacePhoto("https://i.imgur.com/3o3fVjz.jpg","image"),
                new SpacePhoto("https://i.imgur.com/j43EVeD.jpg","image"),
                new SpacePhoto("https://i.imgur.com/SmqWj65.jpg","image"),
                new SpacePhoto("https://i.imgur.com/CsEoS7m.jpg","image"),
                new SpacePhoto("https://i.imgur.com/SWgaQzH.jpg","image"),
                new SpacePhoto("https://i.imgur.com/vzo8y49.jpg","image"),
                new SpacePhoto("https://i.imgur.com/wkCbnZB.jpg","image"),

                new SpacePhoto("https://i.imgur.com/RIpQR3N.jpg","image"),
                new SpacePhoto("https://i.imgur.com/XnC5ag7.jpg","image"),
                new SpacePhoto("https://i.imgur.com/CGhDQlL.jpg","image"),
                new SpacePhoto("https://i.imgur.com/bqAUxGy.jpg","image"),
                new SpacePhoto("https://i.imgur.com/R493yFY.jpg","image"),
                new SpacePhoto("https://i.imgur.com/yn11VQl.jpg","image"),
                new SpacePhoto("https://i.imgur.com/v08tEOK.jpg","image"),
                new SpacePhoto("https://i.imgur.com/sVn1Brt.jpg","image"),
                new SpacePhoto("https://i.imgur.com/Ng9aB4u.jpg","image"),
                new SpacePhoto("https://i.imgur.com/0FAIBC0.jpg","image"),



                new SpacePhoto("https://i.imgur.com/3wuvD8Z.jpg","image"),

                new SpacePhoto("https://i.imgur.com/Coqlwbh.jpg","image"),
                new SpacePhoto("https://i.imgur.com/eYQhov9.jpg","image"),
                new SpacePhoto("https://i.imgur.com/Ro4tDwo.jpg","image"),
                new SpacePhoto("https://i.imgur.com/JTfejPk.jpg","image"),
                new SpacePhoto("https://i.imgur.com/PAbimk0.jpg","image"),
                new SpacePhoto("https://i.imgur.com/GO4znah.jpg","image"),
                new SpacePhoto("https://i.imgur.com/8edmMdf.jpg","image"),
                new SpacePhoto("https://i.imgur.com/hCcCK2i.jpg","image"),
                new SpacePhoto("https://i.imgur.com/aQt3LrI.jpg","image"),

                new SpacePhoto("https://i.imgur.com/e2PsATM.png","image"),

                new SpacePhoto("https://i.imgur.com/RJxik2F.jpg","image"),


                new SpacePhoto("https://i.imgur.com/PTKKPge.jpg","image"),


                new SpacePhoto("https://i.imgur.com/xbKgTP6.jpg","image"),

                new SpacePhoto("https://i.imgur.com/1nMrFDv.png","image"),
                new SpacePhoto("https://i.imgur.com/W0Urkmu.jpg","image"),
                new SpacePhoto("https://i.imgur.com/r0SRiBS.jpg","image"),




        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}

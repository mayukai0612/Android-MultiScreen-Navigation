package com.monash.yukaima.multi_screennavigation;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yukaima on 20/03/16.
 */
public class UserInfo implements Parcelable {
    private String firstname;
    private String surname;
    private String mothersMaidenName;
    private String birthPlace;
    private String favouriteBrand;

    public UserInfo() {


    }

    public UserInfo(String firstname, String surname, String mothersMaidenName, String birthPlace, String favouriteBrand) {
        this.firstname = firstname;
        this.surname = surname;
        this.mothersMaidenName = mothersMaidenName;
        this.birthPlace = birthPlace;
        this.favouriteBrand = favouriteBrand;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }

    public String getFavouriteBrand() {
        return favouriteBrand;
    }

    public void setFavouriteBrand(String favouriteBrand) {
        this.favouriteBrand = favouriteBrand;
    }



    protected UserInfo(Parcel in) {
        firstname = in.readString();
        surname = in.readString();
        mothersMaidenName = in.readString();
        birthPlace = in.readString();
        favouriteBrand = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(surname);
        dest.writeString(mothersMaidenName);
        dest.writeString(birthPlace);
        dest.writeString(favouriteBrand);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
package com.madrefoca.cafe_tango.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Mauro on 17/08/2017.
 */

@DatabaseTable(tableName = "SchoolHouse")
public class SchoolHouse implements Parcelable {

    @DatabaseField(generatedId = true)
    private Integer schoolHouseId;

    @DatabaseField
    private String schoolName;

    @DatabaseField
    private String description;

    public SchoolHouse() {
    }

    public int getSchoolHouseId() {
        return schoolHouseId;
    }

    public void setSchoolHouseId(int schoolHouseId) {
        this.schoolHouseId = schoolHouseId;
    }

    public SchoolHouse(String name, String description) {
        this.schoolName = name;
        this.description = description;
    }

    public void setSchoolHouseId(Integer schoolHouseId) {
        this.schoolHouseId = schoolHouseId;
    }

    public String getSchoolName() {

        return schoolName;
    }

    public void setName(String name) {

        this.schoolName = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     * @see #CONTENTS_FILE_DESCRIPTOR
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(schoolName);
        dest.writeString(description);
    }

    public SchoolHouse(Parcel in) {
        schoolName = in.readString();
        description = in.readString();
    }

    public static final Parcelable.Creator<SchoolHouse> CREATOR = new Parcelable.Creator<SchoolHouse>() {
        public SchoolHouse createFromParcel(Parcel in) {
            return new SchoolHouse(in);
        }

        public SchoolHouse[] newArray(int size) {
            return new SchoolHouse[size];
        }
    };
}

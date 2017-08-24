package com.madrefoca.cafe_tango.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Mauro on 17/08/2017.
 */

@DatabaseTable
public class SchoolHouse implements Parcelable {

    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String description;

    public SchoolHouse() {
    }

    public SchoolHouse(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
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
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
    }

    public SchoolHouse(Parcel in) {
        id = in.readInt();
        name = in.readString();
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

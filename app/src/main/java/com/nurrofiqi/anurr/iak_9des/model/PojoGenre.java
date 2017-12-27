package com.nurrofiqi.anurr.iak_9des.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by anurr on 12/13/2017.
 */

public class PojoGenre  {

    private List<GenresBean> genres;

    public List<GenresBean> getGenres() {
        return genres;
    }

    public void setGenres(List<GenresBean> genres) {
        this.genres = genres;
    }

    public static class GenresBean implements Parcelable {
        /**
         * id : 28
         * name : Action
         */

        private int id;
        private String name;

        protected GenresBean(Parcel in) {
            id = in.readInt();
            name = in.readString();
        }

        public static final Creator<GenresBean> CREATOR = new Creator<GenresBean>() {
            @Override
            public GenresBean createFromParcel(Parcel in) {
                return new GenresBean(in);
            }

            @Override
            public GenresBean[] newArray(int size) {
                return new GenresBean[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
        }
    }
}

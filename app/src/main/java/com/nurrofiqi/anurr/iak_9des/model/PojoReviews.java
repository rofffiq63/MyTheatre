package com.nurrofiqi.anurr.iak_9des.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by anurr on 12/25/2017.
 */

public class PojoReviews {
    /**
     * id : 324852
     * page : 1
     * results : [{"id":"59821cf8c3a3680d3201a5fb","author":"paulv","content":"Nothing will beat the first film. The originality fades with most sequels. Unfortunately this is more the rule rather than the exception. For the same reason, I hope they don't bother to create another \"Rango\". That was another fun and brilliant animation in my opinion. Kids will like it and by all means don't avoid it. Just don't have high expectations.","url":"https://www.themoviedb.org/review/59821cf8c3a3680d3201a5fb"}]
     * total_pages : 1
     * total_results : 1
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean implements Parcelable {
        /**
         * id : 59821cf8c3a3680d3201a5fb
         * author : paulv
         * content : Nothing will beat the first film. The originality fades with most sequels. Unfortunately this is more the rule rather than the exception. For the same reason, I hope they don't bother to create another "Rango". That was another fun and brilliant animation in my opinion. Kids will like it and by all means don't avoid it. Just don't have high expectations.
         * url : https://www.themoviedb.org/review/59821cf8c3a3680d3201a5fb
         */

        private String id;
        private String author;
        private String content;
        private String url;

        protected ResultsBean(Parcel in) {
            id = in.readString();
            author = in.readString();
            content = in.readString();
            url = in.readString();
        }

        public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
            @Override
            public ResultsBean createFromParcel(Parcel in) {
                return new ResultsBean(in);
            }

            @Override
            public ResultsBean[] newArray(int size) {
                return new ResultsBean[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(author);
            dest.writeString(content);
            dest.writeString(url);
        }
    }
}

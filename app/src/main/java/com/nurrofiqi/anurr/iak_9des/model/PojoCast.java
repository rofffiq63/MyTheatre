package com.nurrofiqi.anurr.iak_9des.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by anurr on 1/2/2018.
 */

public class PojoCast implements Parcelable{
    /**
     * id : 353486
     * cast : [{"cast_id":5,"character":"Dr. Smolder Bravestone","credit_id":"57436abfc3a3686d990007b9","gender":2,"id":18918,"name":"Dwayne Johnson","order":0,"profile_path":"/akweMz59qsSoPUJYe7QpjAc2rQp.jpg"},{"cast_id":6,"character":"Professor Shelly Oberon","credit_id":"57436ac6c3a3686ffd002c6c","gender":2,"id":70851,"name":"Jack Black","order":1,"profile_path":"/kAyKg3rYGgIhB5KRaIWALuf78W3.jpg"},{"cast_id":7,"character":"Moose Finbar","credit_id":"57436ace9251411dc8002e79","gender":2,"id":55638,"name":"Kevin Hart","order":2,"profile_path":"/9zxRAhWMxhVrgDnUysvTGLW7fcW.jpg"},{"cast_id":9,"character":"Ruby Roundhouse","credit_id":"57c5f7659251412147000162","gender":1,"id":543261,"name":"Karen Gillan","order":3,"profile_path":"/b6rSmkcM3XvSxCb3aLEP8JaG07q.jpg"},{"cast_id":8,"character":"Alex","credit_id":"57c5f75ec3a3682072000170","gender":2,"id":130565,"name":"Nick Jonas","order":4,"profile_path":"/yDjPQfp3LKp1QnETYhWHOKOQ5lw.jpg"},{"cast_id":13,"character":"Nigel","credit_id":"57e992d59251411096002e69","gender":2,"id":82666,"name":"Rhys Darby","order":5,"profile_path":"/LEqoJOUNZxyZEp5dQy5MaM93m1.jpg"},{"cast_id":14,"character":"Spencer","credit_id":"581b9d1f92514115ca002ff0","gender":0,"id":934281,"name":"Alex Wolff","order":6,"profile_path":"/9lQRfwfWLKafxEK5xoZqGCeKkcS.jpg"},{"cast_id":15,"character":"Bethany","credit_id":"581b9d2bc3a368695e002b01","gender":1,"id":1597855,"name":"Madison Iseman","order":7,"profile_path":"/b3Jj2S2faoxKjo93csGIAUwW0YY.jpg"},{"cast_id":16,"character":"Principal Bentley","credit_id":"581b9d3ac3a368695b002eba","gender":2,"id":141956,"name":"Marc Evan Jackson","order":8,"profile_path":"/1Zk6fLOvRmkWGD58o1iFMSFaTm9.jpg"},{"cast_id":17,"character":"Anthony 'Fridge' Johnson","credit_id":"581b9d47c3a368695e002b1f","gender":2,"id":1160181,"name":"Ser'Darius Blain","order":9,"profile_path":"/qpHplsNLribEDcrnHzC8EvQ8FSz.jpg"},{"cast_id":18,"character":"Martha","credit_id":"581b9d6092514115d700338d","gender":0,"id":1188567,"name":"Morgan Turner","order":10,"profile_path":"/qT1HFFYeW0G4ODQ1EmxUcHa4TIb.jpg"},{"cast_id":19,"character":"Gym Student","credit_id":"58503317c3a3682fb800d5d1","gender":2,"id":1722293,"name":"Ivory J. Taylor","order":11,"profile_path":null},{"cast_id":20,"character":"Coach Webb","credit_id":"589c09e5925141254b000711","gender":1,"id":1294,"name":"Missi Pyle","order":12,"profile_path":"/gjJiT50eCgPMRsIKl03v64CJOPf.jpg"},{"cast_id":21,"character":"Bethany's Teacher","credit_id":"589c0a14c3a3684ce20049ce","gender":1,"id":207250,"name":"Maribeth Monroe","order":13,"profile_path":"/tXXFnOhRs405ZXjAPG3LecP772r.jpg"},{"cast_id":23,"character":"Old Man Vreeke","credit_id":"589c0a4b9251412537000874","gender":2,"id":21561,"name":"Tim Matheson","order":15,"profile_path":"/iQQCtIS9bQJlQ8OMOzeidsJptAQ.jpg"},{"cast_id":24,"character":"The Spy","credit_id":"589c0a65c3a3684ce2004ac4","gender":0,"id":1514475,"name":"Juan Gaspard","order":16,"profile_path":"/drwzIvBgEE5A4o5XanikZR5LfEO.jpg"},{"cast_id":25,"character":"","credit_id":"59536d90c3a368382e0166e2","gender":2,"id":21127,"name":"Bobby Cannavale","order":17,"profile_path":"/o3xnmePoOUCw7sjoZ4xM4W5DL26.jpg"},{"cast_id":27,"character":"Jogger's Wife","credit_id":"599227e0925141042a005698","gender":1,"id":1104568,"name":"Sylvia Jefferies","order":18,"profile_path":"/jtbJjvDrGAuBW3OGHSCGekuVo8J.jpg"},{"cast_id":28,"character":"Amazon Warrior","credit_id":"599227e1c3a3682382005748","gender":1,"id":1718174,"name":"Friday Chamberlain","order":19,"profile_path":"/sZ2ze7BffkwUqh8XXAy9KubtGhI.jpg"},{"cast_id":29,"character":"Bazaar Vendor","credit_id":"599227e1c3a368230d005bfe","gender":0,"id":1304336,"name":"Danny Pardo","order":20,"profile_path":"/aY164UTFbcnGEgxCk0ed9N3eFro.jpg"},{"cast_id":30,"character":"Berber lady","credit_id":"599228e5c3a368230d005d1e","gender":0,"id":1799059,"name":"Natasha Mayet","order":21,"profile_path":null},{"cast_id":31,"character":"High School Student","credit_id":"599228e6c3a368230d005d21","gender":0,"id":1810540,"name":"Ruby Bustamante","order":22,"profile_path":null},{"cast_id":32,"character":"Alex's Wife","credit_id":"599228e692514104370058d7","gender":1,"id":804206,"name":"Virginia Newcomb","order":23,"profile_path":"/xFzX0z5wl1VEkq6AzWdqFNHg8Za.jpg"},{"cast_id":33,"character":"Vendor","credit_id":"599228e79251410470005cac","gender":2,"id":1382836,"name":"William Tokarsky","order":24,"profile_path":"/xZrfbq4oXcDCeBhHVmMvDrI0YTb.jpg"},{"cast_id":33,"character":"Cute Bazar Kid","credit_id":"599228e7c3a3682382005828","gender":0,"id":1842697,"name":"Maiya Boyd","order":24,"profile_path":null},{"cast_id":34,"character":"Boyfriend","credit_id":"599228e7c3a368230d005d23","gender":0,"id":1842696,"name":"Jonnah-Blaine Bowling","order":25,"profile_path":null},{"cast_id":35,"character":"Knife Vendor","credit_id":"599228e7c3a3682392005c30","gender":2,"id":1154191,"name":"John Archer Lundgren","order":26,"profile_path":"/tyyLGVsteiRS4JsuC2FQVwUUVGz.jpg"},{"cast_id":36,"character":"Jogger's Son","credit_id":"599228e792514104840054b6","gender":0,"id":1518688,"name":"Mason Guccione","order":27,"profile_path":null},{"cast_id":37,"character":"Gypsy Cowboy","credit_id":"599228e8c3a36823c90056cd","gender":0,"id":1869723,"name":"Ted Williams","order":28,"profile_path":null},{"cast_id":38,"character":"Cute girl","credit_id":"599228e8925141042a00579d","gender":0,"id":1869724,"name":"Najah Jackson","order":29,"profile_path":null},{"cast_id":39,"character":"Kid #2","credit_id":"599228e8925141048b005ab9","gender":0,"id":1783721,"name":"Maddie Nichols","order":30,"profile_path":null},{"cast_id":40,"character":"Fridge's Mom","credit_id":"599228e99251410470005caf","gender":0,"id":1549537,"name":"Tracey Bonner","order":31,"profile_path":"/pqD39uTR6O6BeQ8Rw4YFikcuDd1.jpg"},{"cast_id":41,"character":"Gym Teacher","credit_id":"599228e99251410470005cb3","gender":0,"id":1083987,"name":"Jamie Renell","order":32,"profile_path":"/bdGhyb8657S8vW8gEtw0bvH475u.jpg"},{"cast_id":42,"character":"Bethany's Mom","credit_id":"599228e992514104480057d1","gender":0,"id":1869725,"name":"Natasha Charles Parker","order":33,"profile_path":null},{"cast_id":43,"character":"High School Jock","credit_id":"599228ea925141046a00564b","gender":0,"id":1869726,"name":"Darian Baker","order":34,"profile_path":null},{"cast_id":44,"character":"Eccentric Woman","credit_id":"599228eac3a368238200583e","gender":0,"id":1869727,"name":"Sarah Fawaz","order":35,"profile_path":null},{"cast_id":45,"character":"Dragoon / Raven","credit_id":"599228eac3a36823590057ae","gender":0,"id":1869728,"name":"Max Ortiz Jr.","order":36,"profile_path":null},{"cast_id":46,"character":"High School Administrator","credit_id":"599228eb925141042a0057a2","gender":0,"id":1856132,"name":"William Walker","order":37,"profile_path":null},{"cast_id":47,"character":"Bazaar Vendor","credit_id":"599228eb925141042a0057a4","gender":0,"id":1767219,"name":"Tahseen Ghauri","order":38,"profile_path":"/63aehtREPF3tWAxReTkJeMhqZGF.jpg"},{"cast_id":48,"character":"Neighbor","credit_id":"599228eb925141042a0057a6","gender":0,"id":1752962,"name":"Jemarko Jones","order":39,"profile_path":null},{"cast_id":49,"character":"High School Student","credit_id":"599228eb925141046a005650","gender":0,"id":1869729,"name":"Daniel Salyers","order":40,"profile_path":null},{"cast_id":50,"character":"Kid #3","credit_id":"599228ec9251410430005928","gender":0,"id":1869730,"name":"Ashley Lonardo","order":41,"profile_path":null},{"cast_id":51,"character":"Vendor","credit_id":"599228ecc3a368230d005d2d","gender":0,"id":1869731,"name":"Demetrice Nguyen","order":42,"profile_path":null},{"cast_id":52,"character":"Berber","credit_id":"599228ecc3a36823590057b8","gender":0,"id":1869732,"name":"Jonathan Louis Ramos","order":43,"profile_path":null},{"cast_id":53,"character":"Neighbor","credit_id":"599228ed925141042a0057aa","gender":0,"id":1869733,"name":"Martin Feigen","order":44,"profile_path":null},{"cast_id":54,"character":"Bazaar Patron","credit_id":"599228edc3a3682382005847","gender":0,"id":1869734,"name":"Leeza Jones","order":45,"profile_path":null},{"cast_id":55,"character":"Skater Punk","credit_id":"599228edc3a36823c90056d5","gender":0,"id":582339,"name":"Tad Sallee","order":46,"profile_path":"/QCvfQXMMsyf09yCbH9V0TpxsII.jpg"},{"cast_id":56,"character":"Letterman","credit_id":"599228eec3a368236d0050a8","gender":0,"id":1869735,"name":"Tyler Stormant","order":47,"profile_path":null},{"cast_id":57,"character":"Jogger","credit_id":"599228eec3a36823590057c1","gender":0,"id":1869736,"name":"Sean Buxton","order":48,"profile_path":null},{"cast_id":58,"character":"Fussfeld","credit_id":"599228eec3a368238200584c","gender":0,"id":1869737,"name":"Michael Shacket","order":49,"profile_path":null},{"cast_id":59,"character":"High School Gym Student","credit_id":"599228ef9251410470005cba","gender":0,"id":1869738,"name":"Cory Michael Peeler","order":50,"profile_path":null},{"cast_id":60,"character":"Mean Girl #1","credit_id":"599228ef92514104370058e6","gender":0,"id":1869739,"name":"Chrysta-Lyn Rodrigues","order":51,"profile_path":null},{"cast_id":61,"character":"Boy #1","credit_id":"599228efc3a3682392005c40","gender":0,"id":1869740,"name":"Ryan Baughman","order":52,"profile_path":null},{"cast_id":62,"character":"High School Student","credit_id":"599228efc3a36823c90056db","gender":0,"id":1869741,"name":"Kevin Montgomery","order":53,"profile_path":null},{"cast_id":63,"character":"Bazar kid","credit_id":"599228f0c3a36823a5005bd9","gender":0,"id":1869742,"name":"Na Bil","order":54,"profile_path":null},{"cast_id":64,"character":"Bazaar Patron","credit_id":"599228f0925141048b005ac9","gender":0,"id":1869743,"name":"Jeffery Clarke","order":55,"profile_path":null},{"cast_id":65,"character":"The Begger","credit_id":"599228f0c3a3682392005c45","gender":0,"id":1869744,"name":"Mario Fernandez","order":56,"profile_path":null},{"cast_id":66,"character":"Bazaar patron","credit_id":"599228f1c3a36823c90056e1","gender":0,"id":1869745,"name":"Stanislav Mruz","order":57,"profile_path":null},{"cast_id":67,"character":"Beggar","credit_id":"599228f192514104480057e3","gender":0,"id":1869746,"name":"John Early","order":58,"profile_path":null},{"cast_id":70,"character":"Cheerleader","credit_id":"59ced5209251412f37007003","gender":0,"id":1897244,"name":"Lyric Jefferson","order":59,"profile_path":null},{"cast_id":71,"character":"Alex","credit_id":"5a3ac2b6c3a3680b882173c5","gender":2,"id":3492,"name":"Colin Hanks","order":60,"profile_path":"/jhdZWVUQZ71JVwuLdvxelvQmYDl.jpg"}]
     * crew : [{"credit_id":"57c5fa0c9251412147000284","department":"Directing","gender":2,"id":51851,"job":"Director","name":"Jake Kasdan","profile_path":"/1jmlwJ7Y0a7fp28bJLr73u12wbv.jpg"},{"credit_id":"57c5fa2f925141214d0002d7","department":"Writing","gender":2,"id":1246890,"job":"Writer","name":"Chris McKenna","profile_path":"/nofhk8pYAKN5EqiTPdINybxsken.jpg"},{"credit_id":"57c5fb7b925141214100032e","department":"Crew","gender":2,"id":30459,"job":"Cinematography","name":"Gyula Pados","profile_path":null},{"credit_id":"55c4de72925141428c00025a","department":"Production","gender":2,"id":9196,"job":"Producer","name":"Ted Field","profile_path":"/qmB7sZcgRUq7mRFBSTlSsVXh7sH.jpg"},{"credit_id":"55c4de84925141429900023f","department":"Production","gender":2,"id":42357,"job":"Producer","name":"William Teitler","profile_path":null},{"credit_id":"55c4dedbc3a36856a700021f","department":"Production","gender":0,"id":1330530,"job":"Producer","name":"Mike Weber","profile_path":null},{"credit_id":"598cc978c3a3683a470003f7","department":"Production","gender":2,"id":977941,"job":"Producer","name":"Matt Tolmach","profile_path":null},{"credit_id":"59b215a0c3a3682cc809466d","department":"Writing","gender":2,"id":3228,"job":"Writer","name":"Scott Rosenberg","profile_path":"/3SqhCboi0IDCVGmEzGtmN4ZNV8I.jpg"},{"credit_id":"59b215b29251410707093555","department":"Writing","gender":2,"id":168309,"job":"Writer","name":"Jeff Pinkner","profile_path":"/tbTEasPFZRw52iEnooF5hBdYOTK.jpg"}]
     */

    private int id;
    private List<CastBean> cast;
    private List<CrewBean> crew;

    protected PojoCast(Parcel in) {
        id = in.readInt();
    }

    public static final Creator<PojoCast> CREATOR = new Creator<PojoCast>() {
        @Override
        public PojoCast createFromParcel(Parcel in) {
            return new PojoCast(in);
        }

        @Override
        public PojoCast[] newArray(int size) {
            return new PojoCast[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CastBean> getCast() {
        return cast;
    }

    public void setCast(List<CastBean> cast) {
        this.cast = cast;
    }

    public List<CrewBean> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewBean> crew) {
        this.crew = crew;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
    }

    public static class CastBean implements Parcelable{
        /**
         * cast_id : 5
         * character : Dr. Smolder Bravestone
         * credit_id : 57436abfc3a3686d990007b9
         * gender : 2
         * id : 18918
         * name : Dwayne Johnson
         * order : 0
         * profile_path : /akweMz59qsSoPUJYe7QpjAc2rQp.jpg
         */

        private int cast_id;
        private String character;
        private String credit_id;
        private int gender;
        private int id;
        private String name;
        private int order;
        private String profile_path;

        protected CastBean(Parcel in) {
            cast_id = in.readInt();
            character = in.readString();
            credit_id = in.readString();
            gender = in.readInt();
            id = in.readInt();
            name = in.readString();
            order = in.readInt();
            profile_path = in.readString();
        }

        public static final Creator<CastBean> CREATOR = new Creator<CastBean>() {
            @Override
            public CastBean createFromParcel(Parcel in) {
                return new CastBean(in);
            }

            @Override
            public CastBean[] newArray(int size) {
                return new CastBean[size];
            }
        };

        public int getCast_id() {
            return cast_id;
        }

        public void setCast_id(int cast_id) {
            this.cast_id = cast_id;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
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

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(cast_id);
            dest.writeString(character);
            dest.writeString(credit_id);
            dest.writeInt(gender);
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeInt(order);
            dest.writeString(profile_path);
        }
    }

    public static class CrewBean implements Parcelable{
        /**
         * credit_id : 57c5fa0c9251412147000284
         * department : Directing
         * gender : 2
         * id : 51851
         * job : Director
         * name : Jake Kasdan
         * profile_path : /1jmlwJ7Y0a7fp28bJLr73u12wbv.jpg
         */

        private String credit_id;
        private String department;
        private int gender;
        private int id;
        private String job;
        private String name;
        private String profile_path;

        protected CrewBean(Parcel in) {
            credit_id = in.readString();
            department = in.readString();
            gender = in.readInt();
            id = in.readInt();
            job = in.readString();
            name = in.readString();
            profile_path = in.readString();
        }

        public static final Creator<CrewBean> CREATOR = new Creator<CrewBean>() {
            @Override
            public CrewBean createFromParcel(Parcel in) {
                return new CrewBean(in);
            }

            @Override
            public CrewBean[] newArray(int size) {
                return new CrewBean[size];
            }
        };

        public String getCredit_id() {
            return credit_id;
        }

        public void setCredit_id(String credit_id) {
            this.credit_id = credit_id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfile_path() {
            return profile_path;
        }

        public void setProfile_path(String profile_path) {
            this.profile_path = profile_path;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(credit_id);
            dest.writeString(department);
            dest.writeInt(gender);
            dest.writeInt(id);
            dest.writeString(job);
            dest.writeString(name);
            dest.writeString(profile_path);
        }
    }
}

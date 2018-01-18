package com.nurrofiqi.anurr.myTheatre.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by anurr on 1/17/2018.
 */

public class PojoGenreList implements Parcelable{
    /**
     * id : 28
     * page : 1
     * results : [{"adult":false,"backdrop_path":"/rz3TAyd5kmiJmozp3GUbYeB5Kep.jpg","genre_ids":[28,12,35,10751],"id":353486,"original_language":"en","original_title":"Jumanji: Welcome to the Jungle","overview":"The tables are turned as four teenagers are sucked into Jumanji's world - pitted against rhinos, black mambas and an endless variety of jungle traps and puzzles. To survive, they'll play as characters from the game.","release_date":"2017-12-08","poster_path":"/bXrZ5iHBEjH7WMidbUDQ0U2xbmr.jpg","popularity":681.838101,"title":"Jumanji: Welcome to the Jungle","video":false,"vote_average":6.4,"vote_count":1495},{"adult":false,"backdrop_path":"/5Iw7zQTHVRBOYpA0V6z0yypOPZh.jpg","genre_ids":[28,12,14,878],"id":181808,"original_language":"en","original_title":"Star Wars: The Last Jedi","overview":"Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares to do battle with the First Order.","release_date":"2017-12-13","poster_path":"/xGWVjewoXnJhvxKW619cMzppJDQ.jpg","popularity":511.361559,"title":"Star Wars: The Last Jedi","video":false,"vote_average":7.2,"vote_count":3170},{"adult":false,"backdrop_path":"/2SEgJ0mHJ7TSdVDbkGU061tR33K.jpg","genre_ids":[18,53,28,878],"id":347882,"original_language":"en","original_title":"Sleight","overview":"A young street magician is left to take care of his little sister after his mother's passing and turns to drug dealing in the Los Angeles party scene to keep a roof over their heads. When he gets into trouble with his supplier, his sister is kidnapped and he is forced to rely on both his sleight of hand and brilliant mind to save her.","release_date":"2017-04-28","poster_path":"/wridRvGxDqGldhzAIh3IcZhHT5F.jpg","popularity":249.349845,"title":"Sleight","video":false,"vote_average":5.4,"vote_count":197},{"adult":false,"backdrop_path":"/4yjJNAgXBmzxpS6sogj4ftwd270.jpg","genre_ids":[28,18,36,53,10752],"id":374720,"original_language":"en","original_title":"Dunkirk","overview":"The story of the miraculous evacuation of Allied soldiers from Belgium, Britain, Canada and France, who were cut off and surrounded by the German army from the beaches and harbour of Dunkirk between May 26th and June 4th 1940 during World War II.","release_date":"2017-07-19","poster_path":"/ebSnODDg9lbsMIaWg2uAbjn7TO5.jpg","popularity":242.085637,"title":"Dunkirk","video":false,"vote_average":7.4,"vote_count":4270},{"adult":false,"backdrop_path":"/umC04Cozevu8nn3JTDJ1pc7PVTn.jpg","genre_ids":[28,53],"id":245891,"original_language":"en","original_title":"John Wick","overview":"Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him.","release_date":"2014-10-22","poster_path":"/5vHssUeVe25bMrof1HyaPyWgaP.jpg","popularity":239.438615,"title":"John Wick","video":false,"vote_average":7,"vote_count":6410},{"adult":false,"backdrop_path":"/m5jvdwlI24XpFDSX79o97z76jis.jpg","genre_ids":[28,878],"id":271404,"original_language":"en","original_title":"Beyond Skyline","overview":"A tough-as-nails detective embarks on a relentless pursuit to free his son from a nightmarish alien warship.","release_date":"2017-10-20","poster_path":"/lQUJZIm2nQj4mIsm0sUcznhMdpD.jpg","popularity":235.759733,"title":"Beyond Skyline","video":false,"vote_average":4.9,"vote_count":200},{"adult":false,"backdrop_path":"/aJn9XeesqsrSLKcHfHP4u5985hn.jpg","genre_ids":[28,12,35,878],"id":283995,"original_language":"en","original_title":"Guardians of the Galaxy Vol. 2","overview":"The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quill's true parentage.","release_date":"2017-04-19","poster_path":"/y4MBh0EjBlMuOzv9axM4qJlmhzz.jpg","popularity":142.731701,"title":"Guardians of the Galaxy Vol. 2","video":false,"vote_average":7.6,"vote_count":6183},{"adult":false,"backdrop_path":"/lkOZcsXcOLZYeJ2YxJd3vSldvU4.jpg","genre_ids":[28,9648,878,53],"id":198663,"original_language":"en","original_title":"The Maze Runner","overview":"Set in a post-apocalyptic world, young Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow \u201crunners\u201d for a shot at escape.","release_date":"2014-09-10","poster_path":"/coss7RgL0NH6g4fC2s5atvf3dFO.jpg","popularity":136.739315,"title":"The Maze Runner","video":false,"vote_average":7,"vote_count":6160},{"adult":false,"backdrop_path":"/Ytv7P13rbwQ3mLpCAY8lBTqI5s.jpg","genre_ids":[28,878,53,12],"id":335988,"original_language":"en","original_title":"Transformers: The Last Knight","overview":"Autobots and Decepticons are at war, with humans on the sidelines. Optimus Prime is gone. The key to saving our future lies buried in the secrets of the past, in the hidden history of Transformers on Earth.","release_date":"2017-06-16","poster_path":"/s5HQf2Gb3lIO2cRcFwNL9sn1o1o.jpg","popularity":111.630926,"title":"Transformers: The Last Knight","video":false,"vote_average":6.1,"vote_count":1871},{"adult":false,"backdrop_path":"/uExPmkOHJySrbJyJDJylHDqaT58.jpg","genre_ids":[28,12,35],"id":343668,"original_language":"en","original_title":"Kingsman: The Golden Circle","overview":"When an attack on the Kingsman headquarters takes place and a new villain rises, Eggsy and Merlin are forced to work together with the American agency known as the Statesman to save the world.","release_date":"2017-09-20","poster_path":"/34xBL6BXNYFqtHO9zhcgoakS4aP.jpg","popularity":109.326966,"title":"Kingsman: The Golden Circle","video":false,"vote_average":7,"vote_count":2304},{"adult":false,"backdrop_path":"/vsjBeMPZtyB7yNsYY56XYxifaQZ.jpg","genre_ids":[28,12,14],"id":209112,"original_language":"en","original_title":"Batman v Superman: Dawn of Justice","overview":"Fearing the actions of a god-like Super Hero left unchecked, Gotham City\u2019s own formidable, forceful vigilante takes on Metropolis\u2019s most revered, modern-day savior, while the world wrestles with what sort of hero it really needs. And with Batman and Superman at war with one another, a new threat quickly arises, putting mankind in greater danger than it\u2019s ever known before.","release_date":"2016-03-23","poster_path":"/cGOPbv9wA5gEejkUN892JrveARt.jpg","popularity":108.148761,"title":"Batman v Superman: Dawn of Justice","video":false,"vote_average":5.7,"vote_count":8261},{"adult":false,"backdrop_path":"/vc8bCGjdVp0UbMNLzHnHSLRbBWQ.jpg","genre_ids":[28,12,35,878],"id":315635,"original_language":"en","original_title":"Spider-Man: Homecoming","overview":"Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.","release_date":"2017-07-05","poster_path":"/ApYhuwBWzl29Oxe9JJsgL7qILbD.jpg","popularity":106.596411,"title":"Spider-Man: Homecoming","video":false,"vote_average":7.3,"vote_count":5751},{"adult":false,"backdrop_path":"/7C921eWK06n12c1miRXnYoEu5Yv.jpg","genre_ids":[12,28,14,35],"id":166426,"original_language":"en","original_title":"Pirates of the Caribbean: Dead Men Tell No Tales","overview":"Thrust into an all-new adventure, a down-on-his-luck Capt. Jack Sparrow feels the winds of ill-fortune blowing even more strongly when deadly ghost sailors led by his old nemesis, the evil Capt. Salazar, escape from the Devil's Triangle. Jack's only hope of survival lies in seeking out the legendary Trident of Poseidon, but to find it, he must forge an uneasy alliance with a brilliant and beautiful astronomer and a headstrong young man in the British navy.","release_date":"2017-05-23","poster_path":"/xbpSDU3p7YUGlu9Mr6Egg2Vweto.jpg","popularity":104.749582,"title":"Pirates of the Caribbean: Dead Men Tell No Tales","video":false,"vote_average":6.6,"vote_count":3691},{"adult":false,"backdrop_path":"/vXIrvKadue7GdySiVh3huoQZiMi.jpg","genre_ids":[28,12,878],"id":99861,"original_language":"en","original_title":"Avengers: Age of Ultron","overview":"When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth\u2019s Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.","release_date":"2015-04-22","poster_path":"/t90Y3G8UGQp0f0DrP60wRu9gfrH.jpg","popularity":97.437175,"title":"Avengers: Age of Ultron","video":false,"vote_average":7.3,"vote_count":7892},{"adult":false,"backdrop_path":"/bHarw8xrmQeqf3t8HpuMY7zoK4x.jpg","genre_ids":[28,878,12],"id":118340,"original_language":"en","original_title":"Guardians of the Galaxy","overview":"Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.","release_date":"2014-07-30","poster_path":"/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg","popularity":96.515615,"title":"Guardians of the Galaxy","video":false,"vote_average":7.9,"vote_count":11258},{"adult":false,"backdrop_path":"/6vNh2vkfXVL8PoVXVIeZB6DcwbM.jpg","genre_ids":[53,28],"id":442064,"original_language":"en","original_title":"Proud Mary","overview":"A hit woman kills a drug boss only to learn that she has left a boy orphaned. A year later, she saves the boy from a dangerous life on the street but finds herself unable to give the boy or herself a fresh start.","release_date":"2018-01-12","poster_path":"/5luceoVMU2FzWuyty7mZFcSY5ZW.jpg","popularity":91.697238,"title":"Proud Mary","video":false,"vote_average":6,"vote_count":35},{"adult":false,"backdrop_path":"/5pAGnkFYSsFJ99ZxDIYnhQbQFXs.jpg","genre_ids":[28,18,878],"id":263115,"original_language":"en","original_title":"Logan","overview":"In the near future, a weary Logan cares for an ailing Professor X in a hideout on the Mexican border. But Logan's attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.","release_date":"2017-02-28","poster_path":"/gGBu0hKw9BGddG8RkRAMX7B6NDB.jpg","popularity":83.29494,"title":"Logan","video":false,"vote_average":7.6,"vote_count":7609},{"adult":false,"backdrop_path":"/5wNUJs23rT5rTBacNyf5h83AynM.jpg","genre_ids":[28,12,35,14,878],"id":284053,"original_language":"en","original_title":"Thor: Ragnarok","overview":"Thor is imprisoned on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.","release_date":"2017-10-25","poster_path":"/oSLd5GYGsiGgzDPKTwQh7wamO8t.jpg","popularity":82.922032,"title":"Thor: Ragnarok","video":false,"vote_average":7.5,"vote_count":3082},{"adult":false,"backdrop_path":"/qZO1xZKer0R5odDgsxJCuNhmNwS.jpg","genre_ids":[28,27],"id":485415,"original_language":"en","original_title":"Day of the Dead: Bloodline","overview":"In a world overrun by zombies, military personnel and survivalists live in an underground bunker while they seek a cure.","release_date":"2018-01-04","poster_path":"/3jM4C1wJxHLWlF4tcSyyv6fnJPR.jpg","popularity":80.113986,"title":"Day of the Dead: Bloodline","video":false,"vote_average":4.7,"vote_count":20},{"adult":false,"backdrop_path":"/3FweBee0xZoY77uO1bhUOlQorNH.jpg","genre_ids":[28,12,14],"id":76338,"original_language":"en","original_title":"Thor: The Dark World","overview":"Thor fights to restore order across the cosmos\u2026 but an ancient race led by the vengeful Malekith returns to plunge the universe back into darkness. Faced with an enemy that even Odin and Asgard cannot withstand, Thor must embark on his most perilous and personal journey yet, one that will reunite him with Jane Foster and force him to sacrifice everything to save us all.","release_date":"2013-10-29","poster_path":"/bnX5PqAdQZRXSw3aX3DutDcdso5.jpg","popularity":79.494515,"title":"Thor: The Dark World","video":false,"vote_average":6.7,"vote_count":5745}]
     * total_pages : 1047
     * total_results : 20933
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsBean> results;

    protected PojoGenreList(Parcel in) {
        id = in.readInt();
        page = in.readInt();
        total_pages = in.readInt();
        total_results = in.readInt();
    }

    public static final Creator<PojoGenreList> CREATOR = new Creator<PojoGenreList>() {
        @Override
        public PojoGenreList createFromParcel(Parcel in) {
            return new PojoGenreList(in);
        }

        @Override
        public PojoGenreList[] newArray(int size) {
            return new PojoGenreList[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(page);
        dest.writeInt(total_pages);
        dest.writeInt(total_results);
    }

    public static class ResultsBean {
        /**
         * adult : false
         * backdrop_path : /rz3TAyd5kmiJmozp3GUbYeB5Kep.jpg
         * genre_ids : [28,12,35,10751]
         * id : 353486
         * original_language : en
         * original_title : Jumanji: Welcome to the Jungle
         * overview : The tables are turned as four teenagers are sucked into Jumanji's world - pitted against rhinos, black mambas and an endless variety of jungle traps and puzzles. To survive, they'll play as characters from the game.
         * release_date : 2017-12-08
         * poster_path : /bXrZ5iHBEjH7WMidbUDQ0U2xbmr.jpg
         * popularity : 681.838101
         * title : Jumanji: Welcome to the Jungle
         * video : false
         * vote_average : 6.4
         * vote_count : 1495
         */

        private boolean adult;
        private String backdrop_path;
        private int id;
        private String original_language;
        private String original_title;
        private String overview;
        private String release_date;
        private String poster_path;
        private double popularity;
        private String title;
        private boolean video;
        private double vote_average;
        private int vote_count;
        private List<Integer> genre_ids;

        public ResultsBean(String load) {

        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}

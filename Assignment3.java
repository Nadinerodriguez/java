import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Assignment3 {
    public static void main(String[] args) {
        Theater []days = new Theater[3]; // Simulates 3 days;
        for (int i = 0; i < days.length; i++) {
            days[i] = new Theater();
            days[i].schedule();
            days[i].sellTickets();
        }
    }
class Movie {
    // Attributes
    private String title;
    private int duration; // in minutes
    private double popularity;
    public static int maxPopularity = 10;
    //    Constructor
    public Movie(String t, int d, double p) {
        this.title = t;
        this.duration = d;
        this.popularity = p;
    }
    // Getter
    public int getDuration() {
        return this.duration;
    }
    // Getter
    public double getPopularity() {
        return this.popularity;
    }
    // toString
    public String toString() {
        return this.title + " (" + this.duration + " minutes)";
    }
}
class Auditorium {
    // Attributes
    private int id, capacity;
    //    Constructor
    public Auditorium(int i, int c) {
        this.id = i;
        this.capacity = c;
    }
    // Getter
    public int getCapacity() {
        return this.capacity;
    }
    // toString
    public String toString(){
        return "Auditorium " + this.id;
    }
}
class Showing {
    // Attributes
    private Movie movie;
    private Auditorium auditorium;
    private LocalTime showtime;
    //    Constructor
    public Showing(Movie m, Auditorium a, LocalTime s) {
        this.movie = m;
        this.auditorium = a;
        this.showtime = s;
    }
    // Getter
    public Movie getMovie() {
        return this.movie;
    }
    // Getter
    public Auditorium getAuditorium() {
        return this.auditorium;
    }
    // Getter
    public LocalTime getShowtime() {
        return this.showtime;
    }
    // toString
    public String toString() {
        return this.movie.toString() + " in " + this.auditorium.toString()+ " at "+ getShowtime();
    }
}
class Theater {
    // Attributes
    private static Random random = new Random(); // used to randomly select which movies are shown
    public static int timeBetweenShowings = 15; // represents the time it takes to clean the theater between movie showings, in minutes
    private LocalTime firstShowtime; // the time the first movie of the day is shown
    private LocalTime lastShowtime; // the time after which no more showings will begin
    private double ticketPrice;
    private ArrayList<Movie> movies; // a selection of movies the Theater has the rights to show
    private ArrayList<Auditorium> auditoriums; //the various auditoriums the theater contains for showing movies
    private ArrayList<Showing> showings; //essentially the schedule of movie showings for the day

    // Constructor
    public Theater() {
        this.firstShowtime = LocalTime.of(10, 0); // 10 a.m
        this.lastShowtime = LocalTime.of(23, 0); // 11 p.m
        this.showings = new ArrayList<Showing>();
        this.ticketPrice = 16;
        // initialized 3 movies
        this.movies = new ArrayList<Movie>(Arrays.asList(
                new Movie("Spiderman", 140, 8.5),
                new Movie("Batman", 136, 9.2),
                new Movie("Superman", 125, 7.4))
        );
        // initialized 3 auditoriums ids with different capacities
        this.auditoriums = new ArrayList<Auditorium>(Arrays.asList(
                new Auditorium(1, 270),
                new Auditorium(2, 240),
                new Auditorium(3, 360))
        );
    }
    private Movie randomMovie() {
        return this.movies.get(random.nextInt(movies.size()));
    }
    public void schedule() {
        // Clears the showings ArrayList
        this.showings.clear();
        // For each auditorium, this generates Showings by scheduling one movie at a time until no more can be scheduled
        for (Auditorium a : auditoriums) {
            LocalTime nextShowtime = firstShowtime;
            while (nextShowtime.isBefore(lastShowtime)) {
                Movie nextMovie = randomMovie();
                showings.add(new Showing(nextMovie, a, nextShowtime));
                nextShowtime = nextShowtime.plusMinutes(nextMovie.getDuration() + timeBetweenShowings);
            }
        }
    }
    

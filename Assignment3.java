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
    

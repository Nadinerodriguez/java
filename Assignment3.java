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

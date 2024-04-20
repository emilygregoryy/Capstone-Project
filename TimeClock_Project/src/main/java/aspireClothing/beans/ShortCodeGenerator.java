package aspireClothing.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShortCodeGenerator {

    private static ShortCodeGenerator generator;
    private static boolean initialized = false;
    private static List<Integer> shortcodes = new ArrayList<Integer>();
    
    
    private ShortCodeGenerator() {
    }

    private void init() {
    }

    public static synchronized ShortCodeGenerator getInstance() {

        if (initialized) {
            return generator;
        }
        generator = new ShortCodeGenerator();
        generator.init();
        initialized = true;
        return generator;

    }
    
    public int shortCode() {

        int shortcode; 
        do {
            shortcode = randomNumericCode(5); 
        } while(shortcodes.contains(shortcode)); 
        shortcodes.add(shortcode); 

        return shortcode;
    }


    private int randomNumericCode(int n) {
        Random rnd = new Random();
        int min = (int) Math.pow(10, n - 1); 
        int max = (int) Math.pow(10, n) - 1;   
        return rnd.nextInt((max - min) + 1) + min;
    }
    
}

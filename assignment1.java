//Problem 1: Language basics 
public class VolumeCalculator {
    public static void main(String[] args) {
        double earthRadius = 7600 / 2.0; // Radius of the Earth in miles
        double sunRadius = 865000 / 2.0; // Radius of the Sun in miles

        double earthVolume = (4.0 / 3.0) * Math.PI * Math.pow(earthRadius, 3);
        double sunVolume = (4.0 / 3.0) * Math.PI * Math.pow(sunRadius, 3);
        double ratio = sunVolume / earthVolume;

        System.out.println("The volume of the Earth is " + earthVolume + " cubic miles");
        System.out.println("The volume of the Sun is " + sunVolume + " cubic miles");
        System.out.println("The ratio of the volume of the Sun to the volume of the Earth is " + ratio);
    }
}
//Problem 2: Loop
public class Primes {
    public static void main(String[] args) {
        int nValues = 50;

        outerloop: 
        for (int i = 2; i <= nValues; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue outerloop; 
                }
            }
            System.out.println(i);
        }
    }
}
//Problem 3: Oop basics
public class StringCharacters {
    public static void main(String[] args) {
        String text = "To be or not to be, that is the question;"
                    + "Whether `tis nobler in the mind to suffer" 
                    + " the slings and arrows of outrageous fortune,"
                    + " or to take arms against a sea of troubles,"
                    + " and by opposing end them?";
        
        int spaces = 0;
        int vowels = 0;
        int letters = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                spaces++;
            } else if (Character.isLetter(ch)) {
                letters++;
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                }
            }
        }

        System.out.println("The text contained vowels: " + vowels);
        System.out.println("Consonants: " + (letters - vowels));
        System.out.println("Spaces: " + spaces);
    }
}
//Problem 4: oop basics
public class WordSorter {
    public static void main(String[] args) {
        String text = "To be or not to be, that is the question;"
                    + "Whether `tis nobler in the mind to suffer" 
                    + " the slings and arrows of outrageous fortune,"
                    + " or to take arms against a sea of troubles,"
                    + " and by opposing end them?";
        
        String[] words = text.split("[\\s,;.`']+"); // Split the text into words
        
        // Bubble sort the words
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - i - 1; j++) {
                if (words[j].compareToIgnoreCase(words[j + 1]) > 0) {
                    // Swap words[j] and words[j+1]
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        // Print the sorted words
        for (String word : words) {
            System.out.println(word);
        }
    }
}


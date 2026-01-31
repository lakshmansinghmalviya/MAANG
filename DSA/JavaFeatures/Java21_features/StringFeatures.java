package JavaFeatures.Java21_features;

public class StringFeatures {
    public static void main(String[]a){
        
        // Not support now 31/03/2025
        // its preview features
         String name = """Lakshman""";

        String formattedName = "Hello, %s !".formatted(name);
        System.out.println(formattedName);
    }
}
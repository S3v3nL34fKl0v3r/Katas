import java.io.File;
import java.util.Scanner;

public class RecipeTextToJson {
    /**
     * assumes the input file is in the following format:
     * DREAMY LEMON BARS (title, required)
     * Oven: 325° (subTitle, optional)
     *
     * 1 cup butter (ingredients, multi-line, required)
     * 1/2 cup powdered sugar
     * 1/4 tsp salt
     * 2 1/4 cup sifted flour (divided)
     * 4 eggs, well beaten
     * 2 cups sugar
     * 1/4 cup lemon juice
     * 1 tsp grated lemon rind
     *
     * (directions, multi-line, required)Cream butter, powdered sugar and salt. Stir in 2 cups flour. Press into bottom of a 9''x13''
     * pan.
     *
     * Bake for 25 minutes.
     *
     * Combine eggs, sugar, remaining flour, lemon juice and lemon rind. Spread over baked
     * mixture.
     *
     * Bake for an additional 30 minutes.
     *
     * Sprinkle lightly with powdered sugar. Cut into squares when fairly cool.
     * --- (delimiter)
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while(scanner.hasNextLine()) {
                StringBuilder json = new StringBuilder();

                //get title
                String title = scanner.nextLine();
                json.append("{\ntitle: \""+title+"\",");

                //get subtitle (optional)
                String subTitle = scanner.nextLine();
                if(!subTitle.isEmpty()) {
                    json.append("\nsubTitle: \""+subTitle+"\",");
                }

                //get ingredients
                json.append("\ningredients: [ ");
                String ingredient=subTitle.isEmpty()?"":scanner.nextLine();
                while(!(ingredient=scanner.nextLine()).isEmpty()) {
                    json.append("\n\""+ingredient+"\",");
                }
                json.append("\n],");

                //get directions until '---';
                json.append("\ndirections: [ ");
                String instruction;
                while(!(instruction=scanner.nextLine()).equals("---") && scanner.hasNextLine()) {
                    if(!instruction.isEmpty()) {
                        json.append("\n\""+instruction+"\",");
                    }
                }
                json.append("\n],\n},");
                System.out.println(json);

            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}

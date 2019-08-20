public class ToCamelCase {


    public static void main(String[] args ) {
        try {
            testing(ToCamelCase.toCamelCase("the-stealth-warrior"), "theStealthWarrior");
            testing(ToCamelCase.toCamelCase("The_Stealth_Warrior"), "TheStealthWarrior");
            testing(ToCamelCase.toCamelCase("the-stealth-warrior"), "theStealthWarrior");
            System.out.println("TESTS PASSED!!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static String toCamelCase(String s){
        while(s.contains("-") || s.contains("_")) {
            int index;
            if((index=s.indexOf("-")) > -1){
                char replace = s.charAt(index+1) > 96 ? (char) (s.charAt(index + 1) - 32) : s.charAt(index+1);
                s = s.replace("-"+s.charAt(index+1), replace+"");
            }
            if((index=s.indexOf("_")) > -1){
                char replace = s.charAt(index+1) > 96 ? (char) (s.charAt(index + 1) - 32) : s.charAt(index+1);
                s = s.replace("_"+s.charAt(index+1), replace+"");
            }

        }
        return s;
    }

    private static void testing(String actual, String expected) throws Exception{
        if(!expected.equals(actual)) {
            throw new Exception("\nExpected:"+ expected + "\nbut found actual:"+actual);
        }
    }
}

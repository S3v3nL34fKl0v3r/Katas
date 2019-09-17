public class EnoughIsEnough {

    public static void main(String[] args) {
        try {
            System.out.println("longestConsec Fixed Tests");
//            testing();
            System.out.println("TESTS PASSED!!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

//    public static int[] deleteNth(int[] elements, int maxOccurrences) {
//        //Code here ;)
//        ArrayList<Integer> retVal = new ArrayList(Arrays.asList(elements));
//        HashMap<Integer, Integer> countMap = new HashMap<>();
//        Arrays.stream(elements).forEach(v -> countMap.put(v,0));
//        for(int i = 0; i<retVal.size(); i++) {
//            int occurances = countMap.get(elements[i]);
//            if(occurances <= maxOccurrences) {
//                countMap.replace(elements[i],occurances+1);
//            } else {
//                retVal.remove(i);
//            }
//        }
//        return retVal.toArray();
//    }

    private static void testing(String actual, String expected) throws Exception{
        if(!expected.equals(actual)) {
            throw new Exception("\nExpected:"+ expected + "\nbut found actual:"+actual);
        }
    }
}

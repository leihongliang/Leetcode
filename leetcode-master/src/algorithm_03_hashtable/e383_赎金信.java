package algorithm_03_hashtable;

public class e383_赎金信 {
    public static boolean canConstruct(String ransomNote, String magazine)  {
        int[] record = new int[26];
        for ( int i = 0; i < magazine.length(); i++) {
            record[ magazine.charAt(i) - 'a'] ++;
        }
        for ( int i = 0; i < ransomNote.length(); i++) {
            int temp = --record[ransomNote.charAt(i) - 'a'];
            if ( temp < 0 ){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ransomNote = new String("aab");
        String magazine = new String("abb");

        Boolean res = canConstruct(ransomNote, magazine);
        System.out.println(res);
    }
}

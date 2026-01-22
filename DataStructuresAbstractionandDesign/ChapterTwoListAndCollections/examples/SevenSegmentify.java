import java.util.HashMap;
import java.util.Map;

public class SevenSegmentify {
    public static String sevenSegmentify(String time) {
      
        Map<Character, String[]> map = getMap();
        String[] result = {"", "", ""};
      
      for (int linha = 0; linha < 3; linha++) {
        for (int i = 0; i < time.length(); i++) {
          
          char caractere = time.charAt(i);
          String[] artAsc;
             if(i == 0 && caractere == '0') {
          artAsc = new String[]{"   ", "   ", "   "};
        } else {
          artAsc= map.get(caractere);
        }
          result[linha] += artAsc[linha];
        }
      }
        return String.join("\n", result);
    }
  
    private static Map<Character, String[]> getMap() {

        Map<Character, String[]> map = new HashMap<>();

        map.put('0', new String[]{" _ ", "| |", "|_|"});
        map.put('1', new String[]{"   ", "  |", "  |"});
        map.put('2', new String[]{" _ ", " _|", "|_ "});
        map.put('3', new String[]{" _ ", " _|", " _|"});
        map.put('4', new String[]{"   ", "|_|", "  |"});
        map.put('5', new String[]{" _ ", "|_ ", " _|"});
        map.put('6', new String[]{" _ ", "|_ ", "|_|"});
        map.put('7', new String[]{" _ ", "  |", "  |"});
        map.put('8', new String[]{" _ ", "|_|", "|_|"});
        map.put('9', new String[]{" _ ", "|_|", " _|"});
        map.put(':', new String[]{"   ", " . ", " . "});

        return map;
    }
}
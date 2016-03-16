
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class maxWord {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new FileInputStream("result_count.txt"));
            HashMap< String,Integer> hmap = new HashMap< String,Integer>();
            while (sc.hasNext()) {
                String s = sc.next();
                int y = Integer.parseInt(sc.next());
                System.out.println(s + "  " + y);
                hmap.put(s, y);
            }

            List<Map.Entry<String, Integer>> list
                    = new LinkedList<Map.Entry<String, Integer>>(hmap.entrySet());

            // Sort list with comparator, to compare the Map values
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1,
                        Map.Entry<String, Integer> o2) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });

            // Convert sorted map back to a Map
            Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
            for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
                Map.Entry<String, Integer> entry = it.next();
                sortedMap.put(entry.getKey(), entry.getValue());
            }
            
            System.out.println("sau khi sap xep");
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println("[Key] : " + entry.getKey() 
                                      + " [Value] : " + entry.getValue());
		}
        } catch (Exception ex) {
        }
    }
}

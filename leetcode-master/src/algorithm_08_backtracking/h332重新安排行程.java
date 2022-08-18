package algorithm_08_backtracking;

import java.util.*;

public class h332重新安排行程 {

    private static Deque<String> res = new LinkedList<>();
    private static Map<String, Map<String, Integer>> map = new HashMap<>();
    // 起点，终点，终点次数
    public static List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            Map<String, Integer> tmp;
            if (map.containsKey(ticket.get(0))) {
                tmp = map.get(ticket.get(0));
                tmp.put(ticket.get(0), tmp.getOrDefault(ticket.get(1), 0) + 1);
                map.put(ticket.get(0), tmp);
            }else {
                tmp = new TreeMap<>();
                tmp.put(ticket.get(0), 1);
                map.put(ticket.get(0), tmp);
            }
        }
        res.add("JFK");
        helper(tickets.size());
        return new ArrayList<>(res);
    }
    private static boolean helper(int ticketNum){
        if(res.size() == ticketNum + 1) {
            return true;
        }
        String last = res.getLast();
        if(map.containsKey(last)) {//防止出现null
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(helper(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket1 = new LinkedList<>();
        List<String> ticket2 = new LinkedList<>();
        List<String> ticket3 = new LinkedList<>();
        List<String> ticket4 = new LinkedList<>();
        ticket1.add("MUC");
        ticket1.add("LHR");

        ticket2.add("JFK");
        ticket2.add("MUC");

        ticket3.add("SFO");
        ticket3.add("SJC");

        ticket4.add("LHR");
        ticket4.add("SFO");
        tickets.add(new ArrayList<>(ticket1));
        tickets.add(new ArrayList<>(ticket2));
        tickets.add(new ArrayList<>(ticket3));
        tickets.add(new ArrayList<>(ticket4));
        List<String> reslut =findItinerary(tickets);
        System.out.println(reslut.toString());
    }
}

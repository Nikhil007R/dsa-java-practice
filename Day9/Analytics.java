package Day9;

import java.util.*;

enum ActionEnum{
    feature1Button,
    feature2Button,
    feature3Button
}

class AnalyticsStore{
    private final List<Queue<ActionEnum>> storedActions = new ArrayList<>();

    public void storeActions(Queue<ActionEnum> q){
        storedActions.add(new LinkedList<>(q));
    }
}

public class Analytics {

    private AnalyticsStore analyticsStore;
    private Queue<ActionEnum> buffer=new LinkedList<>();
    private int k;
    private int totalLoggedActions;
    private Map<ActionEnum,Integer> map=new HashMap<>();

    public Analytics(AnalyticsStore analyticsStore,int k){
        this.analyticsStore=analyticsStore;
        this.k=k;
    }

    public void registerAction(ActionEnum action){
        buffer.add(action);
        map.put(action,map.getOrDefault(action,0)+1);
        totalLoggedActions++;
        if(buffer.size()>=k){
            analyticsStore.storeActions(buffer);
            buffer.clear();
        }
    }

    int getNumberOfActionRegisteredButNotSentToAnalyticsStore(){
        return buffer.size();
    }

    public int getTotalNumberOfLoggedActions() {
        return totalLoggedActions;
    }

    public List<ActionEnum> getMostFrequentlyUsedActions(){
        List<ActionEnum> result=new ArrayList<>();
        int max=0;
        for(ActionEnum action : map.keySet()){
            if(map.get(action)>max){
                max=map.get(action);
            }
        }
        for(ActionEnum action : map.keySet()){
            if(map.get(action)==max){
                result.add(action);
            }
        }
        Collections.sort(result,new Comparator<ActionEnum>(){
            public int compare(ActionEnum a,ActionEnum b){
                return a.toString().compareTo(b.toString());
            }
        });
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalRequests = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine(); // consume newline

        AnalyticsStore analyticsStore = new AnalyticsStore();
        Analytics analytics = new Analytics(analyticsStore, k);

        for (int i = 0; i < totalRequests; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "registerAction":
                    ActionEnum action = ActionEnum.valueOf(command[1]);
                    analytics.registerAction(action);
                    break;

                case "getTotalNumberOfLoggedActions":
                    System.out.println(analytics.getTotalNumberOfLoggedActions());
                    break;

                case "getNumberOfActionRegisteredButNotSentToAnalyticsStore":
                    System.out.println(analytics.getNumberOfActionRegisteredButNotSentToAnalyticsStore());
                    break;

                case "getMostFrequentlyUsedActions":
                    List<ActionEnum> mostUsed = analytics.getMostFrequentlyUsedActions();
                    for (ActionEnum act : mostUsed) {
                        System.out.print(act + " ");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}

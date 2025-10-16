import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        
        int lastAttack = attacks[attacks.length - 1][0];
        
        Map<Integer, Integer> attackTime = new HashMap<>();
        for(int[] attack : attacks) {
            attackTime.put(attack[0], attack[1]);
        }
        
        int consTime = 0;
        for(int i = 1; i <= lastAttack; i++) {
            if(attackTime.containsKey(i)) {
                // System.out.println(i);
                health -= attackTime.get(i);
                consTime = 0;
                
                if(health <= 0) {
                    health = -1;
                    break;
                }
            }
            
            else {
                health += bandage[1];
                consTime++;
                
                if(consTime == bandage[0]) {
                    health += bandage[2];
                    consTime = 0;
                }
                
                health = Math.min(health, maxHealth);
            }
            
        }              
        return health;
    }
}
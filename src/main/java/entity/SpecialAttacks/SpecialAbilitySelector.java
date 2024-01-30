package entity.SpecialAttacks;

import entity.Champion;

import java.util.ArrayList;
import java.util.Scanner;

public class SpecialAbilitySelector {
    public SpecialAttacks pickAbility(){
        ArrayList<SpecialAttacks> attacks = new ArrayList<>();
        attacks.add(new HolyWave());
        attacks.add(new MagmaRage());
        int i =0;
        for (SpecialAttacks attack: attacks) {
            i++;
            System.out.println("["+i+"] "+attack.getName()+" : "+attack.getLore());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the number of the special ability you want : ...");
        int parse = 0;
        try{
            parse = Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e){
            System.err.println("Please enter valid number");
        }
        if (parse > attacks.size() || parse <=0){
            System.err.println("Please enter valid number");
            return pickAbility();
        }
        return attacks.get(parse-1);
    }
}

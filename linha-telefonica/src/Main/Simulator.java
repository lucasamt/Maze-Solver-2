/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Random;

/**
 *
 * @author RGrupos
 */
public class Simulator {
    public void makeRandomPhoneCalls(List<Phone> x){
        int numberOfPhonesToMake = random(1, 10);
        for(int i = 0; i < numberOfPhonesToMake; i++){
            String phone = createsNumber();
            x.push(new Phone(phone));
        }
    }
    public int random(int low, int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }
    
    public String createsNumber(){
        DDD ddd = new DDD();
        int[] DDDs = ddd.getDDDs();
        int randomValue = random(0, (DDDs.length-1));
        String phone = DDDs[randomValue] + "9"+random(0, 9)+random(0, 9)+random(0, 9)+random(0, 9)+random(0, 9)+random(0, 9)+random(0, 9)+random(0, 9)+random(0, 9);
        
        return phone;
    }
}

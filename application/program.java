package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class program{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> quantity = new HashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            

            String line = br.readLine();
            while(line!=null){
                String[] fields = line.split(",");
                String name = fields[0];
                int votes = Integer.parseInt(fields[1]);


                if(quantity.containsKey(name)){
                    int votesSoFar=quantity.get(name);
                    quantity.put(name,votes + votesSoFar);
                }
                else{
                    quantity.put(name, votes);
                }
                line = br.readLine();
            }

            for(String key : quantity.keySet()){
                System.out.println(key + ": " + quantity.get(key));
            }
        }
        catch(IOException e){
            System.out.println("Error:"+e.getMessage());
        }

        sc.close();
    }
}
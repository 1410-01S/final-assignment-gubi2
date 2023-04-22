import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main{

    
    static Random generator;


    static String[] names = {"Spencer","Peters","Hawkins","Grant","Hansen","Castro","Hoffman","Hart","Elliott","Cunningham",
    "Knight","Bradley","Carroll","Hudson","Duncan","Armstrong","Berry","Andrews","Johnston","Ray","Lane","Riley","Carpenter","Perkins"
    ,"Aguilar","Silva","Richards","Willis","Matthews","Chapman","Lawrence","Garza","Vargas","Watkins","Wheeler","Larson","Carlson","Harper"
    ,"George","Greene","Burke","Guzman","Morrison","Munoz","Jacobs"};

    static String[] colors = {"tan", "white", "blue", "black", "grey"};

    static String[] genders = {"male", "female"};

    static String[] weight = {"111.5", "90.3", "98.1", "201", "199.5", "100", "39.5"};

    static <T> T pickRandom(T[] array){
        int Rand = generator.nextInt(array.length);
        return array[Rand];
    }

    static <T> T pickRandom(ArrayList<T> array){
        int Rand = generator.nextInt(array.size());
        return array.get(Rand);
    }

    static class World {
        ArrayList<female> females;
        ArrayList<male> males;
        int amountFood = 0;
        int numFemales = 0;
        int numMales = 0;
        

     public World() {
        males =  new ArrayList<male>();
        females =  new ArrayList<female>();
        }

        public void Create(){
        int chance = generator.nextInt(3);
        if (chance == 1 || chance == 2){
            System.out.println("Male spawned");
            numMales++;
        }
        if (chance == 1 ){
            System.out.println("Female spawned");
            numFemales++;
        }

        }

        public void sFood(){
        int chance = generator.nextInt(3);
        if (chance == 1){
            System.out.println("More Food");
            amountFood++;
        }

        }

    



   
        static class Creature {
        String name = pickRandom(names);
        String gender = pickRandom(genders);
        String color = pickRandom(colors);
        String weigh = pickRandom(weight);


        public boolean food(){
        int chance = generator.nextInt(2);
        if (chance == 1){
            System.out.println(this.name + " ate!");
            return true;
        }
        return false;
        }
    
        public boolean dead(){
        int chance = generator.nextInt(8);
        if (this.food() == true){
            if (chance == 1){
                System.out.println(this.name + " is dead.");
                return true;
            }
        }
        return false;
        }
    





        static class female extends Creature{
   
        public female Repro() {
        
        System.out.println(this.name + " HAD A CHILD.");
        female temp = new female();
        return temp;
        

        }

        }

     static class male extends Creature{
   
        public boolean mDead() {
        int chance = generator.nextInt(3);
        if (chance == 1){
        System.out.println(this.name + " is dead.");
        return true;
        }
        return false;
        }

        }

        }
    }




public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    generator = new Random();
    World world = new World();
    System.out.println("Want to look inside the world?! y or n");

    boolean contin = true;
    while(contin){
        System.out.println("Females: " + world.numFemales);
        System.out.println("Males: " + world.numMales);
        System.out.println();

        String key = in.next();

        switch (key){


            case "y" :
            world.Create();
            world.sFood();

            for (int i = 0; i < world.females.size(); i++){
                if (world.amountFood > 0){
                    if (world.females.get(i).food()== true){
                    
                          world.amountFood--;
                    }
                    
                }
            

            int change = generator.nextInt(3);
            if (world.females.size() > 1){
                if (change > 1){
                    world.numFemales++;
                }

            }

            if (world.females.get(i).dead()== true){
                world.females.remove(world.females.get(i));                  
                  world.numFemales--;
                

            }
        }
        for (int i = 0; i < world.males.size(); i++){
            if (world.amountFood > 0){
                 if (world.males.get(i).food()== true){
               
                  world.amountFood--;
            }
                
            }
        

        

        if (world.males.get(i).mdead()== true){
            world.males.remove(world.males.get(i));                  
              world.numMales--;
            

        }
    }
    break;
    case "n" :
        contin = false;
        break;
    
}

System.out.println();

for (female n : world.females){
    System.out.println(n.name + " " + n.weigh+ " " + n.color);
}
for (male n : world.male){
    System.out.println(n.name + " " + n.weigh+ " " + n.color);
}

    







       


}
}
}
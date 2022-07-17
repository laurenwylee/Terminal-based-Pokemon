import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;

public class Woo{

Player player = new Player();
Scanner in = new Scanner(System.in);

  public static String generatePokemon(int type){
    int random = (int)((Math.random() * 10)-5);
    String fire = new String[] {"vulpix" , "slugma", "numel", "charmander", "cyndaquil", "torchic"};
    String water = new String[] {"feebas", "wooper", "lotad","marill","wingull","poliwag"};
    String grass = new String[] {"cherubi", "seedot", "bulbasaur", "chikorita","treecko", "bellsprout"};
    if (type == 0){
      return fire[random];
    } else if (type == 1){
      return water[random];
    } else {
      return grass[random];
    }
  }

  public static int generateLvl(Pokemon starter){
    int random = (int)((Math.random()*10) + (starter._lvl-3));
    return random;
  }
  public static int generateType(){
    int random = (int)((Math.random() * 10)-8);
    if (random == 0){
      //type is Fire
      return 0;
    } else if (random == 1){
      //type is Water
      return 1;
    } else {
      //type is Grass
      return 2;
    }
  }

  public static boolean generateGender(){
    int random = (int)(Math.random() * 10);
    if (random <=5){
      return true;
    }
    else{
      return false;
    }
  }

  public static String generateName(){
    String name = new String[] {"Dawn" , "Lucas", "Barry", "Riley", "Rowen", "Cynthia"};
    int random = (int) (Math.random()*10-(10-name.length()));
    return name[random];
  }

  public static void wait(int s) {
    try {
      Thread.sleep(s * 1000);
    }
    catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }
  public boolean runaway(){
    int random = (int)(Math.random() * 10);
      if (random <= 5){
        return true;
      } else{
        return false;
      }
    }


  public void walk(Pokemon starter){
    int random = (int)(Math.random() * 10);
    if (random <= 2){
      System.out.println("Nothing has appeared");
      System.out.println("Walk again?");
      String response = "";
      response = in.nextLine().toLowerCase();
      while (response.equals("yes") == false && response.equals("no") == false){
        if (response.equals("yes")){
          walk();
        }
        else if (response.equals("no")){
          System.out.println("Do you want to go to a gym or the nurse? (gym/nurse)");
          String gymOrNurse = "";
          gymOrNurse = in.nextLine().toLowerCase();
          while (gymOrNurse.equals("gym") == false && gymOrNurse.equals("nurse") == false){
            if (response.equals("gym")){
                if (player._numPokemon < 7){
                  System.out.println("You need at least six pokemon to go to the gym. Do you want to talk to catch pokemon?");
                  String yOrN = "";
                  yOrN = in.nextLine().toLowerCase();
                  while (yOrN.equals("yes") == false && yOrN.equals("no") == false){
                    if (response.equals("yes")){
                      walk();
                    }
                    else if (response.equals("no")){
                      System.out.println("Do you want to go to the nurse?");
                      String nurse = "";
                      nurse = in.nextLine().toLowerCase();
                      while (nurse.equals("yes") == false && nurse.equals("no") == false){
                        if (response.equals("yes")){
                          gotoNurse();
                        }
                        else if (response.equals("no")){
                          System.out.println("You will have to catch pokemon.");
                          System.out.println("You walked");
                          walk();
                        }
                        else {
                          System.out.println("input a valid response (yes/no)");
                          nurse = in.nextLine().toLowerCase();
                        }
                    }
                  }
                    else {
                      System.out.println("input a valid response (yes/no)");
                      yOrN = in.nextLine().toLowerCase();
                      //while
                    }

                  }
                }
                else{
                  gymBattle();
                }
          } else if (response.equals("nurse")){
            goToNurse();
          } else {
            System.out.println("input a valid response");
            gymOrNurse = in.nextLine().toLowerCase();
          //while
        }
      }
    } else {
      System.out.println("input a valid response");
      response = in.nextLine().toLowerCase();
      }
    }
  }
  else if (random >= 3 && random <=4){
    //meet someone battle
    System.out.println("A fellow pokemon trainer has appeared. They challenge you to a pokemon battle.");
    System.out.println("Do you want to battle or runaway? (battle/runaway)");
    String runawayOr = "";
    runawayOr = in.nextLine().toLowerCase();
    while (runawayOr.equals("runaway") == false && runawayOr.equals("battle") == false){
      if (runawayOr.equals("runaway")){
        boolean run = runaway();
        if (run == false){
          System.out.println("running away failed. You must engage in battle");
          int type = generateType();
          if (type == 0){
            String opponent = generatePokemon(0);
            if (pokemon.equals("vulpix")){
              Pokemon vulpix = new Fire("vulpix", generateLvl(), 0);
            } else if (pokemon.equals("slugma")){
              Pokemon slugma = new Fire("slugma", generateLvl(), 0);
            }else if (pokemon.equals("numel")){
              Pokemon numel = new Fire("numel", generateLvl(), 0);
            } else if (pokemon.equals("charmander")){
              Pokemon charmander = new Fire("charmander", generateLvl(), 0);
            }else if (pokemon.equals("cyndaquil")){
              Pokemon cyndaquil = new Fire("cyndadquil", generateLvl(), 0);
            }else if (pokemon.equals("torchic")){
              Pokemon torchic = new Fire("torchic", generateLvl(), 0);
            }
          } else if (type == 1){
            String pokemon = generatePokemon(1);
            if (pokemon.equals("feebas")){
              Pokemon feebas = new Water("feebas", generateLvl(), 0);
            } else if (pokemon.equals("wooper")){
              Pokemon wooper = new Water("wooper", generateLvl(), 0);
            }else if (pokemon.equals("lotad")){
              Pokemon lotad = new Water("lotad", generateLvl(), 0);
            } else if (pokemon.equals("marill")){
              Pokemon marill = new Water("marill", generateLvl(), 0);
            }else if (pokemon.equals("wingull")){
              Pokemon wingull = new Water("wingull", generateLvl(), 0);
            }else if (pokemon.equals("poliwag")){
              Pokemon poliwag = new Water("poliwag", generateLvl(), 0);
            }
          } else{
            String pokemon = generatePokemon(2);
            if (pokemon.equals("cherubi")){
              Pokemon cherubi = new Grass("cherubi", generateLvl(), 0);
            } else if (pokemon.equals("seedot")){
              Pokemon seedot = new Grass("seedot", generateLvl(), 0);
            }else if (pokemon.equals("bulbasaur")){
              Pokemon bulbasaur = new Grass("bulbasaur", generateLvl(), 0);
            } else if (pokemon.equals("chikorita")){
              Pokemon chikorita = new Grass("chikorita", generateLvl(), 0);
            }else if (pokemon.equals("treecko")){
              Pokemon treecko = new Grass("treecko", generateLvl(), 0);
            }else if (pokemon.equals("bellsprout")){
              Pokemon bellsprout= new Grass("bellsprout", generateLvl(), 0);
          }
        }
        battle(pokemon);
      }
        else {
          System.out.println("You've sucessfullly runaway");
          System.out.println("You walked");
          //ask
        }
      } else if (runawayOr.equals("battle")){
        System.out.println("You accept the challenge and engage in battle");
        int type = generateType();
        if (type == 0){
          String pokemon = generatePokemon(0);
          if (pokemon.equals("vulpix")){
            Pokemon vulpix = new Fire("vulpix", generateLvl(), 0);
          } else if (pokemon.equals("slugma")){
            Pokemon slugma = new Fire("slugma", generateLvl(), 0);
          }else if (pokemon.equals("numel")){
            Pokemon numel = new Fire("numel", generateLvl(), 0);
          } else if (pokemon.equals("charmander")){
            Pokemon charmander = new Fire("charmander", generateLvl(), 0);
          }else if (pokemon.equals("cyndaquil")){
            Pokemon cyndaquil = new Fire("cyndadquil", generateLvl(), 0);
          }else if (pokemon.equals("torchic")){
            Pokemon torchic = new Fire("torchic", generateLvl(), 0);
          }
        } else if (type == 1){
          String pokemon = generatePokemon(1);
          if (pokemon.equals("feebas")){
            Pokemon feebas = new Water("feebas", generateLvl(), 0);
          } else if (pokemon.equals("wooper")){
            Pokemon wooper = new Water("wooper", generateLvl(), 0);
          }else if (pokemon.equals("lotad")){
            Pokemon lotad = new Water("lotad", generateLvl(), 0);
          } else if (pokemon.equals("marill")){
            Pokemon marill = new Water("marill", generateLvl(), 0);
          }else if (pokemon.equals("wingull")){
            Pokemon wingull = new Water("wingull", generateLvl(), 0);
          }else if (pokemon.equals("poliwag")){
            Pokemon poliwag = new Water("poliwag", generateLvl(), 0);
          }
        } else{
          String pokemon = generatePokemon(2);
          if (pokemon.equals("cherubi")){
            Pokemon cherubi = new Grass("cherubi", generateLvl(), 0);
          } else if (pokemon.equals("seedot")){
            Pokemon seedot = new Grass("seedot", generateLvl(), 0);
          }else if (pokemon.equals("bulbasaur")){
            Pokemon bulbasaur = new Grass("bulbasaur", generateLvl(), 0);
          } else if (pokemon.equals("chikorita")){
            Pokemon chikorita = new Grass("chikorita", generateLvl(), 0);
          }else if (pokemon.equals("treecko")){
            Pokemon treecko = new Grass("treecko", generateLvl(), 0);
          }else if (pokemon.equals("bellsprout")){
            Pokemon bellsprout= new Grass("bellsprout", generateLvl(), 0);
        }
      }
      battle(pokemon);
    }else {
        System.out.println("input a valid response (runaway/battle)");
        runawayOr = in.nextLine().toLowerCase();
      }
    }

  }
  else if (random >= 5 && random <=6 ){
    //civilian
    Human civilian = new Human(generateGender(), 3, generateName());
    System.out.println("You have encountered a civilian");
    civilian.greet();
    //add extra talking functionality
  }
  else {

    System.out.println("A pokemon has appeared");
    System.out.println("Would you like to battle or run away? (battle/runaway)");
    String encounterPokemon = "";
    encounterPokemon = in.nextLine().toLowerCase();
    while (encounterPokemon.equals("runaway") == false && encounterPokemon.equals("battle") == false){
      if (encounterPokemon.equals("runaway")){
        boolean run = runaway();
        if (run == false){
          System.out.println("running away failed. You must engage in battle");
          int type = generateType();
          if (type == 0){
            String pokemon = generatePokemon(0);
            if (pokemon.equals("vulpix")){
              Pokemon vulpix = new Fire("vulpix", generateLvl(), 0);
            } else if (pokemon.equals("slugma")){
              Pokemon slugma = new Fire("slugma", generateLvl(), 0);
            }else if (pokemon.equals("numel")){
              Pokemon numel = new Fire("numel", generateLvl(), 0);
            } else if (pokemon.equals("charmander")){
              Pokemon charmander = new Fire("charmander", generateLvl(), 0);
            }else if (pokemon.equals("cyndaquil")){
              Pokemon cyndaquil = new Fire("cyndadquil", generateLvl(), 0);
            }else if (pokemon.equals("torchic")){
              Pokemon torchic = new Fire("torchic", generateLvl(), 0);
            }
          } else if (type == 1){
            String pokemon = generatePokemon(1);
            if (pokemon.equals("feebas")){
              Pokemon feebas = new Water("feebas", generateLvl(), 0);
            } else if (pokemon.equals("wooper")){
              Pokemon wooper = new Water("wooper", generateLvl(), 0);
            }else if (pokemon.equals("lotad")){
              Pokemon lotad = new Water("lotad", generateLvl(), 0);
            } else if (pokemon.equals("marill")){
              Pokemon marill = new Water("marill", generateLvl(), 0);
            }else if (pokemon.equals("wingull")){
              Pokemon wingull = new Water("wingull", generateLvl(), 0);
            }else if (pokemon.equals("poliwag")){
              Pokemon poliwag = new Water("poliwag", generateLvl(), 0);
            }
          } else{
            String pokemon = generatePokemon(2);
            if (pokemon.equals("cherubi")){
              Pokemon cherubi = new Grass("cherubi", generateLvl(), 0);
            } else if (pokemon.equals("seedot")){
              Pokemon seedot = new Grass("seedot", generateLvl(), 0);
            }else if (pokemon.equals("bulbasaur")){
              Pokemon bulbasaur = new Grass("bulbasaur", generateLvl(), 0);
            } else if (pokemon.equals("chikorita")){
              Pokemon chikorita = new Grass("chikorita", generateLvl(), 0);
            }else if (pokemon.equals("treecko")){
              Pokemon treecko = new Grass("treecko", generateLvl(), 0);
            }else if (pokemon.equals("bellsprout")){
              Pokemon bellsprout= new Grass("bellsprout", generateLvl(), 0);
          }
          battle(pokemon);
        }
        battle(pokemon);
      }else {
          System.out.println("You've sucessfully runaway");
          System.out.println("You walked");
          // ask them
        }
      } else if (encounterPokemon.equals("battle")){
        System.out.println("You accept the challenge and engage in battle");
        int type = generateType();
        if (type == 0){
          String pokemon = generatePokemon(0);
          if (pokemon.equals("vulpix")){
            Pokemon vulpix = new Fire("vulpix", generateLvl(), 0);
          } else if (pokemon.equals("slugma")){
            Pokemon slugma = new Fire("slugma", generateLvl(), 0);
          }else if (pokemon.equals("numel")){
            Pokemon numel = new Fire("numel", generateLvl(), 0);
          } else if (pokemon.equals("charmander")){
            Pokemon charmander = new Fire("charmander", generateLvl(), 0);
          }else if (pokemon.equals("cyndaquil")){
            Pokemon cyndaquil = new Fire("cyndadquil", generateLvl(), 0);
          }else if (pokemon.equals("torchic")){
            Pokemon torchic = new Fire("torchic", generateLvl(), 0);
          }
        } else if (type == 1){
          String pokemon = generatePokemon(1);
          if (pokemon.equals("feebas")){
            Pokemon feebas = new Water("feebas", generateLvl(), 0);
          } else if (pokemon.equals("wooper")){
            Pokemon wooper = new Water("wooper", generateLvl(), 0);
          }else if (pokemon.equals("lotad")){
            Pokemon lotad = new Water("lotad", generateLvl(), 0);
          } else if (pokemon.equals("marill")){
            Pokemon marill = new Water("marill", generateLvl(), 0);
          }else if (pokemon.equals("wingull")){
            Pokemon wingull = new Water("wingull", generateLvl(), 0);
          }else if (pokemon.equals("poliwag")){
            Pokemon poliwag = new Water("poliwag", generateLvl(), 0);
          }
        } else{
          String pokemon = generatePokemon(2);
          if (pokemon.equals("cherubi")){
            Pokemon cherubi = new Grass("cherubi", generateLvl(), 0);
          } else if (pokemon.equals("seedot")){
            Pokemon seedot = new Grass("seedot", generateLvl(), 0);
          }else if (pokemon.equals("bulbasaur")){
            Pokemon bulbasaur = new Grass("bulbasaur", generateLvl(), 0);
          } else if (pokemon.equals("chikorita")){
            Pokemon chikorita = new Grass("chikorita", generateLvl(), 0);
          }else if (pokemon.equals("treecko")){
            Pokemon treecko = new Grass("treecko", generateLvl(), 0);
          }else if (pokemon.equals("bellsprout")){
            Pokemon bellsprout= new Grass("bellsprout", generateLvl(), 0);
        }
      }
      battle(pokemon);
    }else {
        System.out.println("input a valid response (runaway/battle)");
        runawayOr = in.nextLine().toLowerCase();
      }
    }
  }
}
  public static void battle(Pokemon opponent) {
    System.out.println("The battle between");
  }

  public static void goToNurse(){

  }

  public void gymBattle(String region, String gymLeader) {
    String answer = "";
    wait(1);
    System.out.println("You enter the gym and prepare to fight " + gymLeader + ".");
    wait(1);
    System.out.println("Do you wish to visit the Nurse before battling " + gymLeader + "?");
    answer = in.nextLine().toLowerCase();
    if (answer.equals("yes")) {
      System.out.println("You take a quick visit to the Nurse...");
    }
    else if (answer.equals("yes")) {
      System.out.println("Are you ready to fight " + gymLeader + "?");
    }
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Player player = new Player();

    wait(1);
    System.out.println("Welcome, Trainer, to Pokemon Shining Pearl!");
    wait(1);
    System.out.println("\nWhat is your name?");
    String name = "";
    name = in.nextLine();
    player._name = name;
    wait(1);
    System.out.println("\nHello " + name + ", are you a boy or a girl?");
    String gender = "";
    boolean isGender = false;
    gender = in.nextLine().toLowerCase();
    while (isGender == false) {
    if (gender.equals("girl")) {
        player._gender = true;
        isGender = true;
    }
    else if (gender.equals("boy")) {
        player._gender = false;
        isGender = true;
    } else {
        System.out.println("\nPlease input a valid gender:");
        gender = in.nextLine().toLowerCase();
      }
    }
    wait(2);
    System.out.println("\nRING RING! Wake up " + name + "!" + " Your mom told you to go to Dr. Footstep's clinic to get your first starter Pokemon.");
    wait(2);
    System.out.println("\nYou totally forgot. Today is your 10th birthday. You're finally old enough to become a Pokemon trainer!");
    wait(2);
    System.out.println("\nYou rush over to the pokemon clinic and luckily the line isn't long.");
    wait(2);
    System.out.print("\nA");
    wait(2);
    System.out.print(" few");
    wait(2);
    System.out.print(" minutes");
    wait(2);
    System.out.print(" later");
    wait(2);
    System.out.println("...");
    wait(3);
    System.out.println("\nIt's finally your turn!");
    //wake up, go to drs place to pick Pokemon
    wait(1);

    System.out.println("\nThere are three starter Pokemons: Chimchar, Piplup, and Turtwig.");
    wait(1);

    System.out.println("\nInput the pokemon that you want to know more about:");
    String pokemonOne = "";


    // POKEMON DESCRIPTIONS
    pokemonOne = in.nextLine().toLowerCase();
    if (pokemonOne.equals("chimchar")) {
      Fire chimchar = new Fire("Chimchar", 5, 40);
      wait(1);
      System.out.println("\nA Chimp Pokemon.");
      wait(1);
      System.out.println("With a flaming tail, Chimchar is skilled in Fire-type moves.");
      wait(1);
      System.out.println("Its light body affords it the ability to scale steep cliffs and live atop rocky mountains.");
      wait(1);
      System.out.println("Some say that the fiery tail is fueled by gas made in its stomach.");
      wait(1);
      System.out.println("Not even rain can put out the flames, but Chimchar always puts out the fire when asleep.");
      wait(1);
      System.out.println();
      chimchar.display();
    }
    else if (pokemonOne.equals("piplup")) {
      Pokemon piplup = new Water("Piplup", 5, 40);
      wait(1);
      System.out.println("\nA Penguin Pokémon.");
      wait(2);
      System.out.println("It's one of the starter Pokemon received from Professor Rowan when the player departs from the Sinnoh region.");
      wait(2);
      System.out.println("It's a Water type, so it's strong versus Rock and Grounds.");
      wait(2);
      System.out.println("It's very cute but filled with pride--it hates to accept food from people.");
      wait(2);
      System.out.println();
      piplup.display();
    }
    else if (pokemonOne.equals("turtwig")) {
      Pokemon turtwig = new Grass("Turtwig", 5, 40);
      wait(1);
      System.out.println("\nA Tiny Leaf Pokemon.");
      wait(2);
      System.out.println("Despite its animal appearance, Turtwig actually has vegetation sprouting from its head.");
      wait(2);
      System.out.println("The shell on its back is made of soil and hardens when it drinks water.");
      wait(2);
      System.out.println("Much like a plant, Turtwig performs photosynthesis, absorbing sunlight and making oxygen.");
      wait(2);
      System.out.println("It also relies heavily on water to keep its plant healthy and thus spends a lot of time near lakes.");
      wait(2);
      System.out.println();
      turtwig.display();
    }
    else {
      wait(1);
      System.out.println("\nThat's not exactly a Pokemon, but Dr. Footstep wants to show you Chimchar.");
      Pokemon chimchar = new Fire("Chimchar", 5, 40);
      wait(1);
      System.out.println("\nA Chimp Pokemon.");
      wait(1);
      System.out.println("With a flaming tail, Chimchar is skilled in Fire-type moves.");
      wait(1);
      System.out.println("Its light body affords it the ability to scale steep cliffs and live atop rocky mountains.");
      wait(1);
      System.out.println("Some say that the fiery tail is fueled by gas made in its stomach.");
      wait(1);
      System.out.println("Not even rain can put out the flames, but Chimchar always puts out the fire when asleep.");
      wait(1);
      System.out.println();
      chimchar.display();
    }

    wait(2);
    System.out.println("\nInput another pokemon that you want to know more about:");
    String pokemonTwo = "";

    pokemonTwo = in.nextLine().toLowerCase();
    if (pokemonTwo.equals("chimchar")) {
      Pokemon chimchar = new Fire("Chimchar", 5, 40);
      wait(1);
      System.out.println("\nA Chimp Pokemon.");
      wait(1);
      System.out.println("With a flaming tail, Chimchar is skilled in Fire-type moves.");
      wait(1);
      System.out.println("Its light body affords it the ability to scale steep cliffs and live atop rocky mountains.");
      wait(1);
      System.out.println("Some say that the fiery tail is fueled by gas made in its stomach.");
      wait(1);
      System.out.println("Not even rain can put out the flames, but Chimchar always puts out the fire when asleep.");
      wait(1);
      System.out.println();
      chimchar.display();
    }
    else if (pokemonTwo.equals("piplup")) {
      Pokemon piplup = new Water("Piplup", 5, 40);
      wait(1);
      System.out.println("\nA Penguin Pokémon.");
      wait(1);
      System.out.println("It's one of the starter Pokemon received from Professor Rowan when the player departs from the Sinnoh region.");
      wait(1);
      System.out.println("It's a Water type, so it's strong versus Rock and Grounds.");
      wait(1);
      System.out.println("It's very cute but filled with pride--it hates to accept food from people.");
      wait(1);
      System.out.println();
      piplup.display();
    }
      else if (pokemonTwo.equals("turtwig")) {
      Pokemon turtwig = new Grass("Turtwig", 5, 40);
      wait(1);
      System.out.println("\nA Tiny Leaf Pokemon.");
      wait(1);
      System.out.println("Despite its animal appearance, Turtwig actually has vegetation sprouting from its head.");
      wait(1);
      System.out.println("The shell on its back is made of soil and hardens when it drinks water.");
      wait(1);
      System.out.println("Much like a plant, Turtwig performs photosynthesis, absorbing sunlight and making oxygen.");
      wait(1);
      System.out.println("It also relies heavily on water to keep its plant healthy and thus spends a lot of time near lakes.");
      wait(1);
      System.out.println();
      turtwig.display();
    }
    else {
      wait(1);
      System.out.println("\nThat's not exactly a Pokemon, but Dr. Footstep wants to show you Piplup.");
      Pokemon piplup = new Water("Piplup", 5, 40);
      wait(1);
      System.out.println("A Penguin Pokémon.");
      wait(1);
      System.out.println("It's one of the starter Pokemon received from Professor Rowan when the player departs from the Sinnoh region.");
      wait(1);
      System.out.println("It's a Water type, so it's strong versus Rock and Grounds.");
      wait(1);
      System.out.println("It's very cute but filled with pride--it hates to accept food from people.");
      wait(1);
      System.out.println();
      piplup.display();
    }

    wait(2);
    System.out.println("\nInput the last pokemon:");
    String pokemonThree = "";

    pokemonThree = in.nextLine().toLowerCase();
    if (pokemonThree.equals("chimchar")) {
      Pokemon chimchar = new Fire("Chimchar", 5, 40);
      wait(1);
      System.out.println("\nA Chimp Pokemon.");
      wait(1);
      System.out.println("With a flaming tail, Chimchar is skilled in Fire-type moves.");
      wait(1);
      System.out.println("Its light body affords it the ability to scale steep cliffs and live atop rocky mountains.");
      wait(1);
      System.out.println("Some say that the fiery tail is fueled by gas made in its stomach.");
      wait(1);
      System.out.println("Not even rain can put out the flames, but Chimchar always puts out the fire when asleep.");
      wait(1);
      System.out.println();
      chimchar.display();
    }
    else if (pokemonThree.equals("piplup")) {
      Pokemon piplup = new Water("Piplup", 5, 40);
      wait(1);
      System.out.println("\nA Penguin Pokémon.");
      wait(1);
      System.out.println("It's one of the starter Pokemon received from Professor Rowan when the player departs from the Sinnoh region.");
      wait(1);
      System.out.println("It's a Water type, so it's strong versus Rock and Grounds.");
      wait(1);
      System.out.println("It's very cute but filled with pride--it hates to accept food from people.");
      wait(1);
      System.out.println();
      piplup.display();
    }
    else if (pokemonThree.equals("turtwig")) {
      Pokemon turtwig = new Grass("Turtwig", 5, 40);
      wait(1);
      System.out.println("\nA Tiny Leaf Pokemon.");
      wait(1);
      System.out.println("Despite its animal appearance, Turtwig actually has vegetation sprouting from its head.");
      wait(1);
      System.out.println("The shell on its back is made of soil and hardens when it drinks water.");
      wait(1);
      System.out.println("Much like a plant, Turtwig performs photosynthesis, absorbing sunlight and making oxygen.");
      wait(1);
      System.out.println("It also relies heavily on water to keep its plant healthy and thus spends a lot of time near lakes.");
      wait(1);
      System.out.println();
      turtwig.display();
    }else{
      wait(1);
      System.out.println("\nThat's not exactly a Pokemon, but Dr. Footstep wants to show you Turtwig.");
      Pokemon turtwig = new Grass("Turtwig", 5, 40);
      wait(1);
      System.out.println("\nA Tiny Leaf Pokemon.");
      wait(1);
      System.out.println("Despite its animal appearance, Turtwig actually has vegetation sprouting from its head.");
      wait(1);
      System.out.println("The shell on its back is made of soil and hardens when it drinks water.");
      wait(1);
      System.out.println("Much like a plant, Turtwig performs photosynthesis, absorbing sunlight and making oxygen.");
      wait(1);
      System.out.println("It also relies heavily on water to keep its plant healthy and thus spends a lot of time near lakes.");
      wait(1);
      System.out.println();
      turtwig.display();
    }
    // Instance of Pokemon


    // CHOOSING POKEMON
    wait(1);
    System.out.println("\nWhich starter Pokemon do you want?");
    String response = "";

    response = in.nextLine().toLowerCase();
    if(response.equals("chimchar")) {
      Fire starter = Chimchar;
      wait(1);
      System.out.println("\nCongrats, you got your first Pokemon! It's a Chimchar!");
    }
    else if(response.equals("piplup")) {
      Water starter = piplup;
      wait(1);
      System.out.println("\nCongrats, you got your first Pokemon! It's a Piplup!");
    }
    else if(response.equals("turtwig")) {
      Grass starter = turtwig;
      wait(1);
      System.out.println("\nCongrats, you got your first Pokemon! It's a Turtwig!");
    }
    else {
      int random = (int)((Math.random() * 10) - 8);
      if(random == 1) {
        Fire starter = chimchar;
        wait(1);
        System.out.println("\nYou responded too late! The only Pokemon left is Chimchar!");
      }
      else if(random == 2) {
        Water starter = water;
        wait(1);
        System.out.println("\nYou responded too late! The only Pokemon left is Piplup!");
      }
      else if(random == 3) {
        Grass starter = turtwig;
        wait(1);
        System.out.println("\nYou responded too late! The only Pokemon left is Turtwig!");
      }
    }

    Player._numPokemon += 1;
    wait(1);
    System.out.println("\nYou also receive 5 Pokeballs and 5 berries from Dr. Footstep.");
    Player._numPokeball += 5;
    Player._numBerries += 5;
    wait(1);
    System.out.println("\nYou thank Dr. Footstep and walk out of the clinic.");
      System.out.println("\nDo you want to catch Pokemon or attempt battling a Gym leader? (catch/battle)");
      response = in.nextLine().toLowerCase();
    }
  }

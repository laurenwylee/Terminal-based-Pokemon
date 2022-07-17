import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;



public class Woo {

  //tests
  static Scanner in = new Scanner(System.in);
  StdAudio city = new StdAudio();

  public static Pokemon generatePokemon(Player name, int type) {
    int random = (int) ((Math.random() * 6)); //0-5
    //why does it work with negative index
    String[] fire = new String[] { "vulpix", "slugma", "numel", "charmander", "cyndaquil", "torchic" };
    String[] water = new String[] { "feebas", "wooper", "lotad", "marill", "wingull", "poliwag" };
    String[] grass = new String[] { "cherubi", "seedot", "bulbasaur", "chikorita", "treecko", "bellsprout" };
    int level = generateLvl(name);

    if (type == 0) {
      String pokemon = fire[random];
      Pokemon pok = new Fire(pokemon, level, 0);
      //to string for pokem;on
      return pok;
    } else if (type == 1) {
      String pokemon = water[random];
      Pokemon pok = new Water(pokemon, level, 0);
      return pok;
    } else {
      String pokemon = grass[random];
      Pokemon pok = new Grass(pokemon, level, 0);
      return pok;
    }
  }

  public static int generateLvl(Player name) {
    int random = (int) ((Math.random() * 3 )+ (name._pokedex[0].getLvl()));
    return random;
  }

  public static int generateType() {
    int random = (int) ((Math.random() * 3));
    if (random == 0) {
      // type is Fire
      return 0;
    } else if (random == 1) {
      // type is Water
      return 1;
    } else {
      // type is Grass
      return 2;
    }
  }

  public static boolean generateGender() {
    int random = (int) (Math.random() * 10);
    if (random <= 5) {
      return true;
    } else {
      return false;
    }
  }

  public static String generateName() {
    String[] name = new String[] { "Dawn", "Lucas", "Barry", "Riley", "Rowen", "Cynthia" };
    int random = (int) ((Math.random() *6));
    return name[random];
  }

  public static void wait(int s) {
    try {
      Thread.sleep(s * 1000);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  public static boolean runaway() {
    int random = (int) (Math.random() * 10);
    if (random <= 5) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean walk(Player name, String region) {
    //StdAudio.loopInBackground("city.wav");
    System.out.println();
    System.out.println("You went on a walk");
    //wait(1);
    boolean cont = false;
    int random = (int) (Math.random() * 10);
    if (random <= 2) {
      System.out.println("Nothing has appeared");
      //wait(1);
      System.out.println("Walk again or go to a gym? (walk/gym)");
      String response = "";
      response = in.nextLine().toLowerCase();
        if (response.equals("walk")) {

          return false;
       } else if (response.equals("gym")){
          if (name._numPokemon < 4){
            //wait(1);
            System.out.println("You can not go to the gym with less than four pokemon. You walk again");

            return false;
          } else {
             boolean win = goToGym(name, region);
             if (win == true){
               cont = true;
             }
           }
       } else {
         //wait(1);
         System.out.println("That is not a valid response, you go on a walk");

         return false;
         }
       }
     else if (random >= 3 && random <= 4) {
      // meet someone battle
      System.out.println("A fellow pokemon trainer has appeared. They challenge you to a pokemon battle.");
      //wait(1);
      System.out.println("Do you want to battle or runaway? (battle/runaway)");
      String runawayOr = "";
      runawayOr = in.nextLine().toLowerCase();
        if (runawayOr.equals("runaway")) {
          boolean run = runaway();
          if (run == false) {
            //wait(1);
            System.out.println("running away failed. You must engage in battle");
            int type = generateType();
            Pokemon pok = generatePokemon(name, type);
            boolean win = battle(name, pok, region);
              if(win == false){

                goToNurse(name, region);
              } else {
                cont = false;
              }
            } else {
            //wait(1);
            System.out.println("You've sucessfullly runaway");
            //wait(1);
            System.out.println("You walked");
            // ask
          }
        } else if (runawayOr.equals("battle")) {
          //wait(1);
          System.out.println("You accept the challenge and engage in battle");
          int type = generateType();
          Pokemon pok = generatePokemon(name, type);
          boolean win = battle(name, pok, region);
          if (win == true){
            cont = false;
          } else {

            goToNurse(name, region);
          }
        } else {
            //wait(1);
            System.out.println("That is not a valid response, you engage in battle");
            //wait(1);
            System.out.println("You accept the challenge and engage in battle");
            int type = generateType();
            Pokemon pok = generatePokemon(name, type);
            boolean win = battle(name, pok, region);
            if (win == true){
              cont = false;
            } else {

              goToNurse(name, region);
            }
          }


    } else if (random >= 5 && random <= 6) {
      // civilian
      Human civilian = new Human(generateGender(), 3, generateName());
      //wait(1);
      System.out.println("You have encountered a civilian");
      civilian.greet(name);
      //wait(1);
      System.out.println(civilian._name + " gives you a Berry and a Pokeball for your efforts!");
      Player._numBerries += 1;
      Player._numPokeball += 1;
      //wait(1);
      civilian.goodbye(name);
      // add extra talking functionality
    } else {
      //wait(1);
      System.out.println("A pokemon has appeared!");
      //wait(1);
      System.out.println("Would you like to battle or run away? (battle/runaway)");
      String encounterPokemon = "";
      encounterPokemon = in.nextLine().toLowerCase();
        if (encounterPokemon.equals("runaway")) {
          boolean run = runaway();
          if (run == false) {
            //wait(1);
            System.out.println("running away failed. You must engage in battle");
            int type = generateType();
            Pokemon pok = generatePokemon(name, type);
            boolean win = battle(name, pok, region);
            if (win == false){

              goToNurse(name, region);
            } else {

              catchP(name, pok, region);
            }
          } else {
            //wait(1);
            System.out.println("You've sucessfully runaway");
            //wait(1);
            System.out.println("You walked");
            // ask them
          }
        } else if (encounterPokemon.equals("battle")) {
          //wait(1);
          System.out.println("You accept the challenge and engage in battle");
          int type = generateType();
          Pokemon pok = generatePokemon(name, type);
          System.out.println(pok._name);
          boolean win = battle(name, pok, region);
          if(win == false){

            goToNurse(name, region);
          } else {

            catchP(name, pok, region);
          }
        } else {
            //wait(1);
            System.out.println("That is not a valid response, you engage in battle");
            //wait(1);
            System.out.println("You accept the challenge and engage in battle");
            int type = generateType();
            Pokemon pok = generatePokemon(name, type);
            boolean win = battle(name, pok, region);
            if (win == true){

              catchP(name, pok, region);
            } else {

              goToNurse(name, region);
            }
        }
    }

    return cont;
  }



  public static String generateMove(Pokemon name) {
    String[] fireMoves = new String[] { "ember", "bulk up", "restore" };
    String[] waterMoves = new String[] { "water gun", "rain dance", "rest" };
    String[] grassMoves = new String[] { "razor leaf", "safe guard", "rest" };
    int randMove = (int) (((Math.random()) * 3));
    if (name instanceof Fire) {
      return fireMoves[randMove];
    } else if (name instanceof Water) {
      return waterMoves[randMove];
    } else if (name instanceof Grass){
      return grassMoves[randMove];
    }
    return "messed up";
  }

  public static boolean battle(Player name, Pokemon opponent, String region) {
    StdAudio.loopInBackground("battle.wav");
    boolean result = false;
    //wait(1);
    System.out.println("You begin your battle with " + opponent._name + "...");
    //wait(1);
    System.out.println("Here are the Stats of your Pokemon:");
    //wait(1);
    System.out.println();
    name.displayPokedex();
    System.out.println();
    //wait(1);
    System.out.println("Here are the Stats of your opponent's Pokemon:");
    System.out.println();
    opponent.displayt();
    System.out.println();
    while (opponent.isAlive() == true) {
      for (Pokemon p : name._pokedex) {
        //wait(1);
        System.out.println("You take out " + p._name + "!");
        while (p.isAlive() == true) {
          //wait(1);
          System.out.print("Choose a move...");
          //wait(1);
          p.displayMove();
          String answer = "";
          answer = in.nextLine().toLowerCase();
          while (!answer.equals("ember") && !answer.equals("bulk up") && !answer.equals("restore")
              && !answer.equals("water gun") && !answer.equals("rain dance") && !answer.equals("rest")
              && !answer.equals("razor leaf") && !answer.equals("safe guard")) {
            //wait(1);
            System.out.println("Input a valid move:");
            answer = in.nextLine().toLowerCase();
          }
          p.move(answer, opponent);
          //wait(1);
          p._exp = p._exp + 20;
          p.lvlUp();
          //wait(1);
          if (opponent.isAlive() == false){
            return true;
          }
          System.out.println(opponent._name + " makes a move");
          //wait(1);
          opponent.move(generateMove(opponent), p);
          //wait(1);
          System.out.println("Do you want to use a Berry? (yes/no)");
          String berry = "";
          berry = in.nextLine().toLowerCase();
            if (berry.equals("yes")) {
              if (Player._numBerries <= 0) {
                //wait(1);
                System.out.println("You cannot use a Berry.");
                //wait(1);
                System.out.println("You have no Berries left!");
              } else {
                Player._numBerries -= 1;
                p._hp += 20;
                // probably overrides
                //wait(1);
                System.out.println(p._name + "'s HP has been restored by 20!");
                //wait(1);
                System.out.println("Here is your inventory:");
                //wait(1);
                System.out.println();
                Player.displayInventory();
              }
            }
            else if (berry.equals("no")) {
              //wait(1);
              System.out.println("You choose to not use a berry.");
            }
            else {
              //wait(1);
              System.out.println("That is not a valid response, you do not get a berry");
            }
          }
          if (p.isAlive() == false) {
            //wait(1);
            System.out.println("All of your Pokemon have fainted!");
            //wait(1);
            System.out.println("Your Pokemon are rushed to the Nurse...");
            
            return result;
          }
        }

      }
      result = true;

      return result;
    }

  public static void goToNurse(Player name, String region) {
    //StdAudio.loopInBackground("city.wav");
    //wait(1);
    System.out.println("You have arrived at the clinic.");
    //wait(1);
    System.out.println("The Nurse has restored all of your Pokemon's health.");
    for (int i = 0; i < name._pokedexSize; i++) {
      name._pokedex[i]._hp = name._pokedex[i]._lvl * name._pokedex[i].getHPMultiplier();
    }
    System.out.println();
    name.displayPokedex();
    System.out.println();
    //wait(1);

    walk(name, region);
  }

  public static void catchP(Player name, Pokemon pokName, String region) {
    //StdAudio.loopInBackground("city.wav");
    int random = (int) ((Math.random() * 10));
    if (name._numPokeball <= 0) {
      //wait(1);
      System.out.println("You do not have enough pokeballs");
      //wait(1);

      walk(name, region);
    } else {
      if (random <= 7) {
        //wait(1);
        System.out.println("Congratulations, you have successfullly caught a " + pokName._name);
        name.add(pokName);
        name._numPokemon = name._numPokemon + 1;
        name._numPokeball = name._numPokeball - 1;
        System.out.println();
        name.displayPokedex();
        System.out.println();
        name.displayInventory();
        System.out.println();
        //wait(1);

        walk(name, region);
      } else {
        //wait(1);
        System.out.println("The pokemon got away");
        name._numPokeball = name._numPokeball - 1;
        System.out.println();
        name.displayInventory();
        System.out.println();
        //wait(1);

        walk(name, region);
      }
    }
  }

  public static boolean goToGym(Player name, String region){
    if (region.equals("Eterna City")) {
      return gymBattleGrass(name, region);
    } else if (region.equals("Pastria City")){
      return gymBattleWater(name, region);
    } else {
      return gymBattleFire(name, region);
    }
  }

  public static boolean gymBattleFire(Player name, String region) {
    //StdAudio.loopInBackground("city.wav");
    boolean badge = false;
    String answer = "";
    //wait(1);
    System.out.println("You enter the gym and prepare to fight Flint.");
    //wait(1);
    System.out.println("Do you wish to visit the Nurse before battling Flint? (yes/no)");
    answer = in.nextLine().toLowerCase();
      if (answer.equals("yes")) {
        //wait(1);
        System.out.println("You take a quick visit to the Nurse...");
        //wait(1);

        goToNurse(name, region);
      } else if (answer.equals("no")) {
        //wait(1);
        System.out.println("You enter the gym and prepare to battle Flint.");
        //wait(1);
        Pokemon infernape = new Fire("Infernape", 25, 3818);
        boolean firstBattle = battle(name, infernape, region);
        if (firstBattle == true) {
          //wait(1);
          System.out.println("Prepare to fight Flint's next Pokemon!");
          //wait(1);
          Pokemon rapidash = new Fire("Rapidash", 27, 2739);
          boolean secondBattle = battle(name, rapidash, region);
          if (secondBattle == true) {
            //wait(1);
            System.out.println("Congratulations! You have successfully defeated Flint!");
            //wait(1);
            System.out.println("You have earned the Fire Badge!");
            //wait(1);
            badge = true;
          }
        }
      } else {
        //wait(1);
        System.out.println("That is not a valid response, you will not go to the Nurse");
        //wait(1);
        System.out.println("You enter the gym and prepare to battle Flint.");
        //wait(1);
        Pokemon infernape = new Fire("Infernape", 25, 3818);
        boolean firstBattle = battle(name, infernape, region);
        if (firstBattle == true) {
          System.out.println("Prepare to fight Flint's next Pokemon!");
          //wait(1);
          Pokemon rapidash = new Fire("Rapidash", 27, 2739);
          boolean secondBattle = battle(name, rapidash, region);
          if (secondBattle == true) {
            System.out.println("Congratulations! You have successfully defeated Flint!");
            //wait(1);
            System.out.println("You have earned the Fire Badge!");
            //wait(1);
            badge = true;
          }
        }
      }

    return badge;
  }

  public static boolean gymBattleWater(Player name, String region) {
    //StdAudio.loopInBackground("city.wav");
    boolean badge = false;
    String answer = "";
    //wait(1);
    System.out.println("You enter the gym and prepare to fight Crasher Wake.");
    //wait(1);
    System.out.println("Do you wish to visit the Nurse before battling CrasherWake? (yes/no)");
    answer = in.nextLine().toLowerCase();
      if (answer.equals("yes")) {
        //wait(1);
        System.out.println("You take a quick visit to the Nurse...");
        //wait(1);

        goToNurse(name, region);
      } else if (answer.equals("no")) {
        //wait(1);
        System.out.println("You enter the gym and prepare to battle Crasher Wake.");
        //wait(1);
        Pokemon gyarados = new Water("Gyarados", 27, 2690);
        boolean firstBattle = battle(name, gyarados, region);
        if (firstBattle == true) {
          //wait(1);
          System.out.println("Prepare to fight Crasher Wake's next Pokemon!");
          //wait(1);
          Pokemon quagsire = new Water("Quagsire", 27, 2630);
          boolean secondBattle = battle(name, quagsire, region);
          if (secondBattle == true) {
            //wait(1);
            System.out.println("Prepare to fight Crasher Wake's next Pokemon");
            //wait(1);
            Pokemon floatzel = new Water("floatzel", 30, 2950);
            boolean thirdBattle = battle(name, floatzel, region);
            if (thirdBattle == true){
              //wait(1);
              System.out.println("Congratulations! You have successfully defeated Crasher Wake!");
              //wait(1);
              System.out.println("You have earned the Water Badge!");
              //wait(1);
              badge = true;
          }
        }
      }
    } else {
      //wait(1);
      System.out.println("That is not a valid response, you will not go to the nurse");
      //wait(1);
      System.out.println("You enter the gym and prepare to battle Crasher Wake.");
      //wait(1);
      Pokemon gyarados = new Water("Gyarados", 27, 2690);
      boolean firstBattle = battle(name, gyarados, region);
      if (firstBattle == true) {
        //wait(1);
        System.out.println("Prepare to fight Crasher Wake's next Pokemon!");
        //wait(1);
        Pokemon quagsire = new Water("Quagsire", 27, 2630);
        boolean secondBattle = battle(name, quagsire, region);
        if (secondBattle == true) {
          //wait(1);
          System.out.println("Prepare to fight Crasher Wake's next Pokemon");
          //wait(1);
          Pokemon floatzel = new Water("floatzel", 30, 2950);
          boolean thirdBattle = battle(name, floatzel, region);
          if (thirdBattle == true){
            //wait(1);
            System.out.println("Congratulations! You have successfully defeated Crasher Wake!");
            //wait(1);
            System.out.println("You have earned the Water Badge!");
            badge = true;
        }
      }
    }
  }

  return badge;
}
    public static boolean gymBattleGrass(Player name, String region) {
      //StdAudio.loopInBackground("city.wav");
      boolean badge = false;
      String answer = "";
      //wait(1);
      System.out.println("You enter the gym and prepare to fight Gardeniae.");
      //wait(1);
      System.out.println("Do you wish to visit the Nurse before battling Gardenia? (yes/no)");
      answer = in.nextLine().toLowerCase();
        if (answer.equals("yes")) {
          //wait(1);
          System.out.println("You take a quick visit to the Nurse...");
          //wait(1);

          goToNurse(name, region);
        } else if (answer.equals("no")) {
          //wait(1);
          System.out.println("You enter the gym and prepare to battle Gardenia.");
          //wait(1);
          Pokemon cherubi = new Water("cherubi", 19, 1990);
          boolean firstBattle = battle(name, cherubi, region);
          if (firstBattle == true) {
            //wait(1);
            System.out.println("Prepare to fight Gardenia's next Pokemon!");
            //wait(1);
            Pokemon turtwig = new Water("turtwig", 27, 1930);
            boolean secondBattle = battle(name, turtwig, region);
            if (secondBattle == true) {
              //wait(1);
              System.out.println("Prepare to fight Gardenia's next Pokemon");
              //wait(1);
              Pokemon roserade = new Water("roserade",22, 2250);
              boolean thirdBattle = battle(name, roserade, region);
              if (thirdBattle == true){
                //wait(1);
                System.out.println("Congratulations! You have successfully defeated Gardenia!");
                //wait(1);
                System.out.println("You have earned the Water Badge!");
                //wait(1);
                badge = true;
            }
          }
        }
      } else {
        //wait(1);
        System.out.println("That is not a valid response, you will not go to the nurse");
        //wait(1);
        System.out.println("You enter the gym and prepare to battle Gardenia.");
        //wait(1);
        Pokemon cherubi = new Water("cherubi", 19, 1990);
        boolean firstBattle = battle(name, cherubi, region);
        if (firstBattle == true) {
          //wait(1);
          System.out.println("Prepare to fight Gardenia's next Pokemon!");
          //wait(1);
          Pokemon turtwig = new Water("turtwig", 27, 1930);
          boolean secondBattle = battle(name, turtwig, region);
          if (secondBattle == true) {
            //wait(1);
            System.out.println("Prepare to fight Gardenia's next Pokemon");
            //wait(1);
            Pokemon roserade = new Water("roserade",22, 2250);
            boolean thirdBattle = battle(name, roserade, region);
            if (thirdBattle == true){
              //wait(1);
              System.out.println("Congratulations! You have successfully defeated Gardenia!");
              //wait(1);
              System.out.println("You have earned the Water Badge!");
              //wait(1);
              badge = true;
          }
        }
      }
    }

    return badge;
  }
  public static void gameSetup(Player player){
    //StdAudio.loopInBackground("city.wav");
    System.out.println("Welcome, Trainer, to Pokemon Shining Pearl!");
    //wait(1);
    System.out.println("\nWhat is your name?");
    String name = "";
    name = in.nextLine();
    player._name = name;
    //wait(1);

  }

  public static void chooseStarter(Player player){
    //StdAudio.loopInBackground("city.wav");
    //wait(2);
    System.out.println("\nRING RING! Wake up " + player._name + "!" + " Your mom told you to go to Dr. Footstep's clinic to get your first starter Pokemon.");
    //wait(2);
    System.out.println("\nYou totally forgot. Today is your 10th birthday. You're finally old enough to become a Pokemon trainer!");
    //wait(2);
    System.out.println("\nYou rush over to the pokemon clinic and luckily the line isn't long.");
    //wait(2);
    System.out.print("\nA");
    //wait(2);
    System.out.print(" few");
    //wait(2);
    System.out.print(" minutes");
    //wait(2);
    System.out.print(" later");
    //wait(2);
    System.out.println("...");
    //wait(3);
    System.out.println("\nIt's finally your turn!");
    // wake up, go to drs place to pick Pokemon
    //wait(1);

    System.out.println("\nThere are three starter Pokemons: Chimchar, Piplup, and Turtwig.");
    //wait(1);

    System.out.println("\nInput the pokemon that you want to know more about:");
    String pokemonOne = "";

    // POKEMON DESCRIPTIONS
    pokemonOne = in.nextLine().toLowerCase();
    if (pokemonOne.equals("chimchar")) {
      Fire chimchar = new Fire("Chimchar", 5, 40);
      //wait(1);
      System.out.println("\nA Chimp Pokemon.");
      //wait(1);
      System.out.println("With a flaming tail, Chimchar is skilled in Fire-type moves.");
      //wait(1);
      System.out.println("Its light body affords it the ability to scale steep cliffs and live atop rocky mountains.");
      //wait(1);
      System.out.println("Some say that the fiery tail is fueled by gas made in its stomach.");
      //wait(1);
      System.out.println("Not even rain can put out the flames, but Chimchar always puts out the fire when asleep.");
      //wait(1);
      System.out.println();
      chimchar.display();
    } else if (pokemonOne.equals("piplup")) {
      Pokemon piplup = new Water("Piplup", 5, 40);
      //wait(1);
      System.out.println("\nA Penguin Pokemon.");
      //wait(2);
      System.out.println("It's one of the starter Pokemon received from Professor Rowan when the player departs from the Sinnoh region.");
      //wait(2);
      System.out.println("It's a Water type, so it's strong versus Rock and Grounds.");
      //wait(2);
      System.out.println("It's very cute but filled with pride--it hates to accept food from people.");
      //wait(2);
      System.out.println();
      piplup.display();
    } else if (pokemonOne.equals("turtwig")) {
      Pokemon turtwig = new Grass("Turtwig", 5, 40);
      //wait(1);
      System.out.println("\nA Tiny Leaf Pokemon.");
      //wait(2);
      System.out.println("Despite its animal appearance, Turtwig actually has vegetation sprouting from its head.");
      //wait(2);
      System.out.println("The shell on its back is made of soil and hardens when it drinks water.");
      //wait(2);
      System.out.println("Much like a plant, Turtwig performs photosynthesis, absorbing sunlight and making oxygen.");
      //wait(2);
      System.out.println("It also relies heavily on water to keep its plant healthy and thus spends a lot of time near lakes.");
      //wait(2);
      System.out.println();
      turtwig.display();
    } else {
      //wait(1);
      System.out.println("\nThat's not exactly a Pokemon, but Dr. Footstep wants to show you Chimchar.");
      Pokemon chimchar = new Fire("Chimchar", 5, 40);
      //wait(1);
      System.out.println("\nA Chimp Pokemon.");
      //wait(1);
      System.out.println("With a flaming tail, Chimchar is skilled in Fire-type moves.");
      //wait(1);
      System.out.println("Its light body affords it the ability to scale steep cliffs and live atop rocky mountains.");
      //wait(1);
      System.out.println("Some say that the fiery tail is fueled by gas made in its stomach.");
      //wait(1);
      System.out.println("Not even rain can put out the flames, but Chimchar always puts out the fire when asleep.");
      //wait(1);
      System.out.println();
      chimchar.display();
    }

    //wait(2);
    System.out.println("\nInput another pokemon that you want to know more about:");
    String pokemonTwo = "";

    pokemonTwo = in.nextLine().toLowerCase();
    if (pokemonTwo.equals("chimchar")) {
      Pokemon chimchar = new Fire("Chimchar", 5, 40);
      //wait(1);
      System.out.println("\nA Chimp Pokemon.");
      //wait(1);
      System.out.println("With a flaming tail, Chimchar is skilled in Fire-type moves.");
      //wait(1);
      System.out.println("Its light body affords it the ability to scale steep cliffs and live atop rocky mountains.");
      //wait(1);
      System.out.println("Some say that the fiery tail is fueled by gas made in its stomach.");
      //wait(1);
      System.out.println("Not even rain can put out the flames, but Chimchar always puts out the fire when asleep.");
      //wait(1);
      System.out.println();
      chimchar.display();
    } else if (pokemonTwo.equals("piplup")) {
      Pokemon piplup = new Water("Piplup", 5, 40);
      //wait(1);
      System.out.println("\nA Penguin Pokemon.");
      //wait(1);
      System.out.println("It's one of the starter Pokemon received from Professor Rowan when the player departs from the Sinnoh region.");
      //wait(1);
      System.out.println("It's a Water type, so it's strong versus Rock and Grounds.");
      //wait(1);
      System.out.println("It's very cute but filled with pride--it hates to accept food from people.");
      //wait(1);
      System.out.println();
      piplup.display();
    } else if (pokemonTwo.equals("turtwig")) {
      Pokemon turtwig = new Grass("Turtwig", 5, 40);
      //wait(1);
      System.out.println("\nA Tiny Leaf Pokemon.");
      //wait(1);
      System.out.println("Despite its animal appearance, Turtwig actually has vegetation sprouting from its head.");
      //wait(1);
      System.out.println("The shell on its back is made of soil and hardens when it drinks water.");
      //wait(1);
      System.out.println("Much like a plant, Turtwig performs photosynthesis, absorbing sunlight and making oxygen.");
      //wait(1);
      System.out.println("It also relies heavily on water to keep its plant healthy and thus spends a lot of time near lakes.");
      //wait(1);
      System.out.println();
      turtwig.display();
    } else {
      //wait(1);
      System.out.println("\nThat's not exactly a Pokemon, but Dr. Footstep wants to show you Piplup.");
      Pokemon piplup = new Water("Piplup", 5, 40);
      //wait(1);
      System.out.println("A Penguin Pokemon.");
      //wait(1);
      System.out.println("It's one of the starter Pokemon received from Professor Rowan when the player departs from the Sinnoh region.");
      //wait(1);
      System.out.println("It's a Water type, so it's strong versus Rock and Grounds.");
      //wait(1);
      System.out.println("It's very cute but filled with pride--it hates to accept food from people.");
      //wait(1);
      System.out.println();
      piplup.display();
    }

    //wait(2);
    System.out.println("\nInput the last pokemon:");
    String pokemonThree = "";

    pokemonThree = in.nextLine().toLowerCase();
    if (pokemonThree.equals("chimchar")) {
      Pokemon chimchar = new Fire("Chimchar", 5, 40);
      //wait(1);
      System.out.println("\nA Chimp Pokemon.");
      //wait(1);
      System.out.println("With a flaming tail, Chimchar is skilled in Fire-type moves.");
      //wait(1);
      System.out.println("Its light body affords it the ability to scale steep cliffs and live atop rocky mountains.");
      //wait(1);
      System.out.println("Some say that the fiery tail is fueled by gas made in its stomach.");
      //wait(1);
      System.out.println("Not even rain can put out the flames, but Chimchar always puts out the fire when asleep.");
      //wait(1);
      System.out.println();
      chimchar.display();
    } else if (pokemonThree.equals("piplup")) {
      Pokemon piplup = new Water("Piplup", 5, 40);
      //wait(1);
      System.out.println("\nA Penguin Pokemon.");
      //wait(1);
      System.out.println("It's one of the starter Pokemon received from Professor Rowan when the player departs from the Sinnoh region.");
      //wait(1);
      System.out.println("It's a Water type, so it's strong versus Rock and Grounds.");
      //wait(1);
      System.out.println("It's very cute but filled with pride--it hates to accept food from people.");
      //wait(1);
      System.out.println();
      piplup.display();
    } else if (pokemonThree.equals("turtwig")) {
      Pokemon turtwig = new Grass("Turtwig", 5, 40);
      //wait(1);
      System.out.println("\nA Tiny Leaf Pokemon.");
      //wait(1);
      System.out.println("Despite its animal appearance, Turtwig actually has vegetation sprouting from its head.");
      //wait(1);
      System.out.println("The shell on its back is made of soil and hardens when it drinks water.");
      //wait(1);
      System.out.println("Much like a plant, Turtwig performs photosynthesis, absorbing sunlight and making oxygen.");
      //wait(1);
      System.out.println("It also relies heavily on water to keep its plant healthy and thus spends a lot of time near lakes.");
      //wait(1);
      System.out.println();
      turtwig.display();
    } else {
      //wait(1);
      System.out.println("\nThat's not exactly a Pokemon, but Dr. Footstep wants to show you Turtwig.");
      Pokemon turtwig = new Grass("Turtwig", 5, 40);
      //wait(1);
      System.out.println("\nA Tiny Leaf Pokemon.");
      //wait(1);
      System.out.println("Despite its animal appearance, Turtwig actually has vegetation sprouting from its head.");
      //wait(1);
      System.out.println("The shell on its back is made of soil and hardens when it drinks water.");
      //wait(1);
      System.out.println("Much like a plant, Turtwig performs photosynthesis, absorbing sunlight and making oxygen.");
      //wait(1);
      System.out.println("It also relies heavily on water to keep its plant healthy and thus spends a lot of time near lakes.");
      //wait(1);
      System.out.println();
      turtwig.display();
    }
    // Instance of Pokemon

    // CHOOSING POKEMON

    //wait(1);
    System.out.println("\nWhich starter Pokemon do you want? (chimchar/piplup/turtig)");
    String response = "";

    response = in.nextLine().toLowerCase();
    if (response.equals("chimchar")) {
      Fire starter = new Fire("Chimchar", 5, 40);
      Player.add(starter);
      //wait(1);
      System.out.println("\nCongrats, you got your first Pokemon! It's a Chimchar!");
    } else if (response.equals("piplup")) {
      Water starter = new Water("Piplup", 5, 40);
      Player.add(starter);
      //wait(1);
      System.out.println("\nCongrats, you got your first Pokemon! It's a Piplup!");
    } else if (response.equals("turtwig")) {
      Grass starter = new Grass("Turtwig", 5, 40);
      Player.add(starter);
      //wait(1);
      System.out.println("\nCongrats, you got your first Pokemon! It's a Turtwig!");
    } else if (!response.equals("chimchar") && !response.equals("piplup") && !response.equals("turtwig")) {
      int random = (int) ((Math.random() * 3));
      if (random == 0) {
        Fire starter = new Fire("Chimchar", 5, 40);
        Player.add(starter);
        //wait(1);
        System.out.println("\nYou responded too late! The only Pokemon left is Chimchar!");
      } else if (random == 1) {
        Water starter = new Water("Piplup", 5, 40);
        Player.add(starter);
        //wait(1);
        System.out.println("\nYou responded too late! The only Pokemon left is Piplup!");
      } else if (random == 2) {
        Grass starter = new Grass("Turtwig", 5, 40);
        Player.add(starter);
        //wait(1);
        System.out.println("\nYou responded too late! The only Pokemon left is Turtwig!");
      }
    }

    Player._numPokemon += 1;
    //wait(1);
    System.out.println("\nYou also receive 5 Pokeballs and 5 berries from Dr. Footstep.");
    Player._numPokeball += 5;
    Player._numBerries += 5;
    Player.displayInventory();
    //wait(1);
    System.out.println("\nYou thank Dr. Footstep and walk out of the clinic.");
    System.out.println();

  }

  Woo game = new Woo();

  public static void test(){
    Fire pok = new Fire ("name", 2, 0);
    System.out.println(pok._name);
  }

  public static void main(String[] args) {
    Player player = new Player();
    //StdAudio.loopInBackground("city.wav");
    gameSetup(player);
    chooseStarter(player);


    String[] regions = new String[] {"Eterna City", "Pastoria City", "Sunyshore City"};
    int i = 0;
    while (i < 3){
      if (walk(player, regions[i]) == true){
        System.out.println("You beat " + regions[i]);
      }
    }
      System.out.println("\nYou beat the game. Congragulations!");
      StdAudio.close();

    //response = in.nextLine().toLowerCase();
  }
}

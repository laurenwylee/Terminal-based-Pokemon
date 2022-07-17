import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;

public class Woo {

  static Scanner in = new Scanner(System.in); //user inputs
  StdAudio city = new StdAudio(); //in game music

  //should generate a pokemon that is an instance of the type
  public static Pokemon generatePokemon(Player name, int type) {
    int random = (int) ((Math.random() * 6)); //0-5
    String[] fire = new String[] { "Vulpix", "Slugma", "Numel", "Charmander", "Cyndaquil", "Torchic" };
    String[] water = new String[] { "Feebas", "Wooper", "Lotad", "Marill", "Wingull", "Poliwag" };
    String[] grass = new String[] { "Cherubi", "Seedot", "Bulbasaur", "Chikorita", "Treecko", "Bellsprout" };
    int level = generateLvl(name);

    if (type == 0) { // 0 is fire
      String pokemon = fire[random];
      Pokemon pok = new Fire(pokemon, 5, level*100);
      return pok;
    }
    else if (type == 1) { //1 is water
      String pokemon = water[random];
      Pokemon pok = new Water(pokemon, level, level*100);
      return pok;
    }
    else { //3 is grass
      String pokemon = grass[random];
      Pokemon pok = new Grass(pokemon, level, level*100);
      return pok;
    }
  }

  //level is randomly generated. range is two levels below the starter pokemon level and two levels above
  public static int generateLvl(Player name) {
    int random = (int) ((Math.random() * 5 )+ ((name._pokedex[0].getLvl())-2));
    return random;
  }

  // type is indicated by the random number generated from 0-3
  public static int generateType() {
    int random = (int) ((Math.random() * 3));
    if (random == 0) {
      // type is Fire
      return 0;
    }
    else if (random == 1) {
      // type is Water
      return 1;
    }
    else {
      // type is Grass
      return 2;
    }
  }

  //50% male and 50% female gender for civilian
  public static boolean generateGender() {
    int random = (int) (Math.random() * 10);
    if (random <= 5) {
      return true;
    }
    else {
      return false;
    }
  }

  //generates name for civilian
  public static String generateName() {
    String[] name = new String[] { "Dawn", "Lucas", "Barry", "Riley", "Rowen", "Cynthia" };
    int random = (int) ((Math.random() *6));
    return name[random];
  }


  public static void wait(int s) {
    try {
      Thread.sleep(s * 500);
    }
    catch (InterruptedException ex) {
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

  //to make walk invoke with the same parameteres, just return false because there is a while loop in the main method making the player walk until the gym is completed
  public static boolean walk(Player name, String region) {
    //wait(1);
    System.out.println("\nYou went on a walk...");
    //wait(1);
    boolean cont = false;
    int random = (int) (Math.random() * 10); //random number from 0-9
    if (random <= 2) { // 30% chance that nothing appears
      System.out.println("\nNothing appeared.");
      //wait(1);
      System.out.println("\nWalk again or go to a gym? (walk/gym)"); //if nothing appears, can go to gym or walk again
      String response = "";
      response = in.nextLine().toLowerCase();
      if (response.equals("walk")) {
        return cont;
      }
      else if (response.equals("gym")) {
        System.out.println(name._numPokemon);
        if (name._numPokemon < 1){ //cannot go to gym if player has less than four pokemon
          //wait(1);
          System.out.println("\nYou can not go to the gym with less than four pokemon. You walk again...");
          return cont;
        }
        else {
          return goToGym(name, region);
        }
      }
      else {
       //wait(1);
         System.out.println("\nThat is not a valid response. You go on a walk...");
         return false;
      }
    }
    else if (random >= 3 && random <= 4) {
    // meet someone battle is probability of 20%
      System.out.println("\nA fellow Pokemon trainer appeared. They challenge you to a Pokemon battle.");
      //wait(1);
      System.out.println("\nDo you want to battle or run away? (battle/runaway)");
      String runawayOr = "";
      runawayOr = in.nextLine().toLowerCase();
        if (runawayOr.equals("runaway")) {
          boolean run = runaway(); //runaway opporates on a probability. If it can run away, true is returned
          if (run == false) {
            //wait(1);
            System.out.println("\nRunning away failed. You must engage in battle.");
            int type = generateType(); //generates a type for pokemon
            Pokemon pok = generatePokemon(name, type); //generates pokemon to battle
            boolean win = battle(name, pok, region); //battles the pokemon
            if (win == false) {
              goToNurse(name, region); //is lose, go to nurse
            }
            else {
              cont = false; //if win, continue to walk
            }
          }
          else {
          //wait(1);
          System.out.println("\nYou sucessfully escaped!");
          //wait(1);
          System.out.println("\nWalk again or go to a gym? (walk/gym)"); //if nothing appears, can go to gym or walk again
          String response = "";
          response = in.nextLine().toLowerCase();
          if (response.equals("walk")) {
            return cont;
          }
          else if (response.equals("gym")) {
            if (name._numPokemon < 1){ //cannot go to gym if player has less than four pokemon
              //wait(1);
              System.out.println("\nYou can not go to the gym with less than four pokemon. You walk again...");
              return cont;
            }
            else {
              return goToGym(name, region);
            }
          }
          else {
           //wait(1);
             System.out.println("\nThat is not a valid response. You go on a walk...");
             return false;
          }
          // ask
          }
        }
        else if (runawayOr.equals("battle")) {
          //wait(1);
          System.out.println("\nYou accept the challenge and engage in battle.");
          int type = generateType();
          Pokemon pok = generatePokemon(name, type);
          boolean win = battle(name, pok, region);
          if (win == true) {
            cont = false;
          }
          else {
            goToNurse(name, region);
          }
        }
        else {
          //wait(1);
          System.out.println("\nThat is not a valid response. You engage in battle...");
          //wait(1);
          System.out.println("\nYou accept the challenge and engage in battle.");
          int type = generateType();
          Pokemon pok = generatePokemon(name, type);
          boolean win = battle(name, pok, region);
          if (win == true) {
            cont = false;
          } else {
            goToNurse(name, region);
          }
        }
      }
      else if (random >= 5 && random <= 6) {
        // meeting a civilian is probability of 20%
        Human civilian = new Human(generateGender(), 3, generateName()); //civilian randomly generated
        //wait(1);
        System.out.println("\nYou encounter a civilian.");
        System.out.println();
        civilian.greet(name); //civilian greets player
        //wait(1);
        System.out.println("\n" + civilian._name + " gives you a Berry and a Pokeball for your efforts!");
        System.out.println();
        name._numBerries += 1;
        name._numPokeball += 1;
        //civilian gives player pokeball and berries
        //wait(1);
        civilian.goodbye(name); //civilian leaves
        // add extra talking functionality for stretch
        System.out.println("Do you want to walk or go to the gym? (walk/gym)");
        String res = "";
        res = in.nextLine().toLowerCase();
        if (res.equals("walk")) {
          return cont;
        }
        else if (res.equals("gym")) {
          System.out.println(name._numPokemon);
          if (name._numPokemon < 4){ //cannot go to gym if player has less than four pokemon
            //wait(1);
            System.out.println("\nYou can not go to the gym with less than four pokemon. You walk again...");
            return cont;
          }
          else {
            return goToGym(name, region);
          }
        }
        else {
         //wait(1);
           System.out.println("\nThat is not a valid response. You go on a walk...");
           return false;
        }
      }
      else {
        //wait(1);
        System.out.println("\nA Pokemon appeared!");
        //wait(1);
        System.out.println("\nWould you like to battle or run away? (battle/runaway)");
        String encounterPokemon = "";
        encounterPokemon = in.nextLine().toLowerCase();
          if (encounterPokemon.equals("runaway")) {
            boolean run = runaway();
            if (run == false) {
              //wait(1);
              System.out.println("\nRunning away failed. You must engage in battle.");
              int type = generateType();
              Pokemon pok = generatePokemon(name, type);
              boolean win = battle(name, pok, region);
              if (win == false) {
                goToNurse(name, region);
              }
              else {
                catchP(name, pok, region);
              }
            }
            else {
              //wait(1);
              System.out.println("\nYou sucessfully escaped!");
              //wait(1);
              System.out.println("\nWalk again or go to a gym? (walk/gym)"); //if nothing appears, can go to gym or walk again
              String response = "";
              response = in.nextLine().toLowerCase();
              if (response.equals("walk")) {
                return cont;
              }
              else if (response.equals("gym")) {
                System.out.println(name._numPokemon);
                if (name._numPokemon < 4){ //cannot go to gym if player has less than four pokemon
                  //wait(1);
                  System.out.println("\nYou can not go to the gym with less than four pokemon. You walk again...");
                  return cont;
                }
                else {
                  return goToGym(name, region);
                }
              }
              else {
               //wait(1);
                 System.out.println("\nThat is not a valid response. You go on a walk...");
                 return false;
              }
            }
          }
          else if (encounterPokemon.equals("battle")) {
            //wait(1);
            System.out.println("\nYou accept the challenge and engage in battle.");
            int type = generateType();
            Pokemon pok = generatePokemon(name, type);
            System.out.println(pok._name);
            boolean win = battle(name, pok, region);
            if(win == false){
              goToNurse(name, region); //if lose, go to nurse to heal
            }
            else {
              catchP(name, pok, region); //if win, automatically try to catch, based on probability
            }
          }
          else {
            //wait(1);
            System.out.println("\nThat is not a valid response. You engage in battle.");
            //wait(1);
            System.out.println("\nYou accept the challenge and engage in battle.");
            int type = generateType();
            Pokemon pok = generatePokemon(name, type);
            boolean win = battle(name, pok, region);
            if (win == true){
              catchP(name, pok, region);
            }
            else {
              goToNurse(name, region);
            }
          }
        }
      return cont;
    }

    public static void catchP(Player name, Pokemon pokName, String region) {
      //StdAudio.loopInBackground("city.wav");
      int random = (int) ((Math.random() * 10));
      System.out.println("You try to catch a " + pokName._name + "...");
        //wait(1);
      if (name._numPokeball <= 0) {
        //wait(1);
        System.out.println("You do not have enough pokeballs."); //need pokeball to catch
        //wait(1);
        walk(name, region);
      }
      else {
        if (random <= 7) { //catching is very likely
          //wait(1);
          System.out.println("Congratulations, you have successfullly caught a " + pokName._name + "!");
          pokName._hp = pokName._lvl * pokName.getHPMultiplier();
          pokName._defense = pokName._lvl*pokName.getDefenseMultiplier();
          name.add(pokName);
          name._numPokemon = name._numPokemon + 1;
          name._numPokeball = name._numPokeball - 1;
          System.out.println();
          name.displayPokedex(); //print out pokemon
          System.out.println();
          name.displayInventory(); //print out inventory
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
  //start and end battle. If win, true; lose, false
  public static boolean battle(Player name, Pokemon opponent, String region) {
    //  StdAudio.loopInBackground("battle.wav"); // start some smashing battle music
      boolean result = false;
      //wait(1);
      System.out.println("You begin your battle with " + opponent._name + "...");
      System.out.println();
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
      while (opponent.isAlive() == true) { //continue to attack if opponent is alive
        int i = 0;
        while ( i < name._pokedexSize) { //will go through each pokemon in order of catching to try to faint opponent
          //wait(1);
          System.out.println("You take out " + name._pokedex[i]._name + "!");
          while (name._pokedex[i].isAlive() ==true) { //if the pokemon you took out is still alive, it will continue to attack
            //wait(1);
            System.out.print("Choose a move...");
            //wait(1);
            name._pokedex[i].displayMove(); //allows user to see moves
            String answer = "";
            answer = in.nextLine().toLowerCase();
            while (!answer.equals("ember") && !answer.equals("bulk up") && !answer.equals("restore")
                && !answer.equals("water gun") && !answer.equals("rain dance") && !answer.equals("rest")
                && !answer.equals("razor leaf") && !answer.equals("safe guard")) { //if input not valid, asks for another input until it is valid
              //wait(1);
              System.out.println("Input a valid move:");
              answer = in.nextLine().toLowerCase();
            }
            System.out.println();
            name._pokedex[i].move(answer, opponent); //pokemon makes a move
            //wait(1);
            name._pokedex[i]._exp = name._pokedex[i]._exp + 20; //exp goes up each move
            name._pokedex[i].lvlUp(); //level up if the exp is full (100 exp)
            //if level up, should make pokemon healthy again
            //wait(1);
            if (opponent.isAlive() == false){
              result = true;
              goToNurseNull(name, region); // after battle, heal pokemon
              return result; //if the opponent dies, battle terminated, returns true
            }
            System.out.println();
            System.out.println(opponent._name + " makes a move"); //opponent makes a move
            System.out.println();
            //wait(1);
            opponent.moveOther(generateMove(opponent), name._pokedex[i]); //opponents move is random
            //wait(1);
          }
            i = i + 1; //If by this time, the opponent is still alive but the battling pokemon is dead after the opponent move is case, increment to pull out new pokemon
        }
        //wait(1);
        //if there are no more pokemon left, display stats of fainted pokemon
        name._pokedex[i-1].displayt();
        System.out.println();
        System.out.println("All of your Pokemon have fainted!");
        //wait(1);
        System.out.println("Your Pokemon are rushed to the Nurse...");
        // will go to the nurse
        return result;
      }
        // if pokemon is not alive, it is fainted, you go to the nurse to recover and them return true
        //StdAudio.close();
        result = true;
        goToNurseNull(name,region);
        return result;
    }

    //move generate depends on what type of pokemon it is
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
      return "something got messed up";
      }

  // nurse heals and makes walk
    public static void goToNurse(Player name, String region) {
      //StdAudio.loopInBackground("city.wav");
      //wait(1);
      System.out.println("You have arrived at the clinic.");
      //wait(1);
      System.out.println("The Nurse has restored all of your Pokemon's health.");
      for (int i = 0 ; i < name._pokedexSize; i++) {
        name._pokedex[i]._hp = name._pokedex[i]._lvl * name._pokedex[i].getHPMultiplier();
        //heals hp
        name._pokedex[i]._defense = name._pokedex[i]._lvl*name._pokedex[i].getDefenseMultiplier();
        //heals defense

        //displays newly healed pokemon
        System.out.println();
        name.displayPokedex();
        System.out.println();
        //wait(1);
      }
      walk(name, region);
    }

    //same nurse functionality, but do not walk.
  public static void goToNurseGym(Player name, String region){
    //wait(1);
    System.out.println("You have arrived at the clinic.");
    //wait(1);
    System.out.println("The Nurse has restored all of your Pokemon's health.");
    for (int i = 0 ; i < name._pokedexSize; i++) {
      name._pokedex[i]._hp = name._pokedex[i]._lvl * name._pokedex[i].getHPMultiplier();
      name._pokedex[i]._defense = name._pokedex[i]._lvl*name._pokedex[i].getDefenseMultiplier();
    }
    System.out.println();
    name.displayPokedex();
    System.out.println();
    //wait(1);
    System.out.println("You leave the nurse.");
    goToGym(name, region);
  }

  public static void goToNurseNull(Player name, String region){
    //wait(1);
    System.out.println("You have arrived at the clinic.");
    //wait(1);
    System.out.println("The Nurse has restored all of your Pokemon's health.");
    for (int i = 0 ; i < name._pokedexSize; i++) {
      name._pokedex[i]._hp = name._pokedex[i]._lvl * name._pokedex[i].getHPMultiplier();
      name._pokedex[i]._defense = name._pokedex[i]._lvl*name._pokedex[i].getDefenseMultiplier();
    }
    System.out.println();
    name.displayPokedex();
    System.out.println();
    //wait(1);
    System.out.println("You leave the nurse.");
  }

  public static boolean goToGym(Player name, String region) {
    //gym depends on region
    if (region.equals("Eterna City")) {
      return gymBattleGrass(name, region);
    }
    else if (region.equals("Pastoria City")){
      return gymBattleWater(name, region);
    }
    else {
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
      goToNurseGym(name, region);
    } else if (answer.equals("no")) {
      //wait(1);
      System.out.println("You enter the gym and prepare to battle Flint.");
      //wait(1);
      Pokemon infernape = new Fire("Infernape", 25, 3818);
      boolean firstBattle = battle(name, infernape, region);
      if (firstBattle == true) { //if wins first battle, fights next
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
          badge = true; //if win both, then return true
          return badge;
          }
        }
      }
       else {
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
            return badge;
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

      //StdAudio.close();
      goToNurseGym(name, region);
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
            return badge;
          }
        }
      }
    }
    else {
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
            return badge;
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
      System.out.println("You enter the gym and prepare to fight Gardenia.");
      //wait(1);
      System.out.println("Do you wish to visit the Nurse before battling Gardenia? (yes/no)");
      answer = in.nextLine().toLowerCase();
      if (answer.equals("yes")) {
        //wait(1);
        System.out.println("You take a quick visit to the Nurse...");
        //wait(1);

        //StdAudio.close();
        goToNurseGym(name, region);
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
              System.out.println("You have earned the Grass Badge!");
              //wait(1);
              badge = true;
              return badge;
            }
          }
        }
      }
       else {
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
              System.out.println("You have earned the Grass Badge!");
              //wait(1);
              badge = true;
              return badge;
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
      Fire starter = new Fire("Chimchar", 4, 400);
      player.add(starter);
      //wait(1);
      System.out.println("\nCongrats, you got your first Pokemon! It's a Chimchar!");
    } else if (response.equals("piplup")) {
      Water starter = new Water("Piplup", 4, 400);
      player.add(starter);
      //wait(1);
      System.out.println("\nCongrats, you got your first Pokemon! It's a Piplup!");
    } else if (response.equals("turtwig")) {
      Grass starter = new Grass("Turtwig", 4, 400);
      player.add(starter);
      //wait(1);
      System.out.println("\nCongrats, you got your first Pokemon! It's a Turtwig!");
    } else if (!response.equals("chimchar") && !response.equals("piplup") && !response.equals("turtwig")) {
      int random = (int) ((Math.random() * 3));
      if (random == 0) {
        Fire starter = new Fire("Chimchar", 4, 400);
        player.add(starter);
        //wait(1);
        System.out.println("\nYou responded too late! The only Pokemon left is Chimchar!");
      } else if (random == 1) {
        Water starter = new Water("Piplup", 4, 400);
        player.add(starter);
        //wait(1);
        System.out.println("\nYou responded too late! The only Pokemon left is Piplup!");
      } else if (random == 2) {
        Grass starter = new Grass("Turtwig", 4, 400);
        player.add(starter);
        //wait(1);
        System.out.println("\nYou responded too late! The only Pokemon left is Turtwig!");
      }
    }
    player._numPokemon += 1;
    player.displayPokedex();
    System.out.println();
    //wait(1);
    System.out.println("\nYou also receive 5 Pokeballs and 5 berries from Dr. Footstep.");
    player._numPokeball += 5;
    player._numBerries += 5;
    System.out.println();
    player.displayInventory();
    //wait(1);
    System.out.println();
    System.out.println("\nYou thank Dr. Footstep and walk out of the clinic.");
    System.out.println();

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
        i++;
      }
    }
      System.out.println("\nYou beat the game. Congragulations!");
      StdAudio.close();

    //response = in.nextLine().toLowerCase();
  }
}

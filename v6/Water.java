import java.util.*;
import java.util.Scanner;

public class Water extends Pokemon implements Types{

static Scanner in = new Scanner(System.in);
  public Water(String name, int lvl, int exp){
    _hp = 7 * lvl;
    _attack = 7 * lvl;
    _defense = 7 * lvl;
    _mana = 10 * lvl;
    _name = name;
    _lvl = lvl;
    _exp = 100*lvl;
  }

  public static void wait(int s) {
    try {
      Thread.sleep(s * 500);
    }
    catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  public void setName(String name){
    _name = name;
  }

  public int getDefenseMultiplier(){
    return 7;
  }

  public int getHP(){
    return _hp;
  }

  public int getAttack(){
    return _attack;
  }

  public int getDefense(){
    return _defense;
  }

  public int getMana(){
    return _mana;
  }

  public boolean isAlive(){
    if (_hp <= 0){
      return false;
    }else {
      return true;
    }
  }

  public void lvlUp(){
    if((_exp % 100 == 0) && (_exp >= 100)){
      wait(1);
      System.out.println("Congrats! You leveled up! You are now level " + (_exp / 100) + "!");
      wait(1);
      _lvl = _exp / 100;
      _hp = getHPMultiplier() *_lvl;
      _attack += 7;
      _defense = getDefenseMultiplier()* _lvl;
      _mana += 10;
    }
  }

  public int getHPMultiplier() {
    return 7;
  }

  public void displayt(){
    System.out.println(_name + " / Stats:");
    System.out.println("HP: " + _hp);
    System.out.println("Attack: " + _attack);
    System.out.println("Defense:" + _defense);
    System.out.println("Mana: " + _mana);
  }

  public void displayMove() {
    System.out.println("Your available moves are: Water Gun, Rain Dance, and Rest.");
    wait(1);
    System.out.println("Water Gun squirts water to attack.");
    System.out.println("Rain Dance summons rain to increase defense.");
    System.out.println("Rest makes the user take a nap to restore mana.");
  }


  // WATER
  public void move(String moveName, Pokemon name){
    if(moveName.equals("Water Gun") || moveName.equals("water gun")){
      if(_mana < 25){
        wait(1);
        System.out.println(getName() + " cannot use " + moveName + " because you do not have enough mana.");
        wait(1);
      }
      else{
        _mana = getMana() - 25;
        if (name._defense >= getAttack()){
          name._defense = (name._defense - (getAttack()));
        } else if (name._defense < getAttack() && name._defense > 0){
          int old = name._defense;
          name._defense = 0;
          if ((getAttack() - old) > name._hp){
            name._hp = 0;
          } else {
            name._hp = (name._hp - (getAttack() - old));
          }
        } else if (name._defense == 0){
          if (name._hp > getAttack()){
            name._hp = (name._hp - (getAttack()));
          } else {
            name._hp = 0;
          }
        }
        wait(1);
        System.out.println(getName() + " has casted Water Gun!");
        wait(1);
        System.out.println("The foe is blasted with a forceful shot of water.");
        wait(1);
        if(name.isAlive() == false){
          System.out.println(getName() + " has defeated their opponent!");
        }
        System.out.println();
        displayt();
        System.out.println();
        name.displayt();
        System.out.println();
    }
  }
    // Rain Dance
    if(moveName.equals("Rain Dance") || moveName.equals("rain dance")){
      if(_mana < 20){
        wait(1);
        System.out.println(getName() + " cannot use " + moveName + " because you do not have enough mana.");
        wait(1);
      }
      else{
        _mana = getMana() - 20;
        _defense += 10;
        wait(1);
        System.out.println("Rain starts to fall.");
        wait(1);
        System.out.println("Defense increased by 10!");
        wait(1);
        System.out.println();
        displayt();
        System.out.println();
        name.displayt();
        System.out.println();
      }
    }
    // Rest
    if(moveName.equals("Rest") || moveName.equals("rest")){
      _mana += 20;
      wait(1);
      System.out.println(getName() + " takes a nap.");
      wait(1);
      System.out.println("Mana increased by 20!");
      wait(1);

      System.out.println();
      displayt();
      System.out.println();
      name.displayt();
      System.out.println();
    }
  wait(1);
  System.out.println("Do you want to use a Berry on " + _name + "? (yes/no)");
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
        _hp += 20;
        // probably overrides
        //wait(1);
        System.out.println(_name + "'s HP has been restored by 20!");
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

    public void moveOther(String moveName, Pokemon name){
      if(moveName.equals("Water Gun") || moveName.equals("water gun")){
        if(_mana < 25){
          wait(1);
          System.out.println(getName() + " cannot use " + moveName + " because you do not have enough mana.");
          wait(1);
        }
        else{
          _mana = getMana() - 25;
          if (name._defense >= getAttack()){
            name._defense = (name._defense - (getAttack()));
          } else if (name._defense < getAttack() && name._defense > 0){
            int old = name._defense;
            name._defense = 0;
            if ((getAttack() - old) > name._hp){
              name._hp = 0;
            } else {
              name._hp = (name._hp - (getAttack() - old));
            }
          } else if (name._defense == 0){
            if (name._hp > getAttack()){
              name._hp = (name._hp - (getAttack()));
            } else {
              name._hp = 0;
            }
          }
          wait(1);
          System.out.println(getName() + " has casted Water Gun!");
          wait(1);
          System.out.println("The foe is blasted with a forceful shot of water.");
          wait(1);
          if(name.isAlive() == false){
            wait(1);
            System.out.println(getName() + " has defeated their opponent!");
            System.out.println();
            wait(1);
          }
          System.out.println();
          displayt();
          System.out.println();
          name.displayt();
          System.out.println();

      }
    }
      // Rain Dance
      if(moveName.equals("Rain Dance") || moveName.equals("rain dance")){
        if(_mana < 20){
          wait(1);
          System.out.println(getName() + " cannot use " + moveName + " because you do not have enough mana.");
          System.out.println();
          wait(1);
        }
        else{
          _mana = getMana() - 20;
          _defense += 10;
          wait(1);
          System.out.println("Rain starts to fall.");
          wait(1);
          System.out.println("Defense increased by 10!");
          wait(1);
          System.out.println();
          displayt();
          System.out.println();
          name.displayt();
          System.out.println();
        }
      }
      // Rest
      if(moveName.equals("Rest") || moveName.equals("rest")){
        _mana += 20;
        wait(1);
        System.out.println(getName() + " takes a nap.");
        wait(1);
        System.out.println("Mana increased by 20!");
        wait(1);

        System.out.println();
        displayt();
        System.out.println();
        name.displayt();
        System.out.println();
      }

      }
}

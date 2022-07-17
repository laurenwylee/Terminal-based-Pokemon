import java.util.*;
import java.util.Scanner;

public class Water extends Pokemon implements Types {

static Scanner in = new Scanner(System.in);
  public Water(String name, int lvl, int exp) {
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

  public void setName(String name) {
    _name = name;
  }

  public int getDefenseMultiplier() {
    return 7;
  }

  public int getHP() {
    return _hp;
  }

  public int getAttack() {
    return _attack;
  }

  public int getDefense() {
    return _defense;
  }

  public int getMana() {
    return _mana;
  }

  public boolean isAlive() {
    if (_hp <= 0){
      return false;
    }
    else {
      return true;
    }
  }

  public void lvlUp() {
    if((_exp - (_lvl*100)) == 100) {
      wait(1);
      System.out.println();
      System.out.print("\u001b[38;2;180;180;180m");
      System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mhas leveled up! \u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mis now level \u001b[38;2;246;209;8m" + (_exp / 100) + "\u001b[38;2;180;180;180m!");
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

  public void displayt() {
    wait(1);
    System.out.print("\u001b[38;2;204;255;255m");
    System.out.println(_name + " / Stats:");
    System.out.println("HP: " + _hp);
    System.out.println("Attack: " + _attack);
    System.out.println("Defense:" + _defense);
    System.out.println("PP: " + _mana);
  }

  public void displayMove() {
    wait(1);
    System.out.print("\u001b[38;2;180;180;180m");
    System.out.println("Your available moves are: \u001b[38;2;103;179;201mWater Gun\u001b[38;2;180;180;180m, \u001b[38;2;103;179;201mRain Dance\u001b[38;2;180;180;180m, and \u001b[38;2;103;179;201mRest\u001b[38;2;180;180;180m.");
    wait(1);
    System.out.println("\u001b[38;2;103;179;201mWater Gun \u001b[38;2;180;180;180msquirts water to attack.");
    wait(1);
    System.out.println("\u001b[38;2;103;179;201mRain Dance \u001b[38;2;180;180;180msummons rain to increase defense.");
    wait(1);
    System.out.println("\u001b[38;2;103;179;201mRest \u001b[38;2;180;180;180mmakes the user take a nap to restore PP.");
  }


  // WATER
  public void move(String moveName, Pokemon name) {
    if (moveName.equals("Water Gun") || moveName.equals("water gun")) {
      if (_mana < 25) {
        wait(1);
        System.out.print("\u001b[38;2;180;180;180m");
        System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mcannot use \u001b[38;2;103;179;201m" + moveName + "\u001b[38;2;180;180;180m because \u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mdoes not have enough PP.");
        wait(1);
      }
      else {
        _mana = getMana() - 25;
        if (name instanceof Water) {
          if (name._defense >= getAttack()) {
            name._defense = (name._defense - (getAttack()));
          } else if (name._defense < getAttack() && name._defense > 0) {
            int old = name._defense;
            name._defense = 0;
            if ((getAttack() - old) > name._hp) {
              name._hp = 0;
            } else {
              name._hp = (name._hp - (getAttack() - old));
            }
          } else if (name._defense == 0) {
            if (name._hp > getAttack()){
              name._hp = (name._hp - (getAttack()));
            } else {
              name._hp = 0;
            }
          }
        } else if (name instanceof Fire) {
          double newAttack = getAttack()*1.3;
          if (name._defense >= newAttack) {
            name._defense = (int)(name._defense - (newAttack));
          } else if (name._defense < newAttack && name._defense > 0) {
            int old = name._defense;
            name._defense = 0;
            if ((newAttack - old) > name._hp) {
              name._hp = 0;
            } else {
              name._hp = (int) (name._hp - (newAttack - old));
            }
          } else if (name._defense == 0) {
            if (name._hp > newAttack){
              name._hp = (int) (name._hp - (newAttack));
            } else {
              name._hp = 0;
            }
          }
        } else if (name instanceof Grass) {
          double newAttack = getAttack()*0.7;
          if (name._defense >= newAttack){
            name._defense = (int)(name._defense - (newAttack));
          } else if (name._defense < newAttack && name._defense > 0) {
            int old = name._defense;
            name._defense = 0;
            if ((newAttack - old) > name._hp) {
              name._hp = 0;
            } else {
              name._hp = (int) (name._hp - (newAttack - old));
            }
          } else if (name._defense == 0) {
            if (name._hp > newAttack){
              name._hp = (int) (name._hp - (newAttack));
            } else {
              name._hp = 0;
            }
          }
        }
        wait(1);
        System.out.print("\u001b[38;2;180;180;180m");
        System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mhas casted Water Gun!");
        wait(1);
        System.out.println("The foe is blasted with a forceful shot of water.");
        wait(1);
        if(name.isAlive() == false) {
          System.out.print("\u001b[38;2;180;180;180m");
          System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mhas defeated their opponent!");
        }
        wait(1);
        System.out.print("\u001b[38;2;64;64;64m");
        System.out.println("\n~~~~~~~~~~~~~~~~~");
        displayt();
        System.out.println();
        name.displayt();
        wait(1);
        System.out.print("\u001b[38;2;64;64;64m");
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println();
      }
    }
    // Rain Dance
    if (moveName.equals("Rain Dance") || moveName.equals("rain dance")) {
      if (_mana < 20) {
        wait(1);
        System.out.print("\u001b[38;2;180;180;180m");
        System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mcannot use \u001b[38;2;103;179;201m" + moveName + "\u001b[38;2;180;180;180m because \u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mdoes not have enough PP.");
        wait(1);
      }
      else {
        _mana = getMana() - 20;
        _defense += 10;
        wait(1);
        System.out.print("\u001b[38;2;180;180;180m");
        System.out.println("Rain starts to fall.");
        wait(1);
        System.out.println("Defense increased by 10!");
        wait(1);
        System.out.print("\u001b[38;2;64;64;64m");
        System.out.println("\n~~~~~~~~~~~~~~~~~");
        displayt();
        System.out.println();
        name.displayt();
        wait(1);
        System.out.print("\u001b[38;2;64;64;64m");
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println();
      }
    }
    // Rest
    if(moveName.equals("Rest") || moveName.equals("rest")) {
      _mana += 20;
      wait(1);
      System.out.print("\u001b[38;2;180;180;180m");
      System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mtakes a nap.");
      wait(1);
      System.out.println("PP increased by 20!");
      wait(1);
      System.out.print("\u001b[38;2;64;64;64m");
      System.out.println("\n~~~~~~~~~~~~~~~~~");
      displayt();
      System.out.println();
      name.displayt();
      wait(1);
      System.out.print("\u001b[38;2;64;64;64m");
      System.out.println("~~~~~~~~~~~~~~~~~");
      System.out.println();
    }
    wait(1);
    System.out.print("\u001b[38;2;180;180;180m");
    System.out.println("Do you want to use a Berry on \u001b[38;2;103;179;201m" + _name + "\u001b[38;2;180;180;180m? (yes/no)");
    String berry = "";
    wait(1);
    System.out.print("\u001b[38;2;255;255;255m");
    System.out.print("> ");
    berry = in.nextLine().toLowerCase();
      if (berry.equals("yes")) {
        if (Player._numBerries <= 0) {
          wait(1);
          System.out.println();
          System.out.print("\u001b[38;2;180;180;180m");
          System.out.println("You cannot use a Berry.");
          wait(1);
          System.out.println("You have no Berries left!");
        }
        else {
          Player._numBerries -= 1;
          _hp += 20;
          // probably overrides
          wait(1);
          System.out.println();
          System.out.print("\u001b[38;2;180;180;180m");
          System.out.println("\u001b[38;2;103;179;201m" + _name + "'s \u001b[38;2;180;180;180mHP has been restored by 20!");
          wait(1);
          System.out.println("Here is your Inventory:");
          wait(1);
          Player.displayInventory();
        }
      }
      else if (berry.equals("no")) {
        wait(1);
        System.out.println();
        System.out.print("\u001b[38;2;180;180;180m");
        System.out.println("You choose to not use a Berry.");
      }
      else {
        wait(1);
        System.out.println();
        System.out.print("\u001b[38;2;180;180;180m");
        System.out.println("That is not a valid response. You do not use a Berry.");
      }
    }

    public void moveOther(String moveName, Pokemon name) {
      if (moveName.equals("Water Gun") || moveName.equals("water gun")) {
        if (_mana < 25){
          wait(1);
          System.out.print("\u001b[38;2;180;180;180m");
          System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mcannot use \u001b[38;2;103;179;201m" + moveName + "\u001b[38;2;180;180;180m because \u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mdoes not have enough PP.");
          wait(1);
        }
        else {
          _mana = getMana() - 25;
          if (name instanceof Water) {
            if (name._defense >= getAttack()) {
              name._defense = (name._defense - (getAttack()));
            } else if (name._defense < getAttack() && name._defense > 0) {
              int old = name._defense;
              name._defense = 0;
              if ((getAttack() - old) > name._hp) {
                name._hp = 0;
              } else {
                name._hp = (name._hp - (getAttack() - old));
              }
            } else if (name._defense == 0) {
              if (name._hp > getAttack()) {
                name._hp = (name._hp - (getAttack()));
              } else {
                name._hp = 0;
              }
            }
          } else if(name instanceof Fire) {
            double newAttack = getAttack()*1.5;
            if (name._defense >= newAttack) {
              name._defense = (int)(name._defense - (newAttack));
            } else if (name._defense < newAttack && name._defense > 0) {
              int old = name._defense;
              name._defense = 0;
              if ((newAttack - old) > name._hp) {
                name._hp = 0;
              } else {
                name._hp = (int) (name._hp - (newAttack - old));
              }
            } else if (name._defense == 0) {
              if (name._hp > newAttack) {
                name._hp = (int) (name._hp - (newAttack));
              } else {
                name._hp = 0;
              }
            }
          } else if (name instanceof Grass) {
            double newAttack = getAttack()*0.7;
            if (name._defense >= newAttack) {
              name._defense = (int)(name._defense - (newAttack));
            } else if (name._defense < newAttack && name._defense > 0) {
              int old = name._defense;
              name._defense = 0;
              if ((newAttack - old) > name._hp) {
                name._hp = 0;
              } else {
                name._hp = (int) (name._hp - (newAttack - old));
              }
            } else if (name._defense == 0) {
              if (name._hp > newAttack) {
                name._hp = (int) (name._hp - (newAttack));
              } else {
                name._hp = 0;
              }
            }
          }
          wait(1);
          System.out.print("\u001b[38;2;180;180;180m");
          System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mhas casted Water Gun!");
          wait(1);
          System.out.println("The foe is blasted with a forceful shot of water.");
          wait(1);
          if (name.isAlive() == false) {
            System.out.print("\u001b[38;2;180;180;180m");
            System.out.println("\n\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mhas defeated their opponent!");
          }
          wait(1);
          System.out.print("\u001b[38;2;64;64;64m");
          System.out.println("\n~~~~~~~~~~~~~~~~~");
          displayt();
          System.out.println();
          name.displayt();
          wait(1);
          System.out.print("\u001b[38;2;64;64;64m");
          System.out.println("~~~~~~~~~~~~~~~~~");
          System.out.println();
        }
      }
      // Rain Dance
      if (moveName.equals("Rain Dance") || moveName.equals("rain dance")) {
        if (_mana < 20){
          wait(1);
          System.out.print("\u001b[38;2;180;180;180m");
          System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mcannot use \u001b[38;2;103;179;201m" + moveName + "\u001b[38;2;180;180;180m because \u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mdoes not have enough PP.");
          System.out.println();
          wait(1);
        }
        else {
          _mana = getMana() - 20;
          _defense += 10;
          wait(1);
          System.out.print("\u001b[38;2;180;180;180m");
          System.out.println("Rain starts to fall.");
          wait(1);
          System.out.println("Defense increased by 10!");
          wait(1);
          System.out.print("\u001b[38;2;64;64;64m");
          System.out.println("\n~~~~~~~~~~~~~~~~~");
          displayt();
          System.out.println();
          name.displayt();
          wait(1);
          System.out.print("\u001b[38;2;64;64;64m");
          System.out.println("~~~~~~~~~~~~~~~~~");
          System.out.println();
        }
      }
      // Rest
      if(moveName.equals("Rest") || moveName.equals("rest")) {
        _mana += 20;
        wait(1);
        System.out.print("\u001b[38;2;180;180;180m");
        System.out.println("\u001b[38;2;103;179;201m" + getName() + " \u001b[38;2;180;180;180mtakes a nap.");
        wait(1);
        System.out.println("PP increased by 20!");
        wait(1);
        System.out.print("\u001b[38;2;64;64;64m");
        System.out.println("\n~~~~~~~~~~~~~~~~~");
        displayt();
        System.out.println();
        name.displayt();
        wait(1);
        System.out.print("\u001b[38;2;64;64;64m");
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println();
      }
    }
}

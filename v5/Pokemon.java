import java.util.*;

public class Pokemon {
    String _name;
    int _lvl;
    int _exp;
    int _hp;
    int _attack;
    int _defense;
    int _mana;


    public Pokemon(){
      _lvl = 0;
      _exp = 0;
      _name = "snorlax";
    }

    public Pokemon(int level, int experience){
      _lvl = level;
      _exp = experience;
    }
    public void setName(String name){
      _name = name;
    }
    public String getName(){
      return _name;
    }

    public int getHP(){
      return 0;
    }

    public int getAttack(){
      return 0;
    }

    public int getDefense(){
      return 0;
    }

    public int getMana(){
      return 0;
    }

    public int getLvl(){
      return _lvl;
    }

    public int getExp(){
      return _exp;
    }
    public void displayt(){
      System.out.println(_name + " / Stats:");
      System.out.println("HP: " + _hp);
      System.out.println("Attack: " + _attack);
      System.out.println("Defense:" + _defense);
      System.out.println("Mana: " + _mana);
    }

    public void lvlUp(){
      System.out.println();
    }

    public void increaseExp(){
      _exp += 20;
      System.out.println("Your EXP has increased by 20!");
    }

    public boolean isAlive(){
      return false;
    }

    public int getHPMultiplier() {
      return 1;
    }

    public void display(){
      System.out.println();
    }

    public void displayMove() {
      System.out.println();
    }

    public void move(String moveName, Pokemon name){
      System.out.println();
    }

    public boolean runaway(Pokemon opponent){
        if (opponent.getLvl() <= 10){
          return Math.random() * 10 > opponent.getLvl();
        }
        if (opponent.getLvl() <= 100){
          return Math.random() * 100 > opponent.getLvl();
        }
        else{
          return Math.random() * 1000 > opponent.getLvl();
        }
    }
}

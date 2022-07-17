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
    }

    public Pokemon(int level, int experience){
      _lvl = level;
      _exp = experience;
    }

    public int getLvl(){
      return _lvl;
    }

    public int getExp(){
      return _exp;
    }

    public void lvlUp(){
      if((_exp % 100 == 0) && (_exp >= 100)){
        System.out.println("Congrats! You leveled up! You are now level " + (_exp / 100) + "!");
        _lvl = _exp / 100;
      }
    }

    public void increaseExp(){
      _exp += 20;
      System.out.println("Your EXP has increased by 20!");
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

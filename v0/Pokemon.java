public class Pokemon {
    int _lvl;
    int _exp;

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

    public boolean runaway(Pokemon opponent){
        if (opponent.getLvl() <= 10){
          return Math.Random() * 10 > opponent.getLvl();
        }
        if (opponent.getLvl() <= 100){
          return Math.Random() * 100 > opponent.getLvl();
        }
        if (opponent.getLvl() <= 1000){
          return Math.Random() * 1000 > opponent.getLvl();
        }
    }
}

import java.util.*;

public class Pokemon {
    String _name;
    int _lvl;
    int _exp;
    int _hp;
    int _attack;
    int _defense;
    int _mana;

    public Pokemon() {
      _lvl = 0;
      _exp = 0;
      _name = "snorlax";
    }

    public Pokemon(int level, int experience){
      _lvl = level;
      _exp = experience;
    }

    public static void wait(int s) {
      try {
        Thread.sleep(s * 500);
      }
      catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }

    public String toString(){
      if (_name.equals("Turtwig")) {
        wait(1);
        return ("\n\u001b[38;2;119;221;118mA Grass Type: \n\u001b[38;2;166;236;168mTurtwig, the Tiny Leaf Pokemon. \n\u001b[38;2;210;253;187mIts shell is made of earth and when it absorbs water, it becomes harder.");
      }
      else if (_name.equals("Piplup")) {
        wait(1);
        return ("\n\u001b[38;2;34;130;164mA Water Type: \n\u001b[38;2;103;179;201mPiplup, the Penguin Pokemon. \n\u001b[38;2;172;229;238mPiplup's limited walking skills often cause it to fall down, but that never hurts its pride.");
      }
      else if (_name.equals("Chimchar")) {
        wait(1);
        return ("\n\u001b[38;2;243;113;66mA Fire Type: \n\u001b[38;2;255;160;1mChimchar, the Monkey Pokemon. \n\u001b[38;2;255;184;79mChimchar easily climbs the sheerest of walls and lives on mountain tops. \n\u001b[38;2;251;207;137mWhen it sleeps, its flames go out.");
      }
      else if (_name.equals("Vulpix")) {
        wait(1);
        return("\n\u001b[38;2;243;113;66mA Fire Type: \n\u001b[38;2;255;160;1mVulpix, a Fox Pokemon. \n\u001b[38;2;255;184;79mIts six tails are extremely beautiful. \n\u001b[38;2;251;207;161mVulpix uses powerful flame attacks.");
      }
      else if(_name.equals("Slugma")) {
        wait(1);
        return ("\n\u001b[38;2;243;113;66mA Fire Type: \n\u001b[38;2;255;160;1mSlugma, the Lava Pokemon. \n\u001b[38;2;255;184;79mSlugma have intensely hot magma, which circulates throughout their bodies, carrying nutrients and oxygen to their organs.");
      }
      else if(_name.equals("Numel")) {
        wait(1);
        return ("\n\u001b[38;2;243;113;66mA Fire Type: \n\u001b[38;2;255;160;1mNumel, the Numb Pokemon. \n\u001b[38;2;255;184;79mNumel is so complacent that it does not even notice when it is stuck. \n\u001b[38;2;251;207;161mThis Pokemon's body is filled with hot magma, which, when cooled in water, further slows its movement. \n\u001b[38;2;251;224;169mNumel is also unable to bear hunger.");
      }
      else if(_name.equals("Charmander")) {
        wait(1);
        return ("\n\u001b[38;2;243;113;66mA Fire Type: \n\u001b[38;2;255;160;1mCharmander. \n\u001b[38;2;255;184;79mA flame burns on the tip of its tail from birth. \n\u001b[38;2;251;207;161mIt is said that a Charmander dies if its flame ever goes out.");
      }
      else if(_name.equals("Cyndaquil")) {
        wait(1);
        return ("\n\u001b[38;2;243;113;66mA Fire Type: \n\u001b[38;2;255;160;1mCyndaquil, the Fire Mouse Pokemon. \n\u001b[38;2;255;184;79mNormally mild and even-tempered, Cyndaquil will shoot a scorching flame out of its back when upset.");
      }
      else if(_name.equals("Torchic")) {
        wait(1);
        return ("\n\u001b[38;2;243;113;66mA Fire Type: \n\u001b[38;2;255;160;1mA fire burns inside, so it feels very warm to hug. \n\u001b[38;2;255;184;79mIt launches fireballs of 1,800 degrees F.");
      }
      else if(_name.equals("Feebas")) {
        wait(1);
        return ("\n\u001b[38;2;34;130;164mA Water Type: \n\u001b[38;2;103;179;201mFeebas, the Fish Pokemon. \n\u001b[38;2;172;229;238mAlthough extremely ragged, it is a tough Pokemon that can live in almost any kind of water.");
      }
      else if(_name.equals("Wooper")) {
        wait(1);
        return ("\n\u001b[38;2;34;130;164mA Water Type: \n\u001b[38;2;103;179;201mWooper, the Water Fish Pokemon. \n\u001b[38;2;172;229;238mThough they prefer to live in cold water, these appealing Pokemon forage for food on land. \n\u001b[38;2;216;251;255mThey are kept warm by a layer of insulating body fluid.");
      }
      else if(_name.equals("Lotad")) {
        wait(1);
        return ("\n\u001b[38;2;34;130;164mA Water Type: \n\u001b[38;2;103;179;201mLotad, the Water Weed Pokemon. \n\u001b[38;2;172;229;238mLotad inhabit peaceful wetlands, like lakes and ponds.");
      }
      else if(_name.equals("Marill")) {
        wait(1);
        return ("\n\u001b[38;2;34;130;164mA Water Type: \n\u001b[38;2;103;179;201mMarill, the Water Mouse Pokemon. \n\u001b[38;2;172;229;238mIts sensitive ears can detect distant sounds and the round rubbery tip on its tail can expand and contract, assisting Marill in the water. ");
      }
      else if(_name.equals("Wingull")) {
        wait(1);
        return ("\n\u001b[38;2;34;130;164mA Water Type: \n\u001b[38;2;103;179;201mWingull, the Seagull Pokemon. \n\u001b[38;2;172;229;238mIt uses its long wings to catch the ocean wind and glide across the sky, and then folds them when resting.");
      }
      else if(_name.equals("Poliwag")) {
        wait(1);
        return ("\n\u001b[38;2;34;130;164mA Water Type: \n\u001b[38;2;103;179;201mPoliwag, the Tadpole Pokemon. \n\u001b[38;2;172;229;238mIt has no arms, but its tail makes it a strong swimmer.");
      }
      else if(_name.equals("Cherubi")) {
        wait(1);
        return ("\n\u001b[38;2;119;221;118mA Grass Type: \n\u001b[38;2;166;236;168mCherubi, the Cherry Pokemon. \n\u001b[38;2;210;253;187mCherubi's attached small ball holds nutrients.");
      }
      else if(_name.equals("Seedot")) {
        wait(1);
        return ("\n\u001b[38;2;119;221;118mA Grass Type: \n\u001b[38;2;166;236;168mSeedot, the Acorn Pokemon. \n\u001b[38;2;210;253;187mSeedot resembles an acorn when hanging by its head from branches. \n\u001b[38;2;227;255;212mIt jumps down suddenly to the surprise of passersby.");
      }
      else if(_name.equals("Bulbasaur")) {
        wait(1);
        return ("\n\u001b[38;2;119;221;118mA Grass Type: \n\u001b[38;2;166;236;168mBulbasaur, the seed Pokemon. \n\u001b[38;2;210;253;187mIt bears the seed of a plant on its back from birth. \nThe seed slowly develops. \n\u001b[38;2;227;255;212mResearchers are unsure whether to classify Bulbasaur as a plant or animal. \n\u001b[38;2;241;255;233mBulbasaur are extremely tough and very difficult to capture in the wild.");
      }
      else if(_name.equals("Chikorita")) {
        wait(1);
        return ("\n\u001b[38;2;119;221;118mA Grass Type: \n\u001b[38;2;166;236;168mChikorita, the Leaf Pokemon. \n\u001b[38;2;210;253;187mChikorita uses the leaf on its head to scan for warmth and humidity in its surroundings, and loves to sunbathe.");
      }
      else if(_name.equals("Treecko")) {
        wait(1);
        return ("\n\u001b[38;2;119;221;118mA Grass Type: \n\u001b[38;2;166;236;168mTreecko, the Wood Gecko Pokemon. \n\u001b[38;2;210;253;187mNumerous tiny spikes cover the bottoms of Treecko's feet, allowing it to walk on ceilings and walls.");
      }
      else if(_name.equals("Bellsprout")) {
        wait(1);
        return ("\n\u001b[38;2;119;221;118mA Grass Type: \n\u001b[38;2;166;236;168mBellsprout, the Flower Pokemon. \n\u001b[38;2;210;253;187mBellsprout loves high temperatures and humidity. \n\u001b[38;2;227;255;212mIt can be lightning fast when it extends its vines in order to grab something.");
      }
      else {
        return ("Mistake D:");
      }
    }

    public int getManaMultiplier(){
      return 10;
    }
    public int getDefenseMultiplier() {
      return 0;
    }
    public void setName(String name) {
      _name = name;
    }
    public String getName() {
      return _name;
    }

    public int getHP() {
      return 0;
    }

    public int getAttack() {
      return 0;
    }

    public int getDefense() {
      return 0;
    }

    public int getMana() {
      return 0;
    }

    public int getLvl() {
      return _lvl;
    }

    public int getExp() {
      return _exp;
    }

    public void displayt() {
      wait(1);
      System.out.println(_name + " / Stats:");
      System.out.println("HP: " + _hp);
      System.out.println("Attack: " + _attack);
      System.out.println("Defense:" + _defense);
      System.out.println("PP: " + _mana);
    }

    public void lvlUp() {
      System.out.println();
    }


    public boolean isAlive() {
      return true;
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

    public void move(String moveName, Pokemon name) {
      System.out.println();
    }

    public void moveOther(String moveName, Pokemon name) {
      System.out.println();
    }

    public boolean runaway(Pokemon opponent) {
        if (opponent.getLvl() <= 10){
          return Math.random() * 10 > opponent.getLvl();
        }
        if (opponent.getLvl() <= 100){
          return Math.random() * 100 > opponent.getLvl();
        }
        else {
          return Math.random() * 1000 > opponent.getLvl();
        }
    }
}

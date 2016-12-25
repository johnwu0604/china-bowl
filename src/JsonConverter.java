import category.*;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JohnWu on 2016-12-18.
 */
public class JsonConverter {

    public static void main(String[] args) throws Exception {

        Soup soup = new Soup();

        Appetizer appetizer = new Appetizer();

        Rice rice = new Rice();
        FriedRice fried = new FriedRice();
        OnRice on = new OnRice();

        Noodle noodle = new Noodle();
        SoftNoodle softNoodle = new SoftNoodle();
        MixedNoodle mixedNoodle = new MixedNoodle();
        CrispyNoodle crispyNoodle = new CrispyNoodle();
        RiceNoodle riceNoodle = new RiceNoodle();

        Vegetable vegetable = new Vegetable();

        Pork pork = new Pork();

        Beef beef = new Beef();

        Chicken chicken = new Chicken();

        Egg egg = new Egg();

        Seafood seafood = new Seafood();

        Western western = new Western();

        Dinner dinner = new Dinner();

        Combo combo = new Combo();

        int id = 1;

        BufferedReader soupReader = new BufferedReader(new FileReader("resource/soup.txt"));
        List<Item> soups = getSoups( soupReader, id );
        id += soups.size();
        soup.setItems(soups);

        BufferedReader appetizerReader = new BufferedReader(new FileReader("resource/appetizer.txt"));
        List<Item> apps = getItems( appetizerReader, id);
        id += apps.size();
        appetizer.setItems(apps);

        BufferedReader friedRiceReader = new BufferedReader(new FileReader("resource/friedRice.txt"));
        List<Item> friedRice = getItems( friedRiceReader, id);
        id += friedRice.size();
        BufferedReader onRiceReader = new BufferedReader(new FileReader("resource/onRice.txt"));
        List<Item> onRice = getItems( onRiceReader, id);
        id += onRice.size();
        fried.setItems(friedRice);
        on.setItems(onRice);
        rice.setFriedRice(fried);
        rice.setOnRice(on);

        BufferedReader softNoodleReader = new BufferedReader(new FileReader("resource/softNoodle.txt"));
        BufferedReader mixedNoodleReader = new BufferedReader(new FileReader("resource/mixedNoodle.txt"));
        BufferedReader crispyNoodleReader = new BufferedReader(new FileReader("resource/crispyNoodle.txt"));
        BufferedReader riceNoodleReader = new BufferedReader(new FileReader("resource/riceNoodle.txt"));
        List<Item> soft = getItems( softNoodleReader, id );
        id += soft.size();
        List<Item> mixed = getItems( mixedNoodleReader, id );
        id += mixed.size();
        List<Item> crispy = getItems( crispyNoodleReader, id);
        id += crispy.size();
        List<Item> riceN = getItems( riceNoodleReader, id);
        id += riceN.size();
        softNoodle.setItems(soft);
        mixedNoodle.setItems(mixed);
        crispyNoodle.setItems(crispy);
        riceNoodle.setItems(riceN);
        noodle.setSoftNoodle(softNoodle);
        noodle.setMixedNoodle(mixedNoodle);
        noodle.setCrispyNoodle(crispyNoodle);
        noodle.setRiceNoodle(riceNoodle);

        BufferedReader vegReader = new BufferedReader(new FileReader("resource/vegetable.txt"));
        List<Item> vegItems = getItems(vegReader, id);
        id += vegItems.size();
        vegetable.setItems(vegItems);

        BufferedReader porkReader = new BufferedReader(new FileReader("resource/pork.txt"));
        List<Item> porkItems =  getItems(porkReader, id);
        id += porkItems.size();
        pork.setItems(porkItems);

        BufferedReader beefReader = new BufferedReader(new FileReader("resource/beef.txt"));
        List<Item> beefItems =  getItems(beefReader, id);
        id += beefItems.size();
        beef.setItems(beefItems);

        BufferedReader chickenReader = new BufferedReader(new FileReader("resource/chicken.txt"));
        List<Item> chickenItems =  getItems(chickenReader, id);
        id += chickenItems.size();
        chicken.setItems(chickenItems);

        BufferedReader eggReader = new BufferedReader(new FileReader("resource/egg.txt"));
        List<Item> eggItems =  getItems(eggReader, id);
        id += eggItems.size();
        egg.setItems(eggItems);

        BufferedReader seafoodReader = new BufferedReader(new FileReader("resource/seafood.txt"));
        List<Item> seafoodItems =  getItems(seafoodReader, id);
        id += seafoodItems.size();
        seafood.setItems(seafoodItems);

        BufferedReader westernReader = new BufferedReader(new FileReader("resource/western.txt"));
        List<Item> westernItems =  getItems(westernReader, id);
        id += westernItems.size();
        western.setItems(westernItems);

        BufferedReader dinnerReader = new BufferedReader(new FileReader("resource/dinner.txt"));
        List<Item> dinnerItems =  getCombos(dinnerReader, id);
        id += dinnerItems.size();
        dinner.setItems(dinnerItems);

        BufferedReader comboReader = new BufferedReader(new FileReader("resource/combo.txt"));
        List<Item> comboItems =  getCombos(comboReader, id);
        id += comboItems.size();
        combo.setItems(comboItems);


        Menu menu = new Menu();
        menu.setSoup(soup);
        menu.setAppetizer(appetizer);
        menu.setRice(rice);
        menu.setNoodle(noodle);
        menu.setVegetable(vegetable);
        menu.setPork(pork);
        menu.setBeef(beef);
        menu.setChicken(chicken);
        menu.setEgg(egg);
        menu.setSeafood(seafood);
        menu.setWestern(western);
        menu.setDinner(dinner);
        menu.setCombo(combo);

        Gson gson = new Gson();

        System.out.println(gson.toJson(menu));

    }

    public static List<Item> getItems( BufferedReader br, int id ) throws IOException {
        List<Item> items = new ArrayList<>();

        String currentLine = br.readLine();

        while (currentLine != null) {
            Item item = new Item();

            String name = null;
            String price = null;
            boolean spicy = false;

            int priceStart=0;
            for ( int i=0; i<currentLine.length(); i++) {
                if ( currentLine.charAt(i) == '.' && name == null ) {
                    name = currentLine.substring(0, i-1);
                }
                if ( currentLine.charAt(i) == '.' && currentLine.charAt(i+1) == ' ' ) {
                    priceStart = i+2;
                }
                if ( ( i+1) == currentLine.length()) {
                    price = currentLine.substring(priceStart, i+1);
                    spicy = false;
                    break;
                }
                if ( currentLine.charAt(i+1) == '*' ) {
                    price = currentLine.substring(priceStart, i+1);
                    spicy = true;
                    break;
                }
            }
            item.setId(id);
            item.setName(name);
            item.setPriceLarge(price);
            item.setSpicy(spicy);
            items.add(item);

            currentLine = br.readLine();
            id ++;
        }
        return items;
    }

    public static List<Item> getSoups(BufferedReader br, int id ) throws IOException {
        List<Item> items = new ArrayList<>();
        String currentLine = br.readLine();

        while (currentLine != null) {
            Item item = new Item();

            String name = null;
            String priceSmall = null;
            String priceLarge = null;
            boolean spicy = false;

            int priceStart=0;
            for ( int i=0; i<currentLine.length(); i++) {
                if ( ( i+1) == currentLine.length()) {
                    priceLarge = currentLine.substring(priceStart, i+1);
                    spicy = false;
                    break;
                }
                if ( currentLine.charAt(i+1) == '*' ) {
                    priceLarge = currentLine.substring(priceStart, i+1);
                    spicy = true;
                    break;
                }
                if ( currentLine.charAt(i) == '.' && name == null ) {
                    name = currentLine.substring(0, i-1);
                }
                if ( currentLine.charAt(i+1) == ' ' && priceStart >0 ) {
                    priceSmall = currentLine.substring(priceStart, i+1);
                    priceStart = i+2;
                }
                if (  currentLine.charAt(i) == '.' && currentLine.charAt(i+1) == ' ' ) {
                    priceStart = i+2;
                }
            }
            item.setId(id);
            item.setName(name);
            item.setPriceSmall(priceSmall);
            item.setPriceLarge(priceLarge);
            item.setSpicy(spicy);
            items.add(item);

            currentLine = br.readLine();
            id ++;
        }
        return items;
    }

    public static List<Item> getCombos( BufferedReader br, int id ) throws IOException {
        List<Item> items = new ArrayList<>();

        String currentLine = br.readLine();

        while (currentLine != null) {
            Item item = new Item();

            String name = null;
            String price = null;
            boolean spicy = false;

            int priceStart=0;
            for ( int i=0; i<currentLine.length(); i++) {
                if ( currentLine.charAt(i) == '.' && name == null ) {
                    name = currentLine.substring(0, i-1);
                }
                if ( currentLine.charAt(i) == '.' && currentLine.charAt(i+1) == ' ' ) {
                    priceStart = i+2;
                }
                if ( ( i+1) == currentLine.length()) {
                    price = currentLine.substring(priceStart, i+1);
                    spicy = false;
                    break;
                }
                if ( currentLine.charAt(i+1) == '*' ) {
                    price = currentLine.substring(priceStart, i+1);
                    spicy = true;
                    break;
                }
            }
            currentLine = br.readLine();

            item.setId(id);
            item.setName(name);
            item.setPriceLarge(price);
            item.setSpicy(spicy);
            item.setDescription(currentLine);
            items.add(item);

            currentLine = br.readLine();
            currentLine = br.readLine();

            id ++;
        }
        return items;
    }

}

package test;

import colas.JmsMessenger;
import lombok.SneakyThrows;
import lombok.experimental.var;
import model.Pokemon;

import java.util.ArrayList;

/**
 * Created by Local_admin on 6/30/2017.
 */
public class MainTest {

    @SneakyThrows
    public static void main(String[] args) {
        pokemonList();
    }

    static void pokemon() throws Exception{
        var jmsPokemon = new JmsMessenger<Pokemon>("colaPokemon");
        jmsPokemon.send(new Pokemon(0, "caca", null));
        System.out.println("ZzZ...");
        Thread.sleep(4000);
        Pokemon pokemon = jmsPokemon.recieve();
        System.out.println(pokemon);
        jmsPokemon.close();
    }

    static void pokemonList() throws Exception{
        var jmsPokemon = new JmsMessenger<ArrayList<Pokemon>>("colaPokemon");
        ArrayList<Pokemon> list = new ArrayList<>();
        list.add(new Pokemon(0, "caca", null));
        list.add(new Pokemon(-1, "pedo", null));
        jmsPokemon.send(list);
        System.out.println("ZzZ...");
        Thread.sleep(4000);
        ArrayList<Pokemon> pokemonList = jmsPokemon.recieve();
        System.out.println(pokemonList);
        jmsPokemon.close();
    }
}

package podstawy.kolekcje;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/*
 Mapa przyjmująca 2 typy generyczne.
 K określa typ klucza,
 V określa typ wartości przyjmowanej.
 */
public class GenericMap<K, V> implements Map<K, V> {

    //Klucze mapy powiązane z wartościami
    private ArrayList<K> keys;

    //Wartości mapy powiązane z kluczami
    private ArrayList<V> values;

    //Czyść mapę
    public void clear() {
        keys.clear();
        values.clear();
    }

    //Sprawdź, czy klucz 'key' istnieje w mapie
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    //Sprawdź, czy wartość 'value" istnieje w mapie
    public boolean containsValue(Object value) {
        return values.contains(values);
    }

    /*
    Przerób mapę na 'Set' - Set jest kolekcją przechowującą indiwidualne, nie
    powtarzające się elementy.
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        //sprawdź, czy ilość kluczy zgadza się z ilością wartości
        if (keys.size() != values.size())
            //jeśli nie, wyrzuć wyjątek
            throw new IllegalStateException("InternalError: nie można zsynchronizować " +
                    "kluczy z wartośćiami");
        /*
        w przeciwnym wypadku..
        Stwórz nowy Set, w moim wypadku obiekt klasy TreeSet
        Widzimy tutaj, że nasz TreeSet przechowuje obiekty typu
        Map.Entry<K, V>.
        Map.Entry - jest to obiekt przechowujący parę klucz-wartość, czyli to co
        przechowują mapy. <K, V> oznacza, że dana para jest typem K klucz + V wartość
        */
        Set set = new TreeSet<Map.Entry<K, V>>();
        /*
        Wrzuć wszystkie elementy mapy do TreeSetu.
        Dzięki temu zabiegowi, elementy mapy nie będę się powtarzać
        i otrzymamy kolecje indiwidualnych par klucz-wartość.
        */
        for (int i=0; i<size(); i++) {
            /*
            Nie zrażać się słowem Abstract. AbstractMap jest zwykłą klasą,
            która potrafi trochę więcej. SimpleEntry obiektem reprezentujący parę,
            którą można dodać do Setu.
            */
            set.add((new AbstractMap.SimpleEntry<K, V>(keys.get(i), values.get(i))));
        }
        //zwróć set
        return set;
    }

    //Pobierz wartość z mapy na podstawie klucza 'key'
    public V get(Object key) {
        int i = keys.indexOf(key);
        if (i == -1)
            return null;
        return values.get(i);
    }

    //sprawdź, czy mapa jest pusta
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    //Zwróc kolekcje indiwidualnych kluczy mapy
    public Set<K> keySet() {
        return new TreeSet<K>(keys);
    }

    //Dodaj parę key-value do mapy
    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        /**
        Pętla, w której sprawdzamy, czy dany klucz
        już nie wystąpił
        */
        for (int i=0; i<keys.size(); i++) {
            //przechowaj starą wartość klucza, jeśli istnieje
            V oldValue = values.get(i);

            //jeśli klucz istnieje w mapie to
            if(((Comparable<K>) key).compareTo(keys.get(i)) == 0) {
                //przypisz kluczowi nową wartość zachowując kolejność
                values.set(i, value);
                //i zwróć starą
                return oldValue;
            }
        }
        //w przeciwnym wypadku dodaj na koniec mapy parę
        keys.add(key);
        values.add(value);
        return null;
    }
    /*
     Dodaj mapę 'm' do aktualnej mapy.
     Ciekawostka, tutaj stosuje wzorzec Iterator. Iterator
     jest bytem, który przechodzi przez elementy kolekcji.
     Standardowy Itereator przechodzi po wszystkich elementach
     kolekcji. Ale to tak na marginesie.
     */
    public void putAll(Map<? extends K, ? extends V> m) {

        /*
        Stwórz na podstawie kluczy mapy 'm' iterator.
         */

        Iterator<? extends K> keyIterator = m.keySet().iterator();
        //wykonuj, dopóki iterator ma następną wartość
        while(keyIterator.hasNext()) {
            K key = keyIterator.next();
            V value = m.get(key);
            put(key, value);
        }
    }
    /*
    Usuń wartość klucza 'key' i zwróć
    ją, jeśli istnieje. W przeciwnym wypadku
    zwróć null'a.
     */
    public V remove(Object key) {
        int i = keys.indexOf(key);
        if ( i == -1 )
            return null;
        V value = values.get(i);
        keys.remove(i);
        values.remove(i);
        return value;
    }

    //Zwróć wielkość mapy
    public int size() {
        return keys.size();
    }

    //Zwróc kolekcje wartości
    public Collection<V> values() {
        return values;
    }

}


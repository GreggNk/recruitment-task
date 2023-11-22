package com.horus.task.recruitment;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    // Konstruktor klasy
    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        // Collection.stream pozwala m.in. na filtrowanie obiektów.
        // Obiekty za pomocą Arrow function są porównywane z wartością 'color' a
        // następnie zwracany jest dowolny z nich.
        return blocks.stream().filter(b -> b.getColor().equals(color)).findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        // Z filtrowania zwracana jest lista elementów, w których warunek jest spełniony
        // - zgadza się materiał.
        // Następnie zamieniany jest na listę.
        return blocks.stream().filter(b -> b.getMaterial().equals(material)).toList();
    }

    @Override
    public int count() {
        // Zwraca liczbę elementów listy blocks.
        return blocks.size();
    }
}
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class IslandCounterTest {

    @Test
    void testSingleIsland() {
        char[][] map = {
                {'~', '~', '~'},
                {'~', '#', '~'},
                {'~', '~', '~'}
        };
        // Тест если 1 осторов и нет соседей
        assertEquals(1, IslandCounter.CountIslands(map));
    }

    @Test
    void testNoIslands() {
        char[][] map = {
                {'~', '~', '~'},
                {'~', '~', '~'},
                {'~', '~', '~'}
        };
        // Тест если 0 островов
        assertEquals(0, IslandCounter.CountIslands(map));
    }

    @Test
    void testAllLand() {
        char[][] map = {
                {'#', '#', '#'},
                {'#', '#', '#'},
                {'#', '#', '#'}
        };
        // Если вся карта это остров
        assertEquals(1, IslandCounter.CountIslands(map));
    }

    @Test
    void testDiagonalIslands() {
        char[][] map = {
                {'#', '~', '#'},
                {'~', '#', '~'},
                {'#', '~', '#'}
        };
        // Острова по диагонали не соединены, значит должно быть 5 островов
        assertEquals(5, IslandCounter.CountIslands(map));
    }

    @Test
    void testEmptyMap() {
        char[][] map = new char[0][0];
        // Тест если карта пуста
        assertEquals(0, IslandCounter.CountIslands(map));
    }

    @Test
    void testOneCellIsland() {
        char[][] map = {{'#'}};
        // Тест если всего 1 остров  на карте
        assertEquals(1, IslandCounter.CountIslands(map));
    }

    @Test
    void testOneCellWater() {
        char[][] map = {{'~'}};
        // Тест если на карте только вода
        assertEquals(0, IslandCounter.CountIslands(map));
    }

}

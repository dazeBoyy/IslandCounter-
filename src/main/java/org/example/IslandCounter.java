package org.example;

import java.util.Stack;

public class IslandCounter {
    public static void main(String[] args) {

        String[] inputMap = {
                "#~#~#~#",
                "#~#~~~#",
                "###~#~#",
                "#~#~#~~",
                "#~#~#~#"
        };

        char[][] map = new char[inputMap.length][];
        for (int i = 0; i < inputMap.length; i++) {
            map[i] = inputMap[i].toCharArray();
        }
        System.out.println(CountIslands(map));

    }

    /**
     * Подсчитывает количество островов на карте.
     * @param map карта из символов
     * @return количество островов
     */
    public static int CountIslands(char[][] map) {

        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }

        int n = map.length;
        int m = map[0].length;

        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '#' && !visited[i][j]) {
                    dfs(map, visited, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    /**
     * Идем в глубь карты, помечая всех соседий, как просмотренных.
     * @param map карта из символов
     * @param visited карта с пометками о пройденных островах
     * @param i,j координаты нашего острова от которого мы будем искать соседей
     */
    private static void dfs(char[][] map, boolean[][] visited, int i, int j) {

        int n = map.length;
        int m = map[0].length;

        // Смещения по четырём направлениям: вверх, вниз, влево, вправо
        int[] di = {-1, 1, 0, 0}; // смотрим соседей сверху и снизу
        int[] dj = {0, 0, -1, 1};   // смотрим соседей слева и справа

        // Стек для хранения координат клеток острова при обходе в глубину
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        visited[i][j] = true;

        while (!stack.isEmpty()) {

            int[] cell = stack.pop();
            int ci = cell[0];
            int cj = cell[1];

            for (int k = 0; k < 4; k++) {
                int ni = ci + di[k];
                int nj = cj + dj[k];

                if (ni >= 0 &&  nj >= 0 && ni < n && nj < m && map[ni][nj] == '#' && !visited[ni][nj]) {
                    stack.push(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }


        }

    }
}

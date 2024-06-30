package com.example.customdatastructures;

import java.util.*;

public class InsertDeleteGetRandom {

    private Map<Integer, Integer> map;
    private List<Integer> list;

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    // O(1) time and O(n) space
    private boolean insert(int data) {
        if (map.containsKey(data)) {
            return false;
        }

        list.add(data);
        map.put(data, list.size() - 1);
        return true;
    }

    // O(1) time and O(n) space
    private boolean delete(int data) {
        if (!map.containsKey(data)) {
            return false;
        }

        int index = map.get(data);
        int lastValue = list.get(list.size() - 1);
        list.set(index, lastValue);
        map.put(lastValue, index);

        map.remove(data);
        list.remove(list.size() - 1);
        return true;
    }

    // O(1) time and O(n) space
    private int getRandomData() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static void main (String args[]){
        char[][] commands = {{'I', 'G', 'I', 'I', 'R', 'G'},
                {'I', 'I', 'R', 'G', 'R', 'I'}};
        int[][] values = {{10, -1, 100, 1000, 200, -1}, {30, 60, 10, -1, 30, 90}};

        for(int i=0;i<commands.length;i++)
        {
                InsertDeleteGetRandom dataset = new InsertDeleteGetRandom();
            System.out.println((i+1)+ ". Starting operations:");
            for(int j=0;j<commands[i].length;j++){
                if (commands[i][j] == 'I'){
                    System.out.println("\tInsert ("+ values[i][j]+ ") returns "+ dataset.insert(values[i][j]));
                }
                else if (commands[i][j] == 'R'){
                    System.out.println("\tDelete ("+ values[i][j]+ ") returns "+ dataset.delete(values[i][j]));
                }
                else if (commands[i][j] == 'G'){
                    System.out.println("\tGenerate Random() returns "+ dataset.getRandomData());
                }
                else {

                }
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

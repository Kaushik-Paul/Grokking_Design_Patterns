package com.example.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {

    private static List<String> wordBreak(String string, List<String> wordDict) {
        List<List<String>> result = new ArrayList<>(string.length() + 1);
        for (int i = 0; i <= string.length(); i++) {
            result.add(new ArrayList<>());
        }

        result.get(0).add("");

        for (int i = 1; i <= string.length(); i++) {
            String prefix = string.substring(0, i);
            List<String> temp = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                String suffix = prefix.substring(j);

                if (wordDict.contains(suffix)) {
                    for (String substring : result.get(j)) {
                        temp.add(substring + (substring.isEmpty() ? "" : " ") + suffix);
                    }
                }
            }

            result.set(i, temp);
        }

        return result.get(string.length());
    }

    public static void main(String[] args) {

        String[] s = {"vegancookbook", "catsanddog", "highwaycrash", "pineapplepenapple", "screamicecream", "educativecourse"};

        List<String> wordDict = Arrays.asList("oghi", "ncoo", "kboo", "inea",
                "icec", "ghway", "tsand", "anco", "eame", "ghigh", "hi", "way", "wa",
                "amic", "mi", "ed", "cecre", "pple", "reamicecreamed", "ena", "tsa", "ami", "hwaycrashpineapplepenapplescreamicecreamed", "lepen", "okca", "highway", "ples", "atsa", "oghig", "ookb", "epe", "ookca", "nea", "cra", "lepe", "vegancookbookcatsandd",
                "kc", "ra", "le", "ay", "crashpineapple", "ycras", "vegancookbookcatsanddoghighwaycrashpineapplepenapplescre", "doghi", "nddo", "hway", "vegancookbookcatsanddoghi", "vegancookbookcatsanddoghighwaycr", "at", "mice", "nc", "d", "enapplescreamicecreamed", "h",
                "ecrea", "nappl", "shp", "kbo", "yc", "vegancookbookcatsanddoghighwaycrashpineapplepenapplescream", "cat", "waycrashpineapplepenapplescreamicecreamed", "tsan", "vegancookbookcatsanddoghighwaycrashpineap", "ganco", "lescr", "sand", "applescreamicecreamed", "vegancookbookcatsanddoghig", "pi", "vegancookbookcatsanddoghighwaycrashpineapp", "cookb", "okcat", "neap", "nap", "oghighwaycrashpineapplepenapplescreamicecreamed", "crashpineapplepenapplescreamicecreamed",
                "ashpi", "ega", "escreamicecreamed", "hwa", "rash", "cre", "micecreamed", "plepe", "coo", "epen", "napp", "wayc", "vegancookbookcatsanddoghighwaycrashpinea", "vegancookbookcatsanddogh", "plep", "ice", "ple", "gh", "ghw", "cook", "pl", "app", "ic", "pinea", "hello", "dog", "vegancookbookcat", "eamed", "ook", "lesc", "ddog", "ca", "vegancookbookcatsanddoghighwaycrashpineapplepenapplescreamice", "c", "escr", "penap", "boo", "eami", "ecreamed", "vegancookbookcatsanddoghighwaycrashpi", "igh", "mic", "ganc", "vegancookbookcatsanddoghighwaycrashpineapplepenap",
                "eappl", "vegancookbookcatsanddoghighway", "ep", "penapple", "b", "ycrashpineapplepenapplescreamicecreamed", "pin", "book", "p", "sa", "okb", "andd", "ayc", "sh", "vegan", "cookbook");

        System.out.println(
                "The list of words we can use to break down the strings are:\n");
        System.out.println(wordDict + "\n");

        for (int i = 0; i < s.length; i++) {
            System.out.print((i + 1) + ".\tThe possible strings from the string: "
                    + s[i] + " are the following combinations:\n");
            System.out.println("\n\t" + wordBreak(s[i], wordDict));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}

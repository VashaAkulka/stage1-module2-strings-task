package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> arr = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < source.length(); i++) {
            if (delimiters.contains(Character.toString(source.charAt(i)))) {
                if (i == j) {
                    j++;
                    continue;
                }
                arr.add(source.substring(j, i));
                j = i + 1;
            }
        }
        if (j != source.length()) arr.add(source.substring(j));

        return arr;
    }
}

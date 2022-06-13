package com.liudaolunboluo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletionService;
import java.util.stream.Collectors;

/**
 * @author zhangyunfan@fiture.com
 * @version 1.0
 * @ClassName: TopKHighFrequencyWords
 * @date 2022/6/5
 */
public class TopKHighFrequencyWords {

    public static void main(String[] args) {
        TopKHighFrequencyWords t = new TopKHighFrequencyWords();
        System.out.println(t.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 1));
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        Map<String, Long> map = wordList.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        List<Long> indexList = new ArrayList<>();
        Map<Long, Set<String>> reverseMap = new LinkedHashMap<>();
        map.forEach((key, value) -> {
            indexList.add(value);
            if (reverseMap.get(value) == null) {
                Set<String> arrayList = new HashSet<>();
                arrayList.add(key);
                reverseMap.put(value, arrayList);
            } else {
                reverseMap.get(value).add(key);
            }
        });
        Collections.sort(indexList);
        Collections.reverse(indexList);
        List<Long> longs = indexList.subList(0, k);
        List<String> strings = new ArrayList<>();
        for (Long aLong : new HashSet<>(longs)) {
            List<String> list = new ArrayList<>(reverseMap.get(aLong));
            Collections.sort(list);
            Collections.reverse(list);
            strings.addAll(list);
        }
        Collections.reverse(strings);
        if (strings.size() > k) {
            strings = strings.subList(0, k);
        }
        return strings;
    }
}

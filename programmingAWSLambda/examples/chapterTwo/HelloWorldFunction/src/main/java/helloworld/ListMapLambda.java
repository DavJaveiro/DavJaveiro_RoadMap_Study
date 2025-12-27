package helloworld;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ListMapLambda implements RequestHandler<List<Integer>, List<Integer>>{
    @Override
    public List<Integer> handleRequest(List<Integer> input, Context context) {
        List<Integer> newList = new ArrayList<>();
        input.forEach(x -> newList.add(100 + x));
        return newList;
    }

    // public Map<String, String> handlerMap(Map<String, String> input) {
    //     Map<String, String> newMap = new HashMap<>();
    //     input.forEach((k, v) -> newMap.put("New Map -> " + k,v));
    //     return newMap;
    // }

    // public Map<String,Map<String, Integer>> handlerNestedCollection(List<Map<String, Integer>> input) {
    //     Map<String, Map<String, Integer>> newMap = new HashMap<>();
    //     IntStream.range(0, input.size())
    //             .forEach(i -> newMap.put("Map Index -> " + i, input.get(i)));
    //     return newMap;
    // }
}

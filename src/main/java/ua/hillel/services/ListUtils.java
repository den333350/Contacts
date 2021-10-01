package ua.hillel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class ListUtils {
    public static <T> void forEach(List<T> arr, Consumer<T> consumer){
        for (T elem : arr){
            consumer.accept(elem);
        }
    }
    public static <T> List<T> filter(List<T> arr, Predicate<T> predicate){
        List<T> result= new ArrayList<>();
        for (T elem : arr) {
            if (predicate.test(elem)) {
                result.add(elem);
            }
        }
        return result;
    }
    public static <T,R> R reduce(List<T> arr,R initValue, BiFunction<R,T,R>f){
        for (T elem : arr) {
            initValue = f.apply(initValue,elem);
        }
        return initValue;
    }
    public static <T> boolean anyMath(List<T> arr, Predicate<T> predicate){
        for (T elem : arr) {
            if (predicate.test(elem)) return true;
        }
        return false;
    }
    public static <T> boolean allMath(List<T> arr, Predicate<T> predicate){
        for (T elem : arr) {
            if(!predicate.test(elem)) return false;
        }
        return true;
    }
    public static <T> List<T> map(List<T> arr, Function<T, T> function){
        List<T> result= new ArrayList<>();
        for (T elem : arr) {
            result.add(function.apply(elem));
        }
        return result;
    }

}

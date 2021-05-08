package study.piepie.algorithm.cache;

/**
 * @author Robin
 * @date 2021-05-08 10:05
 **/
public interface Cache {
    int get(int key);
    void put(int key, int value);
}

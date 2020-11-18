package test;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreadTest {
    private static final int MAX_THREADS = 10;

    private static final Hashtable<String, Integer> ht = new Hashtable<>();
    private static final HashMap<String, Integer> hm = new HashMap<>();
    private static final HashMap<String, Integer> hmSyn = new HashMap<>();
    private static final Map<String, Integer> hmSyn2 = Collections.synchronizedMap(new HashMap<>());
    private static final ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>();

    @Test
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(MAX_THREADS);

        for(int j = 0 ; j < MAX_THREADS; j++){
            es.execute(() -> {
                for(int i = 0; i < 1000; i++){
                    String key = String.valueOf(i);

                    ht.put(key, i);
                    hm.put(key, i);
                    chm.put(key, i);
                    hmSyn2.put(key, i);

                    synchronized (hmSyn) {
                        hmSyn.put(key, i);
                    }
                }
            });
        }

        es.shutdown();
        try {
            es.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hashtable size is "+ ht.size());
        System.out.println("HashMap size is "+ hm.size());
        System.out.println("ConcurrentHashMap size is "+ chm.size());
        System.out.println("HashMap(synchronized) size is "+ hmSyn.size());
        System.out.println("synchronizedMap size is "+ hmSyn2.size());

        for(String s : hm.keySet()){
            System.out.println("["+s+"] " + hm.get(s));
        }
    }

    @Test
    public void test() {
        Map<String, Integer> map = new HashMap<>();
        map.put("key", 0);
        map.put("key", 1);

        assertThat(map.get("key")).isOne();
        assertThat(map.size()).isOne();
    }
}

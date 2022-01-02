package fortyrunner;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainApp {

    public static void main(final String... args ) {

        HazelcastInstance client = Utils.readHZClient();

        IMap<String, BinaryHolder> byteMap = client.getMap("bytemap");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            byteMap.put(Integer.toString(i), new BinaryHolder(1024 * 1024* 10));
        }
        long taken = System.currentTimeMillis() - start;

        BinaryHolder binaryHolder = byteMap.get("1");
        log.info("length = {}, taken = {}", binaryHolder.getBytes().length, taken);

    }

}

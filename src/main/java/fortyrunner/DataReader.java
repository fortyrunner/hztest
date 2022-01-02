package fortyrunner;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataReader {

    public static void main(String[] args) {
        HazelcastInstance client = Utils.readHZClient();

        long start = System.currentTimeMillis();
        long len = 0L;
        IMap<String, BinaryHolder> byteMap = client.getMap("bytemap");
        for (int i = 0; i < 100; i++) {
            BinaryHolder holder = byteMap.get(Integer.toString(i));
            len += holder.getBytes().length;
        }

        long taken = System.currentTimeMillis() - start;

        log.info("Total map size {}, taken {}", len, taken);

        client.shutdown();

    }

}

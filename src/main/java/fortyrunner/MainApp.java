package fortyrunner;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainApp {

    public static void main(final String... args ) {

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("dev");
//        clientConfig.getNetworkConfig().addAddress("10.90.0.1", "10.90.0.2:5702");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

        IMap<String, Customer> mapCustomers = client.getMap("customers"); //creates the map proxy

        mapCustomers.put("1", new Customer("Joe", "Smith"));
        mapCustomers.put("2", new Customer("Ali", "Selam"));
        mapCustomers.put("3", new Customer("Avi", "Noyan"));

        int size = mapCustomers.size();

        log.info("Map size is {}", size);

        IMap<String, BinaryHolder> byteMap = client.getMap("bytemap");

        for (int i = 0; i < 100; i++) {
            byteMap.put(Integer.toString(i), new BinaryHolder(1024 * 1024));

        }

        BinaryHolder binaryHolder = byteMap.get("1");
        log.info("length = {}", binaryHolder.getBytes().length);

    }

}

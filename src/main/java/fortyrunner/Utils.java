package fortyrunner;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

public final class Utils {

    private Utils(){
    }

    public static HazelcastInstance readHZClient() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("dev");
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}

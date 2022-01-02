package fortyrunner;

import lombok.Value;

import java.io.Serializable;

@Value
public class BinaryHolder implements Serializable {

    byte[] bytes;

    public BinaryHolder(int size) {
        bytes = new byte[size];

    }
}

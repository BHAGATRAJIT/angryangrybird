package com.angrybirds.game2;

public interface Serializable {
    byte[] serialize();
    Object deserialize(byte[] data);
}

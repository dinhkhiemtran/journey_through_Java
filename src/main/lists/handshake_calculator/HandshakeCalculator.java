package main.lists.handshake_calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HandshakeCalculator {

    private static final HashMap<Integer, Signal> mapping = new HashMap<>();

    public static HashMap<Integer, Signal> getHandShake() {
        mapping.put(1, Signal.WINK);
        mapping.put(2, Signal.DOUBLE_BLINK);
        mapping.put(4, Signal.CLOSE_YOUR_EYES);
        mapping.put(8, Signal.JUMP);
        return mapping;
    }

    public List<Signal> calculateHandshake(int number) {
        HashMap<Integer, Signal> mapping = getHandShake();
        List<Signal> handShake = new ArrayList<>();
        mapping.forEach((key, value) -> {
            if ((number & key) == key) {
                handShake.add(value);
            }
        });
        if ((number & 16) == 16) {
            Collections.reverse(handShake);
        }
        return handShake;
    }

    public static void main(String[] args) {
        HandshakeCalculator handshakeCalculator = new HandshakeCalculator();
        List<Signal> signals = handshakeCalculator.calculateHandshake(10);
        System.out.println(signals);

    }
}

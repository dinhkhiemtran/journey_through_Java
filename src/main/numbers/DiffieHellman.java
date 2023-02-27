package main.numbers;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {

    public BigInteger secret(BigInteger p, BigInteger publicKey, BigInteger privateKey) {
        return publicKey.modPow(privateKey, p);
    }

    public BigInteger publicKey(BigInteger p, BigInteger g, BigInteger priKey) {
        return g.modPow(priKey, p);
    }

    public BigInteger privateKey(BigInteger prime) {
        return new BigInteger(prime.bitLength(), new Random()).mod(prime.subtract(BigInteger.ONE)).add(BigInteger.ONE);
    }
}

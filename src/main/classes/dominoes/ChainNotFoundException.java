package main.classes.dominoes;

@SuppressWarnings("serial")
public
class ChainNotFoundException extends Exception {

    public ChainNotFoundException(String message) {
        super(message);
    }
}
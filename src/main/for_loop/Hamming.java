package main.for_loop;

public class Hamming {

    private String leftStrand;

    private String rightStrand;

    public Hamming(String leftStrand, String rightStrand){
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        if (!leftStrand.isEmpty() && rightStrand.isEmpty()){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()){
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    public int getHammingDistance() {
        int ham = 0;
        for (int i = 0; i < leftStrand.length(); i++){
            if (leftStrand.charAt(i) != rightStrand.charAt(i)){
                ham++;
            }
        }
        return ham;
    }

    public static void main(String[] args) {
        String leftStrand = "GAGCCTACTAACGGGAT";
        String rightStrand = "CATCGTAATGACGGCCT";
        Hamming hamming = new Hamming(leftStrand,rightStrand);
        int hammingDistance = hamming.getHammingDistance();
        System.out.println("Distance: " + hammingDistance);
    }
}

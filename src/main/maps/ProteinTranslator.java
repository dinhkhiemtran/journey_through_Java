package main.maps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ProteinTranslator {

    private static LinkedHashMap<String, String> Amino_Acids = new LinkedHashMap<>();

    static {
        Amino_Acids.put("AUG", "Methionine");
        Amino_Acids.put("UUU", "Phenylalanine");
        Amino_Acids.put("UUC", "Phenylalanine");
        Amino_Acids.put("UUA", "Leucine");
        Amino_Acids.put("UUG", "Leucine");
        Amino_Acids.put("UCU", "Serine");
        Amino_Acids.put("UCC", "Serine");
        Amino_Acids.put("UCA", "Serine");
        Amino_Acids.put("UCG", "Serine");
        Amino_Acids.put("UAU", "Tyrosine");
        Amino_Acids.put("UAC", "Tyrosine");
        Amino_Acids.put("UGU", "Cysteine");
        Amino_Acids.put("UGC", "Cysteine");
        Amino_Acids.put("UGG", "Tryptophan");
        Amino_Acids.put("UAA", "STOP");
        Amino_Acids.put("UAG", "STOP");
        Amino_Acids.put("UGA", "STOP");
    }

    public List<String> translate(String rnaSequence) {
        List<String> results = new ArrayList<>();
        String codon, protein;
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            codon = rnaSequence.substring(i, i + 3);
            System.out.println(codon);
            protein = Amino_Acids.get(codon);
            if (protein == "STOP") break;
            results.add(protein);
        }
        return results;
    }

    public static void main(String[] args) {
        ProteinTranslator proteinTranslator = new ProteinTranslator();
        System.out.println(proteinTranslator.translate("AUGUUUUCUUAAAUG"));
    }

}

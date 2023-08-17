package com.yenibiris.textcorrection.utils.normalization;

import org.springframework.stereotype.Component;
import zemberek.core.logging.Log;
import zemberek.morphology.TurkishMorphology;
import zemberek.normalization.TurkishSpellChecker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BasicWordSpellingCheckAndSuggestion {

    private String CheckText(boolean expression)
    {
        return expression ? "green" : "red";
    }
    public String CheckAndSuggestion(String content) throws IOException {
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        TurkishSpellChecker spellChecker = new TurkishSpellChecker(morphology);

        String[] arrOfStr = content.split(" ");

        for (String a : arrOfStr)
            System.out.println(a);
        List<String> solutionsText = new ArrayList<String>();
        for(String word : arrOfStr)
        {
            Log.info(word + " -> " + spellChecker.suggestForWord(word));
            solutionsText.add(String.format("<span style=\"color: %s;\">%s</span> ",CheckText(spellChecker.check(word)),word ));
        }
        return String.join("",solutionsText);
    }
}
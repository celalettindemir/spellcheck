package com.yenibiris.textcorrection.Controller;

import com.yenibiris.textcorrection.DTO.Content;
import com.yenibiris.textcorrection.utils.normalization.BasicWordSpellingCheckAndSuggestion;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class SpellController {

    private final BasicWordSpellingCheckAndSuggestion basicWordSpellingCheckAndSuggestion;
    SpellController(BasicWordSpellingCheckAndSuggestion basicWordSpellingCheckAndSuggestion) {
        this.basicWordSpellingCheckAndSuggestion = basicWordSpellingCheckAndSuggestion;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @PostMapping("/spellCheck")
    @CrossOrigin
    String SpellCheck(@RequestBody Content content) throws IOException {
        return  basicWordSpellingCheckAndSuggestion.CheckAndSuggestion(content.getText());
    }
    // end::get-aggregate-root[]

}

package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String [] lexemes = string.split(LEXEME_REGEX);
        for(String lex : lexemes){
            AbstractTextComponent absComponent = new TextComponent(TextComponentType.WORD);
            abstractTextComponent.add(absComponent);
            AbstractTextParser parser = new WordParser();
            parser.parse(absComponent,lex);
        }
    }
}

package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import java.util.ArrayList;
import java.util.List;

public class LexemeParser extends AbstractTextParser{
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] str = string.split(LEXEME_REGEX);
        List<Character> chars2 = new ArrayList<>();
        for (String x: str) {
            char[] chars = x.toCharArray();
            for (int i = 0; i < chars.length ; i++) {
                chars2.add(chars[i]);
            }
        }
        Character[] newChars = chars2.stream().toArray(Character[]::new);

        for (char charX : newChars) {
            abstractTextComponent.add(new SymbolLeaf(TextComponentType.WORD, charX));
        }
    }
}

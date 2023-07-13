package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public class WordParser extends AbstractTextParser{
    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] str = string.split("\\s+");
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

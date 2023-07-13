package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }
    public AbstractTextParser build() {
        AbstractTextParser abstractTextParser = null;

        for (int i = 0; i < parsers.size() - 1; i++) {
            abstractTextParser = parsers.get(i);
            AbstractTextParser nextParser = parsers.get(i + 1);
            abstractTextParser.setNextParser(nextParser);
        }
        return abstractTextParser;
    }
}

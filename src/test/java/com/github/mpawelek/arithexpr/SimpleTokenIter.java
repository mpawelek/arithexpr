package com.github.mpawelek.arithexpr;

public class SimpleTokenIter extends TokenIter {

    private String[] tokens;
    private int tokenPos;

    public SimpleTokenIter(String[] tokens) {
        super(SimpleTokenIter.makeString(tokens));
        this.tokens = tokens;
    }

    @Override
    public boolean hasNext() {
        return this.tokenPos < tokens.length;
    }

    @Override
    public String next() {
        String nextToken = this.tokens[this.tokenPos];
        this.tokenPos++;
        return nextToken;
    }

    @Override
    public String lookahead() {
        return this.tokens[this.tokenPos];
    }

    public static String makeString(String[] strings) {
        String exprString = "";
        for (String e : strings) {
            exprString += e;
        }
        return exprString;
    }
}

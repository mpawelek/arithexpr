package com.github.mpawelek.arithexpr;

import java.util.HashMap;
import java.util.Map;

public class ArithExpr {
    private TokenIter tokens;
    private Map<String, Integer> priority;

    public ArithExpr(TokenIter tokens) {
        this.tokens = tokens;
        this.priority = new HashMap<>();
        this.priority.put("*", 4);
        this.priority.put("/", 3);
        this.priority.put("+", 2);
        this.priority.put("-", 1);
    }

    public String evalExpr() throws Exception {
        String x = "";
        if (!this.tokens.hasNext()) {
            return x;
        }
        for (x = this.tokens.next(); this.tokens.hasNext(); ) {
            String op = this.tokens.next();
            if (!this.tokens.hasNext()) {
                throw new ArithExprException("expected y");
            }
            String y = this.tokens.next();
            x = this.evalBin(x, op, y);
        }

        return x;
    }

    public String evalBin(String x, String op, String y) throws ArithExprException {
        if (!this.tokens.hasNext()) {
            return x+op+y;
        }
        String opNext = this.tokens.lookahead();
        if (this.priority.get(op) >= this.priority.get(opNext)) {
            return x+op+y;
        }
        opNext = this.tokens.next();
        if (!this.tokens.hasNext()) {
            throw new ArithExprException("expected z");
        }
        String z = this.tokens.next();
        y = "{"+this.evalBin(y, opNext, z)+"}";
        return this.evalBin(x, op, y);
    }
}

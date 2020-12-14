package com.github.mpawelek.arithexpr;

import org.junit.jupiter.api.Test;

public class ArithExprTest {
    @Test
    public void test() throws Exception {
       TokenIter tokens = new SimpleTokenIter(new String [] {"x", "+", "y", "*", "z", "/", "t"}); 
       ArithExpr expr = new ArithExpr(tokens);
       System.out.println(expr.evalExpr());
    }    
}

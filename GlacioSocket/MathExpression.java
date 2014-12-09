/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GlacioSocket;

import expr.Expr;
import expr.Parser;
import expr.SyntaxException;

/**
 *
 * @author Diego
 */
public class MathExpression {

    private MathExpression() {}
    
    public static double Evaluation(String exp) {
            
        try {
            Expr e = Parser.parse(exp);
            return e.value();
        } catch (SyntaxException ex) {
            System.out.println("Erro na sintaxe.");
            //Logger.getLogger(MathExpression.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
    }
    
}

package compiler.compiler;

import compiler.parser.DemoBaseVisitor;
import compiler.parser.DemoParser.AdditionContext;
import compiler.parser.DemoParser.NumberContext;
import compiler.parser.DemoParser.PlusContext;
import compiler.parser.DemoParser.PrintlnContext;

public class MyVisitor extends DemoBaseVisitor<String>{
	
	
	@Override
	public String visitPrintln(PrintlnContext ctx) {
		// TODO Auto-generated method stub
		return "getstatic java/lang/System/out Ljava/io/PrintStream;\n"+
				visit(ctx.argument)+"\n"+
				"invokevirtual java/io/PrintStream/println(I)V\n";
	}
	
	
	@Override
	public String visitPlus(PlusContext ctx) {
		return visitChildren(ctx) + "\n" + 
				"ldc "+ctx.right.getText() + "\n" +
				"iadd";
		
	}
	
	@Override
	public String visitNumber(NumberContext ctx) {
		return "ldc "+ctx.leaf.getText();
	}
	
	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		if(aggregate == null){
			return nextResult;
		}
		if(nextResult == null){
			return aggregate;
		}
		return aggregate +"\n"+ nextResult;
		
	}
	

	
}

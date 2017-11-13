package compiler.compiler;

import compiler.parser.DemoBaseVisitor;
import compiler.parser.DemoParser.DivContext;
import compiler.parser.DemoParser.MinusContext;
import compiler.parser.DemoParser.MulContext;
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
				"iadd";
		
	}
	
	@Override
	public String visitMinus(MinusContext ctx) {
		return visitChildren(ctx) + "\n" + 
				"isub";
	}
	
	@Override
	public String visitDiv(DivContext ctx) {
		return visitChildren(ctx) + "\n" + 
				"idiv";
	}
	
	@Override
	public String visitMul(MulContext ctx) {
		return visitChildren(ctx) + "\n" + 
				"imul";
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

package compiler.compiler;



import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import compiler.parser.DemoLexer;
import compiler.parser.DemoParser;

@SuppressWarnings("deprecation")
public class App {

	public static void main(String[] args) throws Exception {
		ANTLRInputStream input =  new ANTLRFileStream("code.demo");
		System.out.println(compile(input));
	}
	
	public static String compile(ANTLRInputStream input){
		DemoLexer lexer =  new DemoLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DemoParser parser = new DemoParser(tokens);
		
		ParseTree tree = parser.addition();
		
		return createJasminFile(new MyVisitor().visit(tree));

	}
	
	private static String createJasminFile(String instrutions){
		
		return ".class public HelloWorld\n"+
				".super java/lang/Object\n"+
				"\n"+
				".method public static main([Ljava/lang/String;)V\n"+
				".limit stack 100\n"+
				".limit locals 100\n"+
				"\n"+
				"getstatic java/lang/System/out Ljava/io/PrintStream;\n"+
				instrutions+"\n"+
				"invokevirtual java/io/PrintStream/println(I)V\n"+
				"return\n"+ 
				"\n"+
				".end method";
		
	}
	
	

}

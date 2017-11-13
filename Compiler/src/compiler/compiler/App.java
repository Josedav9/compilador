package compiler.compiler;




import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import compiler.parser.DemoLexer;
import compiler.parser.DemoParser;
import jasmin.ClassFile;

@SuppressWarnings("deprecation")
public class App {
	
	Path tempDir;
	

	public static void main(String[] args) throws Exception {
		ANTLRInputStream input =  new ANTLRFileStream("code.demo");
		System.out.println(compile(input));
		//new App().compileAndRun("println(1+2+42);");
	}
	

	
	public static String compile(ANTLRInputStream input){
		DemoLexer lexer =  new DemoLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DemoParser parser = new DemoParser(tokens);
		
		ParseTree tree = parser.program();
		
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
				instrutions+"\n"+
				"return\n"+ 
				"\n"+
				".end method";
		
	}
		
	

}

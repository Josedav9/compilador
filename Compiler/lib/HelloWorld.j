.class public HelloWorld
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 3
ldc 42
iadd
ldc 5
iadd
ldc 6
iadd
invokevirtual java/io/PrintStream/println(I)V

return

.end method


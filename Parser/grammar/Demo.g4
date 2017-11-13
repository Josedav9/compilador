grammar Demo;

program : (println ';')+;

expression: left=expression '/' right=expression #Div
          | left=expression '*' right=expression #Mul
	  | left=expression '-' right=expression #Minus
          | left=expression '+' right=expression #Plus
	  | leaf=NUMERO #Number 
          ;
          
println: 'println(' argument=expression ')';

NUMERO: [0-9]+;
WHITESPACE: [ \t\n\r]+ ->skip;

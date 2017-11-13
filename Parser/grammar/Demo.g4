grammar Demo;

program : (println ';')+;

addition: left=addition '+' right=NUMERO #Plus
          | leaf=NUMERO #Number 
          ;
          
println: 'println(' argument=addition ')';

NUMERO: [0-9]+;
WHITESPACE: [ \t\n\r]+ ->skip;

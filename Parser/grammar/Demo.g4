grammar Demo;

addition: left=addition '+' right=NUMERO #Plus
          | leaf=NUMERO #Number 
          ;

NUMERO: [0-9]+;

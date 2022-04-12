
#include "suma.h"
#include <stdio.h>

void
suma_prog_1(char *host,int a, int b)
{
	CLIENT *clnt;
	int  *result_1;
	dupla_int  suma_1_arg;

#ifndef	DEBUG
    /*si la variable clnt es nula signfica que hubo un error en la creacion del socket*/
	clnt = clnt_create (host, SUMA_PROG, SUMA_VERS, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	

        suma_1_arg.a=a;
        suma_1_arg.b=b;
	result_1 = suma_1(&suma_1_arg, clnt);
	/*en caso de que la variable result_1 sea un valor nulo marcara un error*/
	if (result_1 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}else{
                printf("resultado=%d\n",*result_1);
        }
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	
}

/*En la funcion main se reciben los parametos ingresados por parte del usuario, se indica la direccion IP a la que se va a conectar y todos estos parametros los envia a la función suma_prog_1() e imprime el resultado que le regresar el servidor*/
int
main (int argc, char *argv[])
{
	char *host;
        int a,b;
/*si no se escriben los parametros de la direccion a la que nos vamos a conectar ni la de los numeros a sumar, marcara un error*/
	if (argc !=4 ) {
		printf ("usage: %s server_host num1 num2\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	/*Si los numeros a sumar son 0 o se utiliza el caracter '0' marcar un error ya que no son valores permitidos*/
        if((a=atoi(argv[2]))== 0 && *argv[2]!='0'){
         fprintf(stderr, "invalid value: %s\n", argv[2]);
         exit(1);
        }
        if((b = atoi(argv[3])) == 0 && *argv[3] != '0'){
          fprintf(stderr, "invalid value: %s\n", argv[3]);
          exit(1);
         }
	suma_prog_1 (host,a,b);
exit (0);
}

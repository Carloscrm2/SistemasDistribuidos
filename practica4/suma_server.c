/*En este codigo unicamente se reciben los datos enviados por el cliente, se procesan y se regresa el resultado al servidor*/

#include "suma.h"

int *
suma_1_svc(dupla_int *argp, struct svc_req *rqstp)
{
	static int  result;

       printf("El procedimiento ha sido invocado correctamente\n");
       printf("parametros: %d,%d\n",argp->a,argp->b);
       result = argp->a + argp->b;
       printf("regresando: %d\n",result);
	return &result;
}

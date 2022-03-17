/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _CALCULADORA_H_RPCGEN
#define _CALCULADORA_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct numeros {
	int x;
	int y;
};
typedef struct numeros numeros;

#define calculadora_PROG 0x31111111
#define calculadora_VERS 1

#if defined(__STDC__) || defined(__cplusplus)
#define suma 1
extern  float * suma_1(numeros *, CLIENT *);
extern  float * suma_1_svc(numeros *, struct svc_req *);
#define resta 2
extern  float * resta_1(numeros *, CLIENT *);
extern  float * resta_1_svc(numeros *, struct svc_req *);
#define multiplicacion 3
extern  float * multiplicacion_1(numeros *, CLIENT *);
extern  float * multiplicacion_1_svc(numeros *, struct svc_req *);
#define division 4
extern  float * division_1(numeros *, CLIENT *);
extern  float * division_1_svc(numeros *, struct svc_req *);
extern int calculadora_prog_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define suma 1
extern  float * suma_1();
extern  float * suma_1_svc();
#define resta 2
extern  float * resta_1();
extern  float * resta_1_svc();
#define multiplicacion 3
extern  float * multiplicacion_1();
extern  float * multiplicacion_1_svc();
#define division 4
extern  float * division_1();
extern  float * division_1_svc();
extern int calculadora_prog_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_numeros (XDR *, numeros*);

#else /* K&R C */
extern bool_t xdr_numeros ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_CALCULADORA_H_RPCGEN */
package com.nexos.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nexos.gs_operaciones_web_service.GetDivisionRequest;
import com.nexos.gs_operaciones_web_service.GetDivisionResponse;
import com.nexos.gs_operaciones_web_service.GetMultiplicacionRequest;
import com.nexos.gs_operaciones_web_service.GetMultiplicacionResponse;
import com.nexos.gs_operaciones_web_service.GetRestaRequest;
import com.nexos.gs_operaciones_web_service.GetRestaResponse;
import com.nexos.gs_operaciones_web_service.GetSumaRequest;
import com.nexos.gs_operaciones_web_service.GetSumaResponse;
import com.nexos.logica.Ejercicio;

@Endpoint
public class OperacionesEndPoint {

	 private static final String NAMESPACE_URI = "http://nexos.com/gs_operaciones_web_service";
	 private static Ejercicio ejercicio = new Ejercicio();
	 
	    @Autowired
	    public OperacionesEndPoint() {
	    }
	 
	    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSumaRequest")
	    @ResponsePayload
	    public GetSumaResponse getSuma(@RequestPayload GetSumaRequest request) {
	        GetSumaResponse response = new GetSumaResponse();
	        try{
	        	response.setValorTotal(ejercicio.suma(request.getValor1(),request.getValor2()));	
	        }catch (Exception e) {
				System.out.println("ERROR"+e);
			}
	        return response;
	    }
	    
	    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRestaRequest")
	    @ResponsePayload
	    public GetRestaResponse getResta(@RequestPayload GetRestaRequest request) {
	        GetRestaResponse response = new GetRestaResponse();
	        try{
	        	response.setValorTotal(ejercicio.resta(request.getValor1(),request.getValor2()));	
	        }catch (Exception e) {
				System.out.println("ERROR"+e);
			}
	        return response;
	    }
	    
	    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMultiplicacionRequest")
	    @ResponsePayload
	    public GetMultiplicacionResponse getMultiplicacion(@RequestPayload GetMultiplicacionRequest request) {
	        GetMultiplicacionResponse response = new GetMultiplicacionResponse();
	        try{
	        	response.setValorTotal(ejercicio.multiplicacion(request.getValor1(),request.getValor2()));	
	        }catch (Exception e) {
				System.out.println("ERROR"+e);
			}
	        return response;
	    }
	    
	    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDivisionRequest")
	    @ResponsePayload
	    public GetDivisionResponse getDivision(@RequestPayload GetDivisionRequest request) {
	        GetDivisionResponse response = new GetDivisionResponse();
	        try{
	        	response.setValorTotal(ejercicio.divicion(request.getValor1(),request.getValor2()));	
	        }catch (Exception e) {
				System.out.println("ERROR"+e);
			}
	        return response;
	    }
	    
	}
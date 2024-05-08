package mx.uv.practica06;

import java.util.ArrayList;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;



public class FarenheitEndpoint {
    ArrayList<Historial> historial = new ArrayList<>();
    int id =0;

    @PayloadRoot(localPart = "ConvertirCaFRequest", namespace = "t4is.uv.mx/convertidor")
    @ResponsePayload
    public ConvertirCaFResponse saludar(@RequestPayload ConvertirCaFRequest peticion){
        ConvertirCaFResponse respuesta = new ConvertirCaFResponse();
        double grados = peticion.getGrados();
        double convertidor = (grados * 1.8) + 32;
        respuesta.setRespuesta(String.valueOf(convertidor) );
        Historial e = new Historial();
        e.setId(id);
        id++;
        e.setGrados(convertidor);
        historial.add(e);
        System.out.println("Entrante");
        return respuesta;
    }

    @PayloadRoot(localPart = "ConvertirFaCRequest", namespace = "t4is.uv.mx/convertidor")
    @ResponsePayload
    public ConvertirFaCResponse saludar(@RequestPayload ConvertirFaCRequest peticion){
        ConvertirFaCResponse respuesta = new ConvertirFaCResponse();
        double grados = peticion.getGrados();
        double convertidor = (grados -32 )/1.8;
        respuesta.setRespuesta(convertidor);
        Historial e = new Historial();
        e.setId(id);
        id++;
        e.setGrados(convertidor);
        historial.add(e);
        return respuesta;
    }

    @PayloadRoot(localPart = "HistorialRequest", namespace = "t4is.uv.mx/convertidor")
    @ResponsePayload
    public HistorialResponse buscarSaludos(){
        HistorialResponse respuesta = new HistorialResponse();
        respuesta.getHistorial().addAll(historial);
        return respuesta;
    }
}

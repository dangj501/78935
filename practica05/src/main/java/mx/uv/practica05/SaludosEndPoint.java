package mx.uv.practica05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.saludos.BuscarSaludosResponse;
import mx.uv.t4is.saludos.SaludarRequest;
import mx.uv.t4is.saludos.SaludarResponse;
import mx.uv.t4is.saludos.BuscarSaludosResponse.Saludo;

@Endpoint
public class SaludosEndPoint {
    List<Saludo> saludos = new ArrayList<>();

    @PayloadRoot(localPart = "SaludarRequest", namespace = "t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse saludos(@RequestPayload SaludarRequest peticion){
        System.out.println("hola "+peticion.getNombre());
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setSaludo("hola "+peticion.getNombre());
        Saludo s = new Saludo();
        s.setNombre(peticion.getNombre());
        saludos.add(s);
        return respuesta;
    } 

    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos(){
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        for (int i = 0; i < saludos.size(); i++) {
            System.out.println(saludos.get(i));
            respuesta.getSaludo().add(saludos.get(i));
        }
        return respuesta;
    }
}
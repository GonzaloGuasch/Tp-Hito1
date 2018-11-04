package Aplicacion;

import java.util.Set;
import java.util.stream.Collectors;

import Muestra.Muestra;

public class CalculadorDeDistancias {
	public double distanciaEntre(Ubicacion ubicacion1, Ubicacion ubicacion2) {   
        double radioTierra= 6371;//en kilometros  
        double dLat= Math.toRadians(ubicacion2.getLatitud() - ubicacion1.getLatitud());  
        double dLng= Math.toRadians(ubicacion2.getLongitud() - ubicacion1.getLatitud());  
        double sindLat= Math.sin(dLat / 2);  
        double sindLng= Math.sin(dLng / 2);  
        double va1= Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(ubicacion1.getLatitud())) 
                * Math.cos(Math.toRadians(ubicacion2.getLatitud()));  
        double va2= 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia= radioTierra * va2;  
   
        return distancia;
	}
	
	public Set<Ubicacion> ubicacionesAMenosDeXKilometrosDeUnaUbicacion(Set<Ubicacion> ubicaciones, Ubicacion ubicacionreferencia, Double distancia){
		
		return ubicaciones.stream().filter(ubicacion -> this.distanciaEntre(ubicacion ,ubicacionreferencia) < distancia)
		.collect(Collectors.toSet());
	}
	
	public Set<Muestra> MuestrasAMenosDeXKilometros(Set<Muestra> muestras, Muestra muestraDeReferencia , Double distancia){
		
		Ubicacion ubicacionReferencia =muestraDeReferencia.getUbicacion(); 
		
		return muestras.stream().filter(muestra -> this.distanciaEntre(muestra.getUbicacion(), ubicacionReferencia) < distancia)
				.collect(Collectors.toSet());
		}
}

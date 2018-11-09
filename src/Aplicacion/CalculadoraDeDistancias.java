package Aplicacion;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Muestra.Muestra;

public class CalculadoraDeDistancias {

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
   
        return Math.ceil(distancia);
	}
	public Set<Ubicacion> ubicacionesAMenosDeXKilometrosDeUnaUbicacion(Set<Ubicacion> ubicaciones, Ubicacion ubicacionreferencia, Double distancia){
	//No le supimos dar uso a este Mensaje: (lo implementamos por que lo pedian)
		Stream<Ubicacion> ubicacionesAOperar= ubicaciones.stream();
		
		ubicacionesAOperar = ubicacionesAOperar.filter(ubicacion -> !(ubicacion.equals(ubicacionreferencia)));
		ubicacionesAOperar =ubicacionesAOperar.filter(ubicacion -> this.distanciaEntre(ubicacion ,ubicacionreferencia) < distancia);
		
		return ubicacionesAOperar.collect(Collectors.toSet());
	}
	
	public Set<Muestra> MuestrasAMenosDeXKilometros(Set<Muestra> muestras, Ubicacion unaUbicacion , Double distancia){ 
		
		return muestras.stream().filter(muestra -> this.distanciaEntre(muestra.getUbicacion(), unaUbicacion) < distancia)
				.collect(Collectors.toSet());
		}
}

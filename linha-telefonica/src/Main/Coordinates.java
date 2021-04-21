/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author RGrupos
 */
public class Coordinates {
    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM
    public double lat;
    public double lon;
    
    public Coordinates(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }
    
    public double distance(Coordinates x){
        double startLat = this.lat;
        double startLong = this.lon;
        double endLat = x.lat;
        double endLong = x.lon;
        
        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
    private static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}

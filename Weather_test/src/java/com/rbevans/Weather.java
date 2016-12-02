/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.util.List;
import net.webservicex.*;
/**
 *
 * @author evansrb1
 */
public class Weather {
    private String zipCode = null;
    private net.webservicex.WeatherData today = null;

    public Weather() {
        
    }
    
    

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
        try { // Call Web Service Operation
            net.webservicex.WeatherForecast service = new net.webservicex.WeatherForecast();
            net.webservicex.WeatherForecastSoap port = service.getWeatherForecastSoap();
            // TODO initialize WS operation arguments here
            // TODO process result here
            net.webservicex.WeatherForecasts result = port.getWeatherByZipCode(zipCode);
            net.webservicex.ArrayOfWeatherData dataArray = result.getDetails();
            List<net.webservicex.WeatherData> data = dataArray.getWeatherData();
            today = data.get(0);
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }
    }

    public String getDay() {
        return today.getDay();
    }

    public String getWeatherImageURL () {
        return today.getWeatherImage();
    }

    public String getMaxTemp() {
        return today.getMaxTemperatureF();
    }
    
    public String getMinTemp() {
        return today.getMinTemperatureF();    
    }
}

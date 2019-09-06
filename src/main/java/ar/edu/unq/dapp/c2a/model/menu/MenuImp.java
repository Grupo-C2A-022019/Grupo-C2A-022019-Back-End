package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.time.Availability;

import java.util.Calendar;

public class MenuImp extends EntityImp implements Menu {
    private Business business;
    private String Nombre;
    private String descripción;
    //private List<Categoría>;
    private double valorDelivery;
    private Availability availability;
    //private tupla horarios de atencion
    private double tiempoDeEntrega;
    private double Precio;
    /*Cantidad Mínima [Obligatorio, 10<=X<=70]
    Precio Cantidad Minima  (*Min1) [Obligatorio,$0<=X<=$1000]
    Cantidad Mínima 2 [Opcional, 40<=X<=150]
    Precio Cantidad Minima 2(*Min2)  [Opcional,$0<=X<=$1000]
    Cantidad  máxima de ventas por día [Obligatorio]*/



    public MenuImp(Business business, Availability availability) {
        super();
        this.business = business;
        this.availability = availability;
    }

    @Override
    public Order orderBy(Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location customLocation) {
        return business.placeOrder(this, client, amount, deliveryType, deliveryAppointment, customLocation);
    }

    @Override
    public boolean isAvailableAt(Calendar aDate) {
        return availability.isAvailableAt(aDate);
    }

    public String getNombre(){
        return Nombre;
    }

    public String getDescripcion(){
        return descripción;
    }
}

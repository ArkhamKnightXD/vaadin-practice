package knight.arkham.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import knight.arkham.spring.model.Customer;
import knight.arkham.spring.repository.CustomerRepository;
import knight.arkham.spring.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

//Esta es la ventana principal por defecto de vaadin esto nos muestra un ejemplo de boton
//que hace una accion, como la ruta no esta especificada asume la ruta inicial por defecto
//Esta mainview tambien se puede especificar en el main de springboot


@Route
public class MainView extends VerticalLayout {

    //Cambie el main view para que me muestre un listado de los clientes utilizando grid

    //al parecer no hay necesidad de hacer el autowired a la hora de trabajar con vaadin
    private CustomerServices customerServices;

    //Aqui especifico un grid que contendra objetos tipo customer
    final Grid<Customer> grid;

    //Aqui pongo el constructor donde le mando el repository
    public MainView(CustomerServices customerServices) {

        // Aqui especifico que utilizaremos el repositorio que se encuentra en esta clase
        this.customerServices = customerServices;
        //Aqui inicializo el grid
        this.grid = new Grid<>(Customer.class);

        grid.setHeightByRows(true);

        //Aqui agrego el grid al verticallayout
        add(grid);

        // y por ultimo aqui agrego todos los customers  al grid
        grid.setItems(customerServices.listAllCustomers());
    }


}

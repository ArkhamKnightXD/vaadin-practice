package knight.arkham.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.router.RouterLink;
import knight.arkham.spring.cases.HolaMundo;
import knight.arkham.spring.model.Customer;
import knight.arkham.spring.services.CustomerServices;
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

    //Dentro de los parentesis del constructor debo de agregar el repositorio o el servicio con el que estoy trabajando
    public MainView(CustomerServices customerServices) {

        // Aqui especifico que utilizaremos el servicio que se encuentra en esta clase
        this.customerServices = customerServices;
        //Aqui inicializo el grid
        this.grid = new Grid<>(Customer.class);

        grid.setHeightByRows(true);

        VerticalLayout caja = new VerticalLayout();

        // De esta forma creo hipervinculos para acceder a las demas paginas
        caja.add(new H2("Enlaces a las demas paginas:"));

        //Routerlink sirve para agregar hipervinculos, aqui agrego dos hipervinculos, no importa donde esten ubicadas las clases
        // con especificar el nomber.class es suficiente
        caja.add(new RouterLink("Hola Mundo", HolaMundo.class));

        caja.add(new RouterLink("Comentarios", EjemploVaadin2.class));

        //Aqui agrego el grid al verticallayout
        add(grid, caja);

        // y por ultimo aqui agrego todos los customers  al grid
        grid.setItems(customerServices.listAllCustomers());


    }




}

package knight.arkham.spring.cases;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

//Ejemplo de hola mundo en vaadin
@Route("hola-mundo")
//El extend es para indicar que la vista que mostraremos extiende de un panel verticual y asi
// de esta forma los elementos que agreguemos se visualizaran uno debajo de otro
public class HolaMundo extends VerticalLayout {


    //Para trabajar con vaadin lo primero es hacer un constructuo vacio


    //Los elementos de vaadin se instancian como clases
    public HolaMundo() {


        //Creacion de caja de texto en vaadin
        TextField textField = new TextField("Nombre");

        //Creacion de boton en vaadin
        Button button = new Button("Saludar");
        //Aqui agrego un evento que cuando se haga click en el boton abajo me mostrara
        //un mensaje diciendo hola mas el el valor que el usuario puso en el textfield
        button.addClickListener(event -> add(new Label("Hola " + textField.getValue())));

        //Y al final siempre debo de agregar los elementos que instancie al verticallayout
        // o a el elemento de el cual extiendo sea cual sea

        add(textField,button);

    }
}

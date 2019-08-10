package knight.arkham.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import knight.arkham.spring.model.Comentario;
import knight.arkham.spring.services.ComentarioServices;

//Si desearamos agregar una plantilla html  para usar por defecto debemos de utilizar esta notacion tambien sirve para agregar hojas
//de estilo, y basicamente sera esto que hare, pero sera una hoja de estilo en pagina html
@HtmlImport("styles/styles.html")
@Route("ejemplo-vaadin")
public class EjemploVaadin2 extends VerticalLayout {

    private ComentarioServices comentarioServices;

    //Se recomienda especificar los componentes a nivel de clase y no dentro del constructor

    //Aqui agregamos un grid que es una tabla de datos y le indicamos
    // el tipo de dato u objeto con el que trabajara
    private Grid<Comentario> grid = new Grid<>();

    //Aqui declaramos un textArea esto se usara para almacenar mucho texto
    private TextArea textArea = new TextArea();

    //Y finalmente un boton
    private Button button = new Button("Guardar");

    private Button buttonForDelete = new Button("Borrar");


    public EjemploVaadin2(ComentarioServices comentarioServices) {

        //Especifico esta clase aqui para indicar que desde aqui hasta el final estare dando estilo mediante main-view a esta clase
        addClassName("main-view");

        // Aqui especifico que estaremos utilizando este servicio en este constructor, sino hago esto todas las llamadas
        //que haga a este servicio me daran error a la hora de correr la aplicacion
        this.comentarioServices = comentarioServices;

        //De esta forma le mandamos una imagen a la vista, instanciamos
        // la imagen con la ruta donde se encuentra la imagen
        Image image = new Image("frontend/images/arkham.jpg","logo");

        //Aqui especificamos el tamaño de la imagen al igual como el ancho
        image.setHeight("100px");


        //Aqui limitamos que la altura del grid este limitado por el numero de filas que hayaosea que si hay
        // 5 filas el grid no sera mas grande de ahi
        grid.setHeightByRows(true);

        //De esta forma agrego las columnas al grid, ademas de poder agregar header y el footer aqui mismo, por ahora solo agregare header
        //Por alguna razon la fecha falla a la hora de mostrarse
        grid.addColumn(Comentario::getFecha).setHeader("Fecha");
        grid.addColumn(Comentario::getContenido).setHeader("Contenido");

        //De esta forma agrego las filas con sus respectivos items que en este caso son todos los comentarios que haya registrado
        actualizar();

        //Aqui le indico al text area que sea lo mas ancho posible en la pagina
        textArea.setWidth("100%");

        //De esta forma puedo alinear el boton hacia la derecha en el layout
        // indicamos ahi aling.end que indica que se ira a la derecha, seguido del componente que quiero alinear
        setHorizontalComponentAlignment(Alignment.END,button);
        setHorizontalComponentAlignment(Alignment.CENTER,buttonForDelete);

        //Aqui le indicamos al boton que haga este evento donde consigue lo que se comento en el text area y se lo manda al metodo guardar
        button.addClickListener(event -> guardar(textArea.getValue()));




        //Al final agregamos la imagen al vertical layout
        add(image,grid,textArea,button);


    }


    //En este metodo guardar obtenemos el texto del text area mediante el boton
    // Y ya dentro de la funcion creamos un nuevo comentario y lo guardamos en la
    //base de datos mediante comentario services, luego de esto indico que me liste
    // los comentarios agregados para se haga todos esto con el boton
   private void guardar(String contenido){

        comentarioServices.createComentario(new Comentario(contenido));

        //Aqui listo todos los comentarios, para que cuando presione el boton me muestre
       // de inmediato el nuevo comentario que se creo
       actualizar();

       textArea.clear();

    }

    private void actualizar(){

        grid.setItems(comentarioServices.listAllComentarios());

    }

    private void eliminar(String contenido){

        comentarioServices.deleteComentario(contenido);

    }
}

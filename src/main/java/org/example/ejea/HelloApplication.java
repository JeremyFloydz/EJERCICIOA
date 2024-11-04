package org.example.ejea;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase {@code HelloApplication} es la clase principal que inicia la aplicación JavaFX.
 * Esta clase extiende {@code Application}, que es el punto de entrada para cualquier aplicación JavaFX.
 * Se encarga de cargar la interfaz de usuario desde un archivo FXML y mostrarla en la ventana principal.
 */
public class HelloApplication extends Application {

    /**
     * Este método se invoca al iniciar la aplicación JavaFX.
     * Se encarga de cargar el archivo FXML que define la interfaz de usuario,
     * crear una escena con el contenido del archivo FXML y mostrar la ventana principal.
     *
     * @param stage El escenario principal proporcionado por la plataforma JavaFX.
     *              Es donde se mostrará la interfaz de usuario de la aplicación.
     * @throws IOException Si hay un error al cargar el archivo FXML, se lanza esta excepción.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Asegúrate de que el nombre del archivo es el correcto (encuesta.fxml)
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("encuesta.fxml"));

        // Crear una escena con el contenido cargado y dimensiones específicas
        Scene scene = new Scene(fxmlLoader.load(), 652, 638); // Tamaño ajustado al de tu VBox en encuesta.fxml

        // Establecer el título de la ventana
        stage.setTitle("Encuesta");

        // Asignar la escena al escenario principal
        stage.setScene(scene);

        // Mostrar la ventana
        stage.show();
    }

    /**
     * Método principal que lanza la aplicación JavaFX.
     * Este método invoca {@link #launch(String...)} proporcionado por la clase {@code Application}
     * para iniciar la aplicación.
     *
     * @param args Los argumentos de línea de comandos, si los hay.
     */
    public static void main(String[] args) {
        // Iniciar la aplicación
        launch();
    }
}

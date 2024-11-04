package org.example.ejea;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform; // Import necesario para cerrar la aplicación

/**
 * La clase {@code HelloController} es el controlador de la interfaz de usuario para la encuesta.
 * Maneja las interacciones del usuario con los elementos de la interfaz y realiza la validación
 * de los datos ingresados antes de procesarlos.
 */
public class HelloController {

    @FXML
    private TextField profesionTextField; // Campo de texto para ingresar la profesión.

    @FXML
    private TextField hermanosTextField; // Campo de texto para ingresar el número de hermanos.

    @FXML
    private ComboBox<String> edadComboBox; // ComboBox para seleccionar la edad.

    @FXML
    private ListView<String> deportesListView; // ListView para seleccionar deportes.

    @FXML
    private Slider comprasSlider; // Slider para indicar el nivel de compras (1-10).

    @FXML
    private Slider televisionSlider; // Slider para indicar el tiempo de ver televisión (1-10).

    @FXML
    private Slider cineSlider; // Slider para indicar la frecuencia de ir al cine (1-10).

    @FXML
    private CheckBox deportesCheckBox; // CheckBox para indicar si se practican deportes.

    @FXML
    private RadioButton hombreRadioButton; // RadioButton para seleccionar género masculino.

    @FXML
    private RadioButton mujerRadioButton; // RadioButton para seleccionar género femenino.

    @FXML
    private RadioButton otroRadioButton; // RadioButton para seleccionar otro género.

    @FXML
    private Button aceptarButton; // Botón para aceptar la encuesta.

    @FXML
    private Button cancelarButton; // Botón para cancelar la encuesta.

    /**
     * Método llamado al inicializar el controlador.
     * Se encarga de configurar los elementos de la interfaz,
     * incluyendo los elementos del ComboBox y ListView.
     */
    @FXML
    public void initialize() {
        // Inicializa el ComboBox de edades
        edadComboBox.getItems().addAll(
                "Menores de 18",
                "Entre 18 y 30",
                "Entre 31 y 50",
                "Entre 51 y 70",
                "Mayores de 70"
        );

        // Inicializa el ListView de deportes
        deportesListView.getItems().addAll(
                "Fútbol",
                "Baloncesto",
                "Natación",
                "Tenis",
                "Ciclismo",
                "Golf"
        );
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Aceptar".
     * Valida los datos ingresados en la encuesta y muestra
     * una alerta con la información si no hay errores.
     */
    @FXML
    protected void onHelloButtonClick() {
        StringBuilder errores = new StringBuilder();  // Acumular errores para mostrar al usuario

        // Validación de la profesión
        String profesion = profesionTextField.getText().trim();
        if (profesion.isEmpty()) {
            errores.append("El campo de profesión no puede estar vacío.\n");
        }

        // Validación del número de hermanos
        String hermanos = hermanosTextField.getText().trim();
        if (hermanos.isEmpty()) {
            errores.append("El campo 'Número de Hermanos' no puede estar vacío.\n");
        } else {
            try {
                Integer.parseInt(hermanos);
            } catch (NumberFormatException e) {
                errores.append("El campo 'Número de Hermanos' debe ser un número válido.\n");
            }
        }

        // Validación del CheckBox de deportes
        if (deportesCheckBox.isSelected() && deportesListView.getSelectionModel().isEmpty()) {
            errores.append("Si se marca '¿Practicas algún deporte?', debe seleccionar al menos un deporte.\n");
        }

        // Mostrar errores si existen
        if (errores.length() > 0) {
            mostrarAlertaErrores(errores.toString());
            return;  // Salir del método si hay errores
        }

        // Si no hay errores, mostrar la información en una ventana emergente
        mostrarInformacionRellena(profesion, hermanos);
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Cancelar".
     * Cierra la aplicación.
     */
    @FXML
    protected void onCancelButtonClick() {
        // Cerrar la aplicación
        Platform.exit(); // O puedes usar System.exit(0);
    }

    /**
     * Muestra una alerta de error con los mensajes de validación proporcionados.
     *
     * @param mensajeErrores El mensaje que contiene los errores de validación.
     */
    private void mostrarAlertaErrores(String mensajeErrores) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Errores de Validación");
        alert.setHeaderText("Por favor corrige los siguientes errores:");
        alert.setContentText(mensajeErrores);
        alert.showAndWait();
    }

    /**
     * Muestra una alerta con la información ingresada en la encuesta.
     *
     * @param profesion La profesión ingresada por el usuario.
     * @param hermanos  El número de hermanos ingresado por el usuario.
     */
    private void mostrarInformacionRellena(String profesion, String hermanos) {
        String deportesSeleccionados = String.join(", ", deportesListView.getSelectionModel().getSelectedItems());
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Profesión: ").append(profesion).append("\n")
                .append("Número de Hermanos: ").append(hermanos).append("\n")
                .append("Edad: ").append(edadComboBox.getValue()).append("\n")
                .append("Deportes: ").append(deportesCheckBox.isSelected() ? deportesSeleccionados : "No práctica deportes").append("\n")
                .append("Compras (1-10): ").append((int) comprasSlider.getValue()).append("\n")
                .append("Ver televisión (1-10): ").append((int) televisionSlider.getValue()).append("\n")
                .append("Ir al cine (1-10): ").append((int) cineSlider.getValue()).append("\n");

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información Rellena");
        alert.setHeaderText("Información de la Encuesta:");
        alert.setContentText(mensaje.toString());
        alert.showAndWait();
    }
}

package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Tworzymy VBox, ktory bedzie porzadkowal elementy w pionie
        //Argument liczbowy 5 oznacza odstepy miedzy elementami
        VBox verticalVBox = new VBox(5);
        //ustawiamy padding w VBoxie
        verticalVBox.setPadding(new Insets(5));
        //etykieta pierwszego pola
        Label sequanceLabel = new Label();
        //tekst wyswietlany w etykiecie
        sequanceLabel.setText("Sekwencja");
        //dodajemy potomka do VBoxa
        verticalVBox.getChildren().add(sequanceLabel);
        //Tworzymy kontrolke typu TextArea
        TextArea sequanceTextArea = new TextArea();
        //Ustawiamy mozliwosc zawijania tekstu
        sequanceTextArea.setWrapText(true);
        //dodajemy kontrolke
        verticalVBox.getChildren().add(sequanceTextArea);
        //Tworzymy HBox z odstepami 5
        HBox searchHBox = new HBox(5);
        //Tworzymy etykiete
        Label searchLabel = new Label("Szukaj: ");
        //Tworzymy text Field
        TextField searchTextField = new TextField();
        //ustawiamy minmalna szerokosc pola tekstowego
        searchTextField.setMinWidth(255);
        //Dodajemy Label i TextField do HBox-u
        searchHBox.getChildren().add(searchLabel);
        searchHBox.getChildren().add(searchTextField);
        //Dodajemy HBox do VBoxu
        verticalVBox.getChildren().add(searchHBox);
        //Kolejna etykieta
        Label resultLabel = new Label("Wynik: ");
        //dodajemy do VBoxa
        verticalVBox.getChildren().add(resultLabel);
        //tworzymy TextArea do wypisywania tekstu
        TextArea resultTextArea = new TextArea();
        //Wyłaczamy mozliwosc edycji
        resultTextArea.setEditable(false);
        //Wlaczamy zawijanie tekstu
        resultTextArea.setWrapText(true);
        //dodajemy do VBoxu
        verticalVBox.getChildren().add(resultTextArea);
        //Tworzymy HBox dla przyciskow
        HBox buttonsHBox = new HBox(5);
        //Pierwszy przycisk
        Button searchButton = new Button("Szukaj: ");
        //Ustawiamy akcje
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resultTextArea.setText(Search.search(sequanceTextArea.getText(), searchTextField.getText()));

            }
        });
        //Drugi przycisk
        Button exitButton = new Button("Zakoncz");
        //Ustawiamy akcje
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

        //Dodawanie przyciskow do HBox-u metoda addAll pozwala dodawac wiele elementow naraz
        buttonsHBox.getChildren().addAll(searchButton, exitButton);
        //dodajemy buttonsHBox do verticalVBox
        verticalVBox.getChildren().add(buttonsHBox);
        //Tworzymy scene
        Scene scene = new Scene(verticalVBox, 350, 250);
        primaryStage.setTitle("Szukanie Sekwencji");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

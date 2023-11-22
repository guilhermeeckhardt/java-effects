package com.mycompany.projeto_terca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.ScrollPane;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Text titleLabel = new Text("BEM VINDO AO MEU SITE!");
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Text textLabel = new Text("Lorem ipsum dolor sit amet omnis optio suscipit nobis numquam. Quam eligendi consectetur nostrum laudantium id adipisci consequatur similique reiciendis sint. Ipsa quas consequatur quod assumenda aspernatur odio cum in nihil rem qui harum dolores, alias ipsum sint obcaecati neque amet corrupti, illum minus, at dignissimos omnis atque. Quisquam maiores provident ut porro! Sed, odit facilis? Minima earum molestias eius illo nam voluptatum rerum debitis esse delectus odit aspernatur id neque laboriosam, magnam excepturi perspiciatis perferendis! Accusantium, quibusdam nemo.");
        textLabel.setWrappingWidth(630);
        
        Button button = new Button("Clique aqui");
        button.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Bem vindo ao meu site interativo em Java Effects!");
            alert.showAndWait();
        });
        button.setStyle("-fx-background-color: #00a8ff; -fx-text-fill: white;");
        
        Text addtionalTitleLabel = new Text ("Seção Importante");
        addtionalTitleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Text additionalTextLabel = new Text("Lorem ipsum dolor sit amet consectetur, amet mollitia nam nostrum possimus, doloribus natus provident? Ipsam adipisci vitae assumenda. Ut unde autem totam mollitia beatae sint debitis amet quam repudiandae laudantium, esse molestiae cupiditate fugit explicabo dolorum, omnis quos ipsum voluptatem consequatur quis libero voluptas. Nobis, laboriosam aliquid possimus atque unde pariatur rem veniam itaque dolorum repellat molestias, incidunt debitis est accusamus voluptas reiciendis, accusantium mollitia voluptates quisquam. Vitae magnam dolor vero.");
        additionalTextLabel.setWrappingWidth(630);
        Image image = new Image("https://www.unijui.edu.br/images/stories/manual_identidade/marcas/download.php?arquivo=marca.png");
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(image.getHeight() * 0.2);
        imageView.setFitWidth(image.getWidth() * 0.2);
        
        // Crie a ImageView para a imagem da API
        ImageView apiImageView = new ImageView();

        // Crie o botão
        Button apiButton = new Button("Carregar imagem da API");

        // Defina a ação do botão
        apiButton.setOnAction(e -> {
            // URL da API
            String imageUrl = "https://picsum.photos/200/300";
            
            // Crie uma nova imagem a partir da URL
            Image apiImage = new Image(imageUrl);
            
            // Atualize a imagem na ImageView
            apiImageView.setImage(apiImage);
        });

        // Crie o VBox primeiro
        VBox vbox = new VBox(titleLabel, textLabel, button, addtionalTitleLabel, additionalTextLabel, imageView, apiButton, apiImageView);
        vbox.setAlignment(Pos.CENTER);
        
        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: #ccc;");
        
        scene = new Scene(scrollPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}

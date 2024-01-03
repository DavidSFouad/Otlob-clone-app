//Otlob-Clone-App
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/*

author @Hamza Magdy

*/

public class OtlobGUI extends Application {

  
    
    @Override
    public void start(Stage mainstage)throws Exception{
      // First login page (choosing between admin,seller and customer)  
   Pane main = new Pane();
      main.setStyle("-fx-background-color: rgb(255, 222, 0);");
      
      Text Welcome = new Text("Welcome");
        Welcome.setTranslateX(410); 
        Welcome.setTranslateY(150);  
        Welcome.setFont(Font.font("Impact",FontWeight.BOLD,50));
        Welcome.setFill(Color.rgb(98, 42, 123));
        
        
        Text Log = new Text("Login As:");
        Log.setTranslateX(470); 
        Log.setTranslateY(250);
        Log.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,20));
        Log.setFill(Color.rgb(98, 42, 123));
        
      HBox choice = new HBox(80);
      Button Admin = new Button("Admin");
      Button Seller = new Button("Seller");
      Button Customer = new Button("Customer");
      Customer.setOnAction(e -> {
        System.out.println("Button clicked!"); // Replace this with your desired action
    });
    Seller.setOnAction(e -> {
      System.out.println("Button clicked!"); // Replace this with your desired action
  });
  

      Admin.setPrefWidth(200);
      Admin.setPrefHeight(80);
      Seller.setPrefWidth(200);
      Seller.setPrefHeight(80);
      Customer.setPrefWidth(200);
      Customer.setPrefHeight(80);
      Admin.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      Seller.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      Customer.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      Admin.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      Seller.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      Customer.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      
      
      
      choice.setSpacing(50);
      choice.getChildren().addAll(Admin,Seller,Customer);
      choice.setAlignment(Pos.CENTER);
       choice.setTranslateX(150); // Set X position
        choice.setTranslateY(300); // Set Y position
      
      main.getChildren().addAll(choice,Welcome,Log);
  
     
   Scene LoginChoice = new Scene(main,1000,600);
   
  
       
      
       mainstage.setResizable(false);
       mainstage.setTitle("Otlob");
       mainstage.setScene(LoginChoice);
       mainstage.show();
}    
    public static void main(String[] args) {
    launch(args);
    }
   
}

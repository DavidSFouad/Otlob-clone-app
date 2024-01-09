import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/*

author @Hamza Magdy

*/

public class OtlobGUI extends Application {

// role for choice admin/customer/seller IMPORTANT

    static Scanner s = new Scanner(System.in);

    static ArrayList<Admin> adminArrayList = new ArrayList<>();
    static ArrayList<Customer> customerArrayList = new ArrayList<>();
    static ArrayList<Seller> sellerArrayList = new ArrayList<>();
    static ArrayList<Order> orderArrayList = new ArrayList<>();
    static ArrayList<Product> productArrayList = new ArrayList<>();

    static final String adminPath = "D:\\college\\Sophomore fall 23\\OOP\\poject oop\\Otlob-clone-app\\admins.bin";
    static final String customerPath = "D:\\college\\Sophomore fall 23\\OOP\\poject oop\\Otlob-clone-app\\customers.bin";
    static final String sellerPath = "D:\\college\\Sophomore fall 23\\OOP\\poject oop\\Otlob-clone-app\\sellers.bin";
    static final String orderPath = "D:\\college\\Sophomore fall 23\\OOP\\poject oop\\Otlob-clone-app\\orders.bin";
    static final String productPath = "D:\\college\\Sophomore fall 23\\OOP\\poject oop\\Otlob-clone-app\\products.bin";

   public static void loadArrayLists() {
        try {
            try (ObjectInputStream oisAdmins = new ObjectInputStream(new FileInputStream(adminPath))) {
                adminArrayList = (ArrayList<Admin>) oisAdmins.readObject();
            }
            try (ObjectInputStream oisCustomers = new ObjectInputStream(new FileInputStream(customerPath))) {
                customerArrayList = (ArrayList<Customer>) oisCustomers.readObject();
            }
            try (ObjectInputStream oisSellers = new ObjectInputStream(new FileInputStream(sellerPath))) {
                sellerArrayList = (ArrayList<Seller>) oisSellers.readObject();
            }
            try (ObjectInputStream oisOrders = new ObjectInputStream(new FileInputStream(orderPath))) {
                orderArrayList = (ArrayList<Order>) oisOrders.readObject();
            }
            try (ObjectInputStream oisProducts = new ObjectInputStream(new FileInputStream(productPath))) {
                productArrayList = (ArrayList<Product>) oisProducts.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
      }
 
   public static void saveArrayLists() {
        try {
            try (ObjectOutputStream oosAdmins = new ObjectOutputStream(new FileOutputStream(adminPath))) {
                oosAdmins.writeObject(adminArrayList);
            }
            try (ObjectOutputStream oosCustomers = new ObjectOutputStream(new FileOutputStream(customerPath))) {
                oosCustomers.writeObject(customerArrayList);
            }
            try (ObjectOutputStream oosSellers = new ObjectOutputStream(new FileOutputStream(sellerPath))) {
                oosSellers.writeObject(sellerArrayList);
            }
            try (ObjectOutputStream oosOrders = new ObjectOutputStream(new FileOutputStream(orderPath))) {
                oosOrders.writeObject(orderArrayList);
            }
            try (ObjectOutputStream oosProducts = new ObjectOutputStream(new FileOutputStream(productPath))) {
                oosProducts.writeObject(productArrayList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  private String selectedRole;

    
  @Override
    public void start(Stage mainstage)throws Exception{

      loadArrayLists();
//Login page

        Label LoginWelcome = new Label("Welcome Back");
        LoginWelcome.setStyle("-fx-text-fill: rgb(98, 42, 123)");
        LoginWelcome.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 60));
        LoginWelcome.setAlignment(Pos.TOP_CENTER);
        LoginWelcome.setMinHeight(250);

        VBox logSign = new VBox(1000);
        logSign.setSpacing(7);
        logSign.setAlignment(Pos.CENTER);

        Scene LiSu = new Scene(logSign, 1000, 600);
        Label LoginLabel = new Label("Enter Username:");

        LoginLabel.setStyle("-fx-text-fill: rgb(98, 42, 123)");
        LoginLabel.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

        TextField Logintype = new TextField();
        
        Logintype.setMaxSize(110, 110);
        Label LoginPass = new Label("Enter Password:");
        LoginPass.setStyle("-fx-text-fill: rgb(98, 42, 123)");
        LoginPass.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

        Button goToSignup = new Button("Click here to SignUp");
        goToSignup.setStyle("-fx-font-size: 14px; " + "-fx-underline: true;");
        goToSignup.setFont(Font.font(STYLESHEET_MODENA));
        goToSignup.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 0px;");
        
        Button home = new Button("Go Back");
        home.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
        home.setAlignment(Pos.TOP_LEFT);
        HBox lay = new HBox(home);

        Button Login = new Button("Login");
        

        TextField LoginEnter = new TextField();
        LoginEnter.setMaxSize(110, 110);
        logSign.getChildren().addAll(lay, LoginWelcome, LoginLabel, Logintype, LoginPass, LoginEnter, goToSignup, Login);
        logSign.setStyle("-fx-background-color: rgb(255, 222, 0);");

     

     //Sign up scene
     BorderPane signup = new BorderPane();
     signup.setPrefSize(1000,600);
     Scene signupscene = new Scene(signup,1000,600);
     goToSignup.setOnAction(e->mainstage.setScene(signupscene));
     
     Label ere = new Label("Welcome !!");
     ere.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      ere.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,60));
     ere.setMinSize(30, 30);
    BorderPane.setAlignment(ere, Pos.TOP_CENTER);
        signup.setTop(ere);
     signup.setStyle("-fx-background-color: rgb(255, 222, 0);");
     
     Label enterusr = new Label("Enter Username: ");
     TextField signupusr = new TextField();
     Label enterpass = new Label("Enter Password: ");
     TextField signuppass = new TextField();
     
    
     enterpass.setStyle("-fx-text-fill: rgb(98, 42, 123)");
     enterusr.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      enterusr.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,30));
      enterpass.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,30));
       
      Button SignupB = new Button("Create Account");
      
      
      signupusr.setMaxWidth(110);
     
      signuppass.setMaxWidth(110);  
      
      //go back button
      Button back = new Button("Go Back");
      signup.setTop(back);
      signup.setStyle("-fx-background-color: rgb(255, 222, 0);");
      back.setOnMouseClicked(e-> mainstage.setScene(LiSu));
      back.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
     
      
       Label crt = new Label("Create a new account: ");
        crt.setStyle("-fx-text-fill: rgb(98, 42, 123)");
        crt.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
        BorderPane.setAlignment(crt, Pos.TOP_CENTER);
        
      //allignment
    VBox box = new VBox(20,crt,enterusr,signupusr,enterpass,signuppass,SignupB);
    box.setSpacing(13);
    box.setAlignment(Pos.CENTER); 
        box.setPrefWidth(60);
        signup.setCenter(box);
   
// Choice page (choosing between admin,seller and customer)  
      Pane main = new Pane();
      main.setStyle("-fx-background-color: rgb(255, 222, 0);");
      
      Text Welcome = new Text("Welcome");
        Welcome.setTranslateX(405); 
        Welcome.setTranslateY(150);  
        Welcome.setFont(Font.font("Impact",FontWeight.BOLD,50));
        Welcome.setFill(Color.rgb(98, 42, 123));
        
        
        Text Log = new Text("Login As:");
        Log.setTranslateX(465); 
        Log.setTranslateY(250);
        Log.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,20));
        Log.setFill(Color.rgb(98, 42, 123));
        
      HBox choice = new HBox(80);
      Button Admin = new Button("Admin");
      Button Seller = new Button("Seller");
      Button Customer = new Button("Customer");
      
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
      
      
 
      home.setOnMouseClicked(e-> mainstage.setScene(LoginChoice));
      
    //admin scene 
      StackPane adminpane = new StackPane();
      Scene adminscene = new Scene(adminpane,1000,600);
      
      Admin.setOnAction(e -> {
    selectedRole = "Admin";
    mainstage.setScene(LiSu);});
      
      adminpane.setStyle("-fx-background-color: rgb(255, 222, 0);");
        //Home button to go to homepage(login page)
        Button homepageA = new Button("Home Page");
       homepageA.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
       homepageA.setAlignment(Pos.TOP_LEFT);
       homepageA.setOnAction(e -> mainstage.setScene(LoginChoice));
      
       Label adminwlcm = new Label("Welcome Admin !");
       adminwlcm.setAlignment(Pos.TOP_CENTER);
        adminwlcm.setStyle("-fx-text-fill: rgb(98, 42, 123)");
        adminwlcm.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));

        VBox adminContent = new VBox(adminwlcm);
        VBox.setVgrow(adminContent, Priority.ALWAYS);
        adminContent.setPadding(new Insets(0,0,0,400));

        HBox topBar = new HBox(homepageA);
        topBar.setAlignment(Pos.TOP_LEFT);
        topBar.setPadding(new Insets(10));

        adminpane.getChildren().addAll(adminContent, topBar);
      
       //seller scene
       GridPane sellerpane = new GridPane();
       Scene sellerscene = new Scene(sellerpane,1000,600);
        
       Seller.setOnAction(e -> {
    selectedRole = "Seller";
    mainstage.setScene(LiSu);});
       
       sellerpane.setStyle("-fx-background-color: rgb(255, 222, 0);");
       //Home button to go to homepage(login page)
        Button homepageS = new Button("Home Page");
       homepageS.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
       homepageS.setOnAction(e -> mainstage.setScene(LoginChoice));
      
       Label sellerwlcm = new Label("Welcome Seller !");
        sellerwlcm.setStyle("-fx-text-fill: rgb(98, 42, 123)");
        sellerwlcm.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
     VBox sellerContent = new VBox(sellerwlcm);
        VBox.setVgrow(sellerContent, Priority.ALWAYS);
        sellerContent.setPadding(new Insets(0,0,0,400));

        HBox topBar2 = new HBox(homepageS);
        topBar2.setAlignment(Pos.TOP_LEFT);
        topBar2.setPadding(new Insets(10));

        sellerpane.getChildren().addAll(sellerContent, topBar2);
       
    //customer scene
     GridPane customerpane = new GridPane();
       Scene customerscene = new Scene(customerpane,1000,600);
        
        Customer.setOnAction(e -> {
    selectedRole = "Customer";
    mainstage.setScene(LiSu);});
        
        customerpane.setStyle("-fx-background-color: rgb(255, 222, 0);");
       //Home button to go to homepage(login page)
        Button homepageC = new Button("Home Page");
       homepageC.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
       homepageC.setOnAction(e -> mainstage.setScene(LoginChoice));
      
       Label userwlcm = new Label("Welcome Customer !");

        userwlcm.setStyle("-fx-text-fill: rgb(98, 42, 123)");
        userwlcm.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
        VBox userContent = new VBox(userwlcm);
        VBox.setVgrow(userContent, Priority.ALWAYS);
        userContent.setPadding(new Insets(0,0,0,396));

        HBox topBar3 = new HBox(homepageC);
        topBar3.setAlignment(Pos.TOP_LEFT);
        topBar3.setPadding(new Insets(10));

        customerpane.getChildren().addAll(userContent, topBar3);
   
      
      
     
//Login and signup events 

Login.setOnMouseClicked(e -> {
  
    if (selectedRole != null) {
        
        switch (selectedRole) {
            case "Admin":
                for (Admin admin : adminArrayList) {
                  if(Logintype.getText().equals(admin.getUserName())&&LoginEnter.getText().equals(admin.getUserPassword())){
                    mainstage.setScene(adminscene);
                    break;
                  }
                }
                break;
            case "Seller":
                for (Seller seller : sellerArrayList) {
                  if(Logintype.getText().equals(seller.getUserName())&&LoginEnter.getText().equals(seller.getUserPassword())){
                    mainstage.setScene(sellerscene);
                    break;
                  }
                }
                break;
            case "Customer":
                for (Customer customer : customerArrayList) {
                  if(Logintype.getText().equals(customer.getUserName())&&LoginEnter.getText().equals(customer.getUserPassword())){
                    mainstage.setScene(customerscene);
                    break;
                  }
                }
                break;
            default:
               
                break;
        }
    } else {
        
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Role Selection");
        alert.setHeaderText(null);
        alert.setContentText("Please go back and select Admin/Seller/Customer.");
        alert.showAndWait();
    }
});

SignupB.setOnMouseClicked(e -> {
    if (selectedRole != null) {
      boolean found = false;
        switch (selectedRole) {
            case "Admin":
            for (Admin admin : adminArrayList){
              if (admin.getUserName().equals(Logintype.getText()) && admin.getUserPassword().equals(LoginEnter.getText())) {
                  found = true;
                  break;
              }
          }

          if (found){
              Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("User already exist");
               alert.setHeaderText(null);
               alert.setContentText("Please login");
               alert.showAndWait();
               mainstage.setScene(LiSu);
               break;
              
          } else {
              int id = adminArrayList.size() + 1;
              Admin adminLoggedIn = new Admin(Logintype.getText(),LoginEnter.getText() ,id);
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("logged in");
              alert.setHeaderText(null);
              alert.setContentText("account add successfully");
              alert.showAndWait();
              adminArrayList.add(adminLoggedIn);
            
          }
                mainstage.setScene(adminscene);
                break;
            case "Seller":
                for (Seller seller : sellerArrayList){
              if (seller.getUserName().equals(Logintype.getText()) && seller.getUserPassword().equals(LoginEnter.getText())) {
                  found = true;
                  break;
              }
            }

          if (found){
              Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("User already exist");
               alert.setHeaderText(null);
               alert.setContentText("Please login");
               alert.showAndWait();
               mainstage.setScene(LiSu);
               break;

              
          } else {
              int id = sellerArrayList.size() + 1;
              Seller sellerLoggedIn = new Seller(Logintype.getText(),LoginEnter.getText() ,id);
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("logged in");
              alert.setHeaderText(null);
              alert.setContentText("account add successfully");
              alert.showAndWait();
              sellerArrayList.add(sellerLoggedIn);
            
          }
                mainstage.setScene(sellerscene);
                break;
            case "Customer":
            for (Customer customer : customerArrayList){
              if (customer.getUserName().equals(Logintype.getText()) && customer.getUserPassword().equals(LoginEnter.getText())) {
                  found = true;
                  break;
              }
          }

          if (found){
               Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("alert");
               alert.setHeaderText(null);
               alert.setContentText("user already exist Please login");
               alert.showAndWait();
               mainstage.setScene(LiSu);
               break;
              
          } else {
              int id = customerArrayList.size() + 1;
              Customer customerLoggedIn = new Customer(Logintype.getText(),LoginEnter.getText() ,id);
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("logged in");
              alert.setHeaderText(null);
              alert.setContentText("account add successfully");
              alert.showAndWait();
              customerArrayList.add(customerLoggedIn);
            
          }
                mainstage.setScene(customerscene);
                break;
            default:
                // Handle unexpected case
                break;
        }
    } else {
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Role Selection");
        alert.setHeaderText(null);
        alert.setContentText("Please go back and select Admin/Seller/Customer.");
        alert.showAndWait();
    }
});

        
       //icon setup + mainstage showing

       mainstage.getIcons().add(new javafx.scene.image.Image("image.jpg"));
       mainstage.setResizable(false);
       mainstage.setTitle("Otlob");
       mainstage.setScene(LoginChoice);// <---Always set to LoginChoice
       mainstage.show();
    }  
  
    void setscene(Button butt ,Scene role, Stage main){
      butt.setOnMouseClicked(e->main.setScene(role));
    }

    public static void main(String[] args) {
    
        loadArrayLists();
        System.out.println("data loaded");
        launch(args);
        saveArrayLists();
        System.out.println("data saved");

    }
   
}
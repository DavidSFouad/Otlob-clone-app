import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
        LoginWelcome.setMinHeight(200);

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
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //admin scene 
      VBox adminbox = new VBox(20);
      Scene adminscene = new Scene(adminbox,1000,600);
      adminbox.setAlignment(Pos.TOP_CENTER);
      Admin.setOnAction(e -> {
    selectedRole = "Admin";
    mainstage.setScene(LiSu);});
      
      adminbox.setStyle("-fx-background-color: rgb(255, 222, 0);");
        //Home button to go to homepage(login page)
        Button homepageA = new Button("Logout");
       homepageA.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
       homepageA.setAlignment(Pos.TOP_LEFT);
       homepageA.setOnAction(e -> mainstage.setScene(LiSu));
      
       Label adminwlcm = new Label("Welcome Admin !");
       //adminwlcm.setAlignment(Pos.TOP_CENTER);
        adminwlcm.setStyle("-fx-text-fill: rgb(98, 42, 123)");
        adminwlcm.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
        adminwlcm.setPrefHeight(100);

        Text adminmenu = new Text("Admin menu :");
        //adminmenu.setTranslateX(50); 
        //adminmenu.setTranslateY(50);
        adminmenu.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,20));
        adminmenu.setFill(Color.rgb(98, 42, 123));
        
       /* VBox adminContent = new VBox(adminwlcm,adminmenu);
        VBox.setVgrow(adminContent, Priority.ALWAYS);
        adminContent.setPadding(new Insets(0,0,0,400));

        */ 
        HBox topBar = new HBox(homepageA);
        topBar.setAlignment(Pos.TOP_LEFT);
        topBar.setPadding(new Insets(10));

        
        
        
      HBox choice2 = new HBox(80);
      Button manage = new Button("Manage");
      Button view = new Button("View");
      
      
      manage.setPrefWidth(200);
      manage.setPrefHeight(80);
      view.setPrefWidth(200);
      view.setPrefHeight(80);
      
      manage.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      view.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      manage.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      view.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      
   
      choice2.setSpacing(50);
      choice2.getChildren().addAll(manage,view);
      choice2.setAlignment(Pos.CENTER);
       choice2.setTranslateX(0); // Set X position
        choice2.setTranslateY(0); // Set Y position

        
      adminbox.getChildren().addAll(topBar,adminwlcm,adminmenu,choice2);
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
       homepageS.setOnAction(e -> mainstage.setScene(LiSu));
      
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
       homepageC.setOnAction(e -> mainstage.setScene(LiSu));
      
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
   
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //manage scene
   
   VBox manageBox=new VBox(1000);
      manageBox.setSpacing(40);
      manageBox.setAlignment(Pos.CENTER); 
      manageBox.setPrefWidth(60);
   Scene managescene=new Scene(manageBox,1000,600);  
   manage.setOnAction(e->{mainstage.setScene(managescene);}); 
     
   manageBox.setStyle("-fx-background-color: rgb(255, 222, 0);");
   Button back2 =new Button("Back");
   back2.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   back2.setOnAction(e -> mainstage.setScene(adminscene));

   HBox topBar4 = new HBox(back2);
   topBar4.setAlignment(Pos.TOP_LEFT);
   topBar4.setPadding(new Insets(10));

   Text managedash=new Text("Manage Dashboard");
   managedash.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,40));
   managedash.setFill(Color.rgb(98, 42, 123));

   Text sellertitle=new Text("Seller");
   sellertitle.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,30));
   sellertitle.setFill(Color.rgb(98, 42, 123));

   HBox choice3 = new HBox(80);
      Button add = new Button("Add");
      Button edit = new Button("Edit");
      Button search = new Button("Search");
      Button remove = new Button("Remove");

      add.setPrefWidth(100);
      add.setPrefHeight(50);
      edit.setPrefWidth(100);
      edit.setPrefHeight(50);
      search.setPrefWidth(100);
      search.setPrefHeight(50);
      remove.setPrefWidth(150);
      remove.setPrefHeight(50);
      
      add.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      edit.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      search.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      remove.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      
      add.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      edit.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      search.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      remove.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      
   
      choice3.setSpacing(50);
      choice3.getChildren().addAll(add,edit,search,remove);
      choice3.setAlignment(Pos.CENTER);
      choice3.setTranslateX(0); // Set X position
      choice3.setTranslateY(0); // Set Y position

     Text customertitle=new Text("Customer");
     customertitle.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,30));
     customertitle.setFill(Color.rgb(98, 42, 123));

     HBox choice4 = new HBox(80);
      Button addc = new Button("Add");
      Button editc = new Button("Edit");
      Button searchc = new Button("Search");
      Button removec = new Button("Remove");

      addc.setPrefWidth(100);
      addc.setPrefHeight(50);
      editc.setPrefWidth(100);
      editc.setPrefHeight(50);
      searchc.setPrefWidth(100);
      searchc.setPrefHeight(50);
      removec.setPrefWidth(150);
      removec.setPrefHeight(50);
      
      addc.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      editc.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      searchc.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      removec.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      
      addc.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      editc.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      searchc.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      removec.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      
   
      choice4.setSpacing(50);
      choice4.getChildren().addAll(addc,editc,searchc,removec);
      choice4.setAlignment(Pos.CENTER);
      choice4.setTranslateX(0); // Set X position
      choice4.setTranslateY(0); // Set Y position

      


   manageBox.getChildren().addAll(topBar4,managedash,sellertitle,choice3,customertitle,choice4);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //add seller scene
      
      VBox sellerbox = new VBox(1000);
      sellerbox.setSpacing(5);
      sellerbox.setAlignment(Pos.TOP_CENTER);

      Scene addsellerscene=new Scene(sellerbox,1000,600);
      add.setOnAction(e->{mainstage.setScene(addsellerscene);});

      Button back3 =new Button("Back");
      back3.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      back3.setOnAction(e -> mainstage.setScene(managescene));

      HBox topBar5 = new HBox(back3);
      topBar5.setAlignment(Pos.TOP_LEFT);
      topBar5.setPadding(new Insets(50));
      

      Button back4 =new Button("Back");
      back4.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      back4.setOnAction(e -> mainstage.setScene(managescene));

      HBox topBar6 = new HBox(back3);
      topBar6.setAlignment(Pos.TOP_LEFT);
      topBar6.setPadding(new Insets(50));

      Label addsellertitle=new Label("Add Seller Data");
      addsellertitle.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      addsellertitle.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 40));
      addsellertitle.setAlignment(Pos.TOP_CENTER);
      addsellertitle.setMinHeight(150);

      Label sellername = new Label("Enter Seller Name:");
      sellername.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      sellername.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

      TextField addsellerNfield = new TextField();
      addsellerNfield.setMaxSize(110, 110);
        
      Label addsellerpass = new Label("Enter Password:");
      addsellerpass.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      addsellerpass.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

      TextField addsellerPfield = new TextField();
      addsellerPfield.setMaxSize(110, 110);

      Button addseller = new Button("Add Seller");
      addseller.setOnAction(e->{
        if (addsellerNfield.getText().isBlank()||addsellerPfield.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("please fill in the data first");
        alert.showAndWait();
        }
       else{ int id = sellerArrayList.size() +1;
        Seller newSeller = new Seller(addsellerNfield.getText(), addsellerPfield.getText(), id);
        System.out.println("New Seller Account Created for " + newSeller.getUserName());
        sellerArrayList.add(newSeller);
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("New Seller added");
        alert.setHeaderText(null);
        alert.setContentText("Operation success");
        alert.showAndWait();
        for (Seller seller : sellerArrayList) {
            System.out.println(seller.getUserName()+" "+seller.getUserPassword());
        }
    }});
    
      
      sellerbox.getChildren().addAll(topBar6,addsellertitle,sellername,addsellerNfield,addsellerpass,addsellerPfield,addseller);
      sellerbox.setStyle("-fx-background-color: rgb(255, 222, 0);");

      
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //edit seller scene
   VBox adminSearchBox = new VBox(20); // Adjust spacing as needed
adminSearchBox.setAlignment(Pos.CENTER); // Center elements vertically
Scene adminSearchScene = new Scene(adminSearchBox, 1000, 600);
edit.setOnAction(e->{mainstage.setScene(adminSearchScene);});
adminSearchBox.setStyle("-fx-background-color: rgb(255, 222, 0);");

Button backedit =new Button("Back");
backedit.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
backedit.setOnAction(e -> mainstage.setScene(managescene));

HBox topBaredit = new HBox(backedit);
topBaredit.setAlignment(Pos.TOP_LEFT);
topBaredit.setPadding(new Insets(50));

Label searchLabel = new Label("Search Sellers by Name:");
searchLabel.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
searchLabel.setTextFill(Color.rgb(98, 42, 123));

TextField searchField = new TextField();
searchField.setPromptText("Enter seller name");
searchField.setPrefWidth(300);

Button searchButton = new Button("Search");
searchButton.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
searchButton.setOnAction(e -> {
    String searchName = searchField.getText();
    if (!searchName.isEmpty()) {
        // Search functionality
        ArrayList<Seller> matchedSellers = new ArrayList<>();
        for (Seller seller : sellerArrayList) {
            if (seller.getUserName().equalsIgnoreCase(searchName)) {
                matchedSellers.add(seller);
            }
        }
        
        // Update the content without clearing the existing nodes
        VBox sellerInfoBox = new VBox(10);
        adminSearchBox.getChildren().remove(sellerInfoBox); // Remove previous content if any

        if (!matchedSellers.isEmpty()) {
            for (Seller matchedSeller : matchedSellers) {
                HBox sellerRow = new HBox(10);
                sellerRow.setAlignment(Pos.CENTER);
                TextField sellerNameField = new TextField(matchedSeller.getUserName());
                int sellid=matchedSeller.getSellerID();
                Label sellerid=new Label("Seller id :"+sellid);
                Button editButton = new Button("Edit");
                editButton.setOnAction(event -> {
                    // Perform edit on seller's name
                    matchedSeller.setUserName(sellerNameField.getText());
                    // You may update your data model or perform other actions as needed
                });

                sellerRow.getChildren().addAll(new Label("Seller Name:"), sellerNameField,sellerid, editButton);
                sellerInfoBox.getChildren().add(sellerRow);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data missing");
            alert.setHeaderText(null);
            alert.setContentText("no seller found with that name");
            alert.showAndWait();
        }

        adminSearchBox.getChildren().add(sellerInfoBox);
    } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Blank entry");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a seller name to search.");
            alert.showAndWait();
    }
});

HBox searchBox = new HBox(20);
searchBox.getChildren().addAll(topBaredit,searchLabel, searchField, searchButton);
searchBox.setAlignment(Pos.CENTER); // Center elements horizontally

VBox.setMargin(searchBox, new Insets(50)); // Adjust vertical margin

adminSearchBox.getChildren().addAll(searchBox);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //search seller scene

   VBox sellerSearch = new VBox(20); // Adjust spacing as needed
sellerSearch.setAlignment(Pos.CENTER); // Center elements vertically
Scene sellerSearchScene = new Scene(sellerSearch, 1000, 600);
search.setOnAction(e -> { mainstage.setScene(sellerSearchScene); });
sellerSearch.setStyle("-fx-background-color: rgb(255, 222, 0);");

Button backToManageSellers = new Button("Back");
backToManageSellers.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
backToManageSellers.setOnAction(e -> mainstage.setScene(managescene));

HBox topSellerSearch = new HBox(backToManageSellers);
topSellerSearch.setAlignment(Pos.TOP_LEFT);
topSellerSearch.setPadding(new Insets(50));

Label searchLSeller = new Label("Search Sellers:");
searchLSeller.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
searchLSeller.setTextFill(Color.rgb(98, 42, 123));

TextField searchFSeller = new TextField();
searchFSeller.setPromptText("Enter seller name");
searchFSeller.setPrefWidth(300);

Button searchBSeller = new Button("Search");
searchBSeller.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
searchBSeller.setOnAction(e -> {
    String searchName = searchFSeller.getText();
    if (!searchName.isEmpty()) {
        // Search functionality
        ArrayList<Seller> matchedSellers = new ArrayList<>();
        for (Seller seller : sellerArrayList) {
            if (seller.getUserName().equalsIgnoreCase(searchName)) {
                matchedSellers.add(seller);
            }
        }
        
        // Update the content without clearing the existing nodes
        VBox sellerInfoBox = new VBox(10);
        sellerSearch.getChildren().remove(sellerInfoBox); // Remove previous content if any

        if (!matchedSellers.isEmpty()) {
            for (Seller matchedSeller : matchedSellers) {
                HBox sellerRow = new HBox(10);
                sellerRow.setAlignment(Pos.CENTER);
                TextField sellerNameField = new TextField(matchedSeller.getUserName());
                int sellerId = matchedSeller.getSellerID();
                Label sellerIdLabel = new Label("Seller ID: " + sellerId);
                

                sellerRow.getChildren().addAll(new Label("Seller Found:"), sellerNameField, sellerIdLabel);
                sellerInfoBox.getChildren().add(sellerRow);
            }
        } else {
           Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data missing");
            alert.setHeaderText(null);
            alert.setContentText("No seller found with that name");
            alert.showAndWait();
        }

        sellerSearch.getChildren().add(sellerInfoBox);
    } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Blank entry");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a seller name to search.");
        alert.showAndWait();
    }
});
HBox searchBoSeller = new HBox(20);
searchBoSeller.getChildren().addAll(topSellerSearch, searchLSeller, searchFSeller, searchBSeller);
searchBoSeller.setAlignment(Pos.CENTER); // Center elements horizontally

VBox.setMargin(searchBoSeller, new Insets(50)); // Adjust vertical margin

sellerSearch.getChildren().addAll(searchBoSeller);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //remove seller scene

   VBox deleteSellerBox = new VBox(20); // Adjust spacing as needed
deleteSellerBox.setAlignment(Pos.CENTER); // Center elements vertically
Scene deleteSellerScene = new Scene(deleteSellerBox, 1000, 600);
remove.setOnAction(e -> { mainstage.setScene(deleteSellerScene); });
deleteSellerBox.setStyle("-fx-background-color: rgb(255, 222, 0);");

Button backEdit = new Button("Back");
backEdit.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
backEdit.setOnAction(e -> mainstage.setScene(managescene));

HBox topBarEdit = new HBox(backEdit);
topBarEdit.setAlignment(Pos.TOP_LEFT);
topBarEdit.setPadding(new Insets(50));

Label searchLabeld = new Label("Search Sellers by Name:");
searchLabeld.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
searchLabeld.setTextFill(Color.rgb(98, 42, 123));

TextField searchField2 = new TextField();
searchField2.setPromptText("Enter seller name");
searchField2.setPrefWidth(300);

Button searchButton2 = new Button("Search");
searchButton2.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
searchButton2.setOnAction(e -> {
    String searchName = searchField2.getText();
    if (!searchName.isEmpty()) {
        // Search functionality
        ArrayList<Seller> matchedSellers = new ArrayList<>();
        for (Seller seller : sellerArrayList) {
            if (seller.getUserName().equalsIgnoreCase(searchName)) {
                matchedSellers.add(seller);
            }
        }
        
        if (!matchedSellers.isEmpty()) {
            // Confirmation alert before deletion
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirm Deletion");
            confirmationAlert.setHeaderText(null);
            confirmationAlert.setContentText("Are you sure you want to delete all sellers with the name: '" + searchName + "'?");

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Remove all matched sellers from the array list
                sellerArrayList.removeAll(matchedSellers);
                Alert deletionAlert = new Alert(Alert.AlertType.INFORMATION);
                deletionAlert.setTitle("Deletion Success");
                deletionAlert.setHeaderText(null);
                deletionAlert.setContentText("All sellers with the name: '" + searchName + "' have been deleted.");
                deletionAlert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data missing");
            alert.setHeaderText(null);
            alert.setContentText("No seller found with that name");
            alert.showAndWait();
        }
     } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Blank entry");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a seller name to search.");
        alert.showAndWait();
    }
});

HBox searchBox2 = new HBox(20);
searchBox2.getChildren().addAll(topBarEdit, searchLabeld, searchField2, searchButton2);
searchBox2.setAlignment(Pos.CENTER); // Center elements horizontally

VBox.setMargin(searchBox2, new Insets(50)); // Adjust vertical margin

deleteSellerBox.getChildren().addAll(searchBox2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //add customer scene
   VBox customerbox = new VBox(1000);
      customerbox.setSpacing(5);
      customerbox.setAlignment(Pos.TOP_CENTER);

      Scene addcustomerscene=new Scene(customerbox,1000,600);
      addc.setOnAction(e->{mainstage.setScene(addcustomerscene);});

      Button back5 =new Button("Back");
      back5.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      back5.setOnAction(e -> mainstage.setScene(managescene));

      HBox topBar7 = new HBox(back5);
      topBar7.setAlignment(Pos.TOP_LEFT);
      topBar7.setPadding(new Insets(50));
      
      Label addcustomertitle=new Label("Add Customer Data");
      addcustomertitle.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      addcustomertitle.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 40));
      addcustomertitle.setAlignment(Pos.TOP_CENTER);
      addcustomertitle.setMinHeight(150);

      Label customername = new Label("Enter Customer Name:");
      customername.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      customername.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

      TextField addcustomerNfield = new TextField();
      addcustomerNfield.setMaxSize(110, 110);
        
      Label addcustomerpass = new Label("Enter Password:");
      addcustomerpass.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      addcustomerpass.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

      TextField addcustomerPfield = new TextField();
      addcustomerPfield.setMaxSize(110, 110);

      Button addcustomer = new Button("Add Customer");
      addcustomer.setOnAction(e->{
        if (addcustomerNfield.getText().isBlank()||addcustomerPfield.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("please fill in the data first");
        alert.showAndWait();
        }
       else{ int id = customerArrayList.size() +1;
        Customer newCustomer = new Customer(addcustomerNfield.getText(), addcustomerPfield.getText(), id);
        System.out.println("New Customer Account Created for " + newCustomer.getUserName());
        customerArrayList.add(newCustomer);
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("New Customer added");
        alert.setHeaderText(null);
        alert.setContentText("Operation success");
        alert.showAndWait();
        /*for (Seller seller : sellerArrayList) {
            System.out.println(seller.getUserName()+" "+seller.getUserPassword());
        }*/
    }});
    
      
      customerbox.getChildren().addAll(topBar7,addcustomertitle,customername,addcustomerNfield,addcustomerpass,addcustomerPfield,addcustomer);
      customerbox.setStyle("-fx-background-color: rgb(255, 222, 0);");
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //edit customer scene
VBox customerSearchBox = new VBox(20); // Adjust spacing as needed
customerSearchBox.setAlignment(Pos.CENTER); // Center elements vertically
Scene customerSearchScene = new Scene(customerSearchBox, 1000, 600);
editc.setOnAction(e->{mainstage.setScene(customerSearchScene);});
customerSearchBox.setStyle("-fx-background-color: rgb(255, 222, 0);");

Button backToManageScene = new Button("Back");
backToManageScene.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
backToManageScene.setOnAction(e -> mainstage.setScene(managescene));

HBox topBarCustomerSearch = new HBox(backToManageScene);
topBarCustomerSearch.setAlignment(Pos.TOP_LEFT);
topBarCustomerSearch.setPadding(new Insets(50));

Label searchLabelCustomer = new Label("Search Customers by Name:");
searchLabelCustomer.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
searchLabelCustomer.setTextFill(Color.rgb(98, 42, 123));

TextField searchFieldCustomer = new TextField();
searchFieldCustomer.setPromptText("Enter customer name");
searchFieldCustomer.setPrefWidth(300);

Button searchButtonCustomer = new Button("Search");
searchButtonCustomer.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
searchButtonCustomer.setOnAction(e -> {
    String searchName = searchFieldCustomer.getText();
    if (!searchName.isEmpty()) {
        // Search functionality
        ArrayList<Customer> matchedCustomers = new ArrayList<>();
        for (Customer customer : customerArrayList) {
            if (customer.getUserName().equalsIgnoreCase(searchName)) {
                matchedCustomers.add(customer);
            }
        }
        
        // Update the content without clearing the existing nodes
        VBox customerInfoBox = new VBox(10);
        customerSearchBox.getChildren().remove(customerInfoBox); // Remove previous content if any

        if (!matchedCustomers.isEmpty()) {
            for (Customer matchedCustomer : matchedCustomers) {
                HBox customerRow = new HBox(10);
                customerRow.setAlignment(Pos.CENTER);
                TextField customerNameField = new TextField(matchedCustomer.getUserName());
                int customerId = matchedCustomer.getCustomerID();
                Label customerIdLabel = new Label("Customer ID: " + customerId);
                Button editButton = new Button("Edit");
                editButton.setOnAction(event -> {
                    // Perform edit on customer's name
                    matchedCustomer.setUserName(customerNameField.getText());
                    // You may update your data model or perform other actions as needed
                });

                customerRow.getChildren().addAll(new Label("Customer Name:"), customerNameField, customerIdLabel, editButton);
                customerInfoBox.getChildren().add(customerRow);
            }
        } else {
           Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data missing");
            alert.setHeaderText(null);
            alert.setContentText("no customer found with that name");
            alert.showAndWait();
        }

        customerSearchBox.getChildren().add(customerInfoBox);
    } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Blank entry");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a customer name to search.");
            alert.showAndWait();
    }
});

HBox searchBoxCustomer = new HBox(20);
searchBoxCustomer.getChildren().addAll(topBarCustomerSearch, searchLabelCustomer, searchFieldCustomer, searchButtonCustomer);
searchBoxCustomer.setAlignment(Pos.CENTER); // Center elements horizontally

VBox.setMargin(searchBoxCustomer, new Insets(50)); // Adjust vertical margin

customerSearchBox.getChildren().addAll(searchBoxCustomer);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //search customer scene
   VBox customerSearch = new VBox(20); // Adjust spacing as needed
customerSearch.setAlignment(Pos.CENTER); // Center elements vertically
Scene customerSearchsScene = new Scene(customerSearch, 1000, 600);
searchc.setOnAction(e->{mainstage.setScene(customerSearchsScene);});
customerSearch.setStyle("-fx-background-color: rgb(255, 222, 0);");

Button backToManage = new Button("Back");
backToManage.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
backToManage.setOnAction(e -> mainstage.setScene(managescene));

HBox topCustomerSearch = new HBox(backToManage);
topCustomerSearch.setAlignment(Pos.TOP_LEFT);
topCustomerSearch.setPadding(new Insets(50));

Label searchLCustomer = new Label("Search Customers :");
searchLCustomer.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
searchLCustomer.setTextFill(Color.rgb(98, 42, 123));

TextField searchFCustomer = new TextField();
searchFCustomer.setPromptText("Enter customer name");
searchFCustomer.setPrefWidth(300);

Button searchBCustomer = new Button("Search");
searchBCustomer.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
searchBCustomer.setOnAction(e -> {
    String searchName = searchFCustomer.getText();
    if (!searchName.isEmpty()) {
        // Search functionality
        ArrayList<Customer> matchedCustomers = new ArrayList<>();
        for (Customer customer : customerArrayList) {
            if (customer.getUserName().equalsIgnoreCase(searchName)) {
                matchedCustomers.add(customer);
            }
        }
        
        // Update the content without clearing the existing nodes
        VBox customerInfoBox = new VBox(10);
        customerSearch.getChildren().remove(customerInfoBox); // Remove previous content if any

        if (!matchedCustomers.isEmpty()) {
            for (Customer matchedCustomer : matchedCustomers) {
                HBox customerRow = new HBox(10);
                customerRow.setAlignment(Pos.CENTER);
                TextField customerNameField = new TextField(matchedCustomer.getUserName());
                int customerId = matchedCustomer.getCustomerID();
                Label customerIdLabel = new Label("Customer ID: " + customerId);
                

                customerRow.getChildren().addAll(new Label("Customer Found:"), customerNameField, customerIdLabel);
                customerInfoBox.getChildren().add(customerRow);
            }
        } else {
           Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data missing");
            alert.setHeaderText(null);
            alert.setContentText("no customer found with that name");
            alert.showAndWait();
        }

        customerSearch.getChildren().add(customerInfoBox);
    } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Blank entry");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a customer name to search.");
            alert.showAndWait();
    }
});
HBox searchBoCustomer = new HBox(20);
searchBoCustomer.getChildren().addAll(topCustomerSearch, searchLCustomer, searchFCustomer, searchBCustomer);
searchBoCustomer.setAlignment(Pos.CENTER); // Center elements horizontally

VBox.setMargin(searchBoCustomer, new Insets(50)); // Adjust vertical margin

customerSearch.getChildren().addAll(searchBoCustomer);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //remove customer scene
   VBox deleteCustomerBox = new VBox(20); // Adjust spacing as needed
   deleteCustomerBox.setAlignment(Pos.CENTER); // Center elements vertically
   Scene deleteCustomerScene = new Scene(deleteCustomerBox, 1000, 600);
   removec.setOnAction(e -> { mainstage.setScene(deleteCustomerScene); });
   deleteCustomerBox.setStyle("-fx-background-color: rgb(255, 222, 0);");
   
   Button backRemove = new Button("Back");
   backRemove.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   backRemove.setOnAction(e -> mainstage.setScene(managescene));
   
   HBox topBarRemove = new HBox(backRemove);
   topBarRemove.setAlignment(Pos.TOP_LEFT);
   topBarRemove.setPadding(new Insets(50));
   
   Label searchLabelc = new Label("Search Customers by Name:");
   searchLabelc.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
   searchLabelc.setTextFill(Color.rgb(98, 42, 123));
   
   TextField searchFieldc = new TextField();
   searchFieldc.setPromptText("Enter customer name");
   searchFieldc.setPrefWidth(300);
   
   Button searchButtonc = new Button("Search");
   searchButtonc.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   searchButtonc.setOnAction(e -> {
       String searchName = searchFieldc.getText();
       if (!searchName.isEmpty()) {
           // Search functionality
           ArrayList<Customer> matchedCustomers = new ArrayList<>();
           for (Customer customer : customerArrayList) {
               if (customer.getUserName().equalsIgnoreCase(searchName)) {
                   matchedCustomers.add(customer);
               }
           }
           
           if (!matchedCustomers.isEmpty()) {
               // Confirmation alert before deletion
               Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
               confirmationAlert.setTitle("Confirm Deletion");
               confirmationAlert.setHeaderText(null);
               confirmationAlert.setContentText("Are you sure you want to delete all customers with the name: '" + searchName + "'?");
   
               Optional<ButtonType> result = confirmationAlert.showAndWait();
               if (result.isPresent() && result.get() == ButtonType.OK) {
                   // Remove all matched customers from the array list
                   customerArrayList.removeAll(matchedCustomers);
                   Alert deletionAlert = new Alert(Alert.AlertType.INFORMATION);
                   deletionAlert.setTitle("Deletion Success");
                   deletionAlert.setHeaderText(null);
                   deletionAlert.setContentText("All customers with the name: '" + searchName + "' have been deleted.");
                   deletionAlert.showAndWait();
               }
           } else {
               Alert alert = new Alert(Alert.AlertType.WARNING);
               alert.setTitle("Data missing");
               alert.setHeaderText(null);
               alert.setContentText("No customer found with that name");
               alert.showAndWait();
           }
       } else {
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Blank entry");
           alert.setHeaderText(null);
           alert.setContentText("Please enter a customer name to search.");
           alert.showAndWait();
       }
   });
   
   HBox searchBoxc = new HBox(20);
   searchBoxc.getChildren().addAll(topBarRemove, searchLabelc, searchFieldc, searchButtonc);
   searchBoxc.setAlignment(Pos.CENTER); // Center elements horizontally
   
   VBox.setMargin(searchBoxc, new Insets(50)); // Adjust vertical margin
   
   deleteCustomerBox.getChildren().addAll(searchBoxc);
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //view dashboard scene (seller-customer-orderhistory)
   VBox viewBox=new VBox(1000);
      viewBox.setSpacing(60);
      viewBox.setAlignment(Pos.TOP_CENTER); 
      viewBox.setPrefWidth(80);
   Scene viewscene=new Scene(viewBox,1000,600);  
   view.setOnAction(e->{mainstage.setScene(viewscene);}); 
     
   viewBox.setStyle("-fx-background-color: rgb(255, 222, 0);");
   Button backview =new Button("Back");
   backview.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   backview.setOnAction(e -> mainstage.setScene(adminscene));

   HBox topBarview = new HBox(backview);
   topBarview.setAlignment(Pos.TOP_LEFT);
   topBarview.setPadding(new Insets(10));

   Text viewdash=new Text("View Dashboard");
   viewdash.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,40));
   viewdash.setFill(Color.rgb(98, 42, 123));

   HBox viewoption = new HBox(80);
      Button sellerview = new Button("Seller Data");
      Button customerview = new Button("Customer Data");
      Button orederview = new Button("Order History Data");

      sellerview.setPrefWidth(200);
      sellerview.setPrefHeight(50);
      customerview.setPrefWidth(200);
      customerview.setPrefHeight(50);
      orederview.setPrefWidth(200);
      orederview.setPrefHeight(50);

      sellerview.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      customerview.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      orederview.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      
      sellerview.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      customerview.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      orederview.setFont(Font.font("Impact", FontWeight.BOLD, 22));
   
      viewoption.setSpacing(50);
      viewoption.getChildren().addAll(sellerview,customerview,orederview);
      viewoption.setAlignment(Pos.CENTER);
      viewoption.setTranslateX(0); // Set X position
      viewoption.setTranslateY(0); // Set Y position

      viewBox.getChildren().addAll(topBarview,viewdash,viewoption);


   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //view sellers scene

    VBox viewsellerbox = new VBox(20); // Adjust spacing as needed
    viewsellerbox.setAlignment(Pos.TOP_CENTER); // Center elements vertically
    viewsellerbox.setPadding(new Insets(20));

    Scene viewsellerscene=new Scene(viewsellerbox,1000,600);
    sellerview.setOnAction(e->{mainstage.setScene(viewsellerscene);});
    viewsellerbox.setStyle("-fx-background-color: rgb(255, 222, 0);");

    Button backsellerview =new Button("Back");
   backsellerview.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   

   HBox topBarsellerview = new HBox(backsellerview);
   topBarsellerview.setAlignment(Pos.TOP_LEFT);
   topBarsellerview.setPadding(new Insets(10));
   
   TextArea sellerDataTextArea = new TextArea();
    sellerDataTextArea.setPrefSize(200, 150); // Set preferred size
    sellerDataTextArea.setEditable(false); // Make the text area read-only

    Button refreshseller =new Button("Refresh");
   refreshseller.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   refreshseller.setOnAction(e->{
    StringBuilder sellerData = new StringBuilder();
    for (Seller seller : sellerArrayList) {
    sellerData.append("Name: ").append(seller.getUserName()).append(", Password: ").append(seller.getUserPassword()).append("\n");
    }
    sellerDataTextArea.setText(sellerData.toString());
   });


   Text viewseller=new Text("Seller Data");
   viewseller.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,40));
   viewseller.setFill(Color.rgb(98, 42, 123));

   backsellerview.setOnAction(e -> {
    sellerDataTextArea.clear();
    mainstage.setScene(viewscene);
    });
    
    viewsellerbox.getChildren().addAll(topBarsellerview,viewseller,sellerDataTextArea,refreshseller);
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //view customers scene

    VBox viewcustomerbox = new VBox(20); // Adjust spacing as needed
    viewcustomerbox.setAlignment(Pos.TOP_CENTER); // Center elements vertically
    viewcustomerbox.setPadding(new Insets(20));

    Scene viewcustomerscene=new Scene(viewcustomerbox,1000,600);
    customerview.setOnAction(e->{mainstage.setScene(viewcustomerscene);});
    viewcustomerbox.setStyle("-fx-background-color: rgb(255, 222, 0);");

    Button backcustomerview =new Button("Back");
   backcustomerview.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   backcustomerview.setOnAction(e -> mainstage.setScene(viewscene));

   HBox topBarcustomerview = new HBox(backcustomerview);
   topBarcustomerview.setAlignment(Pos.TOP_LEFT);
   topBarcustomerview.setPadding(new Insets(10));

   TextArea customerDataTextArea = new TextArea();
    customerDataTextArea.setPrefSize(200, 150); // Set preferred size
    customerDataTextArea.setEditable(false); // Make the text area read-only

   Button refresh =new Button("Refresh");
   refresh.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   refresh.setOnAction(e -> {
    StringBuilder customerData = new StringBuilder();
    for (Customer customer : customerArrayList) {
    customerData.append("Name: ").append(customer.getUserName()).append(", Password: ").append(customer.getUserPassword()).append("\n");
    }
    customerDataTextArea.setText(customerData.toString());
   });

   Text viewcustomer=new Text("Customer Data");
   viewcustomer.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,40));
   viewcustomer.setFill(Color.rgb(98, 42, 123));

   
     
    backcustomerview.setOnAction(e -> {
    customerDataTextArea.clear();
    mainstage.setScene(viewscene);
    });

    

    viewcustomerbox.getChildren().addAll(topBarcustomerview,viewcustomer,customerDataTextArea,refresh);



   //view  oreders history scene


//Login and signup events 

Login.setOnMouseClicked(e -> {
  
    if (selectedRole != null) {
        
        switch (selectedRole) {
            case "Admin":
                /*for (Admin admin : adminArrayList) {
                  if(Logintype.getText().equals(admin.getUserName())&&LoginEnter.getText().equals(admin.getUserPassword())){*/
                    mainstage.setScene(adminscene);
                    /*break;
                   }
                }*/
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
        /*for (Seller string : sellerArrayList) {
            System.out.println(string.getUserName());
        }*/
        launch(args);
        saveArrayLists();
        System.out.println("data saved");

    }
   
}
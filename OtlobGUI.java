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
        logSign.setAlignment(Pos.TOP_CENTER);

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
        lay.setAlignment(Pos.TOP_LEFT);
        lay.setPadding(new Insets(15));

        Button Login = new Button("Login");
        
        TextField LoginEnter = new TextField();
        LoginEnter.setMaxSize(110, 110);
        logSign.getChildren().addAll(lay, LoginWelcome, LoginLabel, Logintype, LoginPass, LoginEnter, goToSignup, Login);
        logSign.setStyle("-fx-background-color: rgb(255, 222, 0);");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
      
      Text otlob = new Text("Otlob");
        otlob.setTranslateX(410); 
        otlob.setTranslateY(180);  
        otlob.setFont(Font.font("Impact",FontWeight.BOLD,90));
        otlob.setFill(Color.rgb(98, 42, 123));
        
        Text web = new Text("Web Application");
        web.setTranslateX(410); 
        web.setTranslateY(220);  
        web.setFont(Font.font("Impact",FontWeight.BOLD,30));
        web.setFill(Color.rgb(98, 42, 123));

        Text Welcome = new Text("Welcome to...");
        Welcome.setTranslateX(440); 
        Welcome.setTranslateY(75);  
        Welcome.setFont(Font.font("Impact",FontWeight.BOLD,25));
        Welcome.setFill(Color.rgb(98, 42, 123));
        
        Text Log = new Text("Login As:");
        Log.setTranslateX(465); 
        Log.setTranslateY(270);
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
      
      main.getChildren().addAll(choice,Welcome,Log,otlob,web);
  
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
        
        adminmenu.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,20));
        adminmenu.setFill(Color.rgb(98, 42, 123));
         
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
       Pane sellerpane = new Pane();
       Scene sellerscene = new Scene(sellerpane,1000,600);
        
       Seller.setOnAction(e -> {
    selectedRole = "Seller";
    mainstage.setScene(LiSu);});
       
       sellerpane.setStyle("-fx-background-color: rgb(255, 222, 0);");
       //home button to go to homepage(login page)
        Button homepageS = new Button("Logout");
        homepageS.setLayoutX(10);
       homepageS.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
       homepageS.setOnAction(e -> mainstage.setScene(LoginChoice));
      
       Label sellerwlcm = new Label("Welcome Seller !");
        sellerwlcm.setStyle("-fx-text-fill: rgb(98, 42, 123)");
        sellerwlcm.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
     VBox sellerContent = new VBox(sellerwlcm);
        sellerContent.setLayoutX(400);
        sellerContent.setLayoutY(10);

        HBox topBar2 = new HBox(homepageS);
        topBar2.setAlignment(Pos.TOP_LEFT);
        topBar2.setLayoutY(10);
        topBar2.setLayoutX(10);
        
        Button viewB = new Button("View");
        Button manageB = new Button("Manage");
        HBox sellermenu = new HBox();
        viewB.setPrefWidth(200);
      viewB.setPrefHeight(80);
      manageB.setPrefWidth(200);
      manageB.setPrefHeight(80);
      
      viewB.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      manageB.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      viewB.setFont(Font.font("Impact", FontWeight.BOLD, 22));
      manageB.setFont(Font.font("Impact", FontWeight.BOLD, 22));
        
        sellermenu.setSpacing(50);
        sellermenu.setLayoutY(250);
     sellermenu.setLayoutX(270);
        Label sellerm = new Label("Seller Menu:");
        sellerm.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123)");
      sellerm.setFont(Font.font("Impact", FontWeight.BOLD, 22));
    sellerm.setLayoutY(200);
     sellerm.setLayoutX(440);
      sellermenu.getChildren().addAll(manageB,viewB);
        sellerpane.getChildren().addAll(topBar2,sellermenu,sellerm, sellerContent);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Seller manage Scene

    Label mngDsbd = new Label("Manage Dashboard");
    mngDsbd.setLayoutX(370);
    mngDsbd.setLayoutY(150);
    mngDsbd.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
    mngDsbd.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);");
    
    Button sellerGoBack = new Button("Back");
    sellerGoBack.setLayoutY(10);
    sellerGoBack.setLayoutX(10);
    sellerGoBack.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    Button ViewS = new Button("Search");
    Button RemoveS = new Button("Remove");
    Button AddS = new Button("Add");
    Button EditS = new Button("Edit");
    HBox addEditRemoveSearch = new HBox(AddS,EditS,RemoveS,ViewS);
   
    ViewS.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    RemoveS.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    AddS.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    EditS.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    ViewS.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 22));
    RemoveS.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 22));
    AddS.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 22));
    EditS.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 22));
    
    addEditRemoveSearch.setSpacing(25);
    addEditRemoveSearch.setLayoutX(300);
    addEditRemoveSearch.setLayoutY(300);
    
    Pane sellermanagepane = new Pane(addEditRemoveSearch,sellerGoBack,mngDsbd);
    sellermanagepane.setStyle("-fx-background-color: rgb(255, 222, 0);");
    Scene sellermanagescene = new Scene(sellermanagepane,1000,600);
    manageB.setOnAction(e-> mainstage.setScene(sellermanagescene));
    sellerGoBack.setOnAction(e-> mainstage.setScene(sellerscene));
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Seller View scene
    Label sllrdsbd = new Label("View Dashboard");
     sllrdsbd.setLayoutX(370);
    sllrdsbd.setLayoutY(150);
    sllrdsbd.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
    sllrdsbd.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);");
    sllrdsbd.setMinHeight(150);
    
    Button sllrviewgoback = new Button("Back");
    sllrviewgoback.setLayoutY(10);
    sllrviewgoback.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");    
    
    HBox sellerviewback=new HBox(sllrviewgoback);
    sellerviewback.setAlignment(Pos.TOP_LEFT);
    sellerviewback.setPadding(new Insets(10));

    Button productdata = new Button("Product Data");
    productdata.setAlignment(Pos.CENTER);
    Button orderdata = new Button("Orders Data");
    orderdata.setAlignment(Pos.CENTER);

    HBox viewbox = new HBox(productdata,orderdata);
    viewbox.setSpacing(30);
    viewbox.setAlignment(Pos.CENTER);
   
    productdata.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    orderdata.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    productdata.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 22));
    orderdata.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 22));
    
     VBox sellerviewpane = new VBox(sellerviewback,sllrdsbd,viewbox);
     sellerviewpane.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);");
     sellerviewpane.setAlignment(Pos.TOP_CENTER);
    Scene sellerviewscene = new Scene(sellerviewpane,1000,600);
   
   sllrviewgoback.setOnAction(e-> mainstage.setScene(sellerscene));
   viewB.setOnAction(e->mainstage.setScene(sellerviewscene));
   
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //customer scene
    Pane customerpane = new Pane();
    Scene customerscene = new Scene(customerpane,1000,600);
     
     Customer.setOnAction(e -> {
 selectedRole = "Customer";
 mainstage.setScene(LiSu);});
     
     customerpane.setStyle("-fx-background-color: rgb(255, 222, 0);");
    //Home button to go to homepage(login page)
     Button homepageC = new Button("Logout");
    homepageC.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    homepageC.setOnAction(e -> mainstage.setScene(LoginChoice));
    homepageC.setLayoutY(15);
    
    Label userwlcm = new Label("Welcome Customer !");

     userwlcm.setStyle("-fx-text-fill: rgb(98, 42, 123)");
     userwlcm.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
    userwlcm.setLayoutX(373);
    userwlcm.setLayoutY(10);

     HBox topBar3 = new HBox(homepageC);
     topBar3.setAlignment(Pos.TOP_LEFT);
     topBar3.setPadding(new Insets(10));
     
     Button StartOrdering = new Button("Start Ordering");
     Button TrackOrderHistory = new Button("Track Order History");
     StartOrdering.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
     TrackOrderHistory.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
     TrackOrderHistory.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
     StartOrdering.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
     
     HBox customerminimenu = new HBox(StartOrdering,TrackOrderHistory);
     customerminimenu.setLayoutX(290);
     customerminimenu.setLayoutY(250);
     customerminimenu.setSpacing(15);
     
     Label customerMenu = new Label("Customer Menu");
     customerMenu.setLayoutX(412);
     customerMenu.setLayoutY(200);
     customerMenu.setStyle("-fx-text-fill: rgb(98, 42, 123)");
     customerMenu.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

     customerpane.getChildren().addAll(homepageC,userwlcm,customerMenu,customerminimenu);
     
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //Start Ordering customer scene 
     Pane StartOrderingpane = new Pane();
     Scene StarOrdering = new Scene(StartOrderingpane,1000,600);
     StartOrderingpane.setStyle("-fx-background-color: rgb(255, 222, 0);");
     Label StartOrd = new Label("Start Ordering Dashboard");
     StartOrd.setStyle("-fx-text-fill: rgb(98, 42, 123)");
     StartOrd.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
     StartOrd.setLayoutX(350);

     Button srchvendors = new Button("Search Vendors & Products");
    Button addProductToCart = new Button("Add Product to Cart");
    Button removeProductFromCart = new Button("Remove Product From Cart"); 
    Button clearCart = new Button("Clear Cart");
    Button viewCart = new Button("View Cart");
    Button confirmCart = new Button("Confirm Cart");
    
    srchvendors.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    srchvendors.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

    addProductToCart.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    addProductToCart.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

    removeProductFromCart.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    removeProductFromCart.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

    clearCart.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    clearCart.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

    viewCart.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    viewCart.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

    confirmCart.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    confirmCart.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
            
    HBox actions1= new HBox(srchvendors,addProductToCart,removeProductFromCart);
     actions1.setSpacing(15);
     actions1.setLayoutX(65);
     actions1.setLayoutY(200);
    HBox actions2= new HBox(clearCart,viewCart,confirmCart);
     actions2.setSpacing(15);
     actions2.setLayoutX(260);
     actions2.setLayoutY(300);
     
     Button bacK = new Button("Go Back");
    bacK.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
     
     StartOrdering.setOnAction(e->mainstage.setScene(StarOrdering)); 
    bacK.setOnAction(e->mainstage.setScene(customerscene)); 
 
     StartOrderingpane.getChildren().addAll(bacK,StartOrd,actions1,actions2);

 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //Track Order customer scene
    Pane TrackOrderPane = new Pane();
    TrackOrderPane.setStyle("-fx-background-color: rgb(255, 222, 0);");
    Scene TrackOrder = new Scene(TrackOrderPane,1000,600);
    Button backk = new Button("Go Back");
    backk.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");

    Label TrackOrdr = new Label("Track Order History Dashboard");
    TrackOrdr.setLayoutX(314);
    TrackOrdr.setStyle("-fx-text-fill: rgb(98, 42, 123)");
    TrackOrdr.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 30));
 
    Button viewAllOrderDetails = new Button("View all Orders and their details");
    Button TrackOrderStatus = new Button("View Order Status");
    Button RateOrders = new Button("Rate Order");
 
     RateOrders.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    RateOrders.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
         
     TrackOrderStatus.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    TrackOrderStatus.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
         
     viewAllOrderDetails.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
    viewAllOrderDetails.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
         
    HBox acTions = new HBox(viewAllOrderDetails,TrackOrderStatus,RateOrders);
    acTions.setSpacing(15);
    acTions.setLayoutX(118);
    acTions.setLayoutY(250);
 
    TrackOrderPane.getChildren().addAll(backk,TrackOrdr,acTions);
    TrackOrderHistory.setOnAction(e->mainstage.setScene(TrackOrder));
    backk.setOnAction(e->mainstage.setScene(customerscene));
   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Seller[] sellerLoggedInContainer = new Seller[1];
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
                    if (Logintype.getText().equals(seller.getUserName()) && LoginEnter.getText().equals(seller.getUserPassword())) {
                        sellerLoggedInContainer[0] = seller;
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//seller add product

    VBox selleraddproduct = new VBox(1000);
      selleraddproduct.setSpacing(5);
      selleraddproduct.setAlignment(Pos.TOP_CENTER);

      Scene selleraddproductscene=new Scene(selleraddproduct,1000,600);
      AddS.setOnAction(e->{mainstage.setScene(selleraddproductscene);});

      Button addPback =new Button("Back");
      addPback.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      addPback.setOnAction(e -> mainstage.setScene(sellermanagescene));

      HBox topBaraddP = new HBox(addPback);
      topBaraddP.setAlignment(Pos.TOP_LEFT);
      topBaraddP.setPadding(new Insets(50));
      
      Label addcProducttitle=new Label("Add Product Data");
      addcProducttitle.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      addcProducttitle.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 40));
      addcProducttitle.setAlignment(Pos.TOP_CENTER);
      addcProducttitle.setMinHeight(150);

      Label productname = new Label("Enter Product Name:");
      productname.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      productname.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

      TextField addproductNfield = new TextField();
      addproductNfield.setMaxSize(110, 110);
        
      Label addproductprice = new Label("Enter Product Price");
      addproductprice.setStyle("-fx-text-fill: rgb(98, 42, 123)");
      addproductprice.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));

      TextField addproductPfield = new TextField();
      addproductPfield.setMaxSize(110, 110);

      Button addproduct = new Button("Add Product");
      addproduct.setOnAction(e->{
        if (addproductNfield.getText().isBlank()||addproductPfield.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("please fill in the data first");
        alert.showAndWait();
        }

       else{ int id = productArrayList.size() +1;
        Double price= Double.parseDouble(addproductPfield.getText());
        Product newProduct = new Product(id, addproductNfield.getText(), price);
        sellerLoggedInContainer[0].addProduct(productArrayList, newProduct);
        /*for (Product product : sellerLoggedInContainer[0].sellerProducts) {
            System.out.println(product.productName);
        }
        
        System.out.println(sellerLoggedInContainer[0].sellerProducts);
*/
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("New Product added");
        alert.setHeaderText(null);
        alert.setContentText("Operation success");
        alert.showAndWait();
        /*for (Seller seller : sellerArrayList) {
            System.out.println(seller.getUserName()+" "+seller.getUserPassword());
        }*/
    }});
    
      
      selleraddproduct.getChildren().addAll(topBaraddP,addcProducttitle,productname,addproductNfield,addproductprice,addproductPfield,addproduct);
      selleraddproduct.setStyle("-fx-background-color: rgb(255, 222, 0);");
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      //seller edit product
      VBox selleredithBox = new VBox(20); // Adjust spacing as needed
      selleredithBox.setAlignment(Pos.CENTER); // Center elements vertically
      Scene sellereditScene = new Scene(selleredithBox, 1000, 600);
      EditS.setOnAction(e -> mainstage.setScene(sellereditScene));
      selleredithBox.setStyle("-fx-background-color: rgb(255, 222, 0);");
      
      Button backSEdit = new Button("Back");
      backSEdit.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      
      
      HBox topBarSEdit = new HBox(backSEdit);
      topBarSEdit.setAlignment(Pos.TOP_LEFT);
      topBarSEdit.setPadding(new Insets(50));
      
      Label searchLabelSedit = new Label("Search Products by Name:");
      searchLabelSedit.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
      searchLabelSedit.setTextFill(Color.rgb(98, 42, 123));
      
      TextField searchFieldSedit = new TextField();
      searchFieldSedit.setPromptText("Enter product name");
      searchFieldSedit.setPrefWidth(300);
      
      Button searchButtonSedit = new Button("Search");
      searchButtonSedit.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      searchButtonSedit.setOnAction(e -> {
          String searchName = searchFieldSedit.getText();
          if (!searchName.isEmpty()) {
              // Search functionality
              ArrayList<Product> matchedProducts = new ArrayList<>();
              for (Product product : productArrayList) {
                  if (product.getProductName().equalsIgnoreCase(searchName)) {
                      matchedProducts.add(product);
                  }
              }
      
              // Update the content without clearing the existing nodes
              VBox productInfoBox = new VBox(10);
              selleredithBox.getChildren().remove(productInfoBox); // Remove previous content if any
      
              if (!matchedProducts.isEmpty()) {
                  for (Product matchedProduct : matchedProducts) {
                      HBox productRow = new HBox(10);
                      productRow.setAlignment(Pos.CENTER);
                      TextField productNameField = new TextField(matchedProduct.getProductName());
                      TextField productPriceField = new TextField(String.valueOf(matchedProduct.getProductPrice()));
      
                      int productId = matchedProduct.getProductID();
                      Label productIdLabel = new Label("Product ID: " + productId);
      
                      Button editButton = new Button("Edit");
                      editButton.setOnAction(event -> {
                          // Perform edit on product's name and price
                          matchedProduct.setProductName(productNameField.getText());
                          try {
                              double newPrice = Double.parseDouble(productPriceField.getText());
                              matchedProduct.setProductPrice(newPrice);
                              // You may update your data model or perform other actions as needed
                          } catch (NumberFormatException ex) {
                              Alert alert = new Alert(Alert.AlertType.WARNING);
                              alert.setTitle("Invalid input");
                              alert.setHeaderText(null);
                              alert.setContentText("Please enter a valid price.");
                              alert.showAndWait();
                          }
                      });
      
                      productRow.getChildren().addAll(new Label("Product Name:"), productNameField,
                              new Label("Product Price:"), productPriceField, productIdLabel, editButton);
                      productInfoBox.getChildren().add(productRow);
                  }
              } else {
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                  alert.setTitle("Data missing");
                  alert.setHeaderText(null);
                  alert.setContentText("No product found with that name.");
                  alert.showAndWait();
              }
      
              selleredithBox.getChildren().add(productInfoBox);
          } else {
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Blank entry");
              alert.setHeaderText(null);
              alert.setContentText("Please enter a product name to search.");
              alert.showAndWait();
          }
      });
      
      HBox editBox = new HBox(20);
      editBox.getChildren().addAll(topBarSEdit, searchLabelSedit, searchFieldSedit, searchButtonSedit);
      editBox.setAlignment(Pos.CENTER); // Center elements horizontally
      
      VBox.setMargin(editBox, new Insets(50)); // Adjust vertical margin
      
      selleredithBox.getChildren().addAll(editBox);
      backSEdit.setOnAction(e ->{
        selleredithBox.getChildren().clear();
      selleredithBox.getChildren().addAll(editBox);
      mainstage.setScene(sellermanagescene);}
    );
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// seller remove product
VBox removeProductBox = new VBox(20); // Adjust spacing as needed
removeProductBox.setAlignment(Pos.CENTER); // Center elements vertically
Scene removeProductScene = new Scene(removeProductBox, 1000, 600);
RemoveS.setOnAction(e -> { mainstage.setScene(removeProductScene); });
removeProductBox.setStyle("-fx-background-color: rgb(255, 222, 0);");

Button backsRemove = new Button("Back");
backsRemove.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
backsRemove.setOnAction(e -> mainstage.setScene(sellermanagescene));

HBox topBarsRemove = new HBox(backsRemove);
topBarsRemove.setAlignment(Pos.TOP_LEFT);
topBarsRemove.setPadding(new Insets(50));

Label searchLabelSrem = new Label("Search Products by Name:");
searchLabelSrem.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
searchLabelSrem.setTextFill(Color.rgb(98, 42, 123));

TextField searchFieldsrem = new TextField();
searchFieldsrem.setPromptText("Enter product name");
searchFieldsrem.setPrefWidth(300);

Button searchButtonsrem = new Button("Search");
searchButtonsrem.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
searchButtonsrem.setOnAction(e -> {
    String searchName = searchFieldsrem.getText();
    if (!searchName.isEmpty()) {
        // Search functionality
        ArrayList<Product> matchedProducts = new ArrayList<>();
        for (Product product : sellerLoggedInContainer[0].sellerProducts) {
            if (product.getProductName().equalsIgnoreCase(searchName)) {
                matchedProducts.add(product);
            }
        }
        
        if (!matchedProducts.isEmpty()) {
            // Confirmation alert before deletion
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirm Deletion");
            confirmationAlert.setHeaderText(null);
            confirmationAlert.setContentText("Are you sure you want to delete all products with the name: '" + searchName + "'?");

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Remove all matched products from the array list
                sellerLoggedInContainer[0].sellerProducts.removeAll(matchedProducts);
                productArrayList.removeAll(matchedProducts);
                Alert deletionAlert = new Alert(Alert.AlertType.INFORMATION);
                deletionAlert.setTitle("Deletion Success");
                deletionAlert.setHeaderText(null);
                deletionAlert.setContentText("All products with the name: '" + searchName + "' have been deleted.");
                deletionAlert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Data missing");
            alert.setHeaderText(null);
            alert.setContentText("No product found with that name");
            alert.showAndWait();
        }
     } else {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Blank entry");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a product name to search.");
        alert.showAndWait();
    }
});

HBox searchBoxsrem = new HBox(20);
searchBoxsrem.getChildren().addAll(topBarsRemove, searchLabelSrem, searchFieldsrem, searchButtonsrem);
searchBoxsrem.setAlignment(Pos.CENTER); // Center elements horizontally

VBox.setMargin(searchBoxsrem, new Insets(50)); // Adjust vertical margin

removeProductBox.getChildren().addAll(searchBoxsrem);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//seller search product
VBox sellersearchBox = new VBox(20); // Adjust spacing as needed
      sellersearchBox.setAlignment(Pos.CENTER); // Center elements vertically
      Scene sellersearchScene = new Scene(sellersearchBox, 1000, 600);
      ViewS.setOnAction(e -> mainstage.setScene(sellersearchScene));
      sellersearchBox.setStyle("-fx-background-color: rgb(255, 222, 0);");
      
      Button backSsearch = new Button("Back");
      backSsearch.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      
      
      HBox topBarSsearch = new HBox(backSsearch);
      topBarSsearch.setAlignment(Pos.TOP_LEFT);
      topBarSsearch.setPadding(new Insets(50));
      
      Label searchLabelSsearch = new Label("Search Products by Name:");
      searchLabelSsearch.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
      searchLabelSsearch.setTextFill(Color.rgb(98, 42, 123));
      
      TextField searchFieldSsearch = new TextField();
      searchFieldSsearch.setPromptText("Enter product name");
      searchFieldSsearch.setPrefWidth(300);
      
      Button searchButtonSsearch = new Button("Search");
      searchButtonSsearch.setStyle("-fx-background-color: rgb(255, 222, 0); -fx-text-fill: rgb(98, 42, 123); -fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
      searchButtonSsearch.setOnAction(e -> {
          String searchName = searchFieldSsearch.getText();
          if (!searchName.isEmpty()) {
              // Search functionality
              ArrayList<Product> matchedProducts = new ArrayList<>();
              for (Product product : productArrayList) {
                  if (product.getProductName().equalsIgnoreCase(searchName)) {
                      matchedProducts.add(product);
                  }
              }
      
              // Update the content without clearing the existing nodes
              VBox productInfoBox = new VBox(10);
              selleredithBox.getChildren().remove(productInfoBox); // Remove previous content if any
      
              if (!matchedProducts.isEmpty()) {
                  for (Product matchedProduct : matchedProducts) {
                      HBox productRow = new HBox(10);
                      productRow.setAlignment(Pos.CENTER);
                      TextField productNameField = new TextField(matchedProduct.getProductName());
                      TextField productPriceField = new TextField(String.valueOf(matchedProduct.getProductPrice()));
      
                      int productId = matchedProduct.getProductID();
                      Label productIdLabel = new Label("Product ID: " + productId);
      
                      
      
                      productRow.getChildren().addAll(new Label("Product Name:"), productNameField,
                      new Label("Product Price:"), productPriceField, productIdLabel);
                      productInfoBox.getChildren().add(productRow);
                  }
              } else {
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                  alert.setTitle("Data missing");
                  alert.setHeaderText(null);
                  alert.setContentText("No product found with that name.");
                  alert.showAndWait();
              }
      
              sellersearchBox.getChildren().add(productInfoBox);
          } else {
              Alert alert = new Alert(Alert.AlertType.WARNING);
              alert.setTitle("Blank entry");
              alert.setHeaderText(null);
              alert.setContentText("Please enter a product name to search.");
              alert.showAndWait();
          }
      });
      
      HBox SsearchBox = new HBox(20);
      SsearchBox.getChildren().addAll(topBarSsearch, searchLabelSsearch, searchFieldSsearch, searchButtonSsearch);
      SsearchBox.setAlignment(Pos.CENTER); // Center elements horizontally
      
      VBox.setMargin(SsearchBox, new Insets(50)); // Adjust vertical margin
      
      sellersearchBox.getChildren().addAll(SsearchBox);
      backSsearch.setOnAction(e ->{
        sellersearchBox.getChildren().clear();
      sellersearchBox.getChildren().addAll(SsearchBox);
      mainstage.setScene(sellermanagescene);}
    );
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// seller view products
VBox viewPsellerbox = new VBox(20); // Adjust spacing as needed
    viewPsellerbox.setAlignment(Pos.TOP_CENTER); // Center elements vertically
    viewPsellerbox.setPadding(new Insets(20));

    Scene viewPsellerscene=new Scene(viewPsellerbox,1000,600);
    productdata.setOnAction(e->{mainstage.setScene(viewPsellerscene);});
    viewPsellerbox.setStyle("-fx-background-color: rgb(255, 222, 0);");

    Button backsellerviewP =new Button("Back");
   backsellerviewP.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   

   HBox topBarsellerviewP = new HBox(backsellerviewP);
   topBarsellerviewP.setAlignment(Pos.TOP_LEFT);
   topBarsellerviewP.setPadding(new Insets(10));
   
   TextArea sellerPDataTextArea = new TextArea();
    sellerPDataTextArea.setPrefSize(200, 150); // Set preferred size
    sellerPDataTextArea.setEditable(false); // Make the text area read-only

    Button refreshsellerP =new Button("Refresh");
   refreshsellerP.setStyle("-fx-background-color: rgb(255, 222, 0);-fx-text-fill: rgb(98, 42, 123);-fx-border-color: rgb(98, 42, 123); -fx-border-width: 1px;");
   refreshsellerP.setOnAction(e->{
    StringBuilder productData = new StringBuilder();
    for (Product product : sellerLoggedInContainer[0].sellerProducts) {
    productData.append("Name: ").append(product.getProductName()).append(", Price: ").append(product.getProductPrice()).append("\n");
    }
    sellerPDataTextArea.setText(productData.toString());
   });


   Text viewPseller=new Text("Seller Data");
   viewPseller.setFont(Font.font("Impact",FontWeight.SEMI_BOLD,40));
   viewPseller.setFill(Color.rgb(98, 42, 123));

   backsellerviewP.setOnAction(e -> {
    sellerPDataTextArea.clear();
    mainstage.setScene(sellerviewscene);
    });
    
    viewPsellerbox.getChildren().addAll(topBarsellerviewP,viewPseller,sellerPDataTextArea,refreshsellerP);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // admin manage scene
   
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //view  oreders history scene


//Login and signup events 

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
        for (Product string : productArrayList) {
            System.out.println(string.getProductDetails());
        }
        launch(args);
        saveArrayLists();
        System.out.println("data saved");

    }
   
}
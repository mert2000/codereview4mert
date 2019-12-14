package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;


public class Main extends Application {
    ProdNames prd = new ProdNames("", "", "", 0, 0, "");

    public Main() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Code Review Markt");

        //Labels
        Label lb1 = new Label("PRODUCT NAME:\t");
        Label lb2 = new Label("QUANTITY:" + "\t\t");
        Label lb3 = new Label("OLD PRICE:\t\t");
        Label lb4 = new Label("NEW PRICE:\t\t");
        Label lbEURO = new Label("€");
        Label lbEURO2 = new Label("€");

        //Description
        Label deslblt = new Label("DESCRIPTION:");
        Label deslbl = new Label("Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt.");

        //Textfields
        TextField txt1 = new TextField(prd.getpName());
        TextField txt2 = new TextField(prd.getQuantity());
        TextField txt3 = new TextField(String.valueOf(prd.getOldprice()));
        TextField txt4 = new TextField(String.valueOf(prd.getNewprice()));


        //Images
        InputStream input = this.getClass().getResourceAsStream(prd.getImg().get(0));
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        InputStream input1 = this.getClass().getResourceAsStream(prd.getImg().get(0));
        Image image1 = new Image(input1);
        ImageView imageView1 = new ImageView(image1);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        InputStream input2 = this.getClass().getResourceAsStream(prd.getImg().get(1));
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(200);

        InputStream input3 = this.getClass().getResourceAsStream(prd.getImg().get(2));
        Image image3 = new Image(input3);
        ImageView imageView3 = new ImageView(image3);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(200);

        InputStream input4 = this.getClass().getResourceAsStream(prd.getImg().get(3));
        Image image4 = new Image(input4);
        ImageView imageView4 = new ImageView(image4);
        imageView2.setFitWidth(200);
        imageView2.setFitHeight(200);

        //list
        ObservableList<ProdNames> items = FXCollections.observableArrayList(
                new ProdNames("Pfeffer", "1 Stück", "Schwarzer Pfeffer verleiht Ihren Speisen eine pikante Schärfe,\n besonders wenn er länger mitgekocht wird", 3.49, 2.79, "/cheese_salakis__600x600.jpg"),
                new ProdNames("Schafmilchkäse", "200 Gramm Packung", "Hier gibt es keine Beschreibung, \nweil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt.", 2.59, 1.99, "/pfeffer__600x600.jpg"),
                new ProdNames("Vöslauer", "1.5 Liter Flasche", "Spritziges \nVöslauer Mineralwasser.", 0.75, 0.49, "/voslauer__600x600.jpg"),
                new ProdNames("Zucker", "500 Gramm Paket", "Natürliches Gelieren wird durch Apfelpektin unterstützt,\nwelches im richtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde.", 1.39, 0.89, "/zucker__600x600.jpg")
        );
        ListView<ProdNames> list = new ListView<>();
        list.getItems().addAll(items);


        File file = new File("report.txt");
        FileWriter fw=new FileWriter(file,true);
        PrintWriter pw = new PrintWriter(fw);
        for (int x=0;x<items.size();x++)
        pw.println(" "+items.get(x)+"\n");
        pw.close();

        list.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            txt1.setText(newValue.getpName());
            txt1.setDisable(true);
            txt2.setText(newValue.getQuantity());
            txt2.setDisable(true);
            txt3.setText(String.valueOf(newValue.getOldprice()));
            txt4.setText(String.valueOf(newValue.getNewprice()));
            if (txt1.getText().equals("Pfeffer")) {
                imageView.setImage(imageView2.getImage());
            } else if (txt1.getText().equals("Vöslauer")) {
                imageView.setImage(imageView3.getImage());
            } else if (txt1.getText().equals("Zucker")) {
                imageView.setImage(imageView4.getImage());
            } else {
                imageView.setImage(imageView1.getImage());
            }
            deslbl.setText(newValue.getDescr());
        });

        //UPDATE BUTTON
        Button btnUpdate = new Button("Update");
        btnUpdate.setOnAction(actionEvent -> {
            System.out.println("UPDATED");
            int selectidx=list.getSelectionModel().getSelectedIndex();
            if (selectidx != -1)
            {
                double oldprice=Double.parseDouble(txt3.getText());
                double newprice=Double.parseDouble(txt4.getText());
                list.getItems().get(selectidx).setOldprice(oldprice);
                list.getItems().get(selectidx).setNewprice(newprice);
                list.refresh();
            }
        });

        //VBOX AND HBOX TO PANE
        VBox vBox = new VBox(imageView, deslblt, deslbl,btnUpdate);
        HBox hBox1 = new HBox(lb1, txt1);
        HBox hbox2 = new HBox(lb2, txt2);
        HBox hbox3 = new HBox(lb3, txt3, lbEURO2);
        HBox hbox4 = new HBox(lb4, txt4, lbEURO);
        HBox hBox = new HBox(list);

        GridPane gp = new GridPane();
        gp.setGridLinesVisible(true);
        gp.add(hBox1, 0, 0, 1, 1);
        gp.add(hbox2, 0, 1, 1, 1);
        gp.add(hbox3, 0, 2, 1, 1);
        gp.add(hbox4, 0, 3, 1, 1);
        gp.add(vBox, 0, 4, 1, 1);
        gp.setVgap(20);
        BorderPane bp = new BorderPane();
        bp.setLeft(gp);
        bp.setRight(hBox);

        HBox vmain = new HBox(bp);


        primaryStage.setTitle("SET ACTION PRICE");
        Scene sc = new Scene(vmain, 1000, 1000);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

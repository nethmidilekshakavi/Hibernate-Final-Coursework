package org.example.lk.ijse;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import static com.mysql.cj.protocol.a.MysqlTextValueDecoder.getDate;
import static com.mysql.cj.protocol.a.MysqlTextValueDecoder.getTime;

public class DashBoard implements Initializable {

        @FXML
        private Text Date;

        @FXML
        private AnchorPane Emptypane;

        @FXML
        private Text Time;

        @FXML
        private Text WhosLog;

        @FXML
        private Text admin;

        @FXML
        private ImageView adminpic;

        @FXML
        private Text baking;

        @FXML
        private Rectangle coountframe2;

        @FXML
        private Rectangle countframe;

        @FXML
        private Text course;

        @FXML
        private Text coursecountxtx;

        @FXML
        private Text desc1;

        @FXML
        private Text desc2;

        @FXML
        private Text desc3;

        @FXML
        private Text desc5;

        @FXML
        private Text desc51;

        @FXML
        private Text desc7;

        @FXML
        private Text desc71;

        @FXML
        private Rectangle f1;

        @FXML
        private Rectangle f2;

        @FXML
        private Rectangle f3;

        @FXML
        private Rectangle f5;

        @FXML
        private Rectangle f51;

        @FXML
        private Rectangle ff1;

        @FXML
        private Rectangle frame6;

        @FXML
        private Rectangle frame61;

        @FXML
        private Rectangle mainFrame;

        @FXML
        private Text month1;

        @FXML
        private Text month2;

        @FXML
        private Text month3;

        @FXML
        private ImageView pic1;

        @FXML
        private ImageView pic2;

        @FXML
        private ImageView pic3;

        @FXML
        private ImageView pic4;

        @FXML
        private ImageView pic41;

        @FXML
        private Text student;

        @FXML
        private Text studentcounttxt;

        @FXML
        private Text welcometopic;

        @FXML
        private Text welcommedesc;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                getDate();
                getTime();
        }

        private void getTime() {
                LocalTime now = LocalTime.now();
                Time.setText(String.valueOf(now));
        }

        private void getDate() {
                LocalDate now  = LocalDate.now();
                Date.setText(String.valueOf(now));
        }
}

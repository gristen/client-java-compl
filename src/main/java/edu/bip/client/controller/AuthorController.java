package edu.bip.client.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.bip.client.entity.AuthorEntity;
import edu.bip.client.entity.BookEntity;
import edu.bip.client.utils.HTTPUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AuthorController
{
    public static String api = "http://localhost:2825/api/v1/author/";
    public static ObservableList<AuthorEntity> booksData = FXCollections.observableArrayList();
    static HTTPUtils http = new HTTPUtils();
    static Gson gson = new Gson();

    @FXML
    public TableView<AuthorEntity> tableAuthor;

    @FXML
    private TableColumn<AuthorEntity, String> AuthorName;
    @FXML
    private TableColumn<AuthorEntity, String> AuthorLastName;
    @FXML
        private TableColumn<AuthorEntity, String> AuthorSurName;


    @FXML
    private void initialize() throws Exception {
        getData();
        updateTable();
    }

    private void updateTable() throws Exception {
        AuthorName.setCellValueFactory(new PropertyValueFactory<AuthorEntity, String>("name"));
        AuthorLastName.setCellValueFactory(new PropertyValueFactory<AuthorEntity, String>("lastname"));
        AuthorSurName.setCellValueFactory(new PropertyValueFactory<AuthorEntity, String>("surname"));

        tableAuthor.setItems(booksData);
    }
    public static void getData() throws Exception {
        String result = http.get(api,"all");
        System.out.println("Ответ"+result);

        JsonObject base = gson.fromJson(result, JsonObject.class);
        JsonArray dataArr = base.getAsJsonArray("data");
        System.out.println("Ответ"+dataArr);

        for (int i = 0; i < dataArr.size(); i++) {
            AuthorEntity newAuthor = gson.fromJson(dataArr.get(i).toString(), AuthorEntity.class);

            booksData.add(newAuthor);
        }
    }

}

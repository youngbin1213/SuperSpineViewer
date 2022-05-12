package com.SoarCraft.SuperSpineViewer.Controllers;

import io.github.palexdev.materialfx.controls.MFXRectangleToggleNode;
import io.github.palexdev.materialfx.utils.others.loader.MFXLoader;
import io.github.palexdev.materialfx.utils.others.loader.MFXLoaderBean;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.SoarCraft.SuperSpineViewer.ResourcesLoader.LoadURL;

public class MainController implements Initializable {
    private final Stage stage;

    private final ToggleGroup funcGroup = new ToggleGroup();

    @FXML
    private StackPane contentPane;

    @FXML
    private HBox navBar;

    @FXML
    private StackPane spineViewer;

    @FXML
    private AnchorPane rootPane;

    public MainController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildFuncBar();
    }

    private void buildFuncBar() {
        MFXLoader loader = new MFXLoader();
        loader.addView(MFXLoaderBean
                .of("LOAD", LoadURL("load.fxml"))
                .setBeanToNodeMapper(() -> createToggle("Load"))
                .setDefaultRoot(true).get());

        loader.addView(MFXLoaderBean
                .of("SETTING", LoadURL("setting.fxml"))
                .setBeanToNodeMapper(() -> createToggle("Setting")).get());

        loader.addView(MFXLoaderBean
                .of("EXPORT", LoadURL("export.fxml"))
                .setBeanToNodeMapper(() -> createToggle("Export")).get());

        loader.setOnLoadedAction(beans -> {
            List<ToggleButton> nodes = beans.stream().map(bean -> {
                ToggleButton toggle = (ToggleButton) bean.getBeanToNodeMapper().get();
                toggle.setOnAction(event -> contentPane.getChildren().setAll(bean.getRoot()));

                if (bean.isDefaultView()) {
                    contentPane.getChildren().setAll(bean.getRoot());
                    toggle.setSelected(true);
                }

                return toggle;
            }).toList();

            navBar.getChildren().setAll(nodes);
        });

        loader.start();
    }

    private ToggleButton createToggle(String text) {
        MFXRectangleToggleNode toggleNode = new MFXRectangleToggleNode(text);
        toggleNode.setAlignment(Pos.CENTER_LEFT);
        toggleNode.setMaxWidth(Double.MAX_VALUE);
        toggleNode.setToggleGroup(funcGroup);
        return toggleNode;
    }
}

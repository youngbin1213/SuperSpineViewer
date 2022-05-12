module SuperSpineViewer.main {
    requires MaterialFX;
    requires VirtualizedFX;
    requires jdk.localedata;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;

    opens com.SoarCraft.SuperSpineViewer;
    opens com.SoarCraft.SuperSpineViewer.Controllers;
}

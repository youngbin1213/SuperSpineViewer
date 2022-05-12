plugins {
    id("java")
    id("org.openjfx.javafxplugin") version ("0.0.13")
}

group = "com.SoarCraft.SuperSpineViewer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.palexdev:materialfx:11.13.5")
}

javafx {
    version = "18"
    modules("javafx.controls", "javafx.fxml", "javafx.media")
}

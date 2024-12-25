module com.hkb.musicservice.chatgui142 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    // Gson'ın bu pakete erişmesine izin ver
    opens com.hkb.musicservice.chatgui142 to com.google.gson;

    // Paket dışa aktarılıyor
    exports com.hkb.musicservice.chatgui142;
}
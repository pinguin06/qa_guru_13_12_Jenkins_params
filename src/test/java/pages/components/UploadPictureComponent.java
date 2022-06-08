package pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UploadPictureComponent {

    public void pictureUpload(String path) {
        $("#uploadPicture").uploadFile(new File(path));
    }
}

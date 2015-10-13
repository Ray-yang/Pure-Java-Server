import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Go {

    public static void main(String[] args) throws IOException, URISyntaxException {
        java.awt.Desktop.getDesktop().browse(new File("chat.html").toURI());
    }
}

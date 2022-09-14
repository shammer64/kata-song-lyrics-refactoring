import org.approvaltests.Approvals;
import org.approvaltests.reporters.UseReporter;
import org.approvaltests.reporters.intellij.IntelliJReporter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SongTest {

    @Test
    @UseReporter(IntelliJReporter.class)
    public void approvalTest() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        Song.main(new String[]{});

        Approvals.verify(baos.toString());
    }

}

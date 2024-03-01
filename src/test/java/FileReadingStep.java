import org.example.service.FileReader;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReadingStep {
    String filepath="";
    List<String> data=new ArrayList<>();
    String actualMessage="";

    @Given("a File Path")
    public void filePath() {
        filepath=this.getClass().getResource("LawnMover.txt").getPath().replaceFirst("/","");
    }

    @Given("the file has some data")
    public void fileHasContent() {

    }
    @When("we read content of a file")
    public void readData() throws IOException {
        FileReader fileReader =new FileReader();
        data=fileReader.readFile(filepath);

    }

    @Then("all the content should be returned")
    public void readDataSizeVerification() {
        assertTrue(data.size()>0);
    }

    @Given("a File Path which does't exists")
    public void dummyFile() {
        filepath="dummy.text";
    }

    @When("we read content of a file which does't exists")
    public void readFileWhicDoesntExist()  {

        try{
            FileReader fileReader =new FileReader();
            data=fileReader.readFile(filepath);
        }catch(Exception ex) {
            actualMessage=ex.toString();
        }
    }

    @Then("throw error")
    public void throwWhenFileDoesntExists() {
        assertEquals("java.nio.file.NoSuchFileException: dummy.text",actualMessage);
    }
}

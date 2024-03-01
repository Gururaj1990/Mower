import org.example.model.Direction;
import org.example.model.Lawn;
import org.example.model.Mower;
import org.example.service.FileReader;
import org.example.service.MowerOperator;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MowerOperatorStep {

    Mower mower=null;
    Lawn lawn=null;

    @Given("a mower object with current direction East")
    public void mowerObject() {
        mower=new Mower(0,0, Direction.E);
    }

    @Given("lawn dimensions are set")
    public void lawnDimensions() {
        lawn=new Lawn(5,5);
    }
    @When("left rotate operation is performed")
    public void performLeftRotation() throws IOException {
        MowerOperator mowerOperator=new MowerOperator(mower);
        mowerOperator.operate(lawn,'G');
    }

    @Then("mower direction should be changed to south")
    public void verifyDirection() {
        assertTrue(mower.getDirection()==Direction.S);
    }

    @When("right rotate operation is performed")
    public void performRightRotation() throws IOException {
        MowerOperator mowerOperator=new MowerOperator(mower);
        mowerOperator.operate(lawn,'D');
    }

    @Then("mower direction should be changed to north")
    public void verifyDirectionAfterRightRotation() {
        assertTrue(mower.getDirection()==Direction.N);
    }

    @When("move forward operation is performed")
    public void moveForward() throws IOException {
        MowerOperator mowerOperator=new MowerOperator(mower);
        mowerOperator.operate(lawn,'A');
    }

    @Then("mower should move one step forward in east direction")
    public void verifyAfterMoveForward() {
        assertTrue(mower.getDirection()==Direction.E);
        assertTrue(mower.getPosx()==1);
    }

    @Given("a mower object with current direction East and position right most corner")
    public void mowerObjectInRightCorner() {
        mower=new Mower(5,0, Direction.E);
    }

    @Then("mower should move retain its original postion")
    public void verifyAfterRightMoveForward() {
        assertTrue(mower.getDirection()==Direction.E);
        assertTrue(mower.getPosx()==5);
        assertTrue(mower.getPosy()==0);
    }

}

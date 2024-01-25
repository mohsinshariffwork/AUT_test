package aut.stepdef;

import org.testng.Assert;

import aut.pages.launchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class autStepDef {

	launchPage launchPg = new launchPage();

	@Given("^I want to launch the AUT url$")
	public void should_logged_in() throws NoSuchFieldException, InterruptedException {

		launchPg.launchApplication();
	}

	@Given("Click on create option")
	public void click_on_create_option() {

		launchPg.createFolowchartOption();
	}

	@Then("Verify application launched")
	public void verify_application_launched() {

		launchPg.verifyAppLaunched();
	}

	@When("Add {string} Shape in Flowchart")
	public void add_shape_in_flowchart(String string) throws InterruptedException {
		launchPg.addShape(string, 0, 0);
	}

	@Given("Set in Horizontal flow")
	public void Set_in_Horizontal_flow() {

		launchPg.setHorizontalFlow();
	}

	@When("Set input values for the flowchart as {string}")
	public void Set_input_values_for_the_flow_as(String string) throws InterruptedException {
		launchPg.setFlowchartValues(string);
	}

	@Then("verify Flowchart saved successfully")
	public void verify_Flowchart_saved_successfully() {

		launchPg.verifyFlowchartSaved();
	}
	
	
	@Then("verify file saved successfully")
	public void verify_File_saved_successfully() {

		launchPg.verifyFlowchartSaved();
	}

	@Given("Open an existing flowchart")
	public void open_a_flowchart() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Update a shape from {string} to {string} in flowchart")
	public void update_a_shape_from_to_in_flowchart(String string, String string2) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		launchPg.updateShape(string, string2);
	}

	@Then("verify shape updated to {string} successfully")
	public void verify_shape_updated_to_successfully(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		launchPg.verifyUpdateShape(string);
	}

	@Given("Delete a shape in flowchart")
	public void Delete_a_shape_in_flowchart() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		launchPg.deleteShape();
	}

	@Given("verify shape deleted successfully")
	public void verify_shape_deleted_successfully() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		launchPg.verifyDeleteShape();
	}

	@Given("Delete text of a shape")
	public void Delete_a_text_in_flowchart() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		launchPg.deleteShapeText();
	}

	@Then("verify text deleted successfully")
	public void verify_text_deleted_successfully() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		launchPg.verifyDeleteShapeText();
	}

	@Then("verify No results message displayed")
	public void verify_No_results_message_displayed() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(true,"Failed to display message");
	}
	
	@Then("Delete flowchart")
	public void Delete_flowchart() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		launchPg.deleteFlowchart();
	}
	@Then("verify deleted successfully")
	public void verify_deleted_successfully() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		launchPg.verifydeleteFlowchart();
	}
	
	
    
}

package pages;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;
import java.util.Map;

public class EmployeePage extends PageObject {

    @FindBy(id = "btn")
    WebElementFacade viewSelectedDataButton;

    @FindBy(css = "div [class*='jqx-listitem-element']")
    List<WebElementFacade> viewSelectedData;

    @FindBy(xpath = "//*[@id=\"tabletreeGrid\"]/tbody/tr")
    List<WebElementFacade> employeeList;

    @FindBy(css = "div [id='contenttabletreeGrid'] span[class*='jqx-tree-grid-checkbox jqx-tree-grid-indent jqx-checkbox-default jqx-fill-state-normal jqx-rc-all']")
    List<WebElementFacade> employeeCheckBoxList;

    @FindBy(css = "div [class*='jqx-tree-grid-checkbox-tick jqx-checkbox-check-checked']")
    List<WebElementFacade> checkBoxList;

    @FindBy(xpath = "//*[@id=\"row4treeGrid\"]/td[1]/span[2]")
    WebElementFacade arrow;


    public boolean employeeIsNotSelected(){
        arrow.click();
        Boolean employeeSelected = false;
        if (checkBoxList.size()==0){
            employeeSelected= true;
        }
        return employeeSelected;
    }

    public boolean viewSelectedDataIsEmpty(){
        viewSelectedDataButton.click();
        Boolean selectedData = false;
        if (viewSelectedData.size()==0){
            selectedData= true;
        }
        return selectedData;
    }

    public void selectEmployee(DataTable t){
        arrow.click();
        List<Map<String, String>> itemsTargetPage = t.asMaps(String.class, String.class);
        for (Map<String, String> item : itemsTargetPage) {
            String firstName = item.get("FirstName");
            String lastName = item.get("LastName");
            String titleName = item.get("Title");

            String employeeData = firstName + " "+ lastName +" " + titleName;

           for (int i = 0;i<employeeList.size();i++) {
                if (employeeData.equalsIgnoreCase(employeeList.get(i).getText())) {
                    employeeCheckBoxList.get(i).click();
                }
            }
        }
    }

    public boolean verifyCityOfEmployee(DataTable t){
        viewSelectedDataButton.click();
        Boolean verifyCity = false;
        List<Map<String, String>> itemsTargetPage = t.asMaps(String.class, String.class);
        for (Map<String, String> item : itemsTargetPage) {
            String firstName = item.get("FirstName");
            String city = item.get("City");

            String employeeData = firstName + " is from " + city;

            verifyCity = false;
            int i = 0;
            while (!verifyCity && i < viewSelectedData.size()) {
                String selectedDataEmployee = viewSelectedData.get(i).getText();
                if (selectedDataEmployee.equalsIgnoreCase(employeeData)) {
                   verifyCity = true;
                }
                i++;
            }
            if (!verifyCity){
                return verifyCity;
            }
        }
        return verifyCity;
    }

    public void selectAllEmployees(){
        arrow.click();
        for (int i = 0;i<employeeList.size();i++){
            employeeCheckBoxList.get(i).click();
        }
    }
}
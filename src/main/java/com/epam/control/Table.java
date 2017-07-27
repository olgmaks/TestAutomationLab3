package com.epam.control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class Table extends AbstractElement{
    public Table(WebElement webElement) {
        super(webElement);
    }

    public int getRowCount() {
        List<WebElement> tableRows = webElement.findElements(By.tagName("tr"));
        return tableRows.size();
    }

    public int getColumnCount() {
        List<WebElement> tableRows = webElement.findElements(By.tagName("tr"));
        WebElement headerRow = tableRows.get(0);
        List<WebElement> tableCols = headerRow.findElements(By.tagName("td"));
        return tableCols.size();
    }

    public WebElement getTagFromTable(int rowIdx, int colIdx, String cssSelectorName) throws NoSuchElementException {
        try {
            List<WebElement> tableRows = webElement.findElements(By.tagName("tr"));
            WebElement currentRow = tableRows.get(rowIdx-1);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            WebElement cell = tableCols.get(colIdx-1);
            WebElement cellEditor = cell.findElement(By.cssSelector(cssSelectorName));
            return cellEditor;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Failed to get cell editor");
        }
    }


    public WebElement getCellEditor(String from, String subject, String date){
        List<WebElement> tableRows = webElement.findElements(By.xpath(".//tr"));
        WebElement checkedWebElement = null;
        for (WebElement row : tableRows) {
            if(isItRowWhatWeAreLookingFor(row, from, subject, date)){
                checkedWebElement = row;
            }
        }
        return checkedWebElement;
    }

    private boolean isItRowWhatWeAreLookingFor(WebElement row, String from, String subject, String date) {
        if(row.findElement(By.cssSelector("div.yW span")).getAttribute("textContent").trim().equalsIgnoreCase(from) &&
                row.findElement(By.cssSelector("span.bog")).getAttribute("textContent").trim().equalsIgnoreCase(subject) &&
                row.findElement(By.cssSelector(".xW.xY span")).getAttribute("aria-label").trim().equalsIgnoreCase(date)){
            return true;
        }else{
            return false;
        }
    }
}

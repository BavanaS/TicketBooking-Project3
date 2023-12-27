package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Seat
{
    public void searchSeats(WebDriver driver)
    {
        List<WebElement> showTime=driver.findElements(By.cssSelector(".showtime-pill-container._filling .showtime-pill"));
        showTime.get(0).click();

        driver.findElement(By.xpath("//li[@id='pop_1']")).click();
        driver.findElement(By.xpath("//div[@id='proceed-Qty']")).click();
    }
    public void displaySeats(WebDriver driver)
    {
        List<WebElement> rows=driver.findElements(By.cssSelector("tbody > tr"));

        for(WebElement i:rows)
        {
            WebElement table=i.findElement(By.cssSelector("td > div.seatR.Setrow1"));
            if(table!=null)
            {
                String seat=table.findElement(By.cssSelector("div")).getText();
                List<WebElement> seats=i.findElements(By.cssSelector("td > div"));

                for(int j=1;j<seats.size()-1;j++)
                {
                    if (seats.get(j-1).getAttribute("data-seat-type").equals("1") && seats.get(j).getAttribute("data-seat-type").equals("1") && seats.get(j+1).getAttribute("data-seat-type").equals("1"))
                    {
                        String seatNo=seats.get(j).findElement(By.cssSelector("a")).getText();
                        System.out.println(seat + seatNo);
                    }
                    else
                    {
                        System.out.println("");
                    }
                }
            }
        }
    }
}

const {test,expect}= require('@playwright/test');
const {PracticePage} = require('../pageobjects/PracticePage');

//if we have multiple test file it will run parallely multiple test in one spec file will run sequentially
test ('Page playwright test',async ({page})=>
{
    const practicePage=new PracticePage(page);
    await practicePage.goTo();
    await practicePage.radioButtons();
    await practicePage.dropdowns();
    await practicePage.checkboxes();
    await practicePage.dropdownTexts();
  //const course = page.locator(".course-name");
  //console.log(await course.first().textContent());
   //await expect(page.locator("#enabled-example-input")).toBeEnabled();
   //await (page.locator("#disabled-button")).click();
   //await expect(page.locator("#enabled-example-input")).toBeDisabled();
   //await expect(page.locator("#displayed-text")).toBeVisible();
    //await page.locator("#hide-textbox").click();
    //await expect(page.locator("#displayed-text")).toBeHidden();
    //await page.locator("button:has-text('Mouse Hover')").hover();
    //const framesPage= await page.frameLocator("#courses-iframe");
    //await framesPage.locator("li[data-id='41189'] a[href*='/courses']").click();
    //await framesPage.locator("div h4:has-text('Selenium WebDriver Advanced')").click();
    //await page.pause();
});
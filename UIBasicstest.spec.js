const {test,expect}= require('@playwright/test');
test ('Browser playwright test',async ({browser})=>
{
   const context = await browser.newContext();
   const page = await context.newPage();
   await page.goto("https://google.com");
   console.log(await page.title());
});

//if we have multiple test file it will run parallely multiple test in one spec file will run sequentially
test ('Page playwright test',async ({page})=>
{
   await page.goto("https://courses.letskodeit.com/practice");
   console.log(await page.title());
    expect(await page).toHaveTitle("Practice Page");
   const radioButton= page.locator("#benzradio");
   await radioButton.click();
   const dropdown = page.locator("#carselect");
   await dropdown.selectOption("honda");
   await page.locator("#bmwcheck").click();
   await expect(page.locator("#bmwcheck")).toBeChecked();
   await page.locator("#benzcheck").click();
   await page.locator("#benzcheck").uncheck();
   expect (await page.locator("#benzcheck").isChecked()).toBeFalsy();
   const car= page.locator("#carselect option");
  console.log(await car.first().textContent());
  console.log(await car.allTextContents());
  console.log(await car.nth(1).textContent());
  const course = page.locator(".course-name");
  console.log(await course.first().textContent());
   await expect(page.locator("#enabled-example-input")).toBeEnabled();
   await (page.locator("#disabled-button")).click();
   await expect(page.locator("#enabled-example-input")).toBeDisabled();
   await expect(page.locator("#displayed-text")).toBeVisible();
   await page.locator("#displayed-text").screenshot({path:'partialScreenshot.png'});
    await page.locator("#hide-textbox").click();
    await expect(page.locator("#displayed-text")).toBeHidden();
    await page.screenshot({path:'screenshot.png'});
    await page.locator("button:has-text('Mouse Hover')").hover();
    const framesPage= await page.frameLocator("#courses-iframe");
    await framesPage.locator("li[data-id='41189'] a[href*='/courses']").click();
    await framesPage.locator("div h4:has-text('Selenium WebDriver Advanced')").click();
    //await page.pause();
});

test.only('visual',async({page})=>
{
      await page.goto("https://uk.flightaware.com/");
    expect(await page.screenshot()).toMatchSnapshot('landing.png');

})
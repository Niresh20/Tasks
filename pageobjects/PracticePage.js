const { expect } = require("@playwright/test");

class PracticePage{

constructor(page)
{
  this.page=page;
  this.radioButton=page.locator("#benzradio");
  this.dropdown = page.locator("#carselect");
  this.checkbox = page.locator("#bmwcheck");
  this.checkbox2 = page.locator("#benzcheck");
  this.dropdownText= page.locator("#carselect option");
}

async goTo(){
    await this.page.goto("https://courses.letskodeit.com/practice");
}

async radioButtons(){
    await this.radioButton.click();
}

async dropdowns(){
    await this.dropdown.selectOption("honda");
}

async checkboxes(){
    await this.checkbox.click();
     await expect (this.checkbox).toBeChecked();
    await this.checkbox2.click();
    await this.checkbox2.uncheck();
    const checkBool= await this.checkbox2.toBeChecked();
    expect (checkBool).toBeFalsy();
}

async dropdownTexts(){
    console.log(await this.dropdownText.first().textContent());
    console.log(await this.dropdownText.allTextContents());
    console.log(await this.dropdownText.nth(1).textContent());

}
}

module.exports ={PracticePage};
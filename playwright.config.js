// @ts-check
const { devices } = require('@playwright/test');

//cofiguration file: firstly we are creating one object called config. Test runner will scan this test directory.
//so we have to mention our tests here.
const config = {
  testDir: './tests',
  //retries:2,
  /* Maximum time one test can run for. */
  timeout: 80 * 1000,
  //for assertation
  expect: {
    /**
     * Maximum time expect() should wait for the condition to be met.
     * For example in `await expect(locator).toHaveText();`
     */
    timeout: 5000
  },
  //we can report in html, json
  reporter: 'html',
  /* Shared settings for all the projects below. See https://playwright.dev/docs/api/class-testoptions. */

//this is the key here.This use property whatever we declare here our testcases will read all the properties here. So here where we want
// to tell what browser we want to run taking screenshots, logs all have to send into this property
  use: {
    browserName : 'chromium',
    //browserName : 'webkit',
    //browserName : 'firefox'
    //...devices['iPhone 11'],
    headless :true,
    
  },

};
//finally we are exporting this config object
module.exports = config;

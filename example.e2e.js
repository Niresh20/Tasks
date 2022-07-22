
describe('Amazon application', () => {
    it('sum of products', async () => {
        await browser.url("http://rahulshettyacademy.com/angularpractice/shop")
        await browser.maximizeWindow()
       const cards= await $$("div[class='card h-100']")
       for (let i=0; i<await cards.length;i++)
       {
         const card =await cards[i].$("div[class='card h-100'] div h4 a")
         console.log(await card.getText())
         const products=['iphone X','Blackberry']
         if(products.includes(await card.getText()))
         {
           await cards[i].$(".card-footer button").click()
         }
       }
       browser.pause(3000)
       await $ ("*=Checkout").click()
       const productPrices = await $$("//tr/td[4]/strong")
       const sumOfProducts = (await Promise.all(await productPrices.map(async(productPrice)=> parseInt((await productPrice.getText()).split(".")[1].trim()))))
       .reduce((acc,price)=> acc+price,0) 
       console.log(sumOfProducts)
       














    });
});



const puppeteer = require("puppeteer");

async function startBot() {
    const browser = await puppeteer.launch({ headless: false }); // Abre o navegador
    const page = await browser.newPage(); // Abre uma nova página
    await page.setUserAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
    await page.goto("https://web.whatsapp.com/"); // Navega até o WhatsApp Web
    await page.waitForSelector("._2_1wd"); // Espera o campo de pesquisa carregar

    await delay(5000);
    // Monitora novas mensagens no grupo
    page.on('childList', async () => {
        const messages = await page.$$('.message-in'); // Seleciona todas as mensagens recebidas

        for (const msg of messages) {
            const text = await msg.$eval('.selectable-text', node => node.innerText); // Extrai o texto da mensagem

            if (text.includes('@all')) { // Verifica se a mensagem contém "@all"
                const persons = await page.$$eval('.copyable-text.selectable-text', nodes => nodes.map(n => n.innerText)); // Obtém os nomes das pessoas no grupo
                const myName = persons[persons.length - 1]; // Assume que o último nome é o seu

                const otherPersons = persons.filter(person => person !== myName); // Filtra o seu próprio nome da lista

                // Marca as outras pessoas na mensagem
                const messageBox = await page.$('.copyable-text.selectable-text[data-tab="1"]');
                await messageBox.click();
                await page.keyboard.type(`@${otherPersons.join(' @')}`);

                // Envie a mensagem pressionando Enter (ou aguarde aprovação manual)
                await page.keyboard.press('Enter');
                
            }
        }
    });
}
function delay(time) {
    return new Promise(function (resolve) {
        setTimeout(resolve, time);
    });
}

startBot();

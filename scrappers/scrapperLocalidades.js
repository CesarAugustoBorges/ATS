var axios = require('axios');
var cheerio = require('cheerio');
var fs = require('fs');
    

startParsing = (dadosHtml) => {
    $ = cheerio.load(dadosHtml);
    var populations = []
    var locations = []
    try{
        ($('.ValueCell ').contents().each((i, element) => {
            if(i % 8 == 1){
                var pop = element.data.replace(/[.]/g, '')
                populations.push(parseInt(pop))
            }
        }))
    } catch (e){}

    $('.YearCell').contents().each((i, element) => {
        if((i % 3 == 1))
            locations.push(element.data)
    })

    var retirados = 0;
    $('.YearCell').contents().each(function(i, element){
        if((i % 3 == 1)){
            if(element.parent != undefined){
                var parent = element.parent.parent;
                //console.log(parent.attribs.isparent)
                if(parent.attribs.isparent != undefined){
                    locations.splice(Math.floor(i / 3) - retirados, 1)
                    populations.splice(Math.floor(i / 3) - retirados, 1)
                    retirados++;
                }
            }
            else console.log('Unpredicted: ' + element.parent != undefined, element.parent.parent != undefined)
        }
    })
    console.log(populations.length)
    console.log(locations.length)
    var stringBuilder = 'import Test.QuickCheck\n\nlocalidades :: [(Int, Gen String)]\nlocalidades = [\n'
   for(var i = 0; i < populations.length; i++){
        stringBuilder += '      (' + populations[i] + ', return "' + locations[i] + '")'
        if(i != populations.length - 1)
            stringBuilder += ',\n'
   }
    stringBuilder += ']'
    fs.writeFile(process.argv[2], stringBuilder, erro => {
        if(erro) console.log(erro)
        else console.log("Variável construida com sucesso no ficheiro " + process.argv[2])
    })
}

main = () =>{
    axios.get('https://www.pordata.pt/Municipios/Popula%C3%A7%C3%A3o+residente+total+e+por+grandes+grupos+et%C3%A1rios-390')
        .then(dados => startParsing(dados.data))
        .catch(erro => console.log(erro))

}

main();
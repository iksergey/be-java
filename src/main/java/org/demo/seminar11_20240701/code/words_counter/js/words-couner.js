const fs = require('fs');

function createFrequencyDictionary(inputFile, outputFile) {
    fs.readFile(inputFile, 'utf8', (err, data) => {
        if (err) {
            console.error(`Ошибка при чтении файла: ${err}`);
            return;
        }

        // Удаление знаков пунктуации и приведение к нижнему регистру
        const cleanedData = data.replace(/[.,\/#!$%\^&\*;:{}=\-_`~()]/g, '').toLowerCase();
        const words = cleanedData.split(/\s+/).filter(word => word.length > 0);

        // Создание частотного словаря
        const frequencyMap = {};
        words.forEach(word => {
            if (frequencyMap[word]) {
                frequencyMap[word]++;
            } else {
                frequencyMap[word] = 1;
            }
        });

        // Сортировка по убыванию частоты
        const sortedWords = Object.keys(frequencyMap).sort((a, b) => frequencyMap[b] - frequencyMap[a]);

        // Формирование строки для записи в файл
        let outputText = '';
        sortedWords.forEach(word => {
            outputText += `${word};${frequencyMap[word]};\n`;
        });

        // Запись результата в файл
        fs.writeFile(outputFile, outputText, 'utf8', (err) => {
            if (err) {
                console.error(`Ошибка при записи файла: ${err}`);
                return;
            }
            console.log(`Частотный словарь успешно записан в файл ${outputFile}`);
        });
    });
}


const inputFile = '../words.txt';
const outputFile = '../result_js.csv';

createFrequencyDictionary(inputFile, outputFile);

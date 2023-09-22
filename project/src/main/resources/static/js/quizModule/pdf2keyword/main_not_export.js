const { clearAndConvert } = require('./1module_pdf_2_jpg.js');
const ocrModule = require('./2module_google_ocrApi.js');
const translateModule = require('./2module_translate.js'); // 2module_translate.js를 import합니다.
const keywordModule = require('./3module_ocr_extract_keyword.js');
const deleteKeywordModule = require('./4module_keyword_delete.js');

const args = process.argv.slice(2);

if (args.length !== 2) {
  console.error('Usage: node main.js <pdfPath> <subjectName>');
  process.exit(1);
}

const pdfPath = args[0];
const subjectName = args[1];

async function main() {
  try {
    await clearAndConvert(pdfPath);
    console.log("Image conversion completed.");

    await ocrModule.processImagesSequentially();
    console.log('OCR process completed.');

    await translateModule.translateFile('./resources/input_ocr.txt', './resources/output.txt');
    console.log('Translation completed.');

    const topKeywords = keywordModule.extractKeywords();
    console.log('Keyword extraction completed.');
    console.log(topKeywords);

    await deleteKeywordModule(subjectName);
    console.log('Keyword deletion completed.');
  } catch (error) {
    console.error('Error:', error);
  }
}

main();

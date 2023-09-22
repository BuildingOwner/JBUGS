// main.js

const { clearAndConvert } = require('./1module_pdf_2_jpg.js');
const ocrModule = require('./2module_google_ocrApi.js');
const translateModule = require('./2module_translate.js');
const keywordModule = require('./3module_ocr_extract_keyword.js');
const deleteKeywordModule = require('./4module_keyword_delete.js');

const fs = require('fs/promises');

// 파일을 삭제하는 함수
async function deleteFile(filePath) {
  try {
    await fs.unlink(filePath);
    console.log(`Deleted file: ${filePath}`);
  } catch (error) {
    console.error(`Error deleting file ${filePath}:`, error.message);
  }
}

// ./resources/keyword.txt 파일의 내용을 파싱하여 subjectName과 keywords 배열을 반환하는 함수
// 수정된 parseKeywords 함수
async function parseKeywords() {
  try {
    const keywordData = await fs.readFile('./resources/keyword.txt', 'utf-8');
    const lines = keywordData.trim().split('$');

    if (lines.length === 0) {
      console.error('No keywords found in the file.');
      return { subject: '', keywords: [] };
    }

    const subject = lines[0].trim();
    const keywords = lines.slice(1).map(line => line.trim());

    return { subject, keywords };
  } catch (error) {
    console.error('Error reading keyword file:', error.message);
    return { subject: '', keywords: [] };
  }
}


// JSON 형식으로 키워드 저장 및 반환 함수
async function saveKeywordsAsJSON(keywords) {
  try {
    const jsonKeywords = JSON.stringify(keywords);
    await fs.writeFile('./resources/pdf2keyword.json', jsonKeywords, 'utf-8'); // JSON 파일로 저장
    console.log('Keywords saved as JSON.');
  } catch (error) {
    console.error('Error saving keywords as JSON:', error.message);
  }
}

// 인자로 pdfPath를 받아서 실행하는 함수
async function main(pdfPath, subjectName) {
  try {
    await deleteFile('./resources/keywords.json');

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

    const { subject, keywords } = await parseKeywords();
    console.log('Subject Name:', subject);
    console.log('Keywords:', keywords);

    // 여기서 subjectName 및 keywords를 필요한 곳에서 사용할 수 있습니다.

    // JSON 형식으로 저장하고 반환
    await saveKeywordsAsJSON({ subject, keywords });

    return { subjectName, keywords };
  } catch (error) {
    console.error('Error:', error);
    return null; // 오류 발생 시 null 반환 또는 오류 처리 방법을 선택하세요.
  }
}

// main 함수를 모듈로 내보냅니다.
module.exports = main;

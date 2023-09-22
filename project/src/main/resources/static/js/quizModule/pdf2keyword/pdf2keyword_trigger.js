// test.js

// main 모듈을 import합니다.
const main = require('./pdf2keyword_export');

// 실행할 PDF 파일 경로와 주제 이름을 지정합니다.
const pdfPath = "./resources/input.pdf"; // PDF 파일 경로를 설정하세요.
const subjectName = "DataStructure"; // 주제 이름을 설정하세요.

// main 함수를 호출하여 작업을 실행합니다.
main(pdfPath, subjectName)
  .then(result => {
    if (result) {
      console.log('Main function completed.');

      // JSON 데이터를 파싱하여 출력합니다.
      console.log('Subject Name:', result.subjectName);
      console.log('Keywords:', result.keywords);
    } else {
      console.error('Main function encountered an error.');
    }
  })
  .catch(error => {
    console.error('Main function encountered an error:', error);
  });

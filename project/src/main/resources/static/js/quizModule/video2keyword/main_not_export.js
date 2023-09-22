const cloudVisionModule = require('./2module_google_videoApi.js');
const translateModule = require('./2module_translate.js'); // 2module_translate.js를 import합니다.
const keywordModule = require('./3module_video_extract_keyword.js');
const deleteKeywordModule = require('./4module_keyword_delete.js');

const args = process.argv.slice(2); // 명령줄 인수 가져오기

if (args.length !== 2) {
  console.error('Usage: node main.js <videoPath> <subjectName>');
  process.exit(1);
}

const videoPath = args[0]; // 입력받은 PDF 경로
const subjectName = args[1]; // 입력받은 과목명

async function main() {
  try {
    await cloudVisionModule.detectVideoTextAndSaveToFile(videoPath); // detectVideoTextAndSaveToFile 함수 호출
    console.log('GoogleCloudVision process completed.');

    await translateModule.translateFile('./resources/input_video.txt', './resources/output.txt');
    console.log('Translation completed.');

    // 3. 키워드 추출 모듈 실행 (세 번째로 실행)
    const topKeywords = keywordModule.extractKeywords();
    console.log('Keyword extraction completed.');
    console.log(topKeywords);

    // 4. 키워드 삭제 모듈 실행 (네 번째로 실행)
    await deleteKeywordModule(subjectName);
    console.log('Keyword deletion completed.');
  } catch (error) {
    console.error('Error:', error);
  }
}

// main 함수 실행
main();

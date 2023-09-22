const fs = require('fs');
const natural = require('natural');
const TfIdf = natural.TfIdf;
const tfidf = new TfIdf();

// 파일에서 텍스트 읽어오기
const filePath = './resources/input_video.txt';
const fileContent = fs.readFileSync(filePath, 'utf-8');

// 전체 텍스트를 하나의 문서로 추가
tfidf.addDocument(fileContent);

// 중요한 키워드를 추출하는 함수
function extractKeywords() {
  const excludedKeywords = ["hansung", "university", "school","2019","20","data","int","rlink","gt","lt","quot","easily","saengneung","linked","written","company","publishing","line"]; // 제외할 키워드 추가

  const keywords = [];

  tfidf.listTerms(0).forEach((termInfo) => {
    if (!excludedKeywords.includes(termInfo.term.toLowerCase())) { // 대소문자 구분 없이 체크
      keywords.push({
        term: termInfo.term,
        tfidf: termInfo.tfidf
      });
    }
  });

  keywords.sort((a, b) => b.tfidf - a.tfidf); // TF-IDF 값 기준으로 정렬

  // 중요한 키워드만 출력
  const topKeywords = keywords.slice(0, 10); // 상위 10개 키워드 추출

  // 키워드를 파일에 저장
  const keywordFilePath = './resources/keyword.txt';
  fs.writeFileSync(keywordFilePath, '', 'utf-8'); // 파일 내용 초기화

  topKeywords.forEach((keyword, index) => {
    const keywordInfo = `${index + 1}. ${keyword.term}\n`;
    fs.appendFileSync(keywordFilePath, keywordInfo, 'utf-8'); // 키워드 추가
  });

  console.log(`Keyword extraction complete. Result saved to ${keywordFilePath}.`);

  return topKeywords;
}

// 함수와 데이터를 내보내기
module.exports = {
  extractKeywords,
};

const axios = require('axios');
const fs = require('fs').promises;

const apiKey = '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';
const apiUrl = 'https://api.openai.com/v1/engines/davinci/completions';

async function evaluateRelatedness(subject, keyword) {
  const prompt = `과목명: ${subject}\n키워드: ${keyword}\n`;

  try {
    const response = await axios.post(apiUrl, {
      prompt: prompt,
      max_tokens: 100,
      n: 1,
    }, {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${apiKey}`,
      },
    });

    const relatedness = parseFloat(response.data.choices[0].text);
    return relatedness * 10; // 10점 만점으로 조정
  } catch (error) {
    console.error('Error:', error.message);
    return 0;
  }
}

async function filterKeywords(subject, keywords) {
  const keywordScores = await Promise.all(keywords.map(async keyword => {
    const relatednessSubject = await evaluateRelatedness(subject, keyword);
    const relatednessKeywords = await evaluateKeywordsRelatedness(keywords, keyword);

    const score = relatednessSubject + relatednessKeywords;
    return { keyword, score };
  }));

  return keywordScores;
}

async function evaluateKeywordsRelatedness(keywords, targetKeyword) {
  const relatednessScores = await Promise.all(keywords.map(async keyword => {
    return evaluateRelatedness(targetKeyword, keyword);
  }));

  return Math.max(...relatednessScores); // 상대적 연관성의 최대값 사용
}

async function processKeywordsDeletion() {
  try {
    const subject = process.argv[3]; // 과목명을 명령줄 인수로 받아옴

    const keywordsFilePath = './resources/keyword.txt';
    const keywordsContent = await fs.readFile(keywordsFilePath, 'utf-8');
    const lines = keywordsContent.split('\n');

    if (lines.length === 0) {
      console.log('키워드 파일에서 키워드를 찾을 수 없습니다.');
      return;
    }

    const keywordMap = new Map();
    for (const line of lines) {
      const match = line.match(/^\d+\.\s*(.*)/);
      if (match) {
        const keyword = match[1].trim();
        keywordMap.set(keyword, keyword);
      }
    }

    const allKeywords = Array.from(keywordMap.keys());

    // 키워드 필터링하여 점수 매기기
    const keywordScores = await filterKeywords(subject, allKeywords);

    if (keywordScores.length === 0) {
      console.log('키워드 스코어를 찾을 수 없습니다.');
      return;
    }

    // 점수를 기준으로 내림차순 정렬
    keywordScores.sort((a, b) => b.score - a.score);

    // 연관성이 가장 적은 키워드부터 삭제
    let remainingKeywords = allKeywords;
    while (remainingKeywords.length > 5) {
      const leastRelatedKeyword = keywordScores.pop().keyword;
      remainingKeywords = remainingKeywords.filter(keyword => keyword !== leastRelatedKeyword);
    }

    console.log('남은 키워드:', remainingKeywords);

    // 키워드를 다시 파일에 저장 (과목명을 첫 줄에 추가)
    const updatedKeywords = [subject, ...remainingKeywords].join('$');
    await fs.writeFile(keywordsFilePath, updatedKeywords, 'utf-8');

    console.log('Keyword deletion completed.');
  } catch (error) {
    console.error('Error:', error.message);
  }
}

module.exports = processKeywordsDeletion;

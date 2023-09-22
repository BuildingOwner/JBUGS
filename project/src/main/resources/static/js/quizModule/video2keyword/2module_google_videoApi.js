const fs = require('fs');
const videoIntelligence = require('@google-cloud/video-intelligence');

// API 키 파일 경로
const keyFilePath = 'your_api_key_file.json';

async function detectVideoTextAndSaveToFile(videoPath) {
  try {
    // API 키 파일을 사용하여 Google Cloud Video Intelligence API 클라이언트 생성
    const client = new videoIntelligence.VideoIntelligenceServiceClient({
      keyFilename: keyFilePath,
    });

    // 동영상 파일을 버퍼로 읽어옴
    const videoBuffer = fs.readFileSync(videoPath);

    // 동영상 텍스트 감지 요청 생성
    const request = {
      inputContent: videoBuffer,
      features: ['TEXT_DETECTION'], // 텍스트 감지 기능 추가
      videoContext: {
        textDetectionConfig: {
          languageHints: ['ko'], // 한국어 언어 코드 지정
        },
      },
    };

    // Video Intelligence API를 통해 동영상 텍스트 감지
    const [operation] = await client.annotateVideo(request);

    // 작업 완료 대기
    const [operationResult] = await operation.promise();

    // 텍스트 감지 결과 출력
    const annotations = operationResult.annotationResults[0];
    if (annotations.textAnnotations && annotations.textAnnotations.length > 0) {
      const detectedTexts = annotations.textAnnotations.map(textAnnotation => textAnnotation.text);
      const combinedText = detectedTexts.join('\n'); // 각 라인을 줄바꿈으로 연결

      // 텍스트를 파일에 추가 저장 (이전 내용에 덮어쓰지 않음)
      fs.appendFileSync('./resources/input_video.txt', combinedText, 'utf-8');
      console.log('Detected Texts saved to input_video.txt');
    } else {
      console.log('No texts detected.');
    }

    return annotations;
  } catch (error) {
    console.error('Error:', error);
  }
}

module.exports = {
  detectVideoTextAndSaveToFile, // 모듈에서 함수를 내보냄
};

// document.getElementById('videoButton').addEventListener('click', async (event) => {
//   try {
//     const videoPath = '!/resources/input.mp4';
//     const videoSubject = '/datastructure'
//     videoJson = await fetch('http://localhost:5500' + videoSubject + videoPath);
//   } catch (error) {
//     console.error('An error occurred:', error);
//     document.getElementById('output').textContent = 'An error occurred during chat execution.';
//   }
// })
// document.getElementById('getVideoKeyword').addEventListener('click', async (event) => {
//   try {
//     // Fetch 요청
//     const response = await fetch('http://localhost:5500/getVideoKeyword');
//
//     // 응답이 성공적인 경우
//     if (response.ok) {
//       videoJson = await response.json(); // JSON 데이터 추출 ㅁㄴㅇㄹ
//       console.log(videoJson);
//     } else {
//       throw new Error('An error occurred: ' + response.statusText);
//     }
//   } catch (error) {
//     console.error('An error occurred:', error);
//     document.getElementById('output').textContent = 'An error occurred during chat execution.';
//   }
// })

document.getElementById('videoButton').addEventListener('click', async (event) => {
  try {
    const videoPath = '!/resources/input.mp4';
    const videoSubject = '/datastructure';

    // 첫 번째 작업: 비디오 정보 가져오기
    const videoResponse = await fetch('http://localhost:5500' + videoSubject + videoPath);
    if (!videoResponse.ok) {
      throw new Error('An error occurred: ' + videoResponse.statusText);
    }
    const videoJson = await videoResponse.json(); // JSON 데이터 추출

    // 두 번째 작업: 비디오 키워드 가져오기
    const keywordResponse = await fetch('http://localhost:5500/getVideoKeyword');
    if (!keywordResponse.ok) {
      throw new Error('An error occurred: ' + keywordResponse.statusText);
    }
    const videoKeywordJson = await keywordResponse.json(); // JSON 데이터 추출

    // 두 작업이 성공적으로 완료되었으므로 추가 작업 수행
    console.log('비디오 정보:', videoJson);
    console.log('비디오 키워드:', videoKeywordJson);

  } catch (error) {
    console.error('An error occurred:', error);
    document.getElementById('output').textContent = 'An error occurred during chat execution.';
  }
});

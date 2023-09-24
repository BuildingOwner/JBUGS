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

// document.getElementById('videoButton').addEventListener('click', async (event) => {
//   try {
//     const videoPath = '!/video/input.mp4';
//     const videoSubject = '/datastructure';
//
//     // 첫 번째 작업: 비디오 정보 가져오기
//     const videoResponse = await fetch('http://localhost:5500' + videoSubject + videoPath);
//     if (!videoResponse.ok) {
//       throw new Error('An error occurred: ' + videoResponse.statusText);
//     }
//     const videoJson = await videoResponse.json(); // JSON 데이터 추출
//
//     // 두 번째 작업: 비디오 키워드 가져오기
//     const keywordResponse = await fetch('http://localhost:5500/getVideoKeyword');
//     if (!keywordResponse.ok) {
//       throw new Error('An error occurred: ' + keywordResponse.statusText);
//     }
//     const videoKeywordJson = await keywordResponse.json(); // JSON 데이터 추출
//
//     // 두 작업이 성공적으로 완료되었으므로 추가 작업 수행
//     console.log('비디오 키워드:', videoKeywordJson);
//
//   } catch (error) {
//     console.error('An error occurred:', error);
//     document.getElementById('output').textContent = 'An error occurred during chat execution.';
//   }
// });
//
// document.getElementById('pdfButton').addEventListener('click', async (event) => {
//   try {
//     const pdfPath = '!/resources/input.pdf';
//     const pdfSubject = '/DataStructure';
//
//     // Fetch request
//     const response = await fetch('http://localhost:5500' + pdfSubject + pdfPath);
//
//     // If the response is successful
//     if (response.ok) {
//       const responseJson = await response.json(); // JSON data extraction
//       console.log(responseJson);
//
//     } else {
//       throw new Error('An error occurred: ' + response.statusText);
//     }
//   } catch (error) {
//     // error handling
//     console.error('An error occurred:', error);
//     document.getElementById('output').textContent = 'An error occurred during chat execution.';
//   }
// });

// document.getElementById('videoButton').addEventListener('click', async (event) => {
//   try {
//     const videoPath = '!/video/input.mp4';
//     const videoSubject = '/datastructure';
//
//     // First task: get video information
//     const videoResponse = await fetch('http://localhost:5500' + videoSubject + videoPath);
//     if (!videoResponse.ok) {
//       throw new Error('An error occurred: ' + videoResponse.statusText);
//     }
//     const videoJson = await videoResponse.json(); // JSON data extraction
//
//     // Second task: Get video keywords
//     const keywordResponse = await fetch('http://localhost:5500/getVideoKeyword');
//     if (!keywordResponse.ok) {
//       throw new Error('An error occurred: ' + keywordResponse.statusText);
//     }
//     const videoKeywordJson = await keywordResponse.json(); // JSON data extraction
//
//     // Both operations completed successfully, perform additional operations
//     console.log('Video Keyword:', videoKeywordJson);
//
//     // PDF button functionality
//     const pdfPath = '!/resources/input.pdf';
//     const pdfSubject = '/DataStructure';
//
//     // Fetch request for PDF
//     const response = await fetch('http://localhost:5500' + pdfSubject + pdfPath);
//
//     // If the response is successful
//     if (response.ok) {
//       const responseJson = await response.json(); // JSON data extraction
//       console.log(responseJson);
//     } else {
//       throw new Error('An error occurred: ' + response.statusText);
//     }
//
//   } catch (error) {
//     // error handling
//     console.error('An error occurred:', error);
//     document.getElementById('output').textContent = 'An error occurred during chat execution.';
//   }
// });

async function executeVideoAndGptTasks() {
  try {
    const videoPath = '!/video/input.mp4';
    const videoSubject = '/datastructure';

    // First task: get video information
    const videoResponse = await fetch('http://localhost:5500' + videoSubject + videoPath);
    if (!videoResponse.ok) {
      throw new Error('An error occurred: ' + videoResponse.statusText);
    }
    const videoJson = await videoResponse.json(); // JSON data extraction

    // Second task: Get video keywords
    const keywordResponse = await fetch('http://localhost:5500/getVideoKeyword');
    if (!keywordResponse.ok) {
      throw new Error('An error occurred: ' + keywordResponse.statusText);
    }
    const videoKeywordJson = await keywordResponse.json(); // JSON data extraction

    // Both operations completed successfully, perform additional operations
    console.log('Video Keyword:', videoKeywordJson);

    // PDF button functionality
    const pdfPath = '!/resources/input.pdf';
    const pdfSubject = '/DataStructure';

    // Fetch request for PDF
    const response = await fetch('http://localhost:5500' + pdfSubject + pdfPath);

    // If the response is successful
    if (response.ok) {
      const responseJson = await response.json(); // JSON data extraction
      console.log(responseJson);

      // Now, execute GPT tasks
      try {
        const keywords = 'DataStructure$traverse$order$node$tree$left_node$head$structure$list$node$link';

        // First fetch request
        const response1 = await fetch('http://localhost:5500/' + keywords);

        if (!response1.ok) {
          throw new Error('An error occurred in the first request: ' + response1.statusText);
        }

        const gptJson1 = await response1.json(); // JSON data extraction
        console.log('First Response:', gptJson1);
        let send = JSON.stringify(gptJson1);  //얘
        sendStringToJava(send);

      } catch (error) {
        console.error('An error occurred:', error);
        document.getElementById('output').textContent = 'An error occurred during chat execution.';
      }

    } else {
      throw new Error('An error occurred: ' + response.statusText);
    }

  } catch (error) {
    // error handling
    console.error('An error occurred:', error);
    document.getElementById('output').textContent = 'An error occurred during chat execution.';
  }
}

function sendStringToJava(stringValue) {
  $.ajax({
    type: "POST", // or "GET" depending on your server endpoint
    url: "/api/v2/quiz",
    data: { classesId : 3, classContentsId : 1,
            value: stringValue }, // Send the value as a parameter
    success: function(response) {
      // Handle the response from the Java server if needed
    },
    error: function(error) {
      // Handle any errors if the request fails
    }
  });
}


document.getElementById('videoButton').addEventListener('click', executeVideoAndGptTasks);







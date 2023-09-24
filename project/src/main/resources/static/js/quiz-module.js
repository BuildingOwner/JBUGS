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
  const classesQuiz = document.querySelector("#classesQuiz");
  const weekQuiz = document.querySelector("#weekQuiz");



  $.ajax({
    type: "POST", // or "GET" depending on your server endpoint
    url: "/api/v2/quiz",
    data: { classesId : classesQuiz.options[classesQuiz.selectedIndex].value, classContentsId : weekQuiz.options[weekQuiz.selectedIndex].value,
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






